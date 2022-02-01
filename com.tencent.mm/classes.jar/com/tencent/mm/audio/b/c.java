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
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.os.b;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

public final class c
{
  public int dhN;
  int dhO;
  int dhP;
  int dhQ;
  public int dhR;
  private int dhS;
  public int dhT;
  private boolean dhU;
  boolean dhV;
  private int dhW;
  int dhX;
  public int dhY;
  private boolean dhZ;
  long dia;
  int dib;
  boolean dic;
  int did;
  private boolean die;
  int dif;
  boolean dig;
  boolean dih;
  private AudioRecord dii;
  public c.a dij;
  private f dik;
  private h dil;
  com.tencent.mm.audio.e.b dim;
  private int din;
  public int dio;
  private int dip;
  public String diq;
  private f.a dis;
  private int mSampleRate;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129980);
    this.dhN = 0;
    this.dhO = 0;
    this.dhP = 0;
    this.dhQ = 0;
    this.dhR = 1;
    this.dhS = 1;
    this.mSampleRate = 8000;
    this.dhT = 120;
    this.dhU = false;
    this.dhV = false;
    this.dhW = 10;
    this.dhX = -1;
    this.dhY = -123456789;
    this.dhZ = false;
    this.dia = -1L;
    this.dic = false;
    this.die = false;
    this.dif = 0;
    this.dig = false;
    this.dih = false;
    this.din = 16;
    this.dio = 1;
    this.dip = 0;
    this.dis = new f.a()
    {
      public final void d(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(129979);
        c.this.dif += 1;
        if ((c.this.dih) && (System.currentTimeMillis() - c.this.dia <= 1000L) && (c.this.dif - 10 > (System.currentTimeMillis() - c.this.dia) / c.this.dhT))
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 4L, 1L, false);
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[] { Integer.valueOf(c.this.dif), Long.valueOf((System.currentTimeMillis() - c.this.dia) / c.this.dhT) });
          c.this.dig = true;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "params has been set mChkDataCnt is %s ,mStartMillSec is %s,mAudioFrameCnt is %s,mDurationPreFrame is %s", new Object[] { Boolean.valueOf(c.this.dih), Long.valueOf(c.this.dia), Integer.valueOf(c.this.dif), Integer.valueOf(c.this.dhT) });
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "value has been return %s, and buf length is %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousArrayOfByte.length) });
        if (c.this.dim != null) {
          c.this.dim.y(paramAnonymousArrayOfByte, paramAnonymousInt);
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
          if ((!localc.dic) || (-2 != localc.dhP))
          {
            m = paramAnonymousInt / localc.dib;
            i = 5;
            if (i <= localc.did + m)
            {
              k = (i - localc.did - 1) * localc.dib;
              n = localc.dib + k;
              if (k >= 0)
              {
                j = k;
                if (n <= paramAnonymousInt) {
                  break label797;
                }
              }
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
            }
            localc.did = ((localc.did + m) % 5);
            if (localc.dhP == 20)
            {
              localc.dhN = 6;
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
              if ((localc.dhO != -1) || (localc.dhQ != -1)) {
                break label842;
              }
              localc.dhN = 11;
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              label471:
              if (com.tencent.mm.plugin.audio.c.a.bHy().audioManager.isMicrophoneMute()) {
                com.tencent.mm.audio.c.b.a.hY(localc.dhX);
              }
              if ((com.tencent.mm.plugin.audio.c.a.bHy().isBluetoothScoOn()) || (com.tencent.mm.plugin.audio.c.a.bHy().bHt())) {
                com.tencent.mm.audio.c.b.a.hZ(localc.dhX);
              }
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "record is mute %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bHy().audioManager.isMicrophoneMute()) });
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 5L, 1L, false);
              localc.dhP = -2;
              localc.PQ();
            }
          }
        }
        if (c.this.dhV)
        {
          if (paramAnonymousInt > 0)
          {
            localc = c.this;
            if (localc.dhO != -1)
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
                localc.dhO += 1;
              }
              if (localc.dhO > 100)
              {
                localc.dhN = 7;
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                if ((localc.dhP != -2) || (localc.dhQ != -1)) {
                  break label905;
                }
                localc.dhN = 11;
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 6L, 1L, false);
              localc.PQ();
              localc.dhO = -1;
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
              localc.dhP = -1;
              localc.dic = true;
              localc.dhP += 1;
              i += 5;
              break;
              label842:
              if (localc.dhO == -1)
              {
                localc.dhN = 8;
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                break label471;
              }
              if (localc.dhQ != -1) {
                break label471;
              }
              localc.dhN = 9;
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
              break label471;
              label894:
              i += 1;
              j = k;
              break label615;
              label905:
              if (localc.dhP == -2)
              {
                localc.dhN = 8;
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
              }
              else if (localc.dhQ == -1)
              {
                localc.dhN = 10;
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
              }
            }
          }
          paramAnonymousArrayOfByte = c.this;
          if ((paramAnonymousArrayOfByte.dhQ != -1) && (paramAnonymousInt < 0))
          {
            paramAnonymousArrayOfByte.dhQ += 1;
            if (paramAnonymousArrayOfByte.dhQ >= 50)
            {
              paramAnonymousArrayOfByte.dhN = 5;
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
              if ((paramAnonymousArrayOfByte.dhP != -2) || (paramAnonymousArrayOfByte.dhO != -1)) {
                break label1077;
              }
              paramAnonymousArrayOfByte.dhN = 11;
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 7L, 1L, false);
          paramAnonymousArrayOfByte.PQ();
          paramAnonymousArrayOfByte.dhQ = -1;
          AppMethodBeat.o(129979);
          return;
          label1077:
          if (paramAnonymousArrayOfByte.dhP == -2)
          {
            paramAnonymousArrayOfByte.dhN = 9;
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
          }
          else if (paramAnonymousArrayOfByte.dhO == -1)
          {
            paramAnonymousArrayOfByte.dhN = 10;
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
          }
        }
      }
    };
    this.dhS = paramInt2;
    this.mSampleRate = paramInt1;
    this.dhX = paramInt3;
    if (this.dhS == 2)
    {
      this.din = 12;
      if ((this.dhX == 0) && (com.tencent.mm.compatible.deviceinfo.ae.geX.gbl > 0)) {
        this.dhT = com.tencent.mm.compatible.deviceinfo.ae.geX.gbl;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geX.gbw > 0) {
        this.din = com.tencent.mm.compatible.deviceinfo.ae.geX.gbw;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geX.gbg > 0) {
        this.dhW = com.tencent.mm.compatible.deviceinfo.ae.geX.gbg;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYS) {
        this.dim = new com.tencent.mm.audio.e.b(g.diP, this.dhS, this.mSampleRate);
      }
      if (1 != g.A("EnableRecorderCheckUnreasonableData", 1)) {
        break label363;
      }
    }
    label363:
    for (boolean bool = true;; bool = false)
    {
      this.dih = bool;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[] { Integer.valueOf(this.mSampleRate), Integer.valueOf(this.dhS), Integer.valueOf(this.dhT), Boolean.valueOf(this.dhU), Integer.valueOf(this.dhX) });
      AppMethodBeat.o(129980);
      return;
      this.din = 16;
      break;
    }
  }
  
  private boolean PP()
  {
    AppMethodBeat.i(129990);
    com.tencent.mm.compatible.util.f.a locala = new com.tencent.mm.compatible.util.f.a();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "startRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
    if (this.dii != null)
    {
      com.tencent.mm.audio.c.b.a.ic(this.dhX);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
      AppMethodBeat.o(129990);
      return false;
    }
    locala.gfF = SystemClock.elapsedRealtime();
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
    if (!init())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "startRecord init error");
      AppMethodBeat.o(129990);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "init cost: " + locala.abs() + "ms");
    locala.gfF = SystemClock.elapsedRealtime();
    try
    {
      this.dii.startRecording();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + locala.abs());
      if (this.dii.getRecordingState() != 3)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 3L, 1L, false);
        this.dio = 2;
        this.dhN = 4;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
        PQ();
        com.tencent.mm.audio.c.b.a.hW(this.dhX);
        AppMethodBeat.o(129990);
        return false;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "start error cause permission deny");
      this.dio = 2;
      this.dhN = 4;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
      PQ();
      com.tencent.mm.audio.c.b.a.hW(this.dhX);
      AppMethodBeat.o(129990);
      return false;
    }
    if (this.dik != null)
    {
      boolean bool = this.dik.PO();
      AppMethodBeat.o(129990);
      return bool;
    }
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
    com.tencent.mm.audio.c.b.a.hV(this.dhX);
    AppMethodBeat.o(129990);
    return false;
  }
  
  private boolean init()
  {
    AppMethodBeat.i(129987);
    com.tencent.mm.plugin.audio.c.a.bHy();
    com.tencent.mm.plugin.audio.b.a.bHq();
    this.dio = 1;
    boolean bool1;
    if (com.tencent.mm.compatible.deviceinfo.ae.geX.gbh == 2)
    {
      bool1 = false;
      i = m.aao();
      j = com.tencent.mm.compatible.deviceinfo.ae.geN.fZu;
      if ((i & 0x400) == 0) {
        break label166;
      }
      i = j;
      if (j <= 0) {
        i = 0;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: ".concat(String.valueOf(i)));
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
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
      m = AudioRecord.getMinBufferSize(this.mSampleRate, this.din, 2);
      if ((m != -2) && (m != -1)) {
        break label176;
      }
      this.dio = 3;
      this.dhN = 1;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR ".concat(String.valueOf(m)));
      PQ();
      com.tencent.mm.audio.c.b.a.ib(this.dhX);
      AppMethodBeat.o(129987);
      return false;
      bool1 = true;
      break;
      i = 1;
      break label73;
    }
    label176:
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[] { Integer.valueOf(m) });
    this.dib = (this.mSampleRate * 20 * this.dhS * 2 / 1000);
    int n = this.mSampleRate * this.dhT * this.dhS / 1000;
    int i1 = n * 2;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mSampleRate), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.dhW), Boolean.valueOf(bool1) });
    int i2 = this.dhX;
    int j = this.dhR;
    if ((1 == i2) || (6 == i2) || (7 == i2)) {
      if (Build.VERSION.SDK_INT < 11)
      {
        i = 1;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYn) {
          i = 1;
        }
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYM >= 0) {
          i = com.tencent.mm.compatible.deviceinfo.ae.geN.fYM;
        }
        j = i;
        if (6 != i2) {
          break label1378;
        }
        j = i;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZE < 0) {
          break label1378;
        }
      }
    }
    label792:
    label860:
    label1378:
    for (int i = com.tencent.mm.compatible.deviceinfo.ae.geN.fZE;; i = j)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "init audio source: %s", new Object[] { Integer.valueOf(i) });
        try
        {
          this.dii = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.din, this.dhW * m);
          if (this.dii.getState() == 0)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 2L, 1L, false);
            this.dii.release();
            this.dhN = 2;
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
            if (7 == i)
            {
              i = 1;
              this.dii = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.din, this.dhW * m);
            }
          }
          else
          {
            if (this.dii.getState() != 0) {
              break label792;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 2L, 1L, false);
            this.dii.release();
            this.dii = null;
            this.dio = 2;
            this.dhN = 3;
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
            PQ();
            com.tencent.mm.audio.c.b.a.hX(this.dhX);
            AppMethodBeat.o(129987);
            return false;
            i = 7;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.dhN = 12;
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMPcmRecorder", localException1, "", new Object[0]);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 1L, 1L, false);
            com.tencent.mm.audio.c.b.a.ck(this.dhX, i);
            if (7 == i) {}
            for (i = 1;; i = 7) {
              try
              {
                this.dii = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.din, this.dhW * m);
                com.tencent.mm.audio.c.b.a.cm(this.dhX, i);
              }
              catch (Exception localException2)
              {
                com.tencent.mm.audio.c.b.a.ck(this.dhX, i);
                com.tencent.mm.audio.c.b.a.cl(this.dhX, i);
                com.tencent.mm.audio.c.b.a.hX(this.dhX);
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
        localObject1 = this.dii;
        boolean bool2 = this.dhU;
        localObject2 = this.dij;
        if (((this.dhX == 1) || (this.dhX == 6)) && (k != 0))
        {
          bool1 = true;
          this.dik = new e((AudioRecord)localObject1, bool2, i1, (c.a)localObject2, bool1);
          this.dik.a(this.dis);
          if (-123456789 != this.dhY) {
            this.dik.hR(this.dhY);
          }
          if (this.dhZ)
          {
            this.dil = new h();
            localObject1 = this.dil;
            localObject2 = this.dii;
            i = this.dhX;
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
            if (!com.tencent.mm.compatible.util.d.lB(16))
            {
              if (localObject2 != null) {
                break label1017;
              }
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMAudioPreProcess", "audio is null");
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
        this.dik = new d(this.dii, this.dij, this.dhU, n, i1);
        break label860;
        label1017:
        if (1 == i)
        {
          if (com.tencent.mm.compatible.deviceinfo.ae.geX.gbN != 1)
          {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMAudioPreProcess", "disable by config");
          }
          else
          {
            if (com.tencent.mm.compatible.deviceinfo.ae.geX.gbO != 2)
            {
              ((h)localObject1).fYd = new j((AudioRecord)localObject2);
              if ((((h)localObject1).fYd != null) && (((h)localObject1).fYd.isAvailable())) {
                ((h)localObject1).fYd.ZR();
              }
            }
            if (com.tencent.mm.compatible.deviceinfo.ae.geX.gbP != 2)
            {
              ((h)localObject1).fYe = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
              if ((((h)localObject1).fYe != null) && (((h)localObject1).fYe.isAvailable())) {
                ((h)localObject1).fYe.ZR();
              }
            }
            if (com.tencent.mm.compatible.deviceinfo.ae.geX.gbQ != 2)
            {
              ((h)localObject1).fYf = new i((AudioRecord)localObject2);
              if ((((h)localObject1).fYf != null) && (((h)localObject1).fYf.isAvailable())) {
                ((h)localObject1).fYf.ZR();
              }
            }
          }
        }
        else if (com.tencent.mm.compatible.deviceinfo.ae.geX.gbk != 1)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMAudioPreProcess", "disable by config");
        }
        else
        {
          ((h)localObject1).fYd = new j((AudioRecord)localObject2);
          if ((((h)localObject1).fYd != null) && (((h)localObject1).fYd.isAvailable())) {
            ((h)localObject1).fYd.ZR();
          }
          ((h)localObject1).fYe = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
          if ((((h)localObject1).fYe != null) && (((h)localObject1).fYe.isAvailable())) {
            ((h)localObject1).fYe.ZR();
          }
          ((h)localObject1).fYf = new i((AudioRecord)localObject2);
          if ((((h)localObject1).fYf != null) && (((h)localObject1).fYf.isAvailable())) {
            ((h)localObject1).fYf.ZR();
          }
        }
      }
    }
  }
  
  public final boolean PF()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(129991);
        if (true == this.die)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "already have stopped");
          AppMethodBeat.o(129991);
          bool1 = true;
          return bool1;
        }
        this.die = true;
        Object localObject1 = new com.tencent.mm.compatible.util.f.a();
        if (this.dim != null)
        {
          this.dim.closeFile();
          this.dim = null;
        }
        ((com.tencent.mm.compatible.util.f.a)localObject1).gfF = SystemClock.elapsedRealtime();
        if (this.dik != null)
        {
          this.dik.stopRecord();
          this.dik = null;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "cost " + ((com.tencent.mm.compatible.util.f.a)localObject1).abs() + "ms to call stopRecord");
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "stopRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.dii == null)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
          bool1 = false;
          if (((!this.dic) && (-1L != this.dia) && (System.currentTimeMillis() - this.dia >= 2000L)) || (this.dig))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
            localObject1 = new ot();
            ((ot)localObject1).dDO.type = 1;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
            bool2 = false;
          }
          localObject1 = new os();
          ((os)localObject1).dDJ.type = 1;
          ((os)localObject1).dDJ.dDL = false;
          ((os)localObject1).dDJ.dDM = bool2;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[] { Integer.valueOf(this.dhN) });
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(new IDKey(357, 0, 1));
          if (this.dhN != 0) {
            ((ArrayList)localObject1).add(new IDKey(357, 1, 1));
          }
        }
        switch (this.dhN)
        {
        case 1: 
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
          com.tencent.mm.plugin.report.service.g.yxI.b((ArrayList)localObject1, false);
          AppMethodBeat.o(129991);
          continue;
          if (this.dii.getState() == 1) {
            break label516;
          }
        }
      }
      finally {}
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.dii.getState());
      boolean bool1 = false;
      continue;
      label516:
      if (this.diq != null)
      {
        if (this.dhX != 0) {
          break label630;
        }
        com.tencent.mm.audio.c.b.a.a(0, this.diq, this.dhR, this.mSampleRate, this.din, this.dhN);
        com.tencent.mm.audio.c.b.a.jdMethod_if(this.dhX);
        com.tencent.mm.audio.c.b.a.ie(this.dhX);
      }
      for (;;)
      {
        localObject2.gfF = SystemClock.elapsedRealtime();
        this.dii.stop();
        this.dii.release();
        this.dii = null;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "cost " + localObject2.abs() + "ms to call stop and release");
        bool1 = true;
        break;
        label630:
        if (this.dhX == 1)
        {
          com.tencent.mm.audio.c.b.a.a(1, this.diq, this.dhR, this.mSampleRate, this.din, this.dhN);
          com.tencent.mm.audio.c.b.a.jdMethod_if(this.dhX);
          com.tencent.mm.audio.c.b.a.ie(this.dhX);
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
  
  public final void PM()
  {
    AppMethodBeat.i(129983);
    this.dhV = true;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.dhV);
    AppMethodBeat.o(129983);
  }
  
  public final int PN()
  {
    AppMethodBeat.i(129985);
    if (this.dip > 0)
    {
      i = this.dip;
      AppMethodBeat.o(129985);
      return i;
    }
    int i = AudioRecord.getMinBufferSize(this.mSampleRate, this.din, 2);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", new Object[] { Integer.valueOf(i) });
    if ((i == -2) || (i == -1))
    {
      AppMethodBeat.o(129985);
      return 0;
    }
    this.dip = (this.dhW * i);
    i = this.dip;
    AppMethodBeat.o(129985);
    return i;
  }
  
  public final boolean PO()
  {
    AppMethodBeat.i(129989);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "startRecord");
    Object localObject = new os();
    ((os)localObject).dDJ.type = 1;
    ((os)localObject).dDJ.dDL = true;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    this.dia = System.currentTimeMillis();
    this.dic = false;
    if (((os)localObject).dDK.dDN)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
      this.dhN = 13;
      AppMethodBeat.o(129989);
      return false;
    }
    localObject = (AudioManager)ak.getContext().getSystemService("audio");
    if ((localObject != null) && (((AudioManager)localObject).isMicrophoneMute()))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMPcmRecorder", "microphone is mute");
      this.dhN = 14;
      localObject = new lw();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(151L, 8L, 1L, false);
      com.tencent.mm.audio.c.b.a.id(this.dhX);
      AppMethodBeat.o(129989);
      return false;
    }
    this.die = false;
    boolean bool = PP();
    if (!bool)
    {
      PF();
      localObject = new ot();
      ((ot)localObject).dDO.type = 1;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(129989);
      return bool;
      com.tencent.mm.audio.c.b.a.cj(this.dhX, this.dii.getAudioSource());
    }
  }
  
  final void PQ()
  {
    AppMethodBeat.i(129992);
    if (this.dij != null) {
      this.dij.ch(this.dio, this.dhN);
    }
    AppMethodBeat.o(129992);
  }
  
  public final int PR()
  {
    AppMethodBeat.i(129993);
    if (this.dik != null)
    {
      int i = this.dik.PR();
      AppMethodBeat.o(129993);
      return i;
    }
    AppMethodBeat.o(129993);
    return -1;
  }
  
  public final void a(c.a parama)
  {
    this.dij = parama;
  }
  
  public final void cu(boolean paramBoolean)
  {
    AppMethodBeat.i(129982);
    this.dhU = paramBoolean;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.dhU);
    AppMethodBeat.o(129982);
  }
  
  public final void cv(boolean paramBoolean)
  {
    AppMethodBeat.i(129986);
    this.dhZ = paramBoolean;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.dhZ);
    AppMethodBeat.o(129986);
  }
  
  public final void cw(boolean paramBoolean)
  {
    AppMethodBeat.i(129988);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "switchMute mute:".concat(String.valueOf(paramBoolean)));
    if (this.dik != null) {
      this.dik.cw(paramBoolean);
    }
    AppMethodBeat.o(129988);
  }
  
  public final void hQ(int paramInt)
  {
    AppMethodBeat.i(129981);
    this.dhT = paramInt;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.dhT);
    AppMethodBeat.o(129981);
  }
  
  public final void setAudioSource(int paramInt)
  {
    AppMethodBeat.i(208172);
    this.dhR = paramInt;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(208172);
  }
  
  public final void t(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129984);
    if ((10 == this.dhW) || (paramBoolean))
    {
      this.dhW = paramInt;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.dhW);
    }
    AppMethodBeat.o(129984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.c
 * JD-Core Version:    0.7.0.1
 */