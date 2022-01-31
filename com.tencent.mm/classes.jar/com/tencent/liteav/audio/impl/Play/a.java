package com.tencent.liteav.audio.impl.Play;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class a
  implements Runnable
{
  private static final String a;
  private WeakReference<c> b = null;
  private MediaCodec c = null;
  private MediaCodec.BufferInfo d;
  private MediaFormat e;
  private long f = 0L;
  private volatile boolean g = false;
  private Vector<com.tencent.liteav.basic.structs.a> h;
  private List i;
  private Thread j = null;
  
  static
  {
    AppMethodBeat.i(66592);
    a = "AudioCenter:" + a.class.getSimpleName();
    AppMethodBeat.o(66592);
  }
  
  /* Error */
  private int a(com.tencent.liteav.basic.structs.a parama)
  {
    // Byte code:
    //   0: ldc 87
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: getfield 92	com/tencent/liteav/basic/structs/a:f	[B
    //   9: arraylength
    //   10: iconst_2
    //   11: if_icmpeq +29 -> 40
    //   14: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   17: new 38	java/lang/StringBuilder
    //   20: dup
    //   21: ldc 94
    //   23: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload_1
    //   27: getfield 92	com/tencent/liteav/basic/structs/a:f	[B
    //   30: arraylength
    //   31: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 103	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_1
    //   41: getfield 92	com/tencent/liteav/basic/structs/a:f	[B
    //   44: ifnull +547 -> 591
    //   47: aload_0
    //   48: ldc 105
    //   50: aload_1
    //   51: getfield 92	com/tencent/liteav/basic/structs/a:f	[B
    //   54: iconst_0
    //   55: baload
    //   56: bipush 7
    //   58: iand
    //   59: iconst_1
    //   60: ishl
    //   61: aload_1
    //   62: getfield 92	com/tencent/liteav/basic/structs/a:f	[B
    //   65: iconst_1
    //   66: baload
    //   67: sipush 128
    //   70: iand
    //   71: bipush 7
    //   73: ishr
    //   74: ior
    //   75: invokestatic 110	com/tencent/liteav/audio/impl/b:a	(I)I
    //   78: aload_1
    //   79: getfield 92	com/tencent/liteav/basic/structs/a:f	[B
    //   82: iconst_1
    //   83: baload
    //   84: bipush 120
    //   86: iand
    //   87: iconst_3
    //   88: ishr
    //   89: invokestatic 116	android/media/MediaFormat:createAudioFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   92: putfield 118	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   95: aload_0
    //   96: getfield 118	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   99: ldc 120
    //   101: ldc 121
    //   103: invokevirtual 125	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   106: aload_0
    //   107: getfield 118	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   110: ldc 127
    //   112: iconst_0
    //   113: invokevirtual 125	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   116: aload_0
    //   117: getfield 118	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   120: ldc 129
    //   122: iconst_2
    //   123: invokevirtual 125	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   126: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   129: new 38	java/lang/StringBuilder
    //   132: dup
    //   133: ldc 131
    //   135: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: aload_0
    //   139: getfield 118	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   142: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 136	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_0
    //   152: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   155: ifnull +17 -> 172
    //   158: aload_0
    //   159: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   162: invokevirtual 141	android/media/MediaCodec:stop	()V
    //   165: aload_0
    //   166: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   169: invokevirtual 144	android/media/MediaCodec:release	()V
    //   172: aload_0
    //   173: ldc 105
    //   175: invokestatic 148	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   178: putfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   181: getstatic 154	android/os/Build$VERSION:SDK_INT	I
    //   184: bipush 21
    //   186: if_icmplt +291 -> 477
    //   189: iconst_0
    //   190: istore_2
    //   191: aload_0
    //   192: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   195: aload_0
    //   196: getfield 118	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   199: aconst_null
    //   200: aconst_null
    //   201: iconst_0
    //   202: invokevirtual 158	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   205: aload_0
    //   206: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   209: invokevirtual 161	android/media/MediaCodec:start	()V
    //   212: aload_0
    //   213: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   216: ifnull +26 -> 242
    //   219: aload_0
    //   220: aload_1
    //   221: aload_0
    //   222: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   225: invokevirtual 165	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   228: aload_0
    //   229: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   232: ldc2_w 166
    //   235: invokevirtual 171	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   238: invokespecial 174	com/tencent/liteav/audio/impl/Play/a:a	(Lcom/tencent/liteav/basic/structs/a;[Ljava/nio/ByteBuffer;I)I
    //   241: pop
    //   242: ldc 87
    //   244: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore 4
    //   251: iconst_0
    //   252: istore_2
    //   253: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   256: new 38	java/lang/StringBuilder
    //   259: dup
    //   260: ldc 176
    //   262: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   265: iload_2
    //   266: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: ldc 178
    //   271: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 4
    //   276: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: goto -113 -> 172
    //   288: astore 4
    //   290: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   293: new 38	java/lang/StringBuilder
    //   296: dup
    //   297: ldc 182
    //   299: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: aload 4
    //   304: invokevirtual 185	java/io/IOException:getMessage	()Ljava/lang/String;
    //   307: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: goto -135 -> 181
    //   319: astore 4
    //   321: iconst_0
    //   322: istore_3
    //   323: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   326: new 38	java/lang/StringBuilder
    //   329: dup
    //   330: ldc 187
    //   332: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   335: aload 4
    //   337: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   340: ldc 189
    //   342: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: iload_3
    //   346: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: ldc 191
    //   351: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: getfield 118	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   358: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: iload_2
    //   368: iconst_1
    //   369: iadd
    //   370: istore_2
    //   371: iload_2
    //   372: iconst_1
    //   373: if_icmple +31 -> 404
    //   376: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   379: ldc 193
    //   381: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: aload_0
    //   385: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   388: invokevirtual 144	android/media/MediaCodec:release	()V
    //   391: aload_0
    //   392: aconst_null
    //   393: putfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   396: ldc 87
    //   398: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: bipush 155
    //   403: ireturn
    //   404: aload 4
    //   406: invokevirtual 197	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   409: ifeq +18 -> 427
    //   412: aload_0
    //   413: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   416: invokevirtual 141	android/media/MediaCodec:stop	()V
    //   419: goto -228 -> 191
    //   422: astore 4
    //   424: goto -233 -> 191
    //   427: aload 4
    //   429: invokevirtual 200	android/media/MediaCodec$CodecException:isTransient	()Z
    //   432: ifeq +17 -> 449
    //   435: ldc2_w 201
    //   438: invokestatic 208	java/lang/Thread:sleep	(J)V
    //   441: goto -250 -> 191
    //   444: astore 4
    //   446: goto -255 -> 191
    //   449: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   452: ldc 210
    //   454: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload_0
    //   458: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   461: invokevirtual 144	android/media/MediaCodec:release	()V
    //   464: aload_0
    //   465: aconst_null
    //   466: putfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   469: ldc 87
    //   471: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: bipush 155
    //   476: ireturn
    //   477: iconst_0
    //   478: istore_2
    //   479: aload_0
    //   480: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   483: aload_0
    //   484: getfield 118	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   487: aconst_null
    //   488: aconst_null
    //   489: iconst_0
    //   490: invokevirtual 158	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   493: aload_0
    //   494: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   497: invokevirtual 161	android/media/MediaCodec:start	()V
    //   500: goto -288 -> 212
    //   503: astore 4
    //   505: iconst_1
    //   506: istore_3
    //   507: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   510: new 38	java/lang/StringBuilder
    //   513: dup
    //   514: ldc 212
    //   516: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: aload 4
    //   521: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   524: ldc 189
    //   526: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: iload_3
    //   530: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: iload_2
    //   540: iconst_1
    //   541: iadd
    //   542: istore_2
    //   543: iload_2
    //   544: iconst_1
    //   545: if_icmple +31 -> 576
    //   548: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   551: ldc 193
    //   553: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: aload_0
    //   557: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   560: invokevirtual 144	android/media/MediaCodec:release	()V
    //   563: aload_0
    //   564: aconst_null
    //   565: putfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   568: ldc 87
    //   570: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   573: bipush 155
    //   575: ireturn
    //   576: aload_0
    //   577: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   580: invokevirtual 215	android/media/MediaCodec:reset	()V
    //   583: goto -104 -> 479
    //   586: astore 4
    //   588: goto -109 -> 479
    //   591: ldc 87
    //   593: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: sipush -901
    //   599: ireturn
    //   600: astore 4
    //   602: iconst_0
    //   603: istore_3
    //   604: goto -97 -> 507
    //   607: astore 4
    //   609: iconst_1
    //   610: istore_3
    //   611: goto -288 -> 323
    //   614: astore 4
    //   616: iconst_1
    //   617: istore_2
    //   618: goto -365 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	this	a
    //   0	621	1	parama	com.tencent.liteav.basic.structs.a
    //   190	428	2	k	int
    //   322	289	3	m	int
    //   249	26	4	localException1	Exception
    //   288	15	4	localIOException	java.io.IOException
    //   319	86	4	localCodecException1	android.media.MediaCodec.CodecException
    //   422	6	4	localException2	Exception
    //   444	1	4	localInterruptedException	InterruptedException
    //   503	17	4	localIllegalStateException1	java.lang.IllegalStateException
    //   586	1	4	localException3	Exception
    //   600	1	4	localIllegalStateException2	java.lang.IllegalStateException
    //   607	1	4	localCodecException2	android.media.MediaCodec.CodecException
    //   614	1	4	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   158	165	249	java/lang/Exception
    //   172	181	288	java/io/IOException
    //   191	205	319	android/media/MediaCodec$CodecException
    //   412	419	422	java/lang/Exception
    //   435	441	444	java/lang/InterruptedException
    //   493	500	503	java/lang/IllegalStateException
    //   576	583	586	java/lang/Exception
    //   479	493	600	java/lang/IllegalStateException
    //   205	212	607	android/media/MediaCodec$CodecException
    //   165	172	614	java/lang/Exception
  }
  
  private int a(com.tencent.liteav.basic.structs.a parama, ByteBuffer[] paramArrayOfByteBuffer, int paramInt)
  {
    AppMethodBeat.i(146225);
    if (paramInt >= 0) {}
    for (;;)
    {
      try
      {
        if (parama.f != null)
        {
          paramArrayOfByteBuffer = paramArrayOfByteBuffer[paramInt];
          paramArrayOfByteBuffer.clear();
          paramArrayOfByteBuffer.put(parama.f);
        }
        if ((parama == null) || (parama.f.length <= 0)) {
          continue;
        }
        this.c.queueInputBuffer(paramInt, 0, parama.f.length, b(), 0);
        paramArrayOfByteBuffer = this.c.getOutputBuffers();
        parama = paramArrayOfByteBuffer;
        if (this.d == null)
        {
          this.d = new MediaCodec.BufferInfo();
          parama = paramArrayOfByteBuffer;
        }
        paramInt = this.c.dequeueOutputBuffer(this.d, 10000L);
        if (paramInt != -3) {
          break label169;
        }
        parama = this.c.getOutputBuffers();
        if (paramInt >= 0) {
          continue;
        }
      }
      catch (Exception parama)
      {
        continue;
      }
      AppMethodBeat.o(146225);
      return 0;
      this.c.queueInputBuffer(paramInt, 0, 0, b(), 4);
      continue;
      if (paramInt == -1)
      {
        AppMethodBeat.o(146225);
        return -1;
        label169:
        if (paramInt == -2)
        {
          this.e = this.c.getOutputFormat();
        }
        else if (paramInt >= 0)
        {
          c localc = parama[paramInt];
          localc.position(this.d.offset);
          localc.limit(this.d.offset + this.d.size);
          paramArrayOfByteBuffer = new byte[this.d.size];
          localc.get(paramArrayOfByteBuffer);
          long l = ((Long)this.i.get(0)).longValue();
          this.i.remove(0);
          if (this.b != null)
          {
            localc = (c)this.b.get();
            if (localc != null) {
              localc.onPlayPcmData(paramArrayOfByteBuffer, l, 48000, 1);
            }
          }
          this.c.releaseOutputBuffer(paramInt, false);
        }
      }
    }
  }
  
  private long b()
  {
    AppMethodBeat.i(146226);
    long l2 = TXCTimeUtil.getTimeTick();
    long l1 = l2;
    if (l2 < this.f) {
      l1 = l2 + (this.f - l2);
    }
    this.f = l1;
    AppMethodBeat.o(146226);
    return l1;
  }
  
  public void a()
  {
    AppMethodBeat.i(146223);
    this.g = false;
    if (this.j != null) {}
    try
    {
      this.j.join();
      label25:
      this.j = null;
      AppMethodBeat.o(146223);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label25;
    }
  }
  
  public void a(WeakReference<c> paramWeakReference)
  {
    AppMethodBeat.i(66584);
    if (this.g) {
      a();
    }
    this.b = paramWeakReference;
    this.f = 0L;
    this.h = new Vector();
    this.i = new ArrayList();
    this.g = true;
    this.j = new Thread(this);
    this.j.setName(a);
    this.j.start();
    AppMethodBeat.o(66584);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 329
    //   3: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 73	com/tencent/liteav/audio/impl/Play/a:g	Z
    //   10: ifeq +252 -> 262
    //   13: aload_0
    //   14: getfield 315	com/tencent/liteav/audio/impl/Play/a:h	Ljava/util/Vector;
    //   17: astore 4
    //   19: aload 4
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 315	com/tencent/liteav/audio/impl/Play/a:h	Ljava/util/Vector;
    //   26: invokevirtual 332	java/util/Vector:isEmpty	()Z
    //   29: istore_3
    //   30: aload 4
    //   32: monitorexit
    //   33: iload_3
    //   34: ifeq +31 -> 65
    //   37: ldc2_w 333
    //   40: invokestatic 208	java/lang/Thread:sleep	(J)V
    //   43: goto -37 -> 6
    //   46: astore 4
    //   48: goto -42 -> 6
    //   51: astore 5
    //   53: aload 4
    //   55: monitorexit
    //   56: ldc_w 329
    //   59: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload 5
    //   64: athrow
    //   65: aload_0
    //   66: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   69: ifnull +231 -> 300
    //   72: aload_0
    //   73: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   76: invokevirtual 165	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   79: astore 4
    //   81: iconst_1
    //   82: istore_1
    //   83: aload_0
    //   84: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   87: ldc2_w 166
    //   90: invokevirtual 171	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   93: istore_2
    //   94: iload_2
    //   95: ifge +10 -> 105
    //   98: ldc_w 329
    //   101: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: return
    //   105: iload_2
    //   106: istore_1
    //   107: aload_0
    //   108: getfield 315	com/tencent/liteav/audio/impl/Play/a:h	Ljava/util/Vector;
    //   111: astore 5
    //   113: aload 5
    //   115: monitorenter
    //   116: aload_0
    //   117: getfield 315	com/tencent/liteav/audio/impl/Play/a:h	Ljava/util/Vector;
    //   120: iconst_0
    //   121: invokevirtual 335	java/util/Vector:remove	(I)Ljava/lang/Object;
    //   124: checkcast 89	com/tencent/liteav/basic/structs/a
    //   127: astore 6
    //   129: aload 5
    //   131: monitorexit
    //   132: aload 6
    //   134: getfield 337	com/tencent/liteav/basic/structs/a:d	I
    //   137: iconst_2
    //   138: if_icmpne +72 -> 210
    //   141: aload_0
    //   142: aload 6
    //   144: invokespecial 339	com/tencent/liteav/audio/impl/Play/a:a	(Lcom/tencent/liteav/basic/structs/a;)I
    //   147: pop
    //   148: goto -142 -> 6
    //   151: astore 4
    //   153: iconst_0
    //   154: istore_1
    //   155: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   158: new 38	java/lang/StringBuilder
    //   161: dup
    //   162: ldc_w 341
    //   165: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: iload_1
    //   169: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: ldc_w 343
    //   175: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 4
    //   180: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: ldc_w 329
    //   192: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: return
    //   196: astore 4
    //   198: aload 5
    //   200: monitorexit
    //   201: ldc_w 329
    //   204: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload 4
    //   209: athrow
    //   210: aload 6
    //   212: getfield 337	com/tencent/liteav/basic/structs/a:d	I
    //   215: iconst_3
    //   216: if_icmpne +34 -> 250
    //   219: aload_0
    //   220: getfield 267	com/tencent/liteav/audio/impl/Play/a:i	Ljava/util/List;
    //   223: aload 6
    //   225: getfield 345	com/tencent/liteav/basic/structs/a:e	J
    //   228: invokestatic 349	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   231: invokeinterface 353 2 0
    //   236: pop
    //   237: aload_0
    //   238: aload 6
    //   240: aload 4
    //   242: iload_1
    //   243: invokespecial 174	com/tencent/liteav/audio/impl/Play/a:a	(Lcom/tencent/liteav/basic/structs/a;[Ljava/nio/ByteBuffer;I)I
    //   246: pop
    //   247: goto -241 -> 6
    //   250: getstatic 59	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   253: ldc_w 355
    //   256: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: goto -253 -> 6
    //   262: aload_0
    //   263: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   266: ifnull +22 -> 288
    //   269: aload_0
    //   270: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   273: invokevirtual 141	android/media/MediaCodec:stop	()V
    //   276: aload_0
    //   277: getfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   280: invokevirtual 144	android/media/MediaCodec:release	()V
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 69	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   288: ldc_w 329
    //   291: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: return
    //   295: astore 4
    //   297: goto -142 -> 155
    //   300: iconst_m1
    //   301: istore_1
    //   302: aconst_null
    //   303: astore 4
    //   305: goto -198 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	a
    //   82	220	1	k	int
    //   93	13	2	m	int
    //   29	5	3	bool	boolean
    //   17	14	4	localVector1	Vector
    //   46	8	4	localException1	Exception
    //   79	1	4	arrayOfByteBuffer1	ByteBuffer[]
    //   151	28	4	localException2	Exception
    //   196	45	4	arrayOfByteBuffer2	ByteBuffer[]
    //   295	1	4	localException3	Exception
    //   303	1	4	localObject1	Object
    //   51	12	5	localObject2	Object
    //   127	112	6	locala	com.tencent.liteav.basic.structs.a
    // Exception table:
    //   from	to	target	type
    //   37	43	46	java/lang/Exception
    //   22	33	51	finally
    //   53	56	51	finally
    //   72	81	151	java/lang/Exception
    //   116	132	196	finally
    //   198	201	196	finally
    //   83	94	295	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.a
 * JD-Core Version:    0.7.0.1
 */