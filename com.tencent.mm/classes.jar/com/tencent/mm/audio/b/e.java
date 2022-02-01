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
  boolean dgS;
  final Object dhA;
  final byte[] dhB;
  final Object dhC;
  Timer dhD;
  boolean dhE;
  private boolean dhF;
  AudioRecord dhg;
  int dht;
  private int dhw;
  b dhx;
  b dhy;
  c.a dhz;
  boolean mIsMute;
  int mStatus;
  
  public e(AudioRecord paramAudioRecord, boolean paramBoolean1, int paramInt, c.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(130002);
    this.mStatus = 0;
    this.dhw = 12800;
    this.mIsMute = false;
    this.dhx = new b();
    this.dhy = null;
    this.dhA = new Object();
    this.dhB = new byte[0];
    this.dhC = new Object();
    this.dhD = null;
    this.dhE = false;
    this.dhF = false;
    this.dhg = paramAudioRecord;
    this.dgS = paramBoolean1;
    this.dht = paramInt;
    this.dhz = parama;
    this.dhF = paramBoolean2;
    AppMethodBeat.o(130002);
  }
  
  public final boolean PP()
  {
    int j = -1;
    AppMethodBeat.i(130003);
    ad.i("MicroMsg.RecordModeAsyncRead", "startRecord");
    int i;
    for (;;)
    {
      synchronized (this.dhC)
      {
        this.mStatus = 1;
        ad.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", new Object[] { com.tencent.e.h.LTK.fVt() });
        com.tencent.e.h.LTJ.aR(this.dhx);
        if (true != this.dhF) {
          break label356;
        }
        this.dhy = new b();
        if (this.dhy == null)
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
      this.dhw = (this.dht * 20);
      ad.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.dhw);
      ??? = this.dhy;
      i = this.dhw;
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
        ((b)???).fVv = new byte[i];
        if (((b)???).fVv == null)
        {
          i = -1;
        }
        else
        {
          ((b)???).fVt = i;
          if (((b)???).fVy) {
            ((b)???).fVz = new ReentrantLock();
          }
          i = 0;
        }
      }
      label242:
      i = 1;
    }
    if ((this.dhE) || (this.dhD != null))
    {
      ad.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.dhE);
      i = j;
    }
    while (i != 0)
    {
      ad.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
      AppMethodBeat.o(130003);
      return false;
      this.dhD = new Timer();
      i = j;
      if (this.dhD != null) {
        i = 0;
      }
    }
    this.dhD.scheduleAtFixedRate(new a(), 60L, 20L);
    this.dhE = true;
    label356:
    AppMethodBeat.o(130003);
    return true;
  }
  
  public final int PT()
  {
    synchronized (this.dhA)
    {
      if (this.dhy != null)
      {
        int i = this.dhy.fVt;
        return i;
      }
      return -1;
    }
  }
  
  public final int PU()
  {
    AppMethodBeat.i(130005);
    synchronized (this.dhA)
    {
      if (this.dhy != null)
      {
        int i = this.dhy.ZH();
        AppMethodBeat.o(130005);
        return i;
      }
      AppMethodBeat.o(130005);
      return -1;
    }
  }
  
  public final void cw(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(130004);
    ad.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
    synchronized (this.dhC)
    {
      this.mStatus = 3;
      this.dhx.dhK = new c()
      {
        public final void finish()
        {
          AppMethodBeat.i(129998);
          e.this.dhx.dhK = null;
          ad.i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
          if (e.this.dhy != null)
          {
            if (e.this.dhD != null)
            {
              e.this.dhD.cancel();
              e.this.dhD = null;
            }
            ??? = e.this.dhy;
            ((b)???).fVt = 0;
            ((b)???).fVu = 0;
            ((b)???).fVw = 0;
            ((b)???).fVx = 0;
            ((b)???).fVv = null;
          }
          synchronized (e.this.dhA)
          {
            e.this.dhy = null;
            e.this.dhz = null;
            e.this.dhE = false;
            e.this.dhy = null;
            AppMethodBeat.o(129998);
            return;
          }
        }
      };
    }
    synchronized (this.dhB)
    {
      this.dhB.notify();
      AppMethodBeat.o(130004);
      return;
      localObject2 = finally;
      AppMethodBeat.o(130004);
      throw localObject2;
    }
  }
  
  public final int x(byte[] paramArrayOfByte, int paramInt)
  {
    int j = -1;
    AppMethodBeat.i(130006);
    for (;;)
    {
      b localb;
      synchronized (this.dhA)
      {
        if (this.dhy == null) {
          break label300;
        }
        localb = this.dhy;
        i = j;
        if (paramInt > 0)
        {
          i = j;
          if (paramInt <= localb.ZH())
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
        if (localb.fVw == localb.fVx) {
          continue;
        }
        if (localb.fVy) {
          localb.fVz.lock();
        }
        if (localb.fVw < localb.fVx)
        {
          System.arraycopy(localb.fVv, localb.fVw, paramArrayOfByte, 0, paramInt);
          localb.fVw += paramInt;
          if (!localb.fVy) {
            break label310;
          }
          localb.fVz.unlock();
          break label310;
        }
        if (paramInt <= localb.fVt - localb.fVw)
        {
          System.arraycopy(localb.fVv, localb.fVw, paramArrayOfByte, 0, paramInt);
          localb.fVw += paramInt;
        }
      }
      System.arraycopy(localb.fVv, localb.fVw, paramArrayOfByte, 0, localb.fVt - localb.fVw);
      System.arraycopy(localb.fVv, 0, paramArrayOfByte, localb.fVt - localb.fVw, paramInt - (localb.fVt - localb.fVw));
      localb.fVw = (paramInt - (localb.fVt - localb.fVw));
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
    private int dhH;
    private int dhI;
    byte[] dhJ;
    
    a()
    {
      AppMethodBeat.i(129999);
      this.dhH = (e.this.dht * 2);
      this.dhI = e.this.dht;
      this.dhJ = new byte[this.dhH];
      AppMethodBeat.o(129999);
    }
    
    public final void run()
    {
      AppMethodBeat.i(130000);
      int j;
      if (!e.this.mIsPause)
      {
        j = (int)(0.8D * e.this.PT());
        i = j;
        if (j < e.this.dht * 8) {
          i = e.this.dht * 8;
        }
        if (e.this.PU() <= i) {
          break label140;
        }
      }
      label140:
      for (int i = 8;; i = 1)
      {
        j = 0;
        while (j < i)
        {
          int k = e.this.x(this.dhJ, this.dhI);
          if ((e.this.dhz != null) && (k == 0)) {
            e.this.dhz.u(this.dhJ, this.dhI);
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
    volatile e.c dhK;
    
    b() {}
    
    public final String getKey()
    {
      return "RecordModeAsyncRead_record";
    }
    
    public final void run()
    {
      AppMethodBeat.i(130001);
      ad.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[] { Integer.valueOf(e.this.dht) });
      if (-123456789 != e.this.dgW)
      {
        ad.i("MicroMsg.RecordModeAsyncRead", "set priority to " + e.this.dgW);
        Process.setThreadPriority(e.this.dgW);
      }
      for (;;)
      {
        synchronized (e.this.dhC)
        {
          ad.i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), e.this.dhC });
          if (1 != e.this.mStatus)
          {
            ad.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + e.this.mStatus);
            AppMethodBeat.o(130001);
            return;
          }
          e.this.mStatus = 2;
          ??? = new byte[e.this.dht];
          if (2 == e.this.mStatus) {
            synchronized (e.this.dhB)
            {
              boolean bool = e.this.mIsPause;
              if (!bool) {}
            }
          }
        }
        try
        {
          e.this.dhB.wait();
          label237:
          if (2 != e.this.mStatus) {}
          Object localObject6;
          int i;
          for (;;)
          {
            if (this.dhK != null) {
              this.dhK.finish();
            }
            ad.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
            AppMethodBeat.o(130001);
            return;
            localObject4 = finally;
            AppMethodBeat.o(130001);
            throw localObject4;
            if (e.this.dhg == null)
            {
              ad.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
              synchronized (e.this.dhC)
              {
                e.this.mStatus = 3;
              }
              localObject2 = finally;
              AppMethodBeat.o(130001);
              throw localObject2;
            }
            localObject6 = localObject2;
            if (e.this.dgS) {
              localObject6 = new byte[e.this.dht];
            }
            e.this.dhL += 1;
            new com.tencent.mm.compatible.util.f.a();
            i = e.this.dhg.read((byte[])localObject6, 0, e.this.dht);
            if (2 == e.this.mStatus) {
              break;
            }
            ad.i("MicroMsg.RecordModeAsyncRead", "record mode has not been running and break");
          }
          if (e.this.dhp != null) {
            e.this.dhp.d(i, (byte[])localObject6);
          }
          if (e.this.dht != i) {
            ad.i("MicroMsg.RecordModeAsyncRead", "read len ".concat(String.valueOf(i)));
          }
          if (i < e.this.dht) {
            ad.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
          }
          try
          {
            Thread.sleep(10L);
            label530:
            Object localObject3 = localObject6;
            if (e.this.dhz == null) {
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
            if (e.this.dhy != null)
            {
              if (e.this.mIsMute) {
                Arrays.fill((byte[])localObject6, 0, j, (byte)0);
              }
              localObject3 = e.this.dhy;
              if (j > 0)
              {
                if (((b)localObject3).fVy) {
                  ((b)localObject3).fVz.lock();
                }
                if (((b)localObject3).fVw != ((b)localObject3).fVx) {
                  break label699;
                }
                i = ((b)localObject3).fVt;
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
                ad.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(e.this.dhy.ZH()) });
                localObject3 = localObject6;
                break;
                label699:
                if ((((b)localObject3).fVx + 1) % ((b)localObject3).fVt == ((b)localObject3).fVw)
                {
                  i = 0;
                  break label643;
                }
                if (((b)localObject3).fVw < ((b)localObject3).fVx) {
                  ((b)localObject3).fVu = (((b)localObject3).fVx - ((b)localObject3).fVw);
                }
                for (;;)
                {
                  if (((b)localObject3).fVy) {
                    ((b)localObject3).fVz.unlock();
                  }
                  i = ((b)localObject3).fVt - ((b)localObject3).fVu;
                  break;
                  if (((b)localObject3).fVw > ((b)localObject3).fVx) {
                    ((b)localObject3).fVu = (((b)localObject3).fVx + ((b)localObject3).fVt - ((b)localObject3).fVw);
                  }
                }
                label825:
                if ((((b)localObject3).fVx + j) % ((b)localObject3).fVt != ((b)localObject3).fVw) {
                  break label851;
                }
              }
              label851:
              if (((b)localObject3).fVy) {
                ((b)localObject3).fVz.lock();
              }
              if ((((b)localObject3).fVw < ((b)localObject3).fVx) && (j > ((b)localObject3).fVt - ((b)localObject3).fVx))
              {
                System.arraycopy(localObject6, 0, ((b)localObject3).fVv, ((b)localObject3).fVx, ((b)localObject3).fVt - ((b)localObject3).fVx);
                System.arraycopy(localObject6, ((b)localObject3).fVt - ((b)localObject3).fVx, ((b)localObject3).fVv, 0, j - (((b)localObject3).fVt - ((b)localObject3).fVx));
                ((b)localObject3).fVx = (j - (((b)localObject3).fVt - ((b)localObject3).fVx));
              }
              for (((b)localObject3).fVx %= ((b)localObject3).fVt;; ((b)localObject3).fVx = ((j + ((b)localObject3).fVx) % ((b)localObject3).fVt))
              {
                if (((b)localObject3).fVy) {
                  ((b)localObject3).fVz.unlock();
                }
                i = 0;
                break;
                System.arraycopy(localObject6, 0, ((b)localObject3).fVv, ((b)localObject3).fVx, j);
              }
            }
            localObject3 = localObject6;
            if (e.this.dhz == null) {
              continue;
            }
            if (e.this.mIsMute) {
              Arrays.fill((byte[])localObject6, 0, j, (byte)0);
            }
            e.this.dhz.u((byte[])localObject6, j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.b.e
 * JD-Core Version:    0.7.0.1
 */