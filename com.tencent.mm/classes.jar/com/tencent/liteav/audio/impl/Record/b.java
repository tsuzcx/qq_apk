package com.tencent.liteav.audio.impl.Record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.audio.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Vector;

public class b
  extends Thread
{
  private MediaCodec.BufferInfo a;
  private MediaCodecInfo b;
  private MediaFormat c;
  private MediaCodec d;
  private Vector<byte[]> e;
  private WeakReference<g> f;
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
    AppMethodBeat.i(246498);
    h.f();
    AppMethodBeat.o(246498);
  }
  
  @TargetApi(16)
  public b()
  {
    super("TXAudioRecordThread");
    AppMethodBeat.i(246484);
    this.g = false;
    this.h = false;
    this.i = new Object();
    this.j = 0L;
    this.k = 48000;
    this.l = 1;
    this.m = 16;
    AppMethodBeat.o(246484);
  }
  
  private static final MediaCodecInfo a(String paramString)
  {
    AppMethodBeat.i(246496);
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
      AppMethodBeat.o(246496);
      return paramString;
      i2 += 1;
      break label46;
      i1 += 1;
      break;
    }
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    AppMethodBeat.i(246494);
    if (this.h)
    {
      AppMethodBeat.o(246494);
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
      AppMethodBeat.o(246494);
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
    AppMethodBeat.i(246490);
    this.b = a("audio/mp4a-latm");
    if (this.b == null)
    {
      TXCLog.e("AudioCenter:TXCAudioHWEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
      AppMethodBeat.o(246490);
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
      start();
      AppMethodBeat.o(246490);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TXCLog.e("AudioCenter:TXCAudioHWEncoder", "start media codec failed.", localException);
      }
    }
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(246497);
    if (this.f != null)
    {
      g localg = (g)this.f.get();
      if (localg != null) {
        localg.onRecordEncData(paramArrayOfByte, paramLong, this.k, this.l, this.m);
      }
    }
    AppMethodBeat.o(246497);
  }
  
  private void c()
  {
    this.h = true;
  }
  
  @TargetApi(16)
  private void d()
  {
    AppMethodBeat.i(246491);
    if (this.d != null)
    {
      AppMethodBeat.o(246491);
      return;
    }
    this.d = MediaCodec.createEncoderByType("audio/mp4a-latm");
    this.d.configure(this.c, null, null, 1);
    this.d.start();
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
    this.g = true;
    AppMethodBeat.o(246491);
  }
  
  private void e()
  {
    AppMethodBeat.i(246492);
    if (this.d != null)
    {
      this.d.stop();
      this.d.release();
      this.d = null;
    }
    this.g = false;
    AppMethodBeat.o(246492);
  }
  
  private long f()
  {
    AppMethodBeat.i(246495);
    long l2 = TXCTimeUtil.getTimeTick();
    long l1 = l2;
    if (l2 < this.j) {
      l1 = l2 + (this.j - l2);
    }
    AppMethodBeat.o(246495);
    return l1;
  }
  
  public void a()
  {
    AppMethodBeat.i(246487);
    c();
    AppMethodBeat.o(246487);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, WeakReference<g> paramWeakReference)
  {
    AppMethodBeat.i(246485);
    this.f = paramWeakReference;
    this.a = new MediaCodec.BufferInfo();
    this.e = new Vector();
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
    b();
    AppMethodBeat.o(246485);
  }
  
  public void a(byte[] arg1, long paramLong)
  {
    AppMethodBeat.i(246486);
    if ((this.e != null) && (??? != null)) {
      synchronized (this.e)
      {
        if (this.e == null)
        {
          AppMethodBeat.o(246486);
          return;
        }
        this.e.add(???);
      }
    }
    synchronized (this.i)
    {
      this.i.notify();
      AppMethodBeat.o(246486);
      return;
      ??? = finally;
      AppMethodBeat.o(246486);
      throw ???;
    }
  }
  
  public void run()
  {
    AppMethodBeat.i(246493);
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
    label256:
    for (;;)
    {
      synchronized (this.e)
      {
        for (;;)
        {
          byte[] arrayOfByte = (byte[])this.e.remove(0);
          if (arrayOfByte == null) {
            break label256;
          }
          ??? = localObject1;
          try
          {
            localObject1.clear();
            Object localObject6 = localObject1;
            ??? = localObject1;
            if (arrayOfByte.length > localObject1.capacity())
            {
              ??? = localObject1;
              localObject6 = ByteBuffer.allocateDirect(arrayOfByte.length);
            }
            ??? = localObject6;
            ((ByteBuffer)localObject6).clear();
            ??? = localObject6;
            ((ByteBuffer)localObject6).put(arrayOfByte);
            ??? = localObject6;
            ((ByteBuffer)localObject6).flip();
            ??? = localObject6;
            a((ByteBuffer)localObject6, arrayOfByte.length, f());
            localObject2 = localObject6;
          }
          catch (Exception localException)
          {
            Object localObject2 = ???;
            TXCLog.e("AudioCenter:TXCAudioHWEncoder", "encode frame failed.", localException);
          }
        }
      }
      try
      {
        label224:
        synchronized (this.i)
        {
          this.i.wait();
        }
        e();
        AppMethodBeat.o(246493);
        return;
      }
      catch (InterruptedException localInterruptedException2)
      {
        break label224;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.b
 * JD-Core Version:    0.7.0.1
 */