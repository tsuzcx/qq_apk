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
  private ConcurrentLinkedQueue<a> n;
  private ConcurrentLinkedQueue<a> o;
  private long p;
  private long q;
  private long r;
  
  public d()
  {
    AppMethodBeat.i(14911);
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
    AppMethodBeat.o(14911);
  }
  
  private void a(long paramLong)
  {
    AppMethodBeat.i(14930);
    while (this.o.size() > 0) {
      if (((a)this.o.peek()).b() == null)
      {
        TXCLog.e("TXCMP4SWMuxer", "flushAudioCache, bufferInfo is null");
        this.o.remove();
      }
      else
      {
        if (((a)this.o.peek()).b().presentationTimeUs >= paramLong) {
          break;
        }
        a locala = (a)this.o.poll();
        d(locala.a(), locala.b());
      }
    }
    AppMethodBeat.o(14930);
  }
  
  private void a(boolean paramBoolean, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(14926);
    if ((paramByteBuffer == null) || (paramBufferInfo == null))
    {
      AppMethodBeat.o(14926);
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
    paramByteBuffer = new a(localByteBuffer, paramByteBuffer);
    if (paramBoolean)
    {
      if (this.n.size() < 200)
      {
        this.n.add(paramByteBuffer);
        AppMethodBeat.o(14926);
        return;
      }
      TXCLog.e("TXCMP4SWMuxer", "drop video frame. video cache size is larger than 200");
      AppMethodBeat.o(14926);
      return;
    }
    this.o.add(paramByteBuffer);
    AppMethodBeat.o(14926);
  }
  
  private void c(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l2 = 0L;
    int i1 = 1;
    AppMethodBeat.i(14924);
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
          label159:
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
            AppMethodBeat.o(14924);
            return;
            this.q = l2;
            break;
            if (this.e == 4)
            {
              l1 = ((float)l2 * a);
              break label159;
            }
            if (this.e == 1)
            {
              l1 = ((float)l2 * c);
              break label159;
            }
            l1 = l2;
            if (this.e != 0) {
              break label159;
            }
            l1 = ((float)l2 * d);
            break label159;
            i1 = 0;
          }
          l2 = l1;
        }
        catch (IllegalStateException paramByteBuffer)
        {
          TXCLog.e("TXCMP4SWMuxer", "write frame IllegalStateException: ".concat(String.valueOf(paramByteBuffer)));
          AppMethodBeat.o(14924);
          return;
        }
        catch (IllegalArgumentException paramByteBuffer)
        {
          TXCLog.e("TXCMP4SWMuxer", "write frame IllegalArgumentException: ".concat(String.valueOf(paramByteBuffer)));
          AppMethodBeat.o(14924);
          return;
        }
      }
    }
  }
  
  private ByteBuffer d()
  {
    AppMethodBeat.i(14914);
    ByteBuffer localByteBuffer = this.i.getByteBuffer("csd-0");
    if (localByteBuffer != null) {
      localByteBuffer.position(0);
    }
    AppMethodBeat.o(14914);
    return localByteBuffer;
  }
  
  private void d(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(14925);
    long l2 = paramBufferInfo.presentationTimeUs - this.p;
    if ((this.p < 0L) || (l2 < 0L))
    {
      TXCLog.w("TXCMP4SWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + paramBufferInfo.presentationTimeUs);
      AppMethodBeat.o(14925);
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
          break label231;
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
        AppMethodBeat.o(14925);
        return;
      }
      catch (IllegalStateException paramByteBuffer)
      {
        TXCLog.e("TXCMP4SWMuxer", "write sample IllegalStateException: ".concat(String.valueOf(paramByteBuffer)));
        AppMethodBeat.o(14925);
        return;
      }
      catch (IllegalArgumentException paramByteBuffer)
      {
        TXCLog.e("TXCMP4SWMuxer", "write sample IllegalArgumentException: ".concat(String.valueOf(paramByteBuffer)));
        AppMethodBeat.o(14925);
      }
      this.r = l2;
      break;
      label231:
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
    AppMethodBeat.i(14915);
    ByteBuffer localByteBuffer = this.h.getByteBuffer("csd-0");
    AppMethodBeat.o(14915);
    return localByteBuffer;
  }
  
  private ByteBuffer f()
  {
    AppMethodBeat.i(14916);
    ByteBuffer localByteBuffer = this.h.getByteBuffer("csd-1");
    AppMethodBeat.o(14916);
    return localByteBuffer;
  }
  
  private long g()
  {
    AppMethodBeat.i(14927);
    if (this.n.size() > 0) {}
    for (long l1 = ((a)this.n.peek()).b().presentationTimeUs;; l1 = 0L)
    {
      long l2 = l1;
      if (this.o.size() > 0)
      {
        a locala = (a)this.o.peek();
        l2 = l1;
        if (locala != null)
        {
          l2 = l1;
          if (locala.b() != null)
          {
            long l3 = ((a)this.o.peek()).b().presentationTimeUs;
            l2 = l1;
            if (l1 > l3) {
              l2 = l3;
            }
          }
        }
      }
      AppMethodBeat.o(14927);
      return l2;
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(14928);
    a locala;
    while (this.n.size() > 0)
    {
      locala = (a)this.n.poll();
      c(locala.a(), locala.b());
    }
    while (this.o.size() > 0)
    {
      locala = (a)this.o.poll();
      d(locala.a(), locala.b());
    }
    AppMethodBeat.o(14928);
  }
  
  private void i()
  {
    AppMethodBeat.i(14929);
    while (this.n.size() > 0)
    {
      a locala = (a)this.n.poll();
      a(locala.b().presentationTimeUs);
      c(locala.a(), locala.b());
    }
    AppMethodBeat.o(14929);
  }
  
  public int a()
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(14917);
        if ((this.g == null) || (this.g.isEmpty()))
        {
          TXCLog.e("TXCMP4SWMuxer", "target path not set yet!");
          i1 = -1;
          AppMethodBeat.o(14917);
          return i1;
        }
        if (!c())
        {
          TXCLog.e("TXCMP4SWMuxer", "video track not set yet!");
          i1 = -2;
          AppMethodBeat.o(14917);
          continue;
        }
        if (this.f == null) {
          break;
        }
      }
      finally {}
      TXCLog.w("TXCMP4SWMuxer", "start has been called. stop must be called before start");
      AppMethodBeat.o(14917);
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
        AppMethodBeat.o(14917);
        i1 = -3;
        break;
        do
        {
          if ((this.i != null) && (localByteBuffer1 == null))
          {
            TXCLog.e("TXCMP4SWMuxer", "audio format contains error csd!");
            AppMethodBeat.o(14917);
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
          AppMethodBeat.o(14917);
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
      AppMethodBeat.i(14912);
      TXCLog.d("TXCMP4SWMuxer", "addVideoTrack:".concat(String.valueOf(paramMediaFormat)));
      this.h = paramMediaFormat;
      this.n.clear();
      AppMethodBeat.o(14912);
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
    //   2: sipush 14919
    //   5: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 64	com/tencent/liteav/muxer/d:g	Ljava/lang/String;
    //   13: aload_0
    //   14: getfield 64	com/tencent/liteav/muxer/d:g	Ljava/lang/String;
    //   17: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +68 -> 88
    //   23: new 349	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: getfield 64	com/tencent/liteav/muxer/d:g	Ljava/lang/String;
    //   31: invokespecial 350	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 354	java/io/File:getParentFile	()Ljava/io/File;
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 357	java/io/File:exists	()Z
    //   44: ifne +8 -> 52
    //   47: aload_2
    //   48: invokevirtual 360	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload_1
    //   53: invokevirtual 357	java/io/File:exists	()Z
    //   56: ifeq +8 -> 64
    //   59: aload_1
    //   60: invokevirtual 363	java/io/File:delete	()Z
    //   63: pop
    //   64: aload_1
    //   65: invokevirtual 366	java/io/File:createNewFile	()Z
    //   68: pop
    //   69: sipush 14919
    //   72: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: ldc 107
    //   81: ldc_w 368
    //   84: aload_1
    //   85: invokestatic 371	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: sipush 14919
    //   91: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -19 -> 75
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	d
    //   0	102	1	paramString	String
    //   39	9	2	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   64	69	78	java/io/IOException
    //   2	52	97	finally
    //   52	64	97	finally
    //   64	69	97	finally
    //   69	75	97	finally
    //   79	88	97	finally
    //   88	94	97	finally
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(14922);
        if (this.f == null)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          TXCLog.w("TXCMP4SWMuxer", "cache frame before muexer ready. ptsUs: " + paramBufferInfo.presentationTimeUs);
          AppMethodBeat.o(14922);
          return;
        }
        if (this.p < 0L)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          this.p = g();
          TXCLog.d("TXCMP4SWMuxer", "first frame offset = " + this.p);
          i();
          AppMethodBeat.o(14922);
          continue;
        }
        a(paramBufferInfo.presentationTimeUs);
      }
      finally {}
      c(paramByteBuffer, paramBufferInfo);
      AppMethodBeat.o(14922);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(14921);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      b(localByteBuffer, paramArrayOfByte);
      AppMethodBeat.o(14921);
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
    //   4: sipush 14918
    //   7: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 212	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   14: ifnull +132 -> 146
    //   17: aload_0
    //   18: invokespecial 391	com/tencent/liteav/muxer/d:h	()V
    //   21: ldc 107
    //   23: new 183	java/lang/StringBuilder
    //   26: dup
    //   27: ldc_w 393
    //   30: invokespecial 188	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 74	com/tencent/liteav/muxer/d:l	Z
    //   37: invokevirtual 396	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: ldc_w 398
    //   43: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 76	com/tencent/liteav/muxer/d:m	Z
    //   50: invokevirtual 396	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 274	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 74	com/tencent/liteav/muxer/d:l	Z
    //   63: ifeq +18 -> 81
    //   66: aload_0
    //   67: getfield 76	com/tencent/liteav/muxer/d:m	Z
    //   70: ifeq +11 -> 81
    //   73: aload_0
    //   74: getfield 212	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   77: invokevirtual 400	com/tencent/liteav/muxer/jni/TXSWMuxerJNI:b	()I
    //   80: pop
    //   81: aload_0
    //   82: getfield 212	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   85: invokevirtual 402	com/tencent/liteav/muxer/jni/TXSWMuxerJNI:c	()V
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 212	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 74	com/tencent/liteav/muxer/d:l	Z
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 212	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 76	com/tencent/liteav/muxer/d:m	Z
    //   108: aload_0
    //   109: getfield 81	com/tencent/liteav/muxer/d:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   112: invokevirtual 340	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   115: aload_0
    //   116: getfield 83	com/tencent/liteav/muxer/d:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   119: invokevirtual 340	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 66	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 68	com/tencent/liteav/muxer/d:i	Landroid/media/MediaFormat;
    //   132: aload_0
    //   133: ldc2_w 84
    //   136: putfield 89	com/tencent/liteav/muxer/d:q	J
    //   139: aload_0
    //   140: ldc2_w 84
    //   143: putfield 91	com/tencent/liteav/muxer/d:r	J
    //   146: sipush 14918
    //   149: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: monitorexit
    //   154: iload_1
    //   155: ireturn
    //   156: astore_2
    //   157: ldc 107
    //   159: ldc_w 404
    //   162: aload_2
    //   163: invokestatic 225	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   166: invokevirtual 229	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokestatic 114	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_0
    //   173: iconst_0
    //   174: putfield 74	com/tencent/liteav/muxer/d:l	Z
    //   177: aload_0
    //   178: aconst_null
    //   179: putfield 212	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 76	com/tencent/liteav/muxer/d:m	Z
    //   187: aload_0
    //   188: getfield 81	com/tencent/liteav/muxer/d:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   191: invokevirtual 340	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   194: aload_0
    //   195: getfield 83	com/tencent/liteav/muxer/d:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   198: invokevirtual 340	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   201: aload_0
    //   202: aconst_null
    //   203: putfield 66	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield 68	com/tencent/liteav/muxer/d:i	Landroid/media/MediaFormat;
    //   211: aload_0
    //   212: ldc2_w 84
    //   215: putfield 89	com/tencent/liteav/muxer/d:q	J
    //   218: aload_0
    //   219: ldc2_w 84
    //   222: putfield 91	com/tencent/liteav/muxer/d:r	J
    //   225: iconst_m1
    //   226: istore_1
    //   227: sipush 14918
    //   230: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: goto -81 -> 152
    //   236: astore_2
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_2
    //   240: athrow
    //   241: astore_2
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 74	com/tencent/liteav/muxer/d:l	Z
    //   247: aload_0
    //   248: aconst_null
    //   249: putfield 212	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 76	com/tencent/liteav/muxer/d:m	Z
    //   257: aload_0
    //   258: getfield 81	com/tencent/liteav/muxer/d:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   261: invokevirtual 340	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   264: aload_0
    //   265: getfield 83	com/tencent/liteav/muxer/d:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   268: invokevirtual 340	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   271: aload_0
    //   272: aconst_null
    //   273: putfield 66	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
    //   276: aload_0
    //   277: aconst_null
    //   278: putfield 68	com/tencent/liteav/muxer/d:i	Landroid/media/MediaFormat;
    //   281: aload_0
    //   282: ldc2_w 84
    //   285: putfield 89	com/tencent/liteav/muxer/d:q	J
    //   288: aload_0
    //   289: ldc2_w 84
    //   292: putfield 91	com/tencent/liteav/muxer/d:r	J
    //   295: sipush 14918
    //   298: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(14913);
      TXCLog.d("TXCMP4SWMuxer", "addAudioTrack:".concat(String.valueOf(paramMediaFormat)));
      this.i = paramMediaFormat;
      this.o.clear();
      AppMethodBeat.o(14913);
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
      AppMethodBeat.i(14923);
      a(false, paramByteBuffer, paramBufferInfo);
      AppMethodBeat.o(14923);
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
      AppMethodBeat.i(14920);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      a(localByteBuffer, paramArrayOfByte);
      AppMethodBeat.o(14920);
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
    //   3: getfield 66	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
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
  
  static class a
  {
    ByteBuffer a;
    MediaCodec.BufferInfo b;
    
    public a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
    {
      this.a = paramByteBuffer;
      this.b = paramBufferInfo;
    }
    
    public ByteBuffer a()
    {
      return this.a;
    }
    
    public MediaCodec.BufferInfo b()
    {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.muxer.d
 * JD-Core Version:    0.7.0.1
 */