package com.tencent.liteav.audio.impl.Record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.a;
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
  private WeakReference<com.tencent.liteav.audio.e> f;
  private volatile boolean g = false;
  private volatile boolean h = false;
  private final Object i = new Object();
  private long j = 0L;
  private int k = c.a;
  private int l = c.b;
  private int m = c.c;
  private byte[] n;
  
  static {}
  
  @TargetApi(16)
  public e()
  {
    super("TXAudioRecordThread");
  }
  
  private static final MediaCodecInfo a(String paramString)
  {
    TXCLog.v("AudioCenter:TXCAudioHWEncoder", "selectAudioCodec:");
    int i3 = MediaCodecList.getCodecCount();
    int i1 = 0;
    while (i1 < i3)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i1);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int i2 = 0;
        while (i2 < arrayOfString.length)
        {
          TXCLog.i("AudioCenter:TXCAudioHWEncoder", "supportedType:" + localMediaCodecInfo.getName() + ",MIME=" + arrayOfString[i2]);
          if (arrayOfString[i2].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    if (this.h) {
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
      label90:
      paramInt = this.d.dequeueOutputBuffer(this.a, 10000L);
      localObject = paramByteBuffer;
      if (paramInt != -1)
      {
        if (paramInt != -3) {
          break label152;
        }
        localObject = this.d.getOutputBuffers();
      }
    }
    for (;;)
    {
      paramByteBuffer = (ByteBuffer)localObject;
      if (paramInt >= 0) {
        break label90;
      }
      return;
      this.d.queueInputBuffer(i1, 0, paramInt, paramLong, 0);
      break;
      label152:
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
    this.b = a("audio/mp4a-latm");
    if (this.b == null)
    {
      TXCLog.e("AudioCenter:TXCAudioHWEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
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
      label159:
      start();
      return;
    }
    catch (Exception localException)
    {
      break label159;
    }
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.f != null)
    {
      com.tencent.liteav.audio.e locale = (com.tencent.liteav.audio.e)this.f.get();
      if (locale != null) {
        locale.b(paramArrayOfByte, paramLong, this.k, this.l, this.m);
      }
    }
  }
  
  private void c()
  {
    this.h = true;
  }
  
  @TargetApi(16)
  private void d()
  {
    if (this.d != null) {
      return;
    }
    this.d = MediaCodec.createEncoderByType("audio/mp4a-latm");
    this.d.configure(this.c, null, null, 1);
    this.d.start();
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
    this.g = true;
  }
  
  private void e()
  {
    if (this.d != null)
    {
      this.d.stop();
      this.d.release();
      this.d = null;
    }
    this.g = false;
  }
  
  private long f()
  {
    long l2 = TXCTimeUtil.getTimeTick();
    long l1 = l2;
    if (l2 < this.j) {
      l1 = l2 + (this.j - l2);
    }
    return l1;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, WeakReference<com.tencent.liteav.audio.e> paramWeakReference)
  {
    this.f = paramWeakReference;
    this.a = new MediaCodec.BufferInfo();
    this.e = new Vector();
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
    b();
  }
  
  public void a(byte[] arg1, long paramLong)
  {
    if ((this.e != null) && (??? != null)) {}
    synchronized (this.e)
    {
      if (this.e == null) {
        return;
      }
      this.e.add(???);
      synchronized (this.i)
      {
        this.i.notify();
        return;
      }
    }
  }
  
  public void run()
  {
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
    label195:
    label215:
    for (;;)
    {
      synchronized (this.e)
      {
        for (;;)
        {
          byte[] arrayOfByte = (byte[])this.e.remove(0);
          if (arrayOfByte == null) {
            break label215;
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
        return;
      }
      catch (InterruptedException localInterruptedException2)
      {
        break label195;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.e
 * JD-Core Version:    0.7.0.1
 */