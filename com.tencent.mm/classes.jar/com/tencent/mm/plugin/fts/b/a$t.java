package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class a$t
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public a$t(a parama, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    int i = 0;
    paramj.kwi = g.aF(this.kwT.bVk, true);
    Object localObject1 = a.a(this.kyt);
    Object localObject2 = paramj.kwi;
    Object localObject3 = ((g)localObject2).aVy();
    long l1 = ((g)localObject2).kwK.size();
    long l2 = System.currentTimeMillis();
    localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), Long.valueOf(l1), Long.valueOf(l2 - 1105032704L), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), localObject3 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery((String)localObject2, null);
    localObject2 = new ArrayList();
    localObject3 = new HashSet();
    ((HashSet)localObject3).addAll(this.kwT.kxd);
    while (((Cursor)localObject1).moveToNext())
    {
      m localm = new m().j((Cursor)localObject1);
      if (((HashSet)localObject3).add(localm.kwg))
      {
        if (i >= localm.kwf) {
          ((List)localObject2).add(localm);
        }
        while (Thread.interrupted())
        {
          ((Cursor)localObject1).close();
          throw new InterruptedException("Task is Cancel: " + this.kwT.bVk);
          if (((List)localObject2).size() > this.kwT.kxc) {
            break label333;
          }
          i = localm.kwf;
          ((List)localObject2).add(localm);
        }
      }
    }
    label333:
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
    return 22;
  }
  
  public final String getName()
  {
    return "SearchTopContactTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.t
 * JD-Core Version:    0.7.0.1
 */