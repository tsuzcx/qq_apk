package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.Queue;

public final class j
{
  private static int mZp = 60000;
  private a mVh;
  long mZq;
  long mZr;
  long mZs;
  long mZt;
  long mZu;
  int mZv;
  Queue<Long> mZw;
  au mZx;
  
  public j(a parama)
  {
    AppMethodBeat.i(21736);
    this.mZq = 0L;
    this.mZv = 0;
    this.mZw = new LinkedList();
    this.mZx = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21735);
        long l = bs.Ap(j.a(j.this));
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
            j.c(j.this, bs.eWj());
            j.g(j.this).bDK();
            if (j.c(j.this) < 102400L) {
              break label277;
            }
            if (j.h(j.this) != 0)
            {
              j.a(j.this, 0);
              j.d(j.this, 0L);
              j.g(j.this).wO(0);
              ac.i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
            }
            AppMethodBeat.o(21735);
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
                j.g(j.this).wO(1);
                j.d(j.this, bs.eWj());
                ac.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", new Object[] { Long.valueOf(j.i(j.this)) });
              }
              else if (j.h(j.this) == 1)
              {
                if (j.i(j.this) > 0L)
                {
                  if (bs.Ap(j.i(j.this)) > j.bEL())
                  {
                    ac.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", new Object[] { Long.valueOf(bs.Ap(j.i(j.this))) });
                    j.a(j.this, 2);
                    j.g(j.this).bDL();
                    j.d(j.this, 0L);
                    AppMethodBeat.o(21735);
                    return false;
                  }
                }
                else
                {
                  j.d(j.this, bs.eWj());
                  ac.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", new Object[] { Long.valueOf(j.i(j.this)) });
                }
              }
            }
            else if (j.h(j.this) != 1)
            {
              j.a(j.this, 1);
              j.g(j.this).wO(1);
              ac.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is weak now.");
            }
          }
        }
      }
    }, true);
    this.mVh = parama;
    AppMethodBeat.o(21736);
  }
  
  static String re(long paramLong)
  {
    AppMethodBeat.i(21737);
    if (paramLong >> 30 > 0L)
    {
      str = bs.b(paramLong, 100.0D);
      AppMethodBeat.o(21737);
      return str;
    }
    if (paramLong >> 20 > 0L)
    {
      str = bs.a(paramLong, 100.0D);
      AppMethodBeat.o(21737);
      return str;
    }
    if (paramLong >> 9 > 0L)
    {
      int i = Math.round((float)paramLong / 1024.0F);
      str = i + " KB";
      AppMethodBeat.o(21737);
      return str;
    }
    String str = paramLong + " B";
    AppMethodBeat.o(21737);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void bDK();
    
    public abstract void bDL();
    
    public abstract void wO(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.j
 * JD-Core Version:    0.7.0.1
 */