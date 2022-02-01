package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.c;
import com.tencent.threadpool.i;
import java.util.Arrays;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  extends f
{
  private int Ke;
  int hwM;
  b hwP;
  b hwQ;
  c.a hwR;
  final Object hwS;
  final byte[] hwT;
  final Object hwU;
  Future<?> hwV;
  @Deprecated
  boolean hwW;
  private boolean hwX;
  boolean hwj;
  AudioRecord hwx;
  boolean mIsMute;
  int mStatus;
  
  public e(AudioRecord paramAudioRecord, boolean paramBoolean1, int paramInt, c.a parama, boolean paramBoolean2)
  {
    AppMethodBeat.i(130002);
    this.mStatus = 0;
    this.Ke = 12800;
    this.mIsMute = false;
    this.hwP = new b();
    this.hwQ = null;
    this.hwS = new Object();
    this.hwT = new byte[0];
    this.hwU = new Object();
    this.hwV = null;
    this.hwW = false;
    this.hwX = false;
    this.hwx = paramAudioRecord;
    this.hwj = paramBoolean1;
    this.hwM = paramInt;
    this.hwR = parama;
    this.hwX = paramBoolean2;
    AppMethodBeat.o(130002);
  }
  
  public final boolean aGR()
  {
    int i = -1;
    AppMethodBeat.i(130003);
    Log.i("MicroMsg.RecordModeAsyncRead", "startRecord");
    for (;;)
    {
      synchronized (this.hwU)
      {
        this.mStatus = 1;
        Log.i("MicroMsg.RecordModeAsyncRead", "[startRecord] dumpRunningTask:%s", new Object[] { com.tencent.threadpool.h.ahAB.jYS() });
        com.tencent.threadpool.h.ahAA.bm(this.hwP);
        if (true != this.hwX) {
          break label292;
        }
        this.hwQ = new b();
        if (this.hwQ == null)
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
      this.Ke = (this.hwM * 20);
      Log.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.Ke);
      ??? = this.hwQ;
      int j = this.Ke;
      if (j <= 0) {}
      for (;;)
      {
        if (i == 0) {
          break label235;
        }
        Log.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
        i = 0;
        break;
        ((b)???).lPY = new byte[j];
        if (((b)???).lPY != null)
        {
          ((b)???).lPW = j;
          if (((b)???).lQb) {
            ((b)???).lQc = new ReentrantLock();
          }
          i = 0;
        }
      }
      label235:
      i = 1;
    }
    if (this.hwV != null)
    {
      Log.e("MicroMsg.RecordModeAsyncRead", "startRecord failed : last record is NOT stopped now");
      AppMethodBeat.o(130003);
      return false;
    }
    this.hwV = com.tencent.threadpool.h.ahAA.a(new a(), 60L, 20L);
    this.hwW = true;
    label292:
    AppMethodBeat.o(130003);
    return true;
  }
  
  public final int aGW()
  {
    synchronized (this.hwS)
    {
      if (this.hwQ != null)
      {
        int i = this.hwQ.lPW;
        return i;
      }
      return -1;
    }
  }
  
  public final int aGX()
  {
    AppMethodBeat.i(130005);
    synchronized (this.hwS)
    {
      if (this.hwQ != null)
      {
        int i = this.hwQ.aOd();
        AppMethodBeat.o(130005);
        return i;
      }
      AppMethodBeat.o(130005);
      return -1;
    }
  }
  
  public final void eq(boolean paramBoolean)
  {
    this.mIsMute = paramBoolean;
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(130004);
    Log.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
    synchronized (this.hwU)
    {
      this.mStatus = 3;
      this.hwP.hxc = new c()
      {
        public final void finish()
        {
          AppMethodBeat.i(129998);
          e.this.hwP.hxc = null;
          Log.i("MicroMsg.RecordModeAsyncRead", "finish stopRecord");
          if (e.this.hwQ != null)
          {
            if (e.this.hwV != null)
            {
              e.this.hwV.cancel(false);
              e.this.hwV = null;
            }
            ??? = e.this.hwQ;
            ((b)???).lPW = 0;
            ((b)???).lPX = 0;
            ((b)???).lPZ = 0;
            ((b)???).lQa = 0;
            ((b)???).lPY = null;
          }
          synchronized (e.this.hwS)
          {
            e.this.hwQ = null;
            e.this.hwR = null;
            e.this.hwW = false;
            e.this.hwQ = null;
            AppMethodBeat.o(129998);
            return;
          }
        }
      };
    }
    synchronized (this.hwT)
    {
      this.hwT.notify();
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
      synchronized (this.hwS)
      {
        if (this.hwQ == null) {
          break label300;
        }
        localb = this.hwQ;
        i = j;
        if (paramInt > 0)
        {
          i = j;
          if (paramInt <= localb.aOd())
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
        if (localb.lPZ == localb.lQa) {
          continue;
        }
        if (localb.lQb) {
          localb.lQc.lock();
        }
        if (localb.lPZ < localb.lQa)
        {
          System.arraycopy(localb.lPY, localb.lPZ, paramArrayOfByte, 0, paramInt);
          localb.lPZ += paramInt;
          if (!localb.lQb) {
            break label310;
          }
          localb.lQc.unlock();
          break label310;
        }
        if (paramInt <= localb.lPW - localb.lPZ)
        {
          System.arraycopy(localb.lPY, localb.lPZ, paramArrayOfByte, 0, paramInt);
          localb.lPZ += paramInt;
        }
      }
      System.arraycopy(localb.lPY, localb.lPZ, paramArrayOfByte, 0, localb.lPW - localb.lPZ);
      System.arraycopy(localb.lPY, 0, paramArrayOfByte, localb.lPW - localb.lPZ, paramInt - (localb.lPW - localb.lPZ));
      localb.lPZ = (paramInt - (localb.lPW - localb.lPZ));
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
    private int hwZ;
    private int hxa;
    byte[] hxb;
    
    a()
    {
      AppMethodBeat.i(129999);
      this.hwZ = (e.this.hwM * 2);
      this.hxa = e.this.hwM;
      this.hxb = new byte[this.hwZ];
      AppMethodBeat.o(129999);
    }
    
    public final void run()
    {
      AppMethodBeat.i(130000);
      int j;
      if (!e.this.mIsPause)
      {
        j = (int)(0.8D * e.this.aGW());
        i = j;
        if (j < e.this.hwM * 8) {
          i = e.this.hwM * 8;
        }
        if (e.this.aGX() <= i) {
          break label140;
        }
      }
      label140:
      for (int i = 8;; i = 1)
      {
        j = 0;
        while (j < i)
        {
          int k = e.this.x(this.hxb, this.hxa);
          if ((e.this.hwR != null) && (k == 0)) {
            e.this.hwR.u(this.hxb, this.hxa);
          }
          j += 1;
        }
        AppMethodBeat.o(130000);
        return;
      }
    }
  }
  
  final class b
    implements com.tencent.threadpool.i.h
  {
    volatile e.c hxc;
    
    b() {}
    
    public final String getKey()
    {
      return "RecordModeAsyncRead_record";
    }
    
    public final void run()
    {
      AppMethodBeat.i(130001);
      Log.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[] { Integer.valueOf(e.this.hwM) });
      if (-123456789 != e.this.hwn)
      {
        Log.i("MicroMsg.RecordModeAsyncRead", "set priority to " + e.this.hwn);
        Process.setThreadPriority(e.this.hwn);
      }
      for (;;)
      {
        synchronized (e.this.hwU)
        {
          Log.i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), e.this.hwU });
          if (1 != e.this.mStatus)
          {
            Log.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + e.this.mStatus);
            AppMethodBeat.o(130001);
            return;
          }
          e.this.mStatus = 2;
          ??? = new byte[e.this.hwM];
          if (2 == e.this.mStatus) {
            synchronized (e.this.hwT)
            {
              boolean bool = e.this.mIsPause;
              if (!bool) {}
            }
          }
        }
        try
        {
          e.this.hwT.wait();
          label237:
          if (2 != e.this.mStatus) {}
          Object localObject6;
          int i;
          for (;;)
          {
            if (this.hxc != null) {
              this.hxc.finish();
            }
            Log.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
            AppMethodBeat.o(130001);
            return;
            localObject4 = finally;
            AppMethodBeat.o(130001);
            throw localObject4;
            if (e.this.hwx == null)
            {
              Log.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
              synchronized (e.this.hwU)
              {
                e.this.mStatus = 3;
              }
              localObject2 = finally;
              AppMethodBeat.o(130001);
              throw localObject2;
            }
            localObject6 = localObject2;
            if (e.this.hwj) {
              localObject6 = new byte[e.this.hwM];
            }
            e.this.hxd += 1;
            new com.tencent.mm.compatible.util.f.a();
            i = e.this.hwx.read((byte[])localObject6, 0, e.this.hwM);
            if (2 == e.this.mStatus) {
              break;
            }
            Log.i("MicroMsg.RecordModeAsyncRead", "record mode has not been running and break");
          }
          if (e.this.hwI != null) {
            e.this.hwI.d(i, (byte[])localObject6);
          }
          if (e.this.hwM != i) {
            Log.i("MicroMsg.RecordModeAsyncRead", "read len ".concat(String.valueOf(i)));
          }
          if (i < e.this.hwM) {
            Log.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
          }
          try
          {
            Thread.sleep(10L);
            label530:
            Object localObject3 = localObject6;
            if (e.this.hwR == null) {
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
            if (e.this.hwQ != null)
            {
              if (e.this.mIsMute) {
                Arrays.fill((byte[])localObject6, 0, j, (byte)0);
              }
              localObject3 = e.this.hwQ;
              if (j > 0)
              {
                if (((b)localObject3).lQb) {
                  ((b)localObject3).lQc.lock();
                }
                if (((b)localObject3).lPZ != ((b)localObject3).lQa) {
                  break label699;
                }
                i = ((b)localObject3).lPW;
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
                Log.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(e.this.hwQ.aOd()) });
                localObject3 = localObject6;
                break;
                label699:
                if ((((b)localObject3).lQa + 1) % ((b)localObject3).lPW == ((b)localObject3).lPZ)
                {
                  i = 0;
                  break label643;
                }
                if (((b)localObject3).lPZ < ((b)localObject3).lQa) {
                  ((b)localObject3).lPX = (((b)localObject3).lQa - ((b)localObject3).lPZ);
                }
                for (;;)
                {
                  if (((b)localObject3).lQb) {
                    ((b)localObject3).lQc.unlock();
                  }
                  i = ((b)localObject3).lPW - ((b)localObject3).lPX;
                  break;
                  if (((b)localObject3).lPZ > ((b)localObject3).lQa) {
                    ((b)localObject3).lPX = (((b)localObject3).lQa + ((b)localObject3).lPW - ((b)localObject3).lPZ);
                  }
                }
                label825:
                if ((((b)localObject3).lQa + j) % ((b)localObject3).lPW != ((b)localObject3).lPZ) {
                  break label851;
                }
              }
              label851:
              if (((b)localObject3).lQb) {
                ((b)localObject3).lQc.lock();
              }
              if ((((b)localObject3).lPZ < ((b)localObject3).lQa) && (j > ((b)localObject3).lPW - ((b)localObject3).lQa))
              {
                System.arraycopy(localObject6, 0, ((b)localObject3).lPY, ((b)localObject3).lQa, ((b)localObject3).lPW - ((b)localObject3).lQa);
                System.arraycopy(localObject6, ((b)localObject3).lPW - ((b)localObject3).lQa, ((b)localObject3).lPY, 0, j - (((b)localObject3).lPW - ((b)localObject3).lQa));
                ((b)localObject3).lQa = (j - (((b)localObject3).lPW - ((b)localObject3).lQa));
              }
              for (((b)localObject3).lQa %= ((b)localObject3).lPW;; ((b)localObject3).lQa = ((j + ((b)localObject3).lQa) % ((b)localObject3).lPW))
              {
                if (((b)localObject3).lQb) {
                  ((b)localObject3).lQc.unlock();
                }
                i = 0;
                break;
                System.arraycopy(localObject6, 0, ((b)localObject3).lPY, ((b)localObject3).lQa, j);
              }
            }
            localObject3 = localObject6;
            if (e.this.hwR == null) {
              continue;
            }
            if (e.this.mIsMute) {
              Arrays.fill((byte[])localObject6, 0, j, (byte)0);
            }
            e.this.hwR.u((byte[])localObject6, j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.audio.b.e
 * JD-Core Version:    0.7.0.1
 */