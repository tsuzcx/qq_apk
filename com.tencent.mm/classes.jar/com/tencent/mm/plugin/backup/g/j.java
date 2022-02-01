package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.Queue;

public final class j
{
  private static int mxo = 60000;
  private a mtf;
  long mxp;
  long mxq;
  long mxr;
  long mxs;
  long mxt;
  int mxu;
  Queue<Long> mxv;
  av mxw;
  
  public j(a parama)
  {
    AppMethodBeat.i(21736);
    this.mxp = 0L;
    this.mxu = 0;
    this.mxv = new LinkedList();
    this.mxw = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21735);
        long l = bt.vM(j.a(j.this));
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
            j.c(j.this, bt.eGO());
            j.g(j.this).bwO();
            if (j.c(j.this) < 102400L) {
              break label277;
            }
            if (j.h(j.this) != 0)
            {
              j.a(j.this, 0);
              j.d(j.this, 0L);
              j.g(j.this).vX(0);
              ad.i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
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
                j.g(j.this).vX(1);
                j.d(j.this, bt.eGO());
                ad.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", new Object[] { Long.valueOf(j.i(j.this)) });
              }
              else if (j.h(j.this) == 1)
              {
                if (j.i(j.this) > 0L)
                {
                  if (bt.vM(j.i(j.this)) > j.bxP())
                  {
                    ad.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", new Object[] { Long.valueOf(bt.vM(j.i(j.this))) });
                    j.a(j.this, 2);
                    j.g(j.this).bwP();
                    j.d(j.this, 0L);
                    AppMethodBeat.o(21735);
                    return false;
                  }
                }
                else
                {
                  j.d(j.this, bt.eGO());
                  ad.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", new Object[] { Long.valueOf(j.i(j.this)) });
                }
              }
            }
            else if (j.h(j.this) != 1)
            {
              j.a(j.this, 1);
              j.g(j.this).vX(1);
              ad.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is weak now.");
            }
          }
        }
      }
    }, true);
    this.mtf = parama;
    AppMethodBeat.o(21736);
  }
  
  static String ns(long paramLong)
  {
    AppMethodBeat.i(21737);
    if (paramLong >> 30 > 0L)
    {
      str = bt.b(paramLong, 100.0D);
      AppMethodBeat.o(21737);
      return str;
    }
    if (paramLong >> 20 > 0L)
    {
      str = bt.a(paramLong, 100.0D);
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
    public abstract void bwO();
    
    public abstract void bwP();
    
    public abstract void vX(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.j
 * JD-Core Version:    0.7.0.1
 */