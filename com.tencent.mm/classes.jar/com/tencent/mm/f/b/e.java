package com.tencent.mm.f.b;

import android.media.AudioRecord;
import com.tencent.mm.compatible.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Timer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  extends f
{
  boolean bCA;
  AudioRecord bCO;
  int bDa;
  private int bDd = 12800;
  private e.b bDe = new e.b(this);
  a bDf = null;
  c.a bDg;
  private final Object bDh = new Object();
  final byte[] bDi = new byte[0];
  final Object bDj = new Object();
  private Timer bDk = null;
  private boolean bDl = false;
  private boolean bDm = false;
  boolean mIsMute = false;
  int mStatus = 0;
  
  public e(AudioRecord paramAudioRecord, boolean paramBoolean1, int paramInt, c.a parama, boolean paramBoolean2)
  {
    this.bCO = paramAudioRecord;
    this.bCA = paramBoolean1;
    this.bDa = paramInt;
    this.bDg = parama;
    this.bDm = paramBoolean2;
  }
  
  public final void aZ(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    y.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
    synchronized (this.bDj)
    {
      this.mStatus = 3;
      synchronized (this.bDi)
      {
        this.bDi.notify();
        com.tencent.mm.sdk.f.e.Y(this.bDe);
      }
    }
    try
    {
      com.tencent.mm.sdk.f.e.aa(this.bDe);
      label51:
      if (this.bDf != null)
      {
        if (this.bDk != null)
        {
          this.bDk.cancel();
          this.bDk = null;
        }
        ??? = this.bDf;
        ((a)???).dtT = 0;
        ((a)???).dtU = 0;
        ((a)???).dtW = 0;
        ((a)???).dtX = 0;
        ((a)???).dtV = null;
      }
      synchronized (this.bDh)
      {
        this.bDf = null;
        this.bDg = null;
        this.bDl = false;
        this.bDf = null;
        return;
        localObject2 = finally;
        throw localObject2;
        localObject3 = finally;
        throw localObject3;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label51;
    }
  }
  
  public final int u(byte[] paramArrayOfByte, int paramInt)
  {
    int j = -1;
    for (;;)
    {
      a locala;
      synchronized (this.bDh)
      {
        if (this.bDf == null) {
          break label285;
        }
        locala = this.bDf;
        i = j;
        if (paramInt > 0)
        {
          i = j;
          if (paramInt <= locala.yg())
          {
            if (paramArrayOfByte != null) {
              continue;
            }
            i = j;
          }
        }
        return i;
        i = j;
        if (locala.dtW == locala.dtX) {
          continue;
        }
        if (locala.dtY) {
          locala.dtZ.lock();
        }
        if (locala.dtW < locala.dtX)
        {
          System.arraycopy(locala.dtV, locala.dtW, paramArrayOfByte, 0, paramInt);
          locala.dtW += paramInt;
          if (!locala.dtY) {
            break label290;
          }
          locala.dtZ.unlock();
          break label290;
        }
        if (paramInt <= locala.dtT - locala.dtW)
        {
          System.arraycopy(locala.dtV, locala.dtW, paramArrayOfByte, 0, paramInt);
          locala.dtW += paramInt;
        }
      }
      System.arraycopy(locala.dtV, locala.dtW, paramArrayOfByte, 0, locala.dtT - locala.dtW);
      System.arraycopy(locala.dtV, 0, paramArrayOfByte, locala.dtT - locala.dtW, paramInt - (locala.dtT - locala.dtW));
      locala.dtW = (paramInt - (locala.dtT - locala.dtW));
      continue;
      label285:
      return -1;
      label290:
      int i = 0;
    }
  }
  
  public final boolean uq()
  {
    int j = -1;
    y.i("MicroMsg.RecordModeAsyncRead", "startRecord");
    int i;
    for (;;)
    {
      synchronized (this.bDj)
      {
        this.mStatus = 1;
        y.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", new Object[] { com.tencent.mm.sdk.f.e.csu().csx() });
        com.tencent.mm.sdk.f.e.a(this.bDe, "RecordModeAsyncRead_record", 10);
        if (true != this.bDm) {
          break label332;
        }
        this.bDf = new a();
        if (this.bDf == null)
        {
          y.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
          i = 0;
          if (i != 0) {
            break;
          }
          y.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
          return false;
        }
      }
      this.bDd = (this.bDa * 20);
      y.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.bDd);
      ??? = this.bDf;
      i = this.bDd;
      if (i <= 0) {
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label223;
        }
        y.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
        i = 0;
        break;
        ((a)???).dtV = new byte[i];
        if (((a)???).dtV == null)
        {
          i = -1;
        }
        else
        {
          ((a)???).dtT = i;
          if (((a)???).dtY) {
            ((a)???).dtZ = new ReentrantLock();
          }
          i = 0;
        }
      }
      label223:
      i = 1;
    }
    if ((this.bDl) || (this.bDk != null))
    {
      y.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.bDl);
      i = j;
    }
    while (i != 0)
    {
      y.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
      return false;
      this.bDk = new Timer();
      i = j;
      if (this.bDk != null) {
        i = 0;
      }
    }
    this.bDk.scheduleAtFixedRate(new e.a(this), 60L, 20L);
    this.bDl = true;
    label332:
    return true;
  }
  
  public final int ut()
  {
    synchronized (this.bDh)
    {
      if (this.bDf != null)
      {
        int i = this.bDf.dtT;
        return i;
      }
      return -1;
    }
  }
  
  public final int uu()
  {
    synchronized (this.bDh)
    {
      if (this.bDf != null)
      {
        int i = this.bDf.yg();
        return i;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.e
 * JD-Core Version:    0.7.0.1
 */