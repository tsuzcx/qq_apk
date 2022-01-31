package com.tencent.mm.media.f;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/mix/AudioMixCodec;", "", "sampleRate", "", "channels", "mixBackground", "", "mixMusic", "frameMix", "Lkotlin/Function0;", "", "frameMixEnd", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "data", "", "pts", "(IIZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "backgroundFrameCount", "backgroundPcmDataList", "", "Lcom/tencent/mm/audio/mix/buffer/PcmDataTrack;", "kotlin.jvm.PlatformType", "", "bitDepth", "flushAllData", "flushLock", "Ljava/lang/Object;", "frameLength", "index", "isBackgroundEnd", "isMixing", "isMixingFinish", "isMusicEnd", "mAudioSyncMixController", "Lcom/tencent/mm/audio/mix/mix/AudioSyncMixController;", "mMixRunnable", "Ljava/lang/Runnable;", "mPts", "mixLock", "musicFrameCount", "musicPcmDataList", "pcmDataList", "getAudioData", "input", "pcmData", "audioId", "channelCount", "inputEnd", "runMix", "startMix", "stopMix", "zipPcmDataTrack", "buffer", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a eVu;
  public final String TAG;
  private final int cel;
  private int channels;
  public final e eVa;
  private final int eVb;
  public long eVc;
  private List<d> eVd;
  private List<d> eVe;
  public final List<d> eVf;
  public volatile boolean eVg;
  public volatile boolean eVh;
  public volatile boolean eVi;
  public final Object eVj;
  public final Object eVk;
  private int eVl;
  private int eVm;
  private boolean eVn;
  private boolean eVo;
  private final Runnable eVp;
  private final boolean eVq;
  private final boolean eVr;
  private a.f.a.a<y> eVs;
  public m<? super byte[], ? super Long, y> eVt;
  private int index;
  private int sampleRate;
  
  static
  {
    AppMethodBeat.i(12987);
    eVu = new a.a((byte)0);
    AppMethodBeat.o(12987);
  }
  
  public a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, a.f.a.a<y> parama, m<? super byte[], ? super Long, y> paramm)
  {
    AppMethodBeat.i(12986);
    this.sampleRate = paramInt1;
    this.channels = paramInt2;
    this.eVq = paramBoolean1;
    this.eVr = paramBoolean2;
    this.eVs = parama;
    this.eVt = paramm;
    this.eVa = new e();
    this.cel = 2;
    this.eVb = 2048;
    this.eVd = Collections.synchronizedList((List)new ArrayList());
    this.eVe = Collections.synchronizedList((List)new ArrayList());
    this.eVf = Collections.synchronizedList((List)new ArrayList());
    this.TAG = "MicroMsg.AudioMixCodec";
    this.eVj = new Object();
    this.eVk = new Object();
    ab.i(this.TAG, "init AudioMixCodec, sampleRate:" + this.sampleRate + ", channels:" + this.channels + ", mixBackground:" + this.eVq + ", mixMusic:" + this.eVr);
    this.eVa.q(this.sampleRate, this.channels, this.cel, this.eVb * this.channels);
    this.eVp = ((Runnable)new a.b(this));
    AppMethodBeat.o(12986);
  }
  
  /* Error */
  public final boolean a(byte[] paramArrayOfByte, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 12985
    //   3: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 358
    //   10: invokestatic 125	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_2
    //   14: ldc_w 359
    //   17: invokestatic 125	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 172	com/tencent/mm/media/f/a:eVj	Ljava/lang/Object;
    //   24: astore 7
    //   26: aload 7
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 170	com/tencent/mm/media/f/a:TAG	Ljava/lang/String;
    //   33: new 176	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 361
    //   40: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: arraylength
    //   45: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc_w 363
    //   51: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 365
    //   61: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: iload 5
    //   66: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: ldc_w 367
    //   72: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 6
    //   77: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc_w 369
    //   83: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload_3
    //   87: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 206	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: new 260	com/tencent/mm/audio/mix/a/d
    //   99: dup
    //   100: invokespecial 370	com/tencent/mm/audio/mix/a/d:<init>	()V
    //   103: astore 8
    //   105: aload 8
    //   107: aload_2
    //   108: putfield 317	com/tencent/mm/audio/mix/a/d:ceu	Ljava/lang/String;
    //   111: aload 8
    //   113: aload_1
    //   114: putfield 374	com/tencent/mm/audio/mix/a/d:cem	[B
    //   117: aload 8
    //   119: iload 5
    //   121: putfield 375	com/tencent/mm/audio/mix/a/d:sampleRate	I
    //   124: aload 8
    //   126: iload 6
    //   128: putfield 376	com/tencent/mm/audio/mix/a/d:channels	I
    //   131: aload 8
    //   133: lload_3
    //   134: putfield 325	com/tencent/mm/audio/mix/a/d:cex	J
    //   137: aload_2
    //   138: invokevirtual 381	java/lang/String:hashCode	()I
    //   141: lookupswitch	default:+412->553, -1332194002:+242->383, 104263205:+101->242
    //   169: getfield 136	com/tencent/mm/media/f/a:eVr	Z
    //   172: ifeq +311 -> 483
    //   175: aload_0
    //   176: getfield 134	com/tencent/mm/media/f/a:eVq	Z
    //   179: ifeq +304 -> 483
    //   182: aload_0
    //   183: getfield 164	com/tencent/mm/media/f/a:eVe	Ljava/util/List;
    //   186: invokeinterface 252 1 0
    //   191: ifle +36 -> 227
    //   194: aload_0
    //   195: getfield 162	com/tencent/mm/media/f/a:eVd	Ljava/util/List;
    //   198: invokeinterface 252 1 0
    //   203: istore 5
    //   205: iload 5
    //   207: ifle +20 -> 227
    //   210: aload_0
    //   211: getfield 170	com/tencent/mm/media/f/a:TAG	Ljava/lang/String;
    //   214: ldc_w 383
    //   217: invokestatic 206	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_0
    //   221: getfield 172	com/tencent/mm/media/f/a:eVj	Ljava/lang/Object;
    //   224: invokevirtual 386	java/lang/Object:notifyAll	()V
    //   227: getstatic 277	a/y:BMg	La/y;
    //   230: astore_1
    //   231: aload 7
    //   233: monitorexit
    //   234: sipush 12985
    //   237: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: iconst_1
    //   241: ireturn
    //   242: aload_2
    //   243: ldc_w 319
    //   246: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq -81 -> 168
    //   252: aload_0
    //   253: getfield 170	com/tencent/mm/media/f/a:TAG	Ljava/lang/String;
    //   256: new 176	java/lang/StringBuilder
    //   259: dup
    //   260: ldc_w 391
    //   263: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload_0
    //   267: getfield 164	com/tencent/mm/media/f/a:eVe	Ljava/util/List;
    //   270: invokeinterface 252 1 0
    //   275: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 206	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_0
    //   285: getfield 164	com/tencent/mm/media/f/a:eVe	Ljava/util/List;
    //   288: aload 8
    //   290: invokeinterface 264 2 0
    //   295: pop
    //   296: aload_0
    //   297: getfield 170	com/tencent/mm/media/f/a:TAG	Ljava/lang/String;
    //   300: astore_1
    //   301: new 176	java/lang/StringBuilder
    //   304: dup
    //   305: ldc_w 393
    //   308: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: astore_2
    //   312: aload_0
    //   313: getfield 395	com/tencent/mm/media/f/a:eVm	I
    //   316: istore 5
    //   318: aload_0
    //   319: iload 5
    //   321: iconst_1
    //   322: iadd
    //   323: putfield 395	com/tencent/mm/media/f/a:eVm	I
    //   326: aload_1
    //   327: aload_2
    //   328: iload 5
    //   330: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 206	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: goto -171 -> 168
    //   342: astore_1
    //   343: aload_0
    //   344: getfield 170	com/tencent/mm/media/f/a:TAG	Ljava/lang/String;
    //   347: aload_1
    //   348: checkcast 397	java/lang/Throwable
    //   351: ldc_w 398
    //   354: iconst_0
    //   355: anewarray 4	java/lang/Object
    //   358: invokestatic 402	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   361: getstatic 408	com/tencent/mm/media/i/c:eZC	Lcom/tencent/mm/media/i/c;
    //   364: astore_1
    //   365: invokestatic 411	com/tencent/mm/media/i/c:Wq	()V
    //   368: goto -141 -> 227
    //   371: astore_1
    //   372: aload 7
    //   374: monitorexit
    //   375: sipush 12985
    //   378: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   381: aload_1
    //   382: athrow
    //   383: aload_2
    //   384: ldc_w 413
    //   387: invokevirtual 389	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   390: ifeq -222 -> 168
    //   393: aload_0
    //   394: getfield 170	com/tencent/mm/media/f/a:TAG	Ljava/lang/String;
    //   397: new 176	java/lang/StringBuilder
    //   400: dup
    //   401: ldc_w 415
    //   404: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   407: aload_0
    //   408: getfield 162	com/tencent/mm/media/f/a:eVd	Ljava/util/List;
    //   411: invokeinterface 252 1 0
    //   416: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 206	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload_0
    //   426: getfield 162	com/tencent/mm/media/f/a:eVd	Ljava/util/List;
    //   429: aload 8
    //   431: invokeinterface 264 2 0
    //   436: pop
    //   437: aload_0
    //   438: getfield 170	com/tencent/mm/media/f/a:TAG	Ljava/lang/String;
    //   441: astore_1
    //   442: new 176	java/lang/StringBuilder
    //   445: dup
    //   446: ldc_w 417
    //   449: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   452: astore_2
    //   453: aload_0
    //   454: getfield 419	com/tencent/mm/media/f/a:eVl	I
    //   457: istore 5
    //   459: aload_0
    //   460: iload 5
    //   462: iconst_1
    //   463: iadd
    //   464: putfield 419	com/tencent/mm/media/f/a:eVl	I
    //   467: aload_1
    //   468: aload_2
    //   469: iload 5
    //   471: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 206	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: goto -312 -> 168
    //   483: aload_0
    //   484: getfield 136	com/tencent/mm/media/f/a:eVr	Z
    //   487: ifne +10 -> 497
    //   490: aload_0
    //   491: getfield 134	com/tencent/mm/media/f/a:eVq	Z
    //   494: ifeq -267 -> 227
    //   497: aload_0
    //   498: getfield 164	com/tencent/mm/media/f/a:eVe	Ljava/util/List;
    //   501: invokeinterface 252 1 0
    //   506: ifgt +19 -> 525
    //   509: aload_0
    //   510: getfield 162	com/tencent/mm/media/f/a:eVd	Ljava/util/List;
    //   513: invokeinterface 252 1 0
    //   518: istore 5
    //   520: iload 5
    //   522: ifle -295 -> 227
    //   525: aload_0
    //   526: getfield 170	com/tencent/mm/media/f/a:TAG	Ljava/lang/String;
    //   529: ldc_w 383
    //   532: invokestatic 206	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: aload_0
    //   536: getfield 172	com/tencent/mm/media/f/a:eVj	Ljava/lang/Object;
    //   539: invokevirtual 386	java/lang/Object:notifyAll	()V
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
    //   103	327	8	locald	d
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
  
  public final void mO(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(12984);
    j.q(paramString, "audioId");
    for (;;)
    {
      boolean bool;
      int i;
      synchronized (this.eVj)
      {
        ab.i(this.TAG, "inputEnd, audioId:" + paramString + ", mixBackground:" + this.eVq + ", mixMusic:" + this.eVr);
        if (j.e(paramString, "background")) {
          this.eVn = true;
        }
        if (j.e(paramString, "music")) {
          this.eVo = true;
        }
        if ((this.eVq) && (this.eVr)) {
          if (this.eVo)
          {
            bool = this.eVn;
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
        this.eVi = true;
        ab.i(this.TAG, "notify mix");
        this.eVj.notifyAll();
        label162:
        paramString = y.BMg;
        AppMethodBeat.o(12984);
        return;
        i = 0;
        continue;
        if (this.eVq)
        {
          i = j;
          if (this.eVn) {
            continue;
          }
        }
        if (this.eVr)
        {
          bool = this.eVo;
          i = j;
          if (bool) {
            continue;
          }
        }
        i = 0;
        continue;
        paramString = finally;
        AppMethodBeat.o(12984);
        throw paramString;
      }
      catch (Exception paramString)
      {
        break label162;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.f.a
 * JD-Core Version:    0.7.0.1
 */