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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.n;
import com.tencent.mm.plugin.mmsight.model.a.q;
import com.tencent.mm.plugin.mmsight.model.a.t;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;

public final class e
  implements b
{
  private boolean gHg;
  boolean hwM;
  String hxA;
  private int hxB;
  private float hxC;
  int hxD;
  float hxE;
  private int hxH;
  private int hxI;
  int hxJ;
  int hxK;
  int hxL;
  t hxM;
  int hxN;
  String hxP;
  boolean hxQ;
  private String hxR;
  private boolean hxS;
  VideoTransPara hxV;
  boolean hxX;
  int hxY;
  d.a hxZ;
  c hyH;
  q hyI;
  a hyJ;
  com.tencent.mm.plugin.mmsight.model.a.e hyK;
  HandlerThread hyL;
  aq hyM;
  int hyN;
  int hyO;
  boolean hyP;
  private boolean hyQ;
  private int hyR;
  private boolean hyS;
  private boolean hyT;
  long hyU;
  boolean hyc;
  private boolean hyd;
  long hyn;
  private boolean hyo;
  private g hyr;
  private String mFileName;
  private String md5;
  String thumbPath;
  
  public e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93444);
    this.hyJ = null;
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
    this.hxN = 0;
    this.hxP = null;
    this.hyL = null;
    this.hyM = null;
    this.hyN = -1;
    this.hyO = -1;
    this.hyP = false;
    this.hyQ = false;
    this.thumbPath = null;
    this.hxR = null;
    this.hxS = false;
    this.hxQ = false;
    this.gHg = false;
    this.hyR = -1;
    this.hxX = false;
    this.md5 = "";
    this.hwM = false;
    this.hxY = 0;
    this.hyS = false;
    this.hyc = true;
    this.hyT = false;
    this.hyn = 0L;
    this.hyU = 0L;
    this.hyd = false;
    this.hyr = new g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93431);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(93431);
          return false;
        }
        if (e.this.hxM.wcI == d.c.wbs)
        {
          Object localObject = e.this;
          if ((!((e)localObject).hxQ) && (((e)localObject).hyc))
          {
            ((e)localObject).hxQ = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            com.tencent.e.h.MqF.aO(new e.8((e)localObject, arrayOfByte));
          }
          if (e.this.hyM != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            e.this.hyM.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(93431);
          return true;
        }
        AppMethodBeat.o(93431);
        return false;
      }
    };
    this.hyo = false;
    this.hxV = paramVideoTransPara;
    this.hxH = paramVideoTransPara.width;
    this.hxI = paramVideoTransPara.height;
    this.hxJ = paramVideoTransPara.videoBitrate;
    this.hxM = new t();
    this.gHg = false;
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "create X264YUVMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s, enableHevc:%s", new Object[] { Integer.valueOf(this.hxH), Integer.valueOf(this.hxI), Integer.valueOf(this.hxJ), Integer.valueOf(paramVideoTransPara.hYu) });
    com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.auG();
    if (paramVideoTransPara.hYu == 1)
    {
      paramVideoTransPara = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avG();
    }
    AppMethodBeat.o(93444);
  }
  
  private boolean of(int paramInt)
  {
    AppMethodBeat.i(93453);
    long l = bu.HQ();
    if (com.tencent.mm.plugin.mmsight.model.k.wat != null) {
      this.hyP = com.tencent.mm.plugin.mmsight.model.k.wat.hyP;
    }
    this.hxN = paramInt;
    int j;
    int i;
    label76:
    int k;
    label95:
    int m;
    label114:
    int i1;
    int n;
    if (!this.hyP) {
      if ((paramInt == 90) || (paramInt == 270))
      {
        j = this.hxK;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label337;
        }
        i = this.hxL;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label345;
        }
        k = this.hxI;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label354;
        }
        m = this.hxH;
        i1 = j;
        j = m;
        n = i;
        i = i1;
        i1 = this.hxJ;
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
      ae.i("MicroMsg.X264YUVMP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(j) });
      float f = this.hxV.fps;
      k = this.hxV.hXX;
      int i2 = this.hxV.hXW;
      boolean bool3 = this.hyP;
      int i3 = this.hxV.duration;
      if (this.hxV.hYu == 1)
      {
        bool1 = true;
        label248:
        if (this.hxV.hYu != 1) {
          break label490;
        }
      }
      com.tencent.mm.media.k.d locald;
      label337:
      label345:
      label354:
      label490:
      for (boolean bool2 = true;; bool2 = false)
      {
        i = SightVideoJNI.initDataBufferForMMSightLock(i, n, paramInt, m, j, f, i1, k, 8, i2, 23.0F, bool3, true, i3, false, bool1, com.tencent.mm.plugin.sight.base.b.af(true, bool2));
        if (i >= 0) {
          break label496;
        }
        ae.e("MicroMsg.X264YUVMP4MuxRecorder", "init failed!");
        locald = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.auH();
        AppMethodBeat.o(93453);
        return false;
        j = this.hxL;
        break;
        i = this.hxK;
        break label76;
        k = this.hxH;
        break label95;
        m = this.hxI;
        break label114;
        if ((paramInt == 90) || (paramInt == 270))
        {
          i = this.hxK;
          label381:
          if ((paramInt != 90) && (paramInt != 270)) {
            break label457;
          }
          j = this.hxL;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label466;
          }
          k = this.hxH;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label475;
          }
        }
        for (m = this.hxI;; m = this.hxH)
        {
          n = j;
          j = m;
          break;
          i = this.hxL;
          break label381;
          j = this.hxK;
          break label400;
          k = this.hxI;
          break label419;
        }
        bool1 = false;
        break label248;
      }
      label457:
      label466:
      label475:
      label496:
      this.hyR = i;
      this.hyI = new q(this.hyP, paramInt, m, j, this.hyQ);
      this.hyI.KN(i);
      if (CaptureMMProxy.getInstance() != null) {
        CaptureMMProxy.getInstance().getInt(am.a.IRi, -1);
      }
      if (!this.hyd)
      {
        paramInt = this.hxV.audioSampleRate;
        j = this.hxV.audioBitrate;
        k = this.hxV.audioChannelCount;
        if (this.hxV.hYu != 1) {
          break label692;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        this.hyH = new a(paramInt, j, k, com.tencent.mm.plugin.sight.base.b.af(true, bool1));
        this.hyH.ox(this.hyS);
        if (this.hyH.E(i, com.tencent.mm.plugin.sight.base.e.ayL(this.hxA)) < 0)
        {
          locald = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.auJ();
        }
        ae.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
        AppMethodBeat.o(93453);
        return true;
      }
    }
  }
  
  public final void B(final Runnable paramRunnable)
  {
    AppMethodBeat.i(93449);
    boolean bool1;
    if (this.hyJ == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.hyJ != null) && (this.hyJ.hyZ))
      {
        bool2 = true;
        if ((this.hyJ == null) || (!this.hyJ.hza)) {
          break label145;
        }
        bool3 = true;
        ae.i("MicroMsg.X264YUVMP4MuxRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.hyJ == null) || (!this.hyJ.hyZ)) {
          break;
        }
      }
      synchronized (this.hyJ.hzd)
      {
        reset();
        ar.f(paramRunnable);
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
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.hyT), this.hyM });
    if ((this.hyT) && (this.hyM != null))
    {
      this.hyM.post(new Runnable()
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
    com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
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
  
  public final void L(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93460);
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "resume, cameraOrientation: %s, lastPauseTimeMs:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(this.hyU) });
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbA))
    {
      if (this.hyI != null) {
        this.hyI.L(paramInt1, paramInt2, paramInt3);
      }
      this.hxM.a(d.c.wbs);
      if (this.hyU > 0L) {
        this.hyn += System.currentTimeMillis() - this.hyU;
      }
    }
    AppMethodBeat.o(93460);
  }
  
  public final String Lj()
  {
    AppMethodBeat.i(93450);
    String str = bu.bI(this.md5, "");
    AppMethodBeat.o(93450);
    return str;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(93464);
    if (paramc != null)
    {
      this.hyo = true;
      paramc.oe(this.hyR);
    }
    AppMethodBeat.o(93464);
  }
  
  public final void a(d.a parama)
  {
    this.hxZ = parama;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(93463);
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.hxE = paramFloat;
    AppMethodBeat.o(93463);
  }
  
  public final boolean aoA()
  {
    return this.hwM;
  }
  
  public final String axP()
  {
    return this.thumbPath;
  }
  
  public final void ayc() {}
  
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
    AppMethodBeat.i(93451);
    long l = this.hyI.atL();
    AppMethodBeat.o(93451);
    return l;
  }
  
  public final d.c ayj()
  {
    return this.hxM.wcI;
  }
  
  public final int ayk()
  {
    AppMethodBeat.i(93457);
    int i = Math.round(this.hxB / 1000.0F);
    AppMethodBeat.o(93457);
    return i;
  }
  
  public final Point ayl()
  {
    AppMethodBeat.i(93458);
    Point localPoint = new Point(this.hxK, this.hxL);
    AppMethodBeat.o(93458);
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
    AppMethodBeat.i(93461);
    if (this.hyH != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hyH.dqh();
      AppMethodBeat.o(93461);
      return locala;
    }
    AppMethodBeat.o(93461);
    return null;
  }
  
  public final void ayp()
  {
    this.hyc = false;
  }
  
  public final c ayr()
  {
    return this.hyH;
  }
  
  final void ayt()
  {
    if (this.hyJ != null) {
      this.hyJ.hza = true;
    }
  }
  
  final void ayu()
  {
    AppMethodBeat.i(93456);
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::pcm ready");
    if ((this.hyJ != null) && (!this.hyJ.hzc)) {
      ae.e("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.hyJ });
    }
    synchronized (this.hyJ.hzd)
    {
      oi(this.hyJ.hyX);
      if (this.hxM.wcI != d.c.wbz)
      {
        ae.w("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(93456);
        return;
      }
    }
    this.hxM.a(d.c.wbs);
    this.hyJ = new a();
    this.hyJ.hyX = this.hyR;
    com.tencent.e.h.MqF.aO(this.hyJ);
    AppMethodBeat.o(93456);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93455);
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.hxM.wcI, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hwM = paramBoolean;
    this.hyn = 0L;
    this.hyU = 0L;
    this.hxB = 0;
    this.hxY = paramInt2;
    this.hxM.a(d.c.wbr);
    String str = this.hxA;
    if (this.hyJ == null)
    {
      paramBoolean = true;
      if ((this.hyJ != null) && (!this.hyJ.hzc)) {
        break label189;
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.X264YUVMP4MuxRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.hyJ == null) || (this.hyJ.hzc)) {
        break label195;
      }
      ae.w("MicroMsg.X264YUVMP4MuxRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(93455);
      return -1;
      paramBoolean = false;
      break;
    }
    label195:
    if (bu.isNullOrNil(this.hxA))
    {
      ae.e("MicroMsg.X264YUVMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93455);
      return -1;
    }
    this.mFileName = o.aZW(this.hxA);
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "mCurRecordPath: %s", new Object[] { this.hxA });
    this.hxN = paramInt1;
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.hxN) });
    if (!this.gHg)
    {
      of(paramInt1);
      this.gHg = true;
    }
    this.hyI.start();
    if ((!this.hyS) && (this.hyH != null))
    {
      paramInt1 = this.hyH.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void ayu()
        {
          AppMethodBeat.i(93436);
          e.this.ayu();
          AppMethodBeat.o(93436);
        }
      });
      ae.i("MicroMsg.X264YUVMP4MuxRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.hyL = com.tencent.e.c.d.hg("BigSightWriteCameraData", 5);
      this.hyL.start();
      this.hyM = new aq(this.hyL.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(93437);
          if (e.this.hyN == -1)
          {
            e.this.hyN = Process.myTid();
            ae.i("MicroMsg.X264YUVMP4MuxRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(e.this.hyN) });
          }
          e locale;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            if (e.this.hyH != null) {
              e.this.hyH.dqg();
            }
            locale = e.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!locale.hyP) {
              break label159;
            }
            paramAnonymousMessage = locale.hyI;
            k = arrayOfByte.length;
            j = locale.hxK;
            i = locale.hxL;
          }
          for (;;)
          {
            paramAnonymousMessage.f(arrayOfByte, k, j, i);
            com.tencent.mm.plugin.mmsight.model.a.k.wcg.k(arrayOfByte);
            locale.hxX = true;
            AppMethodBeat.o(93437);
            return;
            label159:
            paramAnonymousMessage = locale.hyI;
            k = arrayOfByte.length;
            if ((locale.hxN == 90) || (locale.hxN == 270)) {}
            for (i = locale.hxK;; i = locale.hxL)
            {
              if ((locale.hxN != 90) && (locale.hxN != 270)) {
                break label242;
              }
              m = locale.hxL;
              j = i;
              i = m;
              break;
            }
            label242:
            int m = locale.hxK;
            j = i;
            i = m;
          }
        }
      };
      this.hxX = false;
      if (paramInt1 == 0) {
        break label434;
      }
      this.hxM.a(d.c.wby);
    }
    for (;;)
    {
      if (this.hyS) {
        ayu();
      }
      AppMethodBeat.o(93455);
      return paramInt1;
      paramInt1 = 0;
      break;
      label434:
      this.hxM.a(d.c.wbz);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93448);
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "cancel");
    this.hxM.a(d.c.wbu);
    clear();
    this.hxM.a(d.c.wbv);
    AppMethodBeat.o(93448);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93447);
    com.tencent.e.h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        boolean bool2 = true;
        AppMethodBeat.i(93432);
        int i = -1;
        if (e.this.hyI != null)
        {
          i = e.this.hyI.wcz;
          if (i < 0)
          {
            ae.v("MicroMsg.X264YUVMP4MuxRecorder", "call clear, but bufID error");
            AppMethodBeat.o(93432);
            return;
          }
          e.this.hyI.stop();
        }
        if (e.this.hyH != null) {
          e.this.hyH.a(null);
        }
        boolean bool1;
        if (e.this.hyJ == null)
        {
          bool1 = true;
          if ((e.this.hyJ == null) || (!e.this.hyJ.hzb)) {
            break label220;
          }
        }
        for (;;)
        {
          ae.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((i >= 0) && (!e.this.oi(i)))
          {
            SightVideoJNI.releaseRecorderBufferRefLock("clear");
            SightVideoJNI.releaseBigSightDataBufferLock(i);
          }
          if (e.this.hyL != null) {
            e.this.hyL.quit();
          }
          e.this.hyn = 0L;
          e.this.hyU = 0L;
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
  
  public final void eu(boolean paramBoolean)
  {
    this.hyS = paramBoolean;
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
    AppMethodBeat.i(93454);
    if (!this.gHg)
    {
      ae.i("MicroMsg.X264YUVMP4MuxRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = of(paramInt);
      this.gHg = true;
      ae.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93454);
      return bool;
    }
    AppMethodBeat.o(93454);
    return true;
  }
  
  public final void oh(int paramInt)
  {
    AppMethodBeat.i(93462);
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hxD = paramInt;
    AppMethodBeat.o(93462);
  }
  
  final boolean oi(int paramInt)
  {
    AppMethodBeat.i(93446);
    if ((this.hyJ != null) && (!this.hyJ.hzc))
    {
      if (!this.hyJ.hyZ)
      {
        this.hyJ.callback = null;
        this.hyJ.hzb = true;
        this.hyJ.hza = true;
        this.hyJ.cancel();
      }
      synchronized (this.hyJ.hzd)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.hyJ.hyX != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.hyJ.hyX);
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
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "pause");
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbs))
    {
      this.hxM.a(d.c.wbA);
      this.hyU = System.currentTimeMillis();
    }
    AppMethodBeat.o(93459);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93452);
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "reset");
    this.hxM.wcI = d.c.wbv;
    this.hxX = false;
    if (this.hyH != null) {
      this.hyH.clear();
    }
    if (this.hyI != null) {
      this.hyI.clear();
    }
    clear();
    AppMethodBeat.o(93452);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93445);
    ae.i("MicroMsg.X264YUVMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.hxK = paramInt1;
    this.hxL = paramInt2;
    if (com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ae.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bu.HQ();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        com.tencent.mm.plugin.mmsight.model.a.k.wcg.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ae.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    }
    AppMethodBeat.o(93445);
  }
  
  public final void setFilePath(String paramString)
  {
    this.hxA = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.hyQ = paramBoolean;
    if (this.hyI != null) {
      this.hyI.hyQ = paramBoolean;
    }
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
  
  final class a
    extends com.tencent.e.i.b
  {
    Runnable callback;
    float cwp;
    int duration;
    volatile int hmE;
    int hyX;
    volatile boolean hyY;
    boolean hyZ;
    boolean hza;
    boolean hzb;
    boolean hzc;
    final Object hzd;
    
    public a()
    {
      AppMethodBeat.i(93442);
      this.hmE = 0;
      this.hyY = true;
      this.hyZ = false;
      this.hza = false;
      this.hzb = false;
      this.hzc = false;
      this.hzd = new Object();
      this.callback = null;
      synchronized (this.hzd)
      {
        try
        {
          String str2 = o.aZU(e.this.hxA);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          e.this.hxP = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            ae.e("MicroMsg.X264YUVMP4MuxRecorder", "retrieve file name error: %s", new Object[] { e.this.getMessage() });
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
      if (e.this.hyO == -1)
      {
        e.this.hyO = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ae.i("MicroMsg.X264YUVMP4MuxRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(e.this.hyO) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.hzd)
        {
          if (this.hza) {
            break label204;
          }
          l = bu.HQ();
          i = SightVideoJNI.triggerEncode(this.hyX, Math.max(0, this.hmE), false);
          ae.i("MicroMsg.X264YUVMP4MuxRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hmE), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.hmE);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.hmE = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(93443);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ae.e("MicroMsg.X264YUVMP4MuxRecorder", "thread sleep error");
          }
        }
      }
      label204:
      long l = bu.HQ();
      if (!this.hzb) {
        this.hmE = SightVideoJNI.triggerEncode(this.hyX, this.hmE, true);
      }
      ae.i("MicroMsg.X264YUVMP4MuxRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hmE), Boolean.valueOf(this.hzb), Long.valueOf(Thread.currentThread().getId()) });
      Object localObject3;
      Object localObject4;
      if (!this.hzb)
      {
        i = Math.max(1000, this.duration);
        if (e.this.hxD > 0) {
          i = e.this.hxD;
        }
        float f = this.cwp;
        if (e.this.hxE > 0.0F) {
          f = e.this.hxE;
        }
        localObject3 = e.this;
        j = this.hyX;
        localObject4 = e.this.hxA;
        int k = e.this.hxJ;
        int m = e.this.hxV.audioSampleRate;
        if (e.this.hxV.hYu == 1) {}
        for (;;)
        {
          ((e)localObject3).hyK = new n(j, (String)localObject4, f, k, i, m, false, true, bool);
          l = bu.HQ();
          bool = e.this.hyK.dqi();
          ae.i("MicroMsg.X264YUVMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bu.aO(l)), Boolean.valueOf(bool) });
          if (bool) {
            break;
          }
          ae.e("MicroMsg.X264YUVMP4MuxRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.hyX);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93439);
              if (e.this.hxZ != null) {
                e.this.hxZ.aVS();
              }
              AppMethodBeat.o(93439);
            }
          });
          localObject3 = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.auM();
          AppMethodBeat.o(93443);
          return;
          bool = false;
        }
        localObject3 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.auN();
        if (((e.this.hwM) && (e.this.hyP)) || ((!e.this.hyP) && (!e.this.hwM)) || ((e.this.hwM) && (Math.abs(e.this.hxN - e.this.hxY) == 0)) || (e.this.hxY == 180))
        {
          l = bu.HQ();
          if ((e.this.hyP) || (e.this.hwM)) {
            break label968;
          }
          i = e.this.hxN;
        }
      }
      for (;;)
      {
        j = i;
        if (e.this.hxY == 180)
        {
          j = i;
          if (!e.this.hyP)
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
          SightVideoJNI.tagRotateVideoVFS(e.this.hxA, e.this.hxP, j);
          ae.i("MicroMsg.X264YUVMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(e.this.hxN), Boolean.valueOf(e.this.hwM), Integer.valueOf(e.this.hxY), Integer.valueOf(j) });
          localObject3 = e.this.hxP;
        }
        try
        {
          o.mF(e.this.hxP, e.this.hxA);
          com.tencent.e.h.MqF.aO(new e.a.3(this, (String)localObject3));
          ae.i("MicroMsg.X264YUVMP4MuxRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
        }
        catch (Exception localException2)
        {
          label898:
          ae.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.hyX);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93440);
              if (e.this.hxZ != null) {
                e.this.hxZ.aVS();
              }
              AppMethodBeat.o(93440);
            }
          });
          AppMethodBeat.o(93443);
          return;
        }
        try
        {
          localObject3 = com.tencent.mm.plugin.sight.base.e.ayN(e.this.hxA);
          if (localObject3 != null)
          {
            localObject4 = com.tencent.mm.media.k.d.hrI;
            com.tencent.mm.media.k.d.cX(((com.tencent.mm.plugin.sight.base.a)localObject3).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject3).frameRate);
          }
        }
        catch (Exception localException3)
        {
          break label898;
          i = 180;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.hyX);
        ae.i("MicroMsg.X264YUVMP4MuxRecorder", "all finish, callback: %s", new Object[] { this.callback });
        e.this.reset();
        ar.f(this.callback);
        this.hzc = true;
        e.this.hyO = -1;
        e.this.hyN = -1;
        AppMethodBeat.o(93443);
        return;
        label968:
        if (e.this.hyP) {
          i = e.this.hxY;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.e
 * JD-Core Version:    0.7.0.1
 */