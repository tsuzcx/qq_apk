package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136689);
    paramj.mRX = g.aU(this.mSJ.query, true);
    Object localObject2 = a.a(this.mUg);
    Object localObject3 = paramj.mRX;
    Object localObject1 = this.mSJ.mSP;
    Object localObject4 = ((g)localObject3).bBX();
    int i;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = " AND type IN " + d.v((int[])localObject1);
      long l = ((g)localObject3).mSA.size();
      localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject1 + " AND status >= 0 ORDER BY subtype;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBS(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBS(), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBS(), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBS(), localObject4 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).mQr.rawQuery((String)localObject1, null);
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.mSJ.mSS);
      i = 0;
    }
    label397:
    for (;;)
    {
      if (!((Cursor)localObject1).moveToNext()) {
        break label399;
      }
      if (((HashSet)localObject3).add(((Cursor)localObject1).getString(3)))
      {
        localObject4 = new m().i((Cursor)localObject1);
        if (i >= ((m)localObject4).mRU) {
          ((List)localObject2).add(localObject4);
        }
        for (;;)
        {
          if (!Thread.interrupted()) {
            break label397;
          }
          ((Cursor)localObject1).close();
          paramj = new InterruptedException("Task is Cancel: " + this.mSJ.query);
          AppMethodBeat.o(136689);
          throw paramj;
          localObject1 = "";
          break;
          if (((List)localObject2).size() > this.mSJ.mSR) {
            break label399;
          }
          i = ((m)localObject4).mRU;
          ((List)localObject2).add(localObject4);
        }
      }
    }
    label399:
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
    AppMethodBeat.o(136689);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.q
 * JD-Core Version:    0.7.0.1
 */