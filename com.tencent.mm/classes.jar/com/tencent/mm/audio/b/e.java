package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.e.c;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  extends f
{
  boolean dhU;
  b diA;
  b diB;
  c.a diC;
  final Object diD;
  final byte[] diE;
  final Object diF;
  Timer diG;
  boolean diH;
  private boolean diI;
  AudioRecord dii;
  int diw;
  private int diz;
  boolean mIsMute;
  int mStatus;
  
  public e(AudioRecord paramAudioRecord, boolean paramBoolean1, int paramInt, c.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(130002);
    this.mStatus = 0;
    this.diz = 12800;
    this.mIsMute = false;
    this.diA = new b();
    this.diB = null;
    this.diD = new Object();
    this.diE = new byte[0];
    this.diF = new Object();
    this.diG = null;
    this.diH = false;
    this.diI = false;
    this.dii = paramAudioRecord;
    this.dhU = paramBoolean1;
    this.diw = paramInt;
    this.diC = parama;
    this.diI = paramBoolean2;
    AppMethodBeat.o(130002);
  }
  
  public final boolean PO()
  {
    int j = -1;
    AppMethodBeat.i(130003);
    ae.i("MicroMsg.RecordModeAsyncRead", "startRecord");
    int i;
    for (;;)
    {
      synchronized (this.diF)
      {
        this.mStatus = 1;
        ae.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", new Object[] { com.tencent.e.h.MqG.fZS() });
        com.tencent.e.h.MqF.aO(this.diA);
        if (true != this.diI) {
          break label356;
        }
        this.diB = new b();
        if (this.diB == null)
        {
          ae.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
          i = 0;
          if (i != 0) {
            break;
          }
          ae.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
          AppMethodBeat.o(130003);
          return false;
        }
      }
      this.diz = (this.diw * 20);
      ae.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.diz);
      ??? = this.diB;
      i = this.diz;
      if (i <= 0) {
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label242;
        }
        ae.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
        i = 0;
        break;
        ((b)???).fXB = new byte[i];
        if (((b)???).fXB == null)
        {
          i = -1;
        }
        else
        {
          ((b)???).fXz = i;
          if (((b)???).fXE) {
            ((b)???).fXF = new ReentrantLock();
          }
          i = 0;
        }
      }
      label242:
      i = 1;
    }
    if ((this.diH) || (this.diG != null))
    {
      ae.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.diH);
      i = j;
    }
    while (i != 0)
    {
      ae.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
      AppMethodBeat.o(130003);
      return false;
      this.diG = new Timer();
      i = j;
      if (this.diG != null) {
        i = 0;
      }
    }
    this.diG.scheduleAtFixedRate(new a(), 60L, 20L);
    this.diH = true;
    label356:
    AppMethodBeat.o(130003);
    return true;
  }
  
  public final int PS()
  {
    synchronized (this.diD)
    {
      if (this.diB != null)
      {
        int i = this.diB.fXz;
        return i;
      }
      return -1;
    }
  }
  
  public final int PT()
  {
    AppMethodBeat.i(130005);
    synchronized (this.diD)
    {
      if (this.diB != null)
      {
        int i = this.diB.ZQ();
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
    ae.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
    synchronized (this.diF)
    {
      this.mStatus = 3;
      this.diA.diN = new c()
      {
        public final void finish()
        {
          AppMethodBeat.i(129998);
          e.this.diA.diN = null;
          ae.i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
          if (e.this.diB != null)
          {
            if (e.this.diG != null)
            {
              e.this.diG.cancel();
              e.this.diG = null;
            }
            ??? = e.this.diB;
            ((b)???).fXz = 0;
            ((b)???).fXA = 0;
            ((b)???).fXC = 0;
            ((b)???).fXD = 0;
            ((b)???).fXB = null;
          }
          synchronized (e.this.diD)
          {
            e.this.diB = null;
            e.this.diC = null;
            e.this.diH = false;
            e.this.diB = null;
            AppMethodBeat.o(129998);
            return;
          }
        }
      };
    }
    synchronized (this.diE)
    {
      this.diE.notify();
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
      synchronized (this.diD)
      {
        if (this.diB == null) {
          break label300;
        }
        localb = this.diB;
        i = j;
        if (paramInt > 0)
        {
          i = j;
          if (paramInt <= localb.ZQ())
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
        if (localb.fXC == localb.fXD) {
          continue;
        }
        if (localb.fXE) {
          localb.fXF.lock();
        }
        if (localb.fXC < localb.fXD)
        {
          System.arraycopy(localb.fXB, localb.fXC, paramArrayOfByte, 0, paramInt);
          localb.fXC += paramInt;
          if (!localb.fXE) {
            break label310;
          }
          localb.fXF.unlock();
          break label310;
        }
        if (paramInt <= localb.fXz - localb.fXC)
        {
          System.arraycopy(localb.fXB, localb.fXC, paramArrayOfByte, 0, paramInt);
          localb.fXC += paramInt;
        }
      }
      System.arraycopy(localb.fXB, localb.fXC, paramArrayOfByte, 0, localb.fXz - localb.fXC);
      System.arraycopy(localb.fXB, 0, paramArrayOfByte, localb.fXz - localb.fXC, paramInt - (localb.fXz - localb.fXC));
      localb.fXC = (paramInt - (localb.fXz - localb.fXC));
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
    private int diK;
    private int diL;
    byte[] diM;
    
    a()
    {
      AppMethodBeat.i(129999);
      this.diK = (e.this.diw * 2);
      this.diL = e.this.diw;
      this.diM = new byte[this.diK];
      AppMethodBeat.o(129999);
    }
    
    public final void run()
    {
      AppMethodBeat.i(130000);
      int j;
      if (!e.this.mIsPause)
      {
        j = (int)(0.8D * e.this.PS());
        i = j;
        if (j < e.this.diw * 8) {
          i = e.this.diw * 8;
        }
        if (e.this.PT() <= i) {
          break label140;
        }
      }
      label140:
      for (int i = 8;; i = 1)
      {
        j = 0;
        while (j < i)
        {
          int k = e.this.x(this.diM, this.diL);
          if ((e.this.diC != null) && (k == 0)) {
            e.this.diC.u(this.diM, this.diL);
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
    volatile e.c diN;
    
    b() {}
    
    public final String getKey()
    {
      return "RecordModeAsyncRead_record";
    }
    
    public final void run()
    {
      AppMethodBeat.i(130001);
      ae.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[] { Integer.valueOf(e.this.diw) });
      if (-123456789 != e.this.dhY)
      {
        ae.i("MicroMsg.RecordModeAsyncRead", "set priority to " + e.this.dhY);
        Process.setThreadPriority(e.this.dhY);
      }
      for (;;)
      {
        synchronized (e.this.diF)
        {
          ae.i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), e.this.diF });
          if (1 != e.this.mStatus)
          {
            ae.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + e.this.mStatus);
            AppMethodBeat.o(130001);
            return;
          }
          e.this.mStatus = 2;
          ??? = new byte[e.this.diw];
          if (2 == e.this.mStatus) {
            synchronized (e.this.diE)
            {
              boolean bool = e.this.mIsPause;
              if (!bool) {}
            }
          }
        }
        try
        {
          e.this.diE.wait();
          label237:
          if (2 != e.this.mStatus) {}
          Object localObject6;
          int i;
          for (;;)
          {
            if (this.diN != null) {
              this.diN.finish();
            }
            ae.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
            AppMethodBeat.o(130001);
            return;
            localObject4 = finally;
            AppMethodBeat.o(130001);
            throw localObject4;
            if (e.this.dii == null)
            {
              ae.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
              synchronized (e.this.diF)
              {
                e.this.mStatus = 3;
              }
              localObject2 = finally;
              AppMethodBeat.o(130001);
              throw localObject2;
            }
            localObject6 = localObject2;
            if (e.this.dhU) {
              localObject6 = new byte[e.this.diw];
            }
            e.this.diO += 1;
            new com.tencent.mm.compatible.util.f.a();
            i = e.this.dii.read((byte[])localObject6, 0, e.this.diw);
            if (2 == e.this.mStatus) {
              break;
            }
            ae.i("MicroMsg.RecordModeAsyncRead", "record mode has not been running and break");
          }
          if (e.this.dis != null) {
            e.this.dis.d(i, (byte[])localObject6);
          }
          if (e.this.diw != i) {
            ae.i("MicroMsg.RecordModeAsyncRead", "read len ".concat(String.valueOf(i)));
          }
          if (i < e.this.diw) {
            ae.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
          }
          try
          {
            Thread.sleep(10L);
            label530:
            Object localObject3 = localObject6;
            if (e.this.diC == null) {
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
            if (e.this.diB != null)
            {
              if (e.this.mIsMute) {
                Arrays.fill((byte[])localObject6, 0, j, (byte)0);
              }
              localObject3 = e.this.diB;
              if (j > 0)
              {
                if (((b)localObject3).fXE) {
                  ((b)localObject3).fXF.lock();
                }
                if (((b)localObject3).fXC != ((b)localObject3).fXD) {
                  break label699;
                }
                i = ((b)localObject3).fXz;
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
                ae.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(e.this.diB.ZQ()) });
                localObject3 = localObject6;
                break;
                label699:
                if ((((b)localObject3).fXD + 1) % ((b)localObject3).fXz == ((b)localObject3).fXC)
                {
                  i = 0;
                  break label643;
                }
                if (((b)localObject3).fXC < ((b)localObject3).fXD) {
                  ((b)localObject3).fXA = (((b)localObject3).fXD - ((b)localObject3).fXC);
                }
                for (;;)
                {
                  if (((b)localObject3).fXE) {
                    ((b)localObject3).fXF.unlock();
                  }
                  i = ((b)localObject3).fXz - ((b)localObject3).fXA;
                  break;
                  if (((b)localObject3).fXC > ((b)localObject3).fXD) {
                    ((b)localObject3).fXA = (((b)localObject3).fXD + ((b)localObject3).fXz - ((b)localObject3).fXC);
                  }
                }
                label825:
                if ((((b)localObject3).fXD + j) % ((b)localObject3).fXz != ((b)localObject3).fXC) {
                  break label851;
                }
              }
              label851:
              if (((b)localObject3).fXE) {
                ((b)localObject3).fXF.lock();
              }
              if ((((b)localObject3).fXC < ((b)localObject3).fXD) && (j > ((b)localObject3).fXz - ((b)localObject3).fXD))
              {
                System.arraycopy(localObject6, 0, ((b)localObject3).fXB, ((b)localObject3).fXD, ((b)localObject3).fXz - ((b)localObject3).fXD);
                System.arraycopy(localObject6, ((b)localObject3).fXz - ((b)localObject3).fXD, ((b)localObject3).fXB, 0, j - (((b)localObject3).fXz - ((b)localObject3).fXD));
                ((b)localObject3).fXD = (j - (((b)localObject3).fXz - ((b)localObject3).fXD));
              }
              for (((b)localObject3).fXD %= ((b)localObject3).fXz;; ((b)localObject3).fXD = ((j + ((b)localObject3).fXD) % ((b)localObject3).fXz))
              {
                if (((b)localObject3).fXE) {
                  ((b)localObject3).fXF.unlock();
                }
                i = 0;
                break;
                System.arraycopy(localObject6, 0, ((b)localObject3).fXB, ((b)localObject3).fXD, j);
              }
            }
            localObject3 = localObject6;
            if (e.this.diC == null) {
              continue;
            }
            if (e.this.mIsMute) {
              Arrays.fill((byte[])localObject6, 0, j, (byte)0);
            }
            e.this.diC.u((byte[])localObject6, j);
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