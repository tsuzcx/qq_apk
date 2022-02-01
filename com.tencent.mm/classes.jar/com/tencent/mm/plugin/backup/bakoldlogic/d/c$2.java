package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  
  public final void ajH()
  {
    AppMethodBeat.i(22080);
    if (this.nIo.nIm != null)
    {
      g localg = this.nIo.nIm;
      Iterator localIterator = localg.JjG.keySet().iterator();
      while (localIterator.hasNext()) {
        ((i)localg.JjG.get(localIterator.next())).fxV();
      }
    }
    AppMethodBeat.o(22080);
  }
  
  public final void ajI() {}
  
  public final void ajJ()
  {
    AppMethodBeat.i(22081);
    if (this.nIo.nIm != null)
    {
      g localg = this.nIo.nIm;
      if (localg.JjH.size() != 0)
      {
        ae.i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", new Object[] { "stg_null", Integer.valueOf(localg.JjH.size()) });
        if (localg.iQT == null)
        {
          ae.e("MicroMsg.MemoryStorage", "attachTable db is null");
          AppMethodBeat.o(22081);
          return;
        }
        g.a locala;
        if (localg.JjE.inTransaction())
        {
          ae.w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", new Object[] { Integer.valueOf(localg.JjH.size()) });
          AppMethodBeat.o(22081);
          return;
          locala = (g.a)localg.JjH.peek();
          if (locala != null) {
            break label213;
          }
          localg.JjH.poll();
        }
        for (;;)
        {
          if (localg.JjH.size() <= 0) {
            break label611;
          }
          if (!localg.JjE.inTransaction()) {
            break;
          }
          ae.w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", new Object[] { Integer.valueOf(localg.JjH.size()) });
          AppMethodBeat.o(22081);
          return;
          label213:
          String str = locala.getTableName();
          if (bu.isNullOrNil(str))
          {
            ae.e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", new Object[] { str });
            localg.JjH.poll();
          }
          else if (f.a(localg.iQT, str))
          {
            ae.e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", new Object[] { str });
            localg.JjH.poll();
          }
          else
          {
            if (localg.aWA(str) != 0) {
              for (;;)
              {
                try
                {
                  if (localg.FfS)
                  {
                    localg.iQT.execSQL("DETACH DATABASE old");
                    ae.i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                    localg.FfS = false;
                  }
                  if (!bu.isNullOrNil(localg.JjE.getKey())) {
                    continue;
                  }
                  localg.iQT.execSQL("ATTACH DATABASE '" + localg.JjE.getPath() + "' AS old ");
                  ae.i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                  localg.FfS = true;
                }
                catch (Exception localException)
                {
                  localg.FfS = false;
                  ae.e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", new Object[] { localException.getMessage() });
                  ae.e("MicroMsg.MemoryStorage", "exception:%s", new Object[] { bu.o(localException) });
                  continue;
                }
                if (localg.aWA(str) == 0) {
                  break label518;
                }
                ae.e("MicroMsg.MemoryStorage", "copy table failed :".concat(String.valueOf(str)));
                AppMethodBeat.o(22081);
                return;
                localg.iQT.execSQL("ATTACH DATABASE '" + localg.JjE.getPath() + "' AS old KEY '" + localg.JjE.getKey() + "'");
              }
            }
            label518:
            ae.i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", new Object[] { str, Integer.valueOf(localg.JjH.size()), Integer.valueOf(localg.JjG.size()) });
            i locali = new i(localg.JjE, str);
            localg.JjG.put(str, locali);
            locala.a(localg);
            localg.JjH.poll();
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