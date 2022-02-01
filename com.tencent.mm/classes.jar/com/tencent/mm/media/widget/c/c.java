package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.opengl.EGLContext;
import android.util.Pair;
import android.view.Surface;
import com.tencent.f.i;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

public final class c
  implements b
{
  private static final Object isn;
  protected int bufId;
  private int dtsCount;
  protected boolean htU;
  private EGLContext ilv;
  private boolean ipv;
  protected boolean iqo;
  protected float irA;
  private int irB;
  private float irC;
  protected com.tencent.mm.plugin.mmsight.model.a.c irD;
  protected com.tencent.mm.media.e.b irE;
  protected int irF;
  protected int irG;
  protected int irH;
  protected int irI;
  protected int irJ;
  protected t irK;
  protected int irL;
  protected boolean irM;
  protected String irN;
  protected boolean irO;
  protected String irP;
  protected boolean irQ;
  protected com.tencent.mm.plugin.mmsight.model.c irR;
  protected com.tencent.mm.plugin.mmsight.model.c irS;
  protected VideoTransPara irT;
  protected n irU;
  protected boolean irV;
  protected int irW;
  protected d.a irX;
  protected Runnable irY;
  protected boolean irZ;
  private final Object irx;
  protected String iry;
  protected int irz;
  protected boolean isa;
  protected boolean isb;
  private long isc;
  private a isd;
  private com.tencent.mm.media.i.a ise;
  private long isf;
  private long isg;
  public boolean ish;
  private double isi;
  private long isj;
  private long isk;
  private long isl;
  private boolean ism;
  private LinkedList<Long> iso;
  private long isp;
  private int isq;
  private Runnable isr;
  protected g iss;
  protected String mFileName;
  protected String md5;
  private boolean released;
  private SurfaceTexture surfaceTexture;
  private int textureId;
  protected String thumbPath;
  
  static
  {
    AppMethodBeat.i(93397);
    isn = new Object();
    AppMethodBeat.o(93397);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama)
  {
    this(paramVideoTransPara, parama, null, -1, null);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt)
  {
    AppMethodBeat.i(93367);
    this.irx = new Object();
    this.iry = "";
    this.irz = 0;
    this.irA = 0.0F;
    this.irB = -1;
    this.irC = -1.0F;
    this.irF = 480;
    this.irG = 640;
    this.irH = 1600000;
    this.irI = 480;
    this.irJ = 640;
    this.bufId = -1;
    this.irM = false;
    this.irN = null;
    this.irO = false;
    this.thumbPath = null;
    this.irP = null;
    this.irQ = false;
    this.irR = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.irS = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.htU = false;
    this.irV = false;
    this.md5 = "";
    this.iqo = false;
    this.irW = 0;
    this.irY = null;
    this.irZ = false;
    this.isa = true;
    this.isb = false;
    this.ipv = false;
    this.isc = 0L;
    this.isd = null;
    this.ise = null;
    this.ilv = null;
    this.textureId = -1;
    this.isf = 0L;
    this.isg = 0L;
    this.ish = false;
    this.isi = 0.0D;
    this.isj = 0L;
    this.isk = 0L;
    this.isl = 0L;
    this.ism = false;
    this.iso = new LinkedList();
    this.isp = -1L;
    this.dtsCount = 0;
    this.isq = 0;
    this.released = false;
    this.isr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218954);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.irK.zwJ = d.c.zvw;
        com.tencent.mm.media.i.a locala = c.a(c.this);
        kotlin.g.a.a local1 = new kotlin.g.a.a() {};
        p.h(local1, "callback");
        locala.k((kotlin.g.a.a)new a.j(local1));
        AppMethodBeat.o(218954);
      }
    };
    this.iss = new g()
    {
      public final boolean ai(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(218956);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(218956);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.ilv = paramEGLContext;
    this.ise = new com.tencent.mm.media.i.a(parama);
    this.textureId = paramInt;
    Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93367);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt, a parama1)
  {
    AppMethodBeat.i(93366);
    this.irx = new Object();
    this.iry = "";
    this.irz = 0;
    this.irA = 0.0F;
    this.irB = -1;
    this.irC = -1.0F;
    this.irF = 480;
    this.irG = 640;
    this.irH = 1600000;
    this.irI = 480;
    this.irJ = 640;
    this.bufId = -1;
    this.irM = false;
    this.irN = null;
    this.irO = false;
    this.thumbPath = null;
    this.irP = null;
    this.irQ = false;
    this.irR = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.irS = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.htU = false;
    this.irV = false;
    this.md5 = "";
    this.iqo = false;
    this.irW = 0;
    this.irY = null;
    this.irZ = false;
    this.isa = true;
    this.isb = false;
    this.ipv = false;
    this.isc = 0L;
    this.isd = null;
    this.ise = null;
    this.ilv = null;
    this.textureId = -1;
    this.isf = 0L;
    this.isg = 0L;
    this.ish = false;
    this.isi = 0.0D;
    this.isj = 0L;
    this.isk = 0L;
    this.isl = 0L;
    this.ism = false;
    this.iso = new LinkedList();
    this.isp = -1L;
    this.dtsCount = 0;
    this.isq = 0;
    this.released = false;
    this.isr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218954);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.irK.zwJ = d.c.zvw;
        com.tencent.mm.media.i.a locala = c.a(c.this);
        kotlin.g.a.a local1 = new kotlin.g.a.a() {};
        p.h(local1, "callback");
        locala.k((kotlin.g.a.a)new a.j(local1));
        AppMethodBeat.o(218954);
      }
    };
    this.iss = new g()
    {
      public final boolean ai(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(218956);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(218956);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.isd = parama1;
    this.ilv = paramEGLContext;
    this.ise = new com.tencent.mm.media.i.a(parama);
    this.textureId = paramInt;
    Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93366);
  }
  
  private void a(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93368);
    this.isc = 0L;
    this.irT = paramVideoTransPara;
    this.irF = paramVideoTransPara.width;
    this.irG = paramVideoTransPara.height;
    this.irK = new t();
    paramVideoTransPara = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aNB();
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.irF), Integer.valueOf(this.irG) });
    AppMethodBeat.o(93368);
  }
  
  private void aQH()
  {
    AppMethodBeat.i(93370);
    int i = this.irF;
    int j = this.irG;
    this.ise.cX(i, j);
    this.ise.qx(this.irL);
    this.ise.cZ(this.irI, this.irJ);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.irI), Integer.valueOf(this.irJ), Integer.valueOf(this.irL) });
    AppMethodBeat.o(93370);
  }
  
  private boolean aQI()
  {
    AppMethodBeat.i(93374);
    long l = Util.currentTicks();
    if (this.irE == null)
    {
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, videoEncoder is null");
      AppMethodBeat.o(93374);
      return false;
    }
    int i = this.irE.frameNum;
    if (this.irz <= 0)
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, mDurationMS error %s", new Object[] { Integer.valueOf(this.irz) });
      AppMethodBeat.o(93374);
      return false;
    }
    this.irA = (i * 1000.0F / this.irz);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.irA), Integer.valueOf(this.irz), this.iry, Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.irB), Float.valueOf(this.irC) });
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] frameCountCallback %s", new Object[] { this.irS.getValue() });
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] yuvRecorderWriteDataCallback %s", new Object[] { this.irR.getValue() });
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
        break label692;
      }
      str = com.tencent.mm.plugin.mmsight.d.eK(str, hashCode());
      i = this.irz;
      if (this.irB > 0) {
        i = this.irB;
      }
      f = this.irA;
      if (this.irC > 0.0F) {
        f = this.irC;
      }
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxResultPath : " + str);
      j = this.bufId;
      k = this.irH;
      m = this.irT.audioSampleRate;
      if ((!this.isb) || (this.ism)) {
        break label701;
      }
    }
    Object localObject;
    label692:
    label701:
    for (boolean bool = true;; bool = false)
    {
      localObject = new n(j, str, f, k, i, m, bool, false, this.irM);
      l = Util.currentTicks();
      bool = ((n)localObject).ejY();
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mux finish, dtsCount:%d, ptsCount:%d", new Object[] { Integer.valueOf(this.dtsCount), Integer.valueOf(this.isq) });
      if (bool) {
        break label707;
      }
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux failed!");
      l.ejM();
      AppMethodBeat.o(93374);
      return false;
      if (Util.isNullOrNil(this.iry)) {
        break;
      }
      str = aa.z(new o(this.iry).heq().her());
      break;
      str = this.iry;
      break label374;
    }
    label707:
    if (this.iqo)
    {
      l = Util.currentTicks();
      if (this.irW != 270) {
        break label999;
      }
    }
    for (i = 270;; i = 90)
    {
      SightVideoJNI.tagRotateVideoVFS(str, this.irN, i);
      this.irQ = true;
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.irL), Boolean.valueOf(this.iqo), Integer.valueOf(this.irW), Integer.valueOf(i) });
      l = Util.currentTicks();
      try
      {
        s.deleteFile(str);
        s.nx(this.irN, str);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] copyFile cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        localObject = this.irN;
        com.tencent.f.h.RTc.b(new c.9(this, (String)localObject), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.irK.a(d.c.zvx);
        this.md5 = s.bhK(str);
        if ((!Util.isNullOrNil(str)) && (!str.equals(this.iry)))
        {
          s.nx(str, this.iry);
          s.deleteFile(str);
        }
        AppMethodBeat.o(93374);
        return true;
      }
      catch (Exception localException)
      {
        label999:
        Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, copy file error");
        AppMethodBeat.o(93374);
      }
    }
    return false;
  }
  
  private void aQJ()
  {
    this.isf = 0L;
    this.isg = 0L;
    this.isi = 0.0D;
    this.isj = 0L;
    this.isk = 0L;
    this.isl = 0L;
  }
  
  private boolean aQU()
  {
    AppMethodBeat.i(93391);
    if ((this.irK.zwJ == d.c.zvu) || (this.irK.zwJ == d.c.zvv))
    {
      if (this.irK.zwJ == d.c.zvv)
      {
        this.irK.zwJ = d.c.zvw;
        Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] forward one more frame", new Object[0]);
      }
      if (this.irD != null) {
        this.irD.ejW();
      }
      this.irS.Hi(1L);
      this.irR.Hi(1L);
      AppMethodBeat.o(93391);
      return true;
    }
    AppMethodBeat.o(93391);
    return false;
  }
  
  private Pair<Long, Boolean> aQV()
  {
    AppMethodBeat.i(218966);
    long l1 = 0L;
    boolean bool = false;
    long l2;
    if (this.isk > 0L)
    {
      l2 = System.nanoTime() - this.isk;
      this.isj += l2;
      this.isl = (((float)this.isl + (float)l2 / 1000000.0F));
      this.isk = 0L;
    }
    Log.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] updateCurrentFrameDts, lastPausePtsDiff:%s", new Object[] { Long.valueOf(this.isj) });
    if (this.isg > 0L)
    {
      l1 = System.nanoTime() - this.isg + this.isf - this.isj;
      this.isj = 0L;
    }
    if (this.ish) {
      if ((this.irK.zwJ == d.c.zvw) || (this.isf == 0L) || (l1 - this.isf >= this.isi * 1000000.0D))
      {
        this.isf = l1;
        this.isg = System.nanoTime();
      }
    }
    for (bool = true;; bool = true)
    {
      l2 = l1 / 1000L;
      if (l2 == 0L)
      {
        this.dtsCount += 1;
        SightVideoJNI.writeDtsDataLock(this.bufId, Math.round(1000.0F / this.irT.fps) * -1 * 1000L);
      }
      this.dtsCount += 1;
      SightVideoJNI.writeDtsDataLock(this.bufId, l2);
      Log.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] updateCurrentFrameDts ptsNs:%s, dtsMs:%s, lastTexturePts:%s, lastTextureNanoTime:%s, accumulatePauseTime:%s, needDrawFrame:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(this.isf), Long.valueOf(this.isg), Long.valueOf(this.isl), Boolean.valueOf(bool) });
      Pair localPair = new Pair(Long.valueOf(l1), Boolean.valueOf(bool));
      AppMethodBeat.o(218966);
      return localPair;
      this.isf = l1;
      this.isg = System.nanoTime();
    }
  }
  
  private void dj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(177314);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
    long l = Util.currentTicks();
    int i = 0;
    while (i < 3)
    {
      k.zwi.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
      i += 1;
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(177314);
  }
  
  private boolean rB(int paramInt)
  {
    AppMethodBeat.i(93369);
    this.released = false;
    long l = Util.currentTicks();
    this.irH = this.irT.videoBitrate;
    if (this.irT.iTr == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = new com.tencent.mm.media.b.d(bool);
      if (!((com.tencent.mm.media.b.d)???).idC) {
        break;
      }
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] encodeConfig  InitError");
      ??? = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNJ();
      AppMethodBeat.o(93369);
      return false;
    }
    this.irM = p.j(((com.tencent.mm.media.b.d)???).mimeType, "video/hevc");
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.irI, this.irJ, paramInt, this.irF, this.irG, this.irT.fps, this.irH, this.irT.iSV, 8, this.irT.iSU, 23.0F, false, false, this.irT.duration, false, this.irM, com.tencent.mm.plugin.sight.base.b.ak(false, this.irM));
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init failed!");
      ??? = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNC();
      AppMethodBeat.o(93369);
      return false;
    }
    this.irL = paramInt;
    this.irG = com.tencent.mm.plugin.mmsight.d.QH(this.irG);
    this.irF = com.tencent.mm.plugin.mmsight.d.QH(this.irF);
    Object localObject2;
    if ((this.irM) && (((com.tencent.mm.media.b.d)???).mimeType.equals("video/hevc")))
    {
      localObject2 = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aOs();
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mTargetRate " + this.irH + "  videoParams.fps: " + this.irT.fps + " mTargetHeight:" + this.irG + " mTargetWidth:" + this.irF + ", minQP:" + this.irT.idF + ", maxQP:" + this.irT.idG);
    ((com.tencent.mm.media.b.d)???).bitrate = this.irH;
    ((com.tencent.mm.media.b.d)???).frameRate = this.irT.fps;
    ((com.tencent.mm.media.b.d)???).targetHeight = this.irG;
    ((com.tencent.mm.media.b.d)???).targetWidth = this.irF;
    ((com.tencent.mm.media.b.d)???).idG = this.irT.idG;
    ((com.tencent.mm.media.b.d)???).idF = this.irT.idF;
    try
    {
      this.irE = new com.tencent.mm.media.e.e((com.tencent.mm.media.b.d)???, new kotlin.g.a.b() {});
      ??? = this.ise;
      localObject2 = this.irE.getInputSurface();
      EGLContext localEGLContext = this.ilv;
      kotlin.g.a.b local5 = new kotlin.g.a.b()
      {
        private x d(Boolean arg1)
        {
          AppMethodBeat.i(218959);
          if (!???.booleanValue())
          {
            ??? = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aND();
          }
          synchronized (c.isn)
          {
            try
            {
              c.isn.notifyAll();
              AppMethodBeat.o(218959);
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
      };
      p.h(localObject2, "surface");
      ((com.tencent.mm.media.i.a)???).surface = ((Surface)localObject2);
      Log.i(((com.tencent.mm.media.i.a)???).TAG, ((com.tencent.mm.media.i.a)???).hashCode() + " initWithSurface, eglContext:" + localEGLContext + ", surface:" + localObject2 + ", waitNewFrame:false, callback:false");
      ((com.tencent.mm.media.i.a)???).k((kotlin.g.a.a)new a.d((com.tencent.mm.media.i.a)???, localEGLContext, (Surface)localObject2, local5));
      synchronized (isn)
      {
        try
        {
          isn.wait(500L);
          this.ise.ihb = new kotlin.g.a.b() {};
          aQH();
          this.irD = new a(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount, com.tencent.mm.plugin.sight.base.b.ak(false, this.irM));
          this.irD.rc(this.irZ);
          paramInt = this.irD.H(this.bufId, com.tencent.mm.plugin.sight.base.e.aNv(this.iry));
          Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl used %sms, ret:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(paramInt) });
          if (paramInt != 0)
          {
            ??? = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNE();
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
      com.tencent.mm.media.k.e locale;
      AppMethodBeat.o(93369);
    }
    catch (Exception localException1)
    {
      release();
      Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException1, "[" + hashCode() + "] init encoder error", new Object[0]);
      MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", true);
      locale = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNC();
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
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release recorder");
      this.irK.a(d.c.zvw);
      synchronized (this.irx)
      {
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release videoEncoder");
        if (this.irE != null)
        {
          this.irE.aMi();
          this.irE.aMj();
          this.irE = null;
          com.tencent.mm.media.k.e locale = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aOj();
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] end release videoEncoder");
        if (this.irD != null)
        {
          this.irD.a(new c.10(this));
          this.irD.clear();
          this.irD = null;
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] release buf-id ? %d", new Object[] { Integer.valueOf(this.bufId) });
        if (this.bufId >= 0) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        }
        this.irK.a(d.c.zvx);
        if (this.ise != null) {
          this.ise.release();
        }
        aQJ();
        this.ish = false;
        this.irV = false;
        this.irU = null;
        this.htU = false;
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
  
  public final void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(93373);
    this.irY = paramRunnable;
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] !!!!!stop, stopCallback: %s !!!", new Object[] { paramRunnable });
    if ((this.irE == null) || ((this.irD == null) && (!this.isb)))
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvx))
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, already in stop videoRecordStatus");
      if (this.irD != null) {
        this.irD.clear();
      }
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    paramRunnable = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aNF();
    if (this.irK != null)
    {
      com.tencent.f.h.RTc.b(this.isr, 1500L, "record_stop_timeout");
      this.irK.a(d.c.zvv);
    }
    if (this.isk > 0L)
    {
      long l1 = System.nanoTime();
      long l2 = this.isk;
      float f = (float)this.isl;
      this.isl = (((float)(l1 - l2) / 1000000.0F + f));
    }
    this.irz = ((int)this.irE.aMm());
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, mDurationMS:%s, accumulatePauseTime:%s", new Object[] { Integer.valueOf(this.irz), Long.valueOf(this.isl) });
    if (this.isl > 0L) {
      this.irz = ((int)(this.irz - this.isl));
    }
    AppMethodBeat.o(93373);
  }
  
  public final void HA(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void HB(String paramString)
  {
    this.irP = paramString;
  }
  
  public final void M(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93385);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.irL = paramInt1;
    this.irI = paramInt2;
    this.irJ = paramInt3;
    this.ise.qx(paramInt1);
    aQH();
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvC))
    {
      this.irK.a(d.c.zvu);
      if (this.irD != null) {
        this.irD.resume();
      }
    }
    AppMethodBeat.o(93385);
  }
  
  public final void a(com.tencent.mm.plugin.mmsight.model.a.c paramc)
  {
    AppMethodBeat.i(93392);
    if (paramc != null)
    {
      this.ism = true;
      paramc.rA(this.bufId);
    }
    AppMethodBeat.o(93392);
  }
  
  public final void a(d.a parama)
  {
    this.irX = parama;
  }
  
  public final void aQG()
  {
    AppMethodBeat.i(93390);
    if ((this.textureId < 0) || (!aQU())) {}
    while ((this.surfaceTexture == null) || (!aQU()))
    {
      AppMethodBeat.o(93390);
      return;
      localObject = aQV();
      if (((Boolean)((Pair)localObject).second).booleanValue()) {
        this.ise.x(this.textureId, ((Long)((Pair)localObject).first).longValue());
      }
    }
    Object localObject = this.ise;
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    p.h(localSurfaceTexture, "surfaceTexture");
    ((com.tencent.mm.media.i.a)localObject).k((kotlin.g.a.a)new a.i((com.tencent.mm.media.i.a)localObject, localSurfaceTexture));
    AppMethodBeat.o(93390);
  }
  
  public final String aQK()
  {
    return this.irP;
  }
  
  public final float aQL()
  {
    return this.irA;
  }
  
  public final long aQM()
  {
    AppMethodBeat.i(93380);
    if (this.irE != null)
    {
      long l = this.irE.aMm();
      AppMethodBeat.o(93380);
      return l;
    }
    AppMethodBeat.o(93380);
    return 0L;
  }
  
  public final d.c aQN()
  {
    return this.irK.zwJ;
  }
  
  public final int aQO()
  {
    AppMethodBeat.i(93382);
    int i = Math.round(this.irz / 1000.0F);
    AppMethodBeat.o(93382);
    return i;
  }
  
  public final Point aQP()
  {
    AppMethodBeat.i(93383);
    Point localPoint = new Point(this.irI, this.irJ);
    AppMethodBeat.o(93383);
    return localPoint;
  }
  
  public final int aQQ()
  {
    return this.irL;
  }
  
  public final boolean aQR()
  {
    return this.irV;
  }
  
  public final com.tencent.mm.audio.b.c.a aQS()
  {
    AppMethodBeat.i(93386);
    if (this.irD != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.irD.ejX();
      AppMethodBeat.o(93386);
      return locala;
    }
    AppMethodBeat.o(93386);
    return null;
  }
  
  public final void aQT()
  {
    this.isa = false;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.c aQW()
  {
    return this.irD;
  }
  
  public final String aQn()
  {
    return this.thumbPath;
  }
  
  public final void av(float paramFloat)
  {
    AppMethodBeat.i(93389);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.irC = paramFloat;
    AppMethodBeat.o(93389);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93372);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.irR.reset();
    this.irz = 0;
    this.isf = 0L;
    this.irS.reset();
    this.irO = false;
    this.iqo = paramBoolean;
    this.irW = paramInt2;
    aQJ();
    this.isi = (1000.0F / this.irT.fps);
    this.irK.a(d.c.zvt);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, checkDropFrameByPts: %s, perFrmaeDuration:%s", new Object[] { Boolean.valueOf(this.ish), Double.valueOf(this.isi) });
    if (Util.isNullOrNil(this.iry))
    {
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93372);
      return -1;
    }
    try
    {
      this.mFileName = s.bpb(this.iry);
      String str2 = s.boZ(this.iry);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.irN = (str1 + hashCode() + "tempRotate.mp4");
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tempRotateFilePath:" + this.irN);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.irK.a(d.c.zvB);
        continue;
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start yuvRecorder with mute");
        this.irK.a(d.c.zvu);
        this.irV = false;
        paramInt1 = 0;
      }
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.iry, this.irN });
    this.irL = paramInt1;
    aQH();
    if (!this.htU)
    {
      rB(paramInt1);
      this.htU = true;
    }
    aQH();
    if ((!this.isb) && (!this.irZ) && (this.irD != null))
    {
      paramInt1 = this.irD.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void aQY()
        {
          AppMethodBeat.i(218962);
          Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] onPcmReady");
          if (c.this.aQN() != d.c.zvB)
          {
            Log.w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(218962);
            return;
          }
          c.this.irK.a(d.c.zvu);
          AppMethodBeat.o(218962);
        }
      });
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.irV = false;
      if (paramInt1 != 0)
      {
        this.irK.a(d.c.zvA);
        AppMethodBeat.o(93372);
        return paramInt1;
      }
    }
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
  
  public final void fk(boolean paramBoolean)
  {
    this.irZ = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.iry;
  }
  
  public final g getFrameDataCallback()
  {
    return this.iss;
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
    return this.iqo;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93384);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] pause");
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvu))
    {
      this.irK.a(d.c.zvC);
      if (this.irD != null) {
        this.irD.pause();
      }
      this.isk = System.nanoTime();
    }
    AppMethodBeat.o(93384);
  }
  
  public final boolean rC(int paramInt)
  {
    AppMethodBeat.i(93371);
    if (!this.htU)
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preInit, cameraOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = rB(paramInt);
      this.htU = true;
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93371);
      return bool;
    }
    AppMethodBeat.o(93371);
    return true;
  }
  
  public final void rD(int paramInt)
  {
    AppMethodBeat.i(93387);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.irB = paramInt;
    AppMethodBeat.o(93387);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93377);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] reset");
    release();
    AppMethodBeat.o(93377);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93381);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.QH(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.QH(paramInt4);
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.irI = paramInt1;
    this.irJ = paramInt2;
    if (k.zwi.h(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null) {
      dj(paramInt1, paramInt2);
    }
    AppMethodBeat.o(93381);
  }
  
  public final void setFilePath(String paramString)
  {
    this.iry = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(93388);
    this.ise.ihs.eD(paramBoolean);
    AppMethodBeat.o(93388);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.isb = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void zV(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c
 * JD-Core Version:    0.7.0.1
 */