package com.tencent.mm.media.widget.b;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.g;
import com.tencent.mm.media.g.a.d;
import com.tencent.mm.media.g.a.i;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class c
  implements b
{
  private static final Object fcO;
  private SurfaceTexture bbI;
  protected String cqq;
  protected boolean eLc;
  protected int eRm;
  private EGLContext eZz;
  private final Object fbZ;
  protected Runnable fcA;
  protected boolean fcB;
  protected boolean fcC;
  protected boolean fcD;
  private long fcE;
  private c.a fcF;
  private com.tencent.mm.media.g.a fcG;
  private long fcH;
  private long fcI;
  public boolean fcJ;
  private double fcK;
  private long fcL;
  private long fcM;
  private long fcN;
  protected f fcP;
  protected String fca;
  protected int fcb;
  protected float fcc;
  private int fcd;
  private float fce;
  protected com.tencent.mm.plugin.mmsight.model.a.c fcf;
  protected com.tencent.mm.media.d.b fcg;
  protected int fch;
  protected int fci;
  protected int fcj;
  protected int fck;
  protected int fcl;
  protected s fcm;
  protected int fcn;
  protected String fco;
  protected boolean fcp;
  protected String fcq;
  protected boolean fcr;
  protected com.tencent.mm.plugin.mmsight.model.b fcs;
  protected com.tencent.mm.plugin.mmsight.model.b fct;
  protected VideoTransPara fcu;
  protected m fcv;
  protected boolean fcw;
  protected boolean fcx;
  protected int fcy;
  protected d.a fcz;
  private boolean isRecording;
  protected String mFileName;
  private int textureId;
  protected String thumbPath;
  
  static
  {
    AppMethodBeat.i(12776);
    fcO = new Object();
    AppMethodBeat.o(12776);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.h.a parama)
  {
    this(paramVideoTransPara, parama, null, -1, null);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.h.a parama, EGLContext paramEGLContext, int paramInt)
  {
    AppMethodBeat.i(12751);
    this.fbZ = new Object();
    this.fca = "";
    this.fcb = 0;
    this.fcc = 0.0F;
    this.fcd = -1;
    this.fce = -1.0F;
    this.fch = 480;
    this.fci = 640;
    this.fcj = 1600000;
    this.fck = 480;
    this.fcl = 640;
    this.eRm = -1;
    this.fco = null;
    this.fcp = false;
    this.thumbPath = null;
    this.fcq = null;
    this.fcr = false;
    this.fcs = new com.tencent.mm.plugin.mmsight.model.b("yuvRecorderWriteData");
    this.fct = new com.tencent.mm.plugin.mmsight.model.b("frameCountCallback");
    this.eLc = false;
    this.fcw = false;
    this.cqq = "";
    this.fcx = false;
    this.fcy = 0;
    this.fcA = null;
    this.fcB = false;
    this.fcC = true;
    this.fcD = false;
    this.isRecording = false;
    this.fcE = 0L;
    this.fcF = null;
    this.fcG = null;
    this.eZz = null;
    this.textureId = -1;
    this.fcH = 0L;
    this.fcI = 0L;
    this.fcJ = false;
    this.fcK = 0.0D;
    this.fcL = 0L;
    this.fcM = 0L;
    this.fcN = 0L;
    this.fcP = new c.1(this);
    a(paramVideoTransPara);
    this.eZz = paramEGLContext;
    this.fcG = new com.tencent.mm.media.g.a(parama);
    this.textureId = paramInt;
    ab.b("MicroMsg.Media.MediaCodecMP4MuxRecorder", "textureId : ".concat(String.valueOf(paramInt)), new Object[0]);
    AppMethodBeat.o(12751);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.h.a parama, EGLContext paramEGLContext, int paramInt, c.a parama1)
  {
    AppMethodBeat.i(152038);
    this.fbZ = new Object();
    this.fca = "";
    this.fcb = 0;
    this.fcc = 0.0F;
    this.fcd = -1;
    this.fce = -1.0F;
    this.fch = 480;
    this.fci = 640;
    this.fcj = 1600000;
    this.fck = 480;
    this.fcl = 640;
    this.eRm = -1;
    this.fco = null;
    this.fcp = false;
    this.thumbPath = null;
    this.fcq = null;
    this.fcr = false;
    this.fcs = new com.tencent.mm.plugin.mmsight.model.b("yuvRecorderWriteData");
    this.fct = new com.tencent.mm.plugin.mmsight.model.b("frameCountCallback");
    this.eLc = false;
    this.fcw = false;
    this.cqq = "";
    this.fcx = false;
    this.fcy = 0;
    this.fcA = null;
    this.fcB = false;
    this.fcC = true;
    this.fcD = false;
    this.isRecording = false;
    this.fcE = 0L;
    this.fcF = null;
    this.fcG = null;
    this.eZz = null;
    this.textureId = -1;
    this.fcH = 0L;
    this.fcI = 0L;
    this.fcJ = false;
    this.fcK = 0.0D;
    this.fcL = 0L;
    this.fcM = 0L;
    this.fcN = 0L;
    this.fcP = new c.1(this);
    a(paramVideoTransPara);
    this.fcF = parama1;
    this.eZz = paramEGLContext;
    this.fcG = new com.tencent.mm.media.g.a(parama);
    this.textureId = paramInt;
    ab.b("MicroMsg.Media.MediaCodecMP4MuxRecorder", "textureId : ".concat(String.valueOf(paramInt)), new Object[0]);
    AppMethodBeat.o(152038);
  }
  
  private boolean XD()
  {
    AppMethodBeat.i(12771);
    if ((this.fcm.oJP == d.c.oIG) || (this.fcm.oJP == d.c.oIH))
    {
      if (this.fcm.oJP == d.c.oIH)
      {
        this.fcm.oJP = d.c.oII;
        ab.b("MicroMsg.Media.MediaCodecMP4MuxRecorder", "forward one more frame", new Object[0]);
      }
      if (this.fcf != null) {
        this.fcf.bRk();
      }
      this.fct.kH(1L);
      this.fcs.kH(1L);
      AppMethodBeat.o(12771);
      return true;
    }
    AppMethodBeat.o(12771);
    return false;
  }
  
  private void Xr()
  {
    AppMethodBeat.i(12753);
    int i = this.fch;
    int j = this.fci;
    this.fcG.cl(i, j);
    this.fcG.jX(this.fcn);
    this.fcG.cm(this.fck, this.fcl);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.fck), Integer.valueOf(this.fcl), Integer.valueOf(this.fcn) });
    AppMethodBeat.o(12753);
  }
  
  private boolean Xs()
  {
    AppMethodBeat.i(152040);
    long l = bo.yB();
    if (this.fcg == null)
    {
      ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "muxTask, videoEncoder is null");
      AppMethodBeat.o(152040);
      return false;
    }
    int i = this.fcg.frameNum;
    if (this.fcb <= 0)
    {
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "muxTask, mDurationMS error %s", new Object[] { Integer.valueOf(this.fcb) });
      AppMethodBeat.o(152040);
      return false;
    }
    this.fcc = (i * 1000.0F / this.fcb);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.fcc), Integer.valueOf(this.fcb), this.fca, Long.valueOf(bo.av(l)), Integer.valueOf(this.fcd), Float.valueOf(this.fce) });
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[] { this.fct.getValue() });
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[] { this.fcs.getValue() });
    String str = null;
    if (CaptureMMProxy.getInstance() != null)
    {
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      if (bo.isNullOrNil(str)) {
        break label429;
      }
    }
    Object localObject;
    label429:
    for (str = com.tencent.mm.plugin.mmsight.d.TV(str);; str = this.fca)
    {
      i = this.fcb;
      if (this.fcd > 0) {
        i = this.fcd;
      }
      float f = this.fcc;
      if (this.fce > 0.0F) {
        f = this.fce;
      }
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "muxResultPath : ".concat(String.valueOf(str)));
      localObject = new m(this.eRm, str, f, this.fcj, i, this.fcu.audioSampleRate, this.fcD);
      l = bo.yB();
      boolean bool = ((m)localObject).bRm();
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bo.av(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label438;
      }
      ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mux failed!");
      k.bRa();
      AppMethodBeat.o(152040);
      return false;
      if (bo.isNullOrNil(this.fca)) {
        break;
      }
      str = new File(this.fca).getParentFile().getAbsolutePath();
      break;
    }
    label438:
    if (this.fcx)
    {
      l = bo.yB();
      if (this.fcy != 270) {
        break label677;
      }
    }
    for (i = 270;; i = 90)
    {
      SightVideoJNI.tagRotateVideo(str, this.fco, i);
      this.fcr = true;
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.fcn), Boolean.valueOf(this.fcx), Integer.valueOf(this.fcy), Integer.valueOf(i) });
      l = bo.yB();
      try
      {
        com.tencent.mm.vfs.e.deleteFile(str);
        com.tencent.mm.vfs.e.aT(this.fco, str);
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[] { Long.valueOf(bo.av(l)) });
        localObject = this.fco;
        com.tencent.mm.sdk.g.d.ysm.b(new c.8(this, (String)localObject), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.eRm);
        this.fcm.a(d.c.oIJ);
        this.cqq = g.getMD5(str);
        if ((!bo.isNullOrNil(str)) && (!str.equals(this.fca)))
        {
          com.tencent.mm.vfs.e.aT(str, this.fca);
          com.tencent.mm.vfs.e.deleteFile(str);
        }
        AppMethodBeat.o(152040);
        return true;
      }
      catch (Exception localException)
      {
        label677:
        ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stop, copy file error");
        AppMethodBeat.o(152040);
      }
    }
    return false;
  }
  
  private void Xt()
  {
    this.fcH = 0L;
    this.fcI = 0L;
    this.fcK = 0.0D;
    this.fcL = 0L;
    this.fcM = 0L;
    this.fcN = 0L;
  }
  
  private void a(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(152039);
    this.fcE = 0L;
    this.fcu = paramVideoTransPara;
    this.fch = paramVideoTransPara.width;
    this.fci = paramVideoTransPara.height;
    this.fcm = new s();
    paramVideoTransPara = com.tencent.mm.media.i.c.eZC;
    com.tencent.mm.media.i.c.VF();
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.fch), Integer.valueOf(this.fci) });
    AppMethodBeat.o(152039);
  }
  
  private boolean kl(int paramInt)
  {
    AppMethodBeat.i(12752);
    long l = bo.yB();
    this.fcj = this.fcu.videoBitrate;
    this.eRm = SightVideoJNI.initDataBufferForMMSightLock(this.fck, this.fcl, paramInt, this.fch, this.fci, this.fcu.fps, this.fcj, this.fcu.fzW, 8, this.fcu.fzV, 23.0F, false, false, this.fcu.duration, false);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.eRm) });
    if (this.eRm < 0)
    {
      ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "init failed!");
      ??? = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VG();
      AppMethodBeat.o(12752);
      return false;
    }
    this.fcn = paramInt;
    ??? = new com.tencent.mm.media.b.c();
    if (((com.tencent.mm.media.b.c)???).eRz)
    {
      ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "encodeConfig  InitError");
      ??? = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VN();
      AppMethodBeat.o(12752);
      return false;
    }
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mTargetRate " + this.fcj + "  videoParams.fps: " + this.fcu.fps + " mTargetHeight:" + this.fci + " mTargetWidth:" + this.fch);
    ((com.tencent.mm.media.b.c)???).bitrate = this.fcj;
    ((com.tencent.mm.media.b.c)???).eRw = this.fcu.fps;
    ((com.tencent.mm.media.b.c)???).eRv = this.fci;
    ((com.tencent.mm.media.b.c)???).eRu = this.fch;
    try
    {
      this.fcg = new com.tencent.mm.media.d.e((com.tencent.mm.media.b.c)???, true, new c.3(this, 1000 / this.fcu.fps));
      ??? = this.fcG;
      Surface localSurface = this.fcg.getInputSurface();
      EGLContext localEGLContext = this.eZz;
      c.4 local4 = new c.4(this);
      a.f.b.j.q(localSurface, "surface");
      ((com.tencent.mm.media.g.a)???).axw = localSurface;
      ab.i(((com.tencent.mm.media.g.a)???).TAG, ((com.tencent.mm.media.g.a)???).hashCode() + " initWithSurface, eglContext:" + localEGLContext + ", surface:" + localSurface + ", waitNewFrame:false, callback:false");
      ((com.tencent.mm.media.g.a)???).d((a.f.a.a)new a.d((com.tencent.mm.media.g.a)???, localEGLContext, localSurface, local4));
      synchronized (fcO)
      {
        try
        {
          fcO.wait(500L);
          this.fcG.eVT = new c.5(this);
          Xr();
          this.fcf = new a(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
          this.fcf.jn(this.fcB);
          paramInt = this.fcf.t(this.eRm, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
          ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "initImpl used %sms, ret:%s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(paramInt) });
          if (paramInt != 0)
          {
            ??? = com.tencent.mm.media.i.c.eZC;
            com.tencent.mm.media.i.c.VI();
            AppMethodBeat.o(12752);
            return false;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException2, "initSurfaceLock wait error", new Object[0]);
          }
        }
      }
      com.tencent.mm.media.i.c localc;
      AppMethodBeat.o(12752);
    }
    catch (Exception localException1)
    {
      ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException1, "init encoder error", new Object[0]);
      localc = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VG();
      AppMethodBeat.o(12752);
      return false;
    }
    return true;
  }
  
  public final String Al()
  {
    AppMethodBeat.i(12757);
    String str = bo.bf(this.cqq, "");
    AppMethodBeat.o(12757);
    return str;
  }
  
  public final void G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12766);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.fcn = paramInt1;
    this.fck = paramInt2;
    this.fcl = paramInt3;
    this.fcG.jX(paramInt1);
    Xr();
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIO)) {
      this.fcm.a(d.c.oIG);
    }
    AppMethodBeat.o(12766);
  }
  
  public final boolean XA()
  {
    return this.fcw;
  }
  
  public final com.tencent.mm.audio.b.c.a XB()
  {
    AppMethodBeat.i(12767);
    if (this.fcf != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.fcf.bRl();
      AppMethodBeat.o(12767);
      return locala;
    }
    AppMethodBeat.o(12767);
    return null;
  }
  
  public final void XC()
  {
    this.fcC = false;
  }
  
  public final long Xf()
  {
    AppMethodBeat.i(12761);
    if (this.fcg != null)
    {
      long l = this.fcg.UQ();
      AppMethodBeat.o(12761);
      return l;
    }
    AppMethodBeat.o(12761);
    return 0L;
  }
  
  public final String Xi()
  {
    return this.thumbPath;
  }
  
  public final void Xq()
  {
    AppMethodBeat.i(12770);
    long l;
    if ((this.textureId < 0) || (!XD()))
    {
      if ((this.bbI == null) || (!XD())) {
        AppMethodBeat.o(12770);
      }
    }
    else
    {
      if (this.fcM > 0L)
      {
        l = System.nanoTime() - this.fcM;
        this.fcL += l;
        float f = (float)this.fcN;
        this.fcN = (((float)l / 1000000.0F + f));
        this.fcM = 0L;
      }
      ab.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "textureDataUpdate, lastPausePtsDiff:%s", new Object[] { Long.valueOf(this.fcL) });
      if (this.fcI <= 0L) {
        break label345;
      }
      l = System.nanoTime() - this.fcI + this.fcH - this.fcL;
      this.fcL = 0L;
    }
    for (;;)
    {
      if (this.fcJ) {
        if ((this.fcm.oJP == d.c.oII) || (this.fcH == 0L) || (l - this.fcH >= this.fcK * 1000000.0D))
        {
          this.fcG.u(this.textureId, l);
          this.fcH = l;
        }
      }
      for (this.fcI = System.nanoTime();; this.fcI = System.nanoTime())
      {
        ab.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "textureDataUpdate pts:%s, lastTexturePts:%s, lastTextureNanoTime:%s, accumulatePauseTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.fcH), Long.valueOf(this.fcI), Long.valueOf(this.fcN) });
        break;
        this.fcG.u(this.textureId, l);
        this.fcH = l;
      }
      com.tencent.mm.media.g.a locala = this.fcG;
      SurfaceTexture localSurfaceTexture = this.bbI;
      a.f.b.j.q(localSurfaceTexture, "surfaceTexture");
      locala.d((a.f.a.a)new a.i(locala, localSurfaceTexture));
      AppMethodBeat.o(12770);
      return;
      label345:
      l = 0L;
    }
  }
  
  public final String Xu()
  {
    return this.fcq;
  }
  
  public final float Xv()
  {
    return this.fcc;
  }
  
  public final d.c Xw()
  {
    return this.fcm.oJP;
  }
  
  public final int Xx()
  {
    AppMethodBeat.i(12763);
    int i = Math.round(this.fcb / 1000.0F);
    AppMethodBeat.o(12763);
    return i;
  }
  
  public final Point Xy()
  {
    AppMethodBeat.i(12764);
    Point localPoint = new Point(this.fck, this.fcl);
    AppMethodBeat.o(12764);
    return localPoint;
  }
  
  public final int Xz()
  {
    return this.fcn;
  }
  
  public final void a(d.a parama)
  {
    this.fcz = parama;
  }
  
  public final void ag(float paramFloat)
  {
    AppMethodBeat.i(12769);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.fce = paramFloat;
    AppMethodBeat.o(12769);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(12755);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.fcs.reset();
    this.fcb = 0;
    this.fcH = 0L;
    this.fct.reset();
    this.fcp = false;
    this.fcx = paramBoolean;
    this.fcy = paramInt2;
    Xt();
    this.fcK = (1000.0F / this.fcu.fps);
    this.fcm.a(d.c.oIF);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start, checkDropFrameByPts: %s, perFrmaeDuration:%s", new Object[] { Boolean.valueOf(this.fcJ), Double.valueOf(this.fcK) });
    if (bo.isNullOrNil(this.fca))
    {
      ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(12755);
      return -1;
    }
    try
    {
      this.mFileName = com.tencent.mm.vfs.e.avM(this.fca);
      String str2 = com.tencent.mm.vfs.e.avK(this.fca);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.fco = (str1 + "tempRotate.mp4");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.fcm.a(d.c.oIN);
        continue;
        ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
        this.fcm.a(d.c.oIG);
        this.fcw = false;
        paramInt1 = 0;
      }
    }
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.fca, this.fco });
    this.fcn = paramInt1;
    if (!this.eLc)
    {
      kl(paramInt1);
      this.eLc = true;
    }
    if ((!this.fcD) && (!this.fcB) && (this.fcf != null))
    {
      paramInt1 = this.fcf.a(new c.6(this));
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.fcw = false;
      if (paramInt1 != 0)
      {
        this.fcm.a(d.c.oIM);
        AppMethodBeat.o(12755);
        return paramInt1;
      }
    }
  }
  
  public final void cG(boolean paramBoolean)
  {
    this.fcB = paramBoolean;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(12758);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "cancel record");
    if ((this.fcg == null) || ((this.fcf == null) && (!this.fcD)))
    {
      ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      AppMethodBeat.o(12758);
      return;
    }
    this.fcm.a(d.c.oII);
    this.fcg.UN();
    if (this.fcf != null) {
      this.fcf.a(new c.9(this));
    }
    if (this.eRm >= 0) {
      SightVideoJNI.releaseBigSightDataBufferLock(this.eRm);
    }
    for (;;)
    {
      this.fcm.a(d.c.oIJ);
      reset();
      AppMethodBeat.o(12758);
      return;
      ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "why buf id < 0 ? %d", new Object[] { Integer.valueOf(this.eRm) });
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(12759);
    try
    {
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "clear");
      if (this.fcf != null) {
        this.fcf.clear();
      }
      if (this.fcG != null) {
        this.fcG.release();
      }
      if (this.fcg != null) {
        this.fcg.release();
      }
      Xt();
      this.fcJ = false;
      AppMethodBeat.o(12759);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(12759);
    }
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.fca;
  }
  
  public final f getFrameDataCallback()
  {
    return this.fcP;
  }
  
  public final boolean isLandscape()
  {
    return this.fcx;
  }
  
  public final boolean km(int paramInt)
  {
    AppMethodBeat.i(12754);
    if (!this.eLc)
    {
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "preInit, cameraOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = kl(paramInt);
      this.eLc = true;
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(12754);
      return bool;
    }
    AppMethodBeat.o(12754);
    return true;
  }
  
  public final void kn(int paramInt)
  {
    AppMethodBeat.i(12768);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.fcd = paramInt;
    AppMethodBeat.o(12768);
  }
  
  public final void mV(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void mW(String paramString)
  {
    this.fcq = paramString;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(12765);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "pause");
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIG))
    {
      this.fcm.a(d.c.oIO);
      this.fcM = System.nanoTime();
    }
    AppMethodBeat.o(12765);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(12760);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.fcg, this.fcf, this.fcv });
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", new Object[] { this.fcg, this.fcf });
    synchronized (this.fbZ)
    {
      if (this.fcg != null) {
        this.fcg.release();
      }
      this.fcg = null;
      if (this.fcf != null) {
        this.fcf.clear();
      }
      this.fcf = null;
      this.fcv = null;
      this.eLc = false;
      this.fcw = false;
      AppMethodBeat.o(12760);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(12762);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.zn(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.zn(paramInt4);
    }
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.fck = paramInt1;
    this.fcl = paramInt2;
    if (com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bo.yB();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        com.tencent.mm.plugin.mmsight.model.a.j.oJp.O(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    }
    AppMethodBeat.o(12762);
  }
  
  public final void setFilePath(String paramString)
  {
    this.fca = paramString;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fcD = paramBoolean;
  }
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(12756);
    this.fcA = paramRunnable;
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s !!!", new Object[] { paramRunnable });
    if ((this.fcg == null) || ((this.fcf == null) && (!this.fcD)))
    {
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        al.d(paramRunnable);
      }
      AppMethodBeat.o(12756);
      return;
    }
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIJ))
    {
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stop, already in stop videoRecordStatus");
      if (this.fcf != null) {
        this.fcf.clear();
      }
      if (paramRunnable != null) {
        al.d(paramRunnable);
      }
      AppMethodBeat.o(12756);
      return;
    }
    paramRunnable = com.tencent.mm.media.i.c.eZC;
    com.tencent.mm.media.i.c.VJ();
    if (this.fcm != null) {
      this.fcm.a(d.c.oIH);
    }
    if (this.fcM > 0L)
    {
      long l1 = System.nanoTime();
      long l2 = this.fcM;
      float f = (float)this.fcN;
      this.fcN = (((float)(l1 - l2) / 1000000.0F + f));
    }
    this.fcb = ((int)this.fcg.UQ());
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stop, mDurationMS:%s, accumulatePauseTime:%s", new Object[] { Integer.valueOf(this.fcb), Long.valueOf(this.fcN) });
    if (this.fcN > 0L) {
      this.fcb = ((int)(this.fcb - this.fcN));
    }
    AppMethodBeat.o(12756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.c
 * JD-Core Version:    0.7.0.1
 */