package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI.AVOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private int e;
  private TXSWMuxerJNI f;
  private String g;
  private MediaFormat h;
  private MediaFormat i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private ConcurrentLinkedQueue<d.a> n;
  private ConcurrentLinkedQueue<d.a> o;
  private long p;
  private long q;
  private long r;
  
  public d()
  {
    AppMethodBeat.i(67121);
    this.e = 2;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = 0;
    this.k = 0;
    this.l = false;
    this.m = false;
    this.n = new ConcurrentLinkedQueue();
    this.o = new ConcurrentLinkedQueue();
    this.p = -1L;
    this.q = -1L;
    this.r = -1L;
    AppMethodBeat.o(67121);
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(67140);
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
    AppMethodBeat.o(67140);
  }
  
  private void a(boolean paramBoolean, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(67136);
    if ((paramByteBuffer == null) || (paramBufferInfo == null))
    {
      AppMethodBeat.o(67136);
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
        AppMethodBeat.o(67136);
        return;
      }
      TXCLog.e("TXCMP4SWMuxer", "drop video frame. video cache size is larger than 200");
      AppMethodBeat.o(67136);
      return;
    }
    this.o.add(paramByteBuffer);
    AppMethodBeat.o(67136);
  }
  
  private void c(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l2 = 0L;
    int i1 = 1;
    AppMethodBeat.i(67134);
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
          label158:
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
            AppMethodBeat.o(67134);
            return;
            this.q = l2;
            break;
            if (this.e == 4)
            {
              l1 = ((float)l2 * a);
              break label158;
            }
            if (this.e == 1)
            {
              l1 = ((float)l2 * c);
              break label158;
            }
            l1 = l2;
            if (this.e != 0) {
              break label158;
            }
            l1 = ((float)l2 * d);
            break label158;
            i1 = 0;
          }
          l2 = l1;
        }
        catch (IllegalStateException paramByteBuffer)
        {
          TXCLog.e("TXCMP4SWMuxer", "write frame IllegalStateException: ".concat(String.valueOf(paramByteBuffer)));
          AppMethodBeat.o(67134);
          return;
        }
        catch (IllegalArgumentException paramByteBuffer)
        {
          TXCLog.e("TXCMP4SWMuxer", "write frame IllegalArgumentException: ".concat(String.valueOf(paramByteBuffer)));
          AppMethodBeat.o(67134);
          return;
        }
      }
    }
  }
  
  private ByteBuffer d()
  {
    AppMethodBeat.i(67124);
    ByteBuffer localByteBuffer = this.i.getByteBuffer("csd-0");
    localByteBuffer.position(0);
    AppMethodBeat.o(67124);
    return localByteBuffer;
  }
  
  private void d(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(67135);
    long l2 = paramBufferInfo.presentationTimeUs - this.p;
    if ((this.p < 0L) || (l2 < 0L))
    {
      TXCLog.w("TXCMP4SWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + paramBufferInfo.presentationTimeUs);
      AppMethodBeat.o(67135);
      return;
    }
    long l1;
    if (l2 < this.r)
    {
      TXCLog.e("TXCMP4SWMuxer", "audio is not in chronological order. current audio's pts pts(" + l2 + ") must larger than pre audio's pts(" + this.r + ")");
      l2 = this.r + 1L;
      l1 = l2;
      if (this.e != 2)
      {
        if (this.e != 3) {
          break label228;
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
        this.f.a(paramByteBuffer, 0, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.flags, paramBufferInfo.presentationTimeUs);
        AppMethodBeat.o(67135);
        return;
      }
      catch (IllegalStateException paramByteBuffer)
      {
        TXCLog.e("TXCMP4SWMuxer", "write sample IllegalStateException: ".concat(String.valueOf(paramByteBuffer)));
        AppMethodBeat.o(67135);
        return;
      }
      catch (IllegalArgumentException paramByteBuffer)
      {
        TXCLog.e("TXCMP4SWMuxer", "write sample IllegalArgumentException: ".concat(String.valueOf(paramByteBuffer)));
        AppMethodBeat.o(67135);
      }
      this.r = l2;
      break;
      label228:
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
  
  private ByteBuffer e()
  {
    AppMethodBeat.i(67125);
    ByteBuffer localByteBuffer = this.h.getByteBuffer("csd-0");
    AppMethodBeat.o(67125);
    return localByteBuffer;
  }
  
  private ByteBuffer f()
  {
    AppMethodBeat.i(67126);
    ByteBuffer localByteBuffer = this.h.getByteBuffer("csd-1");
    AppMethodBeat.o(67126);
    return localByteBuffer;
  }
  
  private long g()
  {
    AppMethodBeat.i(67137);
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
      AppMethodBeat.o(67137);
      return l2;
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(67138);
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
    AppMethodBeat.o(67138);
  }
  
  private void i()
  {
    AppMethodBeat.i(67139);
    while (this.n.size() > 0)
    {
      d.a locala = (d.a)this.n.poll();
      a(locala.b().presentationTimeUs);
      c(locala.a(), locala.b());
    }
    AppMethodBeat.o(67139);
  }
  
  public int a()
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(67127);
        if ((this.g == null) || (this.g.isEmpty()))
        {
          TXCLog.e("TXCMP4SWMuxer", "target path not set yet!");
          i1 = -1;
          AppMethodBeat.o(67127);
          return i1;
        }
        if (!c())
        {
          TXCLog.e("TXCMP4SWMuxer", "video track not set yet!");
          i1 = -2;
          AppMethodBeat.o(67127);
          continue;
        }
        if (this.f == null) {
          break;
        }
      }
      finally {}
      TXCLog.w("TXCMP4SWMuxer", "start has been called. stop must be called before start");
      AppMethodBeat.o(67127);
      i1 = i2;
    }
    TXCLog.d("TXCMP4SWMuxer", "start");
    this.f = new TXSWMuxerJNI();
    TXSWMuxerJNI.AVOptions localAVOptions = new TXSWMuxerJNI.AVOptions();
    if (this.h != null)
    {
      i1 = this.h.getInteger("width");
      localAVOptions.videoHeight = this.h.getInteger("height");
      localAVOptions.videoWidth = i1;
      if (!this.h.containsKey("i-frame-interval")) {
        break label453;
      }
    }
    label276:
    label453:
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
        TXCLog.e("TXCMP4SWMuxer", "video format contains error csd!");
        AppMethodBeat.o(67127);
        i1 = -3;
        break;
        do
        {
          if ((this.i != null) && (localByteBuffer1 == null))
          {
            TXCLog.e("TXCMP4SWMuxer", "audio format contains error csd!");
            AppMethodBeat.o(67127);
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
          AppMethodBeat.o(67127);
          i1 = i2;
          break;
          if (localByteBuffer2 == null) {
            break label276;
          }
        } while (localByteBuffer3 != null);
      }
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    try
    {
      AppMethodBeat.i(67122);
      TXCLog.d("TXCMP4SWMuxer", "addVideoTrack:".concat(String.valueOf(paramMediaFormat)));
      this.h = paramMediaFormat;
      this.n.clear();
      AppMethodBeat.o(67122);
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
    //   2: ldc_w 356
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 65	com/tencent/liteav/muxer/d:g	Ljava/lang/String;
    //   13: aload_0
    //   14: getfield 65	com/tencent/liteav/muxer/d:g	Ljava/lang/String;
    //   17: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +42 -> 62
    //   23: new 363	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: getfield 65	com/tencent/liteav/muxer/d:g	Ljava/lang/String;
    //   31: invokespecial 364	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 367	java/io/File:exists	()Z
    //   39: ifeq +8 -> 47
    //   42: aload_1
    //   43: invokevirtual 370	java/io/File:delete	()Z
    //   46: pop
    //   47: aload_1
    //   48: invokevirtual 373	java/io/File:createNewFile	()Z
    //   51: pop
    //   52: ldc_w 356
    //   55: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_1
    //   62: ldc_w 356
    //   65: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -10 -> 58
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	d
    //   0	76	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   47	52	61	java/io/IOException
    //   2	47	71	finally
    //   47	52	71	finally
    //   52	58	71	finally
    //   62	68	71	finally
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(67132);
        if (this.f == null)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          TXCLog.w("TXCMP4SWMuxer", "cache frame before muexer ready. ptsUs: " + paramBufferInfo.presentationTimeUs);
          AppMethodBeat.o(67132);
          return;
        }
        if (this.p < 0L)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          this.p = g();
          TXCLog.d("TXCMP4SWMuxer", "first frame offset = " + this.p);
          i();
          AppMethodBeat.o(67132);
          continue;
        }
        a(paramBufferInfo.presentationTimeUs);
      }
      finally {}
      c(paramByteBuffer, paramBufferInfo);
      AppMethodBeat.o(67132);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(67131);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      b(localByteBuffer, paramArrayOfByte);
      AppMethodBeat.o(67131);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  /* Error */
  public int b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 394
    //   7: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 216	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   14: ifnull +132 -> 146
    //   17: aload_0
    //   18: invokespecial 396	com/tencent/liteav/muxer/d:h	()V
    //   21: ldc 109
    //   23: new 187	java/lang/StringBuilder
    //   26: dup
    //   27: ldc_w 398
    //   30: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 75	com/tencent/liteav/muxer/d:l	Z
    //   37: invokevirtual 401	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: ldc_w 403
    //   43: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 77	com/tencent/liteav/muxer/d:m	Z
    //   50: invokevirtual 401	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 286	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 75	com/tencent/liteav/muxer/d:l	Z
    //   63: ifeq +18 -> 81
    //   66: aload_0
    //   67: getfield 77	com/tencent/liteav/muxer/d:m	Z
    //   70: ifeq +11 -> 81
    //   73: aload_0
    //   74: getfield 216	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   77: invokevirtual 405	com/tencent/liteav/muxer/jni/TXSWMuxerJNI:b	()I
    //   80: pop
    //   81: aload_0
    //   82: getfield 216	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   85: invokevirtual 407	com/tencent/liteav/muxer/jni/TXSWMuxerJNI:c	()V
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 216	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 75	com/tencent/liteav/muxer/d:l	Z
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 216	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 77	com/tencent/liteav/muxer/d:m	Z
    //   108: aload_0
    //   109: getfield 82	com/tencent/liteav/muxer/d:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   112: invokevirtual 353	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   115: aload_0
    //   116: getfield 84	com/tencent/liteav/muxer/d:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   119: invokevirtual 353	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 67	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 69	com/tencent/liteav/muxer/d:i	Landroid/media/MediaFormat;
    //   132: aload_0
    //   133: ldc2_w 85
    //   136: putfield 90	com/tencent/liteav/muxer/d:q	J
    //   139: aload_0
    //   140: ldc2_w 85
    //   143: putfield 92	com/tencent/liteav/muxer/d:r	J
    //   146: ldc_w 394
    //   149: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: monitorexit
    //   154: iload_1
    //   155: ireturn
    //   156: astore_2
    //   157: ldc 109
    //   159: ldc_w 409
    //   162: aload_2
    //   163: invokestatic 229	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   166: invokevirtual 233	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokestatic 116	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_0
    //   173: iconst_0
    //   174: putfield 75	com/tencent/liteav/muxer/d:l	Z
    //   177: aload_0
    //   178: aconst_null
    //   179: putfield 216	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 77	com/tencent/liteav/muxer/d:m	Z
    //   187: aload_0
    //   188: getfield 82	com/tencent/liteav/muxer/d:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   191: invokevirtual 353	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   194: aload_0
    //   195: getfield 84	com/tencent/liteav/muxer/d:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   198: invokevirtual 353	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   201: aload_0
    //   202: aconst_null
    //   203: putfield 67	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield 69	com/tencent/liteav/muxer/d:i	Landroid/media/MediaFormat;
    //   211: aload_0
    //   212: ldc2_w 85
    //   215: putfield 90	com/tencent/liteav/muxer/d:q	J
    //   218: aload_0
    //   219: ldc2_w 85
    //   222: putfield 92	com/tencent/liteav/muxer/d:r	J
    //   225: iconst_m1
    //   226: istore_1
    //   227: ldc_w 394
    //   230: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: goto -81 -> 152
    //   236: astore_2
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_2
    //   240: athrow
    //   241: astore_2
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 75	com/tencent/liteav/muxer/d:l	Z
    //   247: aload_0
    //   248: aconst_null
    //   249: putfield 216	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 77	com/tencent/liteav/muxer/d:m	Z
    //   257: aload_0
    //   258: getfield 82	com/tencent/liteav/muxer/d:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   261: invokevirtual 353	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   264: aload_0
    //   265: getfield 84	com/tencent/liteav/muxer/d:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   268: invokevirtual 353	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   271: aload_0
    //   272: aconst_null
    //   273: putfield 67	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
    //   276: aload_0
    //   277: aconst_null
    //   278: putfield 69	com/tencent/liteav/muxer/d:i	Landroid/media/MediaFormat;
    //   281: aload_0
    //   282: ldc2_w 85
    //   285: putfield 90	com/tencent/liteav/muxer/d:q	J
    //   288: aload_0
    //   289: ldc2_w 85
    //   292: putfield 92	com/tencent/liteav/muxer/d:r	J
    //   295: ldc_w 394
    //   298: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_2
    //   302: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	d
    //   1	226	1	i1	int
    //   156	7	2	localException	java.lang.Exception
    //   236	4	2	localObject1	Object
    //   241	61	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	81	156	java/lang/Exception
    //   81	93	156	java/lang/Exception
    //   4	59	236	finally
    //   93	146	236	finally
    //   146	152	236	finally
    //   172	225	236	finally
    //   227	233	236	finally
    //   242	303	236	finally
    //   59	81	241	finally
    //   81	93	241	finally
    //   157	172	241	finally
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    try
    {
      AppMethodBeat.i(67123);
      TXCLog.d("TXCMP4SWMuxer", "addAudioTrack:".concat(String.valueOf(paramMediaFormat)));
      this.i = paramMediaFormat;
      this.o.clear();
      AppMethodBeat.o(67123);
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
      AppMethodBeat.i(67133);
      a(false, paramByteBuffer, paramBufferInfo);
      AppMethodBeat.o(67133);
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
      AppMethodBeat.i(67130);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      a(localByteBuffer, paramArrayOfByte);
      AppMethodBeat.o(67130);
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
    //   3: getfield 67	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.muxer.d
 * JD-Core Version:    0.7.0.1
 */