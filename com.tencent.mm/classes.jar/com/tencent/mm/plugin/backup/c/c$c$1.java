package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

final class c$c$1
  implements Runnable
{
  c$c$1(c.c paramc) {}
  
  public final void run()
  {
    Object localObject1;
    while (!this.hGN.hGk.hGc)
    {
      localObject1 = null;
      try
      {
        localObject2 = this.hGN.hGJ.poll(500L, TimeUnit.MILLISECONDS);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        Object localObject2;
        label38:
        c.b localb1;
        break label38;
      }
      y.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", new Object[] { Integer.valueOf(this.hGN.hGJ.size()), localObject1 });
      if (localObject1 != null)
      {
        if (localObject1 != this.hGN.hGK) {
          break label98;
        }
        this.hGN.hGK.open();
      }
    }
    return;
    label98:
    localb1 = (c.b)localObject1;
    localb1.fSF = true;
    localObject2 = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
    if (localb1.fSF)
    {
      localObject1 = "S.";
      label134:
      localb1.TAG = ((String)localObject1 + localb1.hFC + "." + localb1.aVr);
      label170:
      while (!this.hGN.hGk.hGc)
      {
        localObject1 = null;
        try
        {
          localObject2 = (Runnable)localb1.hGo.poll(500L, TimeUnit.MILLISECONDS);
          localObject1 = localObject2;
        }
        catch (Exception localException1)
        {
          label209:
          long l1;
          int k;
          long l2;
          int i;
          int j;
          String str;
          c.b localb2;
          break label209;
        }
        if (localObject1 != null)
        {
          l1 = bk.UY();
          ((Runnable)localObject1).run();
          k = localb1.hGo.size();
          l2 = this.hGN.hGp.hGl.get();
          if (l2 < 8388608L) {
            break label423;
          }
          i = 1;
          if (l2 < 16777216L) {
            break label428;
          }
          j = 1;
          str = String.format("[%s,%s,%s]", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j) });
          l1 = bk.co(l1);
          localb2 = this.hGN.hGL;
          if (this.hGN.hGL == null) {
            break label433;
          }
        }
      }
    }
    else
    {
      label261:
      label272:
      label423:
      label428:
      label433:
      for (localObject2 = Integer.valueOf(this.hGN.hGL.hGo.size());; localObject2 = "null")
      {
        y.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s,%s]", new Object[] { Integer.valueOf(k), str, Long.valueOf(l1), localObject1, localb1, localb2, localObject2 });
        if (localb1.fSF) {
          break label170;
        }
        System.gc();
        break;
        localObject1 = "W.";
        break label134;
        i = 0;
        break label261;
        j = 0;
        break label272;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.c.1
 * JD-Core Version:    0.7.0.1
 */