package com.tencent.mm.media.g;

import a.f.a.m;
import a.l;
import a.y;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useX264Encode", "", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIIIIIJJZLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "codecSurface", "Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "firstFrameDraw", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mediaExtractorWrapper", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "useRequestDraw", "videoDuration", "videoFps", "videoHasBFrame", "videoMixHandlerThread", "videoRotate", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "checkFrameDrawTimeout", "checkVideoHasBFrame", "afterCheck", "copyVideoFile", "source", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "renderer", "Lcom/tencent/mm/media/render/MixRenderer;", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "startRemux", "Companion", "plugin-mediaeditor_release"})
public final class g
  extends d
  implements c
{
  private static final long eXx = 1000L;
  private static final long eXy = 1000L;
  public static final g.a eXz;
  private final String TAG;
  private volatile boolean eQY;
  private com.tencent.mm.media.e.a eRM;
  private int eRf;
  private int eRn;
  private int eVA;
  private a.f.a.b<? super Long, Bitmap> eVY;
  private Bitmap eVZ;
  private int eWJ;
  private int eWK;
  private int eWL;
  private long eWM;
  private long eWN;
  private com.tencent.mm.media.d.b eWO;
  private com.tencent.mm.media.d.g eWP;
  private com.tencent.mm.media.a.a eWQ;
  private a eWR;
  private j eWS;
  private com.tencent.mm.media.e.a eWT;
  private com.tencent.mm.media.e.a eWU;
  private al eWV;
  private al eWW;
  private boolean eWX;
  private boolean eWY;
  private h eWZ;
  private com.tencent.mm.media.c.b eWv;
  private long eXa;
  private final com.tencent.mm.media.i.a eXb;
  private boolean eXc;
  private boolean eXd;
  private boolean eXe;
  private int eXf;
  private int eXg;
  private volatile boolean eXh;
  private volatile boolean eXi;
  private volatile boolean eXj;
  private boolean eXk;
  private final Runnable eXl;
  private final String eXm;
  private final String eXn;
  private int eXo;
  private int eXp;
  private int eXq;
  private int eXr;
  private int eXs;
  private int eXt;
  private int eXu;
  private boolean eXv;
  private a.f.a.b<? super String, y> eXw;
  private String filePath;
  private int videoFps;
  
  static
  {
    AppMethodBeat.i(13063);
    eXz = new g.a((byte)0);
    eXx = 1000L;
    eXy = 1000L;
    AppMethodBeat.o(13063);
  }
  
  public g(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong1, long paramLong2, boolean paramBoolean, a.f.a.b<? super String, y> paramb)
  {
    AppMethodBeat.i(155534);
    this.eXm = paramString1;
    this.filePath = paramString2;
    this.eRn = paramInt1;
    this.eXn = paramString3;
    this.eXo = paramInt2;
    this.eXp = paramInt3;
    this.eXq = paramInt4;
    this.eXr = paramInt5;
    this.eXs = paramInt6;
    this.eXt = paramInt7;
    this.eXu = paramInt8;
    this.eXv = paramBoolean;
    this.eXw = paramb;
    this.TAG = "MicroMsg.MediaCodecRemuxer";
    this.eVA = -1;
    this.eWM = paramLong1;
    this.eWN = -1L;
    this.eXb = new com.tencent.mm.media.i.a("remuxCost");
    if ((bo.isNullOrNil(this.filePath)) || (!com.tencent.mm.vfs.e.cN(this.filePath)) || (bo.isNullOrNil(this.eXn)) || (this.eXo <= 0) || (this.eXp <= 0))
    {
      ab.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", outputFilePath:" + this.eXn + ", outputWidth:" + this.eXo + ", outputHeight:" + this.eXp + ", videoFps:" + this.videoFps + ", outputFps:" + this.eXu);
      paramString1 = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.We();
      paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
      AppMethodBeat.o(155534);
      throw paramString1;
    }
    paramString1 = com.tencent.mm.media.i.c.eZC;
    com.tencent.mm.media.i.c.jZ(this.eRn);
    if (com.tencent.mm.bj.e.vB(this.filePath))
    {
      ab.i(this.TAG, "remux h265 format");
      paramString1 = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.Wd();
    }
    com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK(this.eXn));
    this.eWL = SightVideoJNI.getMp4Rotate(this.filePath);
    paramString2 = com.tencent.mm.plugin.sight.base.d.Zo(this.filePath);
    if (paramString2 != null)
    {
      this.eWJ = paramString2.width;
      this.eWK = paramString2.height;
      this.videoFps = paramString2.eRw;
      this.eVA = paramString2.eVA;
    }
    if ((this.eWJ <= 0) || (this.eWK <= 0)) {}
    try
    {
      paramString1 = new MediaMetadataRetriever();
      paramString1.setDataSource(this.filePath);
      this.eWJ = bo.getInt(paramString1.extractMetadata(18), 0);
      this.eWK = bo.getInt(paramString1.extractMetadata(19), 0);
      paramString1.release();
      label466:
      if (this.videoFps <= 0)
      {
        ab.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", get video fps error");
        paramString1 = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.We();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(155534);
        throw paramString1;
      }
      if (paramLong2 == 0L)
      {
        this.eWN = this.eVA;
        if (!this.eXv) {
          break label1085;
        }
        paramString1 = new j(this.eWM, this.eWN, this.eXq, this.eXo, this.eXp, this.eXv, this.eXu);
        label594:
        this.eWS = paramString1;
        ab.b(this.TAG, "create MediaCodecRemuxer, filePath: " + this.filePath + ", outputFilePath: " + this.eXn + ", inputWidth: " + this.eWJ + ", inputHeight: " + this.eWK + ", videoRotate: " + this.eWL + " videoFps: " + this.videoFps + " ,outputBitrate :" + this.eXq + ", outputAudioBitrate:" + this.eXr + ", outputAudioChannelCount:" + this.eXt + ", outputWidth: " + this.eXo + ", outputHeight: " + this.eXp + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.eXu + " , videoDuration: " + this.eVA + " , remuxStartTime: " + this.eWM + " ,remuxEndTime: " + this.eWN + " , input bitrate:" + paramString2.videoBitrate, new Object[0]);
        this.eRM = new com.tencent.mm.media.e.a(this.filePath);
        if (this.eRM.eUX)
        {
          paramString1 = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.Wf();
        }
        paramInt1 = this.eXo - this.eWJ;
        if ((1 <= paramInt1) && (16 > paramInt1)) {
          break label1118;
        }
        paramInt1 = this.eXp - this.eWK;
        if (1 <= paramInt1) {
          break label1112;
        }
        label920:
        paramBoolean = false;
        label923:
        ab.i(this.TAG, "needCheckCropRect:".concat(String.valueOf(paramBoolean)));
        if (!paramBoolean) {
          break label1206;
        }
        paramString1 = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Wg();
        paramString2 = new f(this.eRM);
        paramString3 = (m)new g.1(this);
        paramString2.evL = paramString3;
      }
      try
      {
        if (!com.tencent.mm.compatible.util.d.fv(23)) {
          break label1124;
        }
        paramString1 = (com.tencent.mm.media.c.b)new com.tencent.mm.media.c.f(0L, paramString2.eWC.getDuration() / 1000, paramString2.eWC, null, (a.f.a.b)new f.c(paramString2));
        label1032:
        paramString2.eWv = paramString1;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          label1085:
          label1112:
          label1118:
          label1124:
          ab.printErrStackTrace(paramString2.TAG, (Throwable)paramString1, "start check init decoder error", new Object[0]);
          paramString1 = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.WA();
          paramString3.h(null, paramString2);
        }
      }
      com.tencent.mm.ab.b.b((a.f.a.a)new f.e(paramString2), "MediaCodecCheckVideoCropRect_decode");
      for (;;)
      {
        this.eXl = ((Runnable)new g.d(this));
        AppMethodBeat.o(155534);
        return;
        this.eWN = paramLong2;
        break;
        paramString1 = new j(this.eWM, this.eWN, this.eXq, this.eXv);
        break label594;
        if (16 <= paramInt1) {
          break label920;
        }
        paramBoolean = true;
        break label923;
        paramString1 = (com.tencent.mm.media.c.b)new com.tencent.mm.media.c.e(0L, paramString2.eWC.getDuration() / 1000, paramString2.eWC, null, (a.f.a.b)new f.d(paramString2));
        break label1032;
        label1206:
        Vb();
      }
    }
    catch (Exception paramString1)
    {
      break label466;
    }
  }
  
  private final void UN()
  {
    AppMethodBeat.i(152093);
    ab.i(this.TAG, "finishEncode");
    Object localObject;
    if (this.eXv)
    {
      localObject = this.eWP;
      if (localObject != null) {
        com.tencent.mm.media.d.g.a((com.tencent.mm.media.d.g)localObject);
      }
      cB(true);
    }
    for (;;)
    {
      al.ae(this.eXl);
      this.eXj = true;
      AppMethodBeat.o(152093);
      return;
      localObject = this.eWO;
      if (localObject != null) {
        ((com.tencent.mm.media.d.b)localObject).UN();
      }
    }
  }
  
  private final void Vb()
  {
    AppMethodBeat.i(154819);
    ab.i(this.TAG, "startRemux, useX264Encode:" + this.eXv);
    if (this.eXv)
    {
      localObject = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.WL();
    }
    Object localObject = (a.f.a.b)new g.o(this);
    boolean bool;
    e locale;
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVL, 1) == 1)
    {
      bool = true;
      if (this.eXv) {
        bool = false;
      }
      ab.i(this.TAG, "checkVideoHasBFrame, needCheck:" + bool + ", useX264Encode:" + this.eXv);
      if (bool)
      {
        locale = new e(this.eRM);
        localObject = (a.f.a.b)new g.c(this, (a.f.a.b)localObject);
        locale.handler.postDelayed(locale.eWA, 1000L);
        locale.evv = ((a.f.a.b)localObject);
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          if (!com.tencent.mm.compatible.util.d.fv(23)) {
            continue;
          }
          localObject = (com.tencent.mm.media.c.b)new com.tencent.mm.media.c.f(0L, locale.eWC.getDuration() / 1000, locale.eWC, null, (a.f.a.b)new e.c(locale));
          locale.eWv = ((com.tencent.mm.media.c.b)localObject);
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace(locale.TAG, (Throwable)localException, "start check init decoder error", new Object[0]);
          localc = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.WK();
          locale.cA(false);
          continue;
        }
        com.tencent.mm.ab.b.b((a.f.a.a)new e.e(locale), "MediaCodecCheckHasBFrame_decode");
        AppMethodBeat.o(154819);
        return;
        bool = false;
        break;
        localObject = (com.tencent.mm.media.c.b)new com.tencent.mm.media.c.e(0L, locale.eWC.getDuration() / 1000, locale.eWC, null, (a.f.a.b)new e.d(locale));
      }
    }
    com.tencent.mm.media.i.c localc;
    localc.S(Boolean.FALSE);
    AppMethodBeat.o(154819);
  }
  
  /* Error */
  private final void cB(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 13060
    //   5: invokestatic 197	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 261	com/tencent/mm/media/g/g:TAG	Ljava/lang/String;
    //   12: new 290	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 990
    //   19: invokespecial 293	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: iload_1
    //   23: invokevirtual 736	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc_w 992
    //   29: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 994	com/tencent/mm/media/g/g:eXe	Z
    //   36: invokevirtual 736	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 996
    //   42: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 998	com/tencent/mm/media/g/g:eXd	Z
    //   49: invokevirtual 736	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 1000
    //   55: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 1002	com/tencent/mm/media/g/g:eXc	Z
    //   62: invokevirtual 736	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 350	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload_1
    //   72: ifeq +340 -> 412
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 998	com/tencent/mm/media/g/g:eXd	Z
    //   80: aload_0
    //   81: getfield 994	com/tencent/mm/media/g/g:eXe	Z
    //   84: ifeq +345 -> 429
    //   87: aload_0
    //   88: getfield 998	com/tencent/mm/media/g/g:eXd	Z
    //   91: ifeq +338 -> 429
    //   94: aload_0
    //   95: getfield 1002	com/tencent/mm/media/g/g:eXc	Z
    //   98: ifne +331 -> 429
    //   101: aload_0
    //   102: getfield 894	com/tencent/mm/media/g/g:eWR	Lcom/tencent/mm/media/g/a;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 1003	com/tencent/mm/media/g/a:release	()V
    //   117: aload_0
    //   118: getfield 277	com/tencent/mm/media/g/g:eXb	Lcom/tencent/mm/media/i/a;
    //   121: invokevirtual 1006	com/tencent/mm/media/i/a:SS	()V
    //   124: aload_0
    //   125: iconst_1
    //   126: putfield 1002	com/tencent/mm/media/g/g:eXc	Z
    //   129: getstatic 830	com/tencent/mm/media/g/k:eXX	Lcom/tencent/mm/media/g/k$a;
    //   132: astore 4
    //   134: aload_0
    //   135: getfield 235	com/tencent/mm/media/g/g:filePath	Ljava/lang/String;
    //   138: invokestatic 844	com/tencent/mm/media/g/k$a:mQ	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 946	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   144: pop
    //   145: getstatic 830	com/tencent/mm/media/g/k:eXX	Lcom/tencent/mm/media/g/k$a;
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 235	com/tencent/mm/media/g/g:filePath	Ljava/lang/String;
    //   154: invokestatic 835	com/tencent/mm/media/g/k$a:mR	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokestatic 946	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 472	com/tencent/mm/media/g/g:eRM	Lcom/tencent/mm/media/e/a;
    //   165: invokevirtual 1007	com/tencent/mm/media/e/a:release	()V
    //   168: aload_0
    //   169: getfield 611	com/tencent/mm/media/g/g:eWU	Lcom/tencent/mm/media/e/a;
    //   172: astore 4
    //   174: aload 4
    //   176: ifnull +8 -> 184
    //   179: aload 4
    //   181: invokevirtual 1007	com/tencent/mm/media/e/a:release	()V
    //   184: aload_0
    //   185: getfield 851	com/tencent/mm/media/g/g:eWZ	Lcom/tencent/mm/media/g/h;
    //   188: astore 4
    //   190: aload 4
    //   192: ifnull +27 -> 219
    //   195: aload 4
    //   197: getfield 1010	com/tencent/mm/media/g/h:eXQ	La/f/a/b;
    //   200: astore 4
    //   202: aload 4
    //   204: ifnull +15 -> 219
    //   207: aload 4
    //   209: aload_0
    //   210: getfield 257	com/tencent/mm/media/g/g:eXw	La/f/a/b;
    //   213: invokeinterface 818 2 0
    //   218: pop
    //   219: aload_0
    //   220: getfield 1012	com/tencent/mm/media/g/g:eWV	Lcom/tencent/mm/sdk/platformtools/al;
    //   223: astore 4
    //   225: aload 4
    //   227: ifnull +9 -> 236
    //   230: aload 4
    //   232: invokevirtual 1015	com/tencent/mm/sdk/platformtools/al:quit	()Z
    //   235: pop
    //   236: aload_0
    //   237: getfield 1017	com/tencent/mm/media/g/g:eWW	Lcom/tencent/mm/sdk/platformtools/al;
    //   240: astore 4
    //   242: aload 4
    //   244: ifnull +9 -> 253
    //   247: aload 4
    //   249: invokevirtual 1015	com/tencent/mm/sdk/platformtools/al:quit	()Z
    //   252: pop
    //   253: aload_0
    //   254: getfield 1019	com/tencent/mm/media/g/g:eXa	J
    //   257: invokestatic 959	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   260: lstore_2
    //   261: aload_0
    //   262: getfield 261	com/tencent/mm/media/g/g:TAG	Ljava/lang/String;
    //   265: new 290	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 1021
    //   272: invokespecial 293	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: lload_2
    //   276: invokevirtual 446	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   279: ldc_w 1023
    //   282: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_0
    //   286: getfield 1025	com/tencent/mm/media/g/g:eXf	I
    //   289: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc_w 1027
    //   295: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_0
    //   299: getfield 988	com/tencent/mm/media/g/g:eRf	I
    //   302: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: ldc_w 1029
    //   308: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_0
    //   312: getfield 1031	com/tencent/mm/media/g/g:eXg	I
    //   315: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 350	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload_0
    //   325: getfield 239	com/tencent/mm/media/g/g:eXn	Ljava/lang/String;
    //   328: invokestatic 374	com/tencent/mm/plugin/sight/base/d:Zo	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   331: astore 4
    //   333: aload 4
    //   335: ifnull +94 -> 429
    //   338: getstatic 328	com/tencent/mm/media/i/c:eZC	Lcom/tencent/mm/media/i/c;
    //   341: astore 5
    //   343: aload_0
    //   344: getfield 237	com/tencent/mm/media/g/g:eRn	I
    //   347: lload_2
    //   348: invokestatic 1035	com/tencent/mm/media/i/c:v	(IJ)V
    //   351: getstatic 328	com/tencent/mm/media/i/c:eZC	Lcom/tencent/mm/media/i/c;
    //   354: astore 5
    //   356: aload 4
    //   358: getfield 461	com/tencent/mm/plugin/sight/base/a:videoBitrate	I
    //   361: i2l
    //   362: aload 4
    //   364: getfield 389	com/tencent/mm/plugin/sight/base/a:eRw	I
    //   367: i2l
    //   368: aload_0
    //   369: getfield 310	com/tencent/mm/media/g/g:videoFps	I
    //   372: i2l
    //   373: invokestatic 1039	com/tencent/mm/media/i/c:d	(JJJ)V
    //   376: aload_0
    //   377: getfield 1025	com/tencent/mm/media/g/g:eXf	I
    //   380: i2f
    //   381: aload_0
    //   382: getfield 988	com/tencent/mm/media/g/g:eRf	I
    //   385: i2f
    //   386: fdiv
    //   387: f2d
    //   388: ldc2_w 1040
    //   391: dcmpl
    //   392: iflt +37 -> 429
    //   395: getstatic 328	com/tencent/mm/media/i/c:eZC	Lcom/tencent/mm/media/i/c;
    //   398: astore 4
    //   400: invokestatic 1044	com/tencent/mm/media/i/c:Wt	()V
    //   403: sipush 13060
    //   406: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   409: aload_0
    //   410: monitorexit
    //   411: return
    //   412: aload_0
    //   413: iconst_1
    //   414: putfield 994	com/tencent/mm/media/g/g:eXe	Z
    //   417: goto -337 -> 80
    //   420: astore 4
    //   422: aload_0
    //   423: monitorexit
    //   424: aload 4
    //   426: athrow
    //   427: astore 4
    //   429: sipush 13060
    //   432: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   435: goto -26 -> 409
    //   438: astore 4
    //   440: goto -279 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	g
    //   0	443	1	paramBoolean	boolean
    //   260	88	2	l	long
    //   105	294	4	localObject1	Object
    //   420	5	4	localObject2	Object
    //   427	1	4	localException1	Exception
    //   438	1	4	localException2	Exception
    //   341	14	5	localc	com.tencent.mm.media.i.c
    // Exception table:
    //   from	to	target	type
    //   2	71	420	finally
    //   75	80	420	finally
    //   80	107	420	finally
    //   112	117	420	finally
    //   117	129	420	finally
    //   129	161	420	finally
    //   161	174	420	finally
    //   179	184	420	finally
    //   184	190	420	finally
    //   195	202	420	finally
    //   207	219	420	finally
    //   219	225	420	finally
    //   230	236	420	finally
    //   236	242	420	finally
    //   247	253	420	finally
    //   253	324	420	finally
    //   324	333	420	finally
    //   338	403	420	finally
    //   403	409	420	finally
    //   412	417	420	finally
    //   429	435	420	finally
    //   324	333	427	java/lang/Exception
    //   338	403	427	java/lang/Exception
    //   129	161	438	java/lang/Exception
  }
  
  private final void cC(boolean paramBoolean)
  {
    long l;
    label202:
    try
    {
      AppMethodBeat.i(13061);
      ab.i(this.TAG, "onDecoderEncoderFailed, isDecoder:".concat(String.valueOf(paramBoolean)));
      if (paramBoolean)
      {
        localObject1 = this.eWv;
        if (localObject1 != null) {
          ((com.tencent.mm.media.c.b)localObject1).pJ();
        }
        if (this.eXc) {
          break label299;
        }
        localObject1 = this.eWR;
        if (localObject1 != null) {
          ((a)localObject1).release();
        }
        this.eXb.SS();
        this.eXc = true;
      }
    }
    finally {}
    try
    {
      localObject1 = k.eXX;
      com.tencent.mm.vfs.e.deleteFile(k.a.mQ(this.filePath));
      localObject1 = k.eXX;
      com.tencent.mm.vfs.e.deleteFile(k.a.mR(this.filePath));
      this.eRM.release();
      localObject1 = this.eWU;
      if (localObject1 != null) {
        ((com.tencent.mm.media.e.a)localObject1).release();
      }
      localObject1 = this.eWV;
      if (localObject1 != null) {
        ((al)localObject1).quit();
      }
      localObject1 = this.eWW;
      if (localObject1 != null) {
        ((al)localObject1).quit();
      }
      com.tencent.mm.vfs.e.deleteFile(this.eXn);
      l = bo.av(this.eXa);
      ab.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
      break label202;
    }
    Object localObject1 = this.eXw;
    if (localObject1 != null)
    {
      ((a.f.a.b)localObject1).S(null);
      AppMethodBeat.o(13061);
    }
    for (;;)
    {
      return;
      localObject1 = this.eWO;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.media.d.b)localObject1).releaseEncoder();
      break;
      label299:
      AppMethodBeat.o(13061);
    }
  }
  
  public final int Va()
  {
    AppMethodBeat.i(13059);
    ab.i(this.TAG, "start remux, initFinish:" + this.eWX);
    this.eXa = bo.yB();
    if ((this.eVZ != null) && (this.eWL > 0)) {
      this.eVZ = com.tencent.mm.sdk.platformtools.d.b(this.eVZ, -this.eWL);
    }
    this.eXb.eMo.reset();
    if (this.eWX)
    {
      al localal = this.eWV;
      if (localal != null) {
        localal.quit();
      }
      this.eWV = com.tencent.mm.ab.b.b((a.f.a.a)new g.e(this), "MediaCodecRemux_audioMix");
      localal = this.eWW;
      if (localal != null) {
        localal.quit();
      }
      if (this.eWv != null) {
        this.eWW = com.tencent.mm.ab.b.b((a.f.a.a)new f(this), "MediaCodecRemux_videoMix");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(13059);
      return 0;
      this.eWY = true;
    }
  }
  
  public final void b(a.f.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(152092);
    a.f.b.j.q(paramb, "blendBitmapProvider");
    this.eVY = paramb;
    a locala = this.eWR;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(152092);
      return;
    }
    AppMethodBeat.o(152092);
  }
  
  public final void p(Bitmap paramBitmap)
  {
    AppMethodBeat.i(13058);
    a.f.b.j.q(paramBitmap, "bitmap");
    this.eVZ = paramBitmap;
    a locala = this.eWR;
    if (locala != null)
    {
      String str = locala.TAG;
      StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmap:");
      if (paramBitmap != null) {}
      for (int i = paramBitmap.hashCode();; i = 0)
      {
        ab.i(str, i);
        locala.eVZ = paramBitmap;
        AppMethodBeat.o(13058);
        return;
      }
    }
    AppMethodBeat.o(13058);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class f
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    f(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.g.g
 * JD-Core Version:    0.7.0.1
 */