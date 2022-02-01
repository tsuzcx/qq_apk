package com.tencent.mm.audio.b;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.h.a;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.a.nz.b;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;

public final class c
{
  public int cXZ;
  public int cYA;
  private int cYB;
  public String cYC;
  private f.a cYD;
  int cYa;
  int cYb;
  int cYc;
  public int cYd;
  private int cYe;
  public int cYf;
  private boolean cYg;
  boolean cYh;
  private int cYi;
  int cYj;
  public int cYk;
  private boolean cYl;
  long cYm;
  int cYn;
  boolean cYo;
  int cYp;
  private boolean cYq;
  int cYr;
  boolean cYs;
  boolean cYt;
  private AudioRecord cYu;
  public a cYv;
  private f cYw;
  private com.tencent.mm.compatible.b.h cYx;
  com.tencent.mm.audio.e.b cYy;
  private int cYz;
  private int mSampleRate;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129980);
    this.cXZ = 0;
    this.cYa = 0;
    this.cYb = 0;
    this.cYc = 0;
    this.cYd = 1;
    this.cYe = 1;
    this.mSampleRate = 8000;
    this.cYf = 120;
    this.cYg = false;
    this.cYh = false;
    this.cYi = 10;
    this.cYj = -1;
    this.cYk = -123456789;
    this.cYl = false;
    this.cYm = -1L;
    this.cYo = false;
    this.cYq = false;
    this.cYr = 0;
    this.cYs = false;
    this.cYt = false;
    this.cYz = 16;
    this.cYA = 1;
    this.cYB = 0;
    this.cYD = new f.a()
    {
      public final void d(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(129979);
        c.this.cYr += 1;
        if ((c.this.cYt) && (System.currentTimeMillis() - c.this.cYm <= 1000L) && (c.this.cYr - 10 > (System.currentTimeMillis() - c.this.cYm) / c.this.cYf))
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 4L, 1L, false);
          ad.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[] { Integer.valueOf(c.this.cYr), Long.valueOf((System.currentTimeMillis() - c.this.cYm) / c.this.cYf) });
          c.this.cYs = true;
        }
        ad.i("MicroMsg.MMPcmRecorder", "params has been set mChkDataCnt is %s ,mStartMillSec is %s,mAudioFrameCnt is %s,mDurationPreFrame is %s", new Object[] { Boolean.valueOf(c.this.cYt), Long.valueOf(c.this.cYm), Integer.valueOf(c.this.cYr), Integer.valueOf(c.this.cYf) });
        ad.i("MicroMsg.MMPcmRecorder", "value has been return %s, and buf length is %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousArrayOfByte.length) });
        if (c.this.cYy != null) {
          c.this.cYy.A(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        c localc;
        int m;
        int i;
        int k;
        int n;
        int j;
        if (paramAnonymousInt > 0)
        {
          localc = c.this;
          if ((!localc.cYo) || (-2 != localc.cYb))
          {
            m = paramAnonymousInt / localc.cYn;
            i = 5;
            if (i <= localc.cYp + m)
            {
              k = (i - localc.cYp - 1) * localc.cYn;
              n = localc.cYn + k;
              if (k >= 0)
              {
                j = k;
                if (n <= paramAnonymousInt) {
                  break label797;
                }
              }
              ad.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
            }
            localc.cYp = ((localc.cYp + m) % 5);
            if (localc.cYb == 20)
            {
              localc.cXZ = 6;
              ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
              if ((localc.cYa != -1) || (localc.cYc != -1)) {
                break label842;
              }
              localc.cXZ = 11;
              ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              label471:
              if (com.tencent.mm.plugin.audio.c.a.bvB().audioManager.isMicrophoneMute()) {
                com.tencent.mm.audio.c.b.a.jdMethod_if(localc.cYj);
              }
              if ((com.tencent.mm.plugin.audio.c.a.bvB().isBluetoothScoOn()) || (com.tencent.mm.plugin.audio.c.a.bvB().bvw())) {
                com.tencent.mm.audio.c.b.a.ig(localc.cYj);
              }
              ad.e("MicroMsg.MMPcmRecorder", "record is mute %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bvB().audioManager.isMicrophoneMute()) });
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 5L, 1L, false);
              localc.cYb = -2;
              localc.Om();
            }
          }
        }
        if (c.this.cYh)
        {
          if (paramAnonymousInt > 0)
          {
            localc = c.this;
            if (localc.cYa != -1)
            {
              j = 0;
              i = 0;
              label615:
              if (i < paramAnonymousInt / 2)
              {
                m = (short)(paramAnonymousArrayOfByte[(i * 2 + 1)] << 8 | paramAnonymousArrayOfByte[(i * 2 + 0)] & 0xFF);
                if (m < 32760)
                {
                  k = j;
                  if (m != -32768) {}
                }
                else
                {
                  k = j + 1;
                }
                if (k < 5) {
                  break label894;
                }
                localc.cYa += 1;
              }
              if (localc.cYa > 100)
              {
                localc.cXZ = 7;
                ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                if ((localc.cYb != -2) || (localc.cYc != -1)) {
                  break label905;
                }
                localc.cXZ = 11;
                ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 6L, 1L, false);
              localc.Om();
              localc.cYa = -1;
              AppMethodBeat.o(129979);
              return;
              label797:
              do
              {
                j += 1;
                if (j >= n) {
                  break;
                }
              } while (paramAnonymousArrayOfByte[j] == 0);
              localc.cYb = -1;
              localc.cYo = true;
              localc.cYb += 1;
              i += 5;
              break;
              label842:
              if (localc.cYa == -1)
              {
                localc.cXZ = 8;
                ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                break label471;
              }
              if (localc.cYc != -1) {
                break label471;
              }
              localc.cXZ = 9;
              ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
              break label471;
              label894:
              i += 1;
              j = k;
              break label615;
              label905:
              if (localc.cYb == -2)
              {
                localc.cXZ = 8;
                ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
              }
              else if (localc.cYc == -1)
              {
                localc.cXZ = 10;
                ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
              }
            }
          }
          paramAnonymousArrayOfByte = c.this;
          if ((paramAnonymousArrayOfByte.cYc != -1) && (paramAnonymousInt < 0))
          {
            paramAnonymousArrayOfByte.cYc += 1;
            if (paramAnonymousArrayOfByte.cYc >= 50)
            {
              paramAnonymousArrayOfByte.cXZ = 5;
              ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
              if ((paramAnonymousArrayOfByte.cYb != -2) || (paramAnonymousArrayOfByte.cYa != -1)) {
                break label1077;
              }
              paramAnonymousArrayOfByte.cXZ = 11;
              ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 7L, 1L, false);
          paramAnonymousArrayOfByte.Om();
          paramAnonymousArrayOfByte.cYc = -1;
          AppMethodBeat.o(129979);
          return;
          label1077:
          if (paramAnonymousArrayOfByte.cYb == -2)
          {
            paramAnonymousArrayOfByte.cXZ = 9;
            ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
          }
          else if (paramAnonymousArrayOfByte.cYa == -1)
          {
            paramAnonymousArrayOfByte.cXZ = 10;
            ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
          }
        }
      }
    };
    this.cYe = paramInt2;
    this.mSampleRate = paramInt1;
    this.cYj = paramInt3;
    if (this.cYe == 2)
    {
      this.cYz = 12;
      if ((this.cYj == 0) && (ae.fFH.fBY > 0)) {
        this.cYf = ae.fFH.fBY;
      }
      if (ae.fFH.fCj > 0) {
        this.cYz = ae.fFH.fCj;
      }
      if (ae.fFH.fBT > 0) {
        this.cYi = ae.fFH.fBT;
      }
      if (ae.fFx.fzR) {
        this.cYy = new com.tencent.mm.audio.e.b(g.cZa, this.cYe, this.mSampleRate);
      }
      if (1 != g.x("EnableRecorderCheckUnreasonableData", 1)) {
        break label363;
      }
    }
    label363:
    for (boolean bool = true;; bool = false)
    {
      this.cYt = bool;
      ad.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[] { Integer.valueOf(this.mSampleRate), Integer.valueOf(this.cYe), Integer.valueOf(this.cYf), Boolean.valueOf(this.cYg), Integer.valueOf(this.cYj) });
      AppMethodBeat.o(129980);
      return;
      this.cYz = 16;
      break;
    }
  }
  
  private boolean Ol()
  {
    AppMethodBeat.i(129990);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    ad.i("MicroMsg.MMPcmRecorder", "startRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
    if (this.cYu != null)
    {
      com.tencent.mm.audio.c.b.a.ij(this.cYj);
      ad.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
      AppMethodBeat.o(129990);
      return false;
    }
    locala.fGp = SystemClock.elapsedRealtime();
    ad.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
    if (!init())
    {
      ad.e("MicroMsg.MMPcmRecorder", "startRecord init error");
      AppMethodBeat.o(129990);
      return false;
    }
    ad.i("MicroMsg.MMPcmRecorder", "init cost: " + locala.XK() + "ms");
    locala.fGp = SystemClock.elapsedRealtime();
    try
    {
      this.cYu.startRecording();
      ad.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + locala.XK());
      if (this.cYu.getRecordingState() != 3)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 3L, 1L, false);
        this.cYA = 2;
        this.cXZ = 4;
        ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
        Om();
        com.tencent.mm.audio.c.b.a.id(this.cYj);
        AppMethodBeat.o(129990);
        return false;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMPcmRecorder", "start error cause permission deny");
      this.cYA = 2;
      this.cXZ = 4;
      ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
      Om();
      com.tencent.mm.audio.c.b.a.id(this.cYj);
      AppMethodBeat.o(129990);
      return false;
    }
    if (this.cYw != null)
    {
      boolean bool = this.cYw.Ok();
      AppMethodBeat.o(129990);
      return bool;
    }
    ad.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
    com.tencent.mm.audio.c.b.a.ic(this.cYj);
    AppMethodBeat.o(129990);
    return false;
  }
  
  private boolean init()
  {
    AppMethodBeat.i(129987);
    com.tencent.mm.plugin.audio.c.a.bvB();
    com.tencent.mm.plugin.audio.b.a.bvt();
    this.cYA = 1;
    boolean bool1;
    if (ae.fFH.fBU == 2)
    {
      bool1 = false;
      i = m.WG();
      j = ae.fFx.fAi;
      if ((i & 0x400) == 0) {
        break label166;
      }
      i = j;
      if (j <= 0) {
        i = 0;
      }
      ad.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: ".concat(String.valueOf(i)));
      label73:
      if (i != 1) {
        break label171;
      }
    }
    int m;
    label166:
    label171:
    for (int k = 1;; k = 0)
    {
      ad.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
      m = AudioRecord.getMinBufferSize(this.mSampleRate, this.cYz, 2);
      if ((m != -2) && (m != -1)) {
        break label176;
      }
      this.cYA = 3;
      this.cXZ = 1;
      ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR ".concat(String.valueOf(m)));
      Om();
      com.tencent.mm.audio.c.b.a.ii(this.cYj);
      AppMethodBeat.o(129987);
      return false;
      bool1 = true;
      break;
      i = 1;
      break label73;
    }
    label176:
    ad.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[] { Integer.valueOf(m) });
    this.cYn = (this.mSampleRate * 20 * this.cYe * 2 / 1000);
    int n = this.mSampleRate * this.cYf * this.cYe / 1000;
    int i1 = n * 2;
    ad.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mSampleRate), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.cYi), Boolean.valueOf(bool1) });
    int i2 = this.cYj;
    int j = this.cYd;
    if ((1 == i2) || (6 == i2) || (7 == i2)) {
      if (Build.VERSION.SDK_INT < 11)
      {
        i = 1;
        if (ae.fFx.fzm) {
          i = 1;
        }
        if (ae.fFx.fzL >= 0) {
          i = ae.fFx.fzL;
        }
        j = i;
        if (6 != i2) {
          break label1378;
        }
        j = i;
        if (ae.fFx.fAs < 0) {
          break label1378;
        }
      }
    }
    label792:
    label860:
    label1378:
    for (int i = ae.fFx.fAs;; i = j)
    {
      for (;;)
      {
        ad.i("MicroMsg.MMPcmRecorder", "init audio source: %s", new Object[] { Integer.valueOf(i) });
        try
        {
          this.cYu = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.cYz, this.cYi * m);
          if (this.cYu.getState() == 0)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 2L, 1L, false);
            this.cYu.release();
            this.cXZ = 2;
            ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
            if (7 == i)
            {
              i = 1;
              this.cYu = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.cYz, this.cYi * m);
            }
          }
          else
          {
            if (this.cYu.getState() != 0) {
              break label792;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 2L, 1L, false);
            this.cYu.release();
            this.cYu = null;
            this.cYA = 2;
            this.cXZ = 3;
            ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
            Om();
            com.tencent.mm.audio.c.b.a.ie(this.cYj);
            AppMethodBeat.o(129987);
            return false;
            i = 7;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ad.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.cXZ = 12;
            ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            ad.printErrStackTrace("MicroMsg.MMPcmRecorder", localException1, "", new Object[0]);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 1L, 1L, false);
            com.tencent.mm.audio.c.b.a.ck(this.cYj, i);
            if (7 == i) {}
            for (i = 1;; i = 7) {
              try
              {
                this.cYu = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.cYz, this.cYi * m);
                com.tencent.mm.audio.c.b.a.cm(this.cYj, i);
              }
              catch (Exception localException2)
              {
                com.tencent.mm.audio.c.b.a.ck(this.cYj, i);
                com.tencent.mm.audio.c.b.a.cl(this.cYj, i);
                com.tencent.mm.audio.c.b.a.ie(this.cYj);
                AppMethodBeat.o(129987);
                return false;
              }
            }
            i = 0;
          }
        }
      }
      Object localObject1;
      Object localObject2;
      if (bool1)
      {
        localObject1 = this.cYu;
        boolean bool2 = this.cYg;
        localObject2 = this.cYv;
        if (((this.cYj == 1) || (this.cYj == 6)) && (k != 0))
        {
          bool1 = true;
          this.cYw = new e((AudioRecord)localObject1, bool2, i1, (a)localObject2, bool1);
          this.cYw.a(this.cYD);
          if (-123456789 != this.cYk) {
            this.cYw.hY(this.cYk);
          }
          if (this.cYl)
          {
            this.cYx = new com.tencent.mm.compatible.b.h();
            localObject1 = this.cYx;
            localObject2 = this.cYu;
            i = this.cYj;
            ad.d("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
            if (!com.tencent.mm.compatible.util.d.lg(16))
            {
              if (localObject2 != null) {
                break label1017;
              }
              ad.d("MicroMsg.MMAudioPreProcess", "audio is null");
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(129987);
        return true;
        bool1 = false;
        break;
        this.cYw = new d(this.cYu, this.cYv, this.cYg, n, i1);
        break label860;
        label1017:
        if (1 == i)
        {
          if (ae.fFH.fCA != 1)
          {
            ad.d("MicroMsg.MMAudioPreProcess", "disable by config");
          }
          else
          {
            if (ae.fFH.fCB != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).fzc = new j((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).fzc != null) && (((com.tencent.mm.compatible.b.h)localObject1).fzc.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).fzc.Wj();
              }
            }
            if (ae.fFH.fCC != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).fzd = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).fzd != null) && (((com.tencent.mm.compatible.b.h)localObject1).fzd.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).fzd.Wj();
              }
            }
            if (ae.fFH.fCD != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).fze = new i((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).fze != null) && (((com.tencent.mm.compatible.b.h)localObject1).fze.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).fze.Wj();
              }
            }
          }
        }
        else if (ae.fFH.fBX != 1)
        {
          ad.d("MicroMsg.MMAudioPreProcess", "disable by config");
        }
        else
        {
          ((com.tencent.mm.compatible.b.h)localObject1).fzc = new j((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).fzc != null) && (((com.tencent.mm.compatible.b.h)localObject1).fzc.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).fzc.Wj();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).fzd = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).fzd != null) && (((com.tencent.mm.compatible.b.h)localObject1).fzd.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).fzd.Wj();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).fze = new i((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).fze != null) && (((com.tencent.mm.compatible.b.h)localObject1).fze.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).fze.Wj();
          }
        }
      }
    }
  }
  
  public final boolean Ob()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(129991);
        if (true == this.cYq)
        {
          ad.i("MicroMsg.MMPcmRecorder", "already have stopped");
          AppMethodBeat.o(129991);
          bool1 = true;
          return bool1;
        }
        this.cYq = true;
        Object localObject1 = new com.tencent.mm.compatible.util.f.a();
        if (this.cYy != null)
        {
          this.cYy.closeFile();
          this.cYy = null;
        }
        ((com.tencent.mm.compatible.util.f.a)localObject1).fGp = SystemClock.elapsedRealtime();
        if (this.cYw != null)
        {
          this.cYw.stopRecord();
          this.cYw = null;
        }
        ad.i("MicroMsg.MMPcmRecorder", "cost " + ((com.tencent.mm.compatible.util.f.a)localObject1).XK() + "ms to call stopRecord");
        ad.i("MicroMsg.MMPcmRecorder", "stopRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.cYu == null)
        {
          ad.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
          bool1 = false;
          if (((!this.cYo) && (-1L != this.cYm) && (System.currentTimeMillis() - this.cYm >= 2000L)) || (this.cYs))
          {
            ad.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
            localObject1 = new oa();
            ((oa)localObject1).dti.type = 1;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
            bool2 = false;
          }
          localObject1 = new nz();
          ((nz)localObject1).dtd.type = 1;
          ((nz)localObject1).dtd.dtf = false;
          ((nz)localObject1).dtd.dtg = bool2;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
          ad.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[] { Integer.valueOf(this.cXZ) });
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(new IDKey(357, 0, 1));
          if (this.cXZ != 0) {
            ((ArrayList)localObject1).add(new IDKey(357, 1, 1));
          }
        }
        switch (this.cXZ)
        {
        case 1: 
          ad.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
          com.tencent.mm.plugin.report.service.h.vKh.b((ArrayList)localObject1, false);
          AppMethodBeat.o(129991);
          continue;
          if (this.cYu.getState() == 1) {
            break label516;
          }
        }
      }
      finally {}
      ad.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.cYu.getState());
      boolean bool1 = false;
      continue;
      label516:
      if (this.cYC != null)
      {
        if (this.cYj != 0) {
          break label630;
        }
        com.tencent.mm.audio.c.b.a.a(0, this.cYC, this.cYd, this.mSampleRate, this.cYz, this.cXZ);
        com.tencent.mm.audio.c.b.a.im(this.cYj);
        com.tencent.mm.audio.c.b.a.il(this.cYj);
      }
      for (;;)
      {
        localObject2.fGp = SystemClock.elapsedRealtime();
        this.cYu.stop();
        this.cYu.release();
        this.cYu = null;
        ad.i("MicroMsg.MMPcmRecorder", "cost " + localObject2.XK() + "ms to call stop and release");
        bool1 = true;
        break;
        label630:
        if (this.cYj == 1)
        {
          com.tencent.mm.audio.c.b.a.a(1, this.cYC, this.cYd, this.mSampleRate, this.cYz, this.cXZ);
          com.tencent.mm.audio.c.b.a.im(this.cYj);
          com.tencent.mm.audio.c.b.a.il(this.cYj);
        }
      }
      localObject2.add(new IDKey(357, 2, 1));
      continue;
      localObject2.add(new IDKey(357, 3, 1));
      continue;
      localObject2.add(new IDKey(357, 4, 1));
      continue;
      localObject2.add(new IDKey(357, 5, 1));
      continue;
      localObject2.add(new IDKey(357, 6, 1));
      continue;
      localObject2.add(new IDKey(357, 7, 1));
      continue;
      localObject2.add(new IDKey(357, 8, 1));
      continue;
      localObject2.add(new IDKey(357, 9, 1));
      continue;
      localObject2.add(new IDKey(357, 10, 1));
      continue;
      localObject2.add(new IDKey(357, 11, 1));
      continue;
      localObject2.add(new IDKey(357, 12, 1));
      continue;
      localObject2.add(new IDKey(357, 13, 1));
    }
  }
  
  public final void Oi()
  {
    AppMethodBeat.i(129983);
    this.cYh = true;
    ad.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.cYh);
    AppMethodBeat.o(129983);
  }
  
  public final int Oj()
  {
    AppMethodBeat.i(129985);
    if (this.cYB > 0)
    {
      i = this.cYB;
      AppMethodBeat.o(129985);
      return i;
    }
    int i = AudioRecord.getMinBufferSize(this.mSampleRate, this.cYz, 2);
    ad.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", new Object[] { Integer.valueOf(i) });
    if ((i == -2) || (i == -1))
    {
      AppMethodBeat.o(129985);
      return 0;
    }
    this.cYB = (this.cYi * i);
    i = this.cYB;
    AppMethodBeat.o(129985);
    return i;
  }
  
  public final boolean Ok()
  {
    AppMethodBeat.i(129989);
    ad.i("MicroMsg.MMPcmRecorder", "startRecord");
    Object localObject = new nz();
    ((nz)localObject).dtd.type = 1;
    ((nz)localObject).dtd.dtf = true;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    this.cYm = System.currentTimeMillis();
    this.cYo = false;
    if (((nz)localObject).dte.dth)
    {
      ad.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
      this.cXZ = 13;
      AppMethodBeat.o(129989);
      return false;
    }
    localObject = (AudioManager)aj.getContext().getSystemService("audio");
    if ((localObject != null) && (((AudioManager)localObject).isMicrophoneMute()))
    {
      ad.e("MicroMsg.MMPcmRecorder", "microphone is mute");
      this.cXZ = 14;
      localObject = new ld();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(151L, 8L, 1L, false);
      com.tencent.mm.audio.c.b.a.ik(this.cYj);
      AppMethodBeat.o(129989);
      return false;
    }
    this.cYq = false;
    boolean bool = Ol();
    if (!bool)
    {
      Ob();
      localObject = new oa();
      ((oa)localObject).dti.type = 1;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(129989);
      return bool;
      com.tencent.mm.audio.c.b.a.cj(this.cYj, this.cYu.getAudioSource());
    }
  }
  
  final void Om()
  {
    AppMethodBeat.i(129992);
    if (this.cYv != null) {
      this.cYv.ch(this.cYA, this.cXZ);
    }
    AppMethodBeat.o(129992);
  }
  
  public final int On()
  {
    AppMethodBeat.i(129993);
    if (this.cYw != null)
    {
      int i = this.cYw.On();
      AppMethodBeat.o(129993);
      return i;
    }
    AppMethodBeat.o(129993);
    return -1;
  }
  
  public final void a(a parama)
  {
    this.cYv = parama;
  }
  
  public final void cr(boolean paramBoolean)
  {
    AppMethodBeat.i(129982);
    this.cYg = paramBoolean;
    ad.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.cYg);
    AppMethodBeat.o(129982);
  }
  
  public final void cs(boolean paramBoolean)
  {
    AppMethodBeat.i(129986);
    this.cYl = paramBoolean;
    ad.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.cYl);
    AppMethodBeat.o(129986);
  }
  
  public final void ct(boolean paramBoolean)
  {
    AppMethodBeat.i(129988);
    ad.i("MicroMsg.MMPcmRecorder", "switchMute mute:".concat(String.valueOf(paramBoolean)));
    if (this.cYw != null) {
      this.cYw.ct(paramBoolean);
    }
    AppMethodBeat.o(129988);
  }
  
  public final void hX(int paramInt)
  {
    AppMethodBeat.i(129981);
    this.cYf = paramInt;
    ad.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.cYf);
    AppMethodBeat.o(129981);
  }
  
  public final void setAudioSource(int paramInt)
  {
    AppMethodBeat.i(189975);
    this.cYd = paramInt;
    ad.i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(189975);
  }
  
  public final void t(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129984);
    if ((10 == this.cYi) || (paramBoolean))
    {
      this.cYi = paramInt;
      ad.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.cYi);
    }
    AppMethodBeat.o(129984);
  }
  
  public static abstract interface a
  {
    public abstract void ch(int paramInt1, int paramInt2);
    
    public abstract void w(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.c
 * JD-Core Version:    0.7.0.1
 */