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
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.oi.b;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;

public final class c
{
  private int cVA;
  public int cVB;
  private boolean cVC;
  boolean cVD;
  private int cVE;
  int cVF;
  public int cVG;
  private boolean cVH;
  long cVI;
  int cVJ;
  boolean cVK;
  int cVL;
  private boolean cVM;
  int cVN;
  boolean cVO;
  boolean cVP;
  private AudioRecord cVQ;
  public c.a cVR;
  private f cVS;
  private com.tencent.mm.compatible.b.h cVT;
  com.tencent.mm.audio.e.b cVU;
  private int cVV;
  public int cVW;
  private int cVX;
  public String cVY;
  private f.a cVZ;
  public int cVv;
  int cVw;
  int cVx;
  int cVy;
  public int cVz;
  private int mSampleRate;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129980);
    this.cVv = 0;
    this.cVw = 0;
    this.cVx = 0;
    this.cVy = 0;
    this.cVz = 1;
    this.cVA = 1;
    this.mSampleRate = 8000;
    this.cVB = 120;
    this.cVC = false;
    this.cVD = false;
    this.cVE = 10;
    this.cVF = -1;
    this.cVG = -123456789;
    this.cVH = false;
    this.cVI = -1L;
    this.cVK = false;
    this.cVM = false;
    this.cVN = 0;
    this.cVO = false;
    this.cVP = false;
    this.cVV = 16;
    this.cVW = 1;
    this.cVX = 0;
    this.cVZ = new f.a()
    {
      public final void d(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(129979);
        c.this.cVN += 1;
        if ((c.this.cVP) && (System.currentTimeMillis() - c.this.cVI <= 1000L) && (c.this.cVN - 10 > (System.currentTimeMillis() - c.this.cVI) / c.this.cVB))
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 4L, 1L, false);
          ac.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[] { Integer.valueOf(c.this.cVN), Long.valueOf((System.currentTimeMillis() - c.this.cVI) / c.this.cVB) });
          c.this.cVO = true;
        }
        ac.i("MicroMsg.MMPcmRecorder", "params has been set mChkDataCnt is %s ,mStartMillSec is %s,mAudioFrameCnt is %s,mDurationPreFrame is %s", new Object[] { Boolean.valueOf(c.this.cVP), Long.valueOf(c.this.cVI), Integer.valueOf(c.this.cVN), Integer.valueOf(c.this.cVB) });
        ac.i("MicroMsg.MMPcmRecorder", "value has been return %s, and buf length is %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousArrayOfByte.length) });
        if (c.this.cVU != null) {
          c.this.cVU.y(paramAnonymousArrayOfByte, paramAnonymousInt);
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
          if ((!localc.cVK) || (-2 != localc.cVx))
          {
            m = paramAnonymousInt / localc.cVJ;
            i = 5;
            if (i <= localc.cVL + m)
            {
              k = (i - localc.cVL - 1) * localc.cVJ;
              n = localc.cVJ + k;
              if (k >= 0)
              {
                j = k;
                if (n <= paramAnonymousInt) {
                  break label797;
                }
              }
              ac.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
            }
            localc.cVL = ((localc.cVL + m) % 5);
            if (localc.cVx == 20)
            {
              localc.cVv = 6;
              ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
              if ((localc.cVw != -1) || (localc.cVy != -1)) {
                break label842;
              }
              localc.cVv = 11;
              ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              label471:
              if (com.tencent.mm.plugin.audio.c.a.bCx().audioManager.isMicrophoneMute()) {
                com.tencent.mm.audio.c.b.a.hP(localc.cVF);
              }
              if ((com.tencent.mm.plugin.audio.c.a.bCx().isBluetoothScoOn()) || (com.tencent.mm.plugin.audio.c.a.bCx().bCs())) {
                com.tencent.mm.audio.c.b.a.hQ(localc.cVF);
              }
              ac.e("MicroMsg.MMPcmRecorder", "record is mute %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bCx().audioManager.isMicrophoneMute()) });
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 5L, 1L, false);
              localc.cVx = -2;
              localc.Oi();
            }
          }
        }
        if (c.this.cVD)
        {
          if (paramAnonymousInt > 0)
          {
            localc = c.this;
            if (localc.cVw != -1)
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
                localc.cVw += 1;
              }
              if (localc.cVw > 100)
              {
                localc.cVv = 7;
                ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                if ((localc.cVx != -2) || (localc.cVy != -1)) {
                  break label905;
                }
                localc.cVv = 11;
                ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 6L, 1L, false);
              localc.Oi();
              localc.cVw = -1;
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
              localc.cVx = -1;
              localc.cVK = true;
              localc.cVx += 1;
              i += 5;
              break;
              label842:
              if (localc.cVw == -1)
              {
                localc.cVv = 8;
                ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                break label471;
              }
              if (localc.cVy != -1) {
                break label471;
              }
              localc.cVv = 9;
              ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
              break label471;
              label894:
              i += 1;
              j = k;
              break label615;
              label905:
              if (localc.cVx == -2)
              {
                localc.cVv = 8;
                ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
              }
              else if (localc.cVy == -1)
              {
                localc.cVv = 10;
                ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
              }
            }
          }
          paramAnonymousArrayOfByte = c.this;
          if ((paramAnonymousArrayOfByte.cVy != -1) && (paramAnonymousInt < 0))
          {
            paramAnonymousArrayOfByte.cVy += 1;
            if (paramAnonymousArrayOfByte.cVy >= 50)
            {
              paramAnonymousArrayOfByte.cVv = 5;
              ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
              if ((paramAnonymousArrayOfByte.cVx != -2) || (paramAnonymousArrayOfByte.cVw != -1)) {
                break label1077;
              }
              paramAnonymousArrayOfByte.cVv = 11;
              ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 7L, 1L, false);
          paramAnonymousArrayOfByte.Oi();
          paramAnonymousArrayOfByte.cVy = -1;
          AppMethodBeat.o(129979);
          return;
          label1077:
          if (paramAnonymousArrayOfByte.cVx == -2)
          {
            paramAnonymousArrayOfByte.cVv = 9;
            ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
          }
          else if (paramAnonymousArrayOfByte.cVw == -1)
          {
            paramAnonymousArrayOfByte.cVv = 10;
            ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
          }
        }
      }
    };
    this.cVA = paramInt2;
    this.mSampleRate = paramInt1;
    this.cVF = paramInt3;
    if (this.cVA == 2)
    {
      this.cVV = 12;
      if ((this.cVF == 0) && (ae.fJo.fFF > 0)) {
        this.cVB = ae.fJo.fFF;
      }
      if (ae.fJo.fFQ > 0) {
        this.cVV = ae.fJo.fFQ;
      }
      if (ae.fJo.fFA > 0) {
        this.cVE = ae.fJo.fFA;
      }
      if (ae.fJe.fDy) {
        this.cVU = new com.tencent.mm.audio.e.b(g.cWw, this.cVA, this.mSampleRate);
      }
      if (1 != g.x("EnableRecorderCheckUnreasonableData", 1)) {
        break label363;
      }
    }
    label363:
    for (boolean bool = true;; bool = false)
    {
      this.cVP = bool;
      ac.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[] { Integer.valueOf(this.mSampleRate), Integer.valueOf(this.cVA), Integer.valueOf(this.cVB), Boolean.valueOf(this.cVC), Integer.valueOf(this.cVF) });
      AppMethodBeat.o(129980);
      return;
      this.cVV = 16;
      break;
    }
  }
  
  private boolean Oh()
  {
    AppMethodBeat.i(129990);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    ac.i("MicroMsg.MMPcmRecorder", "startRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
    if (this.cVQ != null)
    {
      com.tencent.mm.audio.c.b.a.hT(this.cVF);
      ac.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
      AppMethodBeat.o(129990);
      return false;
    }
    locala.fJW = SystemClock.elapsedRealtime();
    ac.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
    if (!init())
    {
      ac.e("MicroMsg.MMPcmRecorder", "startRecord init error");
      AppMethodBeat.o(129990);
      return false;
    }
    ac.i("MicroMsg.MMPcmRecorder", "init cost: " + locala.YH() + "ms");
    locala.fJW = SystemClock.elapsedRealtime();
    try
    {
      this.cVQ.startRecording();
      ac.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + locala.YH());
      if (this.cVQ.getRecordingState() != 3)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 3L, 1L, false);
        this.cVW = 2;
        this.cVv = 4;
        ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
        Oi();
        com.tencent.mm.audio.c.b.a.hN(this.cVF);
        AppMethodBeat.o(129990);
        return false;
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MMPcmRecorder", "start error cause permission deny");
      this.cVW = 2;
      this.cVv = 4;
      ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
      Oi();
      com.tencent.mm.audio.c.b.a.hN(this.cVF);
      AppMethodBeat.o(129990);
      return false;
    }
    if (this.cVS != null)
    {
      boolean bool = this.cVS.Og();
      AppMethodBeat.o(129990);
      return bool;
    }
    ac.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
    com.tencent.mm.audio.c.b.a.hM(this.cVF);
    AppMethodBeat.o(129990);
    return false;
  }
  
  private boolean init()
  {
    AppMethodBeat.i(129987);
    com.tencent.mm.plugin.audio.c.a.bCx();
    com.tencent.mm.plugin.audio.b.a.bCp();
    this.cVW = 1;
    boolean bool1;
    if (ae.fJo.fFB == 2)
    {
      bool1 = false;
      i = m.XE();
      j = ae.fJe.fDP;
      if ((i & 0x400) == 0) {
        break label166;
      }
      i = j;
      if (j <= 0) {
        i = 0;
      }
      ac.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: ".concat(String.valueOf(i)));
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
      ac.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
      m = AudioRecord.getMinBufferSize(this.mSampleRate, this.cVV, 2);
      if ((m != -2) && (m != -1)) {
        break label176;
      }
      this.cVW = 3;
      this.cVv = 1;
      ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR ".concat(String.valueOf(m)));
      Oi();
      com.tencent.mm.audio.c.b.a.hS(this.cVF);
      AppMethodBeat.o(129987);
      return false;
      bool1 = true;
      break;
      i = 1;
      break label73;
    }
    label176:
    ac.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[] { Integer.valueOf(m) });
    this.cVJ = (this.mSampleRate * 20 * this.cVA * 2 / 1000);
    int n = this.mSampleRate * this.cVB * this.cVA / 1000;
    int i1 = n * 2;
    ac.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mSampleRate), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.cVE), Boolean.valueOf(bool1) });
    int i2 = this.cVF;
    int j = this.cVz;
    if ((1 == i2) || (6 == i2) || (7 == i2)) {
      if (Build.VERSION.SDK_INT < 11)
      {
        i = 1;
        if (ae.fJe.fCT) {
          i = 1;
        }
        if (ae.fJe.fDs >= 0) {
          i = ae.fJe.fDs;
        }
        j = i;
        if (6 != i2) {
          break label1378;
        }
        j = i;
        if (ae.fJe.fDZ < 0) {
          break label1378;
        }
      }
    }
    label792:
    label860:
    label1378:
    for (int i = ae.fJe.fDZ;; i = j)
    {
      for (;;)
      {
        ac.i("MicroMsg.MMPcmRecorder", "init audio source: %s", new Object[] { Integer.valueOf(i) });
        try
        {
          this.cVQ = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.cVV, this.cVE * m);
          if (this.cVQ.getState() == 0)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 2L, 1L, false);
            this.cVQ.release();
            this.cVv = 2;
            ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
            if (7 == i)
            {
              i = 1;
              this.cVQ = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.cVV, this.cVE * m);
            }
          }
          else
          {
            if (this.cVQ.getState() != 0) {
              break label792;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 2L, 1L, false);
            this.cVQ.release();
            this.cVQ = null;
            this.cVW = 2;
            this.cVv = 3;
            ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
            Oi();
            com.tencent.mm.audio.c.b.a.hO(this.cVF);
            AppMethodBeat.o(129987);
            return false;
            i = 7;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ac.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.cVv = 12;
            ac.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            ac.printErrStackTrace("MicroMsg.MMPcmRecorder", localException1, "", new Object[0]);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 1L, 1L, false);
            com.tencent.mm.audio.c.b.a.ci(this.cVF, i);
            if (7 == i) {}
            for (i = 1;; i = 7) {
              try
              {
                this.cVQ = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.cVV, this.cVE * m);
                com.tencent.mm.audio.c.b.a.ck(this.cVF, i);
              }
              catch (Exception localException2)
              {
                com.tencent.mm.audio.c.b.a.ci(this.cVF, i);
                com.tencent.mm.audio.c.b.a.cj(this.cVF, i);
                com.tencent.mm.audio.c.b.a.hO(this.cVF);
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
        localObject1 = this.cVQ;
        boolean bool2 = this.cVC;
        localObject2 = this.cVR;
        if (((this.cVF == 1) || (this.cVF == 6)) && (k != 0))
        {
          bool1 = true;
          this.cVS = new e((AudioRecord)localObject1, bool2, i1, (c.a)localObject2, bool1);
          this.cVS.a(this.cVZ);
          if (-123456789 != this.cVG) {
            this.cVS.hI(this.cVG);
          }
          if (this.cVH)
          {
            this.cVT = new com.tencent.mm.compatible.b.h();
            localObject1 = this.cVT;
            localObject2 = this.cVQ;
            i = this.cVF;
            ac.d("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
            if (!com.tencent.mm.compatible.util.d.la(16))
            {
              if (localObject2 != null) {
                break label1017;
              }
              ac.d("MicroMsg.MMAudioPreProcess", "audio is null");
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
        this.cVS = new d(this.cVQ, this.cVR, this.cVC, n, i1);
        break label860;
        label1017:
        if (1 == i)
        {
          if (ae.fJo.fGh != 1)
          {
            ac.d("MicroMsg.MMAudioPreProcess", "disable by config");
          }
          else
          {
            if (ae.fJo.fGi != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).fCJ = new j((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).fCJ != null) && (((com.tencent.mm.compatible.b.h)localObject1).fCJ.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).fCJ.Xh();
              }
            }
            if (ae.fJo.fGj != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).fCK = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).fCK != null) && (((com.tencent.mm.compatible.b.h)localObject1).fCK.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).fCK.Xh();
              }
            }
            if (ae.fJo.fGk != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).fCL = new i((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).fCL != null) && (((com.tencent.mm.compatible.b.h)localObject1).fCL.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).fCL.Xh();
              }
            }
          }
        }
        else if (ae.fJo.fFE != 1)
        {
          ac.d("MicroMsg.MMAudioPreProcess", "disable by config");
        }
        else
        {
          ((com.tencent.mm.compatible.b.h)localObject1).fCJ = new j((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).fCJ != null) && (((com.tencent.mm.compatible.b.h)localObject1).fCJ.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).fCJ.Xh();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).fCK = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).fCK != null) && (((com.tencent.mm.compatible.b.h)localObject1).fCK.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).fCK.Xh();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).fCL = new i((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).fCL != null) && (((com.tencent.mm.compatible.b.h)localObject1).fCL.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).fCL.Xh();
          }
        }
      }
    }
  }
  
  public final boolean NX()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(129991);
        if (true == this.cVM)
        {
          ac.i("MicroMsg.MMPcmRecorder", "already have stopped");
          AppMethodBeat.o(129991);
          bool1 = true;
          return bool1;
        }
        this.cVM = true;
        Object localObject1 = new com.tencent.mm.compatible.util.f.a();
        if (this.cVU != null)
        {
          this.cVU.closeFile();
          this.cVU = null;
        }
        ((com.tencent.mm.compatible.util.f.a)localObject1).fJW = SystemClock.elapsedRealtime();
        if (this.cVS != null)
        {
          this.cVS.stopRecord();
          this.cVS = null;
        }
        ac.i("MicroMsg.MMPcmRecorder", "cost " + ((com.tencent.mm.compatible.util.f.a)localObject1).YH() + "ms to call stopRecord");
        ac.i("MicroMsg.MMPcmRecorder", "stopRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.cVQ == null)
        {
          ac.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
          bool1 = false;
          if (((!this.cVK) && (-1L != this.cVI) && (System.currentTimeMillis() - this.cVI >= 2000L)) || (this.cVO))
          {
            ac.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
            localObject1 = new oj();
            ((oj)localObject1).dqS.type = 1;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
            bool2 = false;
          }
          localObject1 = new oi();
          ((oi)localObject1).dqN.type = 1;
          ((oi)localObject1).dqN.dqP = false;
          ((oi)localObject1).dqN.dqQ = bool2;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
          ac.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[] { Integer.valueOf(this.cVv) });
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(new IDKey(357, 0, 1));
          if (this.cVv != 0) {
            ((ArrayList)localObject1).add(new IDKey(357, 1, 1));
          }
        }
        switch (this.cVv)
        {
        case 1: 
          ac.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
          com.tencent.mm.plugin.report.service.h.wUl.b((ArrayList)localObject1, false);
          AppMethodBeat.o(129991);
          continue;
          if (this.cVQ.getState() == 1) {
            break label516;
          }
        }
      }
      finally {}
      ac.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.cVQ.getState());
      boolean bool1 = false;
      continue;
      label516:
      if (this.cVY != null)
      {
        if (this.cVF != 0) {
          break label630;
        }
        com.tencent.mm.audio.c.b.a.a(0, this.cVY, this.cVz, this.mSampleRate, this.cVV, this.cVv);
        com.tencent.mm.audio.c.b.a.hW(this.cVF);
        com.tencent.mm.audio.c.b.a.hV(this.cVF);
      }
      for (;;)
      {
        localObject2.fJW = SystemClock.elapsedRealtime();
        this.cVQ.stop();
        this.cVQ.release();
        this.cVQ = null;
        ac.i("MicroMsg.MMPcmRecorder", "cost " + localObject2.YH() + "ms to call stop and release");
        bool1 = true;
        break;
        label630:
        if (this.cVF == 1)
        {
          com.tencent.mm.audio.c.b.a.a(1, this.cVY, this.cVz, this.mSampleRate, this.cVV, this.cVv);
          com.tencent.mm.audio.c.b.a.hW(this.cVF);
          com.tencent.mm.audio.c.b.a.hV(this.cVF);
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
  
  public final void Oe()
  {
    AppMethodBeat.i(129983);
    this.cVD = true;
    ac.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.cVD);
    AppMethodBeat.o(129983);
  }
  
  public final int Of()
  {
    AppMethodBeat.i(129985);
    if (this.cVX > 0)
    {
      i = this.cVX;
      AppMethodBeat.o(129985);
      return i;
    }
    int i = AudioRecord.getMinBufferSize(this.mSampleRate, this.cVV, 2);
    ac.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", new Object[] { Integer.valueOf(i) });
    if ((i == -2) || (i == -1))
    {
      AppMethodBeat.o(129985);
      return 0;
    }
    this.cVX = (this.cVE * i);
    i = this.cVX;
    AppMethodBeat.o(129985);
    return i;
  }
  
  public final boolean Og()
  {
    AppMethodBeat.i(129989);
    ac.i("MicroMsg.MMPcmRecorder", "startRecord");
    Object localObject = new oi();
    ((oi)localObject).dqN.type = 1;
    ((oi)localObject).dqN.dqP = true;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    this.cVI = System.currentTimeMillis();
    this.cVK = false;
    if (((oi)localObject).dqO.dqR)
    {
      ac.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
      this.cVv = 13;
      AppMethodBeat.o(129989);
      return false;
    }
    localObject = (AudioManager)ai.getContext().getSystemService("audio");
    if ((localObject != null) && (((AudioManager)localObject).isMicrophoneMute()))
    {
      ac.e("MicroMsg.MMPcmRecorder", "microphone is mute");
      this.cVv = 14;
      localObject = new lm();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(151L, 8L, 1L, false);
      com.tencent.mm.audio.c.b.a.hU(this.cVF);
      AppMethodBeat.o(129989);
      return false;
    }
    this.cVM = false;
    boolean bool = Oh();
    if (!bool)
    {
      NX();
      localObject = new oj();
      ((oj)localObject).dqS.type = 1;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(129989);
      return bool;
      com.tencent.mm.audio.c.b.a.ch(this.cVF, this.cVQ.getAudioSource());
    }
  }
  
  final void Oi()
  {
    AppMethodBeat.i(129992);
    if (this.cVR != null) {
      this.cVR.cf(this.cVW, this.cVv);
    }
    AppMethodBeat.o(129992);
  }
  
  public final int Oj()
  {
    AppMethodBeat.i(129993);
    if (this.cVS != null)
    {
      int i = this.cVS.Oj();
      AppMethodBeat.o(129993);
      return i;
    }
    AppMethodBeat.o(129993);
    return -1;
  }
  
  public final void a(c.a parama)
  {
    this.cVR = parama;
  }
  
  public final void cs(boolean paramBoolean)
  {
    AppMethodBeat.i(129982);
    this.cVC = paramBoolean;
    ac.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.cVC);
    AppMethodBeat.o(129982);
  }
  
  public final void ct(boolean paramBoolean)
  {
    AppMethodBeat.i(129986);
    this.cVH = paramBoolean;
    ac.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.cVH);
    AppMethodBeat.o(129986);
  }
  
  public final void cu(boolean paramBoolean)
  {
    AppMethodBeat.i(129988);
    ac.i("MicroMsg.MMPcmRecorder", "switchMute mute:".concat(String.valueOf(paramBoolean)));
    if (this.cVS != null) {
      this.cVS.cu(paramBoolean);
    }
    AppMethodBeat.o(129988);
  }
  
  public final void hH(int paramInt)
  {
    AppMethodBeat.i(129981);
    this.cVB = paramInt;
    ac.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.cVB);
    AppMethodBeat.o(129981);
  }
  
  public final void setAudioSource(int paramInt)
  {
    AppMethodBeat.i(209885);
    this.cVz = paramInt;
    ac.i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(209885);
  }
  
  public final void t(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129984);
    if ((10 == this.cVE) || (paramBoolean))
    {
      this.cVE = paramInt;
      ac.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.cVE);
    }
    AppMethodBeat.o(129984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.c
 * JD-Core Version:    0.7.0.1
 */