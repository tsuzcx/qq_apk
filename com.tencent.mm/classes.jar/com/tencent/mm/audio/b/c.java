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
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.f.a.nd;
import com.tencent.mm.f.a.qi;
import com.tencent.mm.f.a.qi.b;
import com.tencent.mm.f.a.qj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;

public final class c
{
  public int frO;
  int frP;
  int frQ;
  int frR;
  public int frS;
  private int frT;
  public int frU;
  private boolean frV;
  boolean frW;
  private int frX;
  int frY;
  public int frZ;
  private boolean fsa;
  long fsb;
  int fsc;
  boolean fsd;
  int fse;
  private boolean fsf;
  int fsg;
  boolean fsh;
  boolean fsi;
  private AudioRecord fsj;
  public a fsk;
  private f fsl;
  private com.tencent.mm.compatible.b.h fsm;
  com.tencent.mm.audio.e.b fsn;
  private int fso;
  public int fsp;
  private int fsq;
  public String fsr;
  private f.a fss;
  private int mSampleRate;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129980);
    this.frO = 0;
    this.frP = 0;
    this.frQ = 0;
    this.frR = 0;
    this.frS = 1;
    this.frT = 1;
    this.mSampleRate = 8000;
    this.frU = 120;
    this.frV = false;
    this.frW = false;
    this.frX = 10;
    this.frY = -1;
    this.frZ = -123456789;
    this.fsa = false;
    this.fsb = -1L;
    this.fsd = false;
    this.fsf = false;
    this.fsg = 0;
    this.fsh = false;
    this.fsi = false;
    this.fso = 16;
    this.fsp = 1;
    this.fsq = 0;
    this.fss = new f.a()
    {
      public final void d(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(129979);
        c.this.fsg += 1;
        if ((c.this.fsi) && (System.currentTimeMillis() - c.this.fsb <= 1000L) && (c.this.fsg - 10 > (System.currentTimeMillis() - c.this.fsb) / c.this.frU))
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 4L, 1L, false);
          Log.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[] { Integer.valueOf(c.this.fsg), Long.valueOf((System.currentTimeMillis() - c.this.fsb) / c.this.frU) });
          c.this.fsh = true;
        }
        if (c.this.fsn != null) {
          c.this.fsn.A(paramAnonymousArrayOfByte, paramAnonymousInt);
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
          if ((!localc.fsd) || (-2 != localc.frQ))
          {
            m = paramAnonymousInt / localc.fsc;
            i = 5;
            if (i <= localc.fse + m)
            {
              k = (i - localc.fse - 1) * localc.fsc;
              n = localc.fsc + k;
              if (k >= 0)
              {
                j = k;
                if (n <= paramAnonymousInt) {
                  break label708;
                }
              }
              Log.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
            }
            localc.fse = ((localc.fse + m) % 5);
            if (localc.frQ == 20)
            {
              localc.frO = 6;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
              if ((localc.frP != -1) || (localc.frR != -1)) {
                break label753;
              }
              localc.frO = 11;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              label382:
              if (com.tencent.mm.plugin.audio.c.a.crn().audioManager.isMicrophoneMute()) {
                com.tencent.mm.audio.c.b.a.kM(localc.frY);
              }
              if ((com.tencent.mm.plugin.audio.c.a.crn().crm()) || (com.tencent.mm.plugin.audio.c.a.crn().crh())) {
                com.tencent.mm.audio.c.b.a.kN(localc.frY);
              }
              Log.e("MicroMsg.MMPcmRecorder", "record is mute %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.crn().audioManager.isMicrophoneMute()) });
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 5L, 1L, false);
              localc.frQ = -2;
              localc.aeW();
            }
          }
        }
        if (c.this.frW)
        {
          if (paramAnonymousInt > 0)
          {
            localc = c.this;
            if (localc.frP != -1)
            {
              j = 0;
              i = 0;
              label526:
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
                  break label805;
                }
                localc.frP += 1;
              }
              if (localc.frP > 100)
              {
                localc.frO = 7;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                if ((localc.frQ != -2) || (localc.frR != -1)) {
                  break label816;
                }
                localc.frO = 11;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 6L, 1L, false);
              localc.aeW();
              localc.frP = -1;
              AppMethodBeat.o(129979);
              return;
              label708:
              do
              {
                j += 1;
                if (j >= n) {
                  break;
                }
              } while (paramAnonymousArrayOfByte[j] == 0);
              localc.frQ = -1;
              localc.fsd = true;
              localc.frQ += 1;
              i += 5;
              break;
              label753:
              if (localc.frP == -1)
              {
                localc.frO = 8;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                break label382;
              }
              if (localc.frR != -1) {
                break label382;
              }
              localc.frO = 9;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
              break label382;
              label805:
              i += 1;
              j = k;
              break label526;
              label816:
              if (localc.frQ == -2)
              {
                localc.frO = 8;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
              }
              else if (localc.frR == -1)
              {
                localc.frO = 10;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
              }
            }
          }
          paramAnonymousArrayOfByte = c.this;
          if ((paramAnonymousArrayOfByte.frR != -1) && (paramAnonymousInt < 0))
          {
            paramAnonymousArrayOfByte.frR += 1;
            if (paramAnonymousArrayOfByte.frR >= 50)
            {
              paramAnonymousArrayOfByte.frO = 5;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
              if ((paramAnonymousArrayOfByte.frQ != -2) || (paramAnonymousArrayOfByte.frP != -1)) {
                break label988;
              }
              paramAnonymousArrayOfByte.frO = 11;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 7L, 1L, false);
          paramAnonymousArrayOfByte.aeW();
          paramAnonymousArrayOfByte.frR = -1;
          AppMethodBeat.o(129979);
          return;
          label988:
          if (paramAnonymousArrayOfByte.frQ == -2)
          {
            paramAnonymousArrayOfByte.frO = 9;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
          }
          else if (paramAnonymousArrayOfByte.frP == -1)
          {
            paramAnonymousArrayOfByte.frO = 10;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
          }
        }
      }
    };
    this.frT = paramInt2;
    this.mSampleRate = paramInt1;
    this.frY = paramInt3;
    if (this.frT == 2)
    {
      this.fso = 12;
      if ((this.frY == 0) && (af.juS.jqP > 0)) {
        this.frU = af.juS.jqP;
      }
      if (af.juS.jra > 0) {
        this.fso = af.juS.jra;
      }
      if (af.juS.jqK > 0) {
        this.frX = af.juS.jqK;
      }
      if (af.juI.jot) {
        this.fsn = new com.tencent.mm.audio.e.b(g.fsP, this.frT, this.mSampleRate);
      }
      if (1 != g.T("EnableRecorderCheckUnreasonableData", 1)) {
        break label363;
      }
    }
    label363:
    for (boolean bool = true;; bool = false)
    {
      this.fsi = bool;
      Log.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[] { Integer.valueOf(this.mSampleRate), Integer.valueOf(this.frT), Integer.valueOf(this.frU), Boolean.valueOf(this.frV), Integer.valueOf(this.frY) });
      AppMethodBeat.o(129980);
      return;
      this.fso = 16;
      break;
    }
  }
  
  private boolean aeV()
  {
    AppMethodBeat.i(129990);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    Log.i("MicroMsg.MMPcmRecorder", "startRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
    if (this.fsj != null)
    {
      com.tencent.mm.audio.c.b.a.kQ(this.frY);
      Log.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
      AppMethodBeat.o(129990);
      return false;
    }
    locala.jvB = SystemClock.elapsedRealtime();
    Log.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
    if (!init())
    {
      Log.e("MicroMsg.MMPcmRecorder", "startRecord init error");
      AppMethodBeat.o(129990);
      return false;
    }
    Log.i("MicroMsg.MMPcmRecorder", "init cost: " + locala.avE() + "ms");
    locala.jvB = SystemClock.elapsedRealtime();
    try
    {
      this.fsj.startRecording();
      Log.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + locala.avE());
      if (this.fsj.getRecordingState() != 3)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 3L, 1L, false);
        this.fsp = 2;
        this.frO = 4;
        Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
        aeW();
        com.tencent.mm.audio.c.b.a.kK(this.frY);
        AppMethodBeat.o(129990);
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMPcmRecorder", "start error cause permission deny");
      this.fsp = 2;
      this.frO = 4;
      Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
      aeW();
      com.tencent.mm.audio.c.b.a.kK(this.frY);
      AppMethodBeat.o(129990);
      return false;
    }
    if (this.fsl != null)
    {
      boolean bool = this.fsl.aeU();
      AppMethodBeat.o(129990);
      return bool;
    }
    Log.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
    com.tencent.mm.audio.c.b.a.kJ(this.frY);
    AppMethodBeat.o(129990);
    return false;
  }
  
  private boolean init()
  {
    AppMethodBeat.i(129987);
    com.tencent.mm.plugin.audio.c.a.crn();
    com.tencent.mm.plugin.audio.b.a.cre();
    this.fsp = 1;
    boolean bool1;
    if (af.juS.jqL == 2)
    {
      bool1 = false;
      i = m.aus();
      j = af.juI.joV;
      if ((i & 0x400) == 0) {
        break label166;
      }
      i = j;
      if (j <= 0) {
        i = 0;
      }
      Log.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: ".concat(String.valueOf(i)));
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
      Log.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
      m = AudioRecord.getMinBufferSize(this.mSampleRate, this.fso, 2);
      if ((m != -2) && (m != -1)) {
        break label176;
      }
      this.fsp = 3;
      this.frO = 1;
      Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR ".concat(String.valueOf(m)));
      aeW();
      com.tencent.mm.audio.c.b.a.kP(this.frY);
      AppMethodBeat.o(129987);
      return false;
      bool1 = true;
      break;
      i = 1;
      break label73;
    }
    label176:
    Log.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[] { Integer.valueOf(m) });
    this.fsc = (this.mSampleRate * 20 * this.frT * 2 / 1000);
    int n = this.mSampleRate * this.frU * this.frT / 1000;
    int i1 = n * 2;
    Log.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mSampleRate), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.frX), Boolean.valueOf(bool1) });
    int i2 = this.frY;
    int j = this.frS;
    if ((1 == i2) || (6 == i2) || (7 == i2)) {
      if (Build.VERSION.SDK_INT < 11)
      {
        i = 1;
        if (af.juI.jnK) {
          i = 1;
        }
        if (af.juI.jon >= 0) {
          i = af.juI.jon;
        }
        j = i;
        if (6 != i2) {
          break label1378;
        }
        j = i;
        if (af.juI.jpf < 0) {
          break label1378;
        }
      }
    }
    label792:
    label860:
    label1378:
    for (int i = af.juI.jpf;; i = j)
    {
      for (;;)
      {
        Log.i("MicroMsg.MMPcmRecorder", "init audio source: %s", new Object[] { Integer.valueOf(i) });
        try
        {
          this.fsj = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.fso, this.frX * m);
          if (this.fsj.getState() == 0)
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 2L, 1L, false);
            this.fsj.release();
            this.frO = 2;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
            if (7 == i)
            {
              i = 1;
              this.fsj = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.fso, this.frX * m);
            }
          }
          else
          {
            if (this.fsj.getState() != 0) {
              break label792;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 2L, 1L, false);
            this.fsj.release();
            this.fsj = null;
            this.fsp = 2;
            this.frO = 3;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
            aeW();
            com.tencent.mm.audio.c.b.a.kL(this.frY);
            AppMethodBeat.o(129987);
            return false;
            i = 7;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.frO = 12;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            Log.printErrStackTrace("MicroMsg.MMPcmRecorder", localException1, "", new Object[0]);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 1L, 1L, false);
            com.tencent.mm.audio.c.b.a.cE(this.frY, i);
            if (7 == i) {}
            for (i = 1;; i = 7) {
              try
              {
                this.fsj = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.fso, this.frX * m);
                com.tencent.mm.audio.c.b.a.cG(this.frY, i);
              }
              catch (Exception localException2)
              {
                com.tencent.mm.audio.c.b.a.cE(this.frY, i);
                com.tencent.mm.audio.c.b.a.cF(this.frY, i);
                com.tencent.mm.audio.c.b.a.kL(this.frY);
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
        localObject1 = this.fsj;
        boolean bool2 = this.frV;
        localObject2 = this.fsk;
        if (((this.frY == 1) || (this.frY == 6)) && (k != 0))
        {
          bool1 = true;
          this.fsl = new e((AudioRecord)localObject1, bool2, i1, (a)localObject2, bool1);
          this.fsl.a(this.fss);
          if (-123456789 != this.frZ) {
            this.fsl.kF(this.frZ);
          }
          if (this.fsa)
          {
            this.fsm = new com.tencent.mm.compatible.b.h();
            localObject1 = this.fsm;
            localObject2 = this.fsj;
            i = this.frY;
            Log.d("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
            if (!com.tencent.mm.compatible.util.d.qW(16))
            {
              if (localObject2 != null) {
                break label1017;
              }
              Log.d("MicroMsg.MMAudioPreProcess", "audio is null");
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
        this.fsl = new d(this.fsj, this.fsk, this.frV, n, i1);
        break label860;
        label1017:
        if (1 == i)
        {
          if (af.juS.jrs != 1)
          {
            Log.d("MicroMsg.MMAudioPreProcess", "disable by config");
          }
          else
          {
            if (af.juS.jrt != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).jnq = new j((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).jnq != null) && (((com.tencent.mm.compatible.b.h)localObject1).jnq.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).jnq.atG();
              }
            }
            if (af.juS.jru != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).jnr = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).jnr != null) && (((com.tencent.mm.compatible.b.h)localObject1).jnr.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).jnr.atG();
              }
            }
            if (af.juS.jrv != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).jns = new i((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).jns != null) && (((com.tencent.mm.compatible.b.h)localObject1).jns.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).jns.atG();
              }
            }
          }
        }
        else if (af.juS.jqO != 1)
        {
          Log.d("MicroMsg.MMAudioPreProcess", "disable by config");
        }
        else
        {
          ((com.tencent.mm.compatible.b.h)localObject1).jnq = new j((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).jnq != null) && (((com.tencent.mm.compatible.b.h)localObject1).jnq.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).jnq.atG();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).jnr = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).jnr != null) && (((com.tencent.mm.compatible.b.h)localObject1).jnr.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).jnr.atG();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).jns = new i((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).jns != null) && (((com.tencent.mm.compatible.b.h)localObject1).jns.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).jns.atG();
          }
        }
      }
    }
  }
  
  public final void a(a parama)
  {
    this.fsk = parama;
  }
  
  public final boolean aeJ()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(129991);
        if (true == this.fsf)
        {
          Log.i("MicroMsg.MMPcmRecorder", "already have stopped");
          AppMethodBeat.o(129991);
          bool1 = true;
          return bool1;
        }
        this.fsf = true;
        Object localObject1 = new com.tencent.mm.compatible.util.f.a();
        if (this.fsn != null)
        {
          this.fsn.closeFile();
          this.fsn = null;
        }
        ((com.tencent.mm.compatible.util.f.a)localObject1).jvB = SystemClock.elapsedRealtime();
        if (this.fsl != null)
        {
          this.fsl.stopRecord();
          this.fsl = null;
        }
        Log.i("MicroMsg.MMPcmRecorder", "cost " + ((com.tencent.mm.compatible.util.f.a)localObject1).avE() + "ms to call stopRecord");
        Log.i("MicroMsg.MMPcmRecorder", "stopRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.fsj == null)
        {
          Log.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
          bool1 = false;
          if (((!this.fsd) && (-1L != this.fsb) && (System.currentTimeMillis() - this.fsb >= 2000L)) || (this.fsh))
          {
            Log.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
            localObject1 = new qj();
            ((qj)localObject1).fPf.type = 1;
            EventCenter.instance.publish((IEvent)localObject1);
            bool2 = false;
          }
          localObject1 = new qi();
          ((qi)localObject1).fPa.type = 1;
          ((qi)localObject1).fPa.fPc = false;
          ((qi)localObject1).fPa.fPd = bool2;
          EventCenter.instance.publish((IEvent)localObject1);
          Log.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[] { Integer.valueOf(this.frO) });
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(new IDKey(357, 0, 1));
          if (this.frO != 0) {
            ((ArrayList)localObject1).add(new IDKey(357, 1, 1));
          }
        }
        switch (this.frO)
        {
        case 1: 
          Log.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
          com.tencent.mm.plugin.report.service.h.IzE.b((ArrayList)localObject1, false);
          AppMethodBeat.o(129991);
          continue;
          if (this.fsj.getState() == 1) {
            break label516;
          }
        }
      }
      finally {}
      Log.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.fsj.getState());
      boolean bool1 = false;
      continue;
      label516:
      if (this.fsr != null)
      {
        if (this.frY != 0) {
          break label630;
        }
        com.tencent.mm.audio.c.b.a.a(0, this.fsr, this.frS, this.mSampleRate, this.fso, this.frO);
        com.tencent.mm.audio.c.b.a.kT(this.frY);
        com.tencent.mm.audio.c.b.a.kS(this.frY);
      }
      for (;;)
      {
        localObject2.jvB = SystemClock.elapsedRealtime();
        this.fsj.stop();
        this.fsj.release();
        this.fsj = null;
        Log.i("MicroMsg.MMPcmRecorder", "cost " + localObject2.avE() + "ms to call stop and release");
        bool1 = true;
        break;
        label630:
        if (this.frY == 1)
        {
          com.tencent.mm.audio.c.b.a.a(1, this.fsr, this.frS, this.mSampleRate, this.fso, this.frO);
          com.tencent.mm.audio.c.b.a.kT(this.frY);
          com.tencent.mm.audio.c.b.a.kS(this.frY);
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
  
  public final void aeR()
  {
    AppMethodBeat.i(129983);
    this.frW = true;
    Log.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.frW);
    AppMethodBeat.o(129983);
  }
  
  public final int aeS()
  {
    AppMethodBeat.i(129985);
    if (this.fsq > 0)
    {
      i = this.fsq;
      AppMethodBeat.o(129985);
      return i;
    }
    int i = AudioRecord.getMinBufferSize(this.mSampleRate, this.fso, 2);
    Log.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", new Object[] { Integer.valueOf(i) });
    if ((i == -2) || (i == -1))
    {
      AppMethodBeat.o(129985);
      return 0;
    }
    this.fsq = (this.frX * i);
    i = this.fsq;
    AppMethodBeat.o(129985);
    return i;
  }
  
  public final void aeT()
  {
    this.frZ = -19;
  }
  
  public final boolean aeU()
  {
    AppMethodBeat.i(129989);
    Log.i("MicroMsg.MMPcmRecorder", "startRecord");
    Object localObject = new qi();
    ((qi)localObject).fPa.type = 1;
    ((qi)localObject).fPa.fPc = true;
    EventCenter.instance.publish((IEvent)localObject);
    this.fsb = System.currentTimeMillis();
    this.fsd = false;
    if (((qi)localObject).fPb.fPe)
    {
      Log.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
      this.frO = 13;
      AppMethodBeat.o(129989);
      return false;
    }
    localObject = (AudioManager)MMApplicationContext.getContext().getSystemService("audio");
    if ((localObject != null) && (((AudioManager)localObject).isMicrophoneMute()))
    {
      Log.e("MicroMsg.MMPcmRecorder", "microphone is mute");
      this.frO = 14;
      localObject = new nd();
      EventCenter.instance.publish((IEvent)localObject);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(151L, 8L, 1L, false);
      com.tencent.mm.audio.c.b.a.kR(this.frY);
      AppMethodBeat.o(129989);
      return false;
    }
    this.fsf = false;
    boolean bool = aeV();
    if (!bool)
    {
      aeJ();
      localObject = new qj();
      ((qj)localObject).fPf.type = 1;
      EventCenter.instance.publish((IEvent)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(129989);
      return bool;
      com.tencent.mm.audio.c.b.a.cD(this.frY, this.fsj.getAudioSource());
    }
  }
  
  final void aeW()
  {
    AppMethodBeat.i(129992);
    if (this.fsk != null) {
      this.fsk.cC(this.fsp, this.frO);
    }
    AppMethodBeat.o(129992);
  }
  
  public final int aeX()
  {
    AppMethodBeat.i(129993);
    if (this.fsl != null)
    {
      int i = this.fsl.aeX();
      AppMethodBeat.o(129993);
      return i;
    }
    AppMethodBeat.o(129993);
    return -1;
  }
  
  public final void dC(boolean paramBoolean)
  {
    AppMethodBeat.i(129982);
    this.frV = paramBoolean;
    Log.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.frV);
    AppMethodBeat.o(129982);
  }
  
  public final void dD(boolean paramBoolean)
  {
    AppMethodBeat.i(129986);
    this.fsa = paramBoolean;
    Log.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.fsa);
    AppMethodBeat.o(129986);
  }
  
  public final void dE(boolean paramBoolean)
  {
    AppMethodBeat.i(129988);
    Log.i("MicroMsg.MMPcmRecorder", "switchMute mute:".concat(String.valueOf(paramBoolean)));
    if (this.fsl != null) {
      this.fsl.dE(paramBoolean);
    }
    AppMethodBeat.o(129988);
  }
  
  public final void kD(int paramInt)
  {
    AppMethodBeat.i(129981);
    this.frU = paramInt;
    Log.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.frU);
    AppMethodBeat.o(129981);
  }
  
  public final void kE(int paramInt)
  {
    AppMethodBeat.i(196349);
    this.frS = paramInt;
    Log.i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(196349);
  }
  
  public final void z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129984);
    if ((10 == this.frX) || (paramBoolean))
    {
      this.frX = paramInt;
      Log.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.frX);
    }
    AppMethodBeat.o(129984);
  }
  
  public static abstract interface a
  {
    public abstract void cC(int paramInt1, int paramInt2);
    
    public abstract void w(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.b.c
 * JD-Core Version:    0.7.0.1
 */