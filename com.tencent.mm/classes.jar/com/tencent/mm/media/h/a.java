package com.tencent.mm.media.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/mix/AudioMixCodec;", "", "sampleRate", "", "channels", "mixBackground", "", "mixMusic", "frameMix", "Lkotlin/Function0;", "", "frameMixEnd", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "data", "", "pts", "(IIZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "backgroundFrameCount", "backgroundPcmDataList", "", "Lcom/tencent/mm/audio/mix/buffer/PcmDataTrack;", "kotlin.jvm.PlatformType", "", "bitDepth", "flushAllData", "flushLock", "Ljava/lang/Object;", "frameLength", "index", "isBackgroundEnd", "isMixing", "isMixingFinish", "isMusicEnd", "mAudioSyncMixController", "Lcom/tencent/mm/audio/mix/mix/AudioSyncMixController;", "mMixRunnable", "Ljava/lang/Runnable;", "mPts", "mixLock", "musicFrameCount", "musicPcmDataList", "pcmDataList", "getAudioData", "input", "pcmData", "audioId", "channelCount", "inputEnd", "isAllPcmZero", "runMix", "startMix", "stopMix", "zipPcmDataTrack", "buffer", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a igT;
  public final String TAG;
  private int channels;
  private final int dtP;
  private final int igA;
  public long igB;
  private List<com.tencent.mm.audio.mix.a.e> igC;
  private List<com.tencent.mm.audio.mix.a.e> igD;
  public final List<com.tencent.mm.audio.mix.a.e> igE;
  public volatile boolean igF;
  public volatile boolean igG;
  public volatile boolean igH;
  public final Object igI;
  public final Object igJ;
  private int igK;
  private int igL;
  private boolean igM;
  private boolean igN;
  private final Runnable igO;
  private boolean igP;
  private final boolean igQ;
  private kotlin.g.a.a<x> igR;
  public m<? super byte[], ? super Long, x> igS;
  public final com.tencent.mm.audio.mix.f.e igz;
  private int index;
  private int sampleRate;
  
  static
  {
    AppMethodBeat.i(93714);
    igT = new a.a((byte)0);
    AppMethodBeat.o(93714);
  }
  
  public a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.a<x> parama, m<? super byte[], ? super Long, x> paramm)
  {
    AppMethodBeat.i(93713);
    this.sampleRate = paramInt1;
    this.channels = paramInt2;
    this.igP = paramBoolean1;
    this.igQ = paramBoolean2;
    this.igR = parama;
    this.igS = paramm;
    this.igz = new com.tencent.mm.audio.mix.f.e();
    this.dtP = 2;
    this.igA = 2048;
    this.igC = Collections.synchronizedList((List)new ArrayList());
    this.igD = Collections.synchronizedList((List)new ArrayList());
    this.igE = Collections.synchronizedList((List)new ArrayList());
    this.TAG = "MicroMsg.AudioMixCodec";
    this.igI = new Object();
    this.igJ = new Object();
    Log.i(this.TAG, "init AudioMixCodec, sampleRate:" + this.sampleRate + ", channels:" + this.channels + ", mixBackground:" + this.igP + ", mixMusic:" + this.igQ);
    this.igz.r(this.sampleRate, this.channels, this.dtP, this.igA * this.channels);
    this.igO = ((Runnable)new b(this));
    AppMethodBeat.o(93713);
  }
  
  private static boolean af(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    int i = 0;
    int j;
    if (i < k) {
      if (paramArrayOfByte[i] != 0)
      {
        j = 1;
        label18:
        if (j == 0) {
          break label35;
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label47;
      }
      return true;
      j = 0;
      break label18;
      label35:
      i += 1;
      break;
    }
    label47:
    return false;
  }
  
  public final void Hm(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(93711);
    p.h(paramString, "audioId");
    for (;;)
    {
      boolean bool;
      int i;
      synchronized (this.igI)
      {
        Log.i(this.TAG, "inputEnd, audioId:" + paramString + ", mixBackground:" + this.igP + ", mixMusic:" + this.igQ);
        if (p.j(paramString, "background")) {
          this.igM = true;
        }
        if (p.j(paramString, "music")) {
          this.igN = true;
        }
        if ((this.igP) && (this.igQ)) {
          if (this.igN)
          {
            bool = this.igM;
            if (bool)
            {
              i = j;
              if (i == 0) {}
            }
          }
        }
      }
      try
      {
        this.igH = true;
        Log.i(this.TAG, "notify mix");
        this.igI.notifyAll();
        label162:
        paramString = x.SXb;
        AppMethodBeat.o(93711);
        return;
        i = 0;
        continue;
        if (this.igP)
        {
          i = j;
          if (this.igM) {
            continue;
          }
        }
        if (this.igQ)
        {
          bool = this.igN;
          i = j;
          if (bool) {
            continue;
          }
        }
        i = 0;
        continue;
        paramString = finally;
        AppMethodBeat.o(93711);
        throw paramString;
      }
      catch (Exception paramString)
      {
        break label162;
      }
    }
  }
  
  /* Error */
  public final boolean a(byte[] paramArrayOfByte, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 404
    //   3: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 405
    //   10: invokestatic 129	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_2
    //   14: ldc_w 391
    //   17: invokestatic 129	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 177	com/tencent/mm/media/h/a:igI	Ljava/lang/Object;
    //   24: astore 7
    //   26: aload 7
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 175	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   33: new 181	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 407
    //   40: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: arraylength
    //   45: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc_w 409
    //   51: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 411
    //   61: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: iload 5
    //   66: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: ldc_w 413
    //   72: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 6
    //   77: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc_w 357
    //   83: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload_3
    //   87: invokevirtual 360	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: new 265	com/tencent/mm/audio/mix/a/e
    //   99: dup
    //   100: invokespecial 414	com/tencent/mm/audio/mix/a/e:<init>	()V
    //   103: astore 8
    //   105: aload 8
    //   107: aload_2
    //   108: putfield 333	com/tencent/mm/audio/mix/a/e:dtX	Ljava/lang/String;
    //   111: aload 8
    //   113: aload_1
    //   114: putfield 269	com/tencent/mm/audio/mix/a/e:dtQ	[B
    //   117: aload 8
    //   119: iload 5
    //   121: putfield 415	com/tencent/mm/audio/mix/a/e:sampleRate	I
    //   124: aload 8
    //   126: iload 6
    //   128: putfield 416	com/tencent/mm/audio/mix/a/e:channels	I
    //   131: aload 8
    //   133: lload_3
    //   134: putfield 341	com/tencent/mm/audio/mix/a/e:dua	J
    //   137: aload_2
    //   138: invokevirtual 419	java/lang/String:hashCode	()I
    //   141: lookupswitch	default:+412->553, -1332194002:+242->383, 104263205:+101->242
    //   169: getfield 141	com/tencent/mm/media/h/a:igQ	Z
    //   172: ifeq +311 -> 483
    //   175: aload_0
    //   176: getfield 139	com/tencent/mm/media/h/a:igP	Z
    //   179: ifeq +304 -> 483
    //   182: aload_0
    //   183: getfield 169	com/tencent/mm/media/h/a:igD	Ljava/util/List;
    //   186: invokeinterface 257 1 0
    //   191: ifle +36 -> 227
    //   194: aload_0
    //   195: getfield 167	com/tencent/mm/media/h/a:igC	Ljava/util/List;
    //   198: invokeinterface 257 1 0
    //   203: istore 5
    //   205: iload 5
    //   207: ifle +20 -> 227
    //   210: aload_0
    //   211: getfield 175	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   214: ldc_w 399
    //   217: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_0
    //   221: getfield 177	com/tencent/mm/media/h/a:igI	Ljava/lang/Object;
    //   224: invokevirtual 402	java/lang/Object:notifyAll	()V
    //   227: getstatic 290	kotlin/x:SXb	Lkotlin/x;
    //   230: astore_1
    //   231: aload 7
    //   233: monitorexit
    //   234: ldc_w 404
    //   237: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: iconst_1
    //   241: ireturn
    //   242: aload_2
    //   243: ldc_w 335
    //   246: invokevirtual 422	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq -81 -> 168
    //   252: aload_0
    //   253: getfield 175	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   256: new 181	java/lang/StringBuilder
    //   259: dup
    //   260: ldc_w 424
    //   263: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload_0
    //   267: getfield 169	com/tencent/mm/media/h/a:igD	Ljava/util/List;
    //   270: invokeinterface 257 1 0
    //   275: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_0
    //   285: getfield 169	com/tencent/mm/media/h/a:igD	Ljava/util/List;
    //   288: aload 8
    //   290: invokeinterface 277 2 0
    //   295: pop
    //   296: aload_0
    //   297: getfield 175	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   300: astore_1
    //   301: new 181	java/lang/StringBuilder
    //   304: dup
    //   305: ldc_w 426
    //   308: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: astore_2
    //   312: aload_0
    //   313: getfield 428	com/tencent/mm/media/h/a:igL	I
    //   316: istore 5
    //   318: aload_0
    //   319: iload 5
    //   321: iconst_1
    //   322: iadd
    //   323: putfield 428	com/tencent/mm/media/h/a:igL	I
    //   326: aload_1
    //   327: aload_2
    //   328: iload 5
    //   330: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: goto -171 -> 168
    //   342: astore_1
    //   343: aload_0
    //   344: getfield 175	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   347: aload_1
    //   348: checkcast 430	java/lang/Throwable
    //   351: ldc_w 431
    //   354: iconst_0
    //   355: anewarray 4	java/lang/Object
    //   358: invokestatic 435	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   361: getstatic 441	com/tencent/mm/media/k/e:ilC	Lcom/tencent/mm/media/k/e;
    //   364: astore_1
    //   365: invokestatic 444	com/tencent/mm/media/k/e:aOF	()V
    //   368: goto -141 -> 227
    //   371: astore_1
    //   372: aload 7
    //   374: monitorexit
    //   375: ldc_w 404
    //   378: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   381: aload_1
    //   382: athrow
    //   383: aload_2
    //   384: ldc_w 379
    //   387: invokevirtual 422	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   390: ifeq -222 -> 168
    //   393: aload_0
    //   394: getfield 175	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   397: new 181	java/lang/StringBuilder
    //   400: dup
    //   401: ldc_w 446
    //   404: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   407: aload_0
    //   408: getfield 167	com/tencent/mm/media/h/a:igC	Ljava/util/List;
    //   411: invokeinterface 257 1 0
    //   416: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload_0
    //   426: getfield 167	com/tencent/mm/media/h/a:igC	Ljava/util/List;
    //   429: aload 8
    //   431: invokeinterface 277 2 0
    //   436: pop
    //   437: aload_0
    //   438: getfield 175	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   441: astore_1
    //   442: new 181	java/lang/StringBuilder
    //   445: dup
    //   446: ldc_w 448
    //   449: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   452: astore_2
    //   453: aload_0
    //   454: getfield 450	com/tencent/mm/media/h/a:igK	I
    //   457: istore 5
    //   459: aload_0
    //   460: iload 5
    //   462: iconst_1
    //   463: iadd
    //   464: putfield 450	com/tencent/mm/media/h/a:igK	I
    //   467: aload_1
    //   468: aload_2
    //   469: iload 5
    //   471: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: goto -312 -> 168
    //   483: aload_0
    //   484: getfield 141	com/tencent/mm/media/h/a:igQ	Z
    //   487: ifne +10 -> 497
    //   490: aload_0
    //   491: getfield 139	com/tencent/mm/media/h/a:igP	Z
    //   494: ifeq -267 -> 227
    //   497: aload_0
    //   498: getfield 169	com/tencent/mm/media/h/a:igD	Ljava/util/List;
    //   501: invokeinterface 257 1 0
    //   506: ifgt +19 -> 525
    //   509: aload_0
    //   510: getfield 167	com/tencent/mm/media/h/a:igC	Ljava/util/List;
    //   513: invokeinterface 257 1 0
    //   518: istore 5
    //   520: iload 5
    //   522: ifle -295 -> 227
    //   525: aload_0
    //   526: getfield 175	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   529: ldc_w 399
    //   532: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: aload_0
    //   536: getfield 177	com/tencent/mm/media/h/a:igI	Ljava/lang/Object;
    //   539: invokevirtual 402	java/lang/Object:notifyAll	()V
    //   542: goto -315 -> 227
    //   545: astore_1
    //   546: goto -319 -> 227
    //   549: astore_1
    //   550: goto -323 -> 227
    //   553: goto -385 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	this	a
    //   0	556	1	paramArrayOfByte	byte[]
    //   0	556	2	paramString	String
    //   0	556	3	paramLong	long
    //   0	556	5	paramInt1	int
    //   0	556	6	paramInt2	int
    //   24	349	7	localObject	Object
    //   103	327	8	locale	com.tencent.mm.audio.mix.a.e
    // Exception table:
    //   from	to	target	type
    //   29	168	342	java/lang/Exception
    //   168	205	342	java/lang/Exception
    //   242	339	342	java/lang/Exception
    //   383	480	342	java/lang/Exception
    //   483	497	342	java/lang/Exception
    //   497	520	342	java/lang/Exception
    //   29	168	371	finally
    //   168	205	371	finally
    //   210	227	371	finally
    //   227	231	371	finally
    //   242	339	371	finally
    //   343	368	371	finally
    //   383	480	371	finally
    //   483	497	371	finally
    //   497	520	371	finally
    //   525	542	371	finally
    //   525	542	545	java/lang/Exception
    //   210	227	549	java/lang/Exception
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 33
      //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   9: invokestatic 43	com/tencent/mm/media/h/a:b	(Lcom/tencent/mm/media/h/a;)Z
      //   12: ifeq +472 -> 484
      //   15: aload_0
      //   16: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   19: invokestatic 47	com/tencent/mm/media/h/a:d	(Lcom/tencent/mm/media/h/a;)Ljava/lang/Object;
      //   22: astore_2
      //   23: aload_2
      //   24: monitorenter
      //   25: aload_0
      //   26: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   29: invokestatic 47	com/tencent/mm/media/h/a:d	(Lcom/tencent/mm/media/h/a;)Ljava/lang/Object;
      //   32: invokevirtual 50	java/lang/Object:wait	()V
      //   35: getstatic 56	kotlin/x:SXb	Lkotlin/x;
      //   38: astore_3
      //   39: aload_2
      //   40: monitorexit
      //   41: aload_0
      //   42: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   45: invokestatic 60	com/tencent/mm/media/h/a:e	(Lcom/tencent/mm/media/h/a;)Ljava/lang/String;
      //   48: new 62	java/lang/StringBuilder
      //   51: dup
      //   52: ldc 64
      //   54: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   57: aload_0
      //   58: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   61: invokestatic 70	com/tencent/mm/media/h/a:f	(Lcom/tencent/mm/media/h/a;)Z
      //   64: invokevirtual 74	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   67: ldc 76
      //   69: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: aload_0
      //   73: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   76: invokestatic 82	com/tencent/mm/media/h/a:g	(Lcom/tencent/mm/media/h/a;)Z
      //   79: invokevirtual 74	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   82: ldc 84
      //   84: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   87: aload_0
      //   88: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   91: invokestatic 88	com/tencent/mm/media/h/a:h	(Lcom/tencent/mm/media/h/a;)Ljava/util/List;
      //   94: invokeinterface 94 1 0
      //   99: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   102: ldc 99
      //   104: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   107: aload_0
      //   108: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   111: invokestatic 101	com/tencent/mm/media/h/a:i	(Lcom/tencent/mm/media/h/a;)Ljava/util/List;
      //   114: invokeinterface 94 1 0
      //   119: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   122: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   125: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   128: aload_0
      //   129: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   132: invokestatic 113	com/tencent/mm/media/h/a:j	(Lcom/tencent/mm/media/h/a;)Ljava/lang/Object;
      //   135: astore_2
      //   136: aload_2
      //   137: monitorenter
      //   138: aload_0
      //   139: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   142: invokestatic 101	com/tencent/mm/media/h/a:i	(Lcom/tencent/mm/media/h/a;)Ljava/util/List;
      //   145: invokeinterface 94 1 0
      //   150: ifgt +18 -> 168
      //   153: aload_0
      //   154: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   157: invokestatic 88	com/tencent/mm/media/h/a:h	(Lcom/tencent/mm/media/h/a;)Ljava/util/List;
      //   160: invokeinterface 94 1 0
      //   165: ifle +254 -> 419
      //   168: aload_0
      //   169: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   172: invokestatic 70	com/tencent/mm/media/h/a:f	(Lcom/tencent/mm/media/h/a;)Z
      //   175: ifeq +124 -> 299
      //   178: aload_0
      //   179: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   182: invokestatic 82	com/tencent/mm/media/h/a:g	(Lcom/tencent/mm/media/h/a;)Z
      //   185: ifeq +114 -> 299
      //   188: aload_0
      //   189: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   192: invokestatic 101	com/tencent/mm/media/h/a:i	(Lcom/tencent/mm/media/h/a;)Ljava/util/List;
      //   195: invokeinterface 94 1 0
      //   200: ifle +219 -> 419
      //   203: aload_0
      //   204: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   207: invokestatic 88	com/tencent/mm/media/h/a:h	(Lcom/tencent/mm/media/h/a;)Ljava/util/List;
      //   210: invokeinterface 94 1 0
      //   215: ifle +204 -> 419
      //   218: aload_0
      //   219: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   222: invokestatic 117	com/tencent/mm/media/h/a:k	(Lcom/tencent/mm/media/h/a;)Lkotlin/g/a/a;
      //   225: invokeinterface 123 1 0
      //   230: pop
      //   231: iconst_0
      //   232: istore_1
      //   233: iload_1
      //   234: ifgt +175 -> 409
      //   237: aload_0
      //   238: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   241: invokestatic 126	com/tencent/mm/media/h/a:l	(Lcom/tencent/mm/media/h/a;)V
      //   244: aload_0
      //   245: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   248: invokestatic 129	com/tencent/mm/media/h/a:m	(Lcom/tencent/mm/media/h/a;)V
      //   251: iload_1
      //   252: iconst_1
      //   253: iadd
      //   254: istore_1
      //   255: goto -22 -> 233
      //   258: astore_3
      //   259: aload_2
      //   260: monitorexit
      //   261: ldc 33
      //   263: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   266: aload_3
      //   267: athrow
      //   268: astore_2
      //   269: aload_0
      //   270: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   273: invokestatic 60	com/tencent/mm/media/h/a:e	(Lcom/tencent/mm/media/h/a;)Ljava/lang/String;
      //   276: aload_2
      //   277: checkcast 134	java/lang/Throwable
      //   280: ldc 135
      //   282: iconst_0
      //   283: anewarray 4	java/lang/Object
      //   286: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   289: getstatic 145	com/tencent/mm/media/k/e:ilC	Lcom/tencent/mm/media/k/e;
      //   292: astore_2
      //   293: invokestatic 148	com/tencent/mm/media/k/e:aOF	()V
      //   296: goto -291 -> 5
      //   299: aload_0
      //   300: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   303: invokestatic 70	com/tencent/mm/media/h/a:f	(Lcom/tencent/mm/media/h/a;)Z
      //   306: ifne +13 -> 319
      //   309: aload_0
      //   310: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   313: invokestatic 82	com/tencent/mm/media/h/a:g	(Lcom/tencent/mm/media/h/a;)Z
      //   316: ifeq +93 -> 409
      //   319: aload_0
      //   320: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   323: invokestatic 117	com/tencent/mm/media/h/a:k	(Lcom/tencent/mm/media/h/a;)Lkotlin/g/a/a;
      //   326: invokeinterface 123 1 0
      //   331: pop
      //   332: iconst_0
      //   333: istore_1
      //   334: iload_1
      //   335: ifgt +24 -> 359
      //   338: aload_0
      //   339: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   342: invokestatic 126	com/tencent/mm/media/h/a:l	(Lcom/tencent/mm/media/h/a;)V
      //   345: aload_0
      //   346: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   349: invokestatic 129	com/tencent/mm/media/h/a:m	(Lcom/tencent/mm/media/h/a;)V
      //   352: iload_1
      //   353: iconst_1
      //   354: iadd
      //   355: istore_1
      //   356: goto -22 -> 334
      //   359: aload_0
      //   360: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   363: invokestatic 82	com/tencent/mm/media/h/a:g	(Lcom/tencent/mm/media/h/a;)Z
      //   366: ifeq +18 -> 384
      //   369: aload_0
      //   370: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   373: invokestatic 88	com/tencent/mm/media/h/a:h	(Lcom/tencent/mm/media/h/a;)Ljava/util/List;
      //   376: invokeinterface 94 1 0
      //   381: ifle +38 -> 419
      //   384: aload_0
      //   385: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   388: invokestatic 70	com/tencent/mm/media/h/a:f	(Lcom/tencent/mm/media/h/a;)Z
      //   391: ifeq +18 -> 409
      //   394: aload_0
      //   395: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   398: invokestatic 101	com/tencent/mm/media/h/a:i	(Lcom/tencent/mm/media/h/a;)Ljava/util/List;
      //   401: invokeinterface 94 1 0
      //   406: ifle +13 -> 419
      //   409: aload_0
      //   410: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   413: invokestatic 151	com/tencent/mm/media/h/a:n	(Lcom/tencent/mm/media/h/a;)Z
      //   416: ifne -278 -> 138
      //   419: aload_0
      //   420: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   423: invokestatic 151	com/tencent/mm/media/h/a:n	(Lcom/tencent/mm/media/h/a;)Z
      //   426: ifeq +39 -> 465
      //   429: aload_0
      //   430: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   433: invokestatic 60	com/tencent/mm/media/h/a:e	(Lcom/tencent/mm/media/h/a;)Ljava/lang/String;
      //   436: ldc 153
      //   438: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   441: aload_0
      //   442: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   445: invokestatic 156	com/tencent/mm/media/h/a:c	(Lcom/tencent/mm/media/h/a;)V
      //   448: aload_0
      //   449: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   452: invokestatic 158	com/tencent/mm/media/h/a:o	(Lcom/tencent/mm/media/h/a;)V
      //   455: aload_0
      //   456: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   459: invokestatic 113	com/tencent/mm/media/h/a:j	(Lcom/tencent/mm/media/h/a;)Ljava/lang/Object;
      //   462: invokevirtual 161	java/lang/Object:notifyAll	()V
      //   465: getstatic 56	kotlin/x:SXb	Lkotlin/x;
      //   468: astore_3
      //   469: aload_2
      //   470: monitorexit
      //   471: goto -466 -> 5
      //   474: astore_3
      //   475: aload_2
      //   476: monitorexit
      //   477: ldc 33
      //   479: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   482: aload_3
      //   483: athrow
      //   484: aload_0
      //   485: getfield 26	com/tencent/mm/media/h/a$b:igU	Lcom/tencent/mm/media/h/a;
      //   488: invokestatic 60	com/tencent/mm/media/h/a:e	(Lcom/tencent/mm/media/h/a;)Ljava/lang/String;
      //   491: ldc 163
      //   493: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   496: ldc 33
      //   498: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   501: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	502	0	this	b
      //   232	124	1	i	int
      //   268	9	2	localException	Exception
      //   292	184	2	locale	com.tencent.mm.media.k.e
      //   38	1	3	localx1	x
      //   258	9	3	localObject2	Object
      //   468	1	3	localx2	x
      //   474	9	3	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   25	39	258	finally
      //   15	25	268	java/lang/Exception
      //   39	138	268	java/lang/Exception
      //   259	268	268	java/lang/Exception
      //   469	471	268	java/lang/Exception
      //   475	484	268	java/lang/Exception
      //   138	168	474	finally
      //   168	231	474	finally
      //   237	251	474	finally
      //   299	319	474	finally
      //   319	332	474	finally
      //   338	352	474	finally
      //   359	384	474	finally
      //   384	409	474	finally
      //   409	419	474	finally
      //   419	465	474	finally
      //   465	469	474	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.h.a
 * JD-Core Version:    0.7.0.1
 */