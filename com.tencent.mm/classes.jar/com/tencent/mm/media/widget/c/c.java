package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.a.d;
import com.tencent.mm.media.h.a.i;
import com.tencent.mm.media.h.a.j;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import d.g.b.k;
import d.y;
import java.nio.ByteBuffer;

public final class c
  implements b
{
  private static final Object hdt;
  protected int gNJ;
  private EGLContext gWL;
  protected boolean gkP;
  protected boolean hbQ;
  private boolean hba;
  private final Object hcD;
  protected String hcE;
  protected int hcF;
  protected float hcG;
  private int hcH;
  private float hcI;
  protected com.tencent.mm.plugin.mmsight.model.a.c hcJ;
  protected com.tencent.mm.media.d.b hcK;
  protected int hcL;
  protected int hcM;
  protected int hcN;
  protected int hcO;
  protected int hcP;
  protected s hcQ;
  protected int hcR;
  protected boolean hcS;
  protected String hcT;
  protected boolean hcU;
  protected String hcV;
  protected boolean hcW;
  protected com.tencent.mm.plugin.mmsight.model.c hcX;
  protected com.tencent.mm.plugin.mmsight.model.c hcY;
  protected VideoTransPara hcZ;
  protected com.tencent.mm.plugin.mmsight.model.a.m hda;
  protected boolean hdb;
  protected int hdc;
  protected d.a hdd;
  protected Runnable hde;
  protected boolean hdf;
  protected boolean hdg;
  protected boolean hdh;
  private long hdi;
  private c.a hdj;
  private com.tencent.mm.media.h.a hdk;
  private long hdl;
  private long hdm;
  public boolean hdn;
  private double hdo;
  private long hdp;
  private long hdq;
  private long hdr;
  private boolean hds;
  private Runnable hdu;
  protected g hdv;
  protected String mFileName;
  protected String md5;
  private boolean released;
  private SurfaceTexture surfaceTexture;
  private int textureId;
  protected String thumbPath;
  
  static
  {
    AppMethodBeat.i(93397);
    hdt = new Object();
    AppMethodBeat.o(93397);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.i.a parama)
  {
    this(paramVideoTransPara, parama, null, -1, null);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.i.a parama, EGLContext paramEGLContext, int paramInt)
  {
    AppMethodBeat.i(93367);
    this.hcD = new Object();
    this.hcE = "";
    this.hcF = 0;
    this.hcG = 0.0F;
    this.hcH = -1;
    this.hcI = -1.0F;
    this.hcL = 480;
    this.hcM = 640;
    this.hcN = 1600000;
    this.hcO = 480;
    this.hcP = 640;
    this.gNJ = -1;
    this.hcS = false;
    this.hcT = null;
    this.hcU = false;
    this.thumbPath = null;
    this.hcV = null;
    this.hcW = false;
    this.hcX = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hcY = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gkP = false;
    this.hdb = false;
    this.md5 = "";
    this.hbQ = false;
    this.hdc = 0;
    this.hde = null;
    this.hdf = false;
    this.hdg = true;
    this.hdh = false;
    this.hba = false;
    this.hdi = 0L;
    this.hdj = null;
    this.hdk = null;
    this.gWL = null;
    this.textureId = -1;
    this.hdl = 0L;
    this.hdm = 0L;
    this.hdn = false;
    this.hdo = 0.0D;
    this.hdp = 0L;
    this.hdq = 0L;
    this.hdr = 0L;
    this.hds = false;
    this.released = false;
    this.hdu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209890);
        ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.hcQ.uNv = d.c.uMl;
        com.tencent.mm.media.h.a locala = c.a(c.this);
        d.g.a.a local1 = new d.g.a.a() {};
        k.h(local1, "callback");
        locala.i((d.g.a.a)new a.j(local1));
        AppMethodBeat.o(209890);
      }
    };
    this.hdv = new g()
    {
      public final boolean V(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(209892);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(209892);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.gWL = paramEGLContext;
    this.hdk = new com.tencent.mm.media.h.a(parama);
    this.textureId = paramInt;
    ac.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93367);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.i.a parama, EGLContext paramEGLContext, int paramInt, c.a parama1)
  {
    AppMethodBeat.i(93366);
    this.hcD = new Object();
    this.hcE = "";
    this.hcF = 0;
    this.hcG = 0.0F;
    this.hcH = -1;
    this.hcI = -1.0F;
    this.hcL = 480;
    this.hcM = 640;
    this.hcN = 1600000;
    this.hcO = 480;
    this.hcP = 640;
    this.gNJ = -1;
    this.hcS = false;
    this.hcT = null;
    this.hcU = false;
    this.thumbPath = null;
    this.hcV = null;
    this.hcW = false;
    this.hcX = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hcY = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gkP = false;
    this.hdb = false;
    this.md5 = "";
    this.hbQ = false;
    this.hdc = 0;
    this.hde = null;
    this.hdf = false;
    this.hdg = true;
    this.hdh = false;
    this.hba = false;
    this.hdi = 0L;
    this.hdj = null;
    this.hdk = null;
    this.gWL = null;
    this.textureId = -1;
    this.hdl = 0L;
    this.hdm = 0L;
    this.hdn = false;
    this.hdo = 0.0D;
    this.hdp = 0L;
    this.hdq = 0L;
    this.hdr = 0L;
    this.hds = false;
    this.released = false;
    this.hdu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209890);
        ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.hcQ.uNv = d.c.uMl;
        com.tencent.mm.media.h.a locala = c.a(c.this);
        d.g.a.a local1 = new d.g.a.a() {};
        k.h(local1, "callback");
        locala.i((d.g.a.a)new a.j(local1));
        AppMethodBeat.o(209890);
      }
    };
    this.hdv = new g()
    {
      public final boolean V(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(209892);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(209892);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.hdj = parama1;
    this.gWL = paramEGLContext;
    this.hdk = new com.tencent.mm.media.h.a(parama);
    this.textureId = paramInt;
    ac.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93366);
  }
  
  private void a(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93368);
    this.hdi = 0L;
    this.hcZ = paramVideoTransPara;
    this.hcL = paramVideoTransPara.width;
    this.hcM = paramVideoTransPara.height;
    this.hcQ = new s();
    paramVideoTransPara = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.arM();
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.hcL), Integer.valueOf(this.hcM) });
    AppMethodBeat.o(93368);
  }
  
  private void avb()
  {
    AppMethodBeat.i(93370);
    int i = this.hcL;
    int j = this.hcM;
    this.hdk.cQ(i, j);
    this.hdk.mE(this.hcR);
    this.hdk.cS(this.hcO, this.hcP);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.hcO), Integer.valueOf(this.hcP), Integer.valueOf(this.hcR) });
    AppMethodBeat.o(93370);
  }
  
  private boolean avc()
  {
    AppMethodBeat.i(93374);
    long l = bs.Gn();
    if (this.hcK == null)
    {
      ac.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, videoEncoder is null");
      AppMethodBeat.o(93374);
      return false;
    }
    int i = this.hcK.frameNum;
    if (this.hcF <= 0)
    {
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, mDurationMS error %s", new Object[] { Integer.valueOf(this.hcF) });
      AppMethodBeat.o(93374);
      return false;
    }
    this.hcG = (i * 1000.0F / this.hcF);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.hcG), Integer.valueOf(this.hcF), this.hcE, Long.valueOf(bs.aO(l)), Integer.valueOf(this.hcH), Float.valueOf(this.hcI) });
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] frameCountCallback %s", new Object[] { this.hcY.getValue() });
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] yuvRecorderWriteDataCallback %s", new Object[] { this.hcX.getValue() });
    String str = null;
    label364:
    float f;
    int j;
    int k;
    int m;
    if (CaptureMMProxy.getInstance() != null)
    {
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      if (bs.isNullOrNil(str)) {
        break label643;
      }
      str = com.tencent.mm.plugin.mmsight.d.dY(str, hashCode());
      i = this.hcF;
      if (this.hcH > 0) {
        i = this.hcH;
      }
      f = this.hcG;
      if (this.hcI > 0.0F) {
        f = this.hcI;
      }
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxResultPath : " + str);
      j = this.gNJ;
      k = this.hcN;
      m = this.hcZ.audioSampleRate;
      if ((!this.hdh) || (this.hds)) {
        break label652;
      }
    }
    Object localObject;
    label643:
    label652:
    for (boolean bool = true;; bool = false)
    {
      localObject = new com.tencent.mm.plugin.mmsight.model.a.m(j, str, f, k, i, m, bool, false, this.hcS);
      l = bs.Gn();
      bool = ((com.tencent.mm.plugin.mmsight.model.a.m)localObject).ddO();
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux used %sms, success: %s", new Object[] { Long.valueOf(bs.aO(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label658;
      }
      ac.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux failed!");
      l.ddD();
      AppMethodBeat.o(93374);
      return false;
      if (bs.isNullOrNil(this.hcE)) {
        break;
      }
      str = q.B(new com.tencent.mm.vfs.e(this.hcE).fxU().fxV());
      break;
      str = this.hcE;
      break label364;
    }
    label658:
    if (this.hbQ)
    {
      l = bs.Gn();
      if (this.hdc != 270) {
        break label946;
      }
    }
    for (i = 270;; i = 90)
    {
      SightVideoJNI.tagRotateVideoVFS(str, this.hcT, i);
      this.hcW = true;
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.hcR), Boolean.valueOf(this.hbQ), Integer.valueOf(this.hdc), Integer.valueOf(i) });
      l = bs.Gn();
      try
      {
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.vfs.i.ma(this.hcT, str);
        ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] copyFile cost %s", new Object[] { Long.valueOf(bs.aO(l)) });
        localObject = this.hcT;
        com.tencent.e.h.JZN.f(new c.9(this, (String)localObject), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.gNJ);
        this.hcQ.a(d.c.uMm);
        this.md5 = com.tencent.mm.vfs.i.aKe(str);
        if ((!bs.isNullOrNil(str)) && (!str.equals(this.hcE)))
        {
          com.tencent.mm.vfs.i.ma(str, this.hcE);
          com.tencent.mm.vfs.i.deleteFile(str);
        }
        AppMethodBeat.o(93374);
        return true;
      }
      catch (Exception localException)
      {
        label946:
        ac.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, copy file error");
        AppMethodBeat.o(93374);
      }
    }
    return false;
  }
  
  private void avd()
  {
    this.hdl = 0L;
    this.hdm = 0L;
    this.hdo = 0.0D;
    this.hdp = 0L;
    this.hdq = 0L;
    this.hdr = 0L;
  }
  
  private boolean avo()
  {
    AppMethodBeat.i(93391);
    if ((this.hcQ.uNv == d.c.uMj) || (this.hcQ.uNv == d.c.uMk))
    {
      if (this.hcQ.uNv == d.c.uMk)
      {
        this.hcQ.uNv = d.c.uMl;
        ac.m("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] forward one more frame", new Object[0]);
      }
      if (this.hcJ != null) {
        this.hcJ.ddM();
      }
      this.hcY.vW(1L);
      this.hcX.vW(1L);
      AppMethodBeat.o(93391);
      return true;
    }
    AppMethodBeat.o(93391);
    return false;
  }
  
  private void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(177314);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
    long l = bs.Gn();
    int i = 0;
    while (i < 3)
    {
      j.uMV.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
      i += 1;
    }
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(177314);
  }
  
  private boolean nD(int paramInt)
  {
    AppMethodBeat.i(93369);
    this.released = false;
    long l = bs.Gn();
    this.hcN = this.hcZ.videoBitrate;
    if (this.hcZ.hCW == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = new com.tencent.mm.media.b.d(bool);
      if (!((com.tencent.mm.media.b.d)???).gNY) {
        break;
      }
      ac.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] encodeConfig  InitError");
      ??? = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.arU();
      AppMethodBeat.o(93369);
      return false;
    }
    this.hcS = k.g(((com.tencent.mm.media.b.d)???).mimeType, "video/hevc");
    this.gNJ = SightVideoJNI.initDataBufferForMMSightLock(this.hcO, this.hcP, paramInt, this.hcL, this.hcM, this.hcZ.fps, this.hcN, this.hcZ.hCA, 8, this.hcZ.hCz, 23.0F, false, false, this.hcZ.duration, false, this.hcS, com.tencent.mm.plugin.sight.base.b.ac(false, this.hcS));
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init, bufId: %s", new Object[] { Integer.valueOf(this.gNJ) });
    if (this.gNJ < 0)
    {
      ac.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init failed!");
      ??? = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.arN();
      AppMethodBeat.o(93369);
      return false;
    }
    this.hcR = paramInt;
    this.hcM = com.tencent.mm.plugin.mmsight.d.IJ(this.hcM);
    this.hcL = com.tencent.mm.plugin.mmsight.d.IJ(this.hcL);
    Object localObject2;
    if ((this.hcS) && (((com.tencent.mm.media.b.d)???).mimeType.equals("video/hevc")))
    {
      localObject2 = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asD();
    }
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mTargetRate " + this.hcN + "  videoParams.fps: " + this.hcZ.fps + " mTargetHeight:" + this.hcM + " mTargetWidth:" + this.hcL + ", minQP:" + this.hcZ.gOb + ", maxQP:" + this.hcZ.gOc);
    ((com.tencent.mm.media.b.d)???).bitrate = this.hcN;
    ((com.tencent.mm.media.b.d)???).frameRate = this.hcZ.fps;
    ((com.tencent.mm.media.b.d)???).gNV = this.hcM;
    ((com.tencent.mm.media.b.d)???).gNU = this.hcL;
    ((com.tencent.mm.media.b.d)???).gOc = this.hcZ.gOc;
    ((com.tencent.mm.media.b.d)???).gOb = this.hcZ.gOb;
    try
    {
      this.hcK = new com.tencent.mm.media.d.e((com.tencent.mm.media.b.d)???, true, new d.g.a.b() {});
      ??? = this.hdk;
      localObject2 = this.hcK.getInputSurface();
      EGLContext localEGLContext = this.gWL;
      c.5 local5 = new c.5(this);
      k.h(localObject2, "surface");
      ((com.tencent.mm.media.h.a)???).surface = ((Surface)localObject2);
      ac.i(((com.tencent.mm.media.h.a)???).TAG, ((com.tencent.mm.media.h.a)???).hashCode() + " initWithSurface, eglContext:" + localEGLContext + ", surface:" + localObject2 + ", waitNewFrame:false, callback:false");
      ((com.tencent.mm.media.h.a)???).i((d.g.a.a)new a.d((com.tencent.mm.media.h.a)???, localEGLContext, (Surface)localObject2, local5));
      synchronized (hdt)
      {
        try
        {
          hdt.wait(500L);
          this.hdk.gST = new d.g.a.b() {};
          avb();
          this.hcJ = new a(this.hcZ.audioSampleRate, this.hcZ.audioBitrate, this.hcZ.gOt, com.tencent.mm.plugin.sight.base.b.ac(false, this.hcS));
          this.hcJ.nY(this.hdf);
          paramInt = this.hcJ.E(this.gNJ, com.tencent.mm.plugin.sight.base.e.asv(this.hcE));
          ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl used %sms, ret:%s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(paramInt) });
          if (paramInt != 0)
          {
            ??? = com.tencent.mm.media.j.d.gWO;
            com.tencent.mm.media.j.d.arP();
            AppMethodBeat.o(93369);
            return false;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException2, "[" + hashCode() + "] initSurfaceLock wait error", new Object[0]);
          }
        }
      }
      com.tencent.mm.media.j.d locald;
      AppMethodBeat.o(93369);
    }
    catch (Exception localException1)
    {
      release();
      ac.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException1, "[" + hashCode() + "] init encoder error", new Object[0]);
      aw.eVz().putBoolean("mediacodec_create_error", true);
      locald = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.arN();
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
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release recorder");
      this.hcQ.a(d.c.uMl);
      synchronized (this.hcD)
      {
        ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release videoEncoder");
        if (this.hcK != null)
        {
          this.hcK.aqE();
          this.hcK.aqF();
          this.hcK = null;
          com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.asu();
        }
        ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] end release videoEncoder");
        if (this.hcJ != null)
        {
          this.hcJ.a(new c.10(this));
          this.hcJ.clear();
          this.hcJ = null;
        }
        ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] release buf-id ? %d", new Object[] { Integer.valueOf(this.gNJ) });
        if (this.gNJ >= 0) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.gNJ);
        }
        this.hcQ.a(d.c.uMm);
        if (this.hdk != null) {
          this.hdk.release();
        }
        avd();
        this.hdn = false;
        this.hdb = false;
        this.hda = null;
        this.gkP = false;
        AppMethodBeat.o(93379);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "[" + hashCode() + "] clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93379);
    }
  }
  
  public final void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(93373);
    this.hde = paramRunnable;
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] !!!!!stop, stopCallback: %s !!!", new Object[] { paramRunnable });
    if ((this.hcK == null) || ((this.hcJ == null) && (!this.hdh)))
    {
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        ap.f(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMm))
    {
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, already in stop videoRecordStatus");
      if (this.hcJ != null) {
        this.hcJ.clear();
      }
      if (paramRunnable != null) {
        ap.f(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    paramRunnable = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.arQ();
    if (this.hcQ != null)
    {
      com.tencent.e.h.JZN.b(this.hdu, 1500L, "record_stop_timeout");
      this.hcQ.a(d.c.uMk);
    }
    if (this.hdq > 0L)
    {
      long l1 = System.nanoTime();
      long l2 = this.hdq;
      float f = (float)this.hdr;
      this.hdr = (((float)(l1 - l2) / 1000000.0F + f));
    }
    this.hcF = ((int)this.hcK.aqI());
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, mDurationMS:%s, accumulatePauseTime:%s", new Object[] { Integer.valueOf(this.hcF), Long.valueOf(this.hdr) });
    if (this.hdr > 0L) {
      this.hcF = ((int)(this.hcF - this.hdr));
    }
    AppMethodBeat.o(93373);
  }
  
  public final String JC()
  {
    AppMethodBeat.i(93375);
    String str = bs.bG(this.md5, "");
    AppMethodBeat.o(93375);
    return str;
  }
  
  public final void K(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93385);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.hcR = paramInt1;
    this.hcO = paramInt2;
    this.hcP = paramInt3;
    this.hdk.mE(paramInt1);
    avb();
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMr))
    {
      this.hcQ.a(d.c.uMj);
      if (this.hcJ != null) {
        this.hcJ.resume();
      }
    }
    AppMethodBeat.o(93385);
  }
  
  public final void a(com.tencent.mm.plugin.mmsight.model.a.c paramc)
  {
    AppMethodBeat.i(93392);
    if (paramc != null)
    {
      this.hds = true;
      paramc.nC(this.gNJ);
    }
    AppMethodBeat.o(93392);
  }
  
  public final void a(d.a parama)
  {
    this.hdd = parama;
  }
  
  public final void aj(float paramFloat)
  {
    AppMethodBeat.i(93389);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.hcI = paramFloat;
    AppMethodBeat.o(93389);
  }
  
  public final boolean aly()
  {
    return this.hbQ;
  }
  
  public final String auN()
  {
    return this.thumbPath;
  }
  
  public final void ava()
  {
    AppMethodBeat.i(93390);
    long l;
    if ((this.textureId < 0) || (!avo()))
    {
      if ((this.surfaceTexture == null) || (!avo())) {
        AppMethodBeat.o(93390);
      }
    }
    else
    {
      if (this.hdq > 0L)
      {
        l = System.nanoTime() - this.hdq;
        this.hdp += l;
        float f = (float)this.hdr;
        this.hdr = (((float)l / 1000000.0F + f));
        this.hdq = 0L;
      }
      ac.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureDataUpdate, lastPausePtsDiff:%s", new Object[] { Long.valueOf(this.hdp) });
      if (this.hdm <= 0L) {
        break label389;
      }
      l = System.nanoTime() - this.hdm + this.hdl - this.hdp;
      this.hdp = 0L;
    }
    for (;;)
    {
      if (this.hdn) {
        if ((this.hcQ.uNv == d.c.uMl) || (this.hdl == 0L) || (l - this.hdl >= this.hdo * 1000000.0D))
        {
          this.hdk.v(this.textureId, l);
          this.hdl = l;
        }
      }
      for (this.hdm = System.nanoTime();; this.hdm = System.nanoTime())
      {
        ac.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureDataUpdate pts:%s, lastTexturePts:%s, lastTextureNanoTime:%s, accumulatePauseTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(this.hdl), Long.valueOf(this.hdm), Long.valueOf(this.hdr) });
        break;
        this.hdk.v(this.textureId, l);
        this.hdl = l;
      }
      com.tencent.mm.media.h.a locala = this.hdk;
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      k.h(localSurfaceTexture, "surfaceTexture");
      locala.i((d.g.a.a)new a.i(locala, localSurfaceTexture));
      AppMethodBeat.o(93390);
      return;
      label389:
      l = 0L;
    }
  }
  
  public final String ave()
  {
    return this.hcV;
  }
  
  public final float avf()
  {
    return this.hcG;
  }
  
  public final long avg()
  {
    AppMethodBeat.i(93380);
    if (this.hcK != null)
    {
      long l = this.hcK.aqI();
      AppMethodBeat.o(93380);
      return l;
    }
    AppMethodBeat.o(93380);
    return 0L;
  }
  
  public final d.c avh()
  {
    return this.hcQ.uNv;
  }
  
  public final int avi()
  {
    AppMethodBeat.i(93382);
    int i = Math.round(this.hcF / 1000.0F);
    AppMethodBeat.o(93382);
    return i;
  }
  
  public final Point avj()
  {
    AppMethodBeat.i(93383);
    Point localPoint = new Point(this.hcO, this.hcP);
    AppMethodBeat.o(93383);
    return localPoint;
  }
  
  public final int avk()
  {
    return this.hcR;
  }
  
  public final boolean avl()
  {
    return this.hdb;
  }
  
  public final com.tencent.mm.audio.b.c.a avm()
  {
    AppMethodBeat.i(93386);
    if (this.hcJ != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hcJ.ddN();
      AppMethodBeat.o(93386);
      return locala;
    }
    AppMethodBeat.o(93386);
    return null;
  }
  
  public final void avn()
  {
    this.hdg = false;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.c avp()
  {
    return this.hcJ;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93372);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hcX.reset();
    this.hcF = 0;
    this.hdl = 0L;
    this.hcY.reset();
    this.hcU = false;
    this.hbQ = paramBoolean;
    this.hdc = paramInt2;
    avd();
    this.hdo = (1000.0F / this.hcZ.fps);
    this.hcQ.a(d.c.uMi);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, checkDropFrameByPts: %s, perFrmaeDuration:%s", new Object[] { Boolean.valueOf(this.hdn), Double.valueOf(this.hdo) });
    if (bs.isNullOrNil(this.hcE))
    {
      ac.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93372);
      return -1;
    }
    try
    {
      this.mFileName = com.tencent.mm.vfs.i.aSu(this.hcE);
      String str2 = com.tencent.mm.vfs.i.aSs(this.hcE);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.hcT = (str1 + hashCode() + "tempRotate.mp4");
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tempRotateFilePath:" + this.hcT);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.hcQ.a(d.c.uMq);
        continue;
        ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start yuvRecorder with mute");
        this.hcQ.a(d.c.uMj);
        this.hdb = false;
        paramInt1 = 0;
      }
    }
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.hcE, this.hcT });
    this.hcR = paramInt1;
    avb();
    if (!this.gkP)
    {
      nD(paramInt1);
      this.gkP = true;
    }
    avb();
    if ((!this.hdh) && (!this.hdf) && (this.hcJ != null))
    {
      paramInt1 = this.hcJ.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void avs()
        {
          AppMethodBeat.i(209898);
          ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] onPcmReady");
          if (c.this.avh() != d.c.uMq)
          {
            ac.w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(209898);
            return;
          }
          c.this.hcQ.a(d.c.uMj);
          AppMethodBeat.o(209898);
        }
      });
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.hdb = false;
      if (paramInt1 != 0)
      {
        this.hcQ.a(d.c.uMp);
        AppMethodBeat.o(93372);
        return paramInt1;
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93376);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] cancel");
    release();
    AppMethodBeat.o(93376);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93378);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] clear");
    release();
    AppMethodBeat.o(93378);
  }
  
  public final void eq(boolean paramBoolean)
  {
    this.hdf = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.hcE;
  }
  
  public final g getFrameDataCallback()
  {
    return this.hdv;
  }
  
  public final boolean nE(int paramInt)
  {
    AppMethodBeat.i(93371);
    if (!this.gkP)
    {
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preInit, cameraOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = nD(paramInt);
      this.gkP = true;
      ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93371);
      return bool;
    }
    AppMethodBeat.o(93371);
    return true;
  }
  
  public final void nF(int paramInt)
  {
    AppMethodBeat.i(93387);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hcH = paramInt;
    AppMethodBeat.o(93387);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93384);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] pause");
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMj))
    {
      this.hcQ.a(d.c.uMr);
      if (this.hcJ != null) {
        this.hcJ.pause();
      }
      this.hdq = System.nanoTime();
    }
    AppMethodBeat.o(93384);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93377);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] reset");
    release();
    AppMethodBeat.o(93377);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93381);
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.IJ(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.IJ(paramInt4);
    }
    ac.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.hcO = paramInt1;
    this.hcP = paramInt2;
    if (j.uMV.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null) {
      cY(paramInt1, paramInt2);
    }
    AppMethodBeat.o(93381);
  }
  
  public final void setFilePath(String paramString)
  {
    this.hcE = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(93388);
    this.hdk.gTi.ee(paramBoolean);
    AppMethodBeat.o(93388);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.hdh = paramBoolean;
  }
  
  public final void vx(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void vy(String paramString)
  {
    this.hcV = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c
 * JD-Core Version:    0.7.0.1
 */