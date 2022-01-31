package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Queue;

public final class j
{
  private static int jFV = 60000;
  private j.a jBK;
  long jFW;
  long jFX;
  long jFY;
  long jFZ;
  long jGa;
  int jGb;
  Queue<Long> jGc;
  ap jGd;
  
  public j(j.a parama)
  {
    AppMethodBeat.i(17677);
    this.jFW = 0L;
    this.jGb = 0;
    this.jGc = new LinkedList();
    this.jGd = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(17676);
        long l = bo.hl(j.a(j.this));
        if (l != 0L)
        {
          j.a(j.this, j.b(j.this) / l * 1000L);
          j.d(j.this).offer(Long.valueOf(j.c(j.this)));
        }
        try
        {
          l = ((Long)j.d(j.this).poll()).longValue();
          j.a(j.this, (j.e(j.this) * 10L - l + j.c(j.this)) / 10L);
          j localj = j.this;
          if (j.c(j.this) > 0L)
          {
            l = j.c(j.this);
            j.a(localj, l);
            j.b(j.this, j.c(j.this));
            j.f(j.this);
            j.c(j.this, bo.aoy());
            j.g(j.this).aTF();
            if (j.c(j.this) < 102400L) {
              break label277;
            }
            if (j.h(j.this) != 0)
            {
              j.a(j.this, 0);
              j.d(j.this, 0L);
              j.g(j.this).rk(0);
              ab.i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
            }
            AppMethodBeat.o(17676);
            return true;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            l = 0L;
            continue;
            l = 0L;
            continue;
            label277:
            if (j.c(j.this) < 2L)
            {
              if (j.h(j.this) == 0)
              {
                j.a(j.this, 1);
                j.g(j.this).rk(1);
                j.d(j.this, bo.aoy());
                ab.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", new Object[] { Long.valueOf(j.i(j.this)) });
              }
              else if (j.h(j.this) == 1)
              {
                if (j.i(j.this) > 0L)
                {
                  if (bo.hl(j.i(j.this)) > j.aUG())
                  {
                    ab.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", new Object[] { Long.valueOf(bo.hl(j.i(j.this))) });
                    j.a(j.this, 2);
                    j.g(j.this).aTG();
                    j.d(j.this, 0L);
                    AppMethodBeat.o(17676);
                    return false;
                  }
                }
                else
                {
                  j.d(j.this, bo.aoy());
                  ab.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", new Object[] { Long.valueOf(j.i(j.this)) });
                }
              }
            }
            else if (j.h(j.this) != 1)
            {
              j.a(j.this, 1);
              j.g(j.this).rk(1);
              ab.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is weak now.");
            }
          }
        }
      }
    }, true);
    this.jBK = parama;
    AppMethodBeat.o(17677);
  }
  
  static String hL(long paramLong)
  {
    AppMethodBeat.i(17678);
    if (paramLong >> 30 > 0L)
    {
      str = bo.c(paramLong, 100.0D);
      AppMethodBeat.o(17678);
      return str;
    }
    if (paramLong >> 20 > 0L)
    {
      str = bo.b(paramLong, 100.0D);
      AppMethodBeat.o(17678);
      return str;
    }
    if (paramLong >> 9 > 0L)
    {
      int i = Math.round((float)paramLong / 1024.0F);
      str = i + " KB";
      AppMethodBeat.o(17678);
      return str;
    }
    String str = paramLong + " B";
    AppMethodBeat.o(17678);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.j
 * JD-Core Version:    0.7.0.1
 */