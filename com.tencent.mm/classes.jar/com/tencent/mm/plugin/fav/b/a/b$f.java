package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class b$f
  extends com.tencent.mm.plugin.fts.a.a.h
{
  b$f(b paramb, i parami)
  {
    super(parami);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(5310);
    paramj.mRX = g.aU(this.mSJ.query, true);
    Object localObject1 = this.muL.muI;
    Object localObject2 = paramj.mRX;
    int i = this.mSJ.mSR;
    localObject2 = ((g)localObject2).bBX();
    localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY -timestamp, subtype limit " + (i + 1 + 1) + ";", new Object[] { ((a)localObject1).bBR(), ((a)localObject1).bBR(), ((a)localObject1).bBS(), ((a)localObject1).bBR(), ((a)localObject1).bBS(), ((a)localObject1).bBS(), localObject2 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).mQr.rawQuery((String)localObject2, null);
    paramj.mSW = new ArrayList();
    localObject2 = new HashSet();
    while (((Cursor)localObject1).moveToNext()) {
      if (((HashSet)localObject2).add(String.valueOf(((Cursor)localObject1).getLong(3))))
      {
        m localm = new m().i((Cursor)localObject1);
        paramj.mSW.add(localm);
        if (paramj.mSW.size() <= this.mSJ.mSR) {
          if (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramj = new InterruptedException();
            AppMethodBeat.o(5310);
            throw paramj;
          }
        }
      }
    }
    ((Cursor)localObject1).close();
    if (Thread.interrupted())
    {
      paramj = new InterruptedException();
      AppMethodBeat.o(5310);
      throw paramj;
    }
    AppMethodBeat.o(5310);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.f
 * JD-Core Version:    0.7.0.1
 */