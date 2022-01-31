package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
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
  
  protected final void a(j paramj)
  {
    paramj.kwi = g.aF(this.kwT.bVk, true);
    Object localObject1 = this.kap.kam;
    Object localObject2 = paramj.kwi;
    int i = this.kwT.kxc;
    localObject2 = ((g)localObject2).aVy();
    localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY -timestamp, subtype limit " + (i + 1 + 1) + ";", new Object[] { ((a)localObject1).aVs(), ((a)localObject1).aVs(), ((a)localObject1).aVt(), ((a)localObject1).aVs(), ((a)localObject1).aVt(), ((a)localObject1).aVt(), localObject2 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery((String)localObject2, null);
    paramj.kxh = new ArrayList();
    localObject2 = new HashSet();
    while (((Cursor)localObject1).moveToNext()) {
      if (((HashSet)localObject2).add(String.valueOf(((Cursor)localObject1).getLong(3))))
      {
        m localm = new m().j((Cursor)localObject1);
        paramj.kxh.add(localm);
        if (paramj.kxh.size() <= this.kwT.kxc) {
          if (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            throw new InterruptedException();
          }
        }
      }
    }
    ((Cursor)localObject1).close();
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.f
 * JD-Core Version:    0.7.0.1
 */