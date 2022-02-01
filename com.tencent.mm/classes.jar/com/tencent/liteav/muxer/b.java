package com.tencent.liteav.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class b
  implements a
{
  public static float a = 0.5F;
  public static float b = 0.8F;
  public static float c = 1.25F;
  public static float d = 2.0F;
  private int e;
  private MediaMuxer f;
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
  
  public b()
  {
    AppMethodBeat.i(14931);
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
    AppMethodBeat.o(14931);
  }
  
  private void a(boolean paramBoolean, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(14942);
    if ((paramByteBuffer == null) || (paramBufferInfo == null))
    {
      AppMethodBeat.o(14942);
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
        AppMethodBeat.o(14942);
        return;
      }
      TXCLog.e("TXCMP4HWMuxer", "drop video frame. video cache size is larger than 200");
      AppMethodBeat.o(14942);
      return;
    }
    if (this.o.size() < 600)
    {
      this.o.add(paramByteBuffer);
      AppMethodBeat.o(14942);
      return;
    }
    TXCLog.e("TXCMP4HWMuxer", "drop audio frame. audio cache size is larger than 600");
    AppMethodBeat.o(14942);
  }
  
  private void c(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l2 = 0L;
    AppMethodBeat.i(14940);
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
            break label224;
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
          AppMethodBeat.o(14940);
          return;
        }
        catch (IllegalStateException paramByteBuffer)
        {
          TXCLog.e("TXCMP4HWMuxer", "write frame IllegalStateException: ".concat(String.valueOf(paramByteBuffer)));
          AppMethodBeat.o(14940);
          return;
        }
        catch (IllegalArgumentException paramByteBuffer)
        {
          TXCLog.e("TXCMP4HWMuxer", "write frame IllegalArgumentException: ".concat(String.valueOf(paramByteBuffer)));
          AppMethodBeat.o(14940);
          return;
        }
        this.q = l2;
        break;
        label224:
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
    AppMethodBeat.i(14943);
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
      AppMethodBeat.o(14943);
      return l2;
    }
  }
  
  private void d(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(14941);
    long l2 = paramBufferInfo.presentationTimeUs - this.p;
    if ((this.p < 0L) || (l2 < 0L))
    {
      TXCLog.w("TXCMP4HWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + paramBufferInfo.presentationTimeUs);
      AppMethodBeat.o(14941);
      return;
    }
    long l1;
    if (l2 < this.r)
    {
      TXCLog.e("TXCMP4HWMuxer", "audio is not in chronological order. current audio's pts pts(" + l2 + ") must larger than pre audio's pts(" + this.r + ")");
      l2 = this.r + 1L;
      l1 = l2;
      if (this.e != 2)
      {
        if (this.e != 3) {
          break label195;
        }
        l1 = ((float)l2 * b);
      }
    }
    for (;;)
    {
      paramBufferInfo.presentationTimeUs = l1;
      try
      {
        this.f.writeSampleData(this.j, paramByteBuffer, paramBufferInfo);
        AppMethodBeat.o(14941);
        return;
      }
      catch (IllegalStateException paramByteBuffer)
      {
        TXCLog.e("TXCMP4HWMuxer", "write sample IllegalStateException: ".concat(String.valueOf(paramByteBuffer)));
        AppMethodBeat.o(14941);
        return;
      }
      catch (IllegalArgumentException paramByteBuffer)
      {
        TXCLog.e("TXCMP4HWMuxer", "write sample IllegalArgumentException: ".concat(String.valueOf(paramByteBuffer)));
        AppMethodBeat.o(14941);
      }
      this.r = l2;
      break;
      label195:
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
  
  private void e()
  {
    AppMethodBeat.i(14944);
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
    AppMethodBeat.o(14944);
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: sipush 14934
    //   7: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 61	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   14: ifnull +13 -> 27
    //   17: aload_0
    //   18: getfield 61	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   21: invokevirtual 246	java/lang/String:isEmpty	()Z
    //   24: ifeq +22 -> 46
    //   27: ldc 146
    //   29: ldc 248
    //   31: invokestatic 153	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: iconst_m1
    //   35: istore_1
    //   36: sipush 14934
    //   39: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_1
    //   45: ireturn
    //   46: aload_0
    //   47: invokevirtual 250	com/tencent/liteav/muxer/b:c	()Z
    //   50: ifne +27 -> 77
    //   53: ldc 146
    //   55: ldc 252
    //   57: invokestatic 153	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: bipush 254
    //   62: istore_1
    //   63: sipush 14934
    //   66: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -27 -> 42
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    //   77: aload_0
    //   78: getfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   81: ifnull +19 -> 100
    //   84: ldc 146
    //   86: ldc 254
    //   88: invokestatic 188	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: sipush 14934
    //   94: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: goto -55 -> 42
    //   100: ldc 146
    //   102: ldc_w 256
    //   105: invokestatic 258	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_0
    //   109: new 192	android/media/MediaMuxer
    //   112: dup
    //   113: aload_0
    //   114: getfield 61	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   117: iconst_0
    //   118: invokespecial 261	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   121: putfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   124: aload_0
    //   125: getfield 63	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   128: astore_2
    //   129: aload_2
    //   130: ifnull +18 -> 148
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   138: aload_0
    //   139: getfield 63	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   142: invokevirtual 265	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   145: putfield 69	com/tencent/liteav/muxer/b:k	I
    //   148: aload_0
    //   149: getfield 65	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull +18 -> 172
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   162: aload_0
    //   163: getfield 65	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   166: invokevirtual 265	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   169: putfield 67	com/tencent/liteav/muxer/b:j	I
    //   172: aload_0
    //   173: getfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   176: invokevirtual 267	android/media/MediaMuxer:start	()V
    //   179: aload_0
    //   180: ldc2_w 81
    //   183: putfield 84	com/tencent/liteav/muxer/b:p	J
    //   186: aload_0
    //   187: iconst_1
    //   188: putfield 71	com/tencent/liteav/muxer/b:l	Z
    //   191: aload_0
    //   192: iconst_0
    //   193: putfield 73	com/tencent/liteav/muxer/b:m	Z
    //   196: aload_0
    //   197: ldc2_w 81
    //   200: putfield 86	com/tencent/liteav/muxer/b:q	J
    //   203: aload_0
    //   204: ldc2_w 81
    //   207: putfield 88	com/tencent/liteav/muxer/b:r	J
    //   210: sipush 14934
    //   213: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: goto -174 -> 42
    //   219: astore_2
    //   220: ldc 146
    //   222: ldc_w 269
    //   225: aload_2
    //   226: invokestatic 204	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   229: invokevirtual 208	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   232: invokestatic 153	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: bipush 252
    //   237: istore_1
    //   238: sipush 14934
    //   241: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: goto -202 -> 42
    //   247: astore_2
    //   248: ldc 146
    //   250: ldc_w 271
    //   253: aload_2
    //   254: invokestatic 204	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   257: invokevirtual 208	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   260: invokestatic 153	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: bipush 251
    //   265: istore_1
    //   266: sipush 14934
    //   269: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: goto -230 -> 42
    //   275: astore_2
    //   276: ldc 146
    //   278: ldc_w 273
    //   281: aload_2
    //   282: invokestatic 204	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   285: invokevirtual 208	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokestatic 153	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: bipush 250
    //   293: istore_1
    //   294: sipush 14934
    //   297: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: goto -258 -> 42
    //   303: astore_2
    //   304: ldc 146
    //   306: ldc_w 275
    //   309: aload_2
    //   310: invokestatic 204	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   313: invokevirtual 208	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   316: invokestatic 153	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: bipush 249
    //   321: istore_1
    //   322: sipush 14934
    //   325: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: goto -286 -> 42
    //   331: astore_2
    //   332: ldc 146
    //   334: ldc_w 277
    //   337: aload_2
    //   338: invokestatic 204	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   341: invokevirtual 208	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   344: invokestatic 153	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: bipush 248
    //   349: istore_1
    //   350: sipush 14934
    //   353: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: goto -314 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	b
    //   1	349	1	i1	int
    //   72	4	2	localObject	Object
    //   128	26	2	localMediaFormat	MediaFormat
    //   219	7	2	localIOException	java.io.IOException
    //   247	7	2	localIllegalArgumentException1	IllegalArgumentException
    //   275	7	2	localIllegalStateException1	IllegalStateException
    //   303	7	2	localIllegalArgumentException2	IllegalArgumentException
    //   331	7	2	localIllegalStateException2	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   4	27	72	finally
    //   27	34	72	finally
    //   36	42	72	finally
    //   46	60	72	finally
    //   63	69	72	finally
    //   77	97	72	finally
    //   100	108	72	finally
    //   108	124	72	finally
    //   124	129	72	finally
    //   133	148	72	finally
    //   148	153	72	finally
    //   157	172	72	finally
    //   172	216	72	finally
    //   220	235	72	finally
    //   238	244	72	finally
    //   248	263	72	finally
    //   266	272	72	finally
    //   276	291	72	finally
    //   294	300	72	finally
    //   304	319	72	finally
    //   322	328	72	finally
    //   332	347	72	finally
    //   350	356	72	finally
    //   108	124	219	java/io/IOException
    //   133	148	247	java/lang/IllegalArgumentException
    //   133	148	275	java/lang/IllegalStateException
    //   157	172	303	java/lang/IllegalArgumentException
    //   157	172	331	java/lang/IllegalStateException
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    try
    {
      AppMethodBeat.i(14932);
      TXCLog.d("TXCMP4HWMuxer", "addVideoTrack:".concat(String.valueOf(paramMediaFormat)));
      this.h = paramMediaFormat;
      this.n.clear();
      AppMethodBeat.o(14932);
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
    //   2: ldc_w 284
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 61	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   13: aload_0
    //   14: getfield 61	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   17: invokestatic 289	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +68 -> 88
    //   23: new 291	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: getfield 61	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   31: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 296	java/io/File:getParentFile	()Ljava/io/File;
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 299	java/io/File:exists	()Z
    //   44: ifne +8 -> 52
    //   47: aload_2
    //   48: invokevirtual 302	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload_1
    //   53: invokevirtual 299	java/io/File:exists	()Z
    //   56: ifeq +8 -> 64
    //   59: aload_1
    //   60: invokevirtual 305	java/io/File:delete	()Z
    //   63: pop
    //   64: aload_1
    //   65: invokevirtual 308	java/io/File:createNewFile	()Z
    //   68: pop
    //   69: ldc_w 284
    //   72: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: ldc 146
    //   81: ldc_w 310
    //   84: aload_1
    //   85: invokestatic 313	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: ldc_w 284
    //   91: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -19 -> 75
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	b
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
        AppMethodBeat.i(14938);
        if (this.f == null)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          TXCLog.w("TXCMP4HWMuxer", "cache frame before muexer ready. ptsUs: " + paramBufferInfo.presentationTimeUs);
          AppMethodBeat.o(14938);
          return;
        }
        if (this.p < 0L)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          this.p = d();
          TXCLog.d("TXCMP4HWMuxer", "first frame offset = " + this.p);
          e();
          AppMethodBeat.o(14938);
          continue;
        }
        c(paramByteBuffer, paramBufferInfo);
      }
      finally {}
      AppMethodBeat.o(14938);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(14937);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      b(localByteBuffer, paramArrayOfByte);
      AppMethodBeat.o(14937);
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
    //   4: sipush 14935
    //   7: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   14: ifnull +122 -> 136
    //   17: ldc 146
    //   19: new 161	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 333
    //   26: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 71	com/tencent/liteav/muxer/b:l	Z
    //   33: invokevirtual 336	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: ldc_w 338
    //   39: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 73	com/tencent/liteav/muxer/b:m	Z
    //   46: invokevirtual 336	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 258	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 71	com/tencent/liteav/muxer/b:l	Z
    //   59: ifeq +17 -> 76
    //   62: aload_0
    //   63: getfield 73	com/tencent/liteav/muxer/b:m	Z
    //   66: ifeq +10 -> 76
    //   69: aload_0
    //   70: getfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   73: invokevirtual 341	android/media/MediaMuxer:stop	()V
    //   76: aload_0
    //   77: getfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   80: invokevirtual 344	android/media/MediaMuxer:release	()V
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 71	com/tencent/liteav/muxer/b:l	Z
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 73	com/tencent/liteav/muxer/b:m	Z
    //   98: aload_0
    //   99: getfield 78	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   102: invokevirtual 283	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   105: aload_0
    //   106: getfield 80	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   109: invokevirtual 283	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 63	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 65	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   122: aload_0
    //   123: ldc2_w 81
    //   126: putfield 86	com/tencent/liteav/muxer/b:q	J
    //   129: aload_0
    //   130: ldc2_w 81
    //   133: putfield 88	com/tencent/liteav/muxer/b:r	J
    //   136: sipush 14935
    //   139: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_0
    //   143: monitorexit
    //   144: iload_1
    //   145: ireturn
    //   146: astore_2
    //   147: ldc 146
    //   149: ldc_w 346
    //   152: aload_2
    //   153: invokestatic 204	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokevirtual 208	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokestatic 153	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: iconst_0
    //   164: putfield 71	com/tencent/liteav/muxer/b:l	Z
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   172: aload_0
    //   173: iconst_0
    //   174: putfield 73	com/tencent/liteav/muxer/b:m	Z
    //   177: aload_0
    //   178: getfield 78	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   181: invokevirtual 283	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   184: aload_0
    //   185: getfield 80	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   188: invokevirtual 283	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 63	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 65	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   201: aload_0
    //   202: ldc2_w 81
    //   205: putfield 86	com/tencent/liteav/muxer/b:q	J
    //   208: aload_0
    //   209: ldc2_w 81
    //   212: putfield 88	com/tencent/liteav/muxer/b:r	J
    //   215: iconst_m1
    //   216: istore_1
    //   217: sipush 14935
    //   220: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: goto -81 -> 142
    //   226: astore_2
    //   227: aload_0
    //   228: monitorexit
    //   229: aload_2
    //   230: athrow
    //   231: astore_2
    //   232: aload_0
    //   233: iconst_0
    //   234: putfield 71	com/tencent/liteav/muxer/b:l	Z
    //   237: aload_0
    //   238: aconst_null
    //   239: putfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 73	com/tencent/liteav/muxer/b:m	Z
    //   247: aload_0
    //   248: getfield 78	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   251: invokevirtual 283	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   254: aload_0
    //   255: getfield 80	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   258: invokevirtual 283	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   261: aload_0
    //   262: aconst_null
    //   263: putfield 63	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   266: aload_0
    //   267: aconst_null
    //   268: putfield 65	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   271: aload_0
    //   272: ldc2_w 81
    //   275: putfield 86	com/tencent/liteav/muxer/b:q	J
    //   278: aload_0
    //   279: ldc2_w 81
    //   282: putfield 88	com/tencent/liteav/muxer/b:r	J
    //   285: sipush 14935
    //   288: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload_2
    //   292: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	b
    //   1	216	1	i1	int
    //   146	7	2	localException	java.lang.Exception
    //   226	4	2	localObject1	Object
    //   231	61	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	76	146	java/lang/Exception
    //   76	83	146	java/lang/Exception
    //   4	55	226	finally
    //   83	136	226	finally
    //   136	142	226	finally
    //   162	215	226	finally
    //   217	223	226	finally
    //   232	293	226	finally
    //   55	76	231	finally
    //   76	83	231	finally
    //   147	162	231	finally
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    try
    {
      AppMethodBeat.i(14933);
      TXCLog.d("TXCMP4HWMuxer", "addAudioTrack:".concat(String.valueOf(paramMediaFormat)));
      this.i = paramMediaFormat;
      this.o.clear();
      AppMethodBeat.o(14933);
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
    //   2: sipush 14939
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 190	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   12: ifnull +12 -> 24
    //   15: aload_0
    //   16: getfield 84	com/tencent/liteav/muxer/b:p	J
    //   19: lconst_0
    //   20: lcmp
    //   21: ifge +44 -> 65
    //   24: ldc 146
    //   26: new 161	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 350
    //   33: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_2
    //   37: getfield 128	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   40: invokevirtual 170	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 258	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: iconst_0
    //   51: aload_1
    //   52: aload_2
    //   53: invokespecial 315	com/tencent/liteav/muxer/b:a	(ZLjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   56: sipush 14939
    //   59: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: aload_0
    //   66: aload_1
    //   67: aload_2
    //   68: invokespecial 240	com/tencent/liteav/muxer/b:d	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   71: sipush 14939
    //   74: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: goto -15 -> 62
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	b
    //   0	85	1	paramByteBuffer	ByteBuffer
    //   0	85	2	paramBufferInfo	MediaCodec.BufferInfo
    // Exception table:
    //   from	to	target	type
    //   2	24	80	finally
    //   24	62	80	finally
    //   65	77	80	finally
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(14936);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      a(localByteBuffer, paramArrayOfByte);
      AppMethodBeat.o(14936);
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
    //   3: getfield 63	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.muxer.b
 * JD-Core Version:    0.7.0.1
 */