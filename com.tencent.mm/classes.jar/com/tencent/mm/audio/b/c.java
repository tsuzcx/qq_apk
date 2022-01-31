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
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.a.mn.b;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;

public final class c
{
  boolean cjA;
  boolean cjB;
  private AudioRecord cjC;
  public c.a cjD;
  private f cjE;
  private com.tencent.mm.compatible.b.h cjF;
  com.tencent.mm.audio.e.b cjG;
  public int cjH;
  public int cjI;
  public int cjJ;
  private f.a cjK;
  public int cjh;
  int cji;
  int cjj;
  int cjk;
  public int cjl;
  private int cjm;
  public int cjn;
  private boolean cjo;
  boolean cjp;
  public int cjq;
  private int cjr;
  public int cjs;
  private boolean cjt;
  long cju;
  int cjv;
  boolean cjw;
  int cjx;
  private boolean cjy;
  int cjz;
  public int mSampleRate;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(55732);
    this.cjh = 0;
    this.cji = 0;
    this.cjj = 0;
    this.cjk = 0;
    this.cjl = 1;
    this.cjm = 1;
    this.mSampleRate = 8000;
    this.cjn = 120;
    this.cjo = false;
    this.cjp = false;
    this.cjq = 10;
    this.cjr = -1;
    this.cjs = -123456789;
    this.cjt = false;
    this.cju = -1L;
    this.cjw = false;
    this.cjy = false;
    this.cjz = 0;
    this.cjA = false;
    this.cjB = false;
    this.cjH = 2;
    this.cjI = 1;
    this.cjJ = 0;
    this.cjK = new f.a()
    {
      public final void d(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(55731);
        c.this.cjz += 1;
        if ((c.this.cjB) && (System.currentTimeMillis() - c.this.cju <= 1000L) && (c.this.cjz - 10 > (System.currentTimeMillis() - c.this.cju) / c.this.cjn))
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 4L, 1L, false);
          ab.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[] { Integer.valueOf(c.this.cjz), Long.valueOf((System.currentTimeMillis() - c.this.cju) / c.this.cjn) });
          c.this.cjA = true;
        }
        if (c.this.cjG != null) {
          c.this.cjG.x(paramAnonymousArrayOfByte, paramAnonymousInt);
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
          if ((!localc.cjw) || (-2 != localc.cjj))
          {
            m = paramAnonymousInt / localc.cjv;
            i = 5;
            if (i <= localc.cjx + m)
            {
              k = (i - localc.cjx - 1) * localc.cjv;
              n = localc.cjv + k;
              if (k >= 0)
              {
                j = k;
                if (n <= paramAnonymousInt) {
                  break label636;
                }
              }
              ab.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
            }
            localc.cjx = ((localc.cjx + m) % 5);
            if (localc.cjj == 20)
            {
              localc.cjh = 6;
              ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
              if ((localc.cji != -1) || (localc.cjk != -1)) {
                break label681;
              }
              localc.cjh = 11;
              ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              label382:
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 5L, 1L, false);
              localc.cjj = -2;
              localc.EE();
            }
          }
        }
        if (c.this.cjp)
        {
          if (paramAnonymousInt > 0)
          {
            localc = c.this;
            if (localc.cji != -1)
            {
              j = 0;
              i = 0;
              label454:
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
                  break label733;
                }
                localc.cji += 1;
              }
              if (localc.cji > 100)
              {
                localc.cjh = 7;
                ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                if ((localc.cjj != -2) || (localc.cjk != -1)) {
                  break label744;
                }
                localc.cjh = 11;
                ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 6L, 1L, false);
              localc.EE();
              localc.cji = -1;
              AppMethodBeat.o(55731);
              return;
              label636:
              do
              {
                j += 1;
                if (j >= n) {
                  break;
                }
              } while (paramAnonymousArrayOfByte[j] == 0);
              localc.cjj = -1;
              localc.cjw = true;
              localc.cjj += 1;
              i += 5;
              break;
              label681:
              if (localc.cji == -1)
              {
                localc.cjh = 8;
                ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                break label382;
              }
              if (localc.cjk != -1) {
                break label382;
              }
              localc.cjh = 9;
              ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
              break label382;
              label733:
              i += 1;
              j = k;
              break label454;
              label744:
              if (localc.cjj == -2)
              {
                localc.cjh = 8;
                ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
              }
              else if (localc.cjk == -1)
              {
                localc.cjh = 10;
                ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
              }
            }
          }
          paramAnonymousArrayOfByte = c.this;
          if ((paramAnonymousArrayOfByte.cjk != -1) && (paramAnonymousInt < 0))
          {
            paramAnonymousArrayOfByte.cjk += 1;
            if (paramAnonymousArrayOfByte.cjk >= 50)
            {
              paramAnonymousArrayOfByte.cjh = 5;
              ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
              if ((paramAnonymousArrayOfByte.cjj != -2) || (paramAnonymousArrayOfByte.cji != -1)) {
                break label916;
              }
              paramAnonymousArrayOfByte.cjh = 11;
              ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 7L, 1L, false);
          paramAnonymousArrayOfByte.EE();
          paramAnonymousArrayOfByte.cjk = -1;
          AppMethodBeat.o(55731);
          return;
          label916:
          if (paramAnonymousArrayOfByte.cjj == -2)
          {
            paramAnonymousArrayOfByte.cjh = 9;
            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
          }
          else if (paramAnonymousArrayOfByte.cji == -1)
          {
            paramAnonymousArrayOfByte.cjh = 10;
            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
          }
        }
      }
    };
    this.cjm = paramInt2;
    this.mSampleRate = paramInt1;
    this.cjr = paramInt3;
    if (this.cjm == 2)
    {
      this.cjH = 3;
      if ((this.cjr == 0) && (ac.erF.eoT > 0)) {
        this.cjn = ac.erF.eoT;
      }
      if (ac.erF.epe > 0) {
        this.cjH = ac.erF.epe;
      }
      if (ac.erF.eoO > 0) {
        this.cjq = ac.erF.eoO;
      }
      if (ac.erv.enj) {
        this.cjG = new com.tencent.mm.audio.e.b(g.ckh, this.cjm, this.mSampleRate);
      }
      if (1 != g.x("EnableRecorderCheckUnreasonableData", 1)) {
        break label360;
      }
    }
    label360:
    for (boolean bool = true;; bool = false)
    {
      this.cjB = bool;
      ab.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[] { Integer.valueOf(this.mSampleRate), Integer.valueOf(this.cjm), Integer.valueOf(this.cjn), Boolean.valueOf(this.cjo), Integer.valueOf(this.cjr) });
      AppMethodBeat.o(55732);
      return;
      this.cjH = 2;
      break;
    }
  }
  
  private boolean ED()
  {
    AppMethodBeat.i(55741);
    g.a locala = new g.a();
    ab.i("MicroMsg.MMPcmRecorder", "startRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
    if (this.cjC != null)
    {
      ab.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
      AppMethodBeat.o(55741);
      return false;
    }
    locala.etf = SystemClock.elapsedRealtime();
    ab.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
    if (!init())
    {
      ab.e("MicroMsg.MMPcmRecorder", "startRecord init error");
      AppMethodBeat.o(55741);
      return false;
    }
    ab.i("MicroMsg.MMPcmRecorder", "init cost: " + locala.Mm() + "ms");
    locala.etf = SystemClock.elapsedRealtime();
    this.cjC.startRecording();
    ab.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + locala.Mm());
    if (this.cjC.getRecordingState() != 3)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 3L, 1L, false);
      this.cjI = 2;
      this.cjh = 4;
      ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
      EE();
      AppMethodBeat.o(55741);
      return false;
    }
    if (this.cjE != null)
    {
      boolean bool = this.cjE.EC();
      AppMethodBeat.o(55741);
      return bool;
    }
    ab.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
    AppMethodBeat.o(55741);
    return false;
  }
  
  private boolean init()
  {
    AppMethodBeat.i(55738);
    this.cjI = 1;
    boolean bool1;
    if (ac.erF.eoP == 2)
    {
      bool1 = false;
      i = m.Lo();
      j = ac.erv.enw;
      if ((i & 0x400) == 0) {
        break label152;
      }
      i = j;
      if (j <= 0) {
        i = 0;
      }
      ab.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: ".concat(String.valueOf(i)));
      label66:
      if (i != 1) {
        break label157;
      }
    }
    int m;
    label152:
    label157:
    for (int k = 1;; k = 0)
    {
      ab.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
      m = AudioRecord.getMinBufferSize(this.mSampleRate, this.cjH, 2);
      if ((m != -2) && (m != -1)) {
        break label162;
      }
      this.cjI = 3;
      this.cjh = 1;
      ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR ".concat(String.valueOf(m)));
      EE();
      AppMethodBeat.o(55738);
      return false;
      bool1 = true;
      break;
      i = 1;
      break label66;
    }
    label162:
    ab.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[] { Integer.valueOf(m) });
    this.cjv = (this.mSampleRate * 20 * this.cjm * 2 / 1000);
    int n = this.mSampleRate * this.cjn * this.cjm / 1000;
    int i1 = n * 2;
    ab.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mSampleRate), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.cjq), Boolean.valueOf(bool1) });
    int i2 = this.cjr;
    int j = this.cjl;
    if ((1 == i2) || (6 == i2) || (7 == i2)) {
      if (Build.VERSION.SDK_INT < 11)
      {
        i = 1;
        if (ac.erv.emD) {
          i = 1;
        }
        if (ac.erv.enc >= 0) {
          i = ac.erv.enc;
        }
        j = i;
        if (6 != i2) {
          break label1258;
        }
        j = i;
        if (ac.erv.enG < 0) {
          break label1258;
        }
      }
    }
    label667:
    label672:
    label740:
    label1258:
    for (int i = ac.erv.enG;; i = j)
    {
      ab.i("MicroMsg.MMPcmRecorder", "init audio source: %s", new Object[] { Integer.valueOf(i) });
      for (;;)
      {
        try
        {
          this.cjC = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.cjH, this.cjq * m);
          if (this.cjC.getState() == 0)
          {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 2L, 1L, false);
            this.cjC.release();
            this.cjh = 2;
            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
            if (7 != i) {
              break label667;
            }
            i = 1;
            this.cjC = new com.tencent.mm.compatible.b.d(i, this.mSampleRate, this.cjH, this.cjq * m);
          }
          if (this.cjC.getState() != 0) {
            break label672;
          }
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 2L, 1L, false);
          this.cjC.release();
          this.cjC = null;
          this.cjI = 2;
          this.cjh = 3;
          ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
          EE();
          AppMethodBeat.o(55738);
          return false;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
          this.cjh = 12;
          ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 1L, 1L, false);
          AppMethodBeat.o(55738);
          return false;
        }
        i = 7;
        break;
        i = 0;
      }
      Object localObject1;
      Object localObject2;
      if (bool1)
      {
        localObject1 = this.cjC;
        boolean bool2 = this.cjo;
        localObject2 = this.cjD;
        if (((this.cjr == 1) || (this.cjr == 6)) && (k != 0))
        {
          bool1 = true;
          this.cjE = new e((AudioRecord)localObject1, bool2, i1, (c.a)localObject2, bool1);
          this.cjE.a(this.cjK);
          if (-123456789 != this.cjs) {
            this.cjE.gB(this.cjs);
          }
          if (this.cjt)
          {
            this.cjF = new com.tencent.mm.compatible.b.h();
            localObject1 = this.cjF;
            localObject2 = this.cjC;
            i = this.cjr;
            ab.d("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
            if (!com.tencent.mm.compatible.util.d.fw(16))
            {
              if (localObject2 != null) {
                break label897;
              }
              ab.d("MicroMsg.MMAudioPreProcess", "audio is null");
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(55738);
        return true;
        bool1 = false;
        break;
        this.cjE = new d(this.cjC, this.cjD, this.cjo, n, i1);
        break label740;
        if (1 == i)
        {
          if (ac.erF.epl != 1)
          {
            ab.d("MicroMsg.MMAudioPreProcess", "disable by config");
          }
          else
          {
            if (ac.erF.epm != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).emt = new j((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).emt != null) && (((com.tencent.mm.compatible.b.h)localObject1).emt.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).emt.KB();
              }
            }
            if (ac.erF.epn != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).emu = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).emu != null) && (((com.tencent.mm.compatible.b.h)localObject1).emu.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).emu.KB();
              }
            }
            if (ac.erF.epo != 2)
            {
              ((com.tencent.mm.compatible.b.h)localObject1).emv = new i((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.h)localObject1).emv != null) && (((com.tencent.mm.compatible.b.h)localObject1).emv.isAvailable())) {
                ((com.tencent.mm.compatible.b.h)localObject1).emv.KB();
              }
            }
          }
        }
        else if (ac.erF.eoS != 1)
        {
          ab.d("MicroMsg.MMAudioPreProcess", "disable by config");
        }
        else
        {
          ((com.tencent.mm.compatible.b.h)localObject1).emt = new j((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).emt != null) && (((com.tencent.mm.compatible.b.h)localObject1).emt.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).emt.KB();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).emu = new com.tencent.mm.compatible.b.f((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).emu != null) && (((com.tencent.mm.compatible.b.h)localObject1).emu.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).emu.KB();
          }
          ((com.tencent.mm.compatible.b.h)localObject1).emv = new i((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.h)localObject1).emv != null) && (((com.tencent.mm.compatible.b.h)localObject1).emv.isAvailable())) {
            ((com.tencent.mm.compatible.b.h)localObject1).emv.KB();
          }
        }
      }
    }
  }
  
  public final void EB()
  {
    AppMethodBeat.i(55735);
    this.cjp = true;
    ab.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.cjp);
    AppMethodBeat.o(55735);
  }
  
  public final boolean EC()
  {
    AppMethodBeat.i(55740);
    ab.i("MicroMsg.MMPcmRecorder", "startRecord");
    Object localObject = new mn();
    ((mn)localObject).cCF.type = 1;
    ((mn)localObject).cCF.cCH = true;
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    this.cju = System.currentTimeMillis();
    this.cjw = false;
    if (((mn)localObject).cCG.cCJ)
    {
      ab.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
      this.cjh = 13;
      AppMethodBeat.o(55740);
      return false;
    }
    localObject = (AudioManager)ah.getContext().getSystemService("audio");
    if ((localObject != null) && (((AudioManager)localObject).isMicrophoneMute()))
    {
      ab.e("MicroMsg.MMPcmRecorder", "microphone is mute");
      this.cjh = 14;
      localObject = new ka();
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(151L, 8L, 1L, false);
      AppMethodBeat.o(55740);
      return false;
    }
    this.cjy = false;
    boolean bool = ED();
    if (!bool)
    {
      Et();
      localObject = new mo();
      ((mo)localObject).cCK.type = 1;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    AppMethodBeat.o(55740);
    return bool;
  }
  
  final void EE()
  {
    AppMethodBeat.i(55743);
    if (this.cjD != null) {
      this.cjD.bS(this.cjI, this.cjh);
    }
    AppMethodBeat.o(55743);
  }
  
  public final int EF()
  {
    AppMethodBeat.i(55744);
    if (this.cjE != null)
    {
      int i = this.cjE.EF();
      AppMethodBeat.o(55744);
      return i;
    }
    AppMethodBeat.o(55744);
    return -1;
  }
  
  public final boolean Et()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(55742);
        if (true == this.cjy)
        {
          ab.i("MicroMsg.MMPcmRecorder", "already have stopped");
          AppMethodBeat.o(55742);
          return bool1;
        }
        this.cjy = true;
        Object localObject1 = new g.a();
        if (this.cjG != null)
        {
          this.cjG.EZ();
          this.cjG = null;
        }
        ((g.a)localObject1).etf = SystemClock.elapsedRealtime();
        if (this.cjE != null)
        {
          this.cjE.stopRecord();
          this.cjE = null;
        }
        ab.i("MicroMsg.MMPcmRecorder", "cost " + ((g.a)localObject1).Mm() + "ms to call stopRecord");
        ab.i("MicroMsg.MMPcmRecorder", "stopRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.cjC == null)
        {
          ab.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
          bool1 = false;
          if (((!this.cjw) && (-1L != this.cju) && (System.currentTimeMillis() - this.cju >= 2000L)) || (this.cjA))
          {
            ab.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
            localObject1 = new mo();
            ((mo)localObject1).cCK.type = 1;
            a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
            bool2 = false;
          }
          localObject1 = new mn();
          ((mn)localObject1).cCF.type = 1;
          ((mn)localObject1).cCF.cCH = false;
          ((mn)localObject1).cCF.cCI = bool2;
          a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
          ab.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[] { Integer.valueOf(this.cjh) });
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(new IDKey(357, 0, 1));
          if (this.cjh != 0) {
            ((ArrayList)localObject1).add(new IDKey(357, 1, 1));
          }
        }
        switch (this.cjh)
        {
        case 1: 
          ab.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
          com.tencent.mm.plugin.report.service.h.qsU.b((ArrayList)localObject1, false);
          AppMethodBeat.o(55742);
          continue;
          if (this.cjC.getState() != 1)
          {
            ab.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.cjC.getState());
            bool1 = false;
            continue;
          }
          ((g.a)localObject1).etf = SystemClock.elapsedRealtime();
          this.cjC.stop();
          this.cjC.release();
          this.cjC = null;
          ab.i("MicroMsg.MMPcmRecorder", "cost " + ((g.a)localObject1).Mm() + "ms to call stop and release");
          bool1 = true;
          continue;
          ((ArrayList)localObject1).add(new IDKey(357, 2, 1));
          break;
        case 2: 
          localObject2.add(new IDKey(357, 3, 1));
        }
      }
      finally {}
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
  
  public final void bA(boolean paramBoolean)
  {
    AppMethodBeat.i(55737);
    this.cjt = paramBoolean;
    ab.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.cjt);
    AppMethodBeat.o(55737);
  }
  
  public final void bB(boolean paramBoolean)
  {
    AppMethodBeat.i(55739);
    ab.i("MicroMsg.MMPcmRecorder", "switchMute mute:".concat(String.valueOf(paramBoolean)));
    if (this.cjE != null) {
      this.cjE.bB(paramBoolean);
    }
    AppMethodBeat.o(55739);
  }
  
  public final void bz(boolean paramBoolean)
  {
    AppMethodBeat.i(55734);
    this.cjo = paramBoolean;
    ab.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.cjo);
    AppMethodBeat.o(55734);
  }
  
  public final void gA(int paramInt)
  {
    AppMethodBeat.i(55733);
    this.cjn = paramInt;
    ab.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.cjn);
    AppMethodBeat.o(55733);
  }
  
  public final void t(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(55736);
    if ((10 == this.cjq) || (paramBoolean))
    {
      this.cjq = paramInt;
      ab.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.cjq);
    }
    AppMethodBeat.o(55736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.audio.b.c
 * JD-Core Version:    0.7.0.1
 */