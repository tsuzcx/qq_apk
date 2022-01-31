package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;

final class e$b
  implements Runnable
{
  volatile e.c ckf;
  
  e$b(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(55752);
    ab.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[] { Integer.valueOf(this.ckb.cjO) });
    if (-123456789 != this.ckb.cjs)
    {
      ab.i("MicroMsg.RecordModeAsyncRead", "set priority to " + this.ckb.cjs);
      Process.setThreadPriority(this.ckb.cjs);
    }
    for (;;)
    {
      synchronized (this.ckb.cjX)
      {
        ab.i("MicroMsg.RecordModeAsyncRead", "RecordRunnable#run lock[%s] mStatusLock[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), this.ckb.cjX });
        if (1 != this.ckb.mStatus)
        {
          ab.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + this.ckb.mStatus);
          AppMethodBeat.o(55752);
          return;
        }
        this.ckb.mStatus = 2;
        ??? = new byte[this.ckb.cjO];
        if (2 == this.ckb.mStatus) {
          synchronized (this.ckb.cjW)
          {
            boolean bool = this.ckb.mIsPause;
            if (!bool) {}
          }
        }
      }
      try
      {
        this.ckb.cjW.wait();
        label237:
        if (2 != this.ckb.mStatus) {}
        Object localObject6;
        int i;
        do
        {
          for (;;)
          {
            if (this.ckf != null) {
              this.ckf.finish();
            }
            ab.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
            AppMethodBeat.o(55752);
            return;
            localObject4 = finally;
            AppMethodBeat.o(55752);
            throw localObject4;
            if (this.ckb.cjC != null) {
              break;
            }
            ab.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
            synchronized (this.ckb.cjX)
            {
              this.ckb.mStatus = 3;
            }
          }
          localObject2 = finally;
          AppMethodBeat.o(55752);
          throw localObject2;
          localObject6 = localObject2;
          if (this.ckb.cjo) {
            localObject6 = new byte[this.ckb.cjO];
          }
          this.ckb.ckg += 1;
          new g.a();
          i = this.ckb.cjC.read((byte[])localObject6, 0, this.ckb.cjO);
        } while (2 != this.ckb.mStatus);
        if (this.ckb.cjK != null) {
          this.ckb.cjK.d(i, (byte[])localObject6);
        }
        if (this.ckb.cjO != i) {
          ab.i("MicroMsg.RecordModeAsyncRead", "read len ".concat(String.valueOf(i)));
        }
        if (i < this.ckb.cjO) {
          ab.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
        }
        try
        {
          Thread.sleep(10L);
          label520:
          Object localObject3 = localObject6;
          if (this.ckb.cjU == null) {
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
          if (this.ckb.cjT != null)
          {
            if (this.ckb.mIsMute) {
              Arrays.fill((byte[])localObject6, 0, j, (byte)0);
            }
            localObject3 = this.ckb.cjT;
            if (j > 0)
            {
              if (((b)localObject3).elM) {
                ((b)localObject3).elN.lock();
              }
              if (((b)localObject3).elK != ((b)localObject3).elL) {
                break label689;
              }
              i = ((b)localObject3).elH;
              label633:
              if (j <= i) {
                break label815;
              }
            }
            for (i = -1;; i = -1)
            {
              localObject3 = localObject6;
              if (i == 0) {
                break;
              }
              ab.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ckb.cjT.Kz()) });
              localObject3 = localObject6;
              break;
              label689:
              if ((((b)localObject3).elL + 1) % ((b)localObject3).elH == ((b)localObject3).elK)
              {
                i = 0;
                break label633;
              }
              if (((b)localObject3).elK < ((b)localObject3).elL) {
                ((b)localObject3).elI = (((b)localObject3).elL - ((b)localObject3).elK);
              }
              for (;;)
              {
                if (((b)localObject3).elM) {
                  ((b)localObject3).elN.unlock();
                }
                i = ((b)localObject3).elH - ((b)localObject3).elI;
                break;
                if (((b)localObject3).elK > ((b)localObject3).elL) {
                  ((b)localObject3).elI = (((b)localObject3).elL + ((b)localObject3).elH - ((b)localObject3).elK);
                }
              }
              label815:
              if ((((b)localObject3).elL + j) % ((b)localObject3).elH != ((b)localObject3).elK) {
                break label841;
              }
            }
            label841:
            if (((b)localObject3).elM) {
              ((b)localObject3).elN.lock();
            }
            if ((((b)localObject3).elK < ((b)localObject3).elL) && (j > ((b)localObject3).elH - ((b)localObject3).elL))
            {
              System.arraycopy(localObject6, 0, ((b)localObject3).elJ, ((b)localObject3).elL, ((b)localObject3).elH - ((b)localObject3).elL);
              System.arraycopy(localObject6, ((b)localObject3).elH - ((b)localObject3).elL, ((b)localObject3).elJ, 0, j - (((b)localObject3).elH - ((b)localObject3).elL));
              ((b)localObject3).elL = (j - (((b)localObject3).elH - ((b)localObject3).elL));
            }
            for (((b)localObject3).elL %= ((b)localObject3).elH;; ((b)localObject3).elL = ((j + ((b)localObject3).elL) % ((b)localObject3).elH))
            {
              if (((b)localObject3).elM) {
                ((b)localObject3).elN.unlock();
              }
              i = 0;
              break;
              System.arraycopy(localObject6, 0, ((b)localObject3).elJ, ((b)localObject3).elL, j);
            }
          }
          localObject3 = localObject6;
          if (this.ckb.cjU == null) {
            continue;
          }
          if (this.ckb.mIsMute) {
            Arrays.fill((byte[])localObject6, 0, j, (byte)0);
          }
          this.ckb.cjU.s((byte[])localObject6, j);
          localObject3 = localObject6;
        }
        catch (InterruptedException localInterruptedException1)
        {
          break label520;
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        break label237;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.b.e.b
 * JD-Core Version:    0.7.0.1
 */