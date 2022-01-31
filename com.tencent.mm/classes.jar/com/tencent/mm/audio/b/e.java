package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  extends f
{
  AudioRecord cjC;
  int cjO;
  private int cjR;
  e.b cjS;
  b cjT;
  c.a cjU;
  final Object cjV;
  final byte[] cjW;
  final Object cjX;
  Timer cjY;
  boolean cjZ;
  boolean cjo;
  private boolean cka;
  boolean mIsMute;
  int mStatus;
  
  public e(AudioRecord paramAudioRecord, boolean paramBoolean1, int paramInt, c.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(55753);
    this.mStatus = 0;
    this.cjR = 12800;
    this.mIsMute = false;
    this.cjS = new e.b(this);
    this.cjT = null;
    this.cjV = new Object();
    this.cjW = new byte[0];
    this.cjX = new Object();
    this.cjY = null;
    this.cjZ = false;
    this.cka = false;
    this.cjC = paramAudioRecord;
    this.cjo = paramBoolean1;
    this.cjO = paramInt;
    this.cjU = parama;
    this.cka = paramBoolean2;
    AppMethodBeat.o(55753);
  }
  
  public final boolean EC()
  {
    int j = -1;
    AppMethodBeat.i(55754);
    ab.i("MicroMsg.RecordModeAsyncRead", "startRecord");
    int i;
    for (;;)
    {
      synchronized (this.cjX)
      {
        this.mStatus = 1;
        ab.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", new Object[] { d.ysm.dut() });
        d.f(this.cjS, "RecordModeAsyncRead_record");
        if (true != this.cka) {
          break label352;
        }
        this.cjT = new b();
        if (this.cjT == null)
        {
          ab.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
          i = 0;
          if (i != 0) {
            break;
          }
          ab.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
          AppMethodBeat.o(55754);
          return false;
        }
      }
      this.cjR = (this.cjO * 20);
      ab.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.cjR);
      ??? = this.cjT;
      i = this.cjR;
      if (i <= 0) {
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label238;
        }
        ab.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
        i = 0;
        break;
        ((b)???).elJ = new byte[i];
        if (((b)???).elJ == null)
        {
          i = -1;
        }
        else
        {
          ((b)???).elH = i;
          if (((b)???).elM) {
            ((b)???).elN = new ReentrantLock();
          }
          i = 0;
        }
      }
      label238:
      i = 1;
    }
    if ((this.cjZ) || (this.cjY != null))
    {
      ab.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.cjZ);
      i = j;
    }
    while (i != 0)
    {
      ab.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
      AppMethodBeat.o(55754);
      return false;
      this.cjY = new Timer();
      i = j;
      if (this.cjY != null) {
        i = 0;
      }
    }
    this.cjY.scheduleAtFixedRate(new a(), 60L, 20L);
    this.cjZ = true;
    label352:
    AppMethodBeat.o(55754);
    return true;
  }
  
  public final int EG()
  {
    synchronized (this.cjV)
    {
      if (this.cjT != null)
      {
        int i = this.cjT.elH;
        return i;
      }
      return -1;
    }
  }
  
  public final int EH()
  {
    AppMethodBeat.i(55756);
    synchronized (this.cjV)
    {
      if (this.cjT != null)
      {
        int i = this.cjT.Kz();
        AppMethodBeat.o(55756);
        return i;
      }
      AppMethodBeat.o(55756);
      return -1;
    }
  }
  
  public final void bB(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(55755);
    ab.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
    synchronized (this.cjX)
    {
      this.mStatus = 3;
      this.cjS.ckf = new e.1(this);
    }
    synchronized (this.cjW)
    {
      this.cjW.notify();
      AppMethodBeat.o(55755);
      return;
      localObject2 = finally;
      AppMethodBeat.o(55755);
      throw localObject2;
    }
  }
  
  public final int v(byte[] paramArrayOfByte, int paramInt)
  {
    int j = -1;
    AppMethodBeat.i(55757);
    for (;;)
    {
      b localb;
      synchronized (this.cjV)
      {
        if (this.cjT == null) {
          break label300;
        }
        localb = this.cjT;
        i = j;
        if (paramInt > 0)
        {
          i = j;
          if (paramInt <= localb.Kz())
          {
            if (paramArrayOfByte != null) {
              continue;
            }
            i = j;
          }
        }
        AppMethodBeat.o(55757);
        return i;
        i = j;
        if (localb.elK == localb.elL) {
          continue;
        }
        if (localb.elM) {
          localb.elN.lock();
        }
        if (localb.elK < localb.elL)
        {
          System.arraycopy(localb.elJ, localb.elK, paramArrayOfByte, 0, paramInt);
          localb.elK += paramInt;
          if (!localb.elM) {
            break label310;
          }
          localb.elN.unlock();
          break label310;
        }
        if (paramInt <= localb.elH - localb.elK)
        {
          System.arraycopy(localb.elJ, localb.elK, paramArrayOfByte, 0, paramInt);
          localb.elK += paramInt;
        }
      }
      System.arraycopy(localb.elJ, localb.elK, paramArrayOfByte, 0, localb.elH - localb.elK);
      System.arraycopy(localb.elJ, 0, paramArrayOfByte, localb.elH - localb.elK, paramInt - (localb.elH - localb.elK));
      localb.elK = (paramInt - (localb.elH - localb.elK));
      continue;
      label300:
      AppMethodBeat.o(55757);
      return -1;
      label310:
      int i = 0;
    }
  }
  
  final class a
    extends TimerTask
  {
    private int ckc;
    private int ckd;
    byte[] cke;
    
    a()
    {
      AppMethodBeat.i(55750);
      this.ckc = (e.this.cjO * 2);
      this.ckd = e.this.cjO;
      this.cke = new byte[this.ckc];
      AppMethodBeat.o(55750);
    }
    
    public final void run()
    {
      AppMethodBeat.i(55751);
      int j;
      if (!e.this.mIsPause)
      {
        j = (int)(0.8D * e.this.EG());
        i = j;
        if (j < e.this.cjO * 8) {
          i = e.this.cjO * 8;
        }
        if (e.this.EH() <= i) {
          break label140;
        }
      }
      label140:
      for (int i = 8;; i = 1)
      {
        j = 0;
        while (j < i)
        {
          int k = e.this.v(this.cke, this.ckd);
          if ((e.this.cjU != null) && (k == 0)) {
            e.this.cjU.s(this.cke, this.ckd);
          }
          j += 1;
        }
        AppMethodBeat.o(55751);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.b.e
 * JD-Core Version:    0.7.0.1
 */