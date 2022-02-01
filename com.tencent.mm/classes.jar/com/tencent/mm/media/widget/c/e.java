package com.tencent.mm.media.widget.c;

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
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae.a;
import java.io.ByteArrayOutputStream;

public final class e
  implements b
{
  boolean gBu;
  VideoTransPara gCB;
  boolean gCD;
  int gCE;
  d.a gCF;
  boolean gCI;
  private boolean gCJ;
  long gCT;
  private boolean gCU;
  private g gCW;
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
  com.tencent.mm.plugin.mmsight.model.a.p gDl;
  a gDm;
  com.tencent.mm.plugin.mmsight.model.a.e gDn;
  HandlerThread gDo;
  ap gDp;
  int gDq;
  int gDr;
  boolean gDs;
  private boolean gDt;
  private int gDu;
  private boolean gDv;
  private boolean gDw;
  long gDx;
  private boolean ggj;
  private String mFileName;
  private String md5;
  String thumbPath;
  
  public e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93444);
    this.gDm = null;
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
    this.gCT = 0L;
    this.gDx = 0L;
    this.gCJ = false;
    this.gCW = new g()
    {
      public final boolean W(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93431);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(93431);
          return false;
        }
        if (e.this.gCs.tFa == d.c.tDO)
        {
          Object localObject = e.this;
          if ((!((e)localObject).gCw) && (((e)localObject).gCI))
          {
            ((e)localObject).gCw = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            com.tencent.e.h.Iye.aP(new e.8((e)localObject, arrayOfByte));
          }
          if (e.this.gDp != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            e.this.gDp.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(93431);
          return true;
        }
        AppMethodBeat.o(93431);
        return false;
      }
    };
    this.gCU = false;
    this.gCB = paramVideoTransPara;
    this.gCn = paramVideoTransPara.width;
    this.gCo = paramVideoTransPara.height;
    this.gCp = paramVideoTransPara.videoBitrate;
    this.gCs = new s();
    this.ggj = false;
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "create X264YUVMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s, enableHevc:%s", new Object[] { Integer.valueOf(this.gCn), Integer.valueOf(this.gCo), Integer.valueOf(this.gCp), Integer.valueOf(paramVideoTransPara.hcu) });
    com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gwr;
    com.tencent.mm.media.j.d.akK();
    if (paramVideoTransPara.hcu == 1)
    {
      paramVideoTransPara = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.alK();
    }
    AppMethodBeat.o(93444);
  }
  
  private boolean mP(int paramInt)
  {
    AppMethodBeat.i(93453);
    long l = bt.GC();
    if (k.tCN != null) {
      this.gDs = k.tCN.gDs;
    }
    this.gCt = paramInt;
    int j;
    int i;
    label76:
    int k;
    label95:
    int m;
    label114:
    int i1;
    int n;
    if (!this.gDs) {
      if ((paramInt == 90) || (paramInt == 270))
      {
        j = this.gCq;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label337;
        }
        i = this.gCr;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label345;
        }
        k = this.gCo;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label354;
        }
        m = this.gCn;
        i1 = j;
        j = m;
        n = i;
        i = i1;
        i1 = this.gCp;
        m = k;
        if (k % 2 != 0) {
          m = k + 1;
        }
        if (j % 2 == 0) {
          break label698;
        }
        j += 1;
      }
    }
    label400:
    label419:
    label692:
    label698:
    for (;;)
    {
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(j) });
      float f = this.gCB.fps;
      k = this.gCB.hbY;
      int i2 = this.gCB.hbX;
      boolean bool3 = this.gDs;
      int i3 = this.gCB.duration;
      if (this.gCB.hcu == 1)
      {
        bool1 = true;
        label248:
        if (this.gCB.hcu != 1) {
          break label490;
        }
      }
      com.tencent.mm.media.j.d locald;
      label337:
      label345:
      label354:
      label490:
      for (boolean bool2 = true;; bool2 = false)
      {
        i = SightVideoJNI.initDataBufferForMMSightLock(i, n, paramInt, m, j, f, i1, k, 8, i2, 23.0F, bool3, true, i3, false, bool1, com.tencent.mm.plugin.sight.base.b.Z(true, bool2));
        if (i >= 0) {
          break label496;
        }
        ad.e("MicroMsg.X264YUVMP4MuxRecorder", "init failed!");
        locald = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.akL();
        AppMethodBeat.o(93453);
        return false;
        j = this.gCr;
        break;
        i = this.gCq;
        break label76;
        k = this.gCn;
        break label95;
        m = this.gCo;
        break label114;
        if ((paramInt == 90) || (paramInt == 270))
        {
          i = this.gCq;
          label381:
          if ((paramInt != 90) && (paramInt != 270)) {
            break label457;
          }
          j = this.gCr;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label466;
          }
          k = this.gCn;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label475;
          }
        }
        for (m = this.gCo;; m = this.gCn)
        {
          n = j;
          j = m;
          break;
          i = this.gCr;
          break label381;
          j = this.gCq;
          break label400;
          k = this.gCo;
          break label419;
        }
        bool1 = false;
        break label248;
      }
      label457:
      label466:
      label475:
      label496:
      this.gDu = i;
      this.gDl = new com.tencent.mm.plugin.mmsight.model.a.p(this.gDs, paramInt, m, j, this.gDt);
      this.gDl.GU(i);
      if (CaptureMMProxy.getInstance() != null) {
        CaptureMMProxy.getInstance().getInt(ae.a.FmD, -1);
      }
      if (!this.gCJ)
      {
        paramInt = this.gCB.audioSampleRate;
        j = this.gCB.audioBitrate;
        k = this.gCB.gnH;
        if (this.gCB.hcu != 1) {
          break label692;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        this.gDk = new a(paramInt, j, k, com.tencent.mm.plugin.sight.base.b.Z(true, bool1));
        this.gDk.nf(this.gDv);
        if (this.gDk.D(i, com.tencent.mm.plugin.sight.base.e.anm(this.gCg)) < 0)
        {
          locald = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.akN();
        }
        ad.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
        AppMethodBeat.o(93453);
        return true;
      }
    }
  }
  
  public final void C(final Runnable paramRunnable)
  {
    AppMethodBeat.i(93449);
    boolean bool1;
    if (this.gDm == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.gDm != null) && (this.gDm.gDC))
      {
        bool2 = true;
        if ((this.gDm == null) || (!this.gDm.gDD)) {
          break label145;
        }
        bool3 = true;
        ad.i("MicroMsg.X264YUVMP4MuxRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.gDm == null) || (!this.gDm.gDC)) {
          break;
        }
      }
      synchronized (this.gDm.gDG)
      {
        reset();
        aq.f(paramRunnable);
        AppMethodBeat.o(93449);
        return;
        bool1 = false;
        continue;
        bool2 = false;
        break label34;
        label145:
        bool3 = false;
      }
    }
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.gDw), this.gDp });
    if ((this.gDw) && (this.gDp != null))
    {
      this.gDp.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(93433);
          e.a(e.this, paramRunnable);
          AppMethodBeat.o(93433);
        }
      });
      AppMethodBeat.o(93449);
      return;
    }
    com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "MMSightFFMpegRecorder_stop";
      }
      
      public final void run()
      {
        AppMethodBeat.i(93434);
        e.a(e.this, paramRunnable);
        AppMethodBeat.o(93434);
      }
    });
    AppMethodBeat.o(93449);
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93460);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "resume, cameraOrientation: %s, lastPauseTimeMs:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(this.gDx) });
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDW))
    {
      if (this.gDl != null) {
        this.gDl.J(paramInt1, paramInt2, paramInt3);
      }
      this.gCs.a(d.c.tDO);
      if (this.gDx > 0L) {
        this.gCT += System.currentTimeMillis() - this.gDx;
      }
    }
    AppMethodBeat.o(93460);
  }
  
  public final String JS()
  {
    AppMethodBeat.i(93450);
    String str = bt.by(this.md5, "");
    AppMethodBeat.o(93450);
    return str;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(93464);
    if (paramc != null)
    {
      this.gCU = true;
      paramc.mO(this.gDu);
    }
    AppMethodBeat.o(93464);
  }
  
  public final void a(d.a parama)
  {
    this.gCF = parama;
  }
  
  public final void af(float paramFloat)
  {
    AppMethodBeat.i(93463);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.gCk = paramFloat;
    AppMethodBeat.o(93463);
  }
  
  public final String anX()
  {
    return this.thumbPath;
  }
  
  final void aoA()
  {
    if (this.gDm != null) {
      this.gDm.gDD = true;
    }
  }
  
  final void aoB()
  {
    AppMethodBeat.i(93456);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::pcm ready");
    if ((this.gDm != null) && (!this.gDm.gDF)) {
      ad.e("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.gDm });
    }
    synchronized (this.gDm.gDG)
    {
      mS(this.gDm.gDA);
      if (this.gCs.tFa != d.c.tDV)
      {
        ad.w("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(93456);
        return;
      }
    }
    this.gCs.a(d.c.tDO);
    this.gDm = new a();
    this.gDm.gDA = this.gDu;
    com.tencent.e.h.Iye.aP(this.gDm);
    AppMethodBeat.o(93456);
  }
  
  public final void aoj() {}
  
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
    AppMethodBeat.i(93451);
    long l = this.gDl.ajJ();
    AppMethodBeat.o(93451);
    return l;
  }
  
  public final d.c aoq()
  {
    return this.gCs.tFa;
  }
  
  public final int aor()
  {
    AppMethodBeat.i(93457);
    int i = Math.round(this.gCh / 1000.0F);
    AppMethodBeat.o(93457);
    return i;
  }
  
  public final Point aos()
  {
    AppMethodBeat.i(93458);
    Point localPoint = new Point(this.gCq, this.gCr);
    AppMethodBeat.o(93458);
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
    AppMethodBeat.i(93461);
    if (this.gDk != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.gDk.cQf();
      AppMethodBeat.o(93461);
      return locala;
    }
    AppMethodBeat.o(93461);
    return null;
  }
  
  public final void aox()
  {
    this.gCI = false;
  }
  
  public final c aoz()
  {
    return this.gDk;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93455);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.gCs.tFa, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.gBu = paramBoolean;
    this.gCT = 0L;
    this.gDx = 0L;
    this.gCh = 0;
    this.gCE = paramInt2;
    this.gCs.a(d.c.tDN);
    String str = this.gCg;
    if (this.gDm == null)
    {
      paramBoolean = true;
      if ((this.gDm != null) && (!this.gDm.gDF)) {
        break label189;
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.gDm == null) || (this.gDm.gDF)) {
        break label195;
      }
      ad.w("MicroMsg.X264YUVMP4MuxRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(93455);
      return -1;
      paramBoolean = false;
      break;
    }
    label195:
    if (bt.isNullOrNil(this.gCg))
    {
      ad.e("MicroMsg.X264YUVMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93455);
      return -1;
    }
    this.mFileName = com.tencent.mm.vfs.i.aMS(this.gCg);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "mCurRecordPath: %s", new Object[] { this.gCg });
    this.gCt = paramInt1;
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.gCt) });
    if (!this.ggj)
    {
      mP(paramInt1);
      this.ggj = true;
    }
    this.gDl.start();
    if ((!this.gDv) && (this.gDk != null))
    {
      paramInt1 = this.gDk.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void aoB()
        {
          AppMethodBeat.i(93436);
          e.this.aoB();
          AppMethodBeat.o(93436);
        }
      });
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.gDo = com.tencent.e.c.d.gv("BigSightWriteCameraData", 5);
      this.gDo.start();
      this.gDp = new ap(this.gDo.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(93437);
          if (e.this.gDq == -1)
          {
            e.this.gDq = Process.myTid();
            ad.i("MicroMsg.X264YUVMP4MuxRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(e.this.gDq) });
          }
          e locale;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            if (e.this.gDk != null) {
              e.this.gDk.cQe();
            }
            locale = e.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!locale.gDs) {
              break label159;
            }
            paramAnonymousMessage = locale.gDl;
            k = arrayOfByte.length;
            j = locale.gCq;
            i = locale.gCr;
          }
          for (;;)
          {
            paramAnonymousMessage.e(arrayOfByte, k, j, i);
            j.tEA.k(arrayOfByte);
            locale.gCD = true;
            AppMethodBeat.o(93437);
            return;
            label159:
            paramAnonymousMessage = locale.gDl;
            k = arrayOfByte.length;
            if ((locale.gCt == 90) || (locale.gCt == 270)) {}
            for (i = locale.gCq;; i = locale.gCr)
            {
              if ((locale.gCt != 90) && (locale.gCt != 270)) {
                break label242;
              }
              m = locale.gCr;
              j = i;
              i = m;
              break;
            }
            label242:
            int m = locale.gCq;
            j = i;
            i = m;
          }
        }
      };
      this.gCD = false;
      if (paramInt1 == 0) {
        break label434;
      }
      this.gCs.a(d.c.tDU);
    }
    for (;;)
    {
      if (this.gDv) {
        aoB();
      }
      AppMethodBeat.o(93455);
      return paramInt1;
      paramInt1 = 0;
      break;
      label434:
      this.gCs.a(d.c.tDV);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93448);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "cancel");
    this.gCs.a(d.c.tDQ);
    clear();
    this.gCs.a(d.c.tDR);
    AppMethodBeat.o(93448);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93447);
    com.tencent.e.h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        boolean bool2 = true;
        AppMethodBeat.i(93432);
        int i = -1;
        if (e.this.gDl != null)
        {
          i = e.this.gDl.tER;
          if (i < 0)
          {
            ad.v("MicroMsg.X264YUVMP4MuxRecorder", "call clear, but bufID error");
            AppMethodBeat.o(93432);
            return;
          }
          e.this.gDl.stop();
        }
        if (e.this.gDk != null) {
          e.this.gDk.a(null);
        }
        boolean bool1;
        if (e.this.gDm == null)
        {
          bool1 = true;
          if ((e.this.gDm == null) || (!e.this.gDm.gDE)) {
            break label220;
          }
        }
        for (;;)
        {
          ad.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((i >= 0) && (!e.this.mS(i)))
          {
            SightVideoJNI.releaseRecorderBufferRefLock("clear");
            SightVideoJNI.releaseBigSightDataBufferLock(i);
          }
          if (e.this.gDo != null) {
            e.this.gDo.quit();
          }
          e.this.gCT = 0L;
          e.this.gDx = 0L;
          AppMethodBeat.o(93432);
          return;
          bool1 = false;
          break;
          label220:
          bool2 = false;
        }
      }
    });
    AppMethodBeat.o(93447);
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
  
  public final g getFrameDataCallback()
  {
    return this.gCW;
  }
  
  public final boolean mQ(int paramInt)
  {
    AppMethodBeat.i(93454);
    if (!this.ggj)
    {
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = mP(paramInt);
      this.ggj = true;
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93454);
      return bool;
    }
    AppMethodBeat.o(93454);
    return true;
  }
  
  public final void mR(int paramInt)
  {
    AppMethodBeat.i(93462);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gCj = paramInt;
    AppMethodBeat.o(93462);
  }
  
  final boolean mS(int paramInt)
  {
    AppMethodBeat.i(93446);
    if ((this.gDm != null) && (!this.gDm.gDF))
    {
      if (!this.gDm.gDC)
      {
        this.gDm.callback = null;
        this.gDm.gDE = true;
        this.gDm.gDD = true;
        this.gDm.cancel();
      }
      synchronized (this.gDm.gDG)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.gDm.gDA != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.gDm.gDA);
        }
        AppMethodBeat.o(93446);
        return true;
      }
    }
    AppMethodBeat.o(93446);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93459);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "pause");
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDO))
    {
      this.gCs.a(d.c.tDW);
      this.gDx = System.currentTimeMillis();
    }
    AppMethodBeat.o(93459);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93452);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "reset");
    this.gCs.tFa = d.c.tDR;
    this.gCD = false;
    if (this.gDk != null) {
      this.gDk.clear();
    }
    if (this.gDl != null) {
      this.gDl.clear();
    }
    clear();
    AppMethodBeat.o(93452);
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
    AppMethodBeat.i(93445);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.gCq = paramInt1;
    this.gCr = paramInt2;
    if (j.tEA.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bt.GC();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.tEA.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    }
    AppMethodBeat.o(93445);
  }
  
  public final void setFilePath(String paramString)
  {
    this.gCg = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.gDt = paramBoolean;
    if (this.gDl != null) {
      this.gDl.gDt = paramBoolean;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.gCJ = paramBoolean;
  }
  
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
      AppMethodBeat.i(93442);
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
          String str2 = com.tencent.mm.vfs.i.aMQ(e.this.gCg);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          e.this.gCv = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            ad.e("MicroMsg.X264YUVMP4MuxRecorder", "retrieve file name error: %s", new Object[] { e.this.getMessage() });
          }
        }
        AppMethodBeat.o(93442);
        return;
      }
    }
    
    public final String getKey()
    {
      return "SightCustomAsyncMediaRecorder_encode";
    }
    
    public final void run()
    {
      boolean bool = true;
      AppMethodBeat.i(93443);
      if (e.this.gDr == -1)
      {
        e.this.gDr = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ad.i("MicroMsg.X264YUVMP4MuxRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(e.this.gDr) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.gDG)
        {
          if (this.gDD) {
            break label204;
          }
          l = bt.GC();
          i = SightVideoJNI.triggerEncode(this.gDA, Math.max(0, this.gqQ), false);
          ad.i("MicroMsg.X264YUVMP4MuxRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gqQ), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.gqQ);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.gqQ = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(93443);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ad.e("MicroMsg.X264YUVMP4MuxRecorder", "thread sleep error");
          }
        }
      }
      label204:
      long l = bt.GC();
      if (!this.gDE) {
        this.gqQ = SightVideoJNI.triggerEncode(this.gDA, this.gqQ, true);
      }
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gqQ), Boolean.valueOf(this.gDE), Long.valueOf(Thread.currentThread().getId()) });
      Object localObject3;
      Object localObject4;
      if (!this.gDE)
      {
        i = Math.max(1000, this.duration);
        if (e.this.gCj > 0) {
          i = e.this.gCj;
        }
        float f = this.coh;
        if (e.this.gCk > 0.0F) {
          f = e.this.gCk;
        }
        localObject3 = e.this;
        j = this.gDA;
        localObject4 = e.this.gCg;
        int k = e.this.gCp;
        int m = e.this.gCB.audioSampleRate;
        if (e.this.gCB.hcu == 1) {}
        for (;;)
        {
          ((e)localObject3).gDn = new m(j, (String)localObject4, f, k, i, m, false, true, bool);
          l = bt.GC();
          bool = e.this.gDn.cQg();
          ad.i("MicroMsg.X264YUVMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bt.aS(l)), Boolean.valueOf(bool) });
          if (bool) {
            break;
          }
          ad.e("MicroMsg.X264YUVMP4MuxRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.gDA);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93439);
              if (e.this.gCF != null) {
                e.this.gCF.aLq();
              }
              AppMethodBeat.o(93439);
            }
          });
          localObject3 = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.akQ();
          AppMethodBeat.o(93443);
          return;
          bool = false;
        }
        localObject3 = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.akR();
        if (((e.this.gBu) && (e.this.gDs)) || ((!e.this.gDs) && (!e.this.gBu)) || ((e.this.gBu) && (Math.abs(e.this.gCt - e.this.gCE) == 0)) || (e.this.gCE == 180))
        {
          l = bt.GC();
          if ((e.this.gDs) || (e.this.gBu)) {
            break label968;
          }
          i = e.this.gCt;
        }
      }
      for (;;)
      {
        j = i;
        if (e.this.gCE == 180)
        {
          j = i;
          if (!e.this.gDs)
          {
            i += 180;
            j = i;
            if (i > 360) {
              j = i - 360;
            }
          }
        }
        if (j > 0)
        {
          SightVideoJNI.tagRotateVideoVFS(e.this.gCg, e.this.gCv, j);
          ad.i("MicroMsg.X264YUVMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(e.this.gCt), Boolean.valueOf(e.this.gBu), Integer.valueOf(e.this.gCE), Integer.valueOf(j) });
          localObject3 = e.this.gCv;
        }
        try
        {
          com.tencent.mm.vfs.i.lC(e.this.gCv, e.this.gCg);
          com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
          {
            public final String getKey()
            {
              return "BigSightFFMpegRecorder_tagRotate_after_process";
            }
            
            public final void run()
            {
              AppMethodBeat.i(93441);
              try
              {
                com.tencent.mm.vfs.i.deleteFile(this.gDc);
                AppMethodBeat.o(93441);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(93441);
              }
            }
          });
          ad.i("MicroMsg.X264YUVMP4MuxRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
        }
        catch (Exception localException2)
        {
          label898:
          ad.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.gDA);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93440);
              if (e.this.gCF != null) {
                e.this.gCF.aLq();
              }
              AppMethodBeat.o(93440);
            }
          });
          AppMethodBeat.o(93443);
          return;
        }
        try
        {
          localObject3 = com.tencent.mm.plugin.sight.base.e.ano(e.this.gCg);
          if (localObject3 != null)
          {
            localObject4 = com.tencent.mm.media.j.d.gwr;
            com.tencent.mm.media.j.d.cV(((com.tencent.mm.plugin.sight.base.a)localObject3).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject3).frameRate);
          }
        }
        catch (Exception localException3)
        {
          break label898;
          i = 180;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.gDA);
        ad.i("MicroMsg.X264YUVMP4MuxRecorder", "all finish, callback: %s", new Object[] { this.callback });
        e.this.reset();
        aq.f(this.callback);
        this.gDF = true;
        e.this.gDr = -1;
        e.this.gDq = -1;
        AppMethodBeat.o(93443);
        return;
        label968:
        if (e.this.gDs) {
          i = e.this.gCE;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.e
 * JD-Core Version:    0.7.0.1
 */