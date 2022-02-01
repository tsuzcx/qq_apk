package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.e.c;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  extends f
{
  boolean frV;
  b fsA;
  b fsB;
  c.a fsC;
  final Object fsD;
  final byte[] fsE;
  final Object fsF;
  Future<?> fsG;
  @Deprecated
  boolean fsH;
  private boolean fsI;
  AudioRecord fsj;
  int fsw;
  private int fsz;
  boolean mIsMute;
  int mStatus;
  
  public e(AudioRecord paramAudioRecord, boolean paramBoolean1, int paramInt, c.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(130002);
    this.mStatus = 0;
    this.fsz = 12800;
    this.mIsMute = false;
    this.fsA = new b();
    this.fsB = null;
    this.fsD = new Object();
    this.fsE = new byte[0];
    this.fsF = new Object();
    this.fsG = null;
    this.fsH = false;
    this.fsI = false;
    this.fsj = paramAudioRecord;
    this.frV = paramBoolean1;
    this.fsw = paramInt;
    this.fsC = parama;
    this.fsI = paramBoolean2;
    AppMethodBeat.o(130002);
  }
  
  public final boolean aeU()
  {
    int i = -1;
    AppMethodBeat.i(130003);
    Log.i("MicroMsg.RecordModeAsyncRead", "startRecord");
    for (;;)
    {
      synchronized (this.fsF)
      {
        this.mStatus = 1;
        Log.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", new Object[] { com.tencent.e.h.ZvH.ipD() });
        com.tencent.e.h.ZvG.be(this.fsA);
        if (true != this.fsI) {
          break label292;
        }
        this.fsB = new b();
        if (this.fsB == null)
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
      this.fsz = (this.fsw * 20);
      Log.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.fsz);
      ??? = this.fsB;
      int j = this.fsz;
      if (j <= 0) {}
      for (;;)
      {
        if (i == 0) {
          break label235;
        }
        Log.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
        i = 0;
        break;
        ((b)???).jmN = new byte[j];
        if (((b)???).jmN != null)
        {
          ((b)???).jmL = j;
          if (((b)???).jmQ) {
            ((b)???).jmR = new ReentrantLock();
          }
          i = 0;
        }
      }
      label235:
      i = 1;
    }
    if (this.fsG != null)
    {
      Log.e("MicroMsg.RecordModeAsyncRead", "startRecord failed : last record is NOT stopped now");
      AppMethodBeat.o(130003);
      return false;
    }
    this.fsG = com.tencent.e.h.ZvG.a(new a(), 60L, 20L);
    this.fsH = true;
    label292:
    AppMethodBeat.o(130003);
    return true;
  }
  
  public final int aeY()
  {
    synchronized (this.fsD)
    {
      if (this.fsB != null)
      {
        int i = this.fsB.jmL;
        return i;
      }
      return -1;
    }
  }
  
  public final int aeZ()
  {
    AppMethodBeat.i(130005);
    synchronized (this.fsD)
    {
      if (this.fsB != null)
      {
        int i = this.fsB.atF();
        AppMethodBeat.o(130005);
        return i;
      }
      AppMethodBeat.o(130005);
      return -1;
    }
  }
  
  public final void dE(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(130004);
    Log.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
    synchronized (this.fsF)
    {
      this.mStatus = 3;
      this.fsA.fsN = new c()
      {
        public final void finish()
        {
          AppMethodBeat.i(129998);
          e.this.fsA.fsN = null;
          Log.i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
          if (e.this.fsB != null)
          {
            if (e.this.fsG != null)
            {
              e.this.fsG.cancel(false);
              e.this.fsG = null;
            }
            ??? = e.this.fsB;
            ((b)???).jmL = 0;
            ((b)???).jmM = 0;
            ((b)???).jmO = 0;
            ((b)???).jmP = 0;
            ((b)???).jmN = null;
          }
          synchronized (e.this.fsD)
          {
            e.this.fsB = null;
            e.this.fsC = null;
            e.this.fsH = false;
            e.this.fsB = null;
            AppMethodBeat.o(129998);
            return;
          }
        }
      };
    }
    synchronized (this.fsE)
    {
      this.fsE.notify();
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
      synchronized (this.fsD)
      {
        if (this.fsB == null) {
          break label300;
        }
        localb = this.fsB;
        i = j;
        if (paramInt > 0)
        {
          i = j;
          if (paramInt <= localb.atF())
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
        if (localb.jmO == localb.jmP) {
          continue;
        }
        if (localb.jmQ) {
          localb.jmR.lock();
        }
        if (localb.jmO < localb.jmP)
        {
          System.arraycopy(localb.jmN, localb.jmO, paramArrayOfByte, 0, paramInt);
          localb.jmO += paramInt;
          if (!localb.jmQ) {
            break label310;
          }
          localb.jmR.unlock();
          break label310;
        }
        if (paramInt <= localb.jmL - localb.jmO)
        {
          System.arraycopy(localb.jmN, localb.jmO, paramArrayOfByte, 0, paramInt);
          localb.jmO += paramInt;
        }
      }
      System.arraycopy(localb.jmN, localb.jmO, paramArrayOfByte, 0, localb.jmL - localb.jmO);
      System.arraycopy(localb.jmN, 0, paramArrayOfByte, localb.jmL - localb.jmO, paramInt - (localb.jmL - localb.jmO));
      localb.jmO = (paramInt - (localb.jmL - localb.jmO));
      continue;
      label300:
      AppMethodBeat.o(130006);
      return -1;
      label310:
      int i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    private int fsK;
    private int fsL;
    byte[] fsM;
    
    a()
    {
      AppMethodBeat.i(129999);
      this.fsK = (e.this.fsw * 2);
      this.fsL = e.this.fsw;
      this.fsM = new byte[this.fsK];
      AppMethodBeat.o(129999);
    }
    
    public final void run()
    {
      AppMethodBeat.i(130000);
      int j;
      if (!e.this.mIsPause)
      {
        j = (int)(0.8D * e.this.aeY());
        i = j;
        if (j < e.this.fsw * 8) {
          i = e.this.fsw * 8;
        }
        if (e.this.aeZ() <= i) {
          break label140;
        }
      }
      label140:
      for (int i = 8;; i = 1)
      {
        j = 0;
        while (j < i)
        {
          int k = e.this.z(this.fsM, this.fsL);
          if ((e.this.fsC != null) && (k == 0)) {
            e.this.fsC.w(this.fsM, this.fsL);
          }
          j += 1;
        }
        AppMethodBeat.o(130000);
        return;
      }
    }
  }
  
  final class b
    implements com.tencent.e.i.h
  {
    volatile e.c fsN;
    
    b() {}
    
    public final String getKey()
    {
      return "RecordModeAsyncRead_record";
    }
    
    public final void run()
    {
      AppMethodBeat.i(130001);
      Log.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[] { Integer.valueOf(e.this.fsw) });
      if (-123456789 != e.this.frZ)
      {
        Log.i("MicroMsg.RecordModeAsyncRead", "set priority to " + e.this.frZ);
        Process.setThreadPriority(e.this.frZ);
      }
      for (;;)
      {
        synchronized (e.this.fsF)
        {
          Log.i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), e.this.fsF });
          if (1 != e.this.mStatus)
          {
            Log.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + e.this.mStatus);
            AppMethodBeat.o(130001);
            return;
          }
          e.this.mStatus = 2;
          ??? = new byte[e.this.fsw];
          if (2 == e.this.mStatus) {
            synchronized (e.this.fsE)
            {
              boolean bool = e.this.mIsPause;
              if (!bool) {}
            }
          }
        }
        try
        {
          e.this.fsE.wait();
          label237:
          if (2 != e.this.mStatus) {}
          Object localObject6;
          int i;
          for (;;)
          {
            if (this.fsN != null) {
              this.fsN.finish();
            }
            Log.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
            AppMethodBeat.o(130001);
            return;
            localObject4 = finally;
            AppMethodBeat.o(130001);
            throw localObject4;
            if (e.this.fsj == null)
            {
              Log.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
              synchronized (e.this.fsF)
              {
                e.this.mStatus = 3;
              }
              localObject2 = finally;
              AppMethodBeat.o(130001);
              throw localObject2;
            }
            localObject6 = localObject2;
            if (e.this.frV) {
              localObject6 = new byte[e.this.fsw];
            }
            e.this.fsO += 1;
            new com.tencent.mm.compatible.util.f.a();
            i = e.this.fsj.read((byte[])localObject6, 0, e.this.fsw);
            if (2 == e.this.mStatus) {
              break;
            }
            Log.i("MicroMsg.RecordModeAsyncRead", "record mode has not been running and break");
          }
          if (e.this.fss != null) {
            e.this.fss.d(i, (byte[])localObject6);
          }
          if (e.this.fsw != i) {
            Log.i("MicroMsg.RecordModeAsyncRead", "read len ".concat(String.valueOf(i)));
          }
          if (i < e.this.fsw) {
            Log.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
          }
          try
          {
            Thread.sleep(10L);
            label530:
            Object localObject3 = localObject6;
            if (e.this.fsC == null) {
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
            if (e.this.fsB != null)
            {
              if (e.this.mIsMute) {
                Arrays.fill((byte[])localObject6, 0, j, (byte)0);
              }
              localObject3 = e.this.fsB;
              if (j > 0)
              {
                if (((b)localObject3).jmQ) {
                  ((b)localObject3).jmR.lock();
                }
                if (((b)localObject3).jmO != ((b)localObject3).jmP) {
                  break label699;
                }
                i = ((b)localObject3).jmL;
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
                Log.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(e.this.fsB.atF()) });
                localObject3 = localObject6;
                break;
                label699:
                if ((((b)localObject3).jmP + 1) % ((b)localObject3).jmL == ((b)localObject3).jmO)
                {
                  i = 0;
                  break label643;
                }
                if (((b)localObject3).jmO < ((b)localObject3).jmP) {
                  ((b)localObject3).jmM = (((b)localObject3).jmP - ((b)localObject3).jmO);
                }
                for (;;)
                {
                  if (((b)localObject3).jmQ) {
                    ((b)localObject3).jmR.unlock();
                  }
                  i = ((b)localObject3).jmL - ((b)localObject3).jmM;
                  break;
                  if (((b)localObject3).jmO > ((b)localObject3).jmP) {
                    ((b)localObject3).jmM = (((b)localObject3).jmP + ((b)localObject3).jmL - ((b)localObject3).jmO);
                  }
                }
                label825:
                if ((((b)localObject3).jmP + j) % ((b)localObject3).jmL != ((b)localObject3).jmO) {
                  break label851;
                }
              }
              label851:
              if (((b)localObject3).jmQ) {
                ((b)localObject3).jmR.lock();
              }
              if ((((b)localObject3).jmO < ((b)localObject3).jmP) && (j > ((b)localObject3).jmL - ((b)localObject3).jmP))
              {
                System.arraycopy(localObject6, 0, ((b)localObject3).jmN, ((b)localObject3).jmP, ((b)localObject3).jmL - ((b)localObject3).jmP);
                System.arraycopy(localObject6, ((b)localObject3).jmL - ((b)localObject3).jmP, ((b)localObject3).jmN, 0, j - (((b)localObject3).jmL - ((b)localObject3).jmP));
                ((b)localObject3).jmP = (j - (((b)localObject3).jmL - ((b)localObject3).jmP));
              }
              for (((b)localObject3).jmP %= ((b)localObject3).jmL;; ((b)localObject3).jmP = ((j + ((b)localObject3).jmP) % ((b)localObject3).jmL))
              {
                if (((b)localObject3).jmQ) {
                  ((b)localObject3).jmR.unlock();
                }
                i = 0;
                break;
                System.arraycopy(localObject6, 0, ((b)localObject3).jmN, ((b)localObject3).jmP, j);
              }
            }
            localObject3 = localObject6;
            if (e.this.fsC == null) {
              continue;
            }
            if (e.this.mIsMute) {
              Arrays.fill((byte[])localObject6, 0, j, (byte)0);
            }
            e.this.fsC.w((byte[])localObject6, j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.b.e
 * JD-Core Version:    0.7.0.1
 */