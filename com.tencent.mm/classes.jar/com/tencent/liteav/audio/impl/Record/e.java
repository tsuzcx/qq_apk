package com.tencent.liteav.audio.impl.Record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Vector;

public class e
  extends Thread
{
  private MediaCodec.BufferInfo a;
  private MediaCodecInfo b;
  private MediaFormat c;
  private MediaCodec d;
  private Vector<byte[]> e;
  private WeakReference<d> f;
  private volatile boolean g;
  private volatile boolean h;
  private final Object i;
  private long j;
  private int k;
  private int l;
  private int m;
  private byte[] n;
  
  static
  {
    AppMethodBeat.i(66681);
    b.f();
    AppMethodBeat.o(66681);
  }
  
  @TargetApi(16)
  public e()
  {
    super("TXAudioRecordThread");
    AppMethodBeat.i(66669);
    this.g = false;
    this.h = false;
    this.i = new Object();
    this.j = 0L;
    this.k = 48000;
    this.l = 1;
    this.m = 16;
    AppMethodBeat.o(66669);
  }
  
  private static final MediaCodecInfo a(String paramString)
  {
    AppMethodBeat.i(66679);
    TXCLog.v("AudioCenter:TXCAudioHWEncoder", "selectAudioCodec:");
    int i3 = MediaCodecList.getCodecCount();
    int i1 = 0;
    MediaCodecInfo localMediaCodecInfo;
    int i2;
    if (i1 < i3)
    {
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i1);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        i2 = 0;
        label46:
        if (i2 < arrayOfString.length)
        {
          TXCLog.i("AudioCenter:TXCAudioHWEncoder", "supportedType:" + localMediaCodecInfo.getName() + ",MIME=" + arrayOfString[i2]);
          if (!arrayOfString[i2].equalsIgnoreCase(paramString)) {}
        }
      }
    }
    for (paramString = localMediaCodecInfo;; paramString = null)
    {
      AppMethodBeat.o(66679);
      return paramString;
      i2 += 1;
      break label46;
      i1 += 1;
      break;
    }
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    AppMethodBeat.i(66677);
    if (this.h)
    {
      AppMethodBeat.o(66677);
      return;
    }
    Object localObject = this.d.getInputBuffers();
    int i1 = this.d.dequeueInputBuffer(10000L);
    if (i1 >= 0)
    {
      localObject = localObject[i1];
      ((ByteBuffer)localObject).clear();
      if (paramByteBuffer != null) {
        ((ByteBuffer)localObject).put(paramByteBuffer);
      }
      if (paramInt <= 0)
      {
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "send BUFFER_FLAG_END_OF_STREAM");
        this.d.queueInputBuffer(i1, 0, 0, paramLong, 4);
      }
    }
    else
    {
      paramByteBuffer = this.d.getOutputBuffers();
      label100:
      paramInt = this.d.dequeueOutputBuffer(this.a, 10000L);
      localObject = paramByteBuffer;
      if (paramInt != -1)
      {
        if (paramInt != -3) {
          break label167;
        }
        localObject = this.d.getOutputBuffers();
      }
    }
    for (;;)
    {
      paramByteBuffer = (ByteBuffer)localObject;
      if (paramInt >= 0) {
        break label100;
      }
      AppMethodBeat.o(66677);
      return;
      this.d.queueInputBuffer(i1, 0, paramInt, paramLong, 0);
      break;
      label167:
      if (paramInt == -2)
      {
        this.d.getOutputFormat();
        localObject = paramByteBuffer;
      }
      else
      {
        localObject = paramByteBuffer;
        if (paramInt >= 0)
        {
          localObject = paramByteBuffer[paramInt];
          if ((this.a.flags & 0x2) != 0)
          {
            TXCLog.d("AudioCenter:TXCAudioHWEncoder", "drain:BUFFER_FLAG_CODEC_CONFIG");
            this.a.size = 0;
          }
          if (this.a.size != 0)
          {
            this.a.presentationTimeUs = f();
            this.n = new byte[((ByteBuffer)localObject).limit()];
            ((ByteBuffer)localObject).get(this.n);
            b(this.n, this.a.presentationTimeUs);
            this.j = this.a.presentationTimeUs;
          }
          this.d.releaseOutputBuffer(paramInt, false);
          localObject = paramByteBuffer;
        }
      }
    }
  }
  
  private void b()
  {
    int i1 = 32000;
    AppMethodBeat.i(66673);
    this.b = a("audio/mp4a-latm");
    if (this.b == null)
    {
      TXCLog.e("AudioCenter:TXCAudioHWEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
      AppMethodBeat.o(66673);
      return;
    }
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "selected codec: " + this.b.getName());
    if (this.k >= 32000) {
      i1 = 64000;
    }
    this.c = MediaFormat.createAudioFormat("audio/mp4a-latm", this.k, this.l);
    this.c.setInteger("bitrate", i1);
    this.c.setInteger("channel-count", this.l);
    this.c.setInteger("sample-rate", this.k);
    this.c.setInteger("aac-profile", 2);
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "format: " + this.c);
    try
    {
      d();
      label169:
      start();
      AppMethodBeat.o(66673);
      return;
    }
    catch (Exception localException)
    {
      break label169;
    }
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66680);
    if (this.f != null)
    {
      d locald = (d)this.f.get();
      if (locald != null) {
        locald.b(paramArrayOfByte, paramLong, this.k, this.l, this.m);
      }
    }
    AppMethodBeat.o(66680);
  }
  
  private void c()
  {
    this.h = true;
  }
  
  @TargetApi(16)
  private void d()
  {
    AppMethodBeat.i(66674);
    if (this.d != null)
    {
      AppMethodBeat.o(66674);
      return;
    }
    this.d = MediaCodec.createEncoderByType("audio/mp4a-latm");
    this.d.configure(this.c, null, null, 1);
    this.d.start();
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
    this.g = true;
    AppMethodBeat.o(66674);
  }
  
  private void e()
  {
    AppMethodBeat.i(66675);
    if (this.d != null)
    {
      this.d.stop();
      this.d.release();
      this.d = null;
    }
    this.g = false;
    AppMethodBeat.o(66675);
  }
  
  private long f()
  {
    AppMethodBeat.i(66678);
    long l2 = TXCTimeUtil.getTimeTick();
    long l1 = l2;
    if (l2 < this.j) {
      l1 = l2 + (this.j - l2);
    }
    AppMethodBeat.o(66678);
    return l1;
  }
  
  public void a()
  {
    AppMethodBeat.i(66672);
    c();
    AppMethodBeat.o(66672);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, WeakReference<d> paramWeakReference)
  {
    AppMethodBeat.i(66670);
    this.f = paramWeakReference;
    this.a = new MediaCodec.BufferInfo();
    this.e = new Vector();
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
    b();
    AppMethodBeat.o(66670);
  }
  
  public void a(byte[] arg1, long paramLong)
  {
    AppMethodBeat.i(66671);
    if ((this.e != null) && (??? != null)) {
      synchronized (this.e)
      {
        if (this.e == null)
        {
          AppMethodBeat.o(66671);
          return;
        }
        this.e.add(???);
      }
    }
    synchronized (this.i)
    {
      this.i.notify();
      AppMethodBeat.o(66671);
      return;
      ??? = finally;
      AppMethodBeat.o(66671);
      throw ???;
    }
  }
  
  public void run()
  {
    AppMethodBeat.i(66676);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(1024);
    for (;;)
    {
      if (!this.h) {
        if (this.g) {
          synchronized (this.e)
          {
            boolean bool = this.e.isEmpty();
            if (bool) {
              try
              {
                Thread.sleep(10L);
              }
              catch (InterruptedException localInterruptedException1) {}
            }
          }
        }
      }
    }
    label213:
    label245:
    for (;;)
    {
      synchronized (this.e)
      {
        for (;;)
        {
          byte[] arrayOfByte = (byte[])this.e.remove(0);
          if (arrayOfByte == null) {
            break label245;
          }
          ??? = localObject1;
          try
          {
            localObject1.clear();
            Object localObject7 = localObject1;
            ??? = localObject1;
            if (arrayOfByte.length > localObject1.capacity())
            {
              ??? = localObject1;
              localObject7 = ByteBuffer.allocateDirect(arrayOfByte.length);
            }
            ??? = localObject7;
            ((ByteBuffer)localObject7).clear();
            ??? = localObject7;
            ((ByteBuffer)localObject7).put(arrayOfByte);
            ??? = localObject7;
            ((ByteBuffer)localObject7).flip();
            ??? = localObject7;
            a((ByteBuffer)localObject7, arrayOfByte.length, f());
            Object localObject2 = localObject7;
          }
          catch (Exception localException)
          {
            Object localObject3 = ???;
          }
        }
      }
      try
      {
        synchronized (this.i)
        {
          this.i.wait();
        }
        e();
        AppMethodBeat.o(66676);
        return;
      }
      catch (InterruptedException localInterruptedException2)
      {
        break label213;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.e
 * JD-Core Version:    0.7.0.1
 */