package com.tencent.mm.media.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/mix/AudioMixCodec;", "", "sampleRate", "", "channels", "mixBackground", "", "mixMusic", "frameMix", "Lkotlin/Function0;", "", "frameMixEnd", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "data", "", "pts", "(IIZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "backgroundFrameCount", "backgroundPcmDataList", "", "Lcom/tencent/mm/audio/mix/buffer/PcmDataTrack;", "kotlin.jvm.PlatformType", "", "bitDepth", "flushAllData", "flushLock", "Ljava/lang/Object;", "frameLength", "index", "isBackgroundEnd", "isMixing", "isMixingFinish", "isMusicEnd", "mAudioSyncMixController", "Lcom/tencent/mm/audio/mix/mix/AudioSyncMixController;", "mMixRunnable", "Ljava/lang/Runnable;", "mPts", "mixLock", "musicFrameCount", "musicPcmDataList", "pcmDataList", "getAudioData", "input", "pcmData", "audioId", "channelCount", "inputEnd", "isAllPcmZero", "runMix", "startMix", "stopMix", "zipPcmDataTrack", "buffer", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a nAH;
  public final String TAG;
  private int channels;
  private final int hqI;
  private int index;
  private boolean nAI;
  private final boolean nAJ;
  private kotlin.g.a.a<ah> nAK;
  public m<? super byte[], ? super Long, ah> nAL;
  public final com.tencent.mm.audio.mix.e.e nAM;
  private final int nAN;
  public long nAO;
  private List<com.tencent.mm.audio.mix.a.e> nAP;
  private List<com.tencent.mm.audio.mix.a.e> nAQ;
  public final List<com.tencent.mm.audio.mix.a.e> nAR;
  public volatile boolean nAS;
  public volatile boolean nAT;
  public volatile boolean nAU;
  public final Object nAV;
  public final Object nAW;
  private int nAX;
  private int nAY;
  private boolean nAZ;
  private boolean nBa;
  private final Runnable nBb;
  private int sampleRate;
  
  static
  {
    AppMethodBeat.i(93714);
    nAH = new a.a((byte)0);
    AppMethodBeat.o(93714);
  }
  
  public a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.a<ah> parama, m<? super byte[], ? super Long, ah> paramm)
  {
    AppMethodBeat.i(93713);
    this.sampleRate = paramInt1;
    this.channels = paramInt2;
    this.nAI = paramBoolean1;
    this.nAJ = paramBoolean2;
    this.nAK = parama;
    this.nAL = paramm;
    this.nAM = new com.tencent.mm.audio.mix.e.e();
    this.hqI = 2;
    this.nAN = 2048;
    this.nAP = Collections.synchronizedList((List)new ArrayList());
    this.nAQ = Collections.synchronizedList((List)new ArrayList());
    this.nAR = Collections.synchronizedList((List)new ArrayList());
    this.TAG = "MicroMsg.AudioMixCodec";
    this.nAV = new Object();
    this.nAW = new Object();
    Log.i(this.TAG, "init AudioMixCodec, sampleRate:" + this.sampleRate + ", channels:" + this.channels + ", mixBackground:" + this.nAI + ", mixMusic:" + this.nAJ);
    parama = this.nAM;
    paramInt2 = this.sampleRate;
    int i = this.channels;
    paramInt1 = this.hqI;
    int j = this.nAN;
    int k = this.channels;
    b.i("MicroMsg.Mix.AudioSyncMixController", "init, outSample:%d, outChannel:%d, outBitDepth:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt1) });
    parama.htv = paramInt2;
    parama.htw = i;
    parama.htx = paramInt1;
    parama.hty = (j * k);
    if (parama.hty <= 0) {
      if (2 != paramInt1) {
        break label371;
      }
    }
    label371:
    for (paramInt1 = 16;; paramInt1 = 8)
    {
      parama.hty = (paramInt1 * (paramInt2 * i) * 20 / 8 / 1000);
      this.nBb = new a..ExternalSyntheticLambda0(this);
      AppMethodBeat.o(93713);
      return;
    }
  }
  
  /* Error */
  private static final void a(a parama)
  {
    // Byte code:
    //   0: ldc_w 256
    //   3: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 258
    //   10: invokestatic 136	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 260	com/tencent/mm/media/h/a:nAT	Z
    //   17: ifeq +361 -> 378
    //   20: aload_0
    //   21: getfield 184	com/tencent/mm/media/h/a:nAV	Ljava/lang/Object;
    //   24: astore_2
    //   25: aload_2
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 184	com/tencent/mm/media/h/a:nAV	Ljava/lang/Object;
    //   31: invokevirtual 263	java/lang/Object:wait	()V
    //   34: getstatic 269	kotlin/ah:aiuX	Lkotlin/ah;
    //   37: astore_3
    //   38: aload_2
    //   39: monitorexit
    //   40: aload_0
    //   41: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   44: new 188	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 271
    //   51: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 146	com/tencent/mm/media/h/a:nAI	Z
    //   58: invokevirtual 207	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: ldc 209
    //   63: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: getfield 148	com/tencent/mm/media/h/a:nAJ	Z
    //   70: invokevirtual 207	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   73: ldc_w 273
    //   76: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   83: invokeinterface 277 1 0
    //   88: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: ldc_w 279
    //   94: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   101: invokeinterface 277 1 0
    //   106: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 186	com/tencent/mm/media/h/a:nAW	Ljava/lang/Object;
    //   119: astore_2
    //   120: aload_2
    //   121: monitorenter
    //   122: aload_0
    //   123: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   126: invokeinterface 277 1 0
    //   131: ifgt +15 -> 146
    //   134: aload_0
    //   135: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   138: invokeinterface 277 1 0
    //   143: ifle +66 -> 209
    //   146: aload_0
    //   147: getfield 146	com/tencent/mm/media/h/a:nAI	Z
    //   150: ifeq +142 -> 292
    //   153: aload_0
    //   154: getfield 148	com/tencent/mm/media/h/a:nAJ	Z
    //   157: ifeq +135 -> 292
    //   160: aload_0
    //   161: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   164: invokeinterface 277 1 0
    //   169: ifle +40 -> 209
    //   172: aload_0
    //   173: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   176: invokeinterface 277 1 0
    //   181: ifle +28 -> 209
    //   184: aload_0
    //   185: getfield 150	com/tencent/mm/media/h/a:nAK	Lkotlin/g/a/a;
    //   188: invokeinterface 285 1 0
    //   193: pop
    //   194: aload_0
    //   195: invokespecial 288	com/tencent/mm/media/h/a:bpB	()V
    //   198: aload_0
    //   199: invokespecial 291	com/tencent/mm/media/h/a:bpC	()V
    //   202: aload_0
    //   203: getfield 293	com/tencent/mm/media/h/a:nAU	Z
    //   206: ifne -84 -> 122
    //   209: aload_0
    //   210: getfield 293	com/tencent/mm/media/h/a:nAU	Z
    //   213: ifeq +30 -> 243
    //   216: aload_0
    //   217: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   220: ldc_w 295
    //   223: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: iconst_0
    //   228: putfield 260	com/tencent/mm/media/h/a:nAT	Z
    //   231: aload_0
    //   232: iconst_1
    //   233: putfield 297	com/tencent/mm/media/h/a:nAS	Z
    //   236: aload_0
    //   237: getfield 186	com/tencent/mm/media/h/a:nAW	Ljava/lang/Object;
    //   240: invokevirtual 300	java/lang/Object:notifyAll	()V
    //   243: getstatic 269	kotlin/ah:aiuX	Lkotlin/ah;
    //   246: astore_3
    //   247: aload_2
    //   248: monitorexit
    //   249: goto -236 -> 13
    //   252: astore_2
    //   253: aload_0
    //   254: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   257: aload_2
    //   258: checkcast 302	java/lang/Throwable
    //   261: ldc_w 303
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: getstatic 313	com/tencent/mm/media/util/f:nFE	Lcom/tencent/mm/media/util/f;
    //   274: astore_2
    //   275: invokestatic 316	com/tencent/mm/media/util/f:brR	()V
    //   278: goto -265 -> 13
    //   281: astore_3
    //   282: aload_2
    //   283: monitorexit
    //   284: ldc_w 256
    //   287: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload_3
    //   291: athrow
    //   292: aload_0
    //   293: getfield 146	com/tencent/mm/media/h/a:nAI	Z
    //   296: ifne +10 -> 306
    //   299: aload_0
    //   300: getfield 148	com/tencent/mm/media/h/a:nAJ	Z
    //   303: ifeq -101 -> 202
    //   306: aload_0
    //   307: getfield 150	com/tencent/mm/media/h/a:nAK	Lkotlin/g/a/a;
    //   310: invokeinterface 285 1 0
    //   315: pop
    //   316: aload_0
    //   317: invokespecial 288	com/tencent/mm/media/h/a:bpB	()V
    //   320: aload_0
    //   321: invokespecial 291	com/tencent/mm/media/h/a:bpC	()V
    //   324: aload_0
    //   325: getfield 148	com/tencent/mm/media/h/a:nAJ	Z
    //   328: ifeq +15 -> 343
    //   331: aload_0
    //   332: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   335: invokeinterface 277 1 0
    //   340: ifle -131 -> 209
    //   343: aload_0
    //   344: getfield 146	com/tencent/mm/media/h/a:nAI	Z
    //   347: ifeq -145 -> 202
    //   350: aload_0
    //   351: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   354: invokeinterface 277 1 0
    //   359: istore_1
    //   360: iload_1
    //   361: ifgt -159 -> 202
    //   364: goto -155 -> 209
    //   367: astore_3
    //   368: aload_2
    //   369: monitorexit
    //   370: ldc_w 256
    //   373: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   376: aload_3
    //   377: athrow
    //   378: aload_0
    //   379: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   382: ldc_w 318
    //   385: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: ldc_w 256
    //   391: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	parama	a
    //   359	2	1	i	int
    //   252	6	2	localException	Exception
    //   274	95	2	localf	com.tencent.mm.media.util.f
    //   37	210	3	localah	ah
    //   281	10	3	localObject2	Object
    //   367	10	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	27	252	java/lang/Exception
    //   38	122	252	java/lang/Exception
    //   247	249	252	java/lang/Exception
    //   282	292	252	java/lang/Exception
    //   368	378	252	java/lang/Exception
    //   27	38	281	finally
    //   122	146	367	finally
    //   146	202	367	finally
    //   202	209	367	finally
    //   209	243	367	finally
    //   243	247	367	finally
    //   292	306	367	finally
    //   306	343	367	finally
    //   343	360	367	finally
  }
  
  private static boolean ao(byte[] paramArrayOfByte)
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
  
  /* Error */
  private final void bpB()
  {
    // Byte code:
    //   0: ldc_w 323
    //   3: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 178	com/tencent/mm/media/h/a:nAR	Ljava/util/List;
    //   10: astore_2
    //   11: aload_2
    //   12: ldc_w 324
    //   15: invokestatic 327	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_2
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 178	com/tencent/mm/media/h/a:nAR	Ljava/util/List;
    //   24: invokeinterface 330 1 0
    //   29: aload_0
    //   30: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   33: new 188	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 332
    //   40: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   47: invokeinterface 277 1 0
    //   52: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc_w 273
    //   58: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   65: invokeinterface 277 1 0
    //   70: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: getfield 146	com/tencent/mm/media/h/a:nAI	Z
    //   83: ifeq +87 -> 170
    //   86: aload_0
    //   87: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   90: invokeinterface 277 1 0
    //   95: ifle +75 -> 170
    //   98: aload_0
    //   99: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   102: iconst_0
    //   103: invokeinterface 336 2 0
    //   108: checkcast 338	com/tencent/mm/audio/mix/a/e
    //   111: astore_3
    //   112: aload_3
    //   113: getfield 342	com/tencent/mm/audio/mix/a/e:hqJ	[B
    //   116: astore 4
    //   118: aload 4
    //   120: ldc_w 344
    //   123: invokestatic 327	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   126: aload 4
    //   128: invokestatic 346	com/tencent/mm/media/h/a:ao	([B)Z
    //   131: ifeq +17 -> 148
    //   134: aload_0
    //   135: getfield 146	com/tencent/mm/media/h/a:nAI	Z
    //   138: ifeq +131 -> 269
    //   141: aload_0
    //   142: getfield 148	com/tencent/mm/media/h/a:nAJ	Z
    //   145: ifne +124 -> 269
    //   148: aload_0
    //   149: getfield 178	com/tencent/mm/media/h/a:nAR	Ljava/util/List;
    //   152: aload_3
    //   153: invokeinterface 350 2 0
    //   158: pop
    //   159: aload_0
    //   160: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   163: aload_3
    //   164: invokeinterface 353 2 0
    //   169: pop
    //   170: aload_0
    //   171: getfield 148	com/tencent/mm/media/h/a:nAJ	Z
    //   174: ifeq +51 -> 225
    //   177: aload_0
    //   178: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   181: invokeinterface 277 1 0
    //   186: ifle +39 -> 225
    //   189: aload_0
    //   190: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   193: iconst_0
    //   194: invokeinterface 336 2 0
    //   199: checkcast 338	com/tencent/mm/audio/mix/a/e
    //   202: astore_3
    //   203: aload_0
    //   204: getfield 178	com/tencent/mm/media/h/a:nAR	Ljava/util/List;
    //   207: aload_3
    //   208: invokeinterface 350 2 0
    //   213: pop
    //   214: aload_0
    //   215: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   218: aload_3
    //   219: invokeinterface 353 2 0
    //   224: pop
    //   225: aload_0
    //   226: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   229: astore_3
    //   230: aload_0
    //   231: getfield 355	com/tencent/mm/media/h/a:index	I
    //   234: istore_1
    //   235: aload_0
    //   236: iload_1
    //   237: iconst_1
    //   238: iadd
    //   239: putfield 355	com/tencent/mm/media/h/a:index	I
    //   242: aload_3
    //   243: ldc_w 357
    //   246: iload_1
    //   247: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   250: invokestatic 361	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   253: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: getstatic 269	kotlin/ah:aiuX	Lkotlin/ah;
    //   259: astore_3
    //   260: aload_2
    //   261: monitorexit
    //   262: ldc_w 323
    //   265: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: return
    //   269: aload_0
    //   270: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   273: ldc_w 363
    //   276: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: goto -120 -> 159
    //   282: astore_3
    //   283: aload_2
    //   284: monitorexit
    //   285: ldc_w 323
    //   288: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload_3
    //   292: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	a
    //   234	13	1	i	int
    //   10	274	2	localList	List
    //   111	149	3	localObject1	Object
    //   282	10	3	localObject2	Object
    //   116	11	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   20	148	282	finally
    //   148	159	282	finally
    //   159	170	282	finally
    //   170	225	282	finally
    //   225	260	282	finally
    //   269	279	282	finally
  }
  
  private final void bpC()
  {
    AppMethodBeat.i(236890);
    List localList = this.nAR;
    s.s(localList, "pcmDataList");
    long l2;
    long l1;
    Object localObject6;
    com.tencent.mm.audio.mix.a.e locale;
    try
    {
      Log.i(this.TAG, "the mix thread running mix " + this.index + " pcmDataListSize: " + this.nAR.size() + ", mixBackground:" + this.nAI + ", mixMusic:" + this.nAJ);
      if (this.nAR.size() <= 0) {
        break label354;
      }
      l2 = Util.currentTicks();
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll((Collection)this.nAR);
      localObject1 = this.nAM.bn((List)localObject1);
      if (localObject1 == null) {
        break label354;
      }
      l1 = 0L;
      if (!this.nAJ) {
        break label369;
      }
      ??? = this.nAR;
      s.s(???, "pcmDataList");
      synchronized ((Iterable)???)
      {
        localObject6 = ((Iterable)???).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          locale = (com.tencent.mm.audio.mix.a.e)((Iterator)localObject6).next();
          if (s.p(locale.hqQ, "music"))
          {
            l1 = locale.hqT;
            Log.i(this.TAG, s.X("get pts from music: ", Long.valueOf(l1)));
          }
        }
      }
      localObject6 = ah.aiuX;
    }
    finally
    {
      AppMethodBeat.o(236890);
    }
    for (;;)
    {
      Log.i(this.TAG, "mix finish pcm frame size: " + localObject3.length + ", pts:" + l1 + ", cost:" + Util.ticksToNow(l2));
      this.nAL.invoke(localObject3, Long.valueOf(l1));
      label354:
      ah localah = ah.aiuX;
      AppMethodBeat.o(236890);
      return;
      label369:
      if ((this.nAI) && (!this.nAJ))
      {
        ??? = this.nAR;
        s.s(???, "pcmDataList");
        synchronized ((Iterable)???)
        {
          localObject6 = ((Iterable)???).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            locale = (com.tencent.mm.audio.mix.a.e)((Iterator)localObject6).next();
            if (s.p(locale.hqQ, "background"))
            {
              l1 = locale.hqT;
              Log.i(this.TAG, s.X("get pts from background: ", Long.valueOf(l1)));
            }
          }
        }
        localObject6 = ah.aiuX;
      }
      else
      {
        l1 = 0L;
      }
    }
  }
  
  public final void GN(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(93711);
    s.u(paramString, "audioId");
    for (;;)
    {
      boolean bool;
      int i;
      synchronized (this.nAV)
      {
        Log.i(this.TAG, "inputEnd, audioId:" + paramString + ", mixBackground:" + this.nAI + ", mixMusic:" + this.nAJ);
        if (s.p(paramString, "background")) {
          this.nAZ = true;
        }
        if (s.p(paramString, "music")) {
          this.nBa = true;
        }
        if ((this.nAI) && (this.nAJ)) {
          if (this.nBa)
          {
            bool = this.nAZ;
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
        this.nAU = true;
        Log.i(this.TAG, "notify mix");
        this.nAV.notifyAll();
        label162:
        paramString = ah.aiuX;
        AppMethodBeat.o(93711);
        return;
        i = 0;
        continue;
        if (this.nAI)
        {
          i = j;
          if (this.nAZ) {
            continue;
          }
        }
        if (this.nAJ)
        {
          bool = this.nBa;
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
    //   0: ldc_w 453
    //   3: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 454
    //   10: invokestatic 136	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_2
    //   14: ldc_w 443
    //   17: invokestatic 136	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 184	com/tencent/mm/media/h/a:nAV	Ljava/lang/Object;
    //   24: astore 7
    //   26: aload 7
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   33: new 188	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 456
    //   40: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: arraylength
    //   45: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc_w 458
    //   51: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 460
    //   61: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: iload 5
    //   66: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: ldc_w 462
    //   72: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 6
    //   77: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc_w 422
    //   83: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload_3
    //   87: invokevirtual 425	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: new 338	com/tencent/mm/audio/mix/a/e
    //   99: dup
    //   100: invokespecial 463	com/tencent/mm/audio/mix/a/e:<init>	()V
    //   103: astore 8
    //   105: aload 8
    //   107: aload_2
    //   108: putfield 402	com/tencent/mm/audio/mix/a/e:hqQ	Ljava/lang/String;
    //   111: aload 8
    //   113: aload_1
    //   114: putfield 342	com/tencent/mm/audio/mix/a/e:hqJ	[B
    //   117: aload 8
    //   119: iload 5
    //   121: putfield 464	com/tencent/mm/audio/mix/a/e:sampleRate	I
    //   124: aload 8
    //   126: iload 6
    //   128: putfield 465	com/tencent/mm/audio/mix/a/e:channels	I
    //   131: aload 8
    //   133: lload_3
    //   134: putfield 411	com/tencent/mm/audio/mix/a/e:hqT	J
    //   137: aload_2
    //   138: ldc_w 438
    //   141: invokestatic 408	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   144: ifeq +148 -> 292
    //   147: aload_0
    //   148: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   151: ldc_w 467
    //   154: aload_0
    //   155: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   158: invokeinterface 277 1 0
    //   163: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: invokestatic 361	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_0
    //   173: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   176: aload 8
    //   178: invokeinterface 350 2 0
    //   183: pop
    //   184: aload_0
    //   185: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   188: astore_1
    //   189: aload_0
    //   190: getfield 469	com/tencent/mm/media/h/a:nAX	I
    //   193: istore 5
    //   195: aload_0
    //   196: iload 5
    //   198: iconst_1
    //   199: iadd
    //   200: putfield 469	com/tencent/mm/media/h/a:nAX	I
    //   203: aload_1
    //   204: ldc_w 471
    //   207: iload 5
    //   209: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: invokestatic 361	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   215: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield 148	com/tencent/mm/media/h/a:nAJ	Z
    //   222: ifeq +195 -> 417
    //   225: aload_0
    //   226: getfield 146	com/tencent/mm/media/h/a:nAI	Z
    //   229: ifeq +188 -> 417
    //   232: aload_0
    //   233: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   236: invokeinterface 277 1 0
    //   241: ifle +36 -> 277
    //   244: aload_0
    //   245: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   248: invokeinterface 277 1 0
    //   253: istore 5
    //   255: iload 5
    //   257: ifle +20 -> 277
    //   260: aload_0
    //   261: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   264: ldc_w 451
    //   267: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_0
    //   271: getfield 184	com/tencent/mm/media/h/a:nAV	Ljava/lang/Object;
    //   274: invokevirtual 300	java/lang/Object:notifyAll	()V
    //   277: getstatic 269	kotlin/ah:aiuX	Lkotlin/ah;
    //   280: astore_1
    //   281: aload 7
    //   283: monitorexit
    //   284: ldc_w 453
    //   287: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: iconst_1
    //   291: ireturn
    //   292: aload_2
    //   293: ldc_w 404
    //   296: invokestatic 408	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   299: ifeq -81 -> 218
    //   302: aload_0
    //   303: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   306: ldc_w 473
    //   309: aload_0
    //   310: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   313: invokeinterface 277 1 0
    //   318: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: invokestatic 361	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   324: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: aload_0
    //   328: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   331: aload 8
    //   333: invokeinterface 350 2 0
    //   338: pop
    //   339: aload_0
    //   340: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   343: astore_1
    //   344: aload_0
    //   345: getfield 475	com/tencent/mm/media/h/a:nAY	I
    //   348: istore 5
    //   350: aload_0
    //   351: iload 5
    //   353: iconst_1
    //   354: iadd
    //   355: putfield 475	com/tencent/mm/media/h/a:nAY	I
    //   358: aload_1
    //   359: ldc_w 477
    //   362: iload 5
    //   364: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: invokestatic 361	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   370: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: goto -155 -> 218
    //   376: astore_1
    //   377: aload_0
    //   378: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   381: aload_1
    //   382: checkcast 302	java/lang/Throwable
    //   385: ldc_w 303
    //   388: iconst_0
    //   389: anewarray 4	java/lang/Object
    //   392: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: getstatic 313	com/tencent/mm/media/util/f:nFE	Lcom/tencent/mm/media/util/f;
    //   398: astore_1
    //   399: invokestatic 316	com/tencent/mm/media/util/f:brR	()V
    //   402: goto -125 -> 277
    //   405: astore_1
    //   406: aload 7
    //   408: monitorexit
    //   409: ldc_w 453
    //   412: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   415: aload_1
    //   416: athrow
    //   417: aload_0
    //   418: getfield 148	com/tencent/mm/media/h/a:nAJ	Z
    //   421: ifne +10 -> 431
    //   424: aload_0
    //   425: getfield 146	com/tencent/mm/media/h/a:nAI	Z
    //   428: ifeq -151 -> 277
    //   431: aload_0
    //   432: getfield 176	com/tencent/mm/media/h/a:nAQ	Ljava/util/List;
    //   435: invokeinterface 277 1 0
    //   440: ifgt +19 -> 459
    //   443: aload_0
    //   444: getfield 174	com/tencent/mm/media/h/a:nAP	Ljava/util/List;
    //   447: invokeinterface 277 1 0
    //   452: istore 5
    //   454: iload 5
    //   456: ifle -179 -> 277
    //   459: aload_0
    //   460: getfield 182	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   463: ldc_w 451
    //   466: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload_0
    //   470: getfield 184	com/tencent/mm/media/h/a:nAV	Ljava/lang/Object;
    //   473: invokevirtual 300	java/lang/Object:notifyAll	()V
    //   476: goto -199 -> 277
    //   479: astore_1
    //   480: goto -203 -> 277
    //   483: astore_1
    //   484: goto -207 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	a
    //   0	487	1	paramArrayOfByte	byte[]
    //   0	487	2	paramString	String
    //   0	487	3	paramLong	long
    //   0	487	5	paramInt1	int
    //   0	487	6	paramInt2	int
    //   24	383	7	localObject	Object
    //   103	229	8	locale	com.tencent.mm.audio.mix.a.e
    // Exception table:
    //   from	to	target	type
    //   29	218	376	java/lang/Exception
    //   218	255	376	java/lang/Exception
    //   292	373	376	java/lang/Exception
    //   417	431	376	java/lang/Exception
    //   431	454	376	java/lang/Exception
    //   29	218	405	finally
    //   218	255	405	finally
    //   260	277	405	finally
    //   277	281	405	finally
    //   292	373	405	finally
    //   377	402	405	finally
    //   417	431	405	finally
    //   431	454	405	finally
    //   459	476	405	finally
    //   459	476	479	java/lang/Exception
    //   260	277	483	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.h.a
 * JD-Core Version:    0.7.0.1
 */