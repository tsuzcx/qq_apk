package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class b
  implements a
{
  public static float a = 0.5F;
  public static float b = 0.8F;
  public static float c = 1.25F;
  public static float d = 2.0F;
  private int e = 2;
  private MediaMuxer f;
  private String g = null;
  private MediaFormat h = null;
  private MediaFormat i = null;
  private int j = 0;
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  private ConcurrentLinkedQueue<b.a> n = new ConcurrentLinkedQueue();
  private ConcurrentLinkedQueue<b.a> o = new ConcurrentLinkedQueue();
  private long p = -1L;
  private long q = -1L;
  private long r = -1L;
  
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
    paramByteBuffer = new b.a(localByteBuffer, paramByteBuffer);
    if (paramBoolean)
    {
      if (this.n.size() < 200)
      {
        this.n.add(paramByteBuffer);
        return;
      }
      TXCLog.e("TXCMP4HWMuxer", "drop video frame. video cache size is larger than 200");
      return;
    }
    if (this.o.size() < 600)
    {
      this.o.add(paramByteBuffer);
      return;
    }
    TXCLog.e("TXCMP4HWMuxer", "drop audio frame. audio cache size is larger than 600");
  }
  
  private void c(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l2 = 0L;
    long l1 = paramBufferInfo.presentationTimeUs - this.p;
    if (l1 < 0L)
    {
      TXCLog.e("TXCMP4HWMuxer", "pts error! first frame offset timeus = " + this.p + ", current timeus = " + paramBufferInfo.presentationTimeUs);
      if (this.q <= 0L) {}
    }
    for (l2 = this.q;; l2 = l1)
    {
      if (l2 < this.q)
      {
        TXCLog.w("TXCMP4HWMuxer", "video is not in chronological order. current frame's pts(" + l2 + ") smaller than pre frame's pts(" + this.q + ")");
        l1 = l2;
        if (this.e != 2)
        {
          if (this.e != 3) {
            break label212;
          }
          l1 = ((float)l2 * b);
        }
      }
      for (;;)
      {
        paramBufferInfo.presentationTimeUs = l1;
        try
        {
          paramByteBuffer.position(paramBufferInfo.offset);
          paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
          this.f.writeSampleData(this.k, paramByteBuffer, paramBufferInfo);
          if ((paramBufferInfo.flags & 0x1) != 0) {
            this.m = true;
          }
          return;
        }
        catch (IllegalStateException paramByteBuffer)
        {
          TXCLog.e("TXCMP4HWMuxer", "write frame IllegalStateException: " + paramByteBuffer);
          return;
        }
        catch (IllegalArgumentException paramByteBuffer)
        {
          TXCLog.e("TXCMP4HWMuxer", "write frame IllegalArgumentException: " + paramByteBuffer);
          return;
        }
        this.q = l2;
        break;
        label212:
        if (this.e == 4)
        {
          l1 = ((float)l2 * a);
        }
        else if (this.e == 1)
        {
          l1 = ((float)l2 * c);
        }
        else
        {
          l1 = l2;
          if (this.e == 0) {
            l1 = ((float)l2 * d);
          }
        }
      }
    }
  }
  
  private long d()
  {
    if (this.n.size() > 0) {}
    for (long l1 = ((b.a)this.n.peek()).b().presentationTimeUs;; l1 = 0L)
    {
      long l2 = l1;
      if (this.o.size() > 0)
      {
        b.a locala = (b.a)this.o.peek();
        l2 = l1;
        if (locala != null)
        {
          l2 = l1;
          if (locala.b() != null)
          {
            long l3 = ((b.a)this.o.peek()).b().presentationTimeUs;
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
  
  private void d(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l2 = paramBufferInfo.presentationTimeUs - this.p;
    if ((this.p < 0L) || (l2 < 0L))
    {
      TXCLog.w("TXCMP4HWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + paramBufferInfo.presentationTimeUs);
      return;
    }
    if (l2 < this.r)
    {
      TXCLog.e("TXCMP4HWMuxer", "audio is not in chronological order. current audio's pts pts(" + l2 + ") must larger than pre audio's pts(" + this.r + ")");
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
        this.f.writeSampleData(this.j, paramByteBuffer, paramBufferInfo);
        return;
      }
      catch (IllegalStateException paramByteBuffer)
      {
        TXCLog.e("TXCMP4HWMuxer", "write sample IllegalStateException: " + paramByteBuffer);
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
        TXCLog.e("TXCMP4HWMuxer", "write sample IllegalArgumentException: " + paramByteBuffer);
      }
    }
  }
  
  private void e()
  {
    b.a locala;
    while (this.n.size() > 0)
    {
      locala = (b.a)this.n.poll();
      c(locala.a(), locala.b());
    }
    while (this.o.size() > 0)
    {
      locala = (b.a)this.o.poll();
      d(locala.a(), locala.b());
    }
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 59	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   8: ifnull +13 -> 21
    //   11: aload_0
    //   12: getfield 59	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   15: invokevirtual 237	java/lang/String:isEmpty	()Z
    //   18: ifeq +16 -> 34
    //   21: ldc 142
    //   23: ldc 239
    //   25: invokestatic 149	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: iconst_m1
    //   29: istore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_1
    //   33: ireturn
    //   34: aload_0
    //   35: invokevirtual 241	com/tencent/liteav/muxer/b:c	()Z
    //   38: ifne +16 -> 54
    //   41: ldc 142
    //   43: ldc 243
    //   45: invokestatic 149	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: bipush 254
    //   50: istore_1
    //   51: goto -21 -> 30
    //   54: aload_0
    //   55: getfield 186	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   58: ifnull +18 -> 76
    //   61: ldc 142
    //   63: ldc 245
    //   65: invokestatic 184	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: goto -38 -> 30
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: ldc 142
    //   78: ldc 247
    //   80: invokestatic 249	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: new 188	android/media/MediaMuxer
    //   87: dup
    //   88: aload_0
    //   89: getfield 59	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   92: iconst_0
    //   93: invokespecial 252	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   96: putfield 186	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   99: aload_0
    //   100: getfield 61	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +18 -> 123
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 186	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   113: aload_0
    //   114: getfield 61	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   117: invokevirtual 256	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   120: putfield 67	com/tencent/liteav/muxer/b:k	I
    //   123: aload_0
    //   124: getfield 63	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   127: astore_2
    //   128: aload_2
    //   129: ifnull +18 -> 147
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 186	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   137: aload_0
    //   138: getfield 63	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   141: invokevirtual 256	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   144: putfield 65	com/tencent/liteav/muxer/b:j	I
    //   147: aload_0
    //   148: getfield 186	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   151: invokevirtual 258	android/media/MediaMuxer:start	()V
    //   154: aload_0
    //   155: ldc2_w 79
    //   158: putfield 82	com/tencent/liteav/muxer/b:p	J
    //   161: aload_0
    //   162: iconst_1
    //   163: putfield 69	com/tencent/liteav/muxer/b:l	Z
    //   166: aload_0
    //   167: iconst_0
    //   168: putfield 71	com/tencent/liteav/muxer/b:m	Z
    //   171: aload_0
    //   172: ldc2_w 79
    //   175: putfield 84	com/tencent/liteav/muxer/b:q	J
    //   178: aload_0
    //   179: ldc2_w 79
    //   182: putfield 86	com/tencent/liteav/muxer/b:r	J
    //   185: goto -155 -> 30
    //   188: astore_2
    //   189: ldc 142
    //   191: new 157	java/lang/StringBuilder
    //   194: dup
    //   195: ldc_w 260
    //   198: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   201: aload_2
    //   202: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 149	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: bipush 252
    //   213: istore_1
    //   214: goto -184 -> 30
    //   217: astore_2
    //   218: ldc 142
    //   220: new 157	java/lang/StringBuilder
    //   223: dup
    //   224: ldc_w 262
    //   227: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: aload_2
    //   231: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 149	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: bipush 251
    //   242: istore_1
    //   243: goto -213 -> 30
    //   246: astore_2
    //   247: ldc 142
    //   249: new 157	java/lang/StringBuilder
    //   252: dup
    //   253: ldc_w 264
    //   256: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   259: aload_2
    //   260: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 149	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: bipush 250
    //   271: istore_1
    //   272: goto -242 -> 30
    //   275: astore_2
    //   276: ldc 142
    //   278: new 157	java/lang/StringBuilder
    //   281: dup
    //   282: ldc_w 266
    //   285: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   288: aload_2
    //   289: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 149	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: bipush 249
    //   300: istore_1
    //   301: goto -271 -> 30
    //   304: astore_2
    //   305: ldc 142
    //   307: new 157	java/lang/StringBuilder
    //   310: dup
    //   311: ldc_w 268
    //   314: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: aload_2
    //   318: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 149	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: bipush 248
    //   329: istore_1
    //   330: goto -300 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	b
    //   1	329	1	i1	int
    //   71	4	2	localObject	Object
    //   103	26	2	localMediaFormat	MediaFormat
    //   188	14	2	localIOException	java.io.IOException
    //   217	14	2	localIllegalArgumentException1	IllegalArgumentException
    //   246	14	2	localIllegalStateException1	IllegalStateException
    //   275	14	2	localIllegalArgumentException2	IllegalArgumentException
    //   304	14	2	localIllegalStateException2	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   4	21	71	finally
    //   21	28	71	finally
    //   34	48	71	finally
    //   54	68	71	finally
    //   76	83	71	finally
    //   83	99	71	finally
    //   99	104	71	finally
    //   108	123	71	finally
    //   123	128	71	finally
    //   132	147	71	finally
    //   147	185	71	finally
    //   189	211	71	finally
    //   218	240	71	finally
    //   247	269	71	finally
    //   276	298	71	finally
    //   305	327	71	finally
    //   83	99	188	java/io/IOException
    //   108	123	217	java/lang/IllegalArgumentException
    //   108	123	246	java/lang/IllegalStateException
    //   132	147	275	java/lang/IllegalArgumentException
    //   132	147	304	java/lang/IllegalStateException
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    try
    {
      TXCLog.d("TXCMP4HWMuxer", "addVideoTrack:" + paramMediaFormat);
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
  
  public void a(String paramString)
  {
    try
    {
      this.g = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
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
          TXCLog.w("TXCMP4HWMuxer", "cache frame before muexer ready. ptsUs: " + paramBufferInfo.presentationTimeUs);
          return;
        }
        if (this.p < 0L)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          this.p = d();
          TXCLog.d("TXCMP4HWMuxer", "first frame offset = " + this.p);
          e();
        }
        else
        {
          c(paramByteBuffer, paramBufferInfo);
        }
      }
      finally {}
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
      if (this.f != null) {
        TXCLog.d("TXCMP4HWMuxer", "stop. start flag = " + this.l + ", video key frame set = " + this.m);
      }
      try
      {
        if ((this.l) && (this.m)) {
          this.f.stop();
        }
        this.f.release();
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
          TXCLog.e("TXCMP4HWMuxer", "muxer stop/release exception: " + localException);
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
      TXCLog.d("TXCMP4HWMuxer", "addAudioTrack:" + paramMediaFormat);
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
  
  /* Error */
  public void b(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 186	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 82	com/tencent/liteav/muxer/b:p	J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifge +38 -> 53
    //   18: ldc 142
    //   20: new 157	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 311
    //   27: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_2
    //   31: getfield 124	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   34: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 184	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: iconst_0
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 276	com/tencent/liteav/muxer/b:a	(ZLjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: aload_1
    //   55: aload_2
    //   56: invokespecial 229	com/tencent/liteav/muxer/b:d	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   59: goto -9 -> 50
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	b
    //   0	67	1	paramByteBuffer	ByteBuffer
    //   0	67	2	paramBufferInfo	MediaCodec.BufferInfo
    // Exception table:
    //   from	to	target	type
    //   2	18	62	finally
    //   18	50	62	finally
    //   53	59	62	finally
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
    //   3: getfield 61	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
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
    //   0	27	0	this	b
    //   12	7	1	bool	boolean
    //   6	2	2	localMediaFormat	MediaFormat
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.muxer.b
 * JD-Core Version:    0.7.0.1
 */