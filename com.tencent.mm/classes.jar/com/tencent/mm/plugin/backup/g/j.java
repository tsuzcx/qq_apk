package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Queue;

public final class j
{
  private static int hMt = 60000;
  private j.a hIm;
  Queue<Long> hMA = new LinkedList();
  am hMB = new am(Looper.getMainLooper(), new am.a()
  {
    public final boolean tC()
    {
      long l = bk.co(j.a(j.this));
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
          j.c(j.this, bk.UY());
          j.g(j.this).aug();
          if (j.c(j.this) < 102400L) {
            break label265;
          }
          if (j.h(j.this) != 0)
          {
            j.a(j.this, 0);
            j.d(j.this, 0L);
            j.g(j.this).ny(0);
            y.i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
          }
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
          label265:
          if (j.c(j.this) < 2L)
          {
            if (j.h(j.this) == 0)
            {
              j.a(j.this, 1);
              j.g(j.this).ny(1);
              j.d(j.this, bk.UY());
              y.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", new Object[] { Long.valueOf(j.i(j.this)) });
            }
            else if (j.h(j.this) == 1)
            {
              if (j.i(j.this) > 0L)
              {
                if (bk.co(j.i(j.this)) > j.ave())
                {
                  y.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", new Object[] { Long.valueOf(bk.co(j.i(j.this))) });
                  j.a(j.this, 2);
                  j.g(j.this).auh();
                  j.d(j.this, 0L);
                  return false;
                }
              }
              else
              {
                j.d(j.this, bk.UY());
                y.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", new Object[] { Long.valueOf(j.i(j.this)) });
              }
            }
          }
          else if (j.h(j.this) != 1)
          {
            j.a(j.this, 1);
            j.g(j.this).ny(1);
            y.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is weak now.");
          }
        }
      }
    }
  }, true);
  long hMu = 0L;
  long hMv;
  long hMw;
  long hMx;
  long hMy;
  int hMz = 0;
  
  public j(j.a parama)
  {
    this.hIm = parama;
  }
  
  static String cJ(long paramLong)
  {
    if (paramLong >> 30 > 0L) {
      return bk.b(paramLong, 100.0D);
    }
    if (paramLong >> 20 > 0L) {
      return bk.a(paramLong, 100.0D);
    }
    if (paramLong >> 9 > 0L)
    {
      int i = Math.round((float)paramLong / 1024.0F);
      return i + " KB";
    }
    return paramLong + " B";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.j
 * JD-Core Version:    0.7.0.1
 */