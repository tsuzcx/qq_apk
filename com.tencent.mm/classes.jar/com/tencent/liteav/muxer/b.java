package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    //   7: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 64	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   14: ifnull +13 -> 27
    //   17: aload_0
    //   18: getfield 64	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   21: invokevirtual 249	java/lang/String:isEmpty	()Z
    //   24: ifeq +22 -> 46
    //   27: ldc 149
    //   29: ldc 251
    //   31: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: iconst_m1
    //   35: istore_1
    //   36: sipush 14934
    //   39: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_1
    //   45: ireturn
    //   46: aload_0
    //   47: invokevirtual 253	com/tencent/liteav/muxer/b:c	()Z
    //   50: ifne +27 -> 77
    //   53: ldc 149
    //   55: ldc 255
    //   57: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: bipush 254
    //   62: istore_1
    //   63: sipush 14934
    //   66: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -27 -> 42
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    //   77: aload_0
    //   78: getfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   81: ifnull +20 -> 101
    //   84: ldc 149
    //   86: ldc_w 257
    //   89: invokestatic 191	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: sipush 14934
    //   95: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: goto -56 -> 42
    //   101: ldc 149
    //   103: ldc_w 259
    //   106: invokestatic 261	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: new 195	android/media/MediaMuxer
    //   113: dup
    //   114: aload_0
    //   115: getfield 64	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   118: iconst_0
    //   119: invokespecial 264	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   122: putfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   125: aload_0
    //   126: getfield 66	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   129: astore_2
    //   130: aload_2
    //   131: ifnull +18 -> 149
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   139: aload_0
    //   140: getfield 66	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   143: invokevirtual 268	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   146: putfield 72	com/tencent/liteav/muxer/b:k	I
    //   149: aload_0
    //   150: getfield 68	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   153: astore_2
    //   154: aload_2
    //   155: ifnull +18 -> 173
    //   158: aload_0
    //   159: aload_0
    //   160: getfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   163: aload_0
    //   164: getfield 68	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   167: invokevirtual 268	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   170: putfield 70	com/tencent/liteav/muxer/b:j	I
    //   173: aload_0
    //   174: getfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   177: invokevirtual 270	android/media/MediaMuxer:start	()V
    //   180: aload_0
    //   181: ldc2_w 84
    //   184: putfield 87	com/tencent/liteav/muxer/b:p	J
    //   187: aload_0
    //   188: iconst_1
    //   189: putfield 74	com/tencent/liteav/muxer/b:l	Z
    //   192: aload_0
    //   193: iconst_0
    //   194: putfield 76	com/tencent/liteav/muxer/b:m	Z
    //   197: aload_0
    //   198: ldc2_w 84
    //   201: putfield 89	com/tencent/liteav/muxer/b:q	J
    //   204: aload_0
    //   205: ldc2_w 84
    //   208: putfield 91	com/tencent/liteav/muxer/b:r	J
    //   211: sipush 14934
    //   214: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: goto -175 -> 42
    //   220: astore_2
    //   221: ldc 149
    //   223: ldc_w 272
    //   226: aload_2
    //   227: invokestatic 207	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   230: invokevirtual 211	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   233: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: bipush 252
    //   238: istore_1
    //   239: sipush 14934
    //   242: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: goto -203 -> 42
    //   248: astore_2
    //   249: ldc 149
    //   251: ldc_w 274
    //   254: aload_2
    //   255: invokestatic 207	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   258: invokevirtual 211	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   261: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: bipush 251
    //   266: istore_1
    //   267: sipush 14934
    //   270: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: goto -231 -> 42
    //   276: astore_2
    //   277: ldc 149
    //   279: ldc_w 276
    //   282: aload_2
    //   283: invokestatic 207	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   286: invokevirtual 211	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   289: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: bipush 250
    //   294: istore_1
    //   295: sipush 14934
    //   298: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: goto -259 -> 42
    //   304: astore_2
    //   305: ldc 149
    //   307: ldc_w 278
    //   310: aload_2
    //   311: invokestatic 207	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   314: invokevirtual 211	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   317: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: bipush 249
    //   322: istore_1
    //   323: sipush 14934
    //   326: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: goto -287 -> 42
    //   332: astore_2
    //   333: ldc 149
    //   335: ldc_w 280
    //   338: aload_2
    //   339: invokestatic 207	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   342: invokevirtual 211	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   345: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: bipush 248
    //   350: istore_1
    //   351: sipush 14934
    //   354: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: goto -315 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	b
    //   1	350	1	i1	int
    //   72	4	2	localObject	Object
    //   129	26	2	localMediaFormat	MediaFormat
    //   220	7	2	localIOException	java.io.IOException
    //   248	7	2	localIllegalArgumentException1	IllegalArgumentException
    //   276	7	2	localIllegalStateException1	IllegalStateException
    //   304	7	2	localIllegalArgumentException2	IllegalArgumentException
    //   332	7	2	localIllegalStateException2	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   4	27	72	finally
    //   27	34	72	finally
    //   36	42	72	finally
    //   46	60	72	finally
    //   63	69	72	finally
    //   77	98	72	finally
    //   101	109	72	finally
    //   109	125	72	finally
    //   125	130	72	finally
    //   134	149	72	finally
    //   149	154	72	finally
    //   158	173	72	finally
    //   173	217	72	finally
    //   221	236	72	finally
    //   239	245	72	finally
    //   249	264	72	finally
    //   267	273	72	finally
    //   277	292	72	finally
    //   295	301	72	finally
    //   305	320	72	finally
    //   323	329	72	finally
    //   333	348	72	finally
    //   351	357	72	finally
    //   109	125	220	java/io/IOException
    //   134	149	248	java/lang/IllegalArgumentException
    //   134	149	276	java/lang/IllegalStateException
    //   158	173	304	java/lang/IllegalArgumentException
    //   158	173	332	java/lang/IllegalStateException
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
    //   2: ldc_w 287
    //   5: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 64	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   13: aload_0
    //   14: getfield 64	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   17: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +59 -> 79
    //   23: new 294	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: getfield 64	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   31: invokespecial 295	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 299	java/io/File:getParentFile	()Ljava/io/File;
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 302	java/io/File:exists	()Z
    //   44: ifne +8 -> 52
    //   47: aload_2
    //   48: invokevirtual 305	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload_1
    //   53: invokevirtual 302	java/io/File:exists	()Z
    //   56: ifeq +8 -> 64
    //   59: aload_1
    //   60: invokevirtual 308	java/io/File:delete	()Z
    //   63: pop
    //   64: aload_1
    //   65: invokevirtual 311	java/io/File:createNewFile	()Z
    //   68: pop
    //   69: ldc_w 287
    //   72: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: ldc_w 287
    //   82: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: goto -10 -> 75
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	b
    //   0	93	1	paramString	String
    //   39	9	2	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   64	69	78	java/io/IOException
    //   2	52	88	finally
    //   52	64	88	finally
    //   64	69	88	finally
    //   69	75	88	finally
    //   79	85	88	finally
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
    //   7: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   14: ifnull +122 -> 136
    //   17: ldc 149
    //   19: new 164	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 331
    //   26: invokespecial 169	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 74	com/tencent/liteav/muxer/b:l	Z
    //   33: invokevirtual 334	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: ldc_w 336
    //   39: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 76	com/tencent/liteav/muxer/b:m	Z
    //   46: invokevirtual 334	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 261	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 74	com/tencent/liteav/muxer/b:l	Z
    //   59: ifeq +17 -> 76
    //   62: aload_0
    //   63: getfield 76	com/tencent/liteav/muxer/b:m	Z
    //   66: ifeq +10 -> 76
    //   69: aload_0
    //   70: getfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   73: invokevirtual 339	android/media/MediaMuxer:stop	()V
    //   76: aload_0
    //   77: getfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   80: invokevirtual 342	android/media/MediaMuxer:release	()V
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 74	com/tencent/liteav/muxer/b:l	Z
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 76	com/tencent/liteav/muxer/b:m	Z
    //   98: aload_0
    //   99: getfield 81	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   102: invokevirtual 286	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   105: aload_0
    //   106: getfield 83	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   109: invokevirtual 286	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 66	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 68	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   122: aload_0
    //   123: ldc2_w 84
    //   126: putfield 89	com/tencent/liteav/muxer/b:q	J
    //   129: aload_0
    //   130: ldc2_w 84
    //   133: putfield 91	com/tencent/liteav/muxer/b:r	J
    //   136: sipush 14935
    //   139: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_0
    //   143: monitorexit
    //   144: iload_1
    //   145: ireturn
    //   146: astore_2
    //   147: ldc 149
    //   149: ldc_w 344
    //   152: aload_2
    //   153: invokestatic 207	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokevirtual 211	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: iconst_0
    //   164: putfield 74	com/tencent/liteav/muxer/b:l	Z
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   172: aload_0
    //   173: iconst_0
    //   174: putfield 76	com/tencent/liteav/muxer/b:m	Z
    //   177: aload_0
    //   178: getfield 81	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   181: invokevirtual 286	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   184: aload_0
    //   185: getfield 83	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   188: invokevirtual 286	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 66	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 68	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   201: aload_0
    //   202: ldc2_w 84
    //   205: putfield 89	com/tencent/liteav/muxer/b:q	J
    //   208: aload_0
    //   209: ldc2_w 84
    //   212: putfield 91	com/tencent/liteav/muxer/b:r	J
    //   215: iconst_m1
    //   216: istore_1
    //   217: sipush 14935
    //   220: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: goto -81 -> 142
    //   226: astore_2
    //   227: aload_0
    //   228: monitorexit
    //   229: aload_2
    //   230: athrow
    //   231: astore_2
    //   232: aload_0
    //   233: iconst_0
    //   234: putfield 74	com/tencent/liteav/muxer/b:l	Z
    //   237: aload_0
    //   238: aconst_null
    //   239: putfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 76	com/tencent/liteav/muxer/b:m	Z
    //   247: aload_0
    //   248: getfield 81	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   251: invokevirtual 286	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   254: aload_0
    //   255: getfield 83	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   258: invokevirtual 286	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   261: aload_0
    //   262: aconst_null
    //   263: putfield 66	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   266: aload_0
    //   267: aconst_null
    //   268: putfield 68	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   271: aload_0
    //   272: ldc2_w 84
    //   275: putfield 89	com/tencent/liteav/muxer/b:q	J
    //   278: aload_0
    //   279: ldc2_w 84
    //   282: putfield 91	com/tencent/liteav/muxer/b:r	J
    //   285: sipush 14935
    //   288: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   5: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 193	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   12: ifnull +12 -> 24
    //   15: aload_0
    //   16: getfield 87	com/tencent/liteav/muxer/b:p	J
    //   19: lconst_0
    //   20: lcmp
    //   21: ifge +44 -> 65
    //   24: ldc 149
    //   26: new 164	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 348
    //   33: invokespecial 169	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_2
    //   37: getfield 131	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   40: invokevirtual 173	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 261	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: iconst_0
    //   51: aload_1
    //   52: aload_2
    //   53: invokespecial 313	com/tencent/liteav/muxer/b:a	(ZLjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   56: sipush 14939
    //   59: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: aload_0
    //   66: aload_1
    //   67: aload_2
    //   68: invokespecial 243	com/tencent/liteav/muxer/b:d	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   71: sipush 14939
    //   74: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   3: getfield 66	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.muxer.b
 * JD-Core Version:    0.7.0.1
 */