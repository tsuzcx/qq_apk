package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.f;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

final class c$2
  implements h.a
{
  c$2(c paramc) {}
  
  public final void agH()
  {
    AppMethodBeat.i(22080);
    if (this.ncw.ncu != null)
    {
      g localg = this.ncw.ncu;
      Iterator localIterator = localg.HbI.keySet().iterator();
      while (localIterator.hasNext()) {
        ((i)localg.HbI.get(localIterator.next())).fdM();
      }
    }
    AppMethodBeat.o(22080);
  }
  
  public final void agI() {}
  
  public final void agJ()
  {
    AppMethodBeat.i(22081);
    if (this.ncw.ncu != null)
    {
      g localg = this.ncw.ncu;
      if (localg.HbJ.size() != 0)
      {
        ac.i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", new Object[] { "stg_null", Integer.valueOf(localg.HbJ.size()) });
        if (localg.Hbe == null)
        {
          ac.e("MicroMsg.MemoryStorage", "attachTable db is null");
          AppMethodBeat.o(22081);
          return;
        }
        g.a locala;
        if (localg.HbG.inTransaction())
        {
          ac.w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", new Object[] { Integer.valueOf(localg.HbJ.size()) });
          AppMethodBeat.o(22081);
          return;
          locala = (g.a)localg.HbJ.peek();
          if (locala != null) {
            break label213;
          }
          localg.HbJ.poll();
        }
        for (;;)
        {
          if (localg.HbJ.size() <= 0) {
            break label611;
          }
          if (!localg.HbG.inTransaction()) {
            break;
          }
          ac.w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", new Object[] { Integer.valueOf(localg.HbJ.size()) });
          AppMethodBeat.o(22081);
          return;
          label213:
          String str = locala.getTableName();
          if (bs.isNullOrNil(str))
          {
            ac.e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", new Object[] { str });
            localg.HbJ.poll();
          }
          else if (f.a(localg.Hbe, str))
          {
            ac.e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", new Object[] { str });
            localg.HbJ.poll();
          }
          else
          {
            if (localg.aPi(str) != 0) {
              for (;;)
              {
                try
                {
                  if (localg.DiI)
                  {
                    localg.Hbe.execSQL("DETACH DATABASE old");
                    ac.i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                    localg.DiI = false;
                  }
                  if (!bs.isNullOrNil(localg.HbG.getKey())) {
                    continue;
                  }
                  localg.Hbe.execSQL("ATTACH DATABASE '" + localg.HbG.getPath() + "' AS old ");
                  ac.i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                  localg.DiI = true;
                }
                catch (Exception localException)
                {
                  localg.DiI = false;
                  ac.e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", new Object[] { localException.getMessage() });
                  ac.e("MicroMsg.MemoryStorage", "exception:%s", new Object[] { bs.m(localException) });
                  continue;
                }
                if (localg.aPi(str) == 0) {
                  break label518;
                }
                ac.e("MicroMsg.MemoryStorage", "copy table failed :".concat(String.valueOf(str)));
                AppMethodBeat.o(22081);
                return;
                localg.Hbe.execSQL("ATTACH DATABASE '" + localg.HbG.getPath() + "' AS old KEY '" + localg.HbG.getKey() + "'");
              }
            }
            label518:
            ac.i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", new Object[] { str, Integer.valueOf(localg.HbJ.size()), Integer.valueOf(localg.HbI.size()) });
            i locali = new i(localg.HbG, str);
            localg.HbI.put(str, locali);
            locala.a(localg);
            localg.HbJ.poll();
          }
        }
      }
    }
    label611:
    AppMethodBeat.o(22081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c.2
 * JD-Core Version:    0.7.0.1
 */