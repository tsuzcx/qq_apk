package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.a.d;
import com.tencent.mm.media.i.a.i;
import com.tencent.mm.media.i.a.j;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.n;
import com.tencent.mm.plugin.mmsight.model.a.t;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import d.g.a.m;
import d.g.b.p;
import d.z;
import java.nio.ByteBuffer;

public final class c
  implements b
{
  private static final Object hvB;
  protected int bufId;
  protected boolean gEz;
  private EGLContext hoR;
  protected boolean htY;
  private boolean htg;
  private final Object huL;
  protected String huM;
  protected int huN;
  protected float huO;
  private int huP;
  private float huQ;
  protected com.tencent.mm.plugin.mmsight.model.a.c huR;
  protected com.tencent.mm.media.e.b huS;
  protected int huT;
  protected int huU;
  protected int huV;
  protected int huW;
  protected int huX;
  protected t huY;
  protected int huZ;
  private boolean hvA;
  private Runnable hvC;
  protected g hvD;
  protected boolean hva;
  protected String hvb;
  protected boolean hvc;
  protected String hvd;
  protected boolean hve;
  protected com.tencent.mm.plugin.mmsight.model.c hvf;
  protected com.tencent.mm.plugin.mmsight.model.c hvg;
  protected VideoTransPara hvh;
  protected n hvi;
  protected boolean hvj;
  protected int hvk;
  protected d.a hvl;
  protected Runnable hvm;
  protected boolean hvn;
  protected boolean hvo;
  protected boolean hvp;
  private long hvq;
  private c.a hvr;
  private com.tencent.mm.media.i.a hvs;
  private long hvt;
  private long hvu;
  public boolean hvv;
  private double hvw;
  private long hvx;
  private long hvy;
  private long hvz;
  protected String mFileName;
  protected String md5;
  private boolean released;
  private SurfaceTexture surfaceTexture;
  private int textureId;
  protected String thumbPath;
  
  static
  {
    AppMethodBeat.i(93397);
    hvB = new Object();
    AppMethodBeat.o(93397);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama)
  {
    this(paramVideoTransPara, parama, null, -1, null);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt)
  {
    AppMethodBeat.i(93367);
    this.huL = new Object();
    this.huM = "";
    this.huN = 0;
    this.huO = 0.0F;
    this.huP = -1;
    this.huQ = -1.0F;
    this.huT = 480;
    this.huU = 640;
    this.huV = 1600000;
    this.huW = 480;
    this.huX = 640;
    this.bufId = -1;
    this.hva = false;
    this.hvb = null;
    this.hvc = false;
    this.thumbPath = null;
    this.hvd = null;
    this.hve = false;
    this.hvf = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hvg = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gEz = false;
    this.hvj = false;
    this.md5 = "";
    this.htY = false;
    this.hvk = 0;
    this.hvm = null;
    this.hvn = false;
    this.hvo = true;
    this.hvp = false;
    this.htg = false;
    this.hvq = 0L;
    this.hvr = null;
    this.hvs = null;
    this.hoR = null;
    this.textureId = -1;
    this.hvt = 0L;
    this.hvu = 0L;
    this.hvv = false;
    this.hvw = 0.0D;
    this.hvx = 0L;
    this.hvy = 0L;
    this.hvz = 0L;
    this.hvA = false;
    this.released = false;
    this.hvC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219325);
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.huY.vQE = d.c.vPr;
        com.tencent.mm.media.i.a locala = c.a(c.this);
        d.g.a.a local1 = new d.g.a.a() {};
        p.h(local1, "callback");
        locala.i((d.g.a.a)new a.j(local1));
        AppMethodBeat.o(219325);
      }
    };
    this.hvD = new g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(219327);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(219327);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.hoR = paramEGLContext;
    this.hvs = new com.tencent.mm.media.i.a(parama);
    this.textureId = paramInt;
    ad.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93367);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt, c.a parama1)
  {
    AppMethodBeat.i(93366);
    this.huL = new Object();
    this.huM = "";
    this.huN = 0;
    this.huO = 0.0F;
    this.huP = -1;
    this.huQ = -1.0F;
    this.huT = 480;
    this.huU = 640;
    this.huV = 1600000;
    this.huW = 480;
    this.huX = 640;
    this.bufId = -1;
    this.hva = false;
    this.hvb = null;
    this.hvc = false;
    this.thumbPath = null;
    this.hvd = null;
    this.hve = false;
    this.hvf = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hvg = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gEz = false;
    this.hvj = false;
    this.md5 = "";
    this.htY = false;
    this.hvk = 0;
    this.hvm = null;
    this.hvn = false;
    this.hvo = true;
    this.hvp = false;
    this.htg = false;
    this.hvq = 0L;
    this.hvr = null;
    this.hvs = null;
    this.hoR = null;
    this.textureId = -1;
    this.hvt = 0L;
    this.hvu = 0L;
    this.hvv = false;
    this.hvw = 0.0D;
    this.hvx = 0L;
    this.hvy = 0L;
    this.hvz = 0L;
    this.hvA = false;
    this.released = false;
    this.hvC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219325);
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.huY.vQE = d.c.vPr;
        com.tencent.mm.media.i.a locala = c.a(c.this);
        d.g.a.a local1 = new d.g.a.a() {};
        p.h(local1, "callback");
        locala.i((d.g.a.a)new a.j(local1));
        AppMethodBeat.o(219325);
      }
    };
    this.hvD = new g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(219327);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(219327);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.hvr = parama1;
    this.hoR = paramEGLContext;
    this.hvs = new com.tencent.mm.media.i.a(parama);
    this.textureId = paramInt;
    ad.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93366);
  }
  
  private void a(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93368);
    this.hvq = 0L;
    this.hvh = paramVideoTransPara;
    this.huT = paramVideoTransPara.width;
    this.huU = paramVideoTransPara.height;
    this.huY = new t();
    paramVideoTransPara = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.auz();
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.huT), Integer.valueOf(this.huU) });
    AppMethodBeat.o(93368);
  }
  
  private void axO()
  {
    AppMethodBeat.i(93370);
    int i = this.huT;
    int j = this.huU;
    this.hvs.cS(i, j);
    this.hvs.nd(this.huZ);
    this.hvs.cU(this.huW, this.huX);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.huW), Integer.valueOf(this.huX), Integer.valueOf(this.huZ) });
    AppMethodBeat.o(93370);
  }
  
  private boolean axP()
  {
    AppMethodBeat.i(93374);
    long l = bt.HI();
    if (this.huS == null)
    {
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, videoEncoder is null");
      AppMethodBeat.o(93374);
      return false;
    }
    int i = this.huS.frameNum;
    if (this.huN <= 0)
    {
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, mDurationMS error %s", new Object[] { Integer.valueOf(this.huN) });
      AppMethodBeat.o(93374);
      return false;
    }
    this.huO = (i * 1000.0F / this.huN);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.huO), Integer.valueOf(this.huN), this.huM, Long.valueOf(bt.aO(l)), Integer.valueOf(this.huP), Float.valueOf(this.huQ) });
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] frameCountCallback %s", new Object[] { this.hvg.getValue() });
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] yuvRecorderWriteDataCallback %s", new Object[] { this.hvf.getValue() });
    String str = null;
    label369:
    float f;
    int j;
    int k;
    int m;
    if (CaptureMMProxy.getInstance() != null)
    {
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      if (bt.isNullOrNil(str)) {
        break label651;
      }
      str = com.tencent.mm.plugin.mmsight.d.ep(str, hashCode());
      i = this.huN;
      if (this.huP > 0) {
        i = this.huP;
      }
      f = this.huO;
      if (this.huQ > 0.0F) {
        f = this.huQ;
      }
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxResultPath : " + str);
      j = this.bufId;
      k = this.huV;
      m = this.hvh.audioSampleRate;
      if ((!this.hvp) || (this.hvA)) {
        break label660;
      }
    }
    Object localObject;
    label651:
    label660:
    for (boolean bool = true;; bool = false)
    {
      localObject = new n(j, str, f, k, i, m, bool, false, this.hva);
      l = bt.HI();
      bool = ((n)localObject).dnk();
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux used %sms, success: %s", new Object[] { Long.valueOf(bt.aO(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label666;
      }
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux failed!");
      l.dmZ();
      AppMethodBeat.o(93374);
      return false;
      if (bt.isNullOrNil(this.huM)) {
        break;
      }
      str = q.B(new com.tencent.mm.vfs.e(this.huM).fOJ().fOK());
      break;
      str = this.huM;
      break label369;
    }
    label666:
    if (this.htY)
    {
      l = bt.HI();
      if (this.hvk != 270) {
        break label956;
      }
    }
    for (i = 270;; i = 90)
    {
      SightVideoJNI.tagRotateVideoVFS(str, this.hvb, i);
      this.hve = true;
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.huZ), Boolean.valueOf(this.htY), Integer.valueOf(this.hvk), Integer.valueOf(i) });
      l = bt.HI();
      try
      {
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.vfs.i.mA(this.hvb, str);
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] copyFile cost %s", new Object[] { Long.valueOf(bt.aO(l)) });
        localObject = this.hvb;
        com.tencent.e.h.LTJ.f(new c.9(this, (String)localObject), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.huY.a(d.c.vPs);
        this.md5 = com.tencent.mm.vfs.i.aPK(str);
        if ((!bt.isNullOrNil(str)) && (!str.equals(this.huM)))
        {
          com.tencent.mm.vfs.i.mA(str, this.huM);
          com.tencent.mm.vfs.i.deleteFile(str);
        }
        AppMethodBeat.o(93374);
        return true;
      }
      catch (Exception localException)
      {
        label956:
        ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, copy file error");
        AppMethodBeat.o(93374);
      }
    }
    return false;
  }
  
  private void axQ()
  {
    this.hvt = 0L;
    this.hvu = 0L;
    this.hvw = 0.0D;
    this.hvx = 0L;
    this.hvy = 0L;
    this.hvz = 0L;
  }
  
  private boolean ayb()
  {
    AppMethodBeat.i(93391);
    if ((this.huY.vQE == d.c.vPp) || (this.huY.vQE == d.c.vPq))
    {
      if (this.huY.vQE == d.c.vPq)
      {
        this.huY.vQE = d.c.vPr;
        ad.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] forward one more frame", new Object[0]);
      }
      if (this.huR != null) {
        this.huR.dni();
      }
      this.hvg.yf(1L);
      this.hvf.yf(1L);
      AppMethodBeat.o(93391);
      return true;
    }
    AppMethodBeat.o(93391);
    return false;
  }
  
  private void da(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(177314);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
    long l = bt.HI();
    int i = 0;
    while (i < 3)
    {
      k.vQc.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
      i += 1;
    }
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(177314);
  }
  
  private boolean oc(int paramInt)
  {
    AppMethodBeat.i(93369);
    this.released = false;
    long l = bt.HI();
    this.huV = this.hvh.videoBitrate;
    if (this.hvh.hVB == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = new com.tencent.mm.media.b.d(bool);
      if (!((com.tencent.mm.media.b.d)???).hhS) {
        break;
      }
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] encodeConfig  InitError");
      ??? = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auH();
      AppMethodBeat.o(93369);
      return false;
    }
    this.hva = p.i(((com.tencent.mm.media.b.d)???).mimeType, "video/hevc");
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.huW, this.huX, paramInt, this.huT, this.huU, this.hvh.fps, this.huV, this.hvh.hVf, 8, this.hvh.hVe, 23.0F, false, false, this.hvh.duration, false, this.hva, com.tencent.mm.plugin.sight.base.b.ag(false, this.hva));
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init failed!");
      ??? = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auA();
      AppMethodBeat.o(93369);
      return false;
    }
    this.huZ = paramInt;
    this.huU = com.tencent.mm.plugin.mmsight.d.Kg(this.huU);
    this.huT = com.tencent.mm.plugin.mmsight.d.Kg(this.huT);
    Object localObject2;
    if ((this.hva) && (((com.tencent.mm.media.b.d)???).mimeType.equals("video/hevc")))
    {
      localObject2 = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.avq();
    }
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mTargetRate " + this.huV + "  videoParams.fps: " + this.hvh.fps + " mTargetHeight:" + this.huU + " mTargetWidth:" + this.huT + ", minQP:" + this.hvh.hhV + ", maxQP:" + this.hvh.hhW);
    ((com.tencent.mm.media.b.d)???).bitrate = this.huV;
    ((com.tencent.mm.media.b.d)???).frameRate = this.hvh.fps;
    ((com.tencent.mm.media.b.d)???).targetHeight = this.huU;
    ((com.tencent.mm.media.b.d)???).targetWidth = this.huT;
    ((com.tencent.mm.media.b.d)???).hhW = this.hvh.hhW;
    ((com.tencent.mm.media.b.d)???).hhV = this.hvh.hhV;
    try
    {
      this.huS = new com.tencent.mm.media.e.e((com.tencent.mm.media.b.d)???, true, new d.g.a.b() {});
      ??? = this.hvs;
      localObject2 = this.huS.getInputSurface();
      EGLContext localEGLContext = this.hoR;
      d.g.a.b local5 = new d.g.a.b()
      {
        private z e(Boolean arg1)
        {
          AppMethodBeat.i(219330);
          if (!???.booleanValue())
          {
            ??? = com.tencent.mm.media.k.d.hoU;
            com.tencent.mm.media.k.d.auB();
          }
          synchronized (c.ayd())
          {
            try
            {
              c.ayd().notifyAll();
              AppMethodBeat.o(219330);
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
      p.h(localObject2, "surface");
      ((com.tencent.mm.media.i.a)???).surface = ((Surface)localObject2);
      ad.i(((com.tencent.mm.media.i.a)???).TAG, ((com.tencent.mm.media.i.a)???).hashCode() + " initWithSurface, eglContext:" + localEGLContext + ", surface:" + localObject2 + ", waitNewFrame:false, callback:false");
      ((com.tencent.mm.media.i.a)???).i((d.g.a.a)new a.d((com.tencent.mm.media.i.a)???, localEGLContext, (Surface)localObject2, local5));
      synchronized (hvB)
      {
        try
        {
          hvB.wait(500L);
          this.hvs.hkU = new d.g.a.b() {};
          axO();
          this.huR = new a(this.hvh.audioSampleRate, this.hvh.audioBitrate, this.hvh.audioChannelCount, com.tencent.mm.plugin.sight.base.b.ag(false, this.hva));
          this.huR.os(this.hvn);
          paramInt = this.huR.E(this.bufId, com.tencent.mm.plugin.sight.base.e.axv(this.huM));
          ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl used %sms, ret:%s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(paramInt) });
          if (paramInt != 0)
          {
            ??? = com.tencent.mm.media.k.d.hoU;
            com.tencent.mm.media.k.d.auC();
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
      com.tencent.mm.media.k.d locald;
      AppMethodBeat.o(93369);
    }
    catch (Exception localException1)
    {
      release();
      ad.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException1, "[" + hashCode() + "] init encoder error", new Object[0]);
      ax.flg().putBoolean("mediacodec_create_error", true);
      locald = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auA();
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
      this.huY.a(d.c.vPr);
      synchronized (this.huL)
      {
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release videoEncoder");
        if (this.huS != null)
        {
          this.huS.ats();
          this.huS.att();
          this.huS = null;
          com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.avh();
        }
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] end release videoEncoder");
        if (this.huR != null)
        {
          this.huR.a(new c.10(this));
          this.huR.clear();
          this.huR = null;
        }
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] release buf-id ? %d", new Object[] { Integer.valueOf(this.bufId) });
        if (this.bufId >= 0) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        }
        this.huY.a(d.c.vPs);
        if (this.hvs != null) {
          this.hvs.release();
        }
        axQ();
        this.hvv = false;
        this.hvj = false;
        this.hvi = null;
        this.gEz = false;
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
  
  public final void D(Runnable paramRunnable)
  {
    AppMethodBeat.i(93373);
    this.hvm = paramRunnable;
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] !!!!!stop, stopCallback: %s !!!", new Object[] { paramRunnable });
    if ((this.huS == null) || ((this.huR == null) && (!this.hvp)))
    {
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        aq.f(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    if ((this.huY != null) && (this.huY.vQE == d.c.vPs))
    {
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, already in stop videoRecordStatus");
      if (this.huR != null) {
        this.huR.clear();
      }
      if (paramRunnable != null) {
        aq.f(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    paramRunnable = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.auD();
    if (this.huY != null)
    {
      com.tencent.e.h.LTJ.b(this.hvC, 1500L, "record_stop_timeout");
      this.huY.a(d.c.vPq);
    }
    if (this.hvy > 0L)
    {
      long l1 = System.nanoTime();
      long l2 = this.hvy;
      float f = (float)this.hvz;
      this.hvz = (((float)(l1 - l2) / 1000000.0F + f));
    }
    this.huN = ((int)this.huS.atw());
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, mDurationMS:%s, accumulatePauseTime:%s", new Object[] { Integer.valueOf(this.huN), Long.valueOf(this.hvz) });
    if (this.hvz > 0L) {
      this.huN = ((int)(this.huN - this.hvz));
    }
    AppMethodBeat.o(93373);
  }
  
  public final void L(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93385);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.huZ = paramInt1;
    this.huW = paramInt2;
    this.huX = paramInt3;
    this.hvs.nd(paramInt1);
    axO();
    if ((this.huY != null) && (this.huY.vQE == d.c.vPx))
    {
      this.huY.a(d.c.vPp);
      if (this.huR != null) {
        this.huR.resume();
      }
    }
    AppMethodBeat.o(93385);
  }
  
  public final String Lb()
  {
    AppMethodBeat.i(93375);
    String str = bt.bI(this.md5, "");
    AppMethodBeat.o(93375);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.mmsight.model.a.c paramc)
  {
    AppMethodBeat.i(93392);
    if (paramc != null)
    {
      this.hvA = true;
      paramc.ob(this.bufId);
    }
    AppMethodBeat.o(93392);
  }
  
  public final void a(d.a parama)
  {
    this.hvl = parama;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(93389);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.huQ = paramFloat;
    AppMethodBeat.o(93389);
  }
  
  public final boolean aol()
  {
    return this.htY;
  }
  
  public final String axA()
  {
    return this.thumbPath;
  }
  
  public final void axN()
  {
    AppMethodBeat.i(93390);
    long l;
    if ((this.textureId < 0) || (!ayb()))
    {
      if ((this.surfaceTexture == null) || (!ayb())) {
        AppMethodBeat.o(93390);
      }
    }
    else
    {
      if (this.hvy > 0L)
      {
        l = System.nanoTime() - this.hvy;
        this.hvx += l;
        float f = (float)this.hvz;
        this.hvz = (((float)l / 1000000.0F + f));
        this.hvy = 0L;
      }
      ad.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureDataUpdate, lastPausePtsDiff:%s", new Object[] { Long.valueOf(this.hvx) });
      if (this.hvu <= 0L) {
        break label391;
      }
      l = System.nanoTime() - this.hvu + this.hvt - this.hvx;
      this.hvx = 0L;
    }
    for (;;)
    {
      if (this.hvv) {
        if ((this.huY.vQE == d.c.vPr) || (this.hvt == 0L) || (l - this.hvt >= this.hvw * 1000000.0D))
        {
          this.hvs.v(this.textureId, l);
          this.hvt = l;
        }
      }
      for (this.hvu = System.nanoTime();; this.hvu = System.nanoTime())
      {
        ad.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureDataUpdate pts:%s, lastTexturePts:%s, lastTextureNanoTime:%s, accumulatePauseTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.hvt), Long.valueOf(this.hvu), Long.valueOf(this.hvz) });
        break;
        this.hvs.v(this.textureId, l);
        this.hvt = l;
      }
      com.tencent.mm.media.i.a locala = this.hvs;
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      p.h(localSurfaceTexture, "surfaceTexture");
      locala.i((d.g.a.a)new a.i(locala, localSurfaceTexture));
      AppMethodBeat.o(93390);
      return;
      label391:
      l = 0L;
    }
  }
  
  public final String axR()
  {
    return this.hvd;
  }
  
  public final float axS()
  {
    return this.huO;
  }
  
  public final long axT()
  {
    AppMethodBeat.i(93380);
    if (this.huS != null)
    {
      long l = this.huS.atw();
      AppMethodBeat.o(93380);
      return l;
    }
    AppMethodBeat.o(93380);
    return 0L;
  }
  
  public final d.c axU()
  {
    return this.huY.vQE;
  }
  
  public final int axV()
  {
    AppMethodBeat.i(93382);
    int i = Math.round(this.huN / 1000.0F);
    AppMethodBeat.o(93382);
    return i;
  }
  
  public final Point axW()
  {
    AppMethodBeat.i(93383);
    Point localPoint = new Point(this.huW, this.huX);
    AppMethodBeat.o(93383);
    return localPoint;
  }
  
  public final int axX()
  {
    return this.huZ;
  }
  
  public final boolean axY()
  {
    return this.hvj;
  }
  
  public final com.tencent.mm.audio.b.c.a axZ()
  {
    AppMethodBeat.i(93386);
    if (this.huR != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.huR.dnj();
      AppMethodBeat.o(93386);
      return locala;
    }
    AppMethodBeat.o(93386);
    return null;
  }
  
  public final void aya()
  {
    this.hvo = false;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.c ayc()
  {
    return this.huR;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93372);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hvf.reset();
    this.huN = 0;
    this.hvt = 0L;
    this.hvg.reset();
    this.hvc = false;
    this.htY = paramBoolean;
    this.hvk = paramInt2;
    axQ();
    this.hvw = (1000.0F / this.hvh.fps);
    this.huY.a(d.c.vPo);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, checkDropFrameByPts: %s, perFrmaeDuration:%s", new Object[] { Boolean.valueOf(this.hvv), Double.valueOf(this.hvw) });
    if (bt.isNullOrNil(this.huM))
    {
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93372);
      return -1;
    }
    try
    {
      this.mFileName = com.tencent.mm.vfs.i.aYt(this.huM);
      String str2 = com.tencent.mm.vfs.i.aYr(this.huM);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.hvb = (str1 + hashCode() + "tempRotate.mp4");
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tempRotateFilePath:" + this.hvb);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.huY.a(d.c.vPw);
        continue;
        ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start yuvRecorder with mute");
        this.huY.a(d.c.vPp);
        this.hvj = false;
        paramInt1 = 0;
      }
    }
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.huM, this.hvb });
    this.huZ = paramInt1;
    axO();
    if (!this.gEz)
    {
      oc(paramInt1);
      this.gEz = true;
    }
    axO();
    if ((!this.hvp) && (!this.hvn) && (this.huR != null))
    {
      paramInt1 = this.huR.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void ayf()
        {
          AppMethodBeat.i(219333);
          ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] onPcmReady");
          if (c.this.axU() != d.c.vPw)
          {
            ad.w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(219333);
            return;
          }
          c.this.huY.a(d.c.vPp);
          AppMethodBeat.o(219333);
        }
      });
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.hvj = false;
      if (paramInt1 != 0)
      {
        this.huY.a(d.c.vPv);
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
  
  public final void es(boolean paramBoolean)
  {
    this.hvn = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.huM;
  }
  
  public final g getFrameDataCallback()
  {
    return this.hvD;
  }
  
  public final boolean od(int paramInt)
  {
    AppMethodBeat.i(93371);
    if (!this.gEz)
    {
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preInit, cameraOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = oc(paramInt);
      this.gEz = true;
      ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93371);
      return bool;
    }
    AppMethodBeat.o(93371);
    return true;
  }
  
  public final void oe(int paramInt)
  {
    AppMethodBeat.i(93387);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.huP = paramInt;
    AppMethodBeat.o(93387);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93384);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] pause");
    if ((this.huY != null) && (this.huY.vQE == d.c.vPp))
    {
      this.huY.a(d.c.vPx);
      if (this.huR != null) {
        this.huR.pause();
      }
      this.hvy = System.nanoTime();
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
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93381);
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.Kg(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.Kg(paramInt4);
    }
    ad.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.huW = paramInt1;
    this.huX = paramInt2;
    if (k.vQc.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null) {
      da(paramInt1, paramInt2);
    }
    AppMethodBeat.o(93381);
  }
  
  public final void setFilePath(String paramString)
  {
    this.huM = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(93388);
    this.hvs.hlj.eg(paramBoolean);
    AppMethodBeat.o(93388);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.hvp = paramBoolean;
  }
  
  public final void yo(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void yp(String paramString)
  {
    this.hvd = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c
 * JD-Core Version:    0.7.0.1
 */