package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae.a;
import java.io.ByteArrayOutputStream;

public final class l
  implements d
{
  boolean gBu;
  VideoTransPara gCB;
  boolean gCD;
  int gCE;
  d.a gCF;
  boolean gCI;
  private com.tencent.mm.plugin.mmsight.model.g gCW;
  String gCg;
  private int gCh;
  private float gCi;
  int gCj;
  float gCk;
  private int gCn;
  private int gCo;
  int gCp;
  int gCq;
  int gCr;
  s gCs;
  int gCt;
  String gCv;
  boolean gCw;
  private String gCx;
  private boolean gCy;
  c gDk;
  p gDl;
  e gDn;
  private HandlerThread gDo;
  ap gDp;
  int gDq;
  int gDr;
  boolean gDs;
  private boolean gDt;
  private int gDu;
  private boolean gDv;
  public boolean gDw;
  private boolean ggj;
  private String mFileName;
  private String md5;
  private a tED;
  String thumbPath;
  
  public l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89518);
    this.tED = null;
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
    this.gCt = 0;
    this.gCv = null;
    this.gDo = null;
    this.gDp = null;
    this.gDq = -1;
    this.gDr = -1;
    this.gDs = false;
    this.gDt = false;
    this.thumbPath = null;
    this.gCx = null;
    this.gCy = false;
    this.gCw = false;
    this.ggj = false;
    this.gDu = -1;
    this.gCD = false;
    this.md5 = "";
    this.gBu = false;
    this.gCE = 0;
    this.gDv = false;
    this.gCI = true;
    this.gDw = false;
    this.gCW = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean W(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89506);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(89506);
          return false;
        }
        if (l.this.gCs.tFa == d.c.tDO)
        {
          Object localObject = l.this;
          if ((!((l)localObject).gCw) && (((l)localObject).gCI))
          {
            ((l)localObject).gCw = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            com.tencent.mm.sdk.g.b.c(new l.7((l)localObject, arrayOfByte), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
          }
          if (l.this.gDp != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            l.this.gDp.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(89506);
          return true;
        }
        AppMethodBeat.o(89506);
        return false;
      }
    };
    this.gCB = paramVideoTransPara;
    this.gCn = paramVideoTransPara.width;
    this.gCo = paramVideoTransPara.height;
    this.gCp = paramVideoTransPara.videoBitrate;
    k.cQk();
    int i = k.cQm();
    if (i == -1) {}
    for (this.gCp = paramVideoTransPara.videoBitrate;; this.gCp = i)
    {
      this.gCs = new s();
      this.ggj = false;
      ad.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[] { Integer.valueOf(this.gCn), Integer.valueOf(this.gCo), Integer.valueOf(this.gCp), Integer.valueOf(i) });
      AppMethodBeat.o(89518);
      return;
    }
  }
  
  private boolean mP(int paramInt)
  {
    AppMethodBeat.i(89527);
    long l = bt.GC();
    this.gDs = com.tencent.mm.plugin.mmsight.model.k.tCN.gDs;
    this.gCt = paramInt;
    int j;
    label65:
    int n;
    int m;
    if (!this.gDs) {
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.gCq;
        if ((paramInt != 0) && (paramInt != 180)) {
          break label173;
        }
        j = this.gCr;
        k = this.gCn;
        n = this.gCo;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = this.gCp;
      j = SightVideoJNI.initDataBufferForMMSightLock(m, j, paramInt, k, i, this.gCB.fps, n, this.gCB.hbY, 8, this.gCB.hbX, 23.0F, this.gDs, true, this.gCB.duration, false);
      if (j >= 0) {
        break label296;
      }
      ad.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.l.cPT();
      AppMethodBeat.o(89527);
      return false;
      i = this.gCr;
      break;
      label173:
      j = this.gCq;
      break label65;
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.gCq;
        label197:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label264;
        }
        j = this.gCr;
        label213:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label272;
        }
      }
      label264:
      label272:
      for (k = this.gCn;; k = this.gCo)
      {
        if ((paramInt != 0) && (paramInt != 180)) {
          break label281;
        }
        n = this.gCo;
        m = i;
        i = n;
        break;
        i = this.gCr;
        break label197;
        j = this.gCq;
        break label213;
      }
      label281:
      n = this.gCn;
      m = i;
      i = n;
    }
    label296:
    this.gDu = j;
    this.gDl = new p(this.gDs, paramInt, k, i, this.gDt);
    int k = this.gDl.GU(j);
    paramInt = 0;
    int i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ae.a.FmD, -1);
    }
    boolean bool;
    if (i < 0)
    {
      paramInt = this.gCB.audioSampleRate;
      i = this.gCB.audioBitrate;
      m = this.gCB.gnH;
      if (this.gCB.hcu == 1) {}
      for (bool = true;; bool = false)
      {
        this.gDk = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.b.Z(true, bool));
        this.gDk.nf(this.gDv);
        paramInt = this.gDk.D(j, com.tencent.mm.plugin.sight.base.e.anm(this.gCg));
        if ((k >= 0) && (paramInt >= 0)) {
          break label851;
        }
        ad.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        if ((paramInt >= 0) || (k < 0)) {
          break;
        }
        ad.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
        this.gDk.clear();
        this.gDk = new i(this.gCB.audioSampleRate, this.gCB.audioBitrate, this.gCB.gnH);
        this.gDk.nf(this.gDv);
        paramInt = this.gDk.D(j, com.tencent.mm.plugin.sight.base.e.anm(this.gCg));
        ad.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt < 0) {
          break;
        }
        AppMethodBeat.o(89527);
        return true;
      }
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.l.cPT();
      AppMethodBeat.o(89527);
      return false;
    }
    if (i == 1)
    {
      paramInt = this.gCB.audioSampleRate;
      i = this.gCB.audioBitrate;
      m = this.gCB.gnH;
      if (this.gCB.hcu == 1)
      {
        bool = true;
        this.gDk = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.b.Z(true, bool));
        this.gDk.nf(this.gDv);
        paramInt = this.gDk.D(j, com.tencent.mm.plugin.sight.base.e.anm(this.gCg));
      }
    }
    for (;;)
    {
      if ((k >= 0) && (paramInt >= 0)) {
        break label851;
      }
      ad.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.l.cPT();
      AppMethodBeat.o(89527);
      return false;
      bool = false;
      break;
      if (i == 2)
      {
        this.gDk = new i(this.gCB.audioSampleRate, this.gCB.audioBitrate, this.gCB.gnH);
        this.gDk.nf(this.gDv);
        paramInt = this.gDk.D(j, com.tencent.mm.plugin.sight.base.e.anm(this.gCg));
      }
    }
    label851:
    ad.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    AppMethodBeat.o(89527);
    return true;
  }
  
  private boolean mS(int paramInt)
  {
    AppMethodBeat.i(89520);
    if ((this.tED != null) && (!this.tED.gDF))
    {
      if (!this.tED.gDC)
      {
        this.tED.callback = null;
        this.tED.gDE = true;
        this.tED.gDD = true;
        this.tED.cancel();
      }
      synchronized (this.tED.gDG)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.tED.gDA != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.tED.gDA);
        }
        AppMethodBeat.o(89520);
        return true;
      }
    }
    AppMethodBeat.o(89520);
    return false;
  }
  
  public final void C(final Runnable paramRunnable)
  {
    AppMethodBeat.i(89523);
    boolean bool1;
    if (this.tED == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.tED != null) && (this.tED.gDC))
      {
        bool2 = true;
        if ((this.tED == null) || (!this.tED.gDD)) {
          break label145;
        }
        bool3 = true;
        ad.i("MicroMsg.MMSightFFMpegRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.tED == null) || (!this.tED.gDC)) {
          break;
        }
      }
      synchronized (this.tED.gDG)
      {
        reset();
        aq.f(paramRunnable);
        AppMethodBeat.o(89523);
        return;
        bool1 = false;
        continue;
        bool2 = false;
        break label34;
        label145:
        bool3 = false;
      }
    }
    ad.i("MicroMsg.MMSightFFMpegRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.gDw), this.gDp });
    if ((this.gDw) && (this.gDp != null))
    {
      this.gDp.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89507);
          l.a(l.this, paramRunnable);
          AppMethodBeat.o(89507);
        }
      });
      AppMethodBeat.o(89523);
      return;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89508);
        l.a(l.this, paramRunnable);
        AppMethodBeat.o(89508);
      }
    }, "MMSightFFMpegRecorder_stop");
    AppMethodBeat.o(89523);
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89534);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDW))
    {
      if (this.gDl != null) {
        this.gDl.J(paramInt1, paramInt2, paramInt3);
      }
      this.gCs.a(d.c.tDO);
    }
    AppMethodBeat.o(89534);
  }
  
  public final String JS()
  {
    AppMethodBeat.i(89524);
    String str = bt.by(this.md5, "");
    AppMethodBeat.o(89524);
    return str;
  }
  
  public final void a(d.a parama)
  {
    this.gCF = parama;
  }
  
  public final void af(float paramFloat)
  {
    AppMethodBeat.i(89537);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.gCk = paramFloat;
    AppMethodBeat.o(89537);
  }
  
  public final String anX()
  {
    return this.thumbPath;
  }
  
  final void aoA()
  {
    if (this.tED != null) {
      this.tED.gDD = true;
    }
  }
  
  final void aoB()
  {
    AppMethodBeat.i(89530);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
    if ((this.tED != null) && (!this.tED.gDF)) {
      ad.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.tED });
    }
    synchronized (this.tED.gDG)
    {
      mS(this.tED.gDA);
      if (this.gCs.tFa != d.c.tDV)
      {
        ad.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(89530);
        return;
      }
    }
    this.gCs.a(d.c.tDO);
    this.tED = new a();
    this.tED.gDA = this.gDu;
    com.tencent.mm.sdk.g.b.d(this.tED, "SightCustomAsyncMediaRecorder_encode_" + bt.GC());
    AppMethodBeat.o(89530);
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
    AppMethodBeat.i(89525);
    long l = this.gDl.ajJ();
    AppMethodBeat.o(89525);
    return l;
  }
  
  public final d.c aoq()
  {
    return this.gCs.tFa;
  }
  
  public final int aor()
  {
    AppMethodBeat.i(89531);
    int i = Math.round(this.gCh / 1000.0F);
    AppMethodBeat.o(89531);
    return i;
  }
  
  public final Point aos()
  {
    AppMethodBeat.i(89532);
    Point localPoint = new Point(this.gCq, this.gCr);
    AppMethodBeat.o(89532);
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
    AppMethodBeat.i(89535);
    if (this.gDk != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.gDk.cQf();
      AppMethodBeat.o(89535);
      return locala;
    }
    AppMethodBeat.o(89535);
    return null;
  }
  
  public final void aox()
  {
    this.gCI = false;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89529);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.gCs.tFa, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.gBu = paramBoolean;
    this.gCh = 0;
    this.gCE = paramInt2;
    this.gCs.a(d.c.tDN);
    String str = this.gCg;
    if (this.tED == null)
    {
      paramBoolean = true;
      if ((this.tED != null) && (!this.tED.gDF)) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.MMSightFFMpegRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.tED == null) || (this.tED.gDF)) {
        break label185;
      }
      ad.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(89529);
      return -1;
      paramBoolean = false;
      break;
    }
    label185:
    if (bt.isNullOrNil(this.gCg))
    {
      ad.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89529);
      return -1;
    }
    this.mFileName = com.tencent.mm.vfs.i.aMS(this.gCg);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[] { this.gCg });
    this.gCt = paramInt1;
    ad.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.gCt) });
    if (!this.ggj)
    {
      mP(paramInt1);
      this.ggj = true;
    }
    this.gDl.start();
    if (!this.gDv)
    {
      paramInt1 = this.gDk.a(new c.a()
      {
        public final void aoB()
        {
          AppMethodBeat.i(89510);
          l.this.aoB();
          AppMethodBeat.o(89510);
        }
      });
      ad.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.gDo = com.tencent.e.c.d.gv("BigSightWriteCameraData", 0);
      this.gDo.start();
      this.gDp = new ap(this.gDo.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(89511);
          if (l.this.gDq == -1)
          {
            l.this.gDq = Process.myTid();
            ad.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(l.this.gDq) });
          }
          l locall;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            l.this.gDk.cQe();
            locall = l.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!locall.gDs) {
              break label149;
            }
            paramAnonymousMessage = locall.gDl;
            k = arrayOfByte.length;
            j = locall.gCq;
            i = locall.gCr;
          }
          for (;;)
          {
            paramAnonymousMessage.e(arrayOfByte, k, j, i);
            j.tEA.k(arrayOfByte);
            locall.gCD = true;
            AppMethodBeat.o(89511);
            return;
            label149:
            paramAnonymousMessage = locall.gDl;
            k = arrayOfByte.length;
            if ((locall.gCt == 0) || (locall.gCt == 180)) {}
            for (i = locall.gCq;; i = locall.gCr)
            {
              if ((locall.gCt != 0) && (locall.gCt != 180)) {
                break label228;
              }
              m = locall.gCr;
              j = i;
              i = m;
              break;
            }
            label228:
            int m = locall.gCq;
            j = i;
            i = m;
          }
        }
      };
      this.gCD = false;
      if (paramInt1 == 0) {
        break label441;
      }
      this.gCs.a(d.c.tDU);
    }
    for (;;)
    {
      com.tencent.mm.plugin.mmsight.model.l.cPS();
      ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
      h.vKh.idkeyStat(440L, 1L, 1L, false);
      if (this.gDv) {
        aoB();
      }
      AppMethodBeat.o(89529);
      return paramInt1;
      paramInt1 = 0;
      break;
      label441:
      this.gCs.a(d.c.tDV);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89522);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
    this.gCs.a(d.c.tDQ);
    clear();
    this.gCs.a(d.c.tDR);
    AppMethodBeat.o(89522);
  }
  
  public final void clear()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89521);
    int i = -1;
    if (this.gDl != null)
    {
      i = this.gDl.tER;
      if (i < 0)
      {
        ad.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
        AppMethodBeat.o(89521);
        return;
      }
      this.gDl.stop();
    }
    if (this.gDk != null) {
      this.gDk.a(null);
    }
    boolean bool1;
    if (this.tED == null)
    {
      bool1 = true;
      if ((this.tED == null) || (!this.tED.gDE)) {
        break label177;
      }
    }
    for (;;)
    {
      ad.v("MicroMsg.MMSightFFMpegRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i >= 0) && (!mS(i)))
      {
        SightVideoJNI.releaseRecorderBufferRef("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(i);
      }
      if (this.gDo != null) {
        this.gDo.quit();
      }
      AppMethodBeat.o(89521);
      return;
      bool1 = false;
      break;
      label177:
      bool2 = false;
    }
  }
  
  public final void dV(boolean paramBoolean)
  {
    this.gDv = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.gCg;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.gCW;
  }
  
  public final boolean mQ(int paramInt)
  {
    AppMethodBeat.i(89528);
    if (!this.ggj)
    {
      ad.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = mP(paramInt);
      this.ggj = true;
      ad.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89528);
      return bool;
    }
    AppMethodBeat.o(89528);
    return true;
  }
  
  public final void mR(int paramInt)
  {
    AppMethodBeat.i(89536);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gCj = paramInt;
    AppMethodBeat.o(89536);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89533);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "pause");
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDO)) {
      this.gCs.a(d.c.tDW);
    }
    AppMethodBeat.o(89533);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89526);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "reset");
    this.gCs.tFa = d.c.tDR;
    this.gCD = false;
    if (this.gDk != null) {
      this.gDk.clear();
    }
    if (this.gDl != null) {
      this.gDl.clear();
    }
    clear();
    AppMethodBeat.o(89526);
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
    AppMethodBeat.i(89519);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.gCn = paramInt3;
    this.gCo = paramInt4;
    this.gCq = paramInt1;
    this.gCr = paramInt2;
    if (j.tEA.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ad.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bt.GC();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.tEA.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ad.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    }
    AppMethodBeat.o(89519);
  }
  
  public final void setFilePath(String paramString)
  {
    this.gCg = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.gDt = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  final class a
    extends com.tencent.e.i.b
  {
    Runnable callback;
    float coh;
    int duration;
    int gDA;
    volatile boolean gDB;
    boolean gDC;
    boolean gDD;
    boolean gDE;
    boolean gDF;
    final Object gDG;
    volatile int gqQ;
    
    public a()
    {
      AppMethodBeat.i(89516);
      this.gqQ = 0;
      this.gDB = true;
      this.gDC = false;
      this.gDD = false;
      this.gDE = false;
      this.gDF = false;
      this.gDG = new Object();
      this.callback = null;
      synchronized (this.gDG)
      {
        try
        {
          String str2 = com.tencent.mm.vfs.i.aMQ(l.this.gCg);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          l.this.gCv = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            ad.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[] { l.this.getMessage() });
          }
        }
        AppMethodBeat.o(89516);
        return;
      }
    }
    
    public final String getKey()
    {
      return "MicroMsg.MMSightFFMpegRecorder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(89517);
      if (l.this.gDr == -1)
      {
        l.this.gDr = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ad.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(l.this.gDr) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.gDG)
        {
          if (this.gDD) {
            break label201;
          }
          l = bt.GC();
          i = SightVideoJNI.triggerEncode(this.gDA, Math.max(0, this.gqQ), false);
          ad.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gqQ), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.gqQ);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.gqQ = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(89517);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ad.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
          }
        }
      }
      label201:
      long l = bt.GC();
      if (!this.gDE) {
        this.gqQ = SightVideoJNI.triggerEncode(this.gDA, this.gqQ, true);
      }
      ad.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gqQ), Boolean.valueOf(this.gDE), Long.valueOf(Thread.currentThread().getId()) });
      if (!this.gDE)
      {
        i = Math.max(1000, this.duration);
        if (l.this.gCj > 0) {
          i = l.this.gCj;
        }
        float f = this.coh;
        if (l.this.gCk > 0.0F) {
          f = l.this.gCk;
        }
        l.this.gDn = new m(this.gDA, l.this.gCg, f, l.this.gCp, i, l.this.gCB.audioSampleRate, false, true, false);
        l = bt.GC();
        boolean bool = l.this.gDn.cQg();
        ad.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bt.aS(l)), Boolean.valueOf(bool) });
        if (!bool)
        {
          ad.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.gDA);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89513);
              if (l.this.gCF != null) {
                l.this.gCF.aLq();
              }
              AppMethodBeat.o(89513);
            }
          });
          ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
          h.vKh.idkeyStat(440L, 30L, 1L, false);
          AppMethodBeat.o(89517);
          return;
        }
        if (((l.this.gBu) && (l.this.gDs)) || ((!l.this.gDs) && (!l.this.gBu)) || ((l.this.gBu) && (Math.abs(l.this.gCt - l.this.gCE) == 0)) || (l.this.gCE == 180))
        {
          l = bt.GC();
          if ((l.this.gDs) || (l.this.gBu)) {
            break label895;
          }
          i = l.this.gCt;
        }
      }
      for (;;)
      {
        j = i;
        if (l.this.gCE == 180)
        {
          j = i;
          if (!l.this.gDs)
          {
            i += 180;
            j = i;
            if (i > 360) {
              j = i - 360;
            }
          }
        }
        final String str;
        if (j > 0)
        {
          SightVideoJNI.tagRotateVideoVFS(l.this.gCg, l.this.gCv, j);
          ad.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(l.this.gCt), Boolean.valueOf(l.this.gBu), Integer.valueOf(l.this.gCE), Integer.valueOf(j) });
          str = l.this.gCv;
        }
        try
        {
          com.tencent.mm.vfs.i.lC(l.this.gCv, l.this.gCg);
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89515);
              try
              {
                com.tencent.mm.vfs.i.deleteFile(str);
                AppMethodBeat.o(89515);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(89515);
              }
            }
          }, "BigSightFFMpegRecorder_tagRotate_after_process");
          ad.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
          SightVideoJNI.releaseBigSightDataBufferLock(this.gDA);
          ad.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[] { this.callback });
          l.this.reset();
          aq.f(this.callback);
          this.gDF = true;
          l.this.gDr = -1;
          l.this.gDq = -1;
          AppMethodBeat.o(89517);
          return;
        }
        catch (Exception localException2)
        {
          label895:
          ad.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.gDA);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89514);
              if (l.this.gCF != null) {
                l.this.gCF.aLq();
              }
              AppMethodBeat.o(89514);
            }
          });
          AppMethodBeat.o(89517);
          return;
        }
        if (l.this.gDs) {
          i = l.this.gCE;
        } else {
          i = 180;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l
 * JD-Core Version:    0.7.0.1
 */