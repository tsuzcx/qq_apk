package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  
  public final void a(j paramj)
  {
    int i = 0;
    AppMethodBeat.i(136692);
    paramj.mRX = g.aU(this.mSJ.query, true);
    Object localObject1 = a.a(this.mUg);
    Object localObject2 = paramj.mRX;
    Object localObject3 = ((g)localObject2).bBX();
    long l1 = ((g)localObject2).mSA.size();
    long l2 = System.currentTimeMillis();
    localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), Long.valueOf(l1), Long.valueOf(l2 - 1105032704L), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), localObject3 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).mQr.rawQuery((String)localObject2, null);
    localObject2 = new ArrayList();
    localObject3 = new HashSet();
    ((HashSet)localObject3).addAll(this.mSJ.mSS);
    while (((Cursor)localObject1).moveToNext())
    {
      m localm = new m().i((Cursor)localObject1);
      if (((HashSet)localObject3).add(localm.mRV))
      {
        if (i >= localm.mRU) {
          ((List)localObject2).add(localm);
        }
        while (Thread.interrupted())
        {
          ((Cursor)localObject1).close();
          paramj = new InterruptedException("Task is Cancel: " + this.mSJ.query);
          AppMethodBeat.o(136692);
          throw paramj;
          if (((List)localObject2).size() > this.mSJ.mSR) {
            break label345;
          }
          i = localm.mRU;
          ((List)localObject2).add(localm);
        }
      }
    }
    label345:
    ((Cursor)localObject1).close();
    paramj.mSW = new ArrayList();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (m)((Iterator)localObject1).next();
      ((m)localObject2).bCa();
      ((m)localObject2).a(paramj.mRX);
      paramj.mSW.add(localObject2);
    }
    if (this.mSJ.mST != null) {
      Collections.sort(paramj.mSW, this.mSJ.mST);
    }
    AppMethodBeat.o(136692);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.t
 * JD-Core Version:    0.7.0.1
 */