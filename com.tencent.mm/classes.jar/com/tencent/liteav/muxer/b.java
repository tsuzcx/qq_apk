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
  private ConcurrentLinkedQueue<b.a> n;
  private ConcurrentLinkedQueue<b.a> o;
  private long p;
  private long q;
  private long r;
  
  public b()
  {
    AppMethodBeat.i(67097);
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
    AppMethodBeat.o(67097);
  }
  
  private void a(boolean paramBoolean, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(67108);
    if ((paramByteBuffer == null) || (paramBufferInfo == null))
    {
      AppMethodBeat.o(67108);
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
        AppMethodBeat.o(67108);
        return;
      }
      TXCLog.e("TXCMP4HWMuxer", "drop video frame. video cache size is larger than 200");
      AppMethodBeat.o(67108);
      return;
    }
    if (this.o.size() < 600)
    {
      this.o.add(paramByteBuffer);
      AppMethodBeat.o(67108);
      return;
    }
    TXCLog.e("TXCMP4HWMuxer", "drop audio frame. audio cache size is larger than 600");
    AppMethodBeat.o(67108);
  }
  
  private void c(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l2 = 0L;
    AppMethodBeat.i(67106);
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
            break label222;
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
          AppMethodBeat.o(67106);
          return;
        }
        catch (IllegalStateException paramByteBuffer)
        {
          TXCLog.e("TXCMP4HWMuxer", "write frame IllegalStateException: ".concat(String.valueOf(paramByteBuffer)));
          AppMethodBeat.o(67106);
          return;
        }
        catch (IllegalArgumentException paramByteBuffer)
        {
          TXCLog.e("TXCMP4HWMuxer", "write frame IllegalArgumentException: ".concat(String.valueOf(paramByteBuffer)));
          AppMethodBeat.o(67106);
          return;
        }
        this.q = l2;
        break;
        label222:
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
    AppMethodBeat.i(67109);
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
      AppMethodBeat.o(67109);
      return l2;
    }
  }
  
  private void d(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(67107);
    long l2 = paramBufferInfo.presentationTimeUs - this.p;
    if ((this.p < 0L) || (l2 < 0L))
    {
      TXCLog.w("TXCMP4HWMuxer", "drop sample. first frame offset timeus = " + this.p + ", current sample timeus = " + paramBufferInfo.presentationTimeUs);
      AppMethodBeat.o(67107);
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
          break label192;
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
        AppMethodBeat.o(67107);
        return;
      }
      catch (IllegalStateException paramByteBuffer)
      {
        TXCLog.e("TXCMP4HWMuxer", "write sample IllegalStateException: ".concat(String.valueOf(paramByteBuffer)));
        AppMethodBeat.o(67107);
        return;
      }
      catch (IllegalArgumentException paramByteBuffer)
      {
        TXCLog.e("TXCMP4HWMuxer", "write sample IllegalArgumentException: ".concat(String.valueOf(paramByteBuffer)));
        AppMethodBeat.o(67107);
      }
      this.r = l2;
      break;
      label192:
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
    AppMethodBeat.i(67110);
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
    AppMethodBeat.o(67110);
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 252
    //   6: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 65	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 65	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   20: invokevirtual 256	java/lang/String:isEmpty	()Z
    //   23: ifeq +22 -> 45
    //   26: ldc 151
    //   28: ldc_w 258
    //   31: invokestatic 158	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: iconst_m1
    //   35: istore_1
    //   36: ldc 252
    //   38: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_1
    //   44: ireturn
    //   45: aload_0
    //   46: invokevirtual 260	com/tencent/liteav/muxer/b:c	()Z
    //   49: ifne +27 -> 76
    //   52: ldc 151
    //   54: ldc_w 262
    //   57: invokestatic 158	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: bipush 254
    //   62: istore_1
    //   63: ldc 252
    //   65: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -27 -> 41
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: aload_0
    //   77: getfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   80: ifnull +19 -> 99
    //   83: ldc 151
    //   85: ldc_w 264
    //   88: invokestatic 194	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: ldc 252
    //   93: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -55 -> 41
    //   99: ldc 151
    //   101: ldc_w 266
    //   104: invokestatic 268	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: new 198	android/media/MediaMuxer
    //   111: dup
    //   112: aload_0
    //   113: getfield 65	com/tencent/liteav/muxer/b:g	Ljava/lang/String;
    //   116: iconst_0
    //   117: invokespecial 271	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   120: putfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   123: aload_0
    //   124: getfield 67	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   127: astore_2
    //   128: aload_2
    //   129: ifnull +18 -> 147
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   137: aload_0
    //   138: getfield 67	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   141: invokevirtual 275	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   144: putfield 73	com/tencent/liteav/muxer/b:k	I
    //   147: aload_0
    //   148: getfield 69	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   151: astore_2
    //   152: aload_2
    //   153: ifnull +18 -> 171
    //   156: aload_0
    //   157: aload_0
    //   158: getfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   161: aload_0
    //   162: getfield 69	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   165: invokevirtual 275	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   168: putfield 71	com/tencent/liteav/muxer/b:j	I
    //   171: aload_0
    //   172: getfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   175: invokevirtual 277	android/media/MediaMuxer:start	()V
    //   178: aload_0
    //   179: ldc2_w 85
    //   182: putfield 88	com/tencent/liteav/muxer/b:p	J
    //   185: aload_0
    //   186: iconst_1
    //   187: putfield 75	com/tencent/liteav/muxer/b:l	Z
    //   190: aload_0
    //   191: iconst_0
    //   192: putfield 77	com/tencent/liteav/muxer/b:m	Z
    //   195: aload_0
    //   196: ldc2_w 85
    //   199: putfield 90	com/tencent/liteav/muxer/b:q	J
    //   202: aload_0
    //   203: ldc2_w 85
    //   206: putfield 92	com/tencent/liteav/muxer/b:r	J
    //   209: ldc 252
    //   211: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: goto -173 -> 41
    //   217: astore_2
    //   218: ldc 151
    //   220: ldc_w 279
    //   223: aload_2
    //   224: invokestatic 210	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   227: invokevirtual 214	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   230: invokestatic 158	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: bipush 252
    //   235: istore_1
    //   236: ldc 252
    //   238: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: goto -200 -> 41
    //   244: astore_2
    //   245: ldc 151
    //   247: ldc_w 281
    //   250: aload_2
    //   251: invokestatic 210	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   254: invokevirtual 214	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   257: invokestatic 158	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: bipush 251
    //   262: istore_1
    //   263: ldc 252
    //   265: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: goto -227 -> 41
    //   271: astore_2
    //   272: ldc 151
    //   274: ldc_w 283
    //   277: aload_2
    //   278: invokestatic 210	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   281: invokevirtual 214	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   284: invokestatic 158	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: bipush 250
    //   289: istore_1
    //   290: ldc 252
    //   292: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: goto -254 -> 41
    //   298: astore_2
    //   299: ldc 151
    //   301: ldc_w 285
    //   304: aload_2
    //   305: invokestatic 210	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   308: invokevirtual 214	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   311: invokestatic 158	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: bipush 249
    //   316: istore_1
    //   317: ldc 252
    //   319: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: goto -281 -> 41
    //   325: astore_2
    //   326: ldc 151
    //   328: ldc_w 287
    //   331: aload_2
    //   332: invokestatic 210	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   335: invokevirtual 214	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   338: invokestatic 158	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: bipush 248
    //   343: istore_1
    //   344: ldc 252
    //   346: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: goto -308 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	b
    //   1	343	1	i1	int
    //   71	4	2	localObject	Object
    //   127	26	2	localMediaFormat	MediaFormat
    //   217	7	2	localIOException	java.io.IOException
    //   244	7	2	localIllegalArgumentException1	IllegalArgumentException
    //   271	7	2	localIllegalStateException1	IllegalStateException
    //   298	7	2	localIllegalArgumentException2	IllegalArgumentException
    //   325	7	2	localIllegalStateException2	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   4	26	71	finally
    //   26	34	71	finally
    //   36	41	71	finally
    //   45	60	71	finally
    //   63	68	71	finally
    //   76	96	71	finally
    //   99	107	71	finally
    //   107	123	71	finally
    //   123	128	71	finally
    //   132	147	71	finally
    //   147	152	71	finally
    //   156	171	71	finally
    //   171	214	71	finally
    //   218	233	71	finally
    //   236	241	71	finally
    //   245	260	71	finally
    //   263	268	71	finally
    //   272	287	71	finally
    //   290	295	71	finally
    //   299	314	71	finally
    //   317	322	71	finally
    //   326	341	71	finally
    //   344	349	71	finally
    //   107	123	217	java/io/IOException
    //   132	147	244	java/lang/IllegalArgumentException
    //   132	147	271	java/lang/IllegalStateException
    //   156	171	298	java/lang/IllegalArgumentException
    //   156	171	325	java/lang/IllegalStateException
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    try
    {
      AppMethodBeat.i(67098);
      TXCLog.d("TXCMP4HWMuxer", "addVideoTrack:".concat(String.valueOf(paramMediaFormat)));
      this.h = paramMediaFormat;
      this.n.clear();
      AppMethodBeat.o(67098);
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
        AppMethodBeat.i(67104);
        if (this.f == null)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          TXCLog.w("TXCMP4HWMuxer", "cache frame before muexer ready. ptsUs: " + paramBufferInfo.presentationTimeUs);
          AppMethodBeat.o(67104);
          return;
        }
        if (this.p < 0L)
        {
          a(true, paramByteBuffer, paramBufferInfo);
          this.p = d();
          TXCLog.d("TXCMP4HWMuxer", "first frame offset = " + this.p);
          e();
          AppMethodBeat.o(67104);
          continue;
        }
        c(paramByteBuffer, paramBufferInfo);
      }
      finally {}
      AppMethodBeat.o(67104);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(67103);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      b(localByteBuffer, paramArrayOfByte);
      AppMethodBeat.o(67103);
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
    //   4: ldc_w 315
    //   7: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   14: ifnull +122 -> 136
    //   17: ldc 151
    //   19: new 167	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 317
    //   26: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 75	com/tencent/liteav/muxer/b:l	Z
    //   33: invokevirtual 320	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: ldc_w 322
    //   39: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 77	com/tencent/liteav/muxer/b:m	Z
    //   46: invokevirtual 320	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 268	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 75	com/tencent/liteav/muxer/b:l	Z
    //   59: ifeq +17 -> 76
    //   62: aload_0
    //   63: getfield 77	com/tencent/liteav/muxer/b:m	Z
    //   66: ifeq +10 -> 76
    //   69: aload_0
    //   70: getfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   73: invokevirtual 325	android/media/MediaMuxer:stop	()V
    //   76: aload_0
    //   77: getfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   80: invokevirtual 328	android/media/MediaMuxer:release	()V
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 75	com/tencent/liteav/muxer/b:l	Z
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 77	com/tencent/liteav/muxer/b:m	Z
    //   98: aload_0
    //   99: getfield 82	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   102: invokevirtual 294	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   105: aload_0
    //   106: getfield 84	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   109: invokevirtual 294	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 67	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 69	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   122: aload_0
    //   123: ldc2_w 85
    //   126: putfield 90	com/tencent/liteav/muxer/b:q	J
    //   129: aload_0
    //   130: ldc2_w 85
    //   133: putfield 92	com/tencent/liteav/muxer/b:r	J
    //   136: ldc_w 315
    //   139: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_0
    //   143: monitorexit
    //   144: iload_1
    //   145: ireturn
    //   146: astore_2
    //   147: ldc 151
    //   149: ldc_w 330
    //   152: aload_2
    //   153: invokestatic 210	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokevirtual 214	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokestatic 158	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: iconst_0
    //   164: putfield 75	com/tencent/liteav/muxer/b:l	Z
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   172: aload_0
    //   173: iconst_0
    //   174: putfield 77	com/tencent/liteav/muxer/b:m	Z
    //   177: aload_0
    //   178: getfield 82	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   181: invokevirtual 294	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   184: aload_0
    //   185: getfield 84	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   188: invokevirtual 294	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   191: aload_0
    //   192: aconst_null
    //   193: putfield 67	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 69	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   201: aload_0
    //   202: ldc2_w 85
    //   205: putfield 90	com/tencent/liteav/muxer/b:q	J
    //   208: aload_0
    //   209: ldc2_w 85
    //   212: putfield 92	com/tencent/liteav/muxer/b:r	J
    //   215: iconst_m1
    //   216: istore_1
    //   217: ldc_w 315
    //   220: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: goto -81 -> 142
    //   226: astore_2
    //   227: aload_0
    //   228: monitorexit
    //   229: aload_2
    //   230: athrow
    //   231: astore_2
    //   232: aload_0
    //   233: iconst_0
    //   234: putfield 75	com/tencent/liteav/muxer/b:l	Z
    //   237: aload_0
    //   238: aconst_null
    //   239: putfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 77	com/tencent/liteav/muxer/b:m	Z
    //   247: aload_0
    //   248: getfield 82	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   251: invokevirtual 294	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   254: aload_0
    //   255: getfield 84	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   258: invokevirtual 294	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   261: aload_0
    //   262: aconst_null
    //   263: putfield 67	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   266: aload_0
    //   267: aconst_null
    //   268: putfield 69	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   271: aload_0
    //   272: ldc2_w 85
    //   275: putfield 90	com/tencent/liteav/muxer/b:q	J
    //   278: aload_0
    //   279: ldc2_w 85
    //   282: putfield 92	com/tencent/liteav/muxer/b:r	J
    //   285: ldc_w 315
    //   288: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(67099);
      TXCLog.d("TXCMP4HWMuxer", "addAudioTrack:".concat(String.valueOf(paramMediaFormat)));
      this.i = paramMediaFormat;
      this.o.clear();
      AppMethodBeat.o(67099);
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
    //   2: ldc_w 334
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 196	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   12: ifnull +12 -> 24
    //   15: aload_0
    //   16: getfield 88	com/tencent/liteav/muxer/b:p	J
    //   19: lconst_0
    //   20: lcmp
    //   21: ifge +44 -> 65
    //   24: ldc 151
    //   26: new 167	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 336
    //   33: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_2
    //   37: getfield 133	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   40: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 194	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: iconst_0
    //   51: aload_1
    //   52: aload_2
    //   53: invokespecial 297	com/tencent/liteav/muxer/b:a	(ZLjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   56: ldc_w 334
    //   59: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: aload_0
    //   66: aload_1
    //   67: aload_2
    //   68: invokespecial 249	com/tencent/liteav/muxer/b:d	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   71: ldc_w 334
    //   74: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(67102);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      a(localByteBuffer, paramArrayOfByte);
      AppMethodBeat.o(67102);
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
    //   3: getfield 67	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
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