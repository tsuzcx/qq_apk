package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class b$f
  extends i
{
  b$f(b paramb, j paramj)
  {
    super(paramj);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(101570);
    paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.query, true);
    Object localObject1 = b.a(this.wHX);
    Object localObject2 = paramk.BHY;
    int i = this.BIJ.BIR;
    localObject2 = ((com.tencent.mm.plugin.fts.a.a.h)localObject2).eqQ();
    localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY -timestamp, subtype limit " + (i + 1 + 1) + ";", new Object[] { ((a)localObject1).eqI(), ((a)localObject1).eqI(), ((a)localObject1).eqJ(), ((a)localObject1).eqI(), ((a)localObject1).eqJ(), ((a)localObject1).eqJ(), localObject2 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery((String)localObject2, null);
    paramk.BIW = new ArrayList();
    localObject2 = new HashSet();
    while (((Cursor)localObject1).moveToNext()) {
      if (((HashSet)localObject2).add(String.valueOf(((Cursor)localObject1).getLong(3))))
      {
        n localn = new n().k((Cursor)localObject1);
        paramk.BIW.add(localn);
        if (paramk.BIW.size() <= this.BIJ.BIR) {
          if (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramk = new InterruptedException();
            AppMethodBeat.o(101570);
            throw paramk;
          }
        }
      }
    }
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    if (Thread.interrupted())
    {
      paramk = new InterruptedException();
      AppMethodBeat.o(101570);
      throw paramk;
    }
    AppMethodBeat.o(101570);
  }
  
  public final int getId()
  {
    return 9;
  }
  
  public final String getName()
  {
    return "SearchTopFavoriteTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.f
 * JD-Core Version:    0.7.0.1
 */