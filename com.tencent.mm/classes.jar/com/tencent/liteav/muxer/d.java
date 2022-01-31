package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI.AVOptions;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class d
  implements a
{
  public static float a = 0.5F;
  public static float b = 0.8F;
  public static float c = 1.25F;
  public static float d = 2.0F;
  private int e = 2;
  private TXSWMuxerJNI f;
  private String g = null;
  private MediaFormat h = null;
  private MediaFormat i = null;
  private int j = 0;
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  private ConcurrentLinkedQueue<d.a> n = new ConcurrentLinkedQueue();
  private ConcurrentLinkedQueue<d.a> o = new ConcurrentLinkedQueue();
  private long p = -1L;
  private long q = -1L;
  private long r = -1L;
  
  private void a(long paramLong)
  {
    while (this.o.size() > 0) {
      if (((d.a)this.o.peek()).b() == null)
      {
        TXCLog.e("TXCMP4SWMuxer", "flushAudioCache, bufferInfo is null");
        this.o.remove();
      }
      else
      {
        if (((d.a)this.o.peek()).b().presentationTimeUs >= paramLong) {
          break;
        }
        d.a locala = (d.a)this.o.poll();
        d(locala.a(), locala.b());
      }
    }
  }
  
  private void a(boolean paramBoolean, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    if ((paramByteBuffer == null) || (paramBufferInfo == null)) {
      return;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
    paramByteBuffer.rewind();
    if (paramBufferInfo.size > 0)
    {
      paramByteBuffer.position(paramBufferInfo.offset);
      paramByteBuffer.limit(paramBufferInfo.size);
    }
    localByteBuffer.rewind();
    localByteBuffer.put(paramByteBuffer);
    paramByteBuffer = new MediaCodec.BufferInfo();
    paramByteBuffer.set(paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramBufferInfo.flags);
    paramByteBuffer = new d.a(localByteBuffer, paramByteBuffer);
    if (paramBoolean)
    {
      if (this.n.size() < 200)
      {
        this.n.add(paramByteBuffer);
        return;
      }
      TXCLog.e("TXCMP4SWMuxer", "drop video frame. video cache size is larger than 200");
      return;
    }
    this.o.add(paramByteBuffer);
  }
  
  private void c(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l2 = 0L;
    int i1 = 1;
    long l1 = paramBufferInfo.presentationTimeUs - this.p;
    if (l1 < 0L)
    {
      TXCLog.e("TXCMP4SWMuxer", "pts error! first frame offset timeus = " + this.p + ", current timeus = " + paramBufferInfo.presentationTimeUs);
      if (this.q > 0L) {
        l2 = this.q;
      }
    }
    for (;;)
    {
      if (l2 < this.q) {
        TXCLog.w("TXCMP4SWMuxer", "video is not in chronological order. current frame's pts(" + l2 + ") smaller than pre frame's pts(" + this.q + ")");
      }
      for (;;)
      {
        l1 = l2;
        if (this.e != 2)
        {
          if (this.e == 3) {
            l1 = ((float)l2 * b);
          }
        }
        else {
          label153:
          paramBufferInfo.presentationTimeUs = l1;
        }
        try
        {
          paramByteBuffer.position(paramBufferInfo.offset);
          paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
          TXSWMuxerJNI localTXSWMuxerJNI = this.f;
          int i2 = paramBufferInfo.offset;
          int i3 = paramBufferInfo.size;
          if (paramBufferInfo.flags == 1) {}
          for (;;)
          {
            localTXSWMuxerJNI.a(paramByteBuffer, 1, i2, i3, i1, paramBufferInfo.presentationTimeUs);
            if ((paramBufferInfo.flags & 0x1) != 0) {
              this.m = true;
            }
            return;
            this.q = l2;
            break;
            if (this.e == 4)
            {
              l1 = ((float)l2 * a);
              break label153;
            }
            if (this.e == 1)
            {
              l1 = ((float)l2 * c);
              break label153;
            }
            l1 = l2;
            if (this.e != 0) {
              break label153;
            }
            l1 = ((float)l2 * d);
            break label153;
            i1 = 0;
          }
          l2 = l1;
        }
        catch (IllegalStateException paramByteBuffer)
        {
          TXCLog.e("TXCMP4SWMuxer", "write frame IllegalStateException: " + paramByteBuffer);
          return;
        }
        catch (IllegalArgumentException paramByteBuffer)
        {
          TXCLog.e("TXCMP4SWMuxer", "write frame IllegalArgumentException: " + paramByteBuffer);
          return;
        }
      }
    }
  }
  
  private ByteBuffer d()
  {
    ByteBuffer localByteBuffer = this.i.getByteBuffer("csd-0");
    localByteBuffer.position(0);
    return localByteBuffer;
  }
  
  private void d(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l2 = paramBufferInfo.presentationTimeUs - this.p;
    if ((this.p < 0L) || (l2 < 0L))
    {
      TXCLog.w("TXCMP4SWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + paramBufferInfo.presentationTimeUs);
      return;
    }
    if (l2 < this.r)
    {
      TXCLog.e("TXCMP4SWMuxer", "audio is not in chronological order. current audio's pts pts(" + l2 + ") must larger than pre audio's pts(" + this.r + ")");
      l2 = this.r + 1L;
    }
    for (;;)
    {
      long l1 = l2;
      if (this.e != 2)
      {
        if (this.e == 3) {
          l1 = ((float)l2 * b);
        }
      }
      else {
        label149:
        paramBufferInfo.presentationTimeUs = l1;
      }
      try
      {
        paramByteBuffer.position(paramBufferInfo.offset);
        paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
        this.f.a(paramByteBuffer, 0, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.flags, paramBufferInfo.presentationTimeUs);
        return;
      }
      catch (IllegalStateException paramByteBuffer)
      {
        TXCLog.e("TXCMP4SWMuxer", "write sample IllegalStateException: " + paramByteBuffer);
        return;
        this.r = l2;
        continue;
        if (this.e == 4)
        {
          l1 = ((float)l2 * a);
          break label149;
        }
        if (this.e == 1)
        {
          l1 = ((float)l2 * c);
          break label149;
        }
        l1 = l2;
        if (this.e != 0) {
          break label149;
        }
        l1 = ((float)l2 * d);
      }
      catch (IllegalArgumentException paramByteBuffer)
      {
        TXCLog.e("TXCMP4SWMuxer", "write sample IllegalArgumentException: " + paramByteBuffer);
      }
    }
  }
  
  private ByteBuffer e()
  {
    return this.h.getByteBuffer("csd-0");
  }
  
  private ByteBuffer f()
  {
    return this.h.getByteBuffer("csd-1");
  }
  
  private long g()
  {
    if (this.n.size() > 0) {}
    for (long l1 = ((d.a)this.n.peek()).b().presentationTimeUs;; l1 = 0L)
    {
      long l2 = l1;
      if (this.o.size() > 0)
      {
        d.a locala = (d.a)this.o.peek();
        l2 = l1;
        if (locala != null)
        {
          l2 = l1;
          if (locala.b() != null)
          {
            long l3 = ((d.a)this.o.peek()).b().presentationTimeUs;
            l2 = l1;
            if (l1 > l3) {
              l2 = l3;
            }
          }
        }
      }
      return l2;
    }
  }
  
  private void h()
  {
    d.a locala;
    while (this.n.size() > 0)
    {
      locala = (d.a)this.n.poll();
      c(locala.a(), locala.b());
    }
    while (this.o.size() > 0)
    {
      locala = (d.a)this.o.poll();
      d(locala.a(), locala.b());
    }
  }
  
  private void i()
  {
    while (this.n.size() > 0)
    {
      d.a locala = (d.a)this.n.poll();
      a(locala.b().presentationTimeUs);
      c(locala.a(), locala.b());
    }
  }
  
  public int a()
  {
    int i2 = 0;
    try
    {
      if ((this.g == null) || (this.g.isEmpty()))
      {
        TXCLog.e("TXCMP4SWMuxer", "target path not set yet!");
        i1 = -1;
      }
      for (;;)
      {
        return i1;
        if (!c())
        {
          TXCLog.e("TXCMP4SWMuxer", "video track not set yet!");
          i1 = -2;
        }
        else
        {
          if (this.f == null) {
            break;
          }
          TXCLog.w("TXCMP4SWMuxer", "start has been called. stop must be called before start");
          i1 = i2;
        }
      }
      TXCLog.d("TXCMP4SWMuxer", "start");
    }
    finally {}
    this.f = new TXSWMuxerJNI();
    TXSWMuxerJNI.AVOptions localAVOptions = new TXSWMuxerJNI.AVOptions();
    if (this.h != null)
    {
      i1 = this.h.getInteger("width");
      localAVOptions.videoHeight = this.h.getInteger("height");
      localAVOptions.videoWidth = i1;
      if (!this.h.containsKey("i-frame-interval")) {
        break label410;
      }
    }
    label410:
    for (int i1 = this.h.getInteger("i-frame-interval");; i1 = 3)
    {
      localAVOptions.videoGOP = i1;
      if (this.i != null)
      {
        i1 = this.i.getInteger("channel-count");
        int i3 = this.i.getInteger("sample-rate");
        localAVOptions.audioChannels = i1;
        localAVOptions.audioSampleRate = i3;
      }
      ByteBuffer localByteBuffer2 = e();
      ByteBuffer localByteBuffer3 = f();
      ByteBuffer localByteBuffer1 = null;
      if (this.i != null) {
        localByteBuffer1 = d();
      }
      for (;;)
      {
        label251:
        TXCLog.e("TXCMP4SWMuxer", "video format contains error csd!");
        i1 = -3;
        break;
        do
        {
          if ((this.i != null) && (localByteBuffer1 == null))
          {
            TXCLog.e("TXCMP4SWMuxer", "audio format contains error csd!");
            i1 = -3;
            break;
          }
          this.f.a(localByteBuffer2, localByteBuffer2.capacity(), localByteBuffer3, localByteBuffer3.capacity());
          if (this.i != null) {
            this.f.a(localByteBuffer1, localByteBuffer1.capacity());
          }
          this.f.a(localAVOptions);
          this.f.a(this.g);
          this.f.a();
          this.p = -1L;
          this.l = true;
          this.m = false;
          this.q = -1L;
          this.r = -1L;
          i1 = i2;
          break;
          if (localByteBuffer2 == null) {
            break label251;
          }
        } while (localByteBuffer3 != null);
      }
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    try
    {
      TXCLog.d("TXCMP4SWMuxer", "addVideoTrack:" + paramMediaFormat);
      this.h = paramMediaFormat;
      this.n.clear();
      return;
    }
    finally
    {
      paramMediaFormat = finally;
      throw paramMediaFormat;
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield 59	com/tencent/liteav/muxer/d:g	Ljava/lang/String;
    //   7: aload_0
    //   8: getfield 59	com/tencent/liteav/muxer/d:g	Ljava/lang/String;
    //   11: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +32 -> 46
    //   17: new 337	java/io/File
    //   20: dup
    //   21: aload_0
    //   22: getfield 59	com/tencent/liteav/muxer/d:g	Ljava/lang/String;
    //   25: invokespecial 338	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 341	java/io/File:exists	()Z
    //   33: ifeq +8 -> 41
    //   36: aload_1
    //   37: invokevirtual 344	java/io/File:delete	()Z
    //   40: pop
    //   41: aload_1
    //   42: invokevirtual 347	java/io/File:createNewFile	()Z
    //   45: pop
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: goto -4 -> 46
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	d
    //   0	58	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   41	46	49	java/io/IOException
    //   2	41	53	finally
    //   41	46	53	finally
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    for (;;)
    {
      try
      {
        if (this.f == null)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          TXCLog.w("TXCMP4SWMuxer", "cache frame before muexer ready. ptsUs: " + paramBufferInfo.presentationTimeUs);
          return;
        }
        if (this.p < 0L)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          this.p = g();
          TXCLog.d("TXCMP4SWMuxer", "first frame offset = " + this.p);
          i();
          continue;
        }
        a(paramBufferInfo.presentationTimeUs);
      }
      finally {}
      c(paramByteBuffer, paramBufferInfo);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      b(localByteBuffer, paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public int b()
  {
    int i2 = 0;
    int i1 = i2;
    try
    {
      if (this.f != null)
      {
        h();
        TXCLog.d("TXCMP4SWMuxer", "stop. start flag = " + this.l + ", video key frame set = " + this.m);
      }
      try
      {
        if ((this.l) && (this.m)) {
          this.f.b();
        }
        this.f.c();
        this.f = null;
        this.l = false;
        this.f = null;
        this.m = false;
        this.n.clear();
        this.o.clear();
        this.h = null;
        this.i = null;
        this.q = -1L;
        this.r = -1L;
        i1 = i2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TXCLog.e("TXCMP4SWMuxer", "muxer stop/release exception: " + localException);
          this.l = false;
          this.f = null;
          this.m = false;
          this.n.clear();
          this.o.clear();
          this.h = null;
          this.i = null;
          this.q = -1L;
          this.r = -1L;
          i1 = -1;
        }
      }
      finally
      {
        this.l = false;
        this.f = null;
        this.m = false;
        this.n.clear();
        this.o.clear();
        this.h = null;
        this.i = null;
        this.q = -1L;
        this.r = -1L;
      }
      return i1;
    }
    finally {}
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    try
    {
      TXCLog.d("TXCMP4SWMuxer", "addAudioTrack:" + paramMediaFormat);
      this.i = paramMediaFormat;
      this.o.clear();
      return;
    }
    finally
    {
      paramMediaFormat = finally;
      throw paramMediaFormat;
    }
  }
  
  public void b(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      a(false, paramByteBuffer, paramBufferInfo);
      return;
    }
    finally
    {
      paramByteBuffer = finally;
      throw paramByteBuffer;
    }
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      a(localByteBuffer, paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	d
    //   12	7	1	bool	boolean
    //   6	2	2	localMediaFormat	MediaFormat
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.muxer.d
 * JD-Core Version:    0.7.0.1
 */