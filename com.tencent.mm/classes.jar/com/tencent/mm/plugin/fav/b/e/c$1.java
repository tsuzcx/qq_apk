package com.tencent.mm.plugin.fav.b.e;

import android.os.SystemClock;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    Object localObject = ((ae)g.t(ae.class)).getFavEditInfoStorage().aQs();
    if (localObject == null) {}
    for (;;)
    {
      return;
      y.i("MicroMsg.Fav.FavEditService", "infos size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        f localf = (f)((Iterator)localObject).next();
        String str = c.u(localf.field_localId, localf.field_type);
        c.a locala = (c.a)this.kaM.kaL.get(str);
        if (locala == null)
        {
          y.i("MicroMsg.Fav.FavEditService", "not match key %s", new Object[] { str });
          locala = new c.a((byte)0);
          locala.jZZ = localf;
          locala.retryCount = 3;
          locala.time = SystemClock.elapsedRealtime();
          this.kaM.kaL.put(str, locala);
          c.a(locala, true);
        }
        else
        {
          y.i("MicroMsg.Fav.FavEditService", "match key %s, check start", new Object[] { str });
          c.a(locala, false);
        }
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|run";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.c.1
 * JD-Core Version:    0.7.0.1
 */