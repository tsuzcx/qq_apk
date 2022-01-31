package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class a$q
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public a$q(a parama, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    paramj.kwi = g.aF(this.kwT.bVk, true);
    Object localObject2 = a.a(this.kyt);
    Object localObject3 = paramj.kwi;
    Object localObject1 = this.kwT.kxa;
    Object localObject4 = ((g)localObject3).aVy();
    int i;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = " AND type IN " + d.l((int[])localObject1);
      long l = ((g)localObject3).kwK.size();
      localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject1 + " AND status >= 0 ORDER BY subtype;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVt(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVt(), localObject4 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).kuE.rawQuery((String)localObject1, null);
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.kwT.kxd);
      i = 0;
    }
    label385:
    for (;;)
    {
      if (!((Cursor)localObject1).moveToNext()) {
        break label387;
      }
      if (((HashSet)localObject3).add(((Cursor)localObject1).getString(3)))
      {
        localObject4 = new m().j((Cursor)localObject1);
        if (i >= ((m)localObject4).kwf) {
          ((List)localObject2).add(localObject4);
        }
        for (;;)
        {
          if (!Thread.interrupted()) {
            break label385;
          }
          ((Cursor)localObject1).close();
          throw new InterruptedException("Task is Cancel: " + this.kwT.bVk);
          localObject1 = "";
          break;
          if (((List)localObject2).size() > this.kwT.kxc) {
            break label387;
          }
          i = ((m)localObject4).kwf;
          ((List)localObject2).add(localObject4);
        }
      }
    }
    label387:
    ((Cursor)localObject1).close();
    paramj.kxh = new ArrayList();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (m)((Iterator)localObject1).next();
      ((m)localObject2).aVA();
      ((m)localObject2).a(paramj.kwi);
      paramj.kxh.add(localObject2);
    }
    if (this.kwT.kxe != null) {
      Collections.sort(paramj.kxh, this.kwT.kxe);
    }
  }
  
  public final int getId()
  {
    return 20;
  }
  
  public final String getName()
  {
    return "SearchContactTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.q
 * JD-Core Version:    0.7.0.1
 */