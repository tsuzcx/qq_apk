package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.opengl.EGLContext;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.nio.ByteBuffer;
import java.util.LinkedList;

public final class c
  implements b
{
  private static final Object nMb;
  protected int bufId;
  private int dtsCount;
  private EGLContext eXL;
  protected String mFileName;
  protected boolean mGp;
  protected String md5;
  public kotlin.g.a.a nCZ;
  private boolean nJm;
  protected boolean nKe;
  protected boolean nLA;
  protected String nLB;
  protected boolean nLC;
  protected String nLD;
  protected boolean nLE;
  protected com.tencent.mm.plugin.mmsight.model.c nLF;
  protected com.tencent.mm.plugin.mmsight.model.c nLG;
  protected VideoTransPara nLH;
  protected com.tencent.mm.plugin.mmsight.model.a.m nLI;
  protected boolean nLJ;
  protected int nLK;
  protected d.a nLL;
  protected Runnable nLM;
  protected boolean nLN;
  protected boolean nLO;
  protected boolean nLP;
  private long nLQ;
  private a nLR;
  private com.tencent.mm.media.i.a nLS;
  private long nLT;
  private long nLU;
  public boolean nLV;
  private double nLW;
  private long nLX;
  private long nLY;
  private long nLZ;
  private final Object nLl;
  protected String nLm;
  protected int nLn;
  protected float nLo;
  private int nLp;
  private float nLq;
  protected com.tencent.mm.plugin.mmsight.model.a.c nLr;
  protected com.tencent.mm.media.e.b nLs;
  protected int nLt;
  protected int nLu;
  protected int nLv;
  protected int nLw;
  protected int nLx;
  protected com.tencent.mm.plugin.mmsight.model.a.s nLy;
  protected int nLz;
  private boolean nMa;
  private LinkedList<Long> nMc;
  private long nMd;
  private int nMe;
  private Runnable nMf;
  protected g nMg;
  private boolean released;
  private SurfaceTexture surfaceTexture;
  public int textureId;
  protected String thumbPath;
  
  static
  {
    AppMethodBeat.i(93397);
    nMb = new Object();
    AppMethodBeat.o(93397);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama)
  {
    this(paramVideoTransPara, parama, null, -1, null);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt)
  {
    AppMethodBeat.i(93367);
    this.nLl = new Object();
    this.nLm = "";
    this.nLn = 0;
    this.nLo = 0.0F;
    this.nLp = -1;
    this.nLq = -1.0F;
    this.nLt = 480;
    this.nLu = 640;
    this.nLv = 1600000;
    this.nLw = 480;
    this.nLx = 640;
    this.bufId = -1;
    this.nLA = false;
    this.nLB = null;
    this.nLC = false;
    this.thumbPath = null;
    this.nLD = null;
    this.nLE = false;
    this.nLF = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.nLG = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.mGp = false;
    this.nLJ = false;
    this.md5 = "";
    this.nKe = false;
    this.nLK = 0;
    this.nLM = null;
    this.nLN = false;
    this.nLO = true;
    this.nLP = false;
    this.nJm = false;
    this.nLQ = 0L;
    this.nLR = null;
    this.nLS = null;
    this.eXL = null;
    this.textureId = -1;
    this.nLT = 0L;
    this.nLU = 0L;
    this.nLV = false;
    this.nLW = 0.0D;
    this.nLX = 0L;
    this.nLY = 0L;
    this.nLZ = 0L;
    this.nMa = false;
    this.nMc = new LinkedList();
    this.nMd = -1L;
    this.dtsCount = 0;
    this.nMe = 0;
    this.released = false;
    this.nMf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237451);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.nLy.KXM = d.c.KWE;
        c.a(c.this).X(new kotlin.g.a.a() {});
        AppMethodBeat.o(237451);
      }
    };
    this.nMg = new g()
    {
      public final boolean onFrameData(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(237447);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(237447);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.eXL = paramEGLContext;
    this.nLS = new com.tencent.mm.media.i.a(parama);
    this.textureId = paramInt;
    Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93367);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt, a parama1)
  {
    AppMethodBeat.i(93366);
    this.nLl = new Object();
    this.nLm = "";
    this.nLn = 0;
    this.nLo = 0.0F;
    this.nLp = -1;
    this.nLq = -1.0F;
    this.nLt = 480;
    this.nLu = 640;
    this.nLv = 1600000;
    this.nLw = 480;
    this.nLx = 640;
    this.bufId = -1;
    this.nLA = false;
    this.nLB = null;
    this.nLC = false;
    this.thumbPath = null;
    this.nLD = null;
    this.nLE = false;
    this.nLF = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.nLG = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.mGp = false;
    this.nLJ = false;
    this.md5 = "";
    this.nKe = false;
    this.nLK = 0;
    this.nLM = null;
    this.nLN = false;
    this.nLO = true;
    this.nLP = false;
    this.nJm = false;
    this.nLQ = 0L;
    this.nLR = null;
    this.nLS = null;
    this.eXL = null;
    this.textureId = -1;
    this.nLT = 0L;
    this.nLU = 0L;
    this.nLV = false;
    this.nLW = 0.0D;
    this.nLX = 0L;
    this.nLY = 0L;
    this.nLZ = 0L;
    this.nMa = false;
    this.nMc = new LinkedList();
    this.nMd = -1L;
    this.dtsCount = 0;
    this.nMe = 0;
    this.released = false;
    this.nMf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237451);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.nLy.KXM = d.c.KWE;
        c.a(c.this).X(new kotlin.g.a.a() {});
        AppMethodBeat.o(237451);
      }
    };
    this.nMg = new g()
    {
      public final boolean onFrameData(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(237447);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(237447);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.nLR = parama1;
    this.eXL = paramEGLContext;
    this.nLS = new com.tencent.mm.media.i.a(parama);
    this.textureId = paramInt;
    Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93366);
  }
  
  private void a(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93368);
    this.nLQ = 0L;
    this.nLH = paramVideoTransPara;
    this.nLt = paramVideoTransPara.width;
    this.nLu = paramVideoTransPara.height;
    this.nLy = new com.tencent.mm.plugin.mmsight.model.a.s();
    paramVideoTransPara = com.tencent.mm.media.util.f.nFE;
    com.tencent.mm.media.util.f.bqN();
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.nLt), Integer.valueOf(this.nLu) });
    AppMethodBeat.o(93368);
  }
  
  private Pair<Long, Boolean> buL()
  {
    AppMethodBeat.i(237543);
    long l1 = 0L;
    boolean bool = false;
    long l2;
    if (this.nLY > 0L)
    {
      l2 = System.nanoTime() - this.nLY;
      this.nLX += l2;
      this.nLZ = (((float)this.nLZ + (float)l2 / 1000000.0F));
      this.nLY = 0L;
    }
    Log.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] updateCurrentFrameDts, lastPausePtsDiff:%s", new Object[] { Long.valueOf(this.nLX) });
    if (this.nLU > 0L)
    {
      l1 = System.nanoTime() - this.nLU + this.nLT - this.nLX;
      this.nLX = 0L;
    }
    if (this.nLV) {
      if ((this.nLy.KXM == d.c.KWE) || (this.nLT == 0L) || (l1 - this.nLT >= this.nLW * 1000000.0D))
      {
        this.nLT = l1;
        this.nLU = System.nanoTime();
      }
    }
    for (bool = true;; bool = true)
    {
      l2 = l1 / 1000L;
      if (l2 == 0L)
      {
        this.dtsCount += 1;
        SightVideoJNI.writeDtsDataLock(this.bufId, Math.round(1000.0F / this.nLH.fps) * -1 * 1000L);
      }
      this.dtsCount += 1;
      SightVideoJNI.writeDtsDataLock(this.bufId, l2);
      Log.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] updateCurrentFrameDts ptsNs:%s, dtsMs:%s, lastTexturePts:%s, lastTextureNanoTime:%s, accumulatePauseTime:%s, needDrawFrame:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(this.nLT), Long.valueOf(this.nLU), Long.valueOf(this.nLZ), Boolean.valueOf(bool) });
      Pair localPair = new Pair(Long.valueOf(l1), Boolean.valueOf(bool));
      AppMethodBeat.o(237543);
      return localPair;
      this.nLT = l1;
      this.nLU = System.nanoTime();
    }
  }
  
  private void bux()
  {
    AppMethodBeat.i(93370);
    int i = this.nLt;
    int j = this.nLu;
    this.nLS.ej(i, j);
    this.nLS.th(this.nLz);
    this.nLS.el(this.nLw, this.nLx);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.nLw), Integer.valueOf(this.nLx), Integer.valueOf(this.nLz) });
    AppMethodBeat.o(93370);
  }
  
  private boolean buy()
  {
    AppMethodBeat.i(93374);
    long l = Util.currentTicks();
    if (this.nLs == null)
    {
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, videoEncoder is null");
      AppMethodBeat.o(93374);
      return false;
    }
    int i = this.nLs.frameNum;
    if (this.nLn <= 0)
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, mDurationMS error %s", new Object[] { Integer.valueOf(this.nLn) });
      AppMethodBeat.o(93374);
      return false;
    }
    this.nLo = (i * 1000.0F / this.nLn);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.nLo), Integer.valueOf(this.nLn), this.nLm, Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nLp), Float.valueOf(this.nLq) });
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] frameCountCallback %s", new Object[] { this.nLG.getValue() });
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] yuvRecorderWriteDataCallback %s", new Object[] { this.nLF.getValue() });
    String str = null;
    label374:
    float f;
    int j;
    int k;
    int m;
    if (CaptureMMProxy.getInstance() != null)
    {
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      if (Util.isNullOrNil(str)) {
        break label704;
      }
      str = com.tencent.mm.plugin.mmsight.d.ge(str, hashCode());
      i = this.nLn;
      if (this.nLp > 0) {
        i = this.nLp;
      }
      f = this.nLo;
      if (this.nLq > 0.0F) {
        f = this.nLq;
      }
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxResultPath : " + str);
      j = this.bufId;
      k = this.nLv;
      m = this.nLH.audioSampleRate;
      if ((!this.nLP) || (this.nMa)) {
        break label713;
      }
    }
    Object localObject;
    label704:
    label713:
    for (boolean bool = true;; bool = false)
    {
      localObject = new com.tencent.mm.plugin.mmsight.model.a.m(j, str, f, k, i, m, bool, false, this.nLA);
      bool = com.tencent.mm.plugin.sight.base.c.aP(false, this.nLA);
      l = Util.currentTicks();
      bool = ((com.tencent.mm.plugin.mmsight.model.a.m)localObject).yu(bool);
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mux finish, dtsCount:%d, ptsCount:%d", new Object[] { Integer.valueOf(this.dtsCount), Integer.valueOf(this.nMe) });
      if (bool) {
        break label719;
      }
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux failed!");
      k.gcm();
      AppMethodBeat.o(93374);
      return false;
      if (Util.isNullOrNil(this.nLm)) {
        break;
      }
      str = com.tencent.mm.vfs.ah.v(new u(this.nLm).jKP().jKT());
      break;
      str = this.nLm;
      break label374;
    }
    label719:
    if (this.nKe)
    {
      l = Util.currentTicks();
      if (this.nLK != 270) {
        break label1011;
      }
    }
    for (i = 270;; i = 90)
    {
      SightVideoJNI.tagRotateVideoVFS(str, this.nLB, i);
      this.nLE = true;
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nLz), Boolean.valueOf(this.nKe), Integer.valueOf(this.nLK), Integer.valueOf(i) });
      l = Util.currentTicks();
      try
      {
        y.deleteFile(str);
        y.qn(this.nLB, str);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] copyFile cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        localObject = this.nLB;
        com.tencent.threadpool.h.ahAA.g(new c.9(this, (String)localObject), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.nLy.a(d.c.KWF);
        this.md5 = y.bub(str);
        if ((!Util.isNullOrNil(str)) && (!str.equals(this.nLm)))
        {
          y.qn(str, this.nLm);
          y.deleteFile(str);
        }
        AppMethodBeat.o(93374);
        return true;
      }
      catch (Exception localException)
      {
        label1011:
        Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, copy file error");
        AppMethodBeat.o(93374);
      }
    }
    return false;
  }
  
  private void buz()
  {
    this.nLT = 0L;
    this.nLU = 0L;
    this.nLW = 0.0D;
    this.nLX = 0L;
    this.nLY = 0L;
    this.nLZ = 0L;
  }
  
  private void ey(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(177314);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
    long l = Util.currentTicks();
    int i = 0;
    while (i < 3)
    {
      j.KXq.as(new byte[paramInt1 * paramInt2 * 3 / 2]);
      i += 1;
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(177314);
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
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release recorder");
      this.nLy.a(d.c.KWE);
      synchronized (this.nLl)
      {
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release videoEncoder");
        if (this.nLs != null)
        {
          this.nLs.boZ();
          this.nLs.bpa();
          this.nLs = null;
          com.tencent.mm.media.util.f localf = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.brv();
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] end release videoEncoder");
        if (this.nLr != null)
        {
          this.nLr.a(new c.10(this));
          this.nLr.clear();
          this.nLr = null;
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] release buf-id ? %d", new Object[] { Integer.valueOf(this.bufId) });
        if (this.bufId >= 0) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        }
        this.nLy.a(d.c.KWF);
        if (this.nLS != null) {
          this.nLS.release();
        }
        buz();
        this.nLV = false;
        this.nLJ = false;
        this.nLI = null;
        this.mGp = false;
        AppMethodBeat.o(93379);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "[" + hashCode() + "] clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93379);
    }
  }
  
  private boolean uv(int paramInt)
  {
    AppMethodBeat.i(93369);
    this.released = false;
    long l = Util.currentTicks();
    this.nLv = this.nLH.videoBitrate;
    if (this.nLH.oCm == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = new com.tencent.mm.media.b.d(bool);
      if (!((com.tencent.mm.media.b.d)???).nxR) {
        break;
      }
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] encodeConfig  InitError");
      ??? = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bqV();
      AppMethodBeat.o(93369);
      return false;
    }
    this.nLA = kotlin.g.b.s.p(((com.tencent.mm.media.b.d)???).mimeType, "video/hevc");
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.nLw, this.nLx, paramInt, this.nLt, this.nLu, this.nLH.fps, this.nLv, this.nLH.oBP, 8, this.nLH.oBO, 23.0F, false, false, this.nLH.duration, false, this.nLA, com.tencent.mm.plugin.sight.base.c.aP(false, this.nLA));
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init failed!");
      ??? = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bqO();
      AppMethodBeat.o(93369);
      return false;
    }
    this.nLz = paramInt;
    this.nLu = com.tencent.mm.plugin.mmsight.d.aaX(this.nLu);
    this.nLt = com.tencent.mm.plugin.mmsight.d.aaX(this.nLt);
    if ((this.nLA) && (((com.tencent.mm.media.b.d)???).mimeType.equals("video/hevc")))
    {
      com.tencent.mm.media.util.f localf2 = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.brE();
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mTargetRate " + this.nLv + "  videoParams.fps: " + this.nLH.fps + " mTargetHeight:" + this.nLu + " mTargetWidth:" + this.nLt + ", minQP:" + this.nLH.nxU + ", maxQP:" + this.nLH.nxV);
    ((com.tencent.mm.media.b.d)???).bitrate = this.nLv;
    ((com.tencent.mm.media.b.d)???).frameRate = this.nLH.fps;
    ((com.tencent.mm.media.b.d)???).nxP = this.nLu;
    ((com.tencent.mm.media.b.d)???).nxO = this.nLt;
    ((com.tencent.mm.media.b.d)???).nxV = this.nLH.nxV;
    ((com.tencent.mm.media.b.d)???).nxU = this.nLH.nxU;
    try
    {
      this.nLs = new e((com.tencent.mm.media.b.d)???, new kotlin.g.a.b() {});
      this.nLS.a(this.nLs.bph(), this.eXL, new kotlin.g.a.b()
      {
        private kotlin.ah j(Boolean arg1)
        {
          AppMethodBeat.i(237457);
          if (!???.booleanValue())
          {
            ??? = com.tencent.mm.media.util.f.nFE;
            com.tencent.mm.media.util.f.bqP();
          }
          synchronized (c.nMb)
          {
            try
            {
              c.nMb.notifyAll();
              AppMethodBeat.o(237457);
              return null;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException, "[" + hashCode() + "] initSurfaceLock notify error", new Object[0]);
              }
            }
          }
        }
      });
      synchronized (nMb)
      {
        try
        {
          nMb.wait(500L);
          this.nLS.nBl = new kotlin.g.a.b() {};
          bux();
          this.nLr = new a(this.nLH.audioSampleRate, this.nLH.audioBitrate, this.nLH.audioChannelCount, com.tencent.mm.plugin.sight.base.c.aP(false, this.nLA));
          this.nLr.yt(this.nLN);
          paramInt = this.nLr.L(this.bufId, com.tencent.mm.plugin.sight.base.f.aVV(this.nLm));
          Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl used %sms, ret:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(paramInt) });
          if (paramInt != 0)
          {
            ??? = com.tencent.mm.media.util.f.nFE;
            com.tencent.mm.media.util.f.bqQ();
            AppMethodBeat.o(93369);
            return false;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException2, "[" + hashCode() + "] initSurfaceLock wait error", new Object[0]);
          }
        }
      }
      com.tencent.mm.media.util.f localf1;
      AppMethodBeat.o(93369);
    }
    catch (Exception localException1)
    {
      release();
      Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException1, "[" + hashCode() + "] init encoder error", new Object[0]);
      MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", true);
      localf1 = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bqO();
      AppMethodBeat.o(93369);
      return false;
    }
    return true;
  }
  
  public final void A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93381);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.aaX(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.aaX(paramInt4);
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.nLw = paramInt1;
    this.nLx = paramInt2;
    if (j.KXq.m(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null) {
      ey(paramInt1, paramInt2);
    }
    AppMethodBeat.o(93381);
  }
  
  public final void Hd(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void He(String paramString)
  {
    this.nLD = paramString;
  }
  
  public final void J(Runnable paramRunnable)
  {
    AppMethodBeat.i(93373);
    this.nLM = paramRunnable;
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] !!!!!stop, stopCallback: %s !!!", new Object[] { paramRunnable });
    if ((this.nLs == null) || ((this.nLr == null) && (!this.nLP)))
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWF))
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, already in stop videoRecordStatus");
      if (this.nLr != null) {
        this.nLr.clear();
      }
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    paramRunnable = com.tencent.mm.media.util.f.nFE;
    com.tencent.mm.media.util.f.bqR();
    if (this.nLy != null)
    {
      com.tencent.threadpool.h.ahAA.b(this.nMf, 1500L, "record_stop_timeout");
      this.nLy.a(d.c.KWD);
    }
    if (this.nLY > 0L)
    {
      long l1 = System.nanoTime();
      long l2 = this.nLY;
      float f = (float)this.nLZ;
      this.nLZ = (((float)(l1 - l2) / 1000000.0F + f));
    }
    this.nLn = ((int)this.nLs.bpj());
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, mDurationMS:%s, accumulatePauseTime:%s", new Object[] { Integer.valueOf(this.nLn), Long.valueOf(this.nLZ) });
    if (this.nLZ > 0L) {
      this.nLn = ((int)(this.nLn - this.nLZ));
    }
    AppMethodBeat.o(93373);
  }
  
  public final void a(com.tencent.mm.plugin.mmsight.model.a.c paramc)
  {
    AppMethodBeat.i(93392);
    if (paramc != null)
    {
      this.nMa = true;
      paramc.uu(this.bufId);
    }
    AppMethodBeat.o(93392);
  }
  
  public final void a(d.a parama)
  {
    this.nLL = parama;
  }
  
  public final void ae(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93385);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nLz = paramInt1;
    this.nLw = paramInt2;
    this.nLx = paramInt3;
    this.nLS.th(paramInt1);
    bux();
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWK))
    {
      this.nLy.a(d.c.KWC);
      if (this.nLr != null) {
        this.nLr.resume();
      }
    }
    AppMethodBeat.o(93385);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93372);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.nLF.reset();
    this.nLn = 0;
    this.nLT = 0L;
    this.nLG.reset();
    this.nLC = false;
    this.nKe = paramBoolean;
    this.nLK = paramInt2;
    buz();
    this.nLW = (1000.0F / this.nLH.fps);
    this.nLy.a(d.c.KWB);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, checkDropFrameByPts: %s, perFrmaeDuration:%s", new Object[] { Boolean.valueOf(this.nLV), Double.valueOf(this.nLW) });
    if (Util.isNullOrNil(this.nLm))
    {
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93372);
      return -1;
    }
    try
    {
      this.mFileName = y.bEq(this.nLm);
      String str2 = y.bEo(this.nLm);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.nLB = (str1 + hashCode() + "tempRotate.mp4");
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tempRotateFilePath:" + this.nLB);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.nLy.a(d.c.KWJ);
        continue;
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start yuvRecorder with mute");
        this.nLy.a(d.c.KWC);
        this.nLJ = false;
        paramInt1 = 0;
      }
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.nLm, this.nLB });
    this.nLz = paramInt1;
    bux();
    if (!this.mGp)
    {
      uv(paramInt1);
      this.mGp = true;
    }
    bux();
    if ((!this.nLP) && (!this.nLN) && (this.nLr != null))
    {
      paramInt1 = this.nLr.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void buO()
        {
          AppMethodBeat.i(237453);
          Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] onPcmReady");
          if (c.this.buD() != d.c.KWJ)
          {
            Log.w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(237453);
            return;
          }
          c.this.nLy.a(d.c.KWC);
          AppMethodBeat.o(237453);
        }
      });
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.nLJ = false;
      if (paramInt1 != 0)
      {
        this.nLy.a(d.c.KWI);
        AppMethodBeat.o(93372);
        return paramInt1;
      }
    }
  }
  
  public final void bq(float paramFloat)
  {
    AppMethodBeat.i(93389);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.nLq = paramFloat;
    AppMethodBeat.o(93389);
  }
  
  public final String buA()
  {
    return this.nLD;
  }
  
  public final float buB()
  {
    return this.nLo;
  }
  
  public final long buC()
  {
    AppMethodBeat.i(93380);
    if (this.nLs != null)
    {
      long l = this.nLs.bpj();
      AppMethodBeat.o(93380);
      return l;
    }
    AppMethodBeat.o(93380);
    return 0L;
  }
  
  public final d.c buD()
  {
    return this.nLy.KXM;
  }
  
  public final int buE()
  {
    AppMethodBeat.i(93382);
    int i = Math.round(this.nLn / 1000.0F);
    AppMethodBeat.o(93382);
    return i;
  }
  
  public final Point buF()
  {
    AppMethodBeat.i(93383);
    Point localPoint = new Point(this.nLw, this.nLx);
    AppMethodBeat.o(93383);
    return localPoint;
  }
  
  public final int buG()
  {
    return this.nLz;
  }
  
  public final boolean buH()
  {
    return this.nLJ;
  }
  
  public final com.tencent.mm.audio.b.c.a buI()
  {
    AppMethodBeat.i(93386);
    if (this.nLr != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.nLr.gcx();
      AppMethodBeat.o(93386);
      return locala;
    }
    AppMethodBeat.o(93386);
    return null;
  }
  
  public final void buJ()
  {
    this.nLO = false;
  }
  
  public final boolean buK()
  {
    AppMethodBeat.i(93391);
    if ((this.nLy.KXM == d.c.KWC) || (this.nLy.KXM == d.c.KWD))
    {
      if (this.nLy.KXM == d.c.KWD)
      {
        this.nLy.KXM = d.c.KWE;
        Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] forward one more frame", new Object[0]);
      }
      if (this.nLr != null) {
        this.nLr.gcw();
      }
      this.nLG.ss(1L);
      this.nLF.ss(1L);
      AppMethodBeat.o(93391);
      return true;
    }
    AppMethodBeat.o(93391);
    return false;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.c buM()
  {
    return this.nLr;
  }
  
  public final String bud()
  {
    return this.thumbPath;
  }
  
  public final void buw()
  {
    AppMethodBeat.i(93390);
    gJ(true);
    if ((this.surfaceTexture == null) || (!buK()))
    {
      AppMethodBeat.o(93390);
      return;
    }
    this.nLS.g(this.surfaceTexture);
    AppMethodBeat.o(93390);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93376);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] cancel");
    release();
    AppMethodBeat.o(93376);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93378);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] clear");
    release();
    AppMethodBeat.o(93378);
  }
  
  public final void gI(boolean paramBoolean)
  {
    this.nLN = paramBoolean;
  }
  
  public final void gJ(boolean paramBoolean)
  {
    AppMethodBeat.i(237665);
    if ((this.textureId < 0) || (!buK()))
    {
      AppMethodBeat.o(237665);
      return;
    }
    Pair localPair = buL();
    if (((Boolean)localPair.second).booleanValue()) {
      this.nLS.a(this.textureId, ((Long)localPair.first).longValue(), paramBoolean);
    }
    AppMethodBeat.o(237665);
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.nLm;
  }
  
  public final g getFrameDataCallback()
  {
    return this.nMg;
  }
  
  public final String getMd5()
  {
    AppMethodBeat.i(93375);
    String str = Util.nullAs(this.md5, "");
    AppMethodBeat.o(93375);
    return str;
  }
  
  public final boolean isLandscape()
  {
    return this.nKe;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93384);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] pause");
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWC))
    {
      this.nLy.a(d.c.KWK);
      if (this.nLr != null) {
        this.nLr.pause();
      }
      this.nLY = System.nanoTime();
    }
    AppMethodBeat.o(93384);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93377);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] reset");
    release();
    AppMethodBeat.o(93377);
  }
  
  public final void setFilePath(String paramString)
  {
    this.nLm = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(93388);
    this.nLS.nBj.fQ(paramBoolean);
    AppMethodBeat.o(93388);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.nLP = paramBoolean;
  }
  
  public final boolean uw(int paramInt)
  {
    AppMethodBeat.i(93371);
    if (!this.mGp)
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preInit, cameraOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = uv(paramInt);
      this.mGp = true;
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93371);
      return bool;
    }
    AppMethodBeat.o(93371);
    return true;
  }
  
  public final void ux(int paramInt)
  {
    AppMethodBeat.i(93387);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nLp = paramInt;
    AppMethodBeat.o(93387);
  }
  
  public static abstract interface a
  {
    public abstract void ik(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c
 * JD-Core Version:    0.7.0.1
 */