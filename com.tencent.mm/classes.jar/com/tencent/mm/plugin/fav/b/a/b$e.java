package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.n;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class b$e
  extends i
{
  b$e(b paramb, j paramj)
  {
    super(paramj);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(101569);
    paramk.tFe = h.bq(this.tFP.query, true);
    Object localObject1 = new HashMap();
    Object localObject2 = this.rCn.rCk.a(paramk.tFe, c.tDE, null, false, false);
    while (((Cursor)localObject2).moveToNext())
    {
      n localn = new n().i((Cursor)localObject2);
      m localm = (m)((HashMap)localObject1).get(Long.valueOf(localn.tGf));
      if ((localm == null) || (d.f(c.tDX, localn.tEX, localm.tEX) < 0)) {
        ((HashMap)localObject1).put(Long.valueOf(localn.tGf), localn);
      }
      if (Thread.interrupted())
      {
        ((Cursor)localObject2).close();
        paramk = new InterruptedException();
        AppMethodBeat.o(101569);
        throw paramk;
      }
    }
    ((Cursor)localObject2).close();
    if (Thread.interrupted())
    {
      paramk = new InterruptedException();
      AppMethodBeat.o(101569);
      throw paramk;
    }
    paramk.tGc = new ArrayList(((HashMap)localObject1).size());
    localObject1 = ((HashMap)localObject1).values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (n)((Iterator)localObject1).next();
      paramk.tGc.add(localObject2);
    }
    if (this.tFP.tFZ != null) {
      Collections.sort(paramk.tGc, this.tFP.tFZ);
    }
    AppMethodBeat.o(101569);
  }
  
  public final String getName()
  {
    return "SearchFavoriteTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */