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
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pk.b;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;

public final class c
{
  public int dyZ;
  public int dzA;
  private int dzB;
  public String dzC;
  private f.a dzD;
  int dza;
  int dzb;
  int dzc;
  public int dzd;
  private int dze;
  public int dzf;
  private boolean dzg;
  boolean dzh;
  private int dzi;
  int dzj;
  public int dzk;
  private boolean dzl;
  long dzm;
  int dzn;
  boolean dzo;
  int dzp;
  private boolean dzq;
  int dzr;
  boolean dzs;
  boolean dzt;
  private AudioRecord dzu;
  public a dzv;
  private f dzw;
  private com.tencent.mm.compatible.b.h dzx;
  com.tencent.mm.audio.e.b dzy;
  private int dzz;
  private int mSampleRate;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129980);
    this.dyZ = 0;
    this.dza = 0;
    this.dzb = 0;
    this.dzc = 0;
    this.dzd = 1;
    this.dze = 1;
    this.mSampleRate = 8000;
    this.dzf = 120;
    this.dzg = false;
    this.dzh = false;
    this.dzi = 10;
    this.dzj = -1;
    this.dzk = -123456789;
    this.dzl = false;
    this.dzm = -1L;
    this.dzo = false;
    this.dzq = false;
    this.dzr = 0;
    this.dzs = false;
    this.dzt = false;
    this.dzz = 16;
    this.dzA = 1;
    this.dzB = 0;
    this.dzD = new f.a()
    {
      public final void d(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(129979);
        c.this.dzr += 1;
        if ((c.this.dzt) && (System.currentTimeMillis() - c.this.dzm <= 1000L) && (c.this.dzr - 10 > (System.currentTimeMillis() - c.this.dzm) / c.this.dzf))
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 4L, 1L, false);
          Log.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[] { Integer.valueOf(c.this.dzr), Long.valueOf((System.currentTimeMillis() - c.this.dzm) / c.this.dzf) });
          c.this.dzs = true;
        }
        if (c.this.dzy != null) {
          c.this.dzy.A(paramAnonymousArrayOfByte, paramAnonymousInt);
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
          if ((!localc.dzo) || (-2 != localc.dzb))
          {
            m = paramAnonymousInt / localc.dzn;
            i = 5;
            if (i <= localc.dzp + m)
            {
              k = (i - localc.dzp - 1) * localc.dzn;
              n = localc.dzn + k;
              if (k >= 0)
              {
                j = k;
                if (n <= paramAnonymousInt) {
                  break label708;
                }
              }
              Log.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
            }
            localc.dzp = ((localc.dzp + m) % 5);
            if (localc.dzb == 20)
            {
              localc.dyZ = 6;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
              if ((localc.dza != -1) || (localc.dzc != -1)) {
                break label753;
              }
              localc.dyZ = 11;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              label382:
              if (com.tencent.mm.plugin.audio.c.a.cea().audioManager.isMicrophoneMute()) {
                com.tencent.mm.audio.c.b.a.js(localc.dzj);
              }
              if ((com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn()) || (com.tencent.mm.plugin.audio.c.a.cea().cdW())) {
                com.tencent.mm.audio.c.b.a.jt(localc.dzj);
              }
              Log.e("MicroMsg.MMPcmRecorder", "record is mute %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cea().audioManager.isMicrophoneMute()) });
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 5L, 1L, false);
              localc.dzb = -2;
              localc.aak();
            }
          }
        }
        if (c.this.dzh)
        {
          if (paramAnonymousInt > 0)
          {
            localc = c.this;
            if (localc.dza != -1)
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
                localc.dza += 1;
              }
              if (localc.dza > 100)
              {
                localc.dyZ = 7;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                if ((localc.dzb != -2) || (localc.dzc != -1)) {
                  break label816;
                }
                localc.dyZ = 11;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 6L, 1L, false);
              localc.aak();
              localc.dza = -1;
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
              localc.dzb = -1;
              localc.dzo = true;
              localc.dzb += 1;
              i += 5;
              break;
              label753:
              if (localc.dza == -1)
              {
                localc.dyZ = 8;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                break label382;
              }
              if (localc.dzc != -1) {
                break label382;
              }
              localc.dyZ = 9;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
              break label382;
              label805:
              i += 1;
              j = k;
              break label526;
              label816:
              if (localc.dzb == -2)
              {
                localc.dyZ = 8;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
              }
              else if (localc.dzc == -1)
              {
                localc.dyZ = 10;
                Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
              }
            }
          }
          paramAnonymousArrayOfByte = c.this;
          if ((paramAnonymousArrayOfByte.dzc != -1) && (paramAnonymousInt < 0))
          {
            paramAnonymousArrayOfByte.dzc += 1;
            if (paramAnonymousArrayOfByte.dzc >= 50)
            {
              paramAnonymousArrayOfByte.dyZ = 5;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
              if ((paramAnonymousArrayOfByte.dzb != -2) || (paramAnonymousArrayOfByte.dza != -1)) {
                break label988;
              }
              paramAnonymousArrayOfByte.dyZ = 11;
              Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 7L, 1L, false);
          paramAnonymousArrayOfByte.aak();
          paramAnonymousArrayOfByte.dzc = -1;
          AppMethodBeat.o(129979);
          return;
          label988:
          if (paramAnonymousArrayOfByte.dzb == -2)
          {
            paramAnonymousArrayOfByte.dyZ = 9;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
          }
          else if (paramAnonymousArrayOfByte.dza == -1)
          {
            paramAnonymousArrayOfByte.dyZ = 10;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
          }
        }
      }
    };
    this.dze = paramInt2;
    this.mSampleRate = paramInt1;
    this.dzj = paramInt3;
    if (this.dze == 2)
    {
      this.dzz = 12;
      if ((this.dzj == 0) && (ae.gKE.gGD > 0)) {
        this.dzf = ae.gKE.gGD;
      }
      if (ae.gKE.gGO > 0) {
        this.dzz = ae.gKE.gGO;
      }
      if (ae.gKE.gGy > 0) {
        this.dzi = ae.gKE.gGy;
      }
      if (ae.gKu.gEj) {
        this.dzy = new com.tencent.mm.audio.e.b(g.dAa, this.dze, this.mSampleRate);
      }
      if (1 != g.B("EnableRecorderCheckUnreasonableData", 1)) {
        break label363;
      }
    }
    label363:
    for (boolean bool = true;; bool = false)
    {
      this.dzt = bool;
      Log.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[] { Integer.valueOf(this.mSampleRate), Integer.valueOf(this.dze), Integer.valueOf(this.dzf), Boolean.valueOf(this.dzg), Integer.valueOf(this.dzj) });
      AppMethodBeat.o(129980);
      return;
      this.dzz = 16;
      break;
    }
  }
  
  private boolean aaj()
  {
    AppMethodBeat.i(129990);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    Log.i("MicroMsg.MMPcmRecorder", "startRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
    if (this.dzu != null)
    {
      com.tencent.mm.audio.c.b.a.jw(this.dzj);
      Log.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
      AppMethodBeat.o(129990);
      return false;
    }
    locala.gLm = SystemClock.elapsedRealtime();
    Log.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
    if (!init())
    {
      Log.e("MicroMsg.MMPcmRecorder", "startRecord init error");
      AppMethodBeat.o(129990);
      return false;
    }
    Log.i("MicroMsg.MMPcmRecorder", "init cost: " + locala.apr() + "ms");
    locala.gLm = SystemClock.elapsedRealtime();
    try
    {
      this.dzu.startRecording();
      Log.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + locala.apr());
      if (this.dzu.getRecordingState() != 3)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 3L, 1L, false);
        this.dzA = 2;
        this.dyZ = 4;
        Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
        aak();
        com.tencent.mm.audio.c.b.a.jq(this.dzj);
        AppMethodBeat.o(129990);
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMPcmRecorder", "start error cause permission deny");
      this.dzA = 2;
      this.dyZ = 4;
      Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
      aak();
      com.tencent.mm.audio.c.b.a.jq(this.dzj);
      AppMethodBeat.o(129990);
      return false;
    }
    if (this.dzw != null)
    {
      boolean bool = this.dzw.aai();
      AppMethodBeat.o(129990);
      return bool;
    }
    Log.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
    com.tencent.mm.audio.c.b.a.jp(this.dzj);
    AppMethodBeat.o(129990);
    return false;
  }
  
  private boolean init()
  {
    AppMethodBeat.i(129987);
    com.tencent.mm.plugin.audio.c.a.cea();
    com.tencent.mm.plugin.audio.b.a.cdT();
    this.dzA = 1;
    boolean bool1;
    if (ae.gKE.gGz == 2)
    {
      bool1 = false;
      i = m.aon();
      j = ae.gKu.gEL;
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
      m = AudioRecord.getMinBufferSize(this.mSampleRate, this.dzz, 2);
      if ((m != -2) && (m != -1)) {
        break label176;
      }
      this.dzA = 3;
      this.dyZ = 1;
      Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR ".concat(String.valueOf(m)));
      aak();
      com.tencent.mm.audio.c.b.a.jv(this.dzj);
      AppMethodBeat.o(129987);
      return false;
      bool1 = true;
      break;
      i = 1;
      break label73;
    }
    label176:
    Log.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[] { Integer.valueOf(m) });
    this.dzn = (this.mSampleRate * 20 * this.dze * 2 / 1000);
    int n = this.mSampleRate * this.dzf * this.dze / 1000;
    int i1 = n * 2;
    Log.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mSampleRate), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.dzi), Boolean.valueOf(bool1) });
    int i2 = this.dzj;
    int j = this.dzd;
    if ((1 == i2) || (6 == i2) || (7 == i2)) {
      if (Build.VERSION.SDK_INT < 11)
      {
        i = 1;
        if (ae.gKu.gDA) {
          i = 1;
        }
        if (ae.gKu.gEd >= 0) {
          i = ae.gKu.gEd;
        }
        j = i;
        if (6 != i2) {
          break label1378;
        }
        j = i;
        if (ae.gKu.gEV < 0) {
          break label1378;
        }
      }
    }
    label792:
    label860:
    label1378:
    for (int i = ae.gKu.gEV;; i = j)
    {
      for (;;)
      {
        Log.i("MicroMsg.MMPcmRecorder", "init audio source: %s", new Object[] { Integer.valueOf(i) });
        try
        {
          this.dzu = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.dzz, this.dzi * m);
          if (this.dzu.getState() == 0)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 2L, 1L, false);
            this.dzu.release();
            this.dyZ = 2;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
            if (7 == i)
            {
              i = 1;
              this.dzu = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.dzz, this.dzi * m);
            }
          }
          else
          {
            if (this.dzu.getState() != 0) {
              break label792;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 2L, 1L, false);
            this.dzu.release();
            this.dzu = null;
            this.dzA = 2;
            this.dyZ = 3;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
            aak();
            com.tencent.mm.audio.c.b.a.jr(this.dzj);
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
            this.dyZ = 12;
            Log.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            Log.printErrStackTrace("MicroMsg.MMPcmRecorder", localException1, "", new Object[0]);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 1L, 1L, false);
            com.tencent.mm.audio.c.b.a.cm(this.dzj, i);
            if (7 == i) {}
            for (i = 1;; i = 7) {
              try
              {
                this.dzu = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.dzz, this.dzi * m);
                com.tencent.mm.audio.c.b.a.co(this.dzj, i);
              }
              catch (Exception localException2)
              {
                com.tencent.mm.audio.c.b.a.cm(this.dzj, i);
                com.tencent.mm.audio.c.b.a.cn(this.dzj, i);
                com.tencent.mm.audio.c.b.a.jr(this.dzj);
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
        localObject1 = this.dzu;
        boolean bool2 = this.dzg;
        localObject2 = this.dzv;
        if (((this.dzj == 1) || (this.dzj == 6)) && (k != 0))
        {
          bool1 = true;
          this.dzw = new e((AudioRecord)localObject1, bool2, i1, (a)localObject2, bool1);
          this.dzw.a(this.dzD);
          if (-123456789 != this.dzk) {
            this.dzw.jl(this.dzk);
          }
          if (this.dzl)
          {
            this.dzx = new com.tencent.mm.compatible.b.h();
            localObject1 = this.dzx;
            localObject2 = this.dzu;
            i = this.dzj;
            Log.d("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
            if (!com.tencent.mm.compatible.util.d.oE(16))
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
        this.dzw = new d(this.dzu, this.dzv, this.dzg, n, i1);
        break label860;
        label1017:
        if (1 == i)
        {
          if (ae.gKE.gHg != 1)
          {
            Log.d("MicroMsg.MMAudioPreProcess", "disable by config");
          }
          else
          {
            if (ae.gKE.gHh != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).gDj = new j((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).gDj != null) && (((com.tencent.mm.compatible.b.h)localObject1).gDj.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).gDj.anE();
              }
            }
            if (ae.gKE.gHi != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).gDk = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).gDk != null) && (((com.tencent.mm.compatible.b.h)localObject1).gDk.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).gDk.anE();
              }
            }
            if (ae.gKE.gHj != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).gDl = new i((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).gDl != null) && (((com.tencent.mm.compatible.b.h)localObject1).gDl.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).gDl.anE();
              }
            }
          }
        }
        else if (ae.gKE.gGC != 1)
        {
          Log.d("MicroMsg.MMAudioPreProcess", "disable by config");
        }
        else
        {
          ((com.tencent.mm.compatible.b.h)localObject1).gDj = new j((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).gDj != null) && (((com.tencent.mm.compatible.b.h)localObject1).gDj.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).gDj.anE();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).gDk = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).gDk != null) && (((com.tencent.mm.compatible.b.h)localObject1).gDk.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).gDk.anE();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).gDl = new i((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).gDl != null) && (((com.tencent.mm.compatible.b.h)localObject1).gDl.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).gDl.anE();
          }
        }
      }
    }
  }
  
  public final boolean ZZ()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(129991);
        if (true == this.dzq)
        {
          Log.i("MicroMsg.MMPcmRecorder", "already have stopped");
          AppMethodBeat.o(129991);
          bool1 = true;
          return bool1;
        }
        this.dzq = true;
        Object localObject1 = new com.tencent.mm.compatible.util.f.a();
        if (this.dzy != null)
        {
          this.dzy.closeFile();
          this.dzy = null;
        }
        ((com.tencent.mm.compatible.util.f.a)localObject1).gLm = SystemClock.elapsedRealtime();
        if (this.dzw != null)
        {
          this.dzw.stopRecord();
          this.dzw = null;
        }
        Log.i("MicroMsg.MMPcmRecorder", "cost " + ((com.tencent.mm.compatible.util.f.a)localObject1).apr() + "ms to call stopRecord");
        Log.i("MicroMsg.MMPcmRecorder", "stopRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.dzu == null)
        {
          Log.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
          bool1 = false;
          if (((!this.dzo) && (-1L != this.dzm) && (System.currentTimeMillis() - this.dzm >= 2000L)) || (this.dzs))
          {
            Log.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
            localObject1 = new pl();
            ((pl)localObject1).dVC.type = 1;
            EventCenter.instance.publish((IEvent)localObject1);
            bool2 = false;
          }
          localObject1 = new pk();
          ((pk)localObject1).dVx.type = 1;
          ((pk)localObject1).dVx.dVz = false;
          ((pk)localObject1).dVx.dVA = bool2;
          EventCenter.instance.publish((IEvent)localObject1);
          Log.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[] { Integer.valueOf(this.dyZ) });
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(new IDKey(357, 0, 1));
          if (this.dyZ != 0) {
            ((ArrayList)localObject1).add(new IDKey(357, 1, 1));
          }
        }
        switch (this.dyZ)
        {
        case 1: 
          Log.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
          com.tencent.mm.plugin.report.service.h.CyF.b((ArrayList)localObject1, false);
          AppMethodBeat.o(129991);
          continue;
          if (this.dzu.getState() == 1) {
            break label516;
          }
        }
      }
      finally {}
      Log.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.dzu.getState());
      boolean bool1 = false;
      continue;
      label516:
      if (this.dzC != null)
      {
        if (this.dzj != 0) {
          break label630;
        }
        com.tencent.mm.audio.c.b.a.a(0, this.dzC, this.dzd, this.mSampleRate, this.dzz, this.dyZ);
        com.tencent.mm.audio.c.b.a.jz(this.dzj);
        com.tencent.mm.audio.c.b.a.jy(this.dzj);
      }
      for (;;)
      {
        localObject2.gLm = SystemClock.elapsedRealtime();
        this.dzu.stop();
        this.dzu.release();
        this.dzu = null;
        Log.i("MicroMsg.MMPcmRecorder", "cost " + localObject2.apr() + "ms to call stop and release");
        bool1 = true;
        break;
        label630:
        if (this.dzj == 1)
        {
          com.tencent.mm.audio.c.b.a.a(1, this.dzC, this.dzd, this.mSampleRate, this.dzz, this.dyZ);
          com.tencent.mm.audio.c.b.a.jz(this.dzj);
          com.tencent.mm.audio.c.b.a.jy(this.dzj);
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
  
  public final void a(a parama)
  {
    this.dzv = parama;
  }
  
  public final void aag()
  {
    AppMethodBeat.i(129983);
    this.dzh = true;
    Log.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.dzh);
    AppMethodBeat.o(129983);
  }
  
  public final int aah()
  {
    AppMethodBeat.i(129985);
    if (this.dzB > 0)
    {
      i = this.dzB;
      AppMethodBeat.o(129985);
      return i;
    }
    int i = AudioRecord.getMinBufferSize(this.mSampleRate, this.dzz, 2);
    Log.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", new Object[] { Integer.valueOf(i) });
    if ((i == -2) || (i == -1))
    {
      AppMethodBeat.o(129985);
      return 0;
    }
    this.dzB = (this.dzi * i);
    i = this.dzB;
    AppMethodBeat.o(129985);
    return i;
  }
  
  public final boolean aai()
  {
    AppMethodBeat.i(129989);
    Log.i("MicroMsg.MMPcmRecorder", "startRecord");
    Object localObject = new pk();
    ((pk)localObject).dVx.type = 1;
    ((pk)localObject).dVx.dVz = true;
    EventCenter.instance.publish((IEvent)localObject);
    this.dzm = System.currentTimeMillis();
    this.dzo = false;
    if (((pk)localObject).dVy.dVB)
    {
      Log.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
      this.dyZ = 13;
      AppMethodBeat.o(129989);
      return false;
    }
    localObject = (AudioManager)MMApplicationContext.getContext().getSystemService("audio");
    if ((localObject != null) && (((AudioManager)localObject).isMicrophoneMute()))
    {
      Log.e("MicroMsg.MMPcmRecorder", "microphone is mute");
      this.dyZ = 14;
      localObject = new mm();
      EventCenter.instance.publish((IEvent)localObject);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(151L, 8L, 1L, false);
      com.tencent.mm.audio.c.b.a.jx(this.dzj);
      AppMethodBeat.o(129989);
      return false;
    }
    this.dzq = false;
    boolean bool = aaj();
    if (!bool)
    {
      ZZ();
      localObject = new pl();
      ((pl)localObject).dVC.type = 1;
      EventCenter.instance.publish((IEvent)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(129989);
      return bool;
      com.tencent.mm.audio.c.b.a.cl(this.dzj, this.dzu.getAudioSource());
    }
  }
  
  final void aak()
  {
    AppMethodBeat.i(129992);
    if (this.dzv != null) {
      this.dzv.cj(this.dzA, this.dyZ);
    }
    AppMethodBeat.o(129992);
  }
  
  public final int aal()
  {
    AppMethodBeat.i(129993);
    if (this.dzw != null)
    {
      int i = this.dzw.aal();
      AppMethodBeat.o(129993);
      return i;
    }
    AppMethodBeat.o(129993);
    return -1;
  }
  
  public final void dc(boolean paramBoolean)
  {
    AppMethodBeat.i(129982);
    this.dzg = paramBoolean;
    Log.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.dzg);
    AppMethodBeat.o(129982);
  }
  
  public final void dd(boolean paramBoolean)
  {
    AppMethodBeat.i(129986);
    this.dzl = paramBoolean;
    Log.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.dzl);
    AppMethodBeat.o(129986);
  }
  
  public final void de(boolean paramBoolean)
  {
    AppMethodBeat.i(129988);
    Log.i("MicroMsg.MMPcmRecorder", "switchMute mute:".concat(String.valueOf(paramBoolean)));
    if (this.dzw != null) {
      this.dzw.de(paramBoolean);
    }
    AppMethodBeat.o(129988);
  }
  
  public final void jk(int paramInt)
  {
    AppMethodBeat.i(129981);
    this.dzf = paramInt;
    Log.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.dzf);
    AppMethodBeat.o(129981);
  }
  
  public final void setAudioSource(int paramInt)
  {
    AppMethodBeat.i(200986);
    this.dzd = paramInt;
    Log.i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(200986);
  }
  
  public final void x(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129984);
    if ((10 == this.dzi) || (paramBoolean))
    {
      this.dzi = paramInt;
      Log.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.dzi);
    }
    AppMethodBeat.o(129984);
  }
  
  public static abstract interface a
  {
    public abstract void cj(int paramInt1, int paramInt2);
    
    public abstract void w(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.c
 * JD-Core Version:    0.7.0.1
 */