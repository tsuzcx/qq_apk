package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Queue;

public final class j
{
  private static int oQe = 60000;
  private a oLY;
  long oQf;
  long oQg;
  long oQh;
  long oQi;
  long oQj;
  int oQk;
  Queue<Long> oQl;
  MTimerHandler oQm;
  
  public j(a parama)
  {
    AppMethodBeat.i(21736);
    this.oQf = 0L;
    this.oQk = 0;
    this.oQl = new LinkedList();
    this.oQm = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21735);
        long l = Util.milliSecondsToNow(j.a(j.this));
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
            j.c(j.this, Util.nowMilliSecond());
            j.g(j.this).cfI();
            if (j.c(j.this) < 102400L) {
              break label277;
            }
            if (j.h(j.this) != 0)
            {
              j.a(j.this, 0);
              j.d(j.this, 0L);
              j.g(j.this).Bf(0);
              Log.i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
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
                j.g(j.this).Bf(1);
                j.d(j.this, Util.nowMilliSecond());
                Log.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", new Object[] { Long.valueOf(j.i(j.this)) });
              }
              else if (j.h(j.this) == 1)
              {
                if (j.i(j.this) > 0L)
                {
                  if (Util.milliSecondsToNow(j.i(j.this)) > j.cgL())
                  {
                    Log.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", new Object[] { Long.valueOf(Util.milliSecondsToNow(j.i(j.this))) });
                    j.a(j.this, 2);
                    j.g(j.this).cfJ();
                    j.d(j.this, 0L);
                    AppMethodBeat.o(21735);
                    return false;
                  }
                }
                else
                {
                  j.d(j.this, Util.nowMilliSecond());
                  Log.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", new Object[] { Long.valueOf(j.i(j.this)) });
                }
              }
            }
            else if (j.h(j.this) != 1)
            {
              j.a(j.this, 1);
              j.g(j.this).Bf(1);
              Log.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is weak now.");
            }
          }
        }
      }
    }, true);
    this.oLY = parama;
    AppMethodBeat.o(21736);
  }
  
  static String Bx(long paramLong)
  {
    AppMethodBeat.i(21737);
    if (paramLong >> 30 > 0L)
    {
      str = Util.getSizeGB(paramLong, 100.0D);
      AppMethodBeat.o(21737);
      return str;
    }
    if (paramLong >> 20 > 0L)
    {
      str = Util.getSizeMB(paramLong, 100.0D);
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
    public abstract void Bf(int paramInt);
    
    public abstract void cfI();
    
    public abstract void cfJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.j
 * JD-Core Version:    0.7.0.1
 */