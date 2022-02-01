package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.a.d;
import com.tencent.mm.media.h.a.i;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import d.g.b.k;
import d.y;

public final class c
  implements b
{
  private static final Object gCV;
  private Runnable KBT;
  private boolean gAF;
  protected boolean gBu;
  protected com.tencent.mm.plugin.mmsight.model.c gCA;
  protected VideoTransPara gCB;
  protected m gCC;
  protected boolean gCD;
  protected int gCE;
  protected d.a gCF;
  protected Runnable gCG;
  protected boolean gCH;
  protected boolean gCI;
  protected boolean gCJ;
  private long gCK;
  private a gCL;
  private com.tencent.mm.media.h.a gCM;
  private long gCN;
  private long gCO;
  public boolean gCP;
  private double gCQ;
  private long gCR;
  private long gCS;
  private long gCT;
  private boolean gCU;
  protected g gCW;
  private final Object gCf;
  protected String gCg;
  protected int gCh;
  protected float gCi;
  private int gCj;
  private float gCk;
  protected com.tencent.mm.plugin.mmsight.model.a.c gCl;
  protected com.tencent.mm.media.d.b gCm;
  protected int gCn;
  protected int gCo;
  protected int gCp;
  protected int gCq;
  protected int gCr;
  protected s gCs;
  protected int gCt;
  protected boolean gCu;
  protected String gCv;
  protected boolean gCw;
  protected String gCx;
  protected boolean gCy;
  protected com.tencent.mm.plugin.mmsight.model.c gCz;
  protected boolean ggj;
  protected int gmW;
  private EGLContext gwo;
  protected String mFileName;
  protected String md5;
  private boolean released;
  private SurfaceTexture surfaceTexture;
  private int textureId;
  protected String thumbPath;
  
  static
  {
    AppMethodBeat.i(93397);
    gCV = new Object();
    AppMethodBeat.o(93397);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.i.a parama)
  {
    this(paramVideoTransPara, parama, null, -1, null);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.i.a parama, EGLContext paramEGLContext, int paramInt)
  {
    AppMethodBeat.i(93367);
    this.gCf = new Object();
    this.gCg = "";
    this.gCh = 0;
    this.gCi = 0.0F;
    this.gCj = -1;
    this.gCk = -1.0F;
    this.gCn = 480;
    this.gCo = 640;
    this.gCp = 1600000;
    this.gCq = 480;
    this.gCr = 640;
    this.gmW = -1;
    this.gCu = false;
    this.gCv = null;
    this.gCw = false;
    this.thumbPath = null;
    this.gCx = null;
    this.gCy = false;
    this.gCz = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.gCA = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.ggj = false;
    this.gCD = false;
    this.md5 = "";
    this.gBu = false;
    this.gCE = 0;
    this.gCG = null;
    this.gCH = false;
    this.gCI = true;
    this.gCJ = false;
    this.gAF = false;
    this.gCK = 0L;
    this.gCL = null;
    this.gCM = null;
    this.gwo = null;
    this.textureId = -1;
    this.gCN = 0L;
    this.gCO = 0L;
    this.gCP = false;
    this.gCQ = 0.0D;
    this.gCR = 0L;
    this.gCS = 0L;
    this.gCT = 0L;
    this.gCU = false;
    this.released = false;
    this.KBT = new c.1(this);
    this.gCW = new g()
    {
      public final boolean W(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(205895);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(205895);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.gwo = paramEGLContext;
    this.gCM = new com.tencent.mm.media.h.a(parama);
    this.textureId = paramInt;
    ad.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93367);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.i.a parama, EGLContext paramEGLContext, int paramInt, a parama1)
  {
    AppMethodBeat.i(93366);
    this.gCf = new Object();
    this.gCg = "";
    this.gCh = 0;
    this.gCi = 0.0F;
    this.gCj = -1;
    this.gCk = -1.0F;
    this.gCn = 480;
    this.gCo = 640;
    this.gCp = 1600000;
    this.gCq = 480;
    this.gCr = 640;
    this.gmW = -1;
    this.gCu = false;
    this.gCv = null;
    this.gCw = false;
    this.thumbPath = null;
    this.gCx = null;
    this.gCy = false;
    this.gCz = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.gCA = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.ggj = false;
    this.gCD = false;
    this.md5 = "";
    this.gBu = false;
    this.gCE = 0;
    this.gCG = null;
    this.gCH = false;
    this.gCI = true;
    this.gCJ = false;
    this.gAF = false;
    this.gCK = 0L;
    this.gCL = null;
    this.gCM = null;
    this.gwo = null;
    this.textureId = -1;
    this.gCN = 0L;
    this.gCO = 0L;
    this.gCP = false;
    this.gCQ = 0.0D;
    this.gCR = 0L;
    this.gCS = 0L;
    this.gCT = 0L;
    this.gCU = false;
    this.released = false;
    this.KBT = new c.1(this);
    this.gCW = new g()
    {
      public final boolean W(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(205895);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(205895);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.gCL = parama1;
    this.gwo = paramEGLContext;
    this.gCM = new com.tencent.mm.media.h.a(parama);
    this.textureId = paramInt;
    ad.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93366);
  }
  
  private void a(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93368);
    this.gCK = 0L;
    this.gCB = paramVideoTransPara;
    this.gCn = paramVideoTransPara.width;
    this.gCo = paramVideoTransPara.height;
    this.gCs = new s();
    paramVideoTransPara = com.tencent.mm.media.j.d.gwr;
    com.tencent.mm.media.j.d.akS();
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.gCn), Integer.valueOf(this.gCo) });
    AppMethodBeat.o(93368);
  }
  
  private void aok()
  {
    AppMethodBeat.i(93370);
    int i = this.gCn;
    int j = this.gCo;
    this.gCM.cR(i, j);
    this.gCM.mz(this.gCt);
    this.gCM.cS(this.gCq, this.gCr);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.gCq), Integer.valueOf(this.gCr), Integer.valueOf(this.gCt) });
    AppMethodBeat.o(93370);
  }
  
  private boolean aol()
  {
    AppMethodBeat.i(93374);
    long l = bt.GC();
    if (this.gCm == null)
    {
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, videoEncoder is null");
      AppMethodBeat.o(93374);
      return false;
    }
    int i = this.gCm.frameNum;
    if (this.gCh <= 0)
    {
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, mDurationMS error %s", new Object[] { Integer.valueOf(this.gCh) });
      AppMethodBeat.o(93374);
      return false;
    }
    this.gCi = (i * 1000.0F / this.gCh);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.gCi), Integer.valueOf(this.gCh), this.gCg, Long.valueOf(bt.aS(l)), Integer.valueOf(this.gCj), Float.valueOf(this.gCk) });
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] frameCountCallback %s", new Object[] { this.gCA.getValue() });
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] yuvRecorderWriteDataCallback %s", new Object[] { this.gCz.getValue() });
    String str = null;
    label364:
    float f;
    int j;
    int k;
    int m;
    if (CaptureMMProxy.getInstance() != null)
    {
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      if (bt.isNullOrNil(str)) {
        break label643;
      }
      str = com.tencent.mm.plugin.mmsight.d.dR(str, hashCode());
      i = this.gCh;
      if (this.gCj > 0) {
        i = this.gCj;
      }
      f = this.gCi;
      if (this.gCk > 0.0F) {
        f = this.gCk;
      }
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxResultPath : " + str);
      j = this.gmW;
      k = this.gCp;
      m = this.gCB.audioSampleRate;
      if ((!this.gCJ) || (this.gCU)) {
        break label652;
      }
    }
    Object localObject;
    label643:
    label652:
    for (boolean bool = true;; bool = false)
    {
      localObject = new m(j, str, f, k, i, m, bool, false, this.gCu);
      l = bt.GC();
      bool = ((m)localObject).cQg();
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux used %sms, success: %s", new Object[] { Long.valueOf(bt.aS(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label658;
      }
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux failed!");
      l.cPV();
      AppMethodBeat.o(93374);
      return false;
      if (bt.isNullOrNil(this.gCg)) {
        break;
      }
      str = q.B(new com.tencent.mm.vfs.e(this.gCg).fhT().fhU());
      break;
      str = this.gCg;
      break label364;
    }
    label658:
    if (this.gBu)
    {
      l = bt.GC();
      if (this.gCE != 270) {
        break label946;
      }
    }
    for (i = 270;; i = 90)
    {
      SightVideoJNI.tagRotateVideoVFS(str, this.gCv, i);
      this.gCy = true;
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gCt), Boolean.valueOf(this.gBu), Integer.valueOf(this.gCE), Integer.valueOf(i) });
      l = bt.GC();
      try
      {
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.vfs.i.lD(this.gCv, str);
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] copyFile cost %s", new Object[] { Long.valueOf(bt.aS(l)) });
        localObject = this.gCv;
        h.Iye.f(new c.9(this, (String)localObject), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.gmW);
        this.gCs.a(d.c.tDR);
        this.md5 = com.tencent.mm.vfs.i.aEN(str);
        if ((!bt.isNullOrNil(str)) && (!str.equals(this.gCg)))
        {
          com.tencent.mm.vfs.i.lD(str, this.gCg);
          com.tencent.mm.vfs.i.deleteFile(str);
        }
        AppMethodBeat.o(93374);
        return true;
      }
      catch (Exception localException)
      {
        label946:
        ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, copy file error");
        AppMethodBeat.o(93374);
      }
    }
    return false;
  }
  
  private void aom()
  {
    this.gCN = 0L;
    this.gCO = 0L;
    this.gCQ = 0.0D;
    this.gCR = 0L;
    this.gCS = 0L;
    this.gCT = 0L;
  }
  
  private boolean aoy()
  {
    AppMethodBeat.i(93391);
    if ((this.gCs.tFa == d.c.tDO) || (this.gCs.tFa == d.c.tDP))
    {
      if (this.gCs.tFa == d.c.tDP)
      {
        this.gCs.tFa = d.c.tDQ;
        ad.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] forward one more frame", new Object[0]);
      }
      if (this.gCl != null) {
        this.gCl.cQe();
      }
      this.gCA.rt(1L);
      this.gCz.rt(1L);
      AppMethodBeat.o(93391);
      return true;
    }
    AppMethodBeat.o(93391);
    return false;
  }
  
  private void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(177314);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
    long l = bt.GC();
    int i = 0;
    while (i < 3)
    {
      j.tEA.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
      i += 1;
    }
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    AppMethodBeat.o(177314);
  }
  
  private boolean mP(int paramInt)
  {
    AppMethodBeat.i(93369);
    this.released = false;
    long l = bt.GC();
    this.gCp = this.gCB.videoBitrate;
    if (this.gCB.hct == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = new com.tencent.mm.media.b.d(bool);
      if (!((com.tencent.mm.media.b.d)???).gnm) {
        break;
      }
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] encodeConfig  InitError");
      ??? = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.ala();
      AppMethodBeat.o(93369);
      return false;
    }
    this.gCu = k.g(((com.tencent.mm.media.b.d)???).mimeType, "video/hevc");
    this.gmW = SightVideoJNI.initDataBufferForMMSightLock(this.gCq, this.gCr, paramInt, this.gCn, this.gCo, this.gCB.fps, this.gCp, this.gCB.hbY, 8, this.gCB.hbX, 23.0F, false, false, this.gCB.duration, false, this.gCu, com.tencent.mm.plugin.sight.base.b.Z(false, this.gCu));
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init, bufId: %s", new Object[] { Integer.valueOf(this.gmW) });
    if (this.gmW < 0)
    {
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init failed!");
      ??? = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.akT();
      AppMethodBeat.o(93369);
      return false;
    }
    this.gCt = paramInt;
    this.gCo = com.tencent.mm.plugin.mmsight.d.GN(this.gCo);
    this.gCn = com.tencent.mm.plugin.mmsight.d.GN(this.gCn);
    Object localObject2;
    if ((this.gCu) && (((com.tencent.mm.media.b.d)???).mimeType.equals("video/hevc")))
    {
      localObject2 = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.alJ();
    }
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mTargetRate " + this.gCp + "  videoParams.fps: " + this.gCB.fps + " mTargetHeight:" + this.gCo + " mTargetWidth:" + this.gCn + ", minQP:" + this.gCB.gnp + ", maxQP:" + this.gCB.gnq);
    ((com.tencent.mm.media.b.d)???).bitrate = this.gCp;
    ((com.tencent.mm.media.b.d)???).frameRate = this.gCB.fps;
    ((com.tencent.mm.media.b.d)???).gni = this.gCo;
    ((com.tencent.mm.media.b.d)???).gnh = this.gCn;
    ((com.tencent.mm.media.b.d)???).gnq = this.gCB.gnq;
    ((com.tencent.mm.media.b.d)???).gnp = this.gCB.gnp;
    try
    {
      this.gCm = new com.tencent.mm.media.d.e((com.tencent.mm.media.b.d)???, true, new d.g.a.b() {});
      ??? = this.gCM;
      localObject2 = this.gCm.getInputSurface();
      EGLContext localEGLContext = this.gwo;
      d.g.a.b local5 = new d.g.a.b()
      {
        private y c(Boolean arg1)
        {
          AppMethodBeat.i(205898);
          if (!???.booleanValue())
          {
            ??? = com.tencent.mm.media.j.d.gwr;
            com.tencent.mm.media.j.d.akU();
          }
          synchronized (c.fQJ())
          {
            try
            {
              c.fQJ().notifyAll();
              AppMethodBeat.o(205898);
              return null;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "[" + hashCode() + "] initSurfaceLock notify error", new Object[0]);
              }
            }
          }
        }
      };
      k.h(localObject2, "surface");
      ((com.tencent.mm.media.h.a)???).surface = ((Surface)localObject2);
      ad.i(((com.tencent.mm.media.h.a)???).TAG, ((com.tencent.mm.media.h.a)???).hashCode() + " initWithSurface, eglContext:" + localEGLContext + ", surface:" + localObject2 + ", waitNewFrame:false, callback:false");
      ((com.tencent.mm.media.h.a)???).i((d.g.a.a)new a.d((com.tencent.mm.media.h.a)???, localEGLContext, (Surface)localObject2, local5));
      synchronized (gCV)
      {
        try
        {
          gCV.wait(500L);
          this.gCM.gsm = new d.g.a.b() {};
          aok();
          this.gCl = new a(this.gCB.audioSampleRate, this.gCB.audioBitrate, this.gCB.gnH, com.tencent.mm.plugin.sight.base.b.Z(false, this.gCu));
          this.gCl.nf(this.gCH);
          paramInt = this.gCl.D(this.gmW, com.tencent.mm.plugin.sight.base.e.anm(this.gCg));
          ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl used %sms, ret:%s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(paramInt) });
          if (paramInt != 0)
          {
            ??? = com.tencent.mm.media.j.d.gwr;
            com.tencent.mm.media.j.d.akV();
            AppMethodBeat.o(93369);
            return false;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException2, "[" + hashCode() + "] initSurfaceLock wait error", new Object[0]);
          }
        }
      }
      com.tencent.mm.media.j.d locald;
      AppMethodBeat.o(93369);
    }
    catch (Exception localException1)
    {
      release();
      ad.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException1, "[" + hashCode() + "] init encoder error", new Object[0]);
      ax.eGe().putBoolean("mediacodec_create_error", true);
      locald = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.akT();
      AppMethodBeat.o(93369);
      return false;
    }
    return true;
  }
  
  private void release()
  {
    AppMethodBeat.i(93379);
    if (this.released)
    {
      AppMethodBeat.o(93379);
      return;
    }
    this.released = true;
    try
    {
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release recorder");
      this.gCs.a(d.c.tDQ);
      synchronized (this.gCf)
      {
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release videoEncoder");
        if (this.gCm != null)
        {
          this.gCm.ajF();
          this.gCm.ajG();
          this.gCm = null;
          com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.alA();
        }
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] end release videoEncoder");
        if (this.gCl != null)
        {
          this.gCl.a(new c.10(this));
          this.gCl.clear();
          this.gCl = null;
        }
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] release buf-id ? %d", new Object[] { Integer.valueOf(this.gmW) });
        if (this.gmW >= 0) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.gmW);
        }
        this.gCs.a(d.c.tDR);
        if (this.gCM != null) {
          this.gCM.release();
        }
        aom();
        this.gCP = false;
        this.gCD = false;
        this.gCC = null;
        this.ggj = false;
        AppMethodBeat.o(93379);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "[" + hashCode() + "] clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93379);
    }
  }
  
  public final void C(Runnable paramRunnable)
  {
    AppMethodBeat.i(93373);
    this.gCG = paramRunnable;
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] !!!!!stop, stopCallback: %s !!!", new Object[] { paramRunnable });
    if ((this.gCm == null) || ((this.gCl == null) && (!this.gCJ)))
    {
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        aq.f(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDR))
    {
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, already in stop videoRecordStatus");
      if (this.gCl != null) {
        this.gCl.clear();
      }
      if (paramRunnable != null) {
        aq.f(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    paramRunnable = com.tencent.mm.media.j.d.gwr;
    com.tencent.mm.media.j.d.akW();
    if (this.gCs != null)
    {
      h.Iye.h(this.KBT, "record_stop_timeout");
      this.gCs.a(d.c.tDP);
    }
    if (this.gCS > 0L)
    {
      long l1 = System.nanoTime();
      long l2 = this.gCS;
      float f = (float)this.gCT;
      this.gCT = (((float)(l1 - l2) / 1000000.0F + f));
    }
    this.gCh = ((int)this.gCm.ajJ());
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, mDurationMS:%s, accumulatePauseTime:%s", new Object[] { Integer.valueOf(this.gCh), Long.valueOf(this.gCT) });
    if (this.gCT > 0L) {
      this.gCh = ((int)(this.gCh - this.gCT));
    }
    AppMethodBeat.o(93373);
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93385);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.gCt = paramInt1;
    this.gCq = paramInt2;
    this.gCr = paramInt3;
    this.gCM.mz(paramInt1);
    aok();
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDW))
    {
      this.gCs.a(d.c.tDO);
      if (this.gCl != null) {
        this.gCl.resume();
      }
    }
    AppMethodBeat.o(93385);
  }
  
  public final String JS()
  {
    AppMethodBeat.i(93375);
    String str = bt.by(this.md5, "");
    AppMethodBeat.o(93375);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.mmsight.model.a.c paramc)
  {
    AppMethodBeat.i(93392);
    if (paramc != null)
    {
      this.gCU = true;
      paramc.mO(this.gmW);
    }
    AppMethodBeat.o(93392);
  }
  
  public final void a(d.a parama)
  {
    this.gCF = parama;
  }
  
  public final void af(float paramFloat)
  {
    AppMethodBeat.i(93389);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.gCk = paramFloat;
    AppMethodBeat.o(93389);
  }
  
  public final String anX()
  {
    return this.thumbPath;
  }
  
  public final void aoj()
  {
    AppMethodBeat.i(93390);
    long l;
    if ((this.textureId < 0) || (!aoy()))
    {
      if ((this.surfaceTexture == null) || (!aoy())) {
        AppMethodBeat.o(93390);
      }
    }
    else
    {
      if (this.gCS > 0L)
      {
        l = System.nanoTime() - this.gCS;
        this.gCR += l;
        float f = (float)this.gCT;
        this.gCT = (((float)l / 1000000.0F + f));
        this.gCS = 0L;
      }
      ad.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureDataUpdate, lastPausePtsDiff:%s", new Object[] { Long.valueOf(this.gCR) });
      if (this.gCO <= 0L) {
        break label389;
      }
      l = System.nanoTime() - this.gCO + this.gCN - this.gCR;
      this.gCR = 0L;
    }
    for (;;)
    {
      if (this.gCP) {
        if ((this.gCs.tFa == d.c.tDQ) || (this.gCN == 0L) || (l - this.gCN >= this.gCQ * 1000000.0D))
        {
          this.gCM.w(this.textureId, l);
          this.gCN = l;
        }
      }
      for (this.gCO = System.nanoTime();; this.gCO = System.nanoTime())
      {
        ad.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureDataUpdate pts:%s, lastTexturePts:%s, lastTextureNanoTime:%s, accumulatePauseTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.gCN), Long.valueOf(this.gCO), Long.valueOf(this.gCT) });
        break;
        this.gCM.w(this.textureId, l);
        this.gCN = l;
      }
      com.tencent.mm.media.h.a locala = this.gCM;
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      k.h(localSurfaceTexture, "surfaceTexture");
      locala.i((d.g.a.a)new a.i(locala, localSurfaceTexture));
      AppMethodBeat.o(93390);
      return;
      label389:
      l = 0L;
    }
  }
  
  public final String aon()
  {
    return this.gCx;
  }
  
  public final float aoo()
  {
    return this.gCi;
  }
  
  public final long aop()
  {
    AppMethodBeat.i(93380);
    if (this.gCm != null)
    {
      long l = this.gCm.ajJ();
      AppMethodBeat.o(93380);
      return l;
    }
    AppMethodBeat.o(93380);
    return 0L;
  }
  
  public final d.c aoq()
  {
    return this.gCs.tFa;
  }
  
  public final int aor()
  {
    AppMethodBeat.i(93382);
    int i = Math.round(this.gCh / 1000.0F);
    AppMethodBeat.o(93382);
    return i;
  }
  
  public final Point aos()
  {
    AppMethodBeat.i(93383);
    Point localPoint = new Point(this.gCq, this.gCr);
    AppMethodBeat.o(93383);
    return localPoint;
  }
  
  public final int aot()
  {
    return this.gCt;
  }
  
  public final boolean aou()
  {
    return this.gCD;
  }
  
  public final boolean aov()
  {
    return this.gBu;
  }
  
  public final com.tencent.mm.audio.b.c.a aow()
  {
    AppMethodBeat.i(93386);
    if (this.gCl != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.gCl.cQf();
      AppMethodBeat.o(93386);
      return locala;
    }
    AppMethodBeat.o(93386);
    return null;
  }
  
  public final void aox()
  {
    this.gCI = false;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.c aoz()
  {
    return this.gCl;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93372);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.gCz.reset();
    this.gCh = 0;
    this.gCN = 0L;
    this.gCA.reset();
    this.gCw = false;
    this.gBu = paramBoolean;
    this.gCE = paramInt2;
    aom();
    this.gCQ = (1000.0F / this.gCB.fps);
    this.gCs.a(d.c.tDN);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, checkDropFrameByPts: %s, perFrmaeDuration:%s", new Object[] { Boolean.valueOf(this.gCP), Double.valueOf(this.gCQ) });
    if (bt.isNullOrNil(this.gCg))
    {
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93372);
      return -1;
    }
    try
    {
      this.mFileName = com.tencent.mm.vfs.i.aMS(this.gCg);
      String str2 = com.tencent.mm.vfs.i.aMQ(this.gCg);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.gCv = (str1 + hashCode() + "tempRotate.mp4");
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tempRotateFilePath:" + this.gCv);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.gCs.a(d.c.tDV);
        continue;
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start yuvRecorder with mute");
        this.gCs.a(d.c.tDO);
        this.gCD = false;
        paramInt1 = 0;
      }
    }
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.gCg, this.gCv });
    this.gCt = paramInt1;
    aok();
    if (!this.ggj)
    {
      mP(paramInt1);
      this.ggj = true;
    }
    aok();
    if ((!this.gCJ) && (!this.gCH) && (this.gCl != null))
    {
      paramInt1 = this.gCl.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void aoB()
        {
          AppMethodBeat.i(205901);
          ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] onPcmReady");
          if (c.this.aoq() != d.c.tDV)
          {
            ad.w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(205901);
            return;
          }
          c.this.gCs.a(d.c.tDO);
          AppMethodBeat.o(205901);
        }
      });
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.gCD = false;
      if (paramInt1 != 0)
      {
        this.gCs.a(d.c.tDU);
        AppMethodBeat.o(93372);
        return paramInt1;
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93376);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] cancel");
    release();
    AppMethodBeat.o(93376);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93378);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] clear");
    release();
    AppMethodBeat.o(93378);
  }
  
  public final void dV(boolean paramBoolean)
  {
    this.gCH = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.gCg;
  }
  
  public final g getFrameDataCallback()
  {
    return this.gCW;
  }
  
  public final boolean mQ(int paramInt)
  {
    AppMethodBeat.i(93371);
    if (!this.ggj)
    {
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preInit, cameraOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = mP(paramInt);
      this.ggj = true;
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93371);
      return bool;
    }
    AppMethodBeat.o(93371);
    return true;
  }
  
  public final void mR(int paramInt)
  {
    AppMethodBeat.i(93387);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gCj = paramInt;
    AppMethodBeat.o(93387);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93384);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] pause");
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDO))
    {
      this.gCs.a(d.c.tDW);
      if (this.gCl != null) {
        this.gCl.pause();
      }
      this.gCS = System.nanoTime();
    }
    AppMethodBeat.o(93384);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93377);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] reset");
    release();
    AppMethodBeat.o(93377);
  }
  
  public final void ru(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void rv(String paramString)
  {
    this.gCx = paramString;
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93381);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.GN(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.GN(paramInt4);
    }
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.gCq = paramInt1;
    this.gCr = paramInt2;
    if (j.tEA.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null) {
      cY(paramInt1, paramInt2);
    }
    AppMethodBeat.o(93381);
  }
  
  public final void setFilePath(String paramString)
  {
    this.gCg = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(93388);
    this.gCM.gsB.dJ(paramBoolean);
    AppMethodBeat.o(93388);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.gCJ = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void lR(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c
 * JD-Core Version:    0.7.0.1
 */