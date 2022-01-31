package com.tencent.mm.f.b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.mm.compatible.b.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

final class e$b
  implements Runnable
{
  e$b(e parame) {}
  
  public final void run()
  {
    y.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[] { Integer.valueOf(this.bDq.bDa) });
    if (-123456789 != this.bDq.bCE)
    {
      y.i("MicroMsg.RecordModeAsyncRead", "set priority to " + this.bDq.bCE);
      Process.setThreadPriority(this.bDq.bCE);
    }
    for (;;)
    {
      synchronized (this.bDq.bDj)
      {
        y.i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), this.bDq.bDj });
        if (1 != this.bDq.mStatus)
        {
          y.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + this.bDq.mStatus);
          return;
        }
        this.bDq.mStatus = 2;
        ??? = new byte[this.bDq.bDa];
        if (2 == this.bDq.mStatus) {
          synchronized (this.bDq.bDi)
          {
            boolean bool = this.bDq.mIsPause;
            if (!bool) {}
          }
        }
      }
      try
      {
        this.bDq.bDi.wait();
        label227:
        if (2 != this.bDq.mStatus) {}
        Object localObject6;
        int i;
        do
        {
          for (;;)
          {
            y.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
            return;
            localObject4 = finally;
            throw localObject4;
            if (this.bDq.bCO != null) {
              break;
            }
            y.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
            synchronized (this.bDq.bDj)
            {
              this.bDq.mStatus = 3;
            }
          }
          localObject2 = finally;
          throw localObject2;
          localObject6 = localObject2;
          if (this.bDq.bCA) {
            localObject6 = new byte[this.bDq.bDa];
          }
          this.bDq.bDr += 1;
          new g.a();
          i = this.bDq.bCO.read((byte[])localObject6, 0, this.bDq.bDa);
        } while (2 != this.bDq.mStatus);
        if (this.bDq.bCW != null) {
          this.bDq.bCW.d(i, (byte[])localObject6);
        }
        if (this.bDq.bDa != i) {
          y.i("MicroMsg.RecordModeAsyncRead", "read len " + i);
        }
        if (i < this.bDq.bDa) {
          y.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
        }
        try
        {
          Thread.sleep(10L);
          label481:
          Object localObject3 = localObject6;
          if (this.bDq.bDg == null) {
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
          if (this.bDq.bDf != null)
          {
            if (this.bDq.mIsMute) {
              Arrays.fill((byte[])localObject6, 0, j, (byte)0);
            }
            localObject3 = this.bDq.bDf;
            if (j > 0)
            {
              if (((a)localObject3).dtY) {
                ((a)localObject3).dtZ.lock();
              }
              if (((a)localObject3).dtW != ((a)localObject3).dtX) {
                break label650;
              }
              i = ((a)localObject3).dtT;
              label594:
              if (j <= i) {
                break label776;
              }
            }
            for (i = -1;; i = -1)
            {
              localObject3 = localObject6;
              if (i == 0) {
                break;
              }
              y.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.bDq.bDf.yg()) });
              localObject3 = localObject6;
              break;
              label650:
              if ((((a)localObject3).dtX + 1) % ((a)localObject3).dtT == ((a)localObject3).dtW)
              {
                i = 0;
                break label594;
              }
              if (((a)localObject3).dtW < ((a)localObject3).dtX) {
                ((a)localObject3).dtU = (((a)localObject3).dtX - ((a)localObject3).dtW);
              }
              for (;;)
              {
                if (((a)localObject3).dtY) {
                  ((a)localObject3).dtZ.unlock();
                }
                i = ((a)localObject3).dtT - ((a)localObject3).dtU;
                break;
                if (((a)localObject3).dtW > ((a)localObject3).dtX) {
                  ((a)localObject3).dtU = (((a)localObject3).dtX + ((a)localObject3).dtT - ((a)localObject3).dtW);
                }
              }
              label776:
              if ((((a)localObject3).dtX + j) % ((a)localObject3).dtT != ((a)localObject3).dtW) {
                break label802;
              }
            }
            label802:
            if (((a)localObject3).dtY) {
              ((a)localObject3).dtZ.lock();
            }
            if ((((a)localObject3).dtW < ((a)localObject3).dtX) && (j > ((a)localObject3).dtT - ((a)localObject3).dtX))
            {
              System.arraycopy(localObject6, 0, ((a)localObject3).dtV, ((a)localObject3).dtX, ((a)localObject3).dtT - ((a)localObject3).dtX);
              System.arraycopy(localObject6, ((a)localObject3).dtT - ((a)localObject3).dtX, ((a)localObject3).dtV, 0, j - (((a)localObject3).dtT - ((a)localObject3).dtX));
              ((a)localObject3).dtX = (j - (((a)localObject3).dtT - ((a)localObject3).dtX));
            }
            for (((a)localObject3).dtX %= ((a)localObject3).dtT;; ((a)localObject3).dtX = ((j + ((a)localObject3).dtX) % ((a)localObject3).dtT))
            {
              if (((a)localObject3).dtY) {
                ((a)localObject3).dtZ.unlock();
              }
              i = 0;
              break;
              System.arraycopy(localObject6, 0, ((a)localObject3).dtV, ((a)localObject3).dtX, j);
            }
          }
          localObject3 = localObject6;
          if (this.bDq.bDg == null) {
            continue;
          }
          if (this.bDq.mIsMute) {
            Arrays.fill((byte[])localObject6, 0, j, (byte)0);
          }
          this.bDq.bDg.r((byte[])localObject6, j);
          localObject3 = localObject6;
        }
        catch (InterruptedException localInterruptedException1)
        {
          break label481;
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        break label227;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.e.b
 * JD-Core Version:    0.7.0.1
 */