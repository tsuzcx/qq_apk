package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.e.c;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  extends f
{
  int cYH;
  private int cYK;
  b cYL;
  b cYM;
  c.a cYN;
  final Object cYO;
  final byte[] cYP;
  final Object cYQ;
  Timer cYR;
  boolean cYS;
  private boolean cYT;
  boolean cYg;
  AudioRecord cYu;
  boolean mIsMute;
  int mStatus;
  
  public e(AudioRecord paramAudioRecord, boolean paramBoolean1, int paramInt, c.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(130002);
    this.mStatus = 0;
    this.cYK = 12800;
    this.mIsMute = false;
    this.cYL = new b();
    this.cYM = null;
    this.cYO = new Object();
    this.cYP = new byte[0];
    this.cYQ = new Object();
    this.cYR = null;
    this.cYS = false;
    this.cYT = false;
    this.cYu = paramAudioRecord;
    this.cYg = paramBoolean1;
    this.cYH = paramInt;
    this.cYN = parama;
    this.cYT = paramBoolean2;
    AppMethodBeat.o(130002);
  }
  
  public final boolean Ok()
  {
    int j = -1;
    AppMethodBeat.i(130003);
    ad.i("MicroMsg.RecordModeAsyncRead", "startRecord");
    int i;
    for (;;)
    {
      synchronized (this.cYQ)
      {
        this.mStatus = 1;
        ad.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", new Object[] { com.tencent.e.h.Iyf.fnL() });
        com.tencent.e.h.Iye.aP(this.cYL);
        if (true != this.cYT) {
          break label356;
        }
        this.cYM = new b();
        if (this.cYM == null)
        {
          ad.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
          i = 0;
          if (i != 0) {
            break;
          }
          ad.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
          AppMethodBeat.o(130003);
          return false;
        }
      }
      this.cYK = (this.cYH * 20);
      ad.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.cYK);
      ??? = this.cYM;
      i = this.cYK;
      if (i <= 0) {
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label242;
        }
        ad.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
        i = 0;
        break;
        ((b)???).fyA = new byte[i];
        if (((b)???).fyA == null)
        {
          i = -1;
        }
        else
        {
          ((b)???).fyy = i;
          if (((b)???).fyD) {
            ((b)???).fyE = new ReentrantLock();
          }
          i = 0;
        }
      }
      label242:
      i = 1;
    }
    if ((this.cYS) || (this.cYR != null))
    {
      ad.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.cYS);
      i = j;
    }
    while (i != 0)
    {
      ad.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
      AppMethodBeat.o(130003);
      return false;
      this.cYR = new Timer();
      i = j;
      if (this.cYR != null) {
        i = 0;
      }
    }
    this.cYR.scheduleAtFixedRate(new a(), 60L, 20L);
    this.cYS = true;
    label356:
    AppMethodBeat.o(130003);
    return true;
  }
  
  public final int Oo()
  {
    synchronized (this.cYO)
    {
      if (this.cYM != null)
      {
        int i = this.cYM.fyy;
        return i;
      }
      return -1;
    }
  }
  
  public final int Op()
  {
    AppMethodBeat.i(130005);
    synchronized (this.cYO)
    {
      if (this.cYM != null)
      {
        int i = this.cYM.Wi();
        AppMethodBeat.o(130005);
        return i;
      }
      AppMethodBeat.o(130005);
      return -1;
    }
  }
  
  public final void ct(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(130004);
    ad.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
    synchronized (this.cYQ)
    {
      this.mStatus = 3;
      this.cYL.cYY = new c()
      {
        public final void finish()
        {
          AppMethodBeat.i(129998);
          e.this.cYL.cYY = null;
          ad.i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
          if (e.this.cYM != null)
          {
            if (e.this.cYR != null)
            {
              e.this.cYR.cancel();
              e.this.cYR = null;
            }
            ??? = e.this.cYM;
            ((b)???).fyy = 0;
            ((b)???).fyz = 0;
            ((b)???).fyB = 0;
            ((b)???).fyC = 0;
            ((b)???).fyA = null;
          }
          synchronized (e.this.cYO)
          {
            e.this.cYM = null;
            e.this.cYN = null;
            e.this.cYS = false;
            e.this.cYM = null;
            AppMethodBeat.o(129998);
            return;
          }
        }
      };
    }
    synchronized (this.cYP)
    {
      this.cYP.notify();
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
      synchronized (this.cYO)
      {
        if (this.cYM == null) {
          break label300;
        }
        localb = this.cYM;
        i = j;
        if (paramInt > 0)
        {
          i = j;
          if (paramInt <= localb.Wi())
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
        if (localb.fyB == localb.fyC) {
          continue;
        }
        if (localb.fyD) {
          localb.fyE.lock();
        }
        if (localb.fyB < localb.fyC)
        {
          System.arraycopy(localb.fyA, localb.fyB, paramArrayOfByte, 0, paramInt);
          localb.fyB += paramInt;
          if (!localb.fyD) {
            break label310;
          }
          localb.fyE.unlock();
          break label310;
        }
        if (paramInt <= localb.fyy - localb.fyB)
        {
          System.arraycopy(localb.fyA, localb.fyB, paramArrayOfByte, 0, paramInt);
          localb.fyB += paramInt;
        }
      }
      System.arraycopy(localb.fyA, localb.fyB, paramArrayOfByte, 0, localb.fyy - localb.fyB);
      System.arraycopy(localb.fyA, 0, paramArrayOfByte, localb.fyy - localb.fyB, paramInt - (localb.fyy - localb.fyB));
      localb.fyB = (paramInt - (localb.fyy - localb.fyB));
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
    private int cYV;
    private int cYW;
    byte[] cYX;
    
    a()
    {
      AppMethodBeat.i(129999);
      this.cYV = (e.this.cYH * 2);
      this.cYW = e.this.cYH;
      this.cYX = new byte[this.cYV];
      AppMethodBeat.o(129999);
    }
    
    public final void run()
    {
      AppMethodBeat.i(130000);
      int j;
      if (!e.this.mIsPause)
      {
        j = (int)(0.8D * e.this.Oo());
        i = j;
        if (j < e.this.cYH * 8) {
          i = e.this.cYH * 8;
        }
        if (e.this.Op() <= i) {
          break label140;
        }
      }
      label140:
      for (int i = 8;; i = 1)
      {
        j = 0;
        while (j < i)
        {
          int k = e.this.z(this.cYX, this.cYW);
          if ((e.this.cYN != null) && (k == 0)) {
            e.this.cYN.w(this.cYX, this.cYW);
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
    volatile e.c cYY;
    
    b() {}
    
    public final String getKey()
    {
      return "RecordModeAsyncRead_record";
    }
    
    public final void run()
    {
      AppMethodBeat.i(130001);
      ad.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[] { Integer.valueOf(e.this.cYH) });
      if (-123456789 != e.this.cYk)
      {
        ad.i("MicroMsg.RecordModeAsyncRead", "set priority to " + e.this.cYk);
        Process.setThreadPriority(e.this.cYk);
      }
      for (;;)
      {
        synchronized (e.this.cYQ)
        {
          ad.i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), e.this.cYQ });
          if (1 != e.this.mStatus)
          {
            ad.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + e.this.mStatus);
            AppMethodBeat.o(130001);
            return;
          }
          e.this.mStatus = 2;
          ??? = new byte[e.this.cYH];
          if (2 == e.this.mStatus) {
            synchronized (e.this.cYP)
            {
              boolean bool = e.this.mIsPause;
              if (!bool) {}
            }
          }
        }
        try
        {
          e.this.cYP.wait();
          label237:
          if (2 != e.this.mStatus) {}
          Object localObject6;
          int i;
          for (;;)
          {
            if (this.cYY != null) {
              this.cYY.finish();
            }
            ad.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
            AppMethodBeat.o(130001);
            return;
            localObject4 = finally;
            AppMethodBeat.o(130001);
            throw localObject4;
            if (e.this.cYu == null)
            {
              ad.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
              synchronized (e.this.cYQ)
              {
                e.this.mStatus = 3;
              }
              localObject2 = finally;
              AppMethodBeat.o(130001);
              throw localObject2;
            }
            localObject6 = localObject2;
            if (e.this.cYg) {
              localObject6 = new byte[e.this.cYH];
            }
            e.this.cYZ += 1;
            new com.tencent.mm.compatible.util.f.a();
            i = e.this.cYu.read((byte[])localObject6, 0, e.this.cYH);
            if (2 == e.this.mStatus) {
              break;
            }
            ad.i("MicroMsg.RecordModeAsyncRead", "record mode has not been running and break");
          }
          if (e.this.cYD != null) {
            e.this.cYD.d(i, (byte[])localObject6);
          }
          if (e.this.cYH != i) {
            ad.i("MicroMsg.RecordModeAsyncRead", "read len ".concat(String.valueOf(i)));
          }
          if (i < e.this.cYH) {
            ad.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
          }
          try
          {
            Thread.sleep(10L);
            label530:
            Object localObject3 = localObject6;
            if (e.this.cYN == null) {
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
            if (e.this.cYM != null)
            {
              if (e.this.mIsMute) {
                Arrays.fill((byte[])localObject6, 0, j, (byte)0);
              }
              localObject3 = e.this.cYM;
              if (j > 0)
              {
                if (((b)localObject3).fyD) {
                  ((b)localObject3).fyE.lock();
                }
                if (((b)localObject3).fyB != ((b)localObject3).fyC) {
                  break label699;
                }
                i = ((b)localObject3).fyy;
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
                ad.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(e.this.cYM.Wi()) });
                localObject3 = localObject6;
                break;
                label699:
                if ((((b)localObject3).fyC + 1) % ((b)localObject3).fyy == ((b)localObject3).fyB)
                {
                  i = 0;
                  break label643;
                }
                if (((b)localObject3).fyB < ((b)localObject3).fyC) {
                  ((b)localObject3).fyz = (((b)localObject3).fyC - ((b)localObject3).fyB);
                }
                for (;;)
                {
                  if (((b)localObject3).fyD) {
                    ((b)localObject3).fyE.unlock();
                  }
                  i = ((b)localObject3).fyy - ((b)localObject3).fyz;
                  break;
                  if (((b)localObject3).fyB > ((b)localObject3).fyC) {
                    ((b)localObject3).fyz = (((b)localObject3).fyC + ((b)localObject3).fyy - ((b)localObject3).fyB);
                  }
                }
                label825:
                if ((((b)localObject3).fyC + j) % ((b)localObject3).fyy != ((b)localObject3).fyB) {
                  break label851;
                }
              }
              label851:
              if (((b)localObject3).fyD) {
                ((b)localObject3).fyE.lock();
              }
              if ((((b)localObject3).fyB < ((b)localObject3).fyC) && (j > ((b)localObject3).fyy - ((b)localObject3).fyC))
              {
                System.arraycopy(localObject6, 0, ((b)localObject3).fyA, ((b)localObject3).fyC, ((b)localObject3).fyy - ((b)localObject3).fyC);
                System.arraycopy(localObject6, ((b)localObject3).fyy - ((b)localObject3).fyC, ((b)localObject3).fyA, 0, j - (((b)localObject3).fyy - ((b)localObject3).fyC));
                ((b)localObject3).fyC = (j - (((b)localObject3).fyy - ((b)localObject3).fyC));
              }
              for (((b)localObject3).fyC %= ((b)localObject3).fyy;; ((b)localObject3).fyC = ((j + ((b)localObject3).fyC) % ((b)localObject3).fyy))
              {
                if (((b)localObject3).fyD) {
                  ((b)localObject3).fyE.unlock();
                }
                i = 0;
                break;
                System.arraycopy(localObject6, 0, ((b)localObject3).fyA, ((b)localObject3).fyC, j);
              }
            }
            localObject3 = localObject6;
            if (e.this.cYN == null) {
              continue;
            }
            if (e.this.mIsMute) {
              Arrays.fill((byte[])localObject6, 0, j, (byte)0);
            }
            e.this.cYN.w((byte[])localObject6, j);
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