package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.e.c;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  extends f
{
  boolean cVC;
  AudioRecord cVQ;
  int cWd;
  private int cWg;
  b cWh;
  b cWi;
  c.a cWj;
  final Object cWk;
  final byte[] cWl;
  final Object cWm;
  Timer cWn;
  boolean cWo;
  private boolean cWp;
  boolean mIsMute;
  int mStatus;
  
  public e(AudioRecord paramAudioRecord, boolean paramBoolean1, int paramInt, c.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(130002);
    this.mStatus = 0;
    this.cWg = 12800;
    this.mIsMute = false;
    this.cWh = new b();
    this.cWi = null;
    this.cWk = new Object();
    this.cWl = new byte[0];
    this.cWm = new Object();
    this.cWn = null;
    this.cWo = false;
    this.cWp = false;
    this.cVQ = paramAudioRecord;
    this.cVC = paramBoolean1;
    this.cWd = paramInt;
    this.cWj = parama;
    this.cWp = paramBoolean2;
    AppMethodBeat.o(130002);
  }
  
  public final boolean Og()
  {
    int j = -1;
    AppMethodBeat.i(130003);
    ac.i("MicroMsg.RecordModeAsyncRead", "startRecord");
    int i;
    for (;;)
    {
      synchronized (this.cWm)
      {
        this.mStatus = 1;
        ac.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", new Object[] { com.tencent.e.h.JZO.fEb() });
        com.tencent.e.h.JZN.aS(this.cWh);
        if (true != this.cWp) {
          break label356;
        }
        this.cWi = new b();
        if (this.cWi == null)
        {
          ac.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
          i = 0;
          if (i != 0) {
            break;
          }
          ac.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
          AppMethodBeat.o(130003);
          return false;
        }
      }
      this.cWg = (this.cWd * 20);
      ac.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.cWg);
      ??? = this.cWi;
      i = this.cWg;
      if (i <= 0) {
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label242;
        }
        ac.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
        i = 0;
        break;
        ((b)???).fCh = new byte[i];
        if (((b)???).fCh == null)
        {
          i = -1;
        }
        else
        {
          ((b)???).fCf = i;
          if (((b)???).fCk) {
            ((b)???).fCl = new ReentrantLock();
          }
          i = 0;
        }
      }
      label242:
      i = 1;
    }
    if ((this.cWo) || (this.cWn != null))
    {
      ac.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.cWo);
      i = j;
    }
    while (i != 0)
    {
      ac.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
      AppMethodBeat.o(130003);
      return false;
      this.cWn = new Timer();
      i = j;
      if (this.cWn != null) {
        i = 0;
      }
    }
    this.cWn.scheduleAtFixedRate(new a(), 60L, 20L);
    this.cWo = true;
    label356:
    AppMethodBeat.o(130003);
    return true;
  }
  
  public final int Ok()
  {
    synchronized (this.cWk)
    {
      if (this.cWi != null)
      {
        int i = this.cWi.fCf;
        return i;
      }
      return -1;
    }
  }
  
  public final int Ol()
  {
    AppMethodBeat.i(130005);
    synchronized (this.cWk)
    {
      if (this.cWi != null)
      {
        int i = this.cWi.Xg();
        AppMethodBeat.o(130005);
        return i;
      }
      AppMethodBeat.o(130005);
      return -1;
    }
  }
  
  public final void cu(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(130004);
    ac.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
    synchronized (this.cWm)
    {
      this.mStatus = 3;
      this.cWh.cWu = new c()
      {
        public final void finish()
        {
          AppMethodBeat.i(129998);
          e.this.cWh.cWu = null;
          ac.i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
          if (e.this.cWi != null)
          {
            if (e.this.cWn != null)
            {
              e.this.cWn.cancel();
              e.this.cWn = null;
            }
            ??? = e.this.cWi;
            ((b)???).fCf = 0;
            ((b)???).fCg = 0;
            ((b)???).fCi = 0;
            ((b)???).fCj = 0;
            ((b)???).fCh = null;
          }
          synchronized (e.this.cWk)
          {
            e.this.cWi = null;
            e.this.cWj = null;
            e.this.cWo = false;
            e.this.cWi = null;
            AppMethodBeat.o(129998);
            return;
          }
        }
      };
    }
    synchronized (this.cWl)
    {
      this.cWl.notify();
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
      synchronized (this.cWk)
      {
        if (this.cWi == null) {
          break label300;
        }
        localb = this.cWi;
        i = j;
        if (paramInt > 0)
        {
          i = j;
          if (paramInt <= localb.Xg())
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
        if (localb.fCi == localb.fCj) {
          continue;
        }
        if (localb.fCk) {
          localb.fCl.lock();
        }
        if (localb.fCi < localb.fCj)
        {
          System.arraycopy(localb.fCh, localb.fCi, paramArrayOfByte, 0, paramInt);
          localb.fCi += paramInt;
          if (!localb.fCk) {
            break label310;
          }
          localb.fCl.unlock();
          break label310;
        }
        if (paramInt <= localb.fCf - localb.fCi)
        {
          System.arraycopy(localb.fCh, localb.fCi, paramArrayOfByte, 0, paramInt);
          localb.fCi += paramInt;
        }
      }
      System.arraycopy(localb.fCh, localb.fCi, paramArrayOfByte, 0, localb.fCf - localb.fCi);
      System.arraycopy(localb.fCh, 0, paramArrayOfByte, localb.fCf - localb.fCi, paramInt - (localb.fCf - localb.fCi));
      localb.fCi = (paramInt - (localb.fCf - localb.fCi));
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
    private int cWr;
    private int cWs;
    byte[] cWt;
    
    a()
    {
      AppMethodBeat.i(129999);
      this.cWr = (e.this.cWd * 2);
      this.cWs = e.this.cWd;
      this.cWt = new byte[this.cWr];
      AppMethodBeat.o(129999);
    }
    
    public final void run()
    {
      AppMethodBeat.i(130000);
      int j;
      if (!e.this.mIsPause)
      {
        j = (int)(0.8D * e.this.Ok());
        i = j;
        if (j < e.this.cWd * 8) {
          i = e.this.cWd * 8;
        }
        if (e.this.Ol() <= i) {
          break label140;
        }
      }
      label140:
      for (int i = 8;; i = 1)
      {
        j = 0;
        while (j < i)
        {
          int k = e.this.x(this.cWt, this.cWs);
          if ((e.this.cWj != null) && (k == 0)) {
            e.this.cWj.u(this.cWt, this.cWs);
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
    volatile e.c cWu;
    
    b() {}
    
    public final String getKey()
    {
      return "RecordModeAsyncRead_record";
    }
    
    public final void run()
    {
      AppMethodBeat.i(130001);
      ac.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[] { Integer.valueOf(e.this.cWd) });
      if (-123456789 != e.this.cVG)
      {
        ac.i("MicroMsg.RecordModeAsyncRead", "set priority to " + e.this.cVG);
        Process.setThreadPriority(e.this.cVG);
      }
      for (;;)
      {
        synchronized (e.this.cWm)
        {
          ac.i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), e.this.cWm });
          if (1 != e.this.mStatus)
          {
            ac.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + e.this.mStatus);
            AppMethodBeat.o(130001);
            return;
          }
          e.this.mStatus = 2;
          ??? = new byte[e.this.cWd];
          if (2 == e.this.mStatus) {
            synchronized (e.this.cWl)
            {
              boolean bool = e.this.mIsPause;
              if (!bool) {}
            }
          }
        }
        try
        {
          e.this.cWl.wait();
          label237:
          if (2 != e.this.mStatus) {}
          Object localObject6;
          int i;
          for (;;)
          {
            if (this.cWu != null) {
              this.cWu.finish();
            }
            ac.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
            AppMethodBeat.o(130001);
            return;
            localObject4 = finally;
            AppMethodBeat.o(130001);
            throw localObject4;
            if (e.this.cVQ == null)
            {
              ac.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
              synchronized (e.this.cWm)
              {
                e.this.mStatus = 3;
              }
              localObject2 = finally;
              AppMethodBeat.o(130001);
              throw localObject2;
            }
            localObject6 = localObject2;
            if (e.this.cVC) {
              localObject6 = new byte[e.this.cWd];
            }
            e.this.cWv += 1;
            new com.tencent.mm.compatible.util.f.a();
            i = e.this.cVQ.read((byte[])localObject6, 0, e.this.cWd);
            if (2 == e.this.mStatus) {
              break;
            }
            ac.i("MicroMsg.RecordModeAsyncRead", "record mode has not been running and break");
          }
          if (e.this.cVZ != null) {
            e.this.cVZ.d(i, (byte[])localObject6);
          }
          if (e.this.cWd != i) {
            ac.i("MicroMsg.RecordModeAsyncRead", "read len ".concat(String.valueOf(i)));
          }
          if (i < e.this.cWd) {
            ac.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
          }
          try
          {
            Thread.sleep(10L);
            label530:
            Object localObject3 = localObject6;
            if (e.this.cWj == null) {
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
            if (e.this.cWi != null)
            {
              if (e.this.mIsMute) {
                Arrays.fill((byte[])localObject6, 0, j, (byte)0);
              }
              localObject3 = e.this.cWi;
              if (j > 0)
              {
                if (((b)localObject3).fCk) {
                  ((b)localObject3).fCl.lock();
                }
                if (((b)localObject3).fCi != ((b)localObject3).fCj) {
                  break label699;
                }
                i = ((b)localObject3).fCf;
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
                ac.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(e.this.cWi.Xg()) });
                localObject3 = localObject6;
                break;
                label699:
                if ((((b)localObject3).fCj + 1) % ((b)localObject3).fCf == ((b)localObject3).fCi)
                {
                  i = 0;
                  break label643;
                }
                if (((b)localObject3).fCi < ((b)localObject3).fCj) {
                  ((b)localObject3).fCg = (((b)localObject3).fCj - ((b)localObject3).fCi);
                }
                for (;;)
                {
                  if (((b)localObject3).fCk) {
                    ((b)localObject3).fCl.unlock();
                  }
                  i = ((b)localObject3).fCf - ((b)localObject3).fCg;
                  break;
                  if (((b)localObject3).fCi > ((b)localObject3).fCj) {
                    ((b)localObject3).fCg = (((b)localObject3).fCj + ((b)localObject3).fCf - ((b)localObject3).fCi);
                  }
                }
                label825:
                if ((((b)localObject3).fCj + j) % ((b)localObject3).fCf != ((b)localObject3).fCi) {
                  break label851;
                }
              }
              label851:
              if (((b)localObject3).fCk) {
                ((b)localObject3).fCl.lock();
              }
              if ((((b)localObject3).fCi < ((b)localObject3).fCj) && (j > ((b)localObject3).fCf - ((b)localObject3).fCj))
              {
                System.arraycopy(localObject6, 0, ((b)localObject3).fCh, ((b)localObject3).fCj, ((b)localObject3).fCf - ((b)localObject3).fCj);
                System.arraycopy(localObject6, ((b)localObject3).fCf - ((b)localObject3).fCj, ((b)localObject3).fCh, 0, j - (((b)localObject3).fCf - ((b)localObject3).fCj));
                ((b)localObject3).fCj = (j - (((b)localObject3).fCf - ((b)localObject3).fCj));
              }
              for (((b)localObject3).fCj %= ((b)localObject3).fCf;; ((b)localObject3).fCj = ((j + ((b)localObject3).fCj) % ((b)localObject3).fCf))
              {
                if (((b)localObject3).fCk) {
                  ((b)localObject3).fCl.unlock();
                }
                i = 0;
                break;
                System.arraycopy(localObject6, 0, ((b)localObject3).fCh, ((b)localObject3).fCj, j);
              }
            }
            localObject3 = localObject6;
            if (e.this.cWj == null) {
              continue;
            }
            if (e.this.mIsMute) {
              Arrays.fill((byte[])localObject6, 0, j, (byte)0);
            }
            e.this.cWj.u((byte[])localObject6, j);
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