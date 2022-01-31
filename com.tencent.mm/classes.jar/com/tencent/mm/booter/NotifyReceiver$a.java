package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public final class NotifyReceiver$a
  implements com.tencent.mm.ah.f
{
  private static long dhR = 0L;
  
  private void bl(long paramLong)
  {
    if (!aa.Un().getBoolean("is_in_notify_mode", false)) {
      return;
    }
    new ah(Looper.myLooper()).postDelayed(new NotifyReceiver.a.2(this), paramLong);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, m paramm)
  {
    long l = paramm.hashCode();
    if (paramm.getType() == 268369922) {
      l = ((com.tencent.mm.modelmulti.f)paramm).eso;
    }
    for (;;)
    {
      try
      {
        NotifyReceiver.wc().lock();
      }
      finally
      {
        try
        {
          int i;
          boolean bool2;
          boolean bool1;
          NotifyReceiver.wc().unlock();
          try
          {
            NotifyReceiver.wc().lock();
            if (!NotifyReceiver.wd().isEmpty()) {
              continue;
            }
            synchronized (NotifyReceiver.access$400())
            {
              if (NotifyReceiver.wb() == null) {
                continue;
              }
              NotifyReceiver.wb().unLock();
              y.i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
            }
          }
          finally
          {
            try
            {
              NotifyReceiver.wc().unlock();
              switch (paramm.getType())
              {
              default: 
                bl(7000L);
                return;
                bool1 = false;
                continue;
                paramm = finally;
                throw paramm;
                ??? = finally;
              }
            }
            catch (Exception ???)
            {
              try
              {
                NotifyReceiver.wc().unlock();
                throw ???;
                paramm = finally;
                throw paramm;
                ??? = finally;
                try
                {
                  NotifyReceiver.wc().unlock();
                  throw ???;
                  y.i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", new Object[] { Integer.valueOf(NotifyReceiver.wd().size()) });
                  continue;
                  if (!g.DN().Dc()) {
                    continue;
                  }
                  Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
                  {
                    public final boolean queueIdle()
                    {
                      NotifyReceiver.a.a(NotifyReceiver.a.this);
                      return false;
                    }
                  });
                  if ((paramInt1 != 0) || (paramInt2 != 0) || (!com.tencent.mm.model.a.Fp())) {
                    continue;
                  }
                  try
                  {
                    g.DQ();
                    ??? = g.DN().dJw;
                    if (???.dUe > -1L) {
                      ???.dUe += 1L;
                    }
                    y.i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", new Object[] { Long.valueOf(???.dUe) });
                    if ((???.dUe != 2L) && (???.dUe != 5L)) {
                      continue;
                    }
                    paramm = com.tencent.mm.plugin.report.f.nEG;
                    if (???.dUe != 2L) {
                      continue;
                    }
                    l = 37L;
                    paramm.a(226L, l, 1L, false);
                    com.tencent.mm.plugin.report.f.nEG.f(11098, new Object[] { Integer.valueOf(2001), Long.valueOf(???.dUe) });
                  }
                  catch (Throwable ???)
                  {
                    y.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { bk.j(???) });
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
        bool2 = NotifyReceiver.wd().contains(Long.valueOf(l));
        if (NotifyReceiver.wb() != null)
        {
          bool1 = NotifyReceiver.wb().isLocking();
          y.i("MicroMsg.NotifyReceiver", "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b", new Object[] { Integer.valueOf(i), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          NotifyReceiver.wd().remove(Long.valueOf(l));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.a
 * JD-Core Version:    0.7.0.1
 */