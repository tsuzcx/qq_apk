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
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;

public final class m
  implements d
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
  e hyK;
  private HandlerThread hyL;
  aq hyM;
  int hyN;
  int hyO;
  boolean hyP;
  private boolean hyQ;
  private int hyR;
  private boolean hyS;
  public boolean hyT;
  boolean hyc;
  private com.tencent.mm.plugin.mmsight.model.g hyr;
  private String mFileName;
  private String md5;
  String thumbPath;
  private a wcj;
  
  public m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89518);
    this.wcj = null;
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
    this.hyr = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89506);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(89506);
          return false;
        }
        if (m.this.hxM.wcI == d.c.wbs)
        {
          Object localObject = m.this;
          if ((!((m)localObject).hxQ) && (((m)localObject).hyc))
          {
            ((m)localObject).hxQ = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            com.tencent.mm.sdk.g.b.c(new m.7((m)localObject, arrayOfByte), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
          }
          if (m.this.hyM != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            m.this.hyM.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(89506);
          return true;
        }
        AppMethodBeat.o(89506);
        return false;
      }
    };
    this.hxV = paramVideoTransPara;
    this.hxH = paramVideoTransPara.width;
    this.hxI = paramVideoTransPara.height;
    this.hxJ = paramVideoTransPara.videoBitrate;
    l.dqm();
    int i = l.dqo();
    if (i == -1) {}
    for (this.hxJ = paramVideoTransPara.videoBitrate;; this.hxJ = i)
    {
      this.hxM = new t();
      this.gHg = false;
      ae.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[] { Integer.valueOf(this.hxH), Integer.valueOf(this.hxI), Integer.valueOf(this.hxJ), Integer.valueOf(i) });
      AppMethodBeat.o(89518);
      return;
    }
  }
  
  private boolean of(int paramInt)
  {
    AppMethodBeat.i(89527);
    long l = bu.HQ();
    this.hyP = com.tencent.mm.plugin.mmsight.model.k.wat.hyP;
    this.hxN = paramInt;
    int j;
    label65:
    int n;
    int m;
    if (!this.hyP) {
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.hxK;
        if ((paramInt != 0) && (paramInt != 180)) {
          break label173;
        }
        j = this.hxL;
        k = this.hxH;
        n = this.hxI;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = this.hxJ;
      j = SightVideoJNI.initDataBufferForMMSightLock(m, j, paramInt, k, i, this.hxV.fps, n, this.hxV.hXX, 8, this.hxV.hXW, 23.0F, this.hyP, true, this.hxV.duration, false);
      if (j >= 0) {
        break label296;
      }
      ae.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.l.dpV();
      AppMethodBeat.o(89527);
      return false;
      i = this.hxL;
      break;
      label173:
      j = this.hxK;
      break label65;
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.hxK;
        label197:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label264;
        }
        j = this.hxL;
        label213:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label272;
        }
      }
      label264:
      label272:
      for (k = this.hxH;; k = this.hxI)
      {
        if ((paramInt != 0) && (paramInt != 180)) {
          break label281;
        }
        n = this.hxI;
        m = i;
        i = n;
        break;
        i = this.hxL;
        break label197;
        j = this.hxK;
        break label213;
      }
      label281:
      n = this.hxH;
      m = i;
      i = n;
    }
    label296:
    this.hyR = j;
    this.hyI = new q(this.hyP, paramInt, k, i, this.hyQ);
    int k = this.hyI.KN(j);
    paramInt = 0;
    int i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(am.a.IRi, -1);
    }
    boolean bool;
    if (i < 0)
    {
      paramInt = this.hxV.audioSampleRate;
      i = this.hxV.audioBitrate;
      m = this.hxV.audioChannelCount;
      if (this.hxV.hYu == 1) {}
      for (bool = true;; bool = false)
      {
        this.hyH = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.b.af(true, bool));
        this.hyH.ox(this.hyS);
        paramInt = this.hyH.E(j, com.tencent.mm.plugin.sight.base.e.ayL(this.hxA));
        if ((k >= 0) && (paramInt >= 0)) {
          break label851;
        }
        ae.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        if ((paramInt >= 0) || (k < 0)) {
          break;
        }
        ae.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
        this.hyH.clear();
        this.hyH = new i(this.hxV.audioSampleRate, this.hxV.audioBitrate, this.hxV.audioChannelCount);
        this.hyH.ox(this.hyS);
        paramInt = this.hyH.E(j, com.tencent.mm.plugin.sight.base.e.ayL(this.hxA));
        ae.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt < 0) {
          break;
        }
        AppMethodBeat.o(89527);
        return true;
      }
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.l.dpV();
      AppMethodBeat.o(89527);
      return false;
    }
    if (i == 1)
    {
      paramInt = this.hxV.audioSampleRate;
      i = this.hxV.audioBitrate;
      m = this.hxV.audioChannelCount;
      if (this.hxV.hYu == 1)
      {
        bool = true;
        this.hyH = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.b.af(true, bool));
        this.hyH.ox(this.hyS);
        paramInt = this.hyH.E(j, com.tencent.mm.plugin.sight.base.e.ayL(this.hxA));
      }
    }
    for (;;)
    {
      if ((k >= 0) && (paramInt >= 0)) {
        break label851;
      }
      ae.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.l.dpV();
      AppMethodBeat.o(89527);
      return false;
      bool = false;
      break;
      if (i == 2)
      {
        this.hyH = new i(this.hxV.audioSampleRate, this.hxV.audioBitrate, this.hxV.audioChannelCount);
        this.hyH.ox(this.hyS);
        paramInt = this.hyH.E(j, com.tencent.mm.plugin.sight.base.e.ayL(this.hxA));
      }
    }
    label851:
    ae.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(89527);
    return true;
  }
  
  private boolean oi(int paramInt)
  {
    AppMethodBeat.i(89520);
    if ((this.wcj != null) && (!this.wcj.hzc))
    {
      if (!this.wcj.hyZ)
      {
        this.wcj.callback = null;
        this.wcj.hzb = true;
        this.wcj.hza = true;
        this.wcj.cancel();
      }
      synchronized (this.wcj.hzd)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.wcj.hyX != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.wcj.hyX);
        }
        AppMethodBeat.o(89520);
        return true;
      }
    }
    AppMethodBeat.o(89520);
    return false;
  }
  
  public final void B(final Runnable paramRunnable)
  {
    AppMethodBeat.i(89523);
    boolean bool1;
    if (this.wcj == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.wcj != null) && (this.wcj.hyZ))
      {
        bool2 = true;
        if ((this.wcj == null) || (!this.wcj.hza)) {
          break label145;
        }
        bool3 = true;
        ae.i("MicroMsg.MMSightFFMpegRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.wcj == null) || (!this.wcj.hyZ)) {
          break;
        }
      }
      synchronized (this.wcj.hzd)
      {
        reset();
        ar.f(paramRunnable);
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
    ae.i("MicroMsg.MMSightFFMpegRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.hyT), this.hyM });
    if ((this.hyT) && (this.hyM != null))
    {
      this.hyM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89507);
          m.a(m.this, paramRunnable);
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
        m.a(m.this, paramRunnable);
        AppMethodBeat.o(89508);
      }
    }, "MMSightFFMpegRecorder_stop");
    AppMethodBeat.o(89523);
  }
  
  public final void L(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89534);
    ae.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbA))
    {
      if (this.hyI != null) {
        this.hyI.L(paramInt1, paramInt2, paramInt3);
      }
      this.hxM.a(d.c.wbs);
    }
    AppMethodBeat.o(89534);
  }
  
  public final String Lj()
  {
    AppMethodBeat.i(89524);
    String str = bu.bI(this.md5, "");
    AppMethodBeat.o(89524);
    return str;
  }
  
  public final void a(d.a parama)
  {
    this.hxZ = parama;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(89537);
    ae.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.hxE = paramFloat;
    AppMethodBeat.o(89537);
  }
  
  public final boolean aoA()
  {
    return this.hwM;
  }
  
  public final String axP()
  {
    return this.thumbPath;
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
    AppMethodBeat.i(89525);
    long l = this.hyI.atL();
    AppMethodBeat.o(89525);
    return l;
  }
  
  public final d.c ayj()
  {
    return this.hxM.wcI;
  }
  
  public final int ayk()
  {
    AppMethodBeat.i(89531);
    int i = Math.round(this.hxB / 1000.0F);
    AppMethodBeat.o(89531);
    return i;
  }
  
  public final Point ayl()
  {
    AppMethodBeat.i(89532);
    Point localPoint = new Point(this.hxK, this.hxL);
    AppMethodBeat.o(89532);
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
    AppMethodBeat.i(89535);
    if (this.hyH != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hyH.dqh();
      AppMethodBeat.o(89535);
      return locala;
    }
    AppMethodBeat.o(89535);
    return null;
  }
  
  public final void ayp()
  {
    this.hyc = false;
  }
  
  final void ayt()
  {
    if (this.wcj != null) {
      this.wcj.hza = true;
    }
  }
  
  final void ayu()
  {
    AppMethodBeat.i(89530);
    ae.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
    if ((this.wcj != null) && (!this.wcj.hzc)) {
      ae.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.wcj });
    }
    synchronized (this.wcj.hzd)
    {
      oi(this.wcj.hyX);
      if (this.hxM.wcI != d.c.wbz)
      {
        ae.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(89530);
        return;
      }
    }
    this.hxM.a(d.c.wbs);
    this.wcj = new a();
    this.wcj.hyX = this.hyR;
    com.tencent.mm.sdk.g.b.d(this.wcj, "SightCustomAsyncMediaRecorder_encode_" + bu.HQ());
    AppMethodBeat.o(89530);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89529);
    ae.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.hxM.wcI, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hwM = paramBoolean;
    this.hxB = 0;
    this.hxY = paramInt2;
    this.hxM.a(d.c.wbr);
    String str = this.hxA;
    if (this.wcj == null)
    {
      paramBoolean = true;
      if ((this.wcj != null) && (!this.wcj.hzc)) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.MMSightFFMpegRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.wcj == null) || (this.wcj.hzc)) {
        break label185;
      }
      ae.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(89529);
      return -1;
      paramBoolean = false;
      break;
    }
    label185:
    if (bu.isNullOrNil(this.hxA))
    {
      ae.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89529);
      return -1;
    }
    this.mFileName = o.aZW(this.hxA);
    ae.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[] { this.hxA });
    this.hxN = paramInt1;
    ae.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.hxN) });
    if (!this.gHg)
    {
      of(paramInt1);
      this.gHg = true;
    }
    this.hyI.start();
    if (!this.hyS)
    {
      paramInt1 = this.hyH.a(new c.a()
      {
        public final void ayu()
        {
          AppMethodBeat.i(89510);
          m.this.ayu();
          AppMethodBeat.o(89510);
        }
      });
      ae.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.hyL = com.tencent.e.c.d.hg("BigSightWriteCameraData", 0);
      this.hyL.start();
      this.hyM = new aq(this.hyL.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(89511);
          if (m.this.hyN == -1)
          {
            m.this.hyN = Process.myTid();
            ae.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(m.this.hyN) });
          }
          m localm;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            m.this.hyH.dqg();
            localm = m.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!localm.hyP) {
              break label149;
            }
            paramAnonymousMessage = localm.hyI;
            k = arrayOfByte.length;
            j = localm.hxK;
            i = localm.hxL;
          }
          for (;;)
          {
            paramAnonymousMessage.f(arrayOfByte, k, j, i);
            k.wcg.k(arrayOfByte);
            localm.hxX = true;
            AppMethodBeat.o(89511);
            return;
            label149:
            paramAnonymousMessage = localm.hyI;
            k = arrayOfByte.length;
            if ((localm.hxN == 0) || (localm.hxN == 180)) {}
            for (i = localm.hxK;; i = localm.hxL)
            {
              if ((localm.hxN != 0) && (localm.hxN != 180)) {
                break label228;
              }
              m = localm.hxL;
              j = i;
              i = m;
              break;
            }
            label228:
            int m = localm.hxK;
            j = i;
            i = m;
          }
        }
      };
      this.hxX = false;
      if (paramInt1 == 0) {
        break label441;
      }
      this.hxM.a(d.c.wby);
    }
    for (;;)
    {
      com.tencent.mm.plugin.mmsight.model.l.dpU();
      ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 1L, 1L, false);
      if (this.hyS) {
        ayu();
      }
      AppMethodBeat.o(89529);
      return paramInt1;
      paramInt1 = 0;
      break;
      label441:
      this.hxM.a(d.c.wbz);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89522);
    ae.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
    this.hxM.a(d.c.wbu);
    clear();
    this.hxM.a(d.c.wbv);
    AppMethodBeat.o(89522);
  }
  
  public final void clear()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89521);
    int i = -1;
    if (this.hyI != null)
    {
      i = this.hyI.wcz;
      if (i < 0)
      {
        ae.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
        AppMethodBeat.o(89521);
        return;
      }
      this.hyI.stop();
    }
    if (this.hyH != null) {
      this.hyH.a(null);
    }
    boolean bool1;
    if (this.wcj == null)
    {
      bool1 = true;
      if ((this.wcj == null) || (!this.wcj.hzb)) {
        break label177;
      }
    }
    for (;;)
    {
      ae.v("MicroMsg.MMSightFFMpegRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i >= 0) && (!oi(i)))
      {
        SightVideoJNI.releaseRecorderBufferRef("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(i);
      }
      if (this.hyL != null) {
        this.hyL.quit();
      }
      AppMethodBeat.o(89521);
      return;
      bool1 = false;
      break;
      label177:
      bool2 = false;
    }
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
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.hyr;
  }
  
  public final boolean og(int paramInt)
  {
    AppMethodBeat.i(89528);
    if (!this.gHg)
    {
      ae.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = of(paramInt);
      this.gHg = true;
      ae.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89528);
      return bool;
    }
    AppMethodBeat.o(89528);
    return true;
  }
  
  public final void oh(int paramInt)
  {
    AppMethodBeat.i(89536);
    ae.i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hxD = paramInt;
    AppMethodBeat.o(89536);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89533);
    ae.i("MicroMsg.MMSightFFMpegRecorder", "pause");
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbs)) {
      this.hxM.a(d.c.wbA);
    }
    AppMethodBeat.o(89533);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89526);
    ae.i("MicroMsg.MMSightFFMpegRecorder", "reset");
    this.hxM.wcI = d.c.wbv;
    this.hxX = false;
    if (this.hyH != null) {
      this.hyH.clear();
    }
    if (this.hyI != null) {
      this.hyI.clear();
    }
    clear();
    AppMethodBeat.o(89526);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89519);
    ae.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.hxH = paramInt3;
    this.hxI = paramInt4;
    this.hxK = paramInt1;
    this.hxL = paramInt2;
    if (k.wcg.h(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ae.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bu.HQ();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        k.wcg.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ae.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    }
    AppMethodBeat.o(89519);
  }
  
  public final void setFilePath(String paramString)
  {
    this.hxA = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.hyQ = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean) {}
  
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
      AppMethodBeat.i(89516);
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
          String str2 = o.aZU(m.this.hxA);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          m.this.hxP = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            ae.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[] { m.this.getMessage() });
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
      if (m.this.hyO == -1)
      {
        m.this.hyO = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ae.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(m.this.hyO) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.hzd)
        {
          if (this.hza) {
            break label201;
          }
          l = bu.HQ();
          i = SightVideoJNI.triggerEncode(this.hyX, Math.max(0, this.hmE), false);
          ae.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hmE), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.hmE);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.hmE = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(89517);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ae.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
          }
        }
      }
      label201:
      long l = bu.HQ();
      if (!this.hzb) {
        this.hmE = SightVideoJNI.triggerEncode(this.hyX, this.hmE, true);
      }
      ae.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hmE), Boolean.valueOf(this.hzb), Long.valueOf(Thread.currentThread().getId()) });
      if (!this.hzb)
      {
        i = Math.max(1000, this.duration);
        if (m.this.hxD > 0) {
          i = m.this.hxD;
        }
        float f = this.cwp;
        if (m.this.hxE > 0.0F) {
          f = m.this.hxE;
        }
        m.this.hyK = new n(this.hyX, m.this.hxA, f, m.this.hxJ, i, m.this.hxV.audioSampleRate, false, true, false);
        l = bu.HQ();
        boolean bool = m.this.hyK.dqi();
        ae.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bu.aO(l)), Boolean.valueOf(bool) });
        if (!bool)
        {
          ae.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.hyX);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89513);
              if (m.this.hxZ != null) {
                m.this.hxZ.aVS();
              }
              AppMethodBeat.o(89513);
            }
          });
          ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 30L, 1L, false);
          AppMethodBeat.o(89517);
          return;
        }
        if (((m.this.hwM) && (m.this.hyP)) || ((!m.this.hyP) && (!m.this.hwM)) || ((m.this.hwM) && (Math.abs(m.this.hxN - m.this.hxY) == 0)) || (m.this.hxY == 180))
        {
          l = bu.HQ();
          if ((m.this.hyP) || (m.this.hwM)) {
            break label895;
          }
          i = m.this.hxN;
        }
      }
      for (;;)
      {
        j = i;
        if (m.this.hxY == 180)
        {
          j = i;
          if (!m.this.hyP)
          {
            i += 180;
            j = i;
            if (i > 360) {
              j = i - 360;
            }
          }
        }
        String str;
        if (j > 0)
        {
          SightVideoJNI.tagRotateVideoVFS(m.this.hxA, m.this.hxP, j);
          ae.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(m.this.hxN), Boolean.valueOf(m.this.hwM), Integer.valueOf(m.this.hxY), Integer.valueOf(j) });
          str = m.this.hxP;
        }
        try
        {
          o.mF(m.this.hxP, m.this.hxA);
          com.tencent.mm.sdk.g.b.c(new m.a.3(this, str), "BigSightFFMpegRecorder_tagRotate_after_process");
          ae.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
          SightVideoJNI.releaseBigSightDataBufferLock(this.hyX);
          ae.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[] { this.callback });
          m.this.reset();
          ar.f(this.callback);
          this.hzc = true;
          m.this.hyO = -1;
          m.this.hyN = -1;
          AppMethodBeat.o(89517);
          return;
        }
        catch (Exception localException2)
        {
          label895:
          ae.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.hyX);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89514);
              if (m.this.hxZ != null) {
                m.this.hxZ.aVS();
              }
              AppMethodBeat.o(89514);
            }
          });
          AppMethodBeat.o(89517);
          return;
        }
        if (m.this.hyP) {
          i = m.this.hxY;
        } else {
          i = 180;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.m
 * JD-Core Version:    0.7.0.1
 */