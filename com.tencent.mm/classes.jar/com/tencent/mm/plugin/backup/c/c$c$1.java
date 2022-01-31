package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

final class c$c$1
  implements Runnable
{
  c$c$1(c.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(17191);
    while (!this.jAj.jzG.jzy)
    {
      Object localObject1 = null;
      label273:
      try
      {
        localObject2 = this.jAj.jAf.poll(500L, TimeUnit.MILLISECONDS);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        Object localObject2;
        label44:
        c.b localb;
        label146:
        label182:
        label221:
        break label44;
      }
      ab.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", new Object[] { Integer.valueOf(this.jAj.jAf.size()), localObject1 });
      if (localObject1 != null)
      {
        if (localObject1 == this.jAj.jAg)
        {
          this.jAj.jAg.open();
          AppMethodBeat.o(17191);
          return;
        }
        localb = (c.b)localObject1;
        localb.hmf = true;
        localObject2 = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
        if (localb.hmf)
        {
          localObject1 = "S.";
          localb.TAG = ((String)localObject1 + localb.jyZ + "." + localb.blZ);
          while (!this.jAj.jzG.jzy)
          {
            localObject1 = null;
            try
            {
              localObject2 = (Runnable)localb.jzK.poll(500L, TimeUnit.MILLISECONDS);
              localObject1 = localObject2;
            }
            catch (Exception localException1)
            {
              long l1;
              int k;
              long l2;
              int i;
              int j;
              break label221;
            }
            if (localObject1 != null)
            {
              l1 = bo.aoy();
              ((Runnable)localObject1).run();
              k = localb.jzK.size();
              l2 = this.jAj.jzL.jzH.get();
              if (l2 < 8388608L) {
                break label389;
              }
              i = 1;
              if (l2 < 16777216L) {
                break label394;
              }
            }
          }
        }
        label389:
        label394:
        for (j = 1;; j = 0)
        {
          ab.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s]", new Object[] { Integer.valueOf(k), String.format("[%s,%s,%s]", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j) }), Long.valueOf(bo.hl(l1)), localObject1, localb, this.jAj.jAh });
          if (localb.hmf) {
            break label182;
          }
          System.gc();
          break;
          localObject1 = "W.";
          break label146;
          i = 0;
          break label273;
        }
      }
    }
    AppMethodBeat.o(17191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.c.1
 * JD-Core Version:    0.7.0.1
 */