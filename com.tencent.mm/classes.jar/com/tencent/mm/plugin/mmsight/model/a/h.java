package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h
  implements c
{
  int audioSampleRate;
  com.tencent.mm.f.b.c bCc = null;
  MediaCodec eIF;
  private int eII;
  private int ejM;
  int gNN;
  private final int gOs = 100;
  private MediaFormat miK;
  private MediaCodec.BufferInfo miL;
  long miM = 0L;
  int miN;
  int miO;
  long miP;
  long miQ;
  boolean miR = false;
  boolean miS = false;
  c.a miT = null;
  o miU;
  ah miV = new h.1(this, Looper.getMainLooper());
  protected boolean miW;
  boolean miX;
  final Object miY = new byte[0];
  c.b miZ;
  boolean mja = false;
  ah mjb;
  Runnable mjc = new h.2(this);
  private com.tencent.mm.f.b.c.a mjd = new h.3(this);
  private long startTime = 0L;
  
  public h(int paramInt1, int paramInt2)
  {
    this.ejM = paramInt2;
    this.audioSampleRate = paramInt1;
    this.miU = null;
    y.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s", new Object[] { Integer.valueOf(this.ejM), Integer.valueOf(this.audioSampleRate) });
  }
  
  public final int a(c.a parama)
  {
    int i = 0;
    y.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.miT = parama;
    if (!this.miS)
    {
      if (this.bCc == null)
      {
        y.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
        return -1;
      }
      if (!this.bCc.uq()) {}
    }
    for (;;)
    {
      return i;
      i = -1;
      continue;
      this.miV.sendEmptyMessage(0);
    }
  }
  
  public final int a(c.b paramb)
  {
    boolean bool1;
    boolean bool2;
    if (this.bCc == null)
    {
      bool1 = true;
      if (this.miZ != null) {
        break label89;
      }
      bool2 = true;
      label18:
      if (paramb != null) {
        break label94;
      }
    }
    label89:
    label94:
    for (boolean bool3 = true;; bool3 = false)
    {
      y.i("MicroMsg.MMSightAACMediaCodecRecorder", "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.miW) });
      if ((this.bCc != null) || (this.miS)) {
        break label100;
      }
      return -1;
      bool1 = false;
      break;
      bool2 = false;
      break label18;
    }
    label100:
    this.miW = true;
    synchronized (this.miY)
    {
      this.miZ = paramb;
      if ((this.miX) && (paramb != null))
      {
        y.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
        paramb.bjk();
        this.miZ = null;
      }
      ai.l(new h.4(this), 500L);
      return 0;
    }
  }
  
  /* Error */
  public int au(int paramInt, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/mm/plugin/mmsight/model/a/h:miS	Z
    //   4: ifne +45 -> 49
    //   7: aload_0
    //   8: getfield 83	com/tencent/mm/plugin/mmsight/model/a/h:bCc	Lcom/tencent/mm/f/b/c;
    //   11: ifnull +38 -> 49
    //   14: aload_0
    //   15: getfield 146	com/tencent/mm/plugin/mmsight/model/a/h:miZ	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   18: ifnonnull +371 -> 389
    //   21: iconst_1
    //   22: istore_3
    //   23: ldc 107
    //   25: ldc 183
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iload_3
    //   34: invokestatic 153	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: invokestatic 186	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: aload_0
    //   42: getfield 83	com/tencent/mm/plugin/mmsight/model/a/h:bCc	Lcom/tencent/mm/f/b/c;
    //   45: invokevirtual 189	com/tencent/mm/f/b/c:uh	()Z
    //   48: pop
    //   49: aload_0
    //   50: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   53: ifnull +70 -> 123
    //   56: aload_0
    //   57: getfield 146	com/tencent/mm/plugin/mmsight/model/a/h:miZ	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   60: ifnonnull +334 -> 394
    //   63: iconst_1
    //   64: istore_3
    //   65: ldc 107
    //   67: ldc 193
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: iload_3
    //   76: invokestatic 153	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   79: aastore
    //   80: invokestatic 186	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_0
    //   84: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   87: invokevirtual 198	android/media/MediaCodec:stop	()V
    //   90: aload_0
    //   91: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   94: invokevirtual 201	android/media/MediaCodec:release	()V
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   102: aload_0
    //   103: getfield 146	com/tencent/mm/plugin/mmsight/model/a/h:miZ	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   106: ifnull +17 -> 123
    //   109: aload_0
    //   110: getfield 146	com/tencent/mm/plugin/mmsight/model/a/h:miZ	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   113: invokeinterface 164 1 0
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 146	com/tencent/mm/plugin/mmsight/model/a/h:miZ	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   123: aload_0
    //   124: iconst_0
    //   125: putfield 203	com/tencent/mm/plugin/mmsight/model/a/h:gNN	I
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield 155	com/tencent/mm/plugin/mmsight/model/a/h:miW	Z
    //   133: aload_0
    //   134: getfield 85	com/tencent/mm/plugin/mmsight/model/a/h:miY	Ljava/lang/Object;
    //   137: astore_2
    //   138: aload_2
    //   139: monitorenter
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield 157	com/tencent/mm/plugin/mmsight/model/a/h:miX	Z
    //   145: aload_0
    //   146: aconst_null
    //   147: putfield 146	com/tencent/mm/plugin/mmsight/model/a/h:miZ	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   150: aload_2
    //   151: monitorexit
    //   152: aload_0
    //   153: getfield 64	com/tencent/mm/plugin/mmsight/model/a/h:miS	Z
    //   156: ifne +49 -> 205
    //   159: aload_0
    //   160: new 133	com/tencent/mm/f/b/c
    //   163: dup
    //   164: aload_0
    //   165: getfield 103	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   168: iconst_1
    //   169: iconst_5
    //   170: invokespecial 206	com/tencent/mm/f/b/c:<init>	(III)V
    //   173: putfield 83	com/tencent/mm/plugin/mmsight/model/a/h:bCc	Lcom/tencent/mm/f/b/c;
    //   176: aload_0
    //   177: getfield 83	com/tencent/mm/plugin/mmsight/model/a/h:bCc	Lcom/tencent/mm/f/b/c;
    //   180: sipush 128
    //   183: invokevirtual 210	com/tencent/mm/f/b/c:ey	(I)V
    //   186: aload_0
    //   187: getfield 83	com/tencent/mm/plugin/mmsight/model/a/h:bCc	Lcom/tencent/mm/f/b/c;
    //   190: iconst_0
    //   191: invokevirtual 214	com/tencent/mm/f/b/c:aX	(Z)V
    //   194: aload_0
    //   195: getfield 83	com/tencent/mm/plugin/mmsight/model/a/h:bCc	Lcom/tencent/mm/f/b/c;
    //   198: aload_0
    //   199: getfield 99	com/tencent/mm/plugin/mmsight/model/a/h:mjd	Lcom/tencent/mm/f/b/c$a;
    //   202: putfield 217	com/tencent/mm/f/b/c:bCP	Lcom/tencent/mm/f/b/c$a;
    //   205: aload_0
    //   206: getfield 219	com/tencent/mm/plugin/mmsight/model/a/h:mjb	Lcom/tencent/mm/sdk/platformtools/ah;
    //   209: ifnonnull +197 -> 406
    //   212: ldc 107
    //   214: ldc 221
    //   216: invokestatic 131	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: new 139	com/tencent/mm/sdk/platformtools/ah
    //   223: dup
    //   224: invokespecial 222	com/tencent/mm/sdk/platformtools/ah:<init>	()V
    //   227: putfield 219	com/tencent/mm/plugin/mmsight/model/a/h:mjb	Lcom/tencent/mm/sdk/platformtools/ah;
    //   230: ldc 107
    //   232: ldc 224
    //   234: iconst_2
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_0
    //   241: getfield 103	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   244: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: aload_0
    //   251: getfield 101	com/tencent/mm/plugin/mmsight/model/a/h:ejM	I
    //   254: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic 121	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_0
    //   262: new 226	android/media/MediaCodec$BufferInfo
    //   265: dup
    //   266: invokespecial 227	android/media/MediaCodec$BufferInfo:<init>	()V
    //   269: putfield 229	com/tencent/mm/plugin/mmsight/model/a/h:miL	Landroid/media/MediaCodec$BufferInfo;
    //   272: aload_0
    //   273: new 231	android/media/MediaFormat
    //   276: dup
    //   277: invokespecial 232	android/media/MediaFormat:<init>	()V
    //   280: putfield 234	com/tencent/mm/plugin/mmsight/model/a/h:miK	Landroid/media/MediaFormat;
    //   283: aload_0
    //   284: getfield 234	com/tencent/mm/plugin/mmsight/model/a/h:miK	Landroid/media/MediaFormat;
    //   287: ldc 236
    //   289: ldc 238
    //   291: invokevirtual 241	android/media/MediaFormat:setString	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_0
    //   295: getfield 234	com/tencent/mm/plugin/mmsight/model/a/h:miK	Landroid/media/MediaFormat;
    //   298: ldc 243
    //   300: iconst_2
    //   301: invokevirtual 247	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   304: aload_0
    //   305: getfield 234	com/tencent/mm/plugin/mmsight/model/a/h:miK	Landroid/media/MediaFormat;
    //   308: ldc 249
    //   310: aload_0
    //   311: getfield 103	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   314: invokevirtual 247	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   317: aload_0
    //   318: getfield 234	com/tencent/mm/plugin/mmsight/model/a/h:miK	Landroid/media/MediaFormat;
    //   321: ldc 251
    //   323: iconst_1
    //   324: invokevirtual 247	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   327: aload_0
    //   328: getfield 234	com/tencent/mm/plugin/mmsight/model/a/h:miK	Landroid/media/MediaFormat;
    //   331: ldc 253
    //   333: aload_0
    //   334: getfield 101	com/tencent/mm/plugin/mmsight/model/a/h:ejM	I
    //   337: invokevirtual 247	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   340: aload_0
    //   341: getfield 234	com/tencent/mm/plugin/mmsight/model/a/h:miK	Landroid/media/MediaFormat;
    //   344: ldc 255
    //   346: sipush 16384
    //   349: invokevirtual 247	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   352: aload_0
    //   353: ldc 238
    //   355: invokestatic 259	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   358: putfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   361: aload_0
    //   362: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   365: aload_0
    //   366: getfield 234	com/tencent/mm/plugin/mmsight/model/a/h:miK	Landroid/media/MediaFormat;
    //   369: aconst_null
    //   370: aconst_null
    //   371: iconst_1
    //   372: invokevirtual 263	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   375: aload_0
    //   376: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   379: invokevirtual 266	android/media/MediaCodec:start	()V
    //   382: aload_0
    //   383: iconst_0
    //   384: putfield 62	com/tencent/mm/plugin/mmsight/model/a/h:miR	Z
    //   387: iconst_0
    //   388: ireturn
    //   389: iconst_0
    //   390: istore_3
    //   391: goto -368 -> 23
    //   394: iconst_0
    //   395: istore_3
    //   396: goto -331 -> 65
    //   399: astore 4
    //   401: aload_2
    //   402: monitorexit
    //   403: aload 4
    //   405: athrow
    //   406: aload_0
    //   407: getfield 219	com/tencent/mm/plugin/mmsight/model/a/h:mjb	Lcom/tencent/mm/sdk/platformtools/ah;
    //   410: invokevirtual 269	com/tencent/mm/sdk/platformtools/ah:getLooper	()Landroid/os/Looper;
    //   413: invokestatic 272	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   416: if_acmpeq -186 -> 230
    //   419: ldc 107
    //   421: ldc_w 274
    //   424: iconst_2
    //   425: anewarray 4	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: aload_0
    //   431: getfield 219	com/tencent/mm/plugin/mmsight/model/a/h:mjb	Lcom/tencent/mm/sdk/platformtools/ah;
    //   434: invokevirtual 269	com/tencent/mm/sdk/platformtools/ah:getLooper	()Landroid/os/Looper;
    //   437: aastore
    //   438: dup
    //   439: iconst_1
    //   440: invokestatic 272	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   443: aastore
    //   444: invokestatic 277	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   447: aload_0
    //   448: new 139	com/tencent/mm/sdk/platformtools/ah
    //   451: dup
    //   452: invokespecial 222	com/tencent/mm/sdk/platformtools/ah:<init>	()V
    //   455: putfield 219	com/tencent/mm/plugin/mmsight/model/a/h:mjb	Lcom/tencent/mm/sdk/platformtools/ah;
    //   458: goto -228 -> 230
    //   461: astore_2
    //   462: ldc 107
    //   464: aload_2
    //   465: ldc_w 279
    //   468: iconst_1
    //   469: anewarray 4	java/lang/Object
    //   472: dup
    //   473: iconst_0
    //   474: aload_2
    //   475: invokevirtual 283	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   478: aastore
    //   479: invokestatic 287	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   482: aload_0
    //   483: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   486: astore 4
    //   488: aload 4
    //   490: ifnull +22 -> 512
    //   493: aload_0
    //   494: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   497: invokevirtual 198	android/media/MediaCodec:stop	()V
    //   500: aload_0
    //   501: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   504: invokevirtual 201	android/media/MediaCodec:release	()V
    //   507: aload_0
    //   508: aconst_null
    //   509: putfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   512: ldc_w 289
    //   515: ldc_w 291
    //   518: invokestatic 131	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: getstatic 297	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   524: ldc2_w 298
    //   527: ldc2_w 300
    //   530: lconst_1
    //   531: iconst_0
    //   532: invokevirtual 304	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   535: aload_0
    //   536: iconst_0
    //   537: putfield 62	com/tencent/mm/plugin/mmsight/model/a/h:miR	Z
    //   540: iconst_m1
    //   541: ireturn
    //   542: astore 4
    //   544: ldc 107
    //   546: aload_2
    //   547: ldc_w 306
    //   550: iconst_1
    //   551: anewarray 4	java/lang/Object
    //   554: dup
    //   555: iconst_0
    //   556: aload 4
    //   558: invokevirtual 307	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   561: aastore
    //   562: invokestatic 287	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   565: aload_0
    //   566: aconst_null
    //   567: putfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   570: goto -58 -> 512
    //   573: astore_2
    //   574: aload_0
    //   575: iconst_0
    //   576: putfield 62	com/tencent/mm/plugin/mmsight/model/a/h:miR	Z
    //   579: aload_2
    //   580: athrow
    //   581: astore_2
    //   582: aload_0
    //   583: aconst_null
    //   584: putfield 191	com/tencent/mm/plugin/mmsight/model/a/h:eIF	Landroid/media/MediaCodec;
    //   587: aload_2
    //   588: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	h
    //   0	589	1	paramInt	int
    //   0	589	2	paramString	java.lang.String
    //   22	374	3	bool	boolean
    //   399	5	4	localObject	Object
    //   486	3	4	localMediaCodec	MediaCodec
    //   542	15	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   140	152	399	finally
    //   401	403	399	finally
    //   261	382	461	java/lang/Throwable
    //   493	507	542	java/lang/Exception
    //   261	382	573	finally
    //   462	488	573	finally
    //   507	512	573	finally
    //   512	535	573	finally
    //   565	570	573	finally
    //   582	589	573	finally
    //   493	507	581	finally
    //   544	565	581	finally
  }
  
  public final void bjh()
  {
    this.miR = true;
  }
  
  public final com.tencent.mm.f.b.c.a bji()
  {
    return this.mjd;
  }
  
  protected boolean bjz()
  {
    return false;
  }
  
  public final void clear()
  {
    y.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
    try
    {
      if (this.eIF != null)
      {
        y.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
        this.eIF.stop();
        this.eIF.release();
        this.eIF = null;
      }
      if ((this.bCc != null) && (!this.miS))
      {
        y.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
        this.bCc.uh();
        this.bCc = null;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  final void drainEncoder(boolean paramBoolean)
  {
    if (this.eIF == null)
    {
      y.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:" + paramBoolean);
      return;
    }
    do
    {
      ByteBuffer[] arrayOfByteBuffer2;
      for (;;)
      {
        try
        {
          ByteBuffer[] arrayOfByteBuffer1 = this.eIF.getOutputBuffers();
          this.eII = this.eIF.dequeueOutputBuffer(this.miL, 100L);
          y.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[] { Integer.valueOf(this.eII) });
          if (this.eII == -1)
          {
            y.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
            return;
          }
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", new Object[] { localException.getMessage() });
          return;
        }
        if (this.eII == -3)
        {
          arrayOfByteBuffer2 = this.eIF.getOutputBuffers();
        }
        else if (this.eII == -2)
        {
          localObject = this.eIF.getOutputFormat();
          y.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: " + localObject);
          if (this.miU != null) {
            this.miU.d((MediaFormat)localObject);
          }
        }
        else
        {
          if (this.eII >= 0) {
            break;
          }
          y.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(this.eII) });
        }
      }
      y.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
      Object localObject = arrayOfByteBuffer2[this.eII];
      if (localObject == null) {
        throw new RuntimeException("encoderOutputBuffer " + this.eII + " was null");
      }
      if ((this.miL.flags & 0x2) != 0)
      {
        y.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(this.miL.size), Boolean.valueOf(bjz()) });
        if (bjz()) {
          this.miL.size = 0;
        }
      }
      if (this.miL.size != 0)
      {
        if ((this.miU != null) && (!this.miU.bSr))
        {
          MediaFormat localMediaFormat = this.eIF.getOutputFormat();
          this.miU.d(localMediaFormat);
        }
        ((ByteBuffer)localObject).position(this.miL.offset);
        ((ByteBuffer)localObject).limit(this.miL.offset + this.miL.size);
        e((ByteBuffer)localObject, this.miL);
      }
      this.eIF.releaseOutputBuffer(this.eII, false);
    } while ((this.miL.flags & 0x4) == 0);
    if (!paramBoolean)
    {
      y.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
      return;
    }
    y.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
    this.eIF.stop();
    this.eIF.release();
    this.eIF = null;
  }
  
  protected void e(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    if ((this.miU != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.miU.f(paramByteBuffer, paramBufferInfo);
    }
  }
  
  public final void ht(boolean paramBoolean)
  {
    this.miS = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h
 * JD-Core Version:    0.7.0.1
 */