package com.tencent.mm.audio.b;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.h;
import com.tencent.mm.compatible.b.h.a;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.or.b;
import com.tencent.mm.g.a.os;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;

public final class c
{
  public int dgL;
  int dgM;
  int dgN;
  int dgO;
  public int dgP;
  private int dgQ;
  public int dgR;
  private boolean dgS;
  boolean dgT;
  private int dgU;
  int dgV;
  public int dgW;
  private boolean dgX;
  long dgY;
  int dgZ;
  boolean dha;
  int dhb;
  private boolean dhc;
  int dhd;
  boolean dhe;
  boolean dhf;
  private AudioRecord dhg;
  public a dhh;
  private f dhi;
  private h dhj;
  com.tencent.mm.audio.e.b dhk;
  private int dhl;
  public int dhm;
  private int dhn;
  public String dho;
  private f.a dhp;
  private int mSampleRate;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129980);
    this.dgL = 0;
    this.dgM = 0;
    this.dgN = 0;
    this.dgO = 0;
    this.dgP = 1;
    this.dgQ = 1;
    this.mSampleRate = 8000;
    this.dgR = 120;
    this.dgS = false;
    this.dgT = false;
    this.dgU = 10;
    this.dgV = -1;
    this.dgW = -123456789;
    this.dgX = false;
    this.dgY = -1L;
    this.dha = false;
    this.dhc = false;
    this.dhd = 0;
    this.dhe = false;
    this.dhf = false;
    this.dhl = 16;
    this.dhm = 1;
    this.dhn = 0;
    this.dhp = new f.a()
    {
      public final void d(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(129979);
        c.this.dhd += 1;
        if ((c.this.dhf) && (System.currentTimeMillis() - c.this.dgY <= 1000L) && (c.this.dhd - 10 > (System.currentTimeMillis() - c.this.dgY) / c.this.dgR))
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 4L, 1L, false);
          ad.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[] { Integer.valueOf(c.this.dhd), Long.valueOf((System.currentTimeMillis() - c.this.dgY) / c.this.dgR) });
          c.this.dhe = true;
        }
        ad.i("MicroMsg.MMPcmRecorder", "params has been set mChkDataCnt is %s ,mStartMillSec is %s,mAudioFrameCnt is %s,mDurationPreFrame is %s", new Object[] { Boolean.valueOf(c.this.dhf), Long.valueOf(c.this.dgY), Integer.valueOf(c.this.dhd), Integer.valueOf(c.this.dgR) });
        ad.i("MicroMsg.MMPcmRecorder", "value has been return %s, and buf length is %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousArrayOfByte.length) });
        if (c.this.dhk != null) {
          c.this.dhk.y(paramAnonymousArrayOfByte, paramAnonymousInt);
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
          if ((!localc.dha) || (-2 != localc.dgN))
          {
            m = paramAnonymousInt / localc.dgZ;
            i = 5;
            if (i <= localc.dhb + m)
            {
              k = (i - localc.dhb - 1) * localc.dgZ;
              n = localc.dgZ + k;
              if (k >= 0)
              {
                j = k;
                if (n <= paramAnonymousInt) {
                  break label797;
                }
              }
              ad.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
            }
            localc.dhb = ((localc.dhb + m) % 5);
            if (localc.dgN == 20)
            {
              localc.dgL = 6;
              ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
              if ((localc.dgM != -1) || (localc.dgO != -1)) {
                break label842;
              }
              localc.dgL = 11;
              ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              label471:
              if (com.tencent.mm.plugin.audio.c.a.bGC().audioManager.isMicrophoneMute()) {
                com.tencent.mm.audio.c.b.a.hW(localc.dgV);
              }
              if ((com.tencent.mm.plugin.audio.c.a.bGC().isBluetoothScoOn()) || (com.tencent.mm.plugin.audio.c.a.bGC().bGx())) {
                com.tencent.mm.audio.c.b.a.hX(localc.dgV);
              }
              ad.e("MicroMsg.MMPcmRecorder", "record is mute %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bGC().audioManager.isMicrophoneMute()) });
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 5L, 1L, false);
              localc.dgN = -2;
              localc.PR();
            }
          }
        }
        if (c.this.dgT)
        {
          if (paramAnonymousInt > 0)
          {
            localc = c.this;
            if (localc.dgM != -1)
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
                localc.dgM += 1;
              }
              if (localc.dgM > 100)
              {
                localc.dgL = 7;
                ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                if ((localc.dgN != -2) || (localc.dgO != -1)) {
                  break label905;
                }
                localc.dgL = 11;
                ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 6L, 1L, false);
              localc.PR();
              localc.dgM = -1;
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
              localc.dgN = -1;
              localc.dha = true;
              localc.dgN += 1;
              i += 5;
              break;
              label842:
              if (localc.dgM == -1)
              {
                localc.dgL = 8;
                ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                break label471;
              }
              if (localc.dgO != -1) {
                break label471;
              }
              localc.dgL = 9;
              ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
              break label471;
              label894:
              i += 1;
              j = k;
              break label615;
              label905:
              if (localc.dgN == -2)
              {
                localc.dgL = 8;
                ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
              }
              else if (localc.dgO == -1)
              {
                localc.dgL = 10;
                ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
              }
            }
          }
          paramAnonymousArrayOfByte = c.this;
          if ((paramAnonymousArrayOfByte.dgO != -1) && (paramAnonymousInt < 0))
          {
            paramAnonymousArrayOfByte.dgO += 1;
            if (paramAnonymousArrayOfByte.dgO >= 50)
            {
              paramAnonymousArrayOfByte.dgL = 5;
              ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
              if ((paramAnonymousArrayOfByte.dgN != -2) || (paramAnonymousArrayOfByte.dgM != -1)) {
                break label1077;
              }
              paramAnonymousArrayOfByte.dgL = 11;
              ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 7L, 1L, false);
          paramAnonymousArrayOfByte.PR();
          paramAnonymousArrayOfByte.dgO = -1;
          AppMethodBeat.o(129979);
          return;
          label1077:
          if (paramAnonymousArrayOfByte.dgN == -2)
          {
            paramAnonymousArrayOfByte.dgL = 9;
            ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
          }
          else if (paramAnonymousArrayOfByte.dgM == -1)
          {
            paramAnonymousArrayOfByte.dgL = 10;
            ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
          }
        }
      }
    };
    this.dgQ = paramInt2;
    this.mSampleRate = paramInt1;
    this.dgV = paramInt3;
    if (this.dgQ == 2)
    {
      this.dhl = 12;
      if ((this.dgV == 0) && (ae.gcP.fZe > 0)) {
        this.dgR = ae.gcP.fZe;
      }
      if (ae.gcP.fZp > 0) {
        this.dhl = ae.gcP.fZp;
      }
      if (ae.gcP.fYZ > 0) {
        this.dgU = ae.gcP.fYZ;
      }
      if (ae.gcF.fWM) {
        this.dhk = new com.tencent.mm.audio.e.b(g.dhM, this.dgQ, this.mSampleRate);
      }
      if (1 != g.z("EnableRecorderCheckUnreasonableData", 1)) {
        break label363;
      }
    }
    label363:
    for (boolean bool = true;; bool = false)
    {
      this.dhf = bool;
      ad.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[] { Integer.valueOf(this.mSampleRate), Integer.valueOf(this.dgQ), Integer.valueOf(this.dgR), Boolean.valueOf(this.dgS), Integer.valueOf(this.dgV) });
      AppMethodBeat.o(129980);
      return;
      this.dhl = 16;
      break;
    }
  }
  
  private boolean PQ()
  {
    AppMethodBeat.i(129990);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    ad.i("MicroMsg.MMPcmRecorder", "startRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
    if (this.dhg != null)
    {
      com.tencent.mm.audio.c.b.a.ia(this.dgV);
      ad.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
      AppMethodBeat.o(129990);
      return false;
    }
    locala.gdx = SystemClock.elapsedRealtime();
    ad.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
    if (!init())
    {
      ad.e("MicroMsg.MMPcmRecorder", "startRecord init error");
      AppMethodBeat.o(129990);
      return false;
    }
    ad.i("MicroMsg.MMPcmRecorder", "init cost: " + locala.abj() + "ms");
    locala.gdx = SystemClock.elapsedRealtime();
    try
    {
      this.dhg.startRecording();
      ad.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + locala.abj());
      if (this.dhg.getRecordingState() != 3)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 3L, 1L, false);
        this.dhm = 2;
        this.dgL = 4;
        ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
        PR();
        com.tencent.mm.audio.c.b.a.hU(this.dgV);
        AppMethodBeat.o(129990);
        return false;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMPcmRecorder", "start error cause permission deny");
      this.dhm = 2;
      this.dgL = 4;
      ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
      PR();
      com.tencent.mm.audio.c.b.a.hU(this.dgV);
      AppMethodBeat.o(129990);
      return false;
    }
    if (this.dhi != null)
    {
      boolean bool = this.dhi.PP();
      AppMethodBeat.o(129990);
      return bool;
    }
    ad.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
    com.tencent.mm.audio.c.b.a.hT(this.dgV);
    AppMethodBeat.o(129990);
    return false;
  }
  
  private boolean init()
  {
    AppMethodBeat.i(129987);
    com.tencent.mm.plugin.audio.c.a.bGC();
    com.tencent.mm.plugin.audio.b.a.bGu();
    this.dhm = 1;
    boolean bool1;
    if (ae.gcP.fZa == 2)
    {
      bool1 = false;
      i = m.aaf();
      j = ae.gcF.fXo;
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
      m = AudioRecord.getMinBufferSize(this.mSampleRate, this.dhl, 2);
      if ((m != -2) && (m != -1)) {
        break label176;
      }
      this.dhm = 3;
      this.dgL = 1;
      ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR ".concat(String.valueOf(m)));
      PR();
      com.tencent.mm.audio.c.b.a.hZ(this.dgV);
      AppMethodBeat.o(129987);
      return false;
      bool1 = true;
      break;
      i = 1;
      break label73;
    }
    label176:
    ad.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[] { Integer.valueOf(m) });
    this.dgZ = (this.mSampleRate * 20 * this.dgQ * 2 / 1000);
    int n = this.mSampleRate * this.dgR * this.dgQ / 1000;
    int i1 = n * 2;
    ad.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mSampleRate), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.dgU), Boolean.valueOf(bool1) });
    int i2 = this.dgV;
    int j = this.dgP;
    if ((1 == i2) || (6 == i2) || (7 == i2)) {
      if (Build.VERSION.SDK_INT < 11)
      {
        i = 1;
        if (ae.gcF.fWh) {
          i = 1;
        }
        if (ae.gcF.fWG >= 0) {
          i = ae.gcF.fWG;
        }
        j = i;
        if (6 != i2) {
          break label1378;
        }
        j = i;
        if (ae.gcF.fXy < 0) {
          break label1378;
        }
      }
    }
    label792:
    label860:
    label1378:
    for (int i = ae.gcF.fXy;; i = j)
    {
      for (;;)
      {
        ad.i("MicroMsg.MMPcmRecorder", "init audio source: %s", new Object[] { Integer.valueOf(i) });
        try
        {
          this.dhg = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.dhl, this.dgU * m);
          if (this.dhg.getState() == 0)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 2L, 1L, false);
            this.dhg.release();
            this.dgL = 2;
            ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
            if (7 == i)
            {
              i = 1;
              this.dhg = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.dhl, this.dgU * m);
            }
          }
          else
          {
            if (this.dhg.getState() != 0) {
              break label792;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 2L, 1L, false);
            this.dhg.release();
            this.dhg = null;
            this.dhm = 2;
            this.dgL = 3;
            ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
            PR();
            com.tencent.mm.audio.c.b.a.hV(this.dgV);
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
            this.dgL = 12;
            ad.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            ad.printErrStackTrace("MicroMsg.MMPcmRecorder", localException1, "", new Object[0]);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 1L, 1L, false);
            com.tencent.mm.audio.c.b.a.ck(this.dgV, i);
            if (7 == i) {}
            for (i = 1;; i = 7) {
              try
              {
                this.dhg = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.dhl, this.dgU * m);
                com.tencent.mm.audio.c.b.a.cm(this.dgV, i);
              }
              catch (Exception localException2)
              {
                com.tencent.mm.audio.c.b.a.ck(this.dgV, i);
                com.tencent.mm.audio.c.b.a.cl(this.dgV, i);
                com.tencent.mm.audio.c.b.a.hV(this.dgV);
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
        localObject1 = this.dhg;
        boolean bool2 = this.dgS;
        localObject2 = this.dhh;
        if (((this.dgV == 1) || (this.dgV == 6)) && (k != 0))
        {
          bool1 = true;
          this.dhi = new e((AudioRecord)localObject1, bool2, i1, (a)localObject2, bool1);
          this.dhi.a(this.dhp);
          if (-123456789 != this.dgW) {
            this.dhi.hP(this.dgW);
          }
          if (this.dgX)
          {
            this.dhj = new h();
            localObject1 = this.dhj;
            localObject2 = this.dhg;
            i = this.dgV;
            ad.d("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
            if (!com.tencent.mm.compatible.util.d.lz(16))
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
        this.dhi = new d(this.dhg, this.dhh, this.dgS, n, i1);
        break label860;
        label1017:
        if (1 == i)
        {
          if (ae.gcP.fZG != 1)
          {
            ad.d("MicroMsg.MMAudioPreProcess", "disable by config");
          }
          else
          {
            if (ae.gcP.fZH != 2)
            {
              ((h)localObject1).fVX = new j((AudioRecord)localObject2);
              if ((((h)localObject1).fVX != null) && (((h)localObject1).fVX.isAvailable())) {
                ((h)localObject1).fVX.ZI();
              }
            }
            if (ae.gcP.fZI != 2)
            {
              ((h)localObject1).fVY = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
              if ((((h)localObject1).fVY != null) && (((h)localObject1).fVY.isAvailable())) {
                ((h)localObject1).fVY.ZI();
              }
            }
            if (ae.gcP.fZJ != 2)
            {
              ((h)localObject1).fVZ = new i((AudioRecord)localObject2);
              if ((((h)localObject1).fVZ != null) && (((h)localObject1).fVZ.isAvailable())) {
                ((h)localObject1).fVZ.ZI();
              }
            }
          }
        }
        else if (ae.gcP.fZd != 1)
        {
          ad.d("MicroMsg.MMAudioPreProcess", "disable by config");
        }
        else
        {
          ((h)localObject1).fVX = new j((AudioRecord)localObject2);
          if ((((h)localObject1).fVX != null) && (((h)localObject1).fVX.isAvailable())) {
            ((h)localObject1).fVX.ZI();
          }
          ((h)localObject1).fVY = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
          if ((((h)localObject1).fVY != null) && (((h)localObject1).fVY.isAvailable())) {
            ((h)localObject1).fVY.ZI();
          }
          ((h)localObject1).fVZ = new i((AudioRecord)localObject2);
          if ((((h)localObject1).fVZ != null) && (((h)localObject1).fVZ.isAvailable())) {
            ((h)localObject1).fVZ.ZI();
          }
        }
      }
    }
  }
  
  public final boolean PG()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(129991);
        if (true == this.dhc)
        {
          ad.i("MicroMsg.MMPcmRecorder", "already have stopped");
          AppMethodBeat.o(129991);
          bool1 = true;
          return bool1;
        }
        this.dhc = true;
        Object localObject1 = new com.tencent.mm.compatible.util.f.a();
        if (this.dhk != null)
        {
          this.dhk.closeFile();
          this.dhk = null;
        }
        ((com.tencent.mm.compatible.util.f.a)localObject1).gdx = SystemClock.elapsedRealtime();
        if (this.dhi != null)
        {
          this.dhi.stopRecord();
          this.dhi = null;
        }
        ad.i("MicroMsg.MMPcmRecorder", "cost " + ((com.tencent.mm.compatible.util.f.a)localObject1).abj() + "ms to call stopRecord");
        ad.i("MicroMsg.MMPcmRecorder", "stopRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.dhg == null)
        {
          ad.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
          bool1 = false;
          if (((!this.dha) && (-1L != this.dgY) && (System.currentTimeMillis() - this.dgY >= 2000L)) || (this.dhe))
          {
            ad.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
            localObject1 = new os();
            ((os)localObject1).dCJ.type = 1;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
            bool2 = false;
          }
          localObject1 = new or();
          ((or)localObject1).dCE.type = 1;
          ((or)localObject1).dCE.dCG = false;
          ((or)localObject1).dCE.dCH = bool2;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
          ad.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[] { Integer.valueOf(this.dgL) });
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(new IDKey(357, 0, 1));
          if (this.dgL != 0) {
            ((ArrayList)localObject1).add(new IDKey(357, 1, 1));
          }
        }
        switch (this.dgL)
        {
        case 1: 
          ad.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
          com.tencent.mm.plugin.report.service.g.yhR.b((ArrayList)localObject1, false);
          AppMethodBeat.o(129991);
          continue;
          if (this.dhg.getState() == 1) {
            break label516;
          }
        }
      }
      finally {}
      ad.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.dhg.getState());
      boolean bool1 = false;
      continue;
      label516:
      if (this.dho != null)
      {
        if (this.dgV != 0) {
          break label630;
        }
        com.tencent.mm.audio.c.b.a.a(0, this.dho, this.dgP, this.mSampleRate, this.dhl, this.dgL);
        com.tencent.mm.audio.c.b.a.id(this.dgV);
        com.tencent.mm.audio.c.b.a.ic(this.dgV);
      }
      for (;;)
      {
        localObject2.gdx = SystemClock.elapsedRealtime();
        this.dhg.stop();
        this.dhg.release();
        this.dhg = null;
        ad.i("MicroMsg.MMPcmRecorder", "cost " + localObject2.abj() + "ms to call stop and release");
        bool1 = true;
        break;
        label630:
        if (this.dgV == 1)
        {
          com.tencent.mm.audio.c.b.a.a(1, this.dho, this.dgP, this.mSampleRate, this.dhl, this.dgL);
          com.tencent.mm.audio.c.b.a.id(this.dgV);
          com.tencent.mm.audio.c.b.a.ic(this.dgV);
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
  
  public final void PN()
  {
    AppMethodBeat.i(129983);
    this.dgT = true;
    ad.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.dgT);
    AppMethodBeat.o(129983);
  }
  
  public final int PO()
  {
    AppMethodBeat.i(129985);
    if (this.dhn > 0)
    {
      i = this.dhn;
      AppMethodBeat.o(129985);
      return i;
    }
    int i = AudioRecord.getMinBufferSize(this.mSampleRate, this.dhl, 2);
    ad.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", new Object[] { Integer.valueOf(i) });
    if ((i == -2) || (i == -1))
    {
      AppMethodBeat.o(129985);
      return 0;
    }
    this.dhn = (this.dgU * i);
    i = this.dhn;
    AppMethodBeat.o(129985);
    return i;
  }
  
  public final boolean PP()
  {
    AppMethodBeat.i(129989);
    ad.i("MicroMsg.MMPcmRecorder", "startRecord");
    Object localObject = new or();
    ((or)localObject).dCE.type = 1;
    ((or)localObject).dCE.dCG = true;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    this.dgY = System.currentTimeMillis();
    this.dha = false;
    if (((or)localObject).dCF.dCI)
    {
      ad.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
      this.dgL = 13;
      AppMethodBeat.o(129989);
      return false;
    }
    localObject = (AudioManager)aj.getContext().getSystemService("audio");
    if ((localObject != null) && (((AudioManager)localObject).isMicrophoneMute()))
    {
      ad.e("MicroMsg.MMPcmRecorder", "microphone is mute");
      this.dgL = 14;
      localObject = new lv();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(151L, 8L, 1L, false);
      com.tencent.mm.audio.c.b.a.ib(this.dgV);
      AppMethodBeat.o(129989);
      return false;
    }
    this.dhc = false;
    boolean bool = PQ();
    if (!bool)
    {
      PG();
      localObject = new os();
      ((os)localObject).dCJ.type = 1;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(129989);
      return bool;
      com.tencent.mm.audio.c.b.a.cj(this.dgV, this.dhg.getAudioSource());
    }
  }
  
  final void PR()
  {
    AppMethodBeat.i(129992);
    if (this.dhh != null) {
      this.dhh.ch(this.dhm, this.dgL);
    }
    AppMethodBeat.o(129992);
  }
  
  public final int PS()
  {
    AppMethodBeat.i(129993);
    if (this.dhi != null)
    {
      int i = this.dhi.PS();
      AppMethodBeat.o(129993);
      return i;
    }
    AppMethodBeat.o(129993);
    return -1;
  }
  
  public final void a(a parama)
  {
    this.dhh = parama;
  }
  
  public final void cu(boolean paramBoolean)
  {
    AppMethodBeat.i(129982);
    this.dgS = paramBoolean;
    ad.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.dgS);
    AppMethodBeat.o(129982);
  }
  
  public final void cv(boolean paramBoolean)
  {
    AppMethodBeat.i(129986);
    this.dgX = paramBoolean;
    ad.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.dgX);
    AppMethodBeat.o(129986);
  }
  
  public final void cw(boolean paramBoolean)
  {
    AppMethodBeat.i(129988);
    ad.i("MicroMsg.MMPcmRecorder", "switchMute mute:".concat(String.valueOf(paramBoolean)));
    if (this.dhi != null) {
      this.dhi.cw(paramBoolean);
    }
    AppMethodBeat.o(129988);
  }
  
  public final void hO(int paramInt)
  {
    AppMethodBeat.i(129981);
    this.dgR = paramInt;
    ad.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.dgR);
    AppMethodBeat.o(129981);
  }
  
  public final void setAudioSource(int paramInt)
  {
    AppMethodBeat.i(197037);
    this.dgP = paramInt;
    ad.i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(197037);
  }
  
  public final void t(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129984);
    if ((10 == this.dgU) || (paramBoolean))
    {
      this.dgU = paramInt;
      ad.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.dgU);
    }
    AppMethodBeat.o(129984);
  }
  
  public static abstract interface a
  {
    public abstract void ch(int paramInt1, int paramInt2);
    
    public abstract void u(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.b.c
 * JD-Core Version:    0.7.0.1
 */