package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.a.d;
import com.tencent.mm.media.i.a.i;
import com.tencent.mm.media.i.a.j;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.n;
import com.tencent.mm.plugin.mmsight.model.a.t;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import d.g.a.m;
import d.g.b.p;
import d.z;
import java.nio.ByteBuffer;

public final class c
  implements b
{
  private static final Object hyp;
  protected int bufId;
  protected boolean gHg;
  private EGLContext hrF;
  private boolean hvU;
  protected boolean hwM;
  protected String hxA;
  protected int hxB;
  protected float hxC;
  private int hxD;
  private float hxE;
  protected com.tencent.mm.plugin.mmsight.model.a.c hxF;
  protected com.tencent.mm.media.e.b hxG;
  protected int hxH;
  protected int hxI;
  protected int hxJ;
  protected int hxK;
  protected int hxL;
  protected t hxM;
  protected int hxN;
  protected boolean hxO;
  protected String hxP;
  protected boolean hxQ;
  protected String hxR;
  protected boolean hxS;
  protected com.tencent.mm.plugin.mmsight.model.c hxT;
  protected com.tencent.mm.plugin.mmsight.model.c hxU;
  protected VideoTransPara hxV;
  protected n hxW;
  protected boolean hxX;
  protected int hxY;
  protected d.a hxZ;
  private final Object hxz;
  protected Runnable hya;
  protected boolean hyb;
  protected boolean hyc;
  protected boolean hyd;
  private long hye;
  private a hyf;
  private com.tencent.mm.media.i.a hyg;
  private long hyh;
  private long hyi;
  public boolean hyj;
  private double hyk;
  private long hyl;
  private long hym;
  private long hyn;
  private boolean hyo;
  private Runnable hyq;
  protected g hyr;
  protected String mFileName;
  protected String md5;
  private boolean released;
  private SurfaceTexture surfaceTexture;
  private int textureId;
  protected String thumbPath;
  
  static
  {
    AppMethodBeat.i(93397);
    hyp = new Object();
    AppMethodBeat.o(93397);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama)
  {
    this(paramVideoTransPara, parama, null, -1, null);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt)
  {
    AppMethodBeat.i(93367);
    this.hxz = new Object();
    this.hxA = "";
    this.hxB = 0;
    this.hxC = 0.0F;
    this.hxD = -1;
    this.hxE = -1.0F;
    this.hxH = 480;
    this.hxI = 640;
    this.hxJ = 1600000;
    this.hxK = 480;
    this.hxL = 640;
    this.bufId = -1;
    this.hxO = false;
    this.hxP = null;
    this.hxQ = false;
    this.thumbPath = null;
    this.hxR = null;
    this.hxS = false;
    this.hxT = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hxU = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gHg = false;
    this.hxX = false;
    this.md5 = "";
    this.hwM = false;
    this.hxY = 0;
    this.hya = null;
    this.hyb = false;
    this.hyc = true;
    this.hyd = false;
    this.hvU = false;
    this.hye = 0L;
    this.hyf = null;
    this.hyg = null;
    this.hrF = null;
    this.textureId = -1;
    this.hyh = 0L;
    this.hyi = 0L;
    this.hyj = false;
    this.hyk = 0.0D;
    this.hyl = 0L;
    this.hym = 0L;
    this.hyn = 0L;
    this.hyo = false;
    this.released = false;
    this.hyq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217501);
        ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.hxM.wcI = d.c.wbu;
        com.tencent.mm.media.i.a locala = c.a(c.this);
        d.g.a.a local1 = new d.g.a.a() {};
        p.h(local1, "callback");
        locala.j((d.g.a.a)new a.j(local1));
        AppMethodBeat.o(217501);
      }
    };
    this.hyr = new g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(217503);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(217503);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.hrF = paramEGLContext;
    this.hyg = new com.tencent.mm.media.i.a(parama);
    this.textureId = paramInt;
    ae.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93367);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt, a parama1)
  {
    AppMethodBeat.i(93366);
    this.hxz = new Object();
    this.hxA = "";
    this.hxB = 0;
    this.hxC = 0.0F;
    this.hxD = -1;
    this.hxE = -1.0F;
    this.hxH = 480;
    this.hxI = 640;
    this.hxJ = 1600000;
    this.hxK = 480;
    this.hxL = 640;
    this.bufId = -1;
    this.hxO = false;
    this.hxP = null;
    this.hxQ = false;
    this.thumbPath = null;
    this.hxR = null;
    this.hxS = false;
    this.hxT = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hxU = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gHg = false;
    this.hxX = false;
    this.md5 = "";
    this.hwM = false;
    this.hxY = 0;
    this.hya = null;
    this.hyb = false;
    this.hyc = true;
    this.hyd = false;
    this.hvU = false;
    this.hye = 0L;
    this.hyf = null;
    this.hyg = null;
    this.hrF = null;
    this.textureId = -1;
    this.hyh = 0L;
    this.hyi = 0L;
    this.hyj = false;
    this.hyk = 0.0D;
    this.hyl = 0L;
    this.hym = 0L;
    this.hyn = 0L;
    this.hyo = false;
    this.released = false;
    this.hyq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217501);
        ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.hxM.wcI = d.c.wbu;
        com.tencent.mm.media.i.a locala = c.a(c.this);
        d.g.a.a local1 = new d.g.a.a() {};
        p.h(local1, "callback");
        locala.j((d.g.a.a)new a.j(local1));
        AppMethodBeat.o(217501);
      }
    };
    this.hyr = new g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(217503);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(217503);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.hyf = parama1;
    this.hrF = paramEGLContext;
    this.hyg = new com.tencent.mm.media.i.a(parama);
    this.textureId = paramInt;
    ae.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93366);
  }
  
  private void a(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93368);
    this.hye = 0L;
    this.hxV = paramVideoTransPara;
    this.hxH = paramVideoTransPara.width;
    this.hxI = paramVideoTransPara.height;
    this.hxM = new t();
    paramVideoTransPara = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.auO();
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.hxH), Integer.valueOf(this.hxI) });
    AppMethodBeat.o(93368);
  }
  
  private void ayd()
  {
    AppMethodBeat.i(93370);
    int i = this.hxH;
    int j = this.hxI;
    this.hyg.cS(i, j);
    this.hyg.ng(this.hxN);
    this.hyg.cU(this.hxK, this.hxL);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.hxK), Integer.valueOf(this.hxL), Integer.valueOf(this.hxN) });
    AppMethodBeat.o(93370);
  }
  
  private boolean aye()
  {
    AppMethodBeat.i(93374);
    long l = bu.HQ();
    if (this.hxG == null)
    {
      ae.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, videoEncoder is null");
      AppMethodBeat.o(93374);
      return false;
    }
    int i = this.hxG.frameNum;
    if (this.hxB <= 0)
    {
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, mDurationMS error %s", new Object[] { Integer.valueOf(this.hxB) });
      AppMethodBeat.o(93374);
      return false;
    }
    this.hxC = (i * 1000.0F / this.hxB);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.hxC), Integer.valueOf(this.hxB), this.hxA, Long.valueOf(bu.aO(l)), Integer.valueOf(this.hxD), Float.valueOf(this.hxE) });
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] frameCountCallback %s", new Object[] { this.hxU.getValue() });
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] yuvRecorderWriteDataCallback %s", new Object[] { this.hxT.getValue() });
    String str = null;
    label369:
    float f;
    int j;
    int k;
    int m;
    if (CaptureMMProxy.getInstance() != null)
    {
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      if (bu.isNullOrNil(str)) {
        break label651;
      }
      str = com.tencent.mm.plugin.mmsight.d.ew(str, hashCode());
      i = this.hxB;
      if (this.hxD > 0) {
        i = this.hxD;
      }
      f = this.hxC;
      if (this.hxE > 0.0F) {
        f = this.hxE;
      }
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxResultPath : " + str);
      j = this.bufId;
      k = this.hxJ;
      m = this.hxV.audioSampleRate;
      if ((!this.hyd) || (this.hyo)) {
        break label660;
      }
    }
    Object localObject;
    label651:
    label660:
    for (boolean bool = true;; bool = false)
    {
      localObject = new n(j, str, f, k, i, m, bool, false, this.hxO);
      l = bu.HQ();
      bool = ((n)localObject).dqi();
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux used %sms, success: %s", new Object[] { Long.valueOf(bu.aO(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label666;
      }
      ae.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux failed!");
      l.dpX();
      AppMethodBeat.o(93374);
      return false;
      if (bu.isNullOrNil(this.hxA)) {
        break;
      }
      str = w.B(new com.tencent.mm.vfs.k(this.hxA).fTg().fTh());
      break;
      str = this.hxA;
      break label369;
    }
    label666:
    if (this.hwM)
    {
      l = bu.HQ();
      if (this.hxY != 270) {
        break label956;
      }
    }
    for (i = 270;; i = 90)
    {
      SightVideoJNI.tagRotateVideoVFS(str, this.hxP, i);
      this.hxS = true;
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hxN), Boolean.valueOf(this.hwM), Integer.valueOf(this.hxY), Integer.valueOf(i) });
      l = bu.HQ();
      try
      {
        o.deleteFile(str);
        o.mG(this.hxP, str);
        ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] copyFile cost %s", new Object[] { Long.valueOf(bu.aO(l)) });
        localObject = this.hxP;
        com.tencent.e.h.MqF.f(new c.9(this, (String)localObject), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.hxM.a(d.c.wbv);
        this.md5 = o.aRh(str);
        if ((!bu.isNullOrNil(str)) && (!str.equals(this.hxA)))
        {
          o.mG(str, this.hxA);
          o.deleteFile(str);
        }
        AppMethodBeat.o(93374);
        return true;
      }
      catch (Exception localException)
      {
        label956:
        ae.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, copy file error");
        AppMethodBeat.o(93374);
      }
    }
    return false;
  }
  
  private void ayf()
  {
    this.hyh = 0L;
    this.hyi = 0L;
    this.hyk = 0.0D;
    this.hyl = 0L;
    this.hym = 0L;
    this.hyn = 0L;
  }
  
  private boolean ayq()
  {
    AppMethodBeat.i(93391);
    if ((this.hxM.wcI == d.c.wbs) || (this.hxM.wcI == d.c.wbt))
    {
      if (this.hxM.wcI == d.c.wbt)
      {
        this.hxM.wcI = d.c.wbu;
        ae.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] forward one more frame", new Object[0]);
      }
      if (this.hxF != null) {
        this.hxF.dqg();
      }
      this.hxU.yz(1L);
      this.hxT.yz(1L);
      AppMethodBeat.o(93391);
      return true;
    }
    AppMethodBeat.o(93391);
    return false;
  }
  
  private void da(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(177314);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
    long l = bu.HQ();
    int i = 0;
    while (i < 3)
    {
      com.tencent.mm.plugin.mmsight.model.a.k.wcg.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
      i += 1;
    }
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(177314);
  }
  
  private boolean of(int paramInt)
  {
    AppMethodBeat.i(93369);
    this.released = false;
    long l = bu.HQ();
    this.hxJ = this.hxV.videoBitrate;
    if (this.hxV.hYt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = new com.tencent.mm.media.b.d(bool);
      if (!((com.tencent.mm.media.b.d)???).hkG) {
        break;
      }
      ae.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] encodeConfig  InitError");
      ??? = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.auW();
      AppMethodBeat.o(93369);
      return false;
    }
    this.hxO = p.i(((com.tencent.mm.media.b.d)???).mimeType, "video/hevc");
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.hxK, this.hxL, paramInt, this.hxH, this.hxI, this.hxV.fps, this.hxJ, this.hxV.hXX, 8, this.hxV.hXW, 23.0F, false, false, this.hxV.duration, false, this.hxO, com.tencent.mm.plugin.sight.base.b.af(false, this.hxO));
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      ae.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init failed!");
      ??? = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.auP();
      AppMethodBeat.o(93369);
      return false;
    }
    this.hxN = paramInt;
    this.hxI = com.tencent.mm.plugin.mmsight.d.KG(this.hxI);
    this.hxH = com.tencent.mm.plugin.mmsight.d.KG(this.hxH);
    Object localObject2;
    if ((this.hxO) && (((com.tencent.mm.media.b.d)???).mimeType.equals("video/hevc")))
    {
      localObject2 = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avF();
    }
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mTargetRate " + this.hxJ + "  videoParams.fps: " + this.hxV.fps + " mTargetHeight:" + this.hxI + " mTargetWidth:" + this.hxH + ", minQP:" + this.hxV.hkJ + ", maxQP:" + this.hxV.hkK);
    ((com.tencent.mm.media.b.d)???).bitrate = this.hxJ;
    ((com.tencent.mm.media.b.d)???).frameRate = this.hxV.fps;
    ((com.tencent.mm.media.b.d)???).targetHeight = this.hxI;
    ((com.tencent.mm.media.b.d)???).targetWidth = this.hxH;
    ((com.tencent.mm.media.b.d)???).hkK = this.hxV.hkK;
    ((com.tencent.mm.media.b.d)???).hkJ = this.hxV.hkJ;
    try
    {
      this.hxG = new com.tencent.mm.media.e.e((com.tencent.mm.media.b.d)???, true, new d.g.a.b() {});
      ??? = this.hyg;
      localObject2 = this.hxG.getInputSurface();
      EGLContext localEGLContext = this.hrF;
      d.g.a.b local5 = new d.g.a.b()
      {
        private z e(Boolean arg1)
        {
          AppMethodBeat.i(217506);
          if (!???.booleanValue())
          {
            ??? = com.tencent.mm.media.k.d.hrI;
            com.tencent.mm.media.k.d.auQ();
          }
          synchronized (c.ays())
          {
            try
            {
              c.ays().notifyAll();
              AppMethodBeat.o(217506);
              return null;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "[" + hashCode() + "] initSurfaceLock notify error", new Object[0]);
              }
            }
          }
        }
      };
      p.h(localObject2, "surface");
      ((com.tencent.mm.media.i.a)???).surface = ((Surface)localObject2);
      ae.i(((com.tencent.mm.media.i.a)???).TAG, ((com.tencent.mm.media.i.a)???).hashCode() + " initWithSurface, eglContext:" + localEGLContext + ", surface:" + localObject2 + ", waitNewFrame:false, callback:false");
      ((com.tencent.mm.media.i.a)???).j((d.g.a.a)new a.d((com.tencent.mm.media.i.a)???, localEGLContext, (Surface)localObject2, local5));
      synchronized (hyp)
      {
        try
        {
          hyp.wait(500L);
          this.hyg.hnI = new d.g.a.b() {};
          ayd();
          this.hxF = new a(this.hxV.audioSampleRate, this.hxV.audioBitrate, this.hxV.audioChannelCount, com.tencent.mm.plugin.sight.base.b.af(false, this.hxO));
          this.hxF.ox(this.hyb);
          paramInt = this.hxF.E(this.bufId, com.tencent.mm.plugin.sight.base.e.ayL(this.hxA));
          ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl used %sms, ret:%s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(paramInt) });
          if (paramInt != 0)
          {
            ??? = com.tencent.mm.media.k.d.hrI;
            com.tencent.mm.media.k.d.auR();
            AppMethodBeat.o(93369);
            return false;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException2, "[" + hashCode() + "] initSurfaceLock wait error", new Object[0]);
          }
        }
      }
      com.tencent.mm.media.k.d locald;
      AppMethodBeat.o(93369);
    }
    catch (Exception localException1)
    {
      release();
      ae.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException1, "[" + hashCode() + "] init encoder error", new Object[0]);
      ay.fpb().putBoolean("mediacodec_create_error", true);
      locald = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.auP();
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
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release recorder");
      this.hxM.a(d.c.wbu);
      synchronized (this.hxz)
      {
        ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release videoEncoder");
        if (this.hxG != null)
        {
          this.hxG.atH();
          this.hxG.atI();
          this.hxG = null;
          com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.avw();
        }
        ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] end release videoEncoder");
        if (this.hxF != null)
        {
          this.hxF.a(new c.10(this));
          this.hxF.clear();
          this.hxF = null;
        }
        ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] release buf-id ? %d", new Object[] { Integer.valueOf(this.bufId) });
        if (this.bufId >= 0) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        }
        this.hxM.a(d.c.wbv);
        if (this.hyg != null) {
          this.hyg.release();
        }
        ayf();
        this.hyj = false;
        this.hxX = false;
        this.hxW = null;
        this.gHg = false;
        AppMethodBeat.o(93379);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "[" + hashCode() + "] clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93379);
    }
  }
  
  public final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(93373);
    this.hya = paramRunnable;
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] !!!!!stop, stopCallback: %s !!!", new Object[] { paramRunnable });
    if ((this.hxG == null) || ((this.hxF == null) && (!this.hyd)))
    {
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        ar.f(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbv))
    {
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, already in stop videoRecordStatus");
      if (this.hxF != null) {
        this.hxF.clear();
      }
      if (paramRunnable != null) {
        ar.f(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    paramRunnable = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.auS();
    if (this.hxM != null)
    {
      com.tencent.e.h.MqF.b(this.hyq, 1500L, "record_stop_timeout");
      this.hxM.a(d.c.wbt);
    }
    if (this.hym > 0L)
    {
      long l1 = System.nanoTime();
      long l2 = this.hym;
      float f = (float)this.hyn;
      this.hyn = (((float)(l1 - l2) / 1000000.0F + f));
    }
    this.hxB = ((int)this.hxG.atL());
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, mDurationMS:%s, accumulatePauseTime:%s", new Object[] { Integer.valueOf(this.hxB), Long.valueOf(this.hyn) });
    if (this.hyn > 0L) {
      this.hxB = ((int)(this.hxB - this.hyn));
    }
    AppMethodBeat.o(93373);
  }
  
  public final void L(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93385);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.hxN = paramInt1;
    this.hxK = paramInt2;
    this.hxL = paramInt3;
    this.hyg.ng(paramInt1);
    ayd();
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbA))
    {
      this.hxM.a(d.c.wbs);
      if (this.hxF != null) {
        this.hxF.resume();
      }
    }
    AppMethodBeat.o(93385);
  }
  
  public final String Lj()
  {
    AppMethodBeat.i(93375);
    String str = bu.bI(this.md5, "");
    AppMethodBeat.o(93375);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.mmsight.model.a.c paramc)
  {
    AppMethodBeat.i(93392);
    if (paramc != null)
    {
      this.hyo = true;
      paramc.oe(this.bufId);
    }
    AppMethodBeat.o(93392);
  }
  
  public final void a(d.a parama)
  {
    this.hxZ = parama;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(93389);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.hxE = paramFloat;
    AppMethodBeat.o(93389);
  }
  
  public final boolean aoA()
  {
    return this.hwM;
  }
  
  public final String axP()
  {
    return this.thumbPath;
  }
  
  public final void ayc()
  {
    AppMethodBeat.i(93390);
    long l;
    if ((this.textureId < 0) || (!ayq()))
    {
      if ((this.surfaceTexture == null) || (!ayq())) {
        AppMethodBeat.o(93390);
      }
    }
    else
    {
      if (this.hym > 0L)
      {
        l = System.nanoTime() - this.hym;
        this.hyl += l;
        float f = (float)this.hyn;
        this.hyn = (((float)l / 1000000.0F + f));
        this.hym = 0L;
      }
      ae.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureDataUpdate, lastPausePtsDiff:%s", new Object[] { Long.valueOf(this.hyl) });
      if (this.hyi <= 0L) {
        break label391;
      }
      l = System.nanoTime() - this.hyi + this.hyh - this.hyl;
      this.hyl = 0L;
    }
    for (;;)
    {
      if (this.hyj) {
        if ((this.hxM.wcI == d.c.wbu) || (this.hyh == 0L) || (l - this.hyh >= this.hyk * 1000000.0D))
        {
          this.hyg.v(this.textureId, l);
          this.hyh = l;
        }
      }
      for (this.hyi = System.nanoTime();; this.hyi = System.nanoTime())
      {
        ae.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureDataUpdate pts:%s, lastTexturePts:%s, lastTextureNanoTime:%s, accumulatePauseTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.hyh), Long.valueOf(this.hyi), Long.valueOf(this.hyn) });
        break;
        this.hyg.v(this.textureId, l);
        this.hyh = l;
      }
      com.tencent.mm.media.i.a locala = this.hyg;
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      p.h(localSurfaceTexture, "surfaceTexture");
      locala.j((d.g.a.a)new a.i(locala, localSurfaceTexture));
      AppMethodBeat.o(93390);
      return;
      label391:
      l = 0L;
    }
  }
  
  public final String ayg()
  {
    return this.hxR;
  }
  
  public final float ayh()
  {
    return this.hxC;
  }
  
  public final long ayi()
  {
    AppMethodBeat.i(93380);
    if (this.hxG != null)
    {
      long l = this.hxG.atL();
      AppMethodBeat.o(93380);
      return l;
    }
    AppMethodBeat.o(93380);
    return 0L;
  }
  
  public final d.c ayj()
  {
    return this.hxM.wcI;
  }
  
  public final int ayk()
  {
    AppMethodBeat.i(93382);
    int i = Math.round(this.hxB / 1000.0F);
    AppMethodBeat.o(93382);
    return i;
  }
  
  public final Point ayl()
  {
    AppMethodBeat.i(93383);
    Point localPoint = new Point(this.hxK, this.hxL);
    AppMethodBeat.o(93383);
    return localPoint;
  }
  
  public final int aym()
  {
    return this.hxN;
  }
  
  public final boolean ayn()
  {
    return this.hxX;
  }
  
  public final com.tencent.mm.audio.b.c.a ayo()
  {
    AppMethodBeat.i(93386);
    if (this.hxF != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hxF.dqh();
      AppMethodBeat.o(93386);
      return locala;
    }
    AppMethodBeat.o(93386);
    return null;
  }
  
  public final void ayp()
  {
    this.hyc = false;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.c ayr()
  {
    return this.hxF;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93372);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hxT.reset();
    this.hxB = 0;
    this.hyh = 0L;
    this.hxU.reset();
    this.hxQ = false;
    this.hwM = paramBoolean;
    this.hxY = paramInt2;
    ayf();
    this.hyk = (1000.0F / this.hxV.fps);
    this.hxM.a(d.c.wbr);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, checkDropFrameByPts: %s, perFrmaeDuration:%s", new Object[] { Boolean.valueOf(this.hyj), Double.valueOf(this.hyk) });
    if (bu.isNullOrNil(this.hxA))
    {
      ae.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93372);
      return -1;
    }
    try
    {
      this.mFileName = o.aZW(this.hxA);
      String str2 = o.aZU(this.hxA);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.hxP = (str1 + hashCode() + "tempRotate.mp4");
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tempRotateFilePath:" + this.hxP);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.hxM.a(d.c.wbz);
        continue;
        ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start yuvRecorder with mute");
        this.hxM.a(d.c.wbs);
        this.hxX = false;
        paramInt1 = 0;
      }
    }
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.hxA, this.hxP });
    this.hxN = paramInt1;
    ayd();
    if (!this.gHg)
    {
      of(paramInt1);
      this.gHg = true;
    }
    ayd();
    if ((!this.hyd) && (!this.hyb) && (this.hxF != null))
    {
      paramInt1 = this.hxF.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void ayu()
        {
          AppMethodBeat.i(217509);
          ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] onPcmReady");
          if (c.this.ayj() != d.c.wbz)
          {
            ae.w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(217509);
            return;
          }
          c.this.hxM.a(d.c.wbs);
          AppMethodBeat.o(217509);
        }
      });
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.hxX = false;
      if (paramInt1 != 0)
      {
        this.hxM.a(d.c.wby);
        AppMethodBeat.o(93372);
        return paramInt1;
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93376);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] cancel");
    release();
    AppMethodBeat.o(93376);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93378);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] clear");
    release();
    AppMethodBeat.o(93378);
  }
  
  public final void eu(boolean paramBoolean)
  {
    this.hyb = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.hxA;
  }
  
  public final g getFrameDataCallback()
  {
    return this.hyr;
  }
  
  public final boolean og(int paramInt)
  {
    AppMethodBeat.i(93371);
    if (!this.gHg)
    {
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preInit, cameraOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = of(paramInt);
      this.gHg = true;
      ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93371);
      return bool;
    }
    AppMethodBeat.o(93371);
    return true;
  }
  
  public final void oh(int paramInt)
  {
    AppMethodBeat.i(93387);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hxD = paramInt;
    AppMethodBeat.o(93387);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93384);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] pause");
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbs))
    {
      this.hxM.a(d.c.wbA);
      if (this.hxF != null) {
        this.hxF.pause();
      }
      this.hym = System.nanoTime();
    }
    AppMethodBeat.o(93384);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93377);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] reset");
    release();
    AppMethodBeat.o(93377);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93381);
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.KG(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.KG(paramInt4);
    }
    ae.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.hxK = paramInt1;
    this.hxL = paramInt2;
    if (com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null) {
      da(paramInt1, paramInt2);
    }
    AppMethodBeat.o(93381);
  }
  
  public final void setFilePath(String paramString)
  {
    this.hxA = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(93388);
    this.hyg.hnY.ei(paramBoolean);
    AppMethodBeat.o(93388);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.hyd = paramBoolean;
  }
  
  public final void yY(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void yZ(String paramString)
  {
    this.hxR = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void rR(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c
 * JD-Core Version:    0.7.0.1
 */