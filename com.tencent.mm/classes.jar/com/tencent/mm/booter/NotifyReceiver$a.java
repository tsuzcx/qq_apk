package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public final class NotifyReceiver$a
  implements com.tencent.mm.ai.f
{
  private static long dZk = 0L;
  
  private void fV(long paramLong)
  {
    AppMethodBeat.i(57785);
    if (!com.tencent.mm.network.ab.any().getBoolean("is_in_notify_mode", false))
    {
      AppMethodBeat.o(57785);
      return;
    }
    new ak(Looper.myLooper()).postDelayed(new NotifyReceiver.a.2(this), paramLong);
    AppMethodBeat.o(57785);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, m paramm)
  {
    AppMethodBeat.i(57784);
    long l = paramm.hashCode();
    if (paramm.getType() == 268369922) {
      l = ((com.tencent.mm.modelmulti.f)paramm).fIb;
    }
    for (;;)
    {
      try
      {
        NotifyReceiver.Ir().lock();
      }
      finally
      {
        try
        {
          int i;
          boolean bool2;
          boolean bool1;
          NotifyReceiver.Ir().unlock();
          try
          {
            NotifyReceiver.Ir().lock();
            if (!NotifyReceiver.Is().isEmpty()) {
              continue;
            }
            synchronized (NotifyReceiver.access$400())
            {
              if (NotifyReceiver.Iq() == null) {
                continue;
              }
              NotifyReceiver.Iq().unLock();
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
            }
          }
          finally
          {
            try
            {
              NotifyReceiver.Ir().unlock();
              switch (paramm.getType())
              {
              default: 
                fV(7000L);
                AppMethodBeat.o(57784);
                return;
                bool1 = false;
                continue;
                paramm = finally;
                AppMethodBeat.o(57784);
                throw paramm;
                ??? = finally;
              }
            }
            catch (Exception ???)
            {
              try
              {
                NotifyReceiver.Ir().unlock();
                AppMethodBeat.o(57784);
                throw ???;
                paramm = finally;
                AppMethodBeat.o(57784);
                throw paramm;
                ??? = finally;
                try
                {
                  NotifyReceiver.Ir().unlock();
                  AppMethodBeat.o(57784);
                  throw ???;
                  com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", new Object[] { Integer.valueOf(NotifyReceiver.Is().size()) });
                  continue;
                  if (!g.RJ().QU()) {
                    continue;
                  }
                  Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
                  {
                    public final boolean queueIdle()
                    {
                      AppMethodBeat.i(57780);
                      NotifyReceiver.a.a(NotifyReceiver.a.this);
                      AppMethodBeat.o(57780);
                      return false;
                    }
                  });
                  if ((paramInt1 != 0) || (paramInt2 != 0) || (!com.tencent.mm.model.a.Yt())) {
                    continue;
                  }
                  try
                  {
                    g.RM();
                    ??? = g.RJ().eGV;
                    if (???.fko > -1L) {
                      ???.fko += 1L;
                    }
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", new Object[] { Long.valueOf(???.fko) });
                    if ((???.fko != 2L) && (???.fko != 5L)) {
                      continue;
                    }
                    paramm = e.qrI;
                    if (???.fko != 2L) {
                      continue;
                    }
                    l = 37L;
                    paramm.idkeyStat(226L, l, 1L, false);
                    e.qrI.e(11098, new Object[] { Integer.valueOf(2001), Long.valueOf(???.fko) });
                  }
                  catch (Throwable ???)
                  {
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { bo.l(???) });
                  }
                  continue;
                  l = 38L;
                  continue;
                }
                catch (Exception paramm)
                {
                  continue;
                }
                ??? = ???;
              }
              catch (Exception paramm)
              {
                continue;
              }
            }
          }
        }
        catch (Exception ???)
        {
          continue;
        }
      }
      synchronized (NotifyReceiver.access$400())
      {
        i = paramm.getType();
        bool2 = NotifyReceiver.Is().contains(Long.valueOf(l));
        if (NotifyReceiver.Iq() != null)
        {
          bool1 = NotifyReceiver.Iq().isLocking();
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifyReceiver", "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b", new Object[] { Integer.valueOf(i), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          NotifyReceiver.Is().remove(Long.valueOf(l));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.a
 * JD-Core Version:    0.7.0.1
 */