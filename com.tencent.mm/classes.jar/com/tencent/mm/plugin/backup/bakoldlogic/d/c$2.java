package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.f;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.a;
import com.tencent.mm.cg.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

final class c$2
  implements h.a
{
  c$2(c paramc) {}
  
  public final void RB()
  {
    AppMethodBeat.i(18023);
    if (this.jJf.jJd != null)
    {
      g localg = this.jJf.jJd;
      Iterator localIterator = localg.yQN.keySet().iterator();
      while (localIterator.hasNext()) {
        ((i)localg.yQN.get(localIterator.next())).dzW();
      }
    }
    AppMethodBeat.o(18023);
  }
  
  public final void RC() {}
  
  public final void RD()
  {
    AppMethodBeat.i(18024);
    if (this.jJf.jJd != null)
    {
      g localg = this.jJf.jJd;
      if (localg.yQO.size() != 0)
      {
        ab.i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", new Object[] { "stg_null", Integer.valueOf(localg.yQO.size()) });
        if (localg.yQj == null)
        {
          ab.e("MicroMsg.MemoryStorage", "attachTable db is null");
          AppMethodBeat.o(18024);
          return;
        }
        g.a locala;
        if (localg.yQL.inTransaction())
        {
          ab.w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", new Object[] { Integer.valueOf(localg.yQO.size()) });
          AppMethodBeat.o(18024);
          return;
          locala = (g.a)localg.yQO.peek();
          if (locala != null) {
            break label213;
          }
          localg.yQO.poll();
        }
        for (;;)
        {
          if (localg.yQO.size() <= 0) {
            break label611;
          }
          if (!localg.yQL.inTransaction()) {
            break;
          }
          ab.w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", new Object[] { Integer.valueOf(localg.yQO.size()) });
          AppMethodBeat.o(18024);
          return;
          label213:
          String str = locala.getTableName();
          if (bo.isNullOrNil(str))
          {
            ab.e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", new Object[] { str });
            localg.yQO.poll();
          }
          else if (f.a(localg.yQj, str))
          {
            ab.e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", new Object[] { str });
            localg.yQO.poll();
          }
          else
          {
            if (localg.atc(str) != 0) {
              for (;;)
              {
                try
                {
                  if (localg.vLI)
                  {
                    localg.yQj.execSQL("DETACH DATABASE old");
                    ab.i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                    localg.vLI = false;
                  }
                  if (!bo.isNullOrNil(localg.yQL.getKey())) {
                    continue;
                  }
                  localg.yQj.execSQL("ATTACH DATABASE '" + localg.yQL.getPath() + "' AS old ");
                  ab.i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                  localg.vLI = true;
                }
                catch (Exception localException)
                {
                  localg.vLI = false;
                  ab.e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", new Object[] { localException.getMessage() });
                  ab.e("MicroMsg.MemoryStorage", "exception:%s", new Object[] { bo.l(localException) });
                  continue;
                }
                if (localg.atc(str) == 0) {
                  break label518;
                }
                ab.e("MicroMsg.MemoryStorage", "copy table failed :".concat(String.valueOf(str)));
                AppMethodBeat.o(18024);
                return;
                localg.yQj.execSQL("ATTACH DATABASE '" + localg.yQL.getPath() + "' AS old KEY '" + localg.yQL.getKey() + "'");
              }
            }
            label518:
            ab.i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", new Object[] { str, Integer.valueOf(localg.yQO.size()), Integer.valueOf(localg.yQN.size()) });
            i locali = new i(localg.yQL, str);
            localg.yQN.put(str, locali);
            locala.a(localg);
            localg.yQO.poll();
          }
        }
      }
    }
    label611:
    AppMethodBeat.o(18024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c.2
 * JD-Core Version:    0.7.0.1
 */