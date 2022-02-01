package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.f.c;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  extends f
{
  int dzH;
  private int dzK;
  b dzL;
  b dzM;
  c.a dzN;
  final Object dzO;
  final byte[] dzP;
  final Object dzQ;
  Timer dzR;
  boolean dzS;
  private boolean dzT;
  boolean dzg;
  AudioRecord dzu;
  boolean mIsMute;
  int mStatus;
  
  public e(AudioRecord paramAudioRecord, boolean paramBoolean1, int paramInt, c.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(130002);
    this.mStatus = 0;
    this.dzK = 12800;
    this.mIsMute = false;
    this.dzL = new b();
    this.dzM = null;
    this.dzO = new Object();
    this.dzP = new byte[0];
    this.dzQ = new Object();
    this.dzR = null;
    this.dzS = false;
    this.dzT = false;
    this.dzu = paramAudioRecord;
    this.dzg = paramBoolean1;
    this.dzH = paramInt;
    this.dzN = parama;
    this.dzT = paramBoolean2;
    AppMethodBeat.o(130002);
  }
  
  public final boolean aai()
  {
    int j = -1;
    AppMethodBeat.i(130003);
    Log.i("MicroMsg.RecordModeAsyncRead", "startRecord");
    int i;
    for (;;)
    {
      synchronized (this.dzQ)
      {
        this.mStatus = 1;
        Log.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", new Object[] { com.tencent.f.h.RTd.hmd() });
        com.tencent.f.h.RTc.aX(this.dzL);
        if (true != this.dzT) {
          break label356;
        }
        this.dzM = new b();
        if (this.dzM == null)
        {
          Log.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
          i = 0;
          if (i != 0) {
            break;
          }
          Log.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
          AppMethodBeat.o(130003);
          return false;
        }
      }
      this.dzK = (this.dzH * 20);
      Log.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.dzK);
      ??? = this.dzM;
      i = this.dzK;
      if (i <= 0) {
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label242;
        }
        Log.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
        i = 0;
        break;
        ((b)???).gCH = new byte[i];
        if (((b)???).gCH == null)
        {
          i = -1;
        }
        else
        {
          ((b)???).gCF = i;
          if (((b)???).gCK) {
            ((b)???).gCL = new ReentrantLock();
          }
          i = 0;
        }
      }
      label242:
      i = 1;
    }
    if ((this.dzS) || (this.dzR != null))
    {
      Log.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.dzS);
      i = j;
    }
    while (i != 0)
    {
      Log.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
      AppMethodBeat.o(130003);
      return false;
      this.dzR = new Timer();
      i = j;
      if (this.dzR != null) {
        i = 0;
      }
    }
    this.dzR.scheduleAtFixedRate(new a(), 60L, 20L);
    this.dzS = true;
    label356:
    AppMethodBeat.o(130003);
    return true;
  }
  
  public final int aam()
  {
    synchronized (this.dzO)
    {
      if (this.dzM != null)
      {
        int i = this.dzM.gCF;
        return i;
      }
      return -1;
    }
  }
  
  public final int aan()
  {
    AppMethodBeat.i(130005);
    synchronized (this.dzO)
    {
      if (this.dzM != null)
      {
        int i = this.dzM.anD();
        AppMethodBeat.o(130005);
        return i;
      }
      AppMethodBeat.o(130005);
      return -1;
    }
  }
  
  public final void de(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(130004);
    Log.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
    synchronized (this.dzQ)
    {
      this.mStatus = 3;
      this.dzL.dzY = new c()
      {
        public final void finish()
        {
          AppMethodBeat.i(129998);
          e.this.dzL.dzY = null;
          Log.i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
          if (e.this.dzM != null)
          {
            if (e.this.dzR != null)
            {
              e.this.dzR.cancel();
              e.this.dzR = null;
            }
            ??? = e.this.dzM;
            ((b)???).gCF = 0;
            ((b)???).gCG = 0;
            ((b)???).gCI = 0;
            ((b)???).gCJ = 0;
            ((b)???).gCH = null;
          }
          synchronized (e.this.dzO)
          {
            e.this.dzM = null;
            e.this.dzN = null;
            e.this.dzS = false;
            e.this.dzM = null;
            AppMethodBeat.o(129998);
            return;
          }
        }
      };
    }
    synchronized (this.dzP)
    {
      this.dzP.notify();
      AppMethodBeat.o(130004);
      return;
      localObject2 = finally;
      AppMethodBeat.o(130004);
      throw localObject2;
    }
  }
  
  public final int z(byte[] paramArrayOfByte, int paramInt)
  {
    int j = -1;
    AppMethodBeat.i(130006);
    for (;;)
    {
      b localb;
      synchronized (this.dzO)
      {
        if (this.dzM == null) {
          break label300;
        }
        localb = this.dzM;
        i = j;
        if (paramInt > 0)
        {
          i = j;
          if (paramInt <= localb.anD())
          {
            if (paramArrayOfByte != null) {
              continue;
            }
            i = j;
          }
        }
        AppMethodBeat.o(130006);
        return i;
        i = j;
        if (localb.gCI == localb.gCJ) {
          continue;
        }
        if (localb.gCK) {
          localb.gCL.lock();
        }
        if (localb.gCI < localb.gCJ)
        {
          System.arraycopy(localb.gCH, localb.gCI, paramArrayOfByte, 0, paramInt);
          localb.gCI += paramInt;
          if (!localb.gCK) {
            break label310;
          }
          localb.gCL.unlock();
          break label310;
        }
        if (paramInt <= localb.gCF - localb.gCI)
        {
          System.arraycopy(localb.gCH, localb.gCI, paramArrayOfByte, 0, paramInt);
          localb.gCI += paramInt;
        }
      }
      System.arraycopy(localb.gCH, localb.gCI, paramArrayOfByte, 0, localb.gCF - localb.gCI);
      System.arraycopy(localb.gCH, 0, paramArrayOfByte, localb.gCF - localb.gCI, paramInt - (localb.gCF - localb.gCI));
      localb.gCI = (paramInt - (localb.gCF - localb.gCI));
      continue;
      label300:
      AppMethodBeat.o(130006);
      return -1;
      label310:
      int i = 0;
    }
  }
  
  final class a
    extends TimerTask
  {
    private int dzV;
    private int dzW;
    byte[] dzX;
    
    a()
    {
      AppMethodBeat.i(129999);
      this.dzV = (e.this.dzH * 2);
      this.dzW = e.this.dzH;
      this.dzX = new byte[this.dzV];
      AppMethodBeat.o(129999);
    }
    
    public final void run()
    {
      AppMethodBeat.i(130000);
      int j;
      if (!e.this.mIsPause)
      {
        j = (int)(0.8D * e.this.aam());
        i = j;
        if (j < e.this.dzH * 8) {
          i = e.this.dzH * 8;
        }
        if (e.this.aan() <= i) {
          break label140;
        }
      }
      label140:
      for (int i = 8;; i = 1)
      {
        j = 0;
        while (j < i)
        {
          int k = e.this.z(this.dzX, this.dzW);
          if ((e.this.dzN != null) && (k == 0)) {
            e.this.dzN.w(this.dzX, this.dzW);
          }
          j += 1;
        }
        AppMethodBeat.o(130000);
        return;
      }
    }
  }
  
  final class b
    implements com.tencent.f.i.h
  {
    volatile e.c dzY;
    
    b() {}
    
    public final String getKey()
    {
      return "RecordModeAsyncRead_record";
    }
    
    public final void run()
    {
      AppMethodBeat.i(130001);
      Log.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[] { Integer.valueOf(e.this.dzH) });
      if (-123456789 != e.this.dzk)
      {
        Log.i("MicroMsg.RecordModeAsyncRead", "set priority to " + e.this.dzk);
        Process.setThreadPriority(e.this.dzk);
      }
      for (;;)
      {
        synchronized (e.this.dzQ)
        {
          Log.i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), e.this.dzQ });
          if (1 != e.this.mStatus)
          {
            Log.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + e.this.mStatus);
            AppMethodBeat.o(130001);
            return;
          }
          e.this.mStatus = 2;
          ??? = new byte[e.this.dzH];
          if (2 == e.this.mStatus) {
            synchronized (e.this.dzP)
            {
              boolean bool = e.this.mIsPause;
              if (!bool) {}
            }
          }
        }
        try
        {
          e.this.dzP.wait();
          label237:
          if (2 != e.this.mStatus) {}
          Object localObject6;
          int i;
          for (;;)
          {
            if (this.dzY != null) {
              this.dzY.finish();
            }
            Log.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
            AppMethodBeat.o(130001);
            return;
            localObject4 = finally;
            AppMethodBeat.o(130001);
            throw localObject4;
            if (e.this.dzu == null)
            {
              Log.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
              synchronized (e.this.dzQ)
              {
                e.this.mStatus = 3;
              }
              localObject2 = finally;
              AppMethodBeat.o(130001);
              throw localObject2;
            }
            localObject6 = localObject2;
            if (e.this.dzg) {
              localObject6 = new byte[e.this.dzH];
            }
            e.this.dzZ += 1;
            new com.tencent.mm.compatible.util.f.a();
            i = e.this.dzu.read((byte[])localObject6, 0, e.this.dzH);
            if (2 == e.this.mStatus) {
              break;
            }
            Log.i("MicroMsg.RecordModeAsyncRead", "record mode has not been running and break");
          }
          if (e.this.dzD != null) {
            e.this.dzD.d(i, (byte[])localObject6);
          }
          if (e.this.dzH != i) {
            Log.i("MicroMsg.RecordModeAsyncRead", "read len ".concat(String.valueOf(i)));
          }
          if (i < e.this.dzH) {
            Log.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
          }
          try
          {
            Thread.sleep(10L);
            label530:
            Object localObject3 = localObject6;
            if (e.this.dzN == null) {
              continue;
            }
            localObject3 = localObject6;
            if (i <= 0) {
              continue;
            }
            int j = i;
            if (i > localObject6.length) {
              j = localObject6.length;
            }
            if (e.this.dzM != null)
            {
              if (e.this.mIsMute) {
                Arrays.fill((byte[])localObject6, 0, j, (byte)0);
              }
              localObject3 = e.this.dzM;
              if (j > 0)
              {
                if (((b)localObject3).gCK) {
                  ((b)localObject3).gCL.lock();
                }
                if (((b)localObject3).gCI != ((b)localObject3).gCJ) {
                  break label699;
                }
                i = ((b)localObject3).gCF;
                label643:
                if (j <= i) {
                  break label825;
                }
              }
              for (i = -1;; i = -1)
              {
                localObject3 = localObject6;
                if (i == 0) {
                  break;
                }
                Log.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(e.this.dzM.anD()) });
                localObject3 = localObject6;
                break;
                label699:
                if ((((b)localObject3).gCJ + 1) % ((b)localObject3).gCF == ((b)localObject3).gCI)
                {
                  i = 0;
                  break label643;
                }
                if (((b)localObject3).gCI < ((b)localObject3).gCJ) {
                  ((b)localObject3).gCG = (((b)localObject3).gCJ - ((b)localObject3).gCI);
                }
                for (;;)
                {
                  if (((b)localObject3).gCK) {
                    ((b)localObject3).gCL.unlock();
                  }
                  i = ((b)localObject3).gCF - ((b)localObject3).gCG;
                  break;
                  if (((b)localObject3).gCI > ((b)localObject3).gCJ) {
                    ((b)localObject3).gCG = (((b)localObject3).gCJ + ((b)localObject3).gCF - ((b)localObject3).gCI);
                  }
                }
                label825:
                if ((((b)localObject3).gCJ + j) % ((b)localObject3).gCF != ((b)localObject3).gCI) {
                  break label851;
                }
              }
              label851:
              if (((b)localObject3).gCK) {
                ((b)localObject3).gCL.lock();
              }
              if ((((b)localObject3).gCI < ((b)localObject3).gCJ) && (j > ((b)localObject3).gCF - ((b)localObject3).gCJ))
              {
                System.arraycopy(localObject6, 0, ((b)localObject3).gCH, ((b)localObject3).gCJ, ((b)localObject3).gCF - ((b)localObject3).gCJ);
                System.arraycopy(localObject6, ((b)localObject3).gCF - ((b)localObject3).gCJ, ((b)localObject3).gCH, 0, j - (((b)localObject3).gCF - ((b)localObject3).gCJ));
                ((b)localObject3).gCJ = (j - (((b)localObject3).gCF - ((b)localObject3).gCJ));
              }
              for (((b)localObject3).gCJ %= ((b)localObject3).gCF;; ((b)localObject3).gCJ = ((j + ((b)localObject3).gCJ) % ((b)localObject3).gCF))
              {
                if (((b)localObject3).gCK) {
                  ((b)localObject3).gCL.unlock();
                }
                i = 0;
                break;
                System.arraycopy(localObject6, 0, ((b)localObject3).gCH, ((b)localObject3).gCJ, j);
              }
            }
            localObject3 = localObject6;
            if (e.this.dzN == null) {
              continue;
            }
            if (e.this.mIsMute) {
              Arrays.fill((byte[])localObject6, 0, j, (byte)0);
            }
            e.this.dzN.w((byte[])localObject6, j);
            localObject3 = localObject6;
          }
          catch (InterruptedException localInterruptedException1)
          {
            break label530;
          }
        }
        catch (InterruptedException localInterruptedException2)
        {
          break label237;
        }
      }
    }
  }
  
  static abstract interface c
  {
    public abstract void finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.e
 * JD-Core Version:    0.7.0.1
 */