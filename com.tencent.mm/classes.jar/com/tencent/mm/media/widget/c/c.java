package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.opengl.EGLContext;
import android.util.Pair;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.a.i;
import com.tencent.mm.media.i.a.j;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.x;

public final class c
  implements b
{
  private static final Object lhr;
  protected int bufId;
  private int dtsCount;
  protected boolean kfR;
  private EGLContext lau;
  private boolean leA;
  protected boolean lft;
  private final Object lgB;
  protected String lgC;
  protected int lgD;
  protected float lgE;
  private int lgF;
  private float lgG;
  protected com.tencent.mm.plugin.mmsight.model.a.c lgH;
  protected com.tencent.mm.media.e.b lgI;
  protected int lgJ;
  protected int lgK;
  protected int lgL;
  protected int lgM;
  protected int lgN;
  protected s lgO;
  protected int lgP;
  protected boolean lgQ;
  protected String lgR;
  protected boolean lgS;
  protected String lgT;
  protected boolean lgU;
  protected com.tencent.mm.plugin.mmsight.model.c lgV;
  protected com.tencent.mm.plugin.mmsight.model.c lgW;
  protected VideoTransPara lgX;
  protected com.tencent.mm.plugin.mmsight.model.a.m lgY;
  protected boolean lgZ;
  protected int lha;
  protected d.a lhb;
  protected Runnable lhc;
  protected boolean lhd;
  protected boolean lhe;
  protected boolean lhf;
  private long lhg;
  private c.a lhh;
  private com.tencent.mm.media.i.a lhi;
  private long lhj;
  private long lhk;
  public boolean lhl;
  private double lhm;
  private long lhn;
  private long lho;
  private long lhp;
  private boolean lhq;
  private LinkedList<Long> lhs;
  private long lht;
  private int lhu;
  private Runnable lhv;
  protected g lhw;
  protected String mFileName;
  protected String md5;
  private boolean released;
  private SurfaceTexture surfaceTexture;
  private int textureId;
  protected String thumbPath;
  
  static
  {
    AppMethodBeat.i(93397);
    lhr = new Object();
    AppMethodBeat.o(93397);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama)
  {
    this(paramVideoTransPara, parama, null, -1, null);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt)
  {
    AppMethodBeat.i(93367);
    this.lgB = new Object();
    this.lgC = "";
    this.lgD = 0;
    this.lgE = 0.0F;
    this.lgF = -1;
    this.lgG = -1.0F;
    this.lgJ = 480;
    this.lgK = 640;
    this.lgL = 1600000;
    this.lgM = 480;
    this.lgN = 640;
    this.bufId = -1;
    this.lgQ = false;
    this.lgR = null;
    this.lgS = false;
    this.thumbPath = null;
    this.lgT = null;
    this.lgU = false;
    this.lgV = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.lgW = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.kfR = false;
    this.lgZ = false;
    this.md5 = "";
    this.lft = false;
    this.lha = 0;
    this.lhc = null;
    this.lhd = false;
    this.lhe = true;
    this.lhf = false;
    this.leA = false;
    this.lhg = 0L;
    this.lhh = null;
    this.lhi = null;
    this.lau = null;
    this.textureId = -1;
    this.lhj = 0L;
    this.lhk = 0L;
    this.lhl = false;
    this.lhm = 0.0D;
    this.lhn = 0L;
    this.lho = 0L;
    this.lhp = 0L;
    this.lhq = false;
    this.lhs = new LinkedList();
    this.lht = -1L;
    this.dtsCount = 0;
    this.lhu = 0;
    this.released = false;
    this.lhv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(263649);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.lgO.Fcd = d.c.FaV;
        com.tencent.mm.media.i.a locala = c.a(c.this);
        kotlin.g.a.a local1 = new kotlin.g.a.a()
        {
          private x aZP()
          {
            AppMethodBeat.i(258741);
            if (c.this.lgI != null)
            {
              Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] final frame draw");
              c.this.lgI.aUx();
              if (c.this.lgH != null) {
                c.this.lgH.a(new c.1.1.1(this));
              }
              c.a(c.this).release();
            }
            AppMethodBeat.o(258741);
            return null;
          }
        };
        p.k(local1, "callback");
        locala.j((kotlin.g.a.a)new a.j(local1));
        AppMethodBeat.o(263649);
      }
    };
    this.lhw = new g()
    {
      public final boolean ar(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(263456);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(263456);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.lau = paramEGLContext;
    this.lhi = new com.tencent.mm.media.i.a(parama);
    this.textureId = paramInt;
    Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93367);
  }
  
  public c(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt, c.a parama1)
  {
    AppMethodBeat.i(93366);
    this.lgB = new Object();
    this.lgC = "";
    this.lgD = 0;
    this.lgE = 0.0F;
    this.lgF = -1;
    this.lgG = -1.0F;
    this.lgJ = 480;
    this.lgK = 640;
    this.lgL = 1600000;
    this.lgM = 480;
    this.lgN = 640;
    this.bufId = -1;
    this.lgQ = false;
    this.lgR = null;
    this.lgS = false;
    this.thumbPath = null;
    this.lgT = null;
    this.lgU = false;
    this.lgV = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.lgW = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.kfR = false;
    this.lgZ = false;
    this.md5 = "";
    this.lft = false;
    this.lha = 0;
    this.lhc = null;
    this.lhd = false;
    this.lhe = true;
    this.lhf = false;
    this.leA = false;
    this.lhg = 0L;
    this.lhh = null;
    this.lhi = null;
    this.lau = null;
    this.textureId = -1;
    this.lhj = 0L;
    this.lhk = 0L;
    this.lhl = false;
    this.lhm = 0.0D;
    this.lhn = 0L;
    this.lho = 0L;
    this.lhp = 0L;
    this.lhq = false;
    this.lhs = new LinkedList();
    this.lht = -1L;
    this.dtsCount = 0;
    this.lhu = 0;
    this.released = false;
    this.lhv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(263649);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "frame to stop timeout");
        c.this.lgO.Fcd = d.c.FaV;
        com.tencent.mm.media.i.a locala = c.a(c.this);
        kotlin.g.a.a local1 = new kotlin.g.a.a()
        {
          private x aZP()
          {
            AppMethodBeat.i(258741);
            if (c.this.lgI != null)
            {
              Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] final frame draw");
              c.this.lgI.aUx();
              if (c.this.lgH != null) {
                c.this.lgH.a(new c.1.1.1(this));
              }
              c.a(c.this).release();
            }
            AppMethodBeat.o(258741);
            return null;
          }
        };
        p.k(local1, "callback");
        locala.j((kotlin.g.a.a)new a.j(local1));
        AppMethodBeat.o(263649);
      }
    };
    this.lhw = new g()
    {
      public final boolean ar(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(263456);
        c.a(c.this, paramAnonymousArrayOfByte);
        AppMethodBeat.o(263456);
        return false;
      }
    };
    a(paramVideoTransPara);
    this.lhh = parama1;
    this.lau = paramEGLContext;
    this.lhi = new com.tencent.mm.media.i.a(parama);
    this.textureId = paramInt;
    Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] textureId : " + paramInt, new Object[0]);
    AppMethodBeat.o(93366);
  }
  
  private void a(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93368);
    this.lhg = 0L;
    this.lgX = paramVideoTransPara;
    this.lgJ = paramVideoTransPara.width;
    this.lgK = paramVideoTransPara.height;
    this.lgO = new s();
    paramVideoTransPara = com.tencent.mm.media.k.f.laB;
    com.tencent.mm.media.k.f.aWf();
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] create MediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.lgJ), Integer.valueOf(this.lgK) });
    AppMethodBeat.o(93368);
  }
  
  private boolean aZA()
  {
    AppMethodBeat.i(93374);
    long l = Util.currentTicks();
    if (this.lgI == null)
    {
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, videoEncoder is null");
      AppMethodBeat.o(93374);
      return false;
    }
    int i = this.lgI.frameNum;
    if (this.lgD <= 0)
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxTask, mDurationMS error %s", new Object[] { Integer.valueOf(this.lgD) });
      AppMethodBeat.o(93374);
      return false;
    }
    this.lgE = (i * 1000.0F / this.lgD);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.lgE), Integer.valueOf(this.lgD), this.lgC, Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.lgF), Float.valueOf(this.lgG) });
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] frameCountCallback %s", new Object[] { this.lgW.getValue() });
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] yuvRecorderWriteDataCallback %s", new Object[] { this.lgV.getValue() });
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
        break label701;
      }
      str = com.tencent.mm.plugin.mmsight.d.fl(str, hashCode());
      i = this.lgD;
      if (this.lgF > 0) {
        i = this.lgF;
      }
      f = this.lgE;
      if (this.lgG > 0.0F) {
        f = this.lgG;
      }
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] muxResultPath : " + str);
      j = this.bufId;
      k = this.lgL;
      m = this.lgX.audioSampleRate;
      if ((!this.lhf) || (this.lhq)) {
        break label710;
      }
    }
    Object localObject;
    label701:
    label710:
    for (boolean bool = true;; bool = false)
    {
      localObject = new com.tencent.mm.plugin.mmsight.model.a.m(j, str, f, k, i, m, bool, false, this.lgQ);
      bool = com.tencent.mm.plugin.sight.base.c.aw(false, this.lgQ);
      l = Util.currentTicks();
      bool = ((com.tencent.mm.plugin.mmsight.model.a.m)localObject).ug(bool);
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "mux finish, dtsCount:%d, ptsCount:%d", new Object[] { Integer.valueOf(this.dtsCount), Integer.valueOf(this.lhu) });
      if (bool) {
        break label716;
      }
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mux failed!");
      k.eTt();
      AppMethodBeat.o(93374);
      return false;
      if (Util.isNullOrNil(this.lgC)) {
        break;
      }
      str = new q(this.lgC).ifB().bOF();
      break;
      str = this.lgC;
      break label374;
    }
    label716:
    if (this.lft)
    {
      l = Util.currentTicks();
      if (this.lha != 270) {
        break label1008;
      }
    }
    for (i = 270;; i = 90)
    {
      SightVideoJNI.tagRotateVideoVFS(str, this.lgR, i);
      this.lgU = true;
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.lgP), Boolean.valueOf(this.lft), Integer.valueOf(this.lha), Integer.valueOf(i) });
      l = Util.currentTicks();
      try
      {
        u.deleteFile(str);
        u.oo(this.lgR, str);
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] copyFile cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        localObject = this.lgR;
        com.tencent.e.h.ZvG.d(new c.9(this, (String)localObject), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.lgO.a(d.c.FaW);
        this.md5 = u.buc(str);
        if ((!Util.isNullOrNil(str)) && (!str.equals(this.lgC)))
        {
          u.oo(str, this.lgC);
          u.deleteFile(str);
        }
        AppMethodBeat.o(93374);
        return true;
      }
      catch (Exception localException)
      {
        label1008:
        Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, copy file error");
        AppMethodBeat.o(93374);
      }
    }
    return false;
  }
  
  private void aZB()
  {
    this.lhj = 0L;
    this.lhk = 0L;
    this.lhm = 0.0D;
    this.lhn = 0L;
    this.lho = 0L;
    this.lhp = 0L;
  }
  
  private boolean aZM()
  {
    AppMethodBeat.i(93391);
    if ((this.lgO.Fcd == d.c.FaT) || (this.lgO.Fcd == d.c.FaU))
    {
      if (this.lgO.Fcd == d.c.FaU)
      {
        this.lgO.Fcd = d.c.FaV;
        Log.printInfoStack("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] forward one more frame", new Object[0]);
      }
      if (this.lgH != null) {
        this.lgH.eTD();
      }
      this.lgW.Ox(1L);
      this.lgV.Ox(1L);
      AppMethodBeat.o(93391);
      return true;
    }
    AppMethodBeat.o(93391);
    return false;
  }
  
  private Pair<Long, Boolean> aZN()
  {
    AppMethodBeat.i(263166);
    long l1 = 0L;
    boolean bool = false;
    long l2;
    if (this.lho > 0L)
    {
      l2 = System.nanoTime() - this.lho;
      this.lhn += l2;
      this.lhp = (((float)this.lhp + (float)l2 / 1000000.0F));
      this.lho = 0L;
    }
    Log.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] updateCurrentFrameDts, lastPausePtsDiff:%s", new Object[] { Long.valueOf(this.lhn) });
    if (this.lhk > 0L)
    {
      l1 = System.nanoTime() - this.lhk + this.lhj - this.lhn;
      this.lhn = 0L;
    }
    if (this.lhl) {
      if ((this.lgO.Fcd == d.c.FaV) || (this.lhj == 0L) || (l1 - this.lhj >= this.lhm * 1000000.0D))
      {
        this.lhj = l1;
        this.lhk = System.nanoTime();
      }
    }
    for (bool = true;; bool = true)
    {
      l2 = l1 / 1000L;
      if (l2 == 0L)
      {
        this.dtsCount += 1;
        SightVideoJNI.writeDtsDataLock(this.bufId, Math.round(1000.0F / this.lgX.fps) * -1 * 1000L);
      }
      this.dtsCount += 1;
      SightVideoJNI.writeDtsDataLock(this.bufId, l2);
      Log.d("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] updateCurrentFrameDts ptsNs:%s, dtsMs:%s, lastTexturePts:%s, lastTextureNanoTime:%s, accumulatePauseTime:%s, needDrawFrame:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(this.lhj), Long.valueOf(this.lhk), Long.valueOf(this.lhp), Boolean.valueOf(bool) });
      Pair localPair = new Pair(Long.valueOf(l1), Boolean.valueOf(bool));
      AppMethodBeat.o(263166);
      return localPair;
      this.lhj = l1;
      this.lhk = System.nanoTime();
    }
  }
  
  private void aZz()
  {
    AppMethodBeat.i(93370);
    int i = this.lgJ;
    int j = this.lgK;
    this.lhi.dt(i, j);
    this.lhi.tm(this.lgP);
    this.lhi.dv(this.lgM, this.lgN);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.lgM), Integer.valueOf(this.lgN), Integer.valueOf(this.lgP) });
    AppMethodBeat.o(93370);
  }
  
  private void dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(177314);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
    long l = Util.currentTicks();
    int i = 0;
    while (i < 3)
    {
      j.FbH.as(new byte[paramInt1 * paramInt2 * 3 / 2]);
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
      this.lgO.a(d.c.FaV);
      synchronized (this.lgB)
      {
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start release videoEncoder");
        if (this.lgI != null)
        {
          this.lgI.aUx();
          this.lgI.aUy();
          this.lgI = null;
          com.tencent.mm.media.k.f localf = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aWN();
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] end release videoEncoder");
        if (this.lgH != null)
        {
          this.lgH.a(new c.10(this));
          this.lgH.clear();
          this.lgH = null;
        }
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] release buf-id ? %d", new Object[] { Integer.valueOf(this.bufId) });
        if (this.bufId >= 0) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        }
        this.lgO.a(d.c.FaW);
        if (this.lhi != null) {
          this.lhi.release();
        }
        aZB();
        this.lhl = false;
        this.lgZ = false;
        this.lgY = null;
        this.kfR = false;
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
    this.lgL = this.lgX.videoBitrate;
    if (this.lgX.lJK == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = new com.tencent.mm.media.b.d(bool);
      if (!((com.tencent.mm.media.b.d)???).kSi) {
        break;
      }
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] encodeConfig  InitError");
      ??? = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWn();
      AppMethodBeat.o(93369);
      return false;
    }
    this.lgQ = p.h(((com.tencent.mm.media.b.d)???).mimeType, "video/hevc");
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.lgM, this.lgN, paramInt, this.lgJ, this.lgK, this.lgX.fps, this.lgL, this.lgX.lJn, 8, this.lgX.lJm, 23.0F, false, false, this.lgX.duration, false, this.lgQ, com.tencent.mm.plugin.sight.base.c.aw(false, this.lgQ));
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] init failed!");
      ??? = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWg();
      AppMethodBeat.o(93369);
      return false;
    }
    this.lgP = paramInt;
    this.lgK = com.tencent.mm.plugin.mmsight.d.WV(this.lgK);
    this.lgJ = com.tencent.mm.plugin.mmsight.d.WV(this.lgJ);
    if ((this.lgQ) && (((com.tencent.mm.media.b.d)???).mimeType.equals("video/hevc")))
    {
      com.tencent.mm.media.k.f localf2 = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWW();
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mTargetRate " + this.lgL + "  videoParams.fps: " + this.lgX.fps + " mTargetHeight:" + this.lgK + " mTargetWidth:" + this.lgJ + ", minQP:" + this.lgX.kSl + ", maxQP:" + this.lgX.kSm);
    ((com.tencent.mm.media.b.d)???).bitrate = this.lgL;
    ((com.tencent.mm.media.b.d)???).frameRate = this.lgX.fps;
    ((com.tencent.mm.media.b.d)???).targetHeight = this.lgK;
    ((com.tencent.mm.media.b.d)???).targetWidth = this.lgJ;
    ((com.tencent.mm.media.b.d)???).kSm = this.lgX.kSm;
    ((com.tencent.mm.media.b.d)???).kSl = this.lgX.kSl;
    try
    {
      this.lgI = new com.tencent.mm.media.e.f((com.tencent.mm.media.b.d)???, new kotlin.g.a.b() {});
      this.lhi.a(this.lgI.aUA(), this.lau, new c.5(this));
      synchronized (lhr)
      {
        try
        {
          lhr.wait(500L);
          this.lhi.kVP = new kotlin.g.a.b()
          {
            private x aZR()
            {
              AppMethodBeat.i(262367);
              if (c.this.lgI != null) {
                c.this.lgI.aUB();
              }
              if ((c.this.lgI != null) && (c.this.lgO.Fcd == d.c.FaV))
              {
                Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] final frame draw");
                com.tencent.e.h.ZvG.bDh("record_stop_timeout");
                c.this.lgI.aUx();
                if (c.this.lgH != null) {
                  c.this.lgH.a(new c.6.1(this));
                }
                c.a(c.this).release();
              }
              AppMethodBeat.o(262367);
              return null;
            }
          };
          aZz();
          this.lgH = new a(this.lgX.audioSampleRate, this.lgX.audioBitrate, this.lgX.audioChannelCount, com.tencent.mm.plugin.sight.base.c.aw(false, this.lgQ));
          this.lgH.uf(this.lhd);
          paramInt = this.lgH.J(this.bufId, com.tencent.mm.plugin.sight.base.f.aYe(this.lgC));
          Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] initImpl used %sms, ret:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(paramInt) });
          if (paramInt != 0)
          {
            ??? = com.tencent.mm.media.k.f.laB;
            com.tencent.mm.media.k.f.aWi();
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
      com.tencent.mm.media.k.f localf1;
      AppMethodBeat.o(93369);
    }
    catch (Exception localException1)
    {
      release();
      Log.printErrStackTrace("MicroMsg.Media.MediaCodecMP4MuxRecorder", localException1, "[" + hashCode() + "] init encoder error", new Object[0]);
      MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", true);
      localf1 = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWg();
      AppMethodBeat.o(93369);
      return false;
    }
    return true;
  }
  
  public final void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(93373);
    this.lhc = paramRunnable;
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] !!!!!stop, stopCallback: %s !!!", new Object[] { paramRunnable });
    if ((this.lgI == null) || ((this.lgH == null) && (!this.lhf)))
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.FaW))
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, already in stop videoRecordStatus");
      if (this.lgH != null) {
        this.lgH.clear();
      }
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(93373);
      return;
    }
    paramRunnable = com.tencent.mm.media.k.f.laB;
    com.tencent.mm.media.k.f.aWj();
    if (this.lgO != null)
    {
      com.tencent.e.h.ZvG.b(this.lhv, 1500L, "record_stop_timeout");
      this.lgO.a(d.c.FaU);
    }
    if (this.lho > 0L)
    {
      long l1 = System.nanoTime();
      long l2 = this.lho;
      float f = (float)this.lhp;
      this.lhp = (((float)(l1 - l2) / 1000000.0F + f));
    }
    this.lgD = ((int)this.lgI.aUC());
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, mDurationMS:%s, accumulatePauseTime:%s", new Object[] { Integer.valueOf(this.lgD), Long.valueOf(this.lhp) });
    if (this.lhp > 0L) {
      this.lgD = ((int)(this.lgD - this.lhp));
    }
    AppMethodBeat.o(93373);
  }
  
  public final void ON(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void OO(String paramString)
  {
    this.lgT = paramString;
  }
  
  public final void P(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93385);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] resume, cameraOrientation: %s, cameraPreviewWidth:%s, cameraPreviewHeight:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lgP = paramInt1;
    this.lgM = paramInt2;
    this.lgN = paramInt3;
    this.lhi.tm(paramInt1);
    aZz();
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.Fbb))
    {
      this.lgO.a(d.c.FaT);
      if (this.lgH != null) {
        this.lgH.resume();
      }
    }
    AppMethodBeat.o(93385);
  }
  
  public final void a(com.tencent.mm.plugin.mmsight.model.a.c paramc)
  {
    AppMethodBeat.i(93392);
    if (paramc != null)
    {
      this.lhq = true;
      paramc.uu(this.bufId);
    }
    AppMethodBeat.o(93392);
  }
  
  public final void a(d.a parama)
  {
    this.lhb = parama;
  }
  
  public final String aZC()
  {
    return this.lgT;
  }
  
  public final float aZD()
  {
    return this.lgE;
  }
  
  public final long aZE()
  {
    AppMethodBeat.i(93380);
    if (this.lgI != null)
    {
      long l = this.lgI.aUC();
      AppMethodBeat.o(93380);
      return l;
    }
    AppMethodBeat.o(93380);
    return 0L;
  }
  
  public final d.c aZF()
  {
    return this.lgO.Fcd;
  }
  
  public final int aZG()
  {
    AppMethodBeat.i(93382);
    int i = Math.round(this.lgD / 1000.0F);
    AppMethodBeat.o(93382);
    return i;
  }
  
  public final Point aZH()
  {
    AppMethodBeat.i(93383);
    Point localPoint = new Point(this.lgM, this.lgN);
    AppMethodBeat.o(93383);
    return localPoint;
  }
  
  public final int aZI()
  {
    return this.lgP;
  }
  
  public final boolean aZJ()
  {
    return this.lgZ;
  }
  
  public final com.tencent.mm.audio.b.c.a aZK()
  {
    AppMethodBeat.i(93386);
    if (this.lgH != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.lgH.eTE();
      AppMethodBeat.o(93386);
      return locala;
    }
    AppMethodBeat.o(93386);
    return null;
  }
  
  public final void aZL()
  {
    this.lhe = false;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.c aZO()
  {
    return this.lgH;
  }
  
  public final String aZe()
  {
    return this.thumbPath;
  }
  
  public final void aZy()
  {
    AppMethodBeat.i(93390);
    if ((this.textureId < 0) || (!aZM())) {}
    while ((this.surfaceTexture == null) || (!aZM()))
    {
      AppMethodBeat.o(93390);
      return;
      localObject = aZN();
      if (((Boolean)((Pair)localObject).second).booleanValue()) {
        this.lhi.x(this.textureId, ((Long)((Pair)localObject).first).longValue());
      }
    }
    Object localObject = this.lhi;
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    p.k(localSurfaceTexture, "surfaceTexture");
    ((com.tencent.mm.media.i.a)localObject).j((kotlin.g.a.a)new a.i((com.tencent.mm.media.i.a)localObject, localSurfaceTexture));
    AppMethodBeat.o(93390);
  }
  
  public final void av(float paramFloat)
  {
    AppMethodBeat.i(93389);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.lgG = paramFloat;
    AppMethodBeat.o(93389);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93372);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.lgV.reset();
    this.lgD = 0;
    this.lhj = 0L;
    this.lgW.reset();
    this.lgS = false;
    this.lft = paramBoolean;
    this.lha = paramInt2;
    aZB();
    this.lhm = (1000.0F / this.lgX.fps);
    this.lgO.a(d.c.FaS);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start, checkDropFrameByPts: %s, perFrmaeDuration:%s", new Object[] { Boolean.valueOf(this.lhl), Double.valueOf(this.lhm) });
    if (Util.isNullOrNil(this.lgC))
    {
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93372);
      return -1;
    }
    try
    {
      this.mFileName = u.bBW(this.lgC);
      String str2 = u.bBT(this.lgC);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.lgR = (str1 + hashCode() + "tempRotate.mp4");
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] tempRotateFilePath:" + this.lgR);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.lgO.a(d.c.Fba);
        continue;
        Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start yuvRecorder with mute");
        this.lgO.a(d.c.FaT);
        this.lgZ = false;
        paramInt1 = 0;
      }
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.lgC, this.lgR });
    this.lgP = paramInt1;
    aZz();
    if (!this.kfR)
    {
      uv(paramInt1);
      this.kfR = true;
    }
    aZz();
    if ((!this.lhf) && (!this.lhd) && (this.lgH != null))
    {
      paramInt1 = this.lgH.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void aZS()
        {
          AppMethodBeat.i(258159);
          Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] onPcmReady");
          if (c.this.aZF() != d.c.Fba)
          {
            Log.w("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(258159);
            return;
          }
          c.this.lgO.a(d.c.FaT);
          AppMethodBeat.o(258159);
        }
      });
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.lgZ = false;
      if (paramInt1 != 0)
      {
        this.lgO.a(d.c.FaZ);
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
  
  public final void fU(boolean paramBoolean)
  {
    this.lhd = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.lgC;
  }
  
  public final g getFrameDataCallback()
  {
    return this.lhw;
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
    return this.lft;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93384);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] pause");
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.FaT))
    {
      this.lgO.a(d.c.Fbb);
      if (this.lgH != null) {
        this.lgH.pause();
      }
      this.lho = System.nanoTime();
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
    this.lgC = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(93388);
    this.lhi.kWg.fj(paramBoolean);
    AppMethodBeat.o(93388);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.lhf = paramBoolean;
  }
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93381);
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.WV(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.WV(paramInt4);
    }
    Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.lgM = paramInt1;
    this.lgN = paramInt2;
    if (j.FbH.k(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null) {
      dE(paramInt1, paramInt2);
    }
    AppMethodBeat.o(93381);
  }
  
  public final boolean uw(int paramInt)
  {
    AppMethodBeat.i(93371);
    if (!this.kfR)
    {
      Log.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] preInit, cameraOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = uv(paramInt);
      this.kfR = true;
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
    this.lgF = paramInt;
    AppMethodBeat.o(93387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c
 * JD-Core Version:    0.7.0.1
 */