package com.tencent.mm.f.b;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.h.a.jr;
import com.tencent.mm.h.a.lw;
import com.tencent.mm.h.a.lw.b;
import com.tencent.mm.h.a.lx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class c
{
  private boolean bCA = false;
  boolean bCB = false;
  public int bCC = 10;
  private int bCD = -1;
  public int bCE = -123456789;
  private boolean bCF = false;
  long bCG = -1L;
  int bCH;
  boolean bCI = false;
  int bCJ;
  private boolean bCK = false;
  int bCL = 0;
  boolean bCM = false;
  boolean bCN = false;
  private AudioRecord bCO;
  public c.a bCP;
  private f bCQ;
  private com.tencent.mm.compatible.b.g bCR;
  com.tencent.mm.f.c.b bCS;
  public int bCT = 2;
  public int bCU = 1;
  public int bCV = 0;
  private f.a bCW = new c.1(this);
  public int bCt = 0;
  int bCu = 0;
  int bCv = 0;
  int bCw = 0;
  public int bCx = 1;
  private int bCy = 1;
  public int bCz = 120;
  public int mSampleRate = 8000;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.bCy = paramInt2;
    this.mSampleRate = paramInt1;
    this.bCD = paramInt3;
    if (this.bCy == 2)
    {
      this.bCT = 3;
      if ((this.bCD == 0) && (q.dyn.dwV > 0)) {
        this.bCz = q.dyn.dwV;
      }
      if (q.dyn.dxg > 0) {
        this.bCT = q.dyn.dxg;
      }
      if (q.dyn.dwQ > 0) {
        this.bCC = q.dyn.dwQ;
      }
      if (q.dye.dvs) {
        this.bCS = new com.tencent.mm.f.c.b(g.bDs, this.bCy, this.mSampleRate);
      }
      if (1 != g.r("EnableRecorderCheckUnreasonableData", 1)) {
        break label350;
      }
    }
    label350:
    for (boolean bool = true;; bool = false)
    {
      this.bCN = bool;
      y.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[] { Integer.valueOf(this.mSampleRate), Integer.valueOf(this.bCy), Integer.valueOf(this.bCz), Boolean.valueOf(this.bCA), Integer.valueOf(this.bCD) });
      return;
      this.bCT = 2;
      break;
    }
  }
  
  private boolean init()
  {
    this.bCU = 1;
    boolean bool1;
    if (q.dyn.dwR == 2)
    {
      bool1 = false;
      i = m.yR();
      j = q.dye.dvF;
      if ((i & 0x400) == 0) {
        break label151;
      }
      i = j;
      if (j <= 0) {
        i = 0;
      }
      y.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: " + i);
      label66:
      if (i != 1) {
        break label156;
      }
    }
    int m;
    label151:
    label156:
    for (int k = 1;; k = 0)
    {
      y.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
      m = AudioRecord.getMinBufferSize(this.mSampleRate, this.bCT, 2);
      if ((m != -2) && (m != -1)) {
        break label161;
      }
      this.bCU = 3;
      this.bCt = 1;
      y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR " + m);
      ur();
      return false;
      bool1 = true;
      break;
      i = 1;
      break label66;
    }
    label161:
    y.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[] { Integer.valueOf(m) });
    this.bCH = (this.mSampleRate * 20 * this.bCy * 2 / 1000);
    int n = this.mSampleRate * this.bCz * this.bCy / 1000;
    int i1 = n * 2;
    y.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mSampleRate), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.bCC), Boolean.valueOf(bool1) });
    int i2 = this.bCD;
    int j = this.bCx;
    if ((1 == i2) || (6 == i2) || (7 == i2)) {
      if (Build.VERSION.SDK_INT < 11)
      {
        i = 1;
        if (q.dye.duN) {
          i = 1;
        }
        if (q.dye.dvm >= 0) {
          i = q.dye.dvm;
        }
        j = i;
        if (6 != i2) {
          break label1218;
        }
        j = i;
        if (q.dye.dvP < 0) {
          break label1218;
        }
      }
    }
    label1218:
    for (int i = q.dye.dvP;; i = j)
    {
      for (;;)
      {
        try
        {
          this.bCO = new com.tencent.mm.compatible.b.c(i, this.mSampleRate, this.bCT, this.bCC * m);
          if (this.bCO.getState() == 0)
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.h.nFQ.a(151L, 2L, 1L, false);
            this.bCO.release();
            this.bCt = 2;
            y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
            if (7 != i) {
              break label633;
            }
            i = 1;
            this.bCO = new com.tencent.mm.compatible.b.c(i, this.mSampleRate, this.bCT, this.bCC * m);
          }
          if (this.bCO.getState() != 0) {
            break label638;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.a(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.nFQ.a(151L, 2L, 1L, false);
          this.bCO.release();
          this.bCO = null;
          this.bCU = 2;
          this.bCt = 3;
          y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
          ur();
          return false;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
          this.bCt = 12;
          y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
          com.tencent.mm.plugin.report.service.h.nFQ.a(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.nFQ.a(151L, 1L, 1L, false);
          return false;
        }
        i = 7;
        break;
        label633:
        i = 0;
      }
      label638:
      Object localObject1;
      Object localObject2;
      if (bool1)
      {
        localObject1 = this.bCO;
        boolean bool2 = this.bCA;
        localObject2 = this.bCP;
        if (((this.bCD == 1) || (this.bCD == 6)) && (k != 0))
        {
          bool1 = true;
          this.bCQ = new e((AudioRecord)localObject1, bool2, i1, (c.a)localObject2, bool1);
          label706:
          this.bCQ.a(this.bCW);
          if (-123456789 != this.bCE) {
            this.bCQ.ez(this.bCE);
          }
          if (this.bCF)
          {
            this.bCR = new com.tencent.mm.compatible.b.g();
            localObject1 = this.bCR;
            localObject2 = this.bCO;
            i = this.bCD;
            y.d("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
            if (!com.tencent.mm.compatible.util.d.gG(16))
            {
              if (localObject2 != null) {
                break label857;
              }
              y.d("MicroMsg.MMAudioPreProcess", "audio is null");
            }
          }
        }
      }
      for (;;)
      {
        return true;
        bool1 = false;
        break;
        this.bCQ = new d(this.bCO, this.bCP, this.bCA, n, i1);
        break label706;
        label857:
        if (1 == i)
        {
          if (q.dyn.dxn != 1)
          {
            y.d("MicroMsg.MMAudioPreProcess", "disable by config");
          }
          else
          {
            if (q.dyn.dxo != 2)
            {
              ((com.tencent.mm.compatible.b.g)localObject1).duD = new i((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.g)localObject1).duD != null) && (((com.tencent.mm.compatible.b.g)localObject1).duD.isAvailable())) {
                ((com.tencent.mm.compatible.b.g)localObject1).duD.yh();
              }
            }
            if (q.dyn.dxp != 2)
            {
              ((com.tencent.mm.compatible.b.g)localObject1).duE = new com.tencent.mm.compatible.b.e((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.g)localObject1).duE != null) && (((com.tencent.mm.compatible.b.g)localObject1).duE.isAvailable())) {
                ((com.tencent.mm.compatible.b.g)localObject1).duE.yh();
              }
            }
            if (q.dyn.dxq != 2)
            {
              ((com.tencent.mm.compatible.b.g)localObject1).duF = new com.tencent.mm.compatible.b.h((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.g)localObject1).duF != null) && (((com.tencent.mm.compatible.b.g)localObject1).duF.isAvailable())) {
                ((com.tencent.mm.compatible.b.g)localObject1).duF.yh();
              }
            }
          }
        }
        else if (q.dyn.dwU != 1)
        {
          y.d("MicroMsg.MMAudioPreProcess", "disable by config");
        }
        else
        {
          ((com.tencent.mm.compatible.b.g)localObject1).duD = new i((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.g)localObject1).duD != null) && (((com.tencent.mm.compatible.b.g)localObject1).duD.isAvailable())) {
            ((com.tencent.mm.compatible.b.g)localObject1).duD.yh();
          }
          ((com.tencent.mm.compatible.b.g)localObject1).duE = new com.tencent.mm.compatible.b.e((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.g)localObject1).duE != null) && (((com.tencent.mm.compatible.b.g)localObject1).duE.isAvailable())) {
            ((com.tencent.mm.compatible.b.g)localObject1).duE.yh();
          }
          ((com.tencent.mm.compatible.b.g)localObject1).duF = new com.tencent.mm.compatible.b.h((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.g)localObject1).duF != null) && (((com.tencent.mm.compatible.b.g)localObject1).duF.isAvailable())) {
            ((com.tencent.mm.compatible.b.g)localObject1).duF.yh();
          }
        }
      }
    }
  }
  
  public final void aX(boolean paramBoolean)
  {
    this.bCA = paramBoolean;
    y.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.bCA);
  }
  
  public final void aY(boolean paramBoolean)
  {
    this.bCF = paramBoolean;
    y.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.bCF);
  }
  
  public final void aZ(boolean paramBoolean)
  {
    y.i("MicroMsg.MMPcmRecorder", "switchMute mute:" + paramBoolean);
    if (this.bCQ != null) {
      this.bCQ.aZ(paramBoolean);
    }
  }
  
  public final void ey(int paramInt)
  {
    this.bCz = paramInt;
    y.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.bCz);
  }
  
  public final void t(int paramInt, boolean paramBoolean)
  {
    if ((10 == this.bCC) || (paramBoolean))
    {
      this.bCC = paramInt;
      y.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.bCC);
    }
  }
  
  public final boolean uh()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (true == this.bCK)
        {
          y.i("MicroMsg.MMPcmRecorder", "already have stopped");
          return bool1;
        }
        this.bCK = true;
        Object localObject1 = new com.tencent.mm.compatible.util.g.a();
        if (this.bCS != null)
        {
          this.bCS.uG();
          this.bCS = null;
        }
        ((com.tencent.mm.compatible.util.g.a)localObject1).dzS = SystemClock.elapsedRealtime();
        if (this.bCQ != null)
        {
          this.bCQ.stopRecord();
          this.bCQ = null;
        }
        y.i("MicroMsg.MMPcmRecorder", "cost " + ((com.tencent.mm.compatible.util.g.a)localObject1).zJ() + "ms to call stopRecord");
        y.i("MicroMsg.MMPcmRecorder", "stopRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.bCO == null)
        {
          y.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
          bool1 = false;
          if (((!this.bCI) && (-1L != this.bCG) && (System.currentTimeMillis() - this.bCG >= 2000L)) || (this.bCM))
          {
            y.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
            localObject1 = new lx();
            ((lx)localObject1).bVc.type = 1;
            a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
            bool2 = false;
          }
          localObject1 = new lw();
          ((lw)localObject1).bUX.type = 1;
          ((lw)localObject1).bUX.bUZ = false;
          ((lw)localObject1).bUX.bVa = bool2;
          a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          y.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[] { Integer.valueOf(this.bCt) });
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(new IDKey(357, 0, 1));
          if (this.bCt != 0) {
            ((ArrayList)localObject1).add(new IDKey(357, 1, 1));
          }
        }
        switch (this.bCt)
        {
        case 1: 
          y.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
          com.tencent.mm.plugin.report.service.h.nFQ.b((ArrayList)localObject1, false);
          continue;
          if (this.bCO.getState() != 1)
          {
            y.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.bCO.getState());
            bool1 = false;
            continue;
          }
          ((com.tencent.mm.compatible.util.g.a)localObject1).dzS = SystemClock.elapsedRealtime();
          this.bCO.stop();
          this.bCO.release();
          this.bCO = null;
          y.i("MicroMsg.MMPcmRecorder", "cost " + ((com.tencent.mm.compatible.util.g.a)localObject1).zJ() + "ms to call stop and release");
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
  
  public final void up()
  {
    this.bCB = true;
    y.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.bCB);
  }
  
  public final boolean uq()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    y.i("MicroMsg.MMPcmRecorder", "startRecord");
    Object localObject = new lw();
    ((lw)localObject).bUX.type = 1;
    ((lw)localObject).bUX.bUZ = true;
    a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    this.bCG = System.currentTimeMillis();
    this.bCI = false;
    if (((lw)localObject).bUY.bVb)
    {
      y.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
      this.bCt = 13;
      return bool2;
    }
    localObject = (AudioManager)ae.getContext().getSystemService("audio");
    if ((localObject != null) && (((AudioManager)localObject).isMicrophoneMute()))
    {
      y.e("MicroMsg.MMPcmRecorder", "microphone is mute");
      this.bCt = 14;
      localObject = new jr();
      a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.plugin.report.service.h.nFQ.a(151L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.nFQ.a(151L, 8L, 1L, false);
      return false;
    }
    this.bCK = false;
    localObject = new com.tencent.mm.compatible.util.g.a();
    y.i("MicroMsg.MMPcmRecorder", "startRecord, " + java.lang.Thread.currentThread().getStackTrace()[2].getMethodName());
    if (this.bCO != null) {
      y.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      uh();
      localObject = new lx();
      ((lx)localObject).bVc.type = 1;
      a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      return bool1;
      ((com.tencent.mm.compatible.util.g.a)localObject).dzS = SystemClock.elapsedRealtime();
      y.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
      if (!init())
      {
        y.e("MicroMsg.MMPcmRecorder", "startRecord init error");
      }
      else
      {
        y.i("MicroMsg.MMPcmRecorder", "init cost: " + ((com.tencent.mm.compatible.util.g.a)localObject).zJ() + "ms");
        ((com.tencent.mm.compatible.util.g.a)localObject).dzS = SystemClock.elapsedRealtime();
        this.bCO.startRecording();
        y.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + ((com.tencent.mm.compatible.util.g.a)localObject).zJ());
        if (this.bCO.getRecordingState() != 3)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.nFQ.a(151L, 3L, 1L, false);
          this.bCU = 2;
          this.bCt = 4;
          y.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
          ur();
        }
        else if (this.bCQ != null)
        {
          bool1 = this.bCQ.uq();
        }
        else
        {
          y.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
        }
      }
    }
  }
  
  final void ur()
  {
    if (this.bCP != null) {
      this.bCP.aU(this.bCU, this.bCt);
    }
  }
  
  public final int us()
  {
    if (this.bCQ != null) {
      return this.bCQ.us();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.c
 * JD-Core Version:    0.7.0.1
 */