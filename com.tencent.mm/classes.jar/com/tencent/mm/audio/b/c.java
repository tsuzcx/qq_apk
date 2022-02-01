package com.tencent.mm.audio.b;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ok;
import com.tencent.mm.autogen.a.rv;
import com.tencent.mm.autogen.a.rv.b;
import com.tencent.mm.autogen.a.rw;
import com.tencent.mm.compatible.b.h.a;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;

public final class c
{
  private com.tencent.mm.compatible.b.h hwA;
  com.tencent.mm.audio.e.b hwB;
  private boolean hwC;
  private int hwD;
  public int hwE;
  private int hwF;
  public String hwG;
  public long hwH;
  private f.a hwI;
  public int hwc;
  int hwd;
  int hwe;
  int hwf;
  public int hwg;
  private int hwh;
  public int hwi;
  private boolean hwj;
  boolean hwk;
  private int hwl;
  int hwm;
  public int hwn;
  private boolean hwo;
  long hwp;
  int hwq;
  boolean hwr;
  int hws;
  private boolean hwt;
  int hwu;
  boolean hwv;
  boolean hww;
  private AudioRecord hwx;
  public a hwy;
  private f hwz;
  private int mSampleRate;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129980);
    this.hwc = 0;
    this.hwd = 0;
    this.hwe = 0;
    this.hwf = 0;
    this.hwg = 1;
    this.hwh = 1;
    this.mSampleRate = 8000;
    this.hwi = 120;
    this.hwj = false;
    this.hwk = false;
    this.hwl = 10;
    this.hwm = -1;
    this.hwn = -123456789;
    this.hwo = false;
    this.hwp = -1L;
    this.hwr = false;
    this.hwt = false;
    this.hwu = 0;
    this.hwv = false;
    this.hww = false;
    this.hwC = false;
    this.hwD = 16;
    this.hwE = 1;
    this.hwF = 0;
    this.hwH = -1L;
    this.hwI = new f.a()
    {
      public final void d(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(129979);
        c localc = c.this;
        localc.hwu += 1;
        if ((c.this.hww) && (System.currentTimeMillis() - c.this.hwp <= 1000L) && (c.this.hwu - 10 > (System.currentTimeMillis() - c.this.hwp) / c.this.hwi))
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 4L, 1L, false);
          Log.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[] { Integer.valueOf(c.this.hwu), Long.valueOf((System.currentTimeMillis() - c.this.hwp) / c.this.hwi) });
          c.this.hwv = true;
        }
        if (c.this.hwB != null) {
          c.this.hwB.y(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        int m;
        int i;
        int k;
        int n;
        int j;
        if (paramAnonymousInt > 0)
        {
          localc = c.this;
          if ((!localc.hwr) || (-2 != localc.hwe))
          {
            m = paramAnonymousInt / localc.hwq;
            i = 5;
            if (i <= localc.hws + m)
            {
              k = (i - localc.hws - 1) * localc.hwq;
              n = localc.hwq + k;
              if (k >= 0)
              {
                j = k;
                if (n <= paramAnonymousInt) {
                  break label710;
                }
              }
              Log.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
            }
            localc.hws = ((localc.hws + m) % 5);
            if (localc.hwe == 20)
            {
              localc.hwc = 6;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
              if ((localc.hwd != -1) || (localc.hwf != -1)) {
                break label755;
              }
              localc.hwc = 11;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              label384:
              if (com.tencent.mm.plugin.audio.c.a.cTW().audioManager.isMicrophoneMute()) {
                com.tencent.mm.audio.c.b.a.ot(localc.hwm);
              }
              if ((com.tencent.mm.plugin.audio.c.a.cTW().cTV()) || (com.tencent.mm.plugin.audio.c.a.cTW().cTQ())) {
                com.tencent.mm.audio.c.b.a.ou(localc.hwm);
              }
              Log.e("MicroMsg.MMPcmRecorder", "record is mute %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cTW().audioManager.isMicrophoneMute()) });
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 5L, 1L, false);
              localc.hwe = -2;
              localc.aGU();
            }
          }
        }
        if (c.this.hwk)
        {
          if (paramAnonymousInt > 0)
          {
            localc = c.this;
            if (localc.hwd != -1)
            {
              j = 0;
              i = 0;
              label528:
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
                  break label807;
                }
                localc.hwd += 1;
              }
              if (localc.hwd > 100)
              {
                localc.hwc = 7;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                if ((localc.hwe != -2) || (localc.hwf != -1)) {
                  break label818;
                }
                localc.hwc = 11;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 6L, 1L, false);
              localc.aGU();
              localc.hwd = -1;
              AppMethodBeat.o(129979);
              return;
              label710:
              do
              {
                j += 1;
                if (j >= n) {
                  break;
                }
              } while (paramAnonymousArrayOfByte[j] == 0);
              localc.hwe = -1;
              localc.hwr = true;
              localc.hwe += 1;
              i += 5;
              break;
              label755:
              if (localc.hwd == -1)
              {
                localc.hwc = 8;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                break label384;
              }
              if (localc.hwf != -1) {
                break label384;
              }
              localc.hwc = 9;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
              break label384;
              label807:
              i += 1;
              j = k;
              break label528;
              label818:
              if (localc.hwe == -2)
              {
                localc.hwc = 8;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
              }
              else if (localc.hwf == -1)
              {
                localc.hwc = 10;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
              }
            }
          }
          paramAnonymousArrayOfByte = c.this;
          if ((paramAnonymousArrayOfByte.hwf != -1) && (paramAnonymousInt < 0))
          {
            paramAnonymousArrayOfByte.hwf += 1;
            if (paramAnonymousArrayOfByte.hwf >= 50)
            {
              paramAnonymousArrayOfByte.hwc = 5;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
              if ((paramAnonymousArrayOfByte.hwe != -2) || (paramAnonymousArrayOfByte.hwd != -1)) {
                break label990;
              }
              paramAnonymousArrayOfByte.hwc = 11;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 7L, 1L, false);
          paramAnonymousArrayOfByte.aGU();
          paramAnonymousArrayOfByte.hwf = -1;
          AppMethodBeat.o(129979);
          return;
          label990:
          if (paramAnonymousArrayOfByte.hwe == -2)
          {
            paramAnonymousArrayOfByte.hwc = 9;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
          }
          else if (paramAnonymousArrayOfByte.hwd == -1)
          {
            paramAnonymousArrayOfByte.hwc = 10;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
          }
        }
      }
    };
    this.hwh = paramInt2;
    this.mSampleRate = paramInt1;
    this.hwm = paramInt3;
    if (this.hwh == 2)
    {
      this.hwD = 12;
      if ((this.hwm == 0) && (af.lYj.lUd > 0)) {
        this.hwi = af.lYj.lUd;
      }
      if (af.lYj.lUo > 0) {
        this.hwD = af.lYj.lUo;
      }
      if (af.lYj.lTY > 0) {
        this.hwl = af.lYj.lTY;
      }
      if (af.lXZ.lRB) {
        this.hwB = new com.tencent.mm.audio.e.b(g.hxe, this.hwh, this.mSampleRate);
      }
      if (1 != g.ac("EnableRecorderCheckUnreasonableData", 1)) {
        break label375;
      }
    }
    label375:
    for (boolean bool = true;; bool = false)
    {
      this.hww = bool;
      Log.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[] { Integer.valueOf(this.mSampleRate), Integer.valueOf(this.hwh), Integer.valueOf(this.hwi), Boolean.valueOf(this.hwj), Integer.valueOf(this.hwm) });
      AppMethodBeat.o(129980);
      return;
      this.hwD = 16;
      break;
    }
  }
  
  private boolean aGS()
  {
    AppMethodBeat.i(129990);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    Log.i("MicroMsg.MMPcmRecorder", "startRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
    if (this.hwx != null)
    {
      com.tencent.mm.audio.c.b.a.ox(this.hwm);
      Log.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
      AppMethodBeat.o(129990);
      return false;
    }
    locala.lYS = SystemClock.elapsedRealtime();
    Log.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
    if (!init())
    {
      Log.e("MicroMsg.MMPcmRecorder", "startRecord init error");
      AppMethodBeat.o(129990);
      return false;
    }
    this.hwH = locala.aPY();
    Log.i("MicroMsg.MMPcmRecorder", "init cost: " + this.hwH + "ms");
    locala.lYS = SystemClock.elapsedRealtime();
    try
    {
      com.tencent.mm.hellhoundlib.a.a.a(this.hwx, "com/tencent/mm/audio/recorder/MMPcmRecorder", "startRecordInternal", "()Z", "android/media/AudioRecord", "startRecording", "()V");
      Log.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + locala.aPY());
      if (this.hwx.getRecordingState() != 3)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 3L, 1L, false);
        this.hwE = 2;
        this.hwc = 4;
        Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
        aGU();
        com.tencent.mm.audio.c.b.a.or(this.hwm);
        AppMethodBeat.o(129990);
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMPcmRecorder", "start error cause permission deny");
      this.hwE = 2;
      this.hwc = 4;
      Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
      aGU();
      com.tencent.mm.audio.c.b.a.or(this.hwm);
      AppMethodBeat.o(129990);
      return false;
    }
    if (this.hwz != null)
    {
      boolean bool = this.hwz.aGR();
      AppMethodBeat.o(129990);
      return bool;
    }
    Log.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
    com.tencent.mm.audio.c.b.a.oq(this.hwm);
    AppMethodBeat.o(129990);
    return false;
  }
  
  private boolean init()
  {
    AppMethodBeat.i(129987);
    com.tencent.mm.plugin.audio.c.a.cTW();
    com.tencent.mm.plugin.audio.b.a.cTN();
    this.hwE = 1;
    boolean bool1;
    if (af.lYj.lTZ == 2)
    {
      bool1 = false;
      i = m.aOK();
      j = af.lXZ.lSd;
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
      m = AudioRecord.getMinBufferSize(this.mSampleRate, this.hwD, 2);
      if ((m != -2) && (m != -1)) {
        break label176;
      }
      this.hwE = 3;
      this.hwc = 1;
      Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR ".concat(String.valueOf(m)));
      aGU();
      com.tencent.mm.audio.c.b.a.ow(this.hwm);
      AppMethodBeat.o(129987);
      return false;
      bool1 = true;
      break;
      i = 1;
      break label73;
    }
    label176:
    Log.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[] { Integer.valueOf(m) });
    this.hwq = (this.mSampleRate * 20 * this.hwh * 2 / 1000);
    int n = this.mSampleRate * this.hwi * this.hwh / 1000;
    int i1 = n * 2;
    Log.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mSampleRate), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.hwl), Boolean.valueOf(bool1) });
    int i2 = this.hwm;
    int j = this.hwg;
    if ((1 == i2) || (6 == i2) || (7 == i2)) {
      if (Build.VERSION.SDK_INT < 11)
      {
        i = 1;
        if (af.lXZ.lQS) {
          i = 1;
        }
        if (af.lXZ.lRv >= 0) {
          i = af.lXZ.lRv;
        }
        j = i;
        if (6 != i2) {
          break label1393;
        }
        j = i;
        if (af.lXZ.lSn < 0) {
          break label1393;
        }
      }
    }
    label792:
    label860:
    label1393:
    for (int i = af.lXZ.lSn;; i = j)
    {
      for (;;)
      {
        Log.i("MicroMsg.MMPcmRecorder", "init audio source: %s", new Object[] { Integer.valueOf(i) });
        try
        {
          this.hwx = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.hwD, this.hwl * m);
          if (this.hwx.getState() == 0)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 2L, 1L, false);
            this.hwx.release();
            this.hwc = 2;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
            if (7 == i)
            {
              i = 1;
              this.hwx = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.hwD, this.hwl * m);
            }
          }
          else
          {
            if (this.hwx.getState() != 0) {
              break label792;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 2L, 1L, false);
            this.hwx.release();
            this.hwx = null;
            this.hwE = 2;
            this.hwc = 3;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
            aGU();
            com.tencent.mm.audio.c.b.a.os(this.hwm);
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
            this.hwc = 12;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            Log.printErrStackTrace("MicroMsg.MMPcmRecorder", localException1, "", new Object[0]);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 1L, 1L, false);
            com.tencent.mm.audio.c.b.a.du(this.hwm, i);
            if (7 == i) {}
            for (i = 1;; i = 7) {
              try
              {
                this.hwx = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.hwD, this.hwl * m);
                com.tencent.mm.audio.c.b.a.dw(this.hwm, i);
              }
              catch (Exception localException2)
              {
                com.tencent.mm.audio.c.b.a.du(this.hwm, i);
                com.tencent.mm.audio.c.b.a.dv(this.hwm, i);
                com.tencent.mm.audio.c.b.a.os(this.hwm);
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
        localObject1 = this.hwx;
        boolean bool2 = this.hwj;
        localObject2 = this.hwy;
        if (((this.hwm == 1) || (this.hwm == 6)) && (k != 0))
        {
          bool1 = true;
          this.hwz = new e((AudioRecord)localObject1, bool2, i1, (a)localObject2, bool1);
          this.hwz.a(this.hwI);
          if (-123456789 != this.hwn) {
            this.hwz.om(this.hwn);
          }
          if (this.hwo)
          {
            this.hwA = new com.tencent.mm.compatible.b.h();
            localObject1 = this.hwA;
            localObject2 = this.hwx;
            i = this.hwm;
            Log.d("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
            if (!com.tencent.mm.compatible.util.d.rc(16))
            {
              if (localObject2 != null) {
                break label1032;
              }
              Log.d("MicroMsg.MMAudioPreProcess", "audio is null");
            }
          }
        }
      }
      for (;;)
      {
        if (this.hwC) {
          this.hwz.eq(true);
        }
        AppMethodBeat.o(129987);
        return true;
        bool1 = false;
        break;
        this.hwz = new d(this.hwx, this.hwy, this.hwj, n, i1);
        break label860;
        if (1 == i)
        {
          if (af.lYj.lUG != 1)
          {
            Log.d("MicroMsg.MMAudioPreProcess", "disable by config");
          }
          else
          {
            if (af.lYj.lUH != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).lQA = new j((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).lQA != null) && (((com.tencent.mm.compatible.b.h)localObject1).lQA.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).lQA.aOe();
              }
            }
            if (af.lYj.lUI != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).lQB = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).lQB != null) && (((com.tencent.mm.compatible.b.h)localObject1).lQB.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).lQB.aOe();
              }
            }
            if (af.lYj.lUJ != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).lQC = new i((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).lQC != null) && (((com.tencent.mm.compatible.b.h)localObject1).lQC.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).lQC.aOe();
              }
            }
          }
        }
        else if (af.lYj.lUc != 1)
        {
          Log.d("MicroMsg.MMAudioPreProcess", "disable by config");
        }
        else
        {
          ((com.tencent.mm.compatible.b.h)localObject1).lQA = new j((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).lQA != null) && (((com.tencent.mm.compatible.b.h)localObject1).lQA.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).lQA.aOe();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).lQB = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).lQB != null) && (((com.tencent.mm.compatible.b.h)localObject1).lQB.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).lQB.aOe();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).lQC = new i((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).lQC != null) && (((com.tencent.mm.compatible.b.h)localObject1).lQC.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).lQC.aOe();
          }
        }
      }
    }
  }
  
  public final void O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129984);
    if ((10 == this.hwl) || (paramBoolean))
    {
      this.hwl = paramInt;
      Log.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.hwl);
    }
    AppMethodBeat.o(129984);
  }
  
  public final boolean aGH()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(129991);
        if (true == this.hwt)
        {
          Log.i("MicroMsg.MMPcmRecorder", "already have stopped");
          AppMethodBeat.o(129991);
          bool1 = true;
          return bool1;
        }
        this.hwt = true;
        Object localObject1 = new com.tencent.mm.compatible.util.f.a();
        if (this.hwB != null)
        {
          this.hwB.closeFile();
          this.hwB = null;
        }
        ((com.tencent.mm.compatible.util.f.a)localObject1).lYS = SystemClock.elapsedRealtime();
        if (this.hwz != null)
        {
          this.hwz.stopRecord();
          this.hwz = null;
        }
        this.hwC = false;
        Log.i("MicroMsg.MMPcmRecorder", "cost " + ((com.tencent.mm.compatible.util.f.a)localObject1).aPY() + "ms to call stopRecord");
        Log.i("MicroMsg.MMPcmRecorder", "stopRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.hwx == null)
        {
          Log.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
          bool1 = false;
          if (((!this.hwr) && (-1L != this.hwp) && (System.currentTimeMillis() - this.hwp >= 2000L)) || (this.hwv))
          {
            Log.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
            localObject1 = new rw();
            ((rw)localObject1).hUY.type = 1;
            ((rw)localObject1).publish();
            bool2 = false;
          }
          localObject1 = new rv();
          ((rv)localObject1).hUT.type = 1;
          ((rv)localObject1).hUT.hUV = false;
          ((rv)localObject1).hUT.hUW = bool2;
          ((rv)localObject1).publish();
          Log.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[] { Integer.valueOf(this.hwc) });
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(new IDKey(357, 0, 1));
          if (this.hwc != 0) {
            ((ArrayList)localObject1).add(new IDKey(357, 1, 1));
          }
        }
        switch (this.hwc)
        {
        case 1: 
          Log.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
          com.tencent.mm.plugin.report.service.h.OAn.b((ArrayList)localObject1, false);
          AppMethodBeat.o(129991);
          continue;
          if (this.hwx.getState() == 1) {
            break label516;
          }
        }
      }
      finally {}
      Log.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.hwx.getState());
      boolean bool1 = false;
      continue;
      label516:
      if (this.hwG != null)
      {
        if (this.hwm != 0) {
          break label630;
        }
        com.tencent.mm.audio.c.b.a.a(0, this.hwG, this.hwg, this.mSampleRate, this.hwD, this.hwc);
        com.tencent.mm.audio.c.b.a.oA(this.hwm);
        com.tencent.mm.audio.c.b.a.oz(this.hwm);
      }
      for (;;)
      {
        localObject2.lYS = SystemClock.elapsedRealtime();
        this.hwx.stop();
        this.hwx.release();
        this.hwx = null;
        Log.i("MicroMsg.MMPcmRecorder", "cost " + localObject2.aPY() + "ms to call stop and release");
        bool1 = true;
        break;
        label630:
        if (this.hwm == 1)
        {
          com.tencent.mm.audio.c.b.a.a(1, this.hwG, this.hwg, this.mSampleRate, this.hwD, this.hwc);
          com.tencent.mm.audio.c.b.a.oA(this.hwm);
          com.tencent.mm.audio.c.b.a.oz(this.hwm);
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
  
  public final void aGP()
  {
    AppMethodBeat.i(129983);
    this.hwk = true;
    Log.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.hwk);
    AppMethodBeat.o(129983);
  }
  
  public final int aGQ()
  {
    AppMethodBeat.i(129985);
    if (this.hwF > 0)
    {
      i = this.hwF;
      AppMethodBeat.o(129985);
      return i;
    }
    int i = AudioRecord.getMinBufferSize(this.mSampleRate, this.hwD, 2);
    Log.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", new Object[] { Integer.valueOf(i) });
    if ((i == -2) || (i == -1))
    {
      AppMethodBeat.o(129985);
      return 0;
    }
    this.hwF = (this.hwl * i);
    i = this.hwF;
    AppMethodBeat.o(129985);
    return i;
  }
  
  public final boolean aGR()
  {
    AppMethodBeat.i(129989);
    Log.i("MicroMsg.MMPcmRecorder", "startRecord");
    Object localObject = new rv();
    ((rv)localObject).hUT.type = 1;
    ((rv)localObject).hUT.hUV = true;
    ((rv)localObject).publish();
    this.hwp = System.currentTimeMillis();
    this.hwr = false;
    if (((rv)localObject).hUU.hUX)
    {
      Log.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
      this.hwc = 13;
      AppMethodBeat.o(129989);
      return false;
    }
    localObject = (AudioManager)MMApplicationContext.getContext().getSystemService("audio");
    if ((localObject != null) && (((AudioManager)localObject).isMicrophoneMute()))
    {
      Log.e("MicroMsg.MMPcmRecorder", "microphone is mute");
      this.hwc = 14;
      new ok().publish();
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(151L, 8L, 1L, false);
      com.tencent.mm.audio.c.b.a.oy(this.hwm);
      AppMethodBeat.o(129989);
      return false;
    }
    this.hwt = false;
    boolean bool = aGS();
    if (!bool)
    {
      aGH();
      localObject = new rw();
      ((rw)localObject).hUY.type = 1;
      ((rw)localObject).publish();
    }
    for (;;)
    {
      AppMethodBeat.o(129989);
      return bool;
      com.tencent.mm.audio.c.b.a.dt(this.hwm, this.hwx.getAudioSource());
    }
  }
  
  public final int aGT()
  {
    AppMethodBeat.i(236240);
    if (this.hwx != null)
    {
      int i = this.hwx.getAudioSource();
      AppMethodBeat.o(236240);
      return i;
    }
    AppMethodBeat.o(236240);
    return -1;
  }
  
  final void aGU()
  {
    AppMethodBeat.i(129992);
    if (this.hwy != null) {
      this.hwy.ds(this.hwE, this.hwc);
    }
    AppMethodBeat.o(129992);
  }
  
  public final int aGV()
  {
    AppMethodBeat.i(129993);
    if (this.hwz != null)
    {
      int i = this.hwz.aGV();
      AppMethodBeat.o(129993);
      return i;
    }
    AppMethodBeat.o(129993);
    return -1;
  }
  
  public final void eo(boolean paramBoolean)
  {
    AppMethodBeat.i(129982);
    this.hwj = paramBoolean;
    Log.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.hwj);
    AppMethodBeat.o(129982);
  }
  
  public final void ep(boolean paramBoolean)
  {
    AppMethodBeat.i(129986);
    this.hwo = paramBoolean;
    Log.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.hwo);
    AppMethodBeat.o(129986);
  }
  
  public final void eq(boolean paramBoolean)
  {
    AppMethodBeat.i(129988);
    this.hwC = paramBoolean;
    Log.i("MicroMsg.MMPcmRecorder", "switchMute mute:" + paramBoolean + ", mRecordMode=" + this.hwz);
    if (this.hwz != null) {
      this.hwz.eq(paramBoolean);
    }
    AppMethodBeat.o(129988);
  }
  
  public final void ok(int paramInt)
  {
    AppMethodBeat.i(129981);
    this.hwi = paramInt;
    Log.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.hwi);
    AppMethodBeat.o(129981);
  }
  
  public final void ol(int paramInt)
  {
    AppMethodBeat.i(236242);
    this.hwg = paramInt;
    Log.i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(236242);
  }
  
  public static abstract interface a
  {
    public abstract void ds(int paramInt1, int paramInt2);
    
    public abstract void u(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.b.c
 * JD-Core Version:    0.7.0.1
 */