package com.tencent.mm.plugin.fav.b.e;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(5362);
    Object localObject = ((ae)g.G(ae.class)).getFavEditInfoStorage().bwH();
    if (localObject == null)
    {
      AppMethodBeat.o(5362);
      return;
    }
    ab.i("MicroMsg.Fav.FavEditService", "infos size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      String str = c.z(localf.field_localId, localf.field_type);
      c.a locala = (c.a)this.mvi.mvh.get(str);
      if (locala == null)
      {
        ab.i("MicroMsg.Fav.FavEditService", "not match key %s", new Object[] { str });
        locala = new c.a((byte)0);
        locala.muv = localf;
        locala.retryCount = 3;
        locala.time = SystemClock.elapsedRealtime();
        this.mvi.mvh.put(str, locala);
        c.a(locala, true);
      }
      else
      {
        ab.i("MicroMsg.Fav.FavEditService", "match key %s, check start", new Object[] { str });
        c.a(locala, false);
      }
    }
    AppMethodBeat.o(5362);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5363);
    String str = super.toString() + "|run";
    AppMethodBeat.o(5363);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.c.1
 * JD-Core Version:    0.7.0.1
 */