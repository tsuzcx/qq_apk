package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.cf.f;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.a;
import com.tencent.mm.cf.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

final class c$2
  implements h.a
{
  c$2(c paramc) {}
  
  public final void DG()
  {
    if (this.hPD.hPB != null)
    {
      g localg = this.hPD.hPB;
      Iterator localIterator = localg.uEe.keySet().iterator();
      while (localIterator.hasNext()) {
        ((i)localg.uEe.get(localIterator.next())).cxh();
      }
    }
  }
  
  public final void DH() {}
  
  public final void DI()
  {
    g localg;
    if (this.hPD.hPB != null)
    {
      localg = this.hPD.hPB;
      if (localg.uEf.size() != 0)
      {
        y.i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", new Object[] { "stg_null", Integer.valueOf(localg.uEf.size()) });
        if (localg.uDC != null) {
          break label76;
        }
        y.e("MicroMsg.MemoryStorage", "attachTable db is null");
      }
    }
    label189:
    label586:
    for (;;)
    {
      return;
      label76:
      g.a locala;
      if (localg.uEc.inTransaction())
      {
        y.w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", new Object[] { Integer.valueOf(localg.uEf.size()) });
        return;
        locala = (g.a)localg.uEf.peek();
        if (locala != null) {
          break label189;
        }
        localg.uEf.poll();
      }
      for (;;)
      {
        if (localg.uEf.size() <= 0) {
          break label586;
        }
        if (!localg.uEc.inTransaction()) {
          break;
        }
        y.w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", new Object[] { Integer.valueOf(localg.uEf.size()) });
        return;
        String str = locala.getTableName();
        if (bk.bl(str))
        {
          y.e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", new Object[] { str });
          localg.uEf.poll();
        }
        else if (f.a(localg.uDC, str))
        {
          y.e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", new Object[] { str });
          localg.uEf.poll();
        }
        else
        {
          if (localg.acO(str) != 0) {
            for (;;)
            {
              try
              {
                if (localg.rUU)
                {
                  localg.uDC.execSQL("DETACH DATABASE old");
                  y.i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                  localg.rUU = false;
                }
                if (!bk.bl(localg.uEc.getKey())) {
                  continue;
                }
                localg.uDC.execSQL("ATTACH DATABASE '" + localg.uEc.getPath() + "' AS old ");
                y.i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                localg.rUU = true;
              }
              catch (Exception localException)
              {
                localg.rUU = false;
                y.e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", new Object[] { localException.getMessage() });
                y.e("MicroMsg.MemoryStorage", "exception:%s", new Object[] { bk.j(localException) });
                continue;
              }
              if (localg.acO(str) == 0) {
                break label495;
              }
              y.e("MicroMsg.MemoryStorage", "copy table failed :" + str);
              return;
              localg.uDC.execSQL("ATTACH DATABASE '" + localg.uEc.getPath() + "' AS old KEY '" + localg.uEc.getKey() + "'");
            }
          }
          label495:
          y.i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", new Object[] { str, Integer.valueOf(localg.uEf.size()), Integer.valueOf(localg.uEe.size()) });
          i locali = new i(localg.uEc, str);
          localg.uEe.put(str, locali);
          locala.a(localg);
          localg.uEf.poll();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c.2
 * JD-Core Version:    0.7.0.1
 */