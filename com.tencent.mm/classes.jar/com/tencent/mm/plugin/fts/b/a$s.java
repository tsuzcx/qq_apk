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

final class a$s
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public a$s(a parama, i parami)
  {
    super(parami);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136691);
    paramj.mRX = g.aU(this.mSJ.query, true);
    Object localObject1 = a.a(this.mUg);
    Object localObject2 = paramj.mRX;
    Object localObject3 = this.mSJ.mSP;
    Object localObject4 = ((g)localObject2).bBX();
    long l1 = System.currentTimeMillis();
    long l2 = ((g)localObject2).mSA.size();
    localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + d.v((int[])localObject3) + " ORDER BY Rank ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), Long.valueOf(l1 - 1105032704L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), localObject4 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).mQr.rawQuery((String)localObject3, new String[] { ((g)localObject2).mSx });
    localObject2 = new ArrayList();
    localObject3 = new HashSet();
    ((HashSet)localObject3).addAll(this.mSJ.mSS);
    l1 = 0L;
    while (((Cursor)localObject1).moveToNext())
    {
      localObject4 = new m().h((Cursor)localObject1);
      if (((HashSet)localObject3).add(((m)localObject4).mRV))
      {
        if (l1 >= ((m)localObject4).mTh) {
          ((List)localObject2).add(localObject4);
        }
        while (Thread.interrupted())
        {
          ((Cursor)localObject1).close();
          paramj = new InterruptedException("Task is Cancel: " + this.mSJ.query);
          AppMethodBeat.o(136691);
          throw paramj;
          if (((List)localObject2).size() > this.mSJ.mSR) {
            break label407;
          }
          l1 = ((m)localObject4).mTh;
          ((List)localObject2).add(localObject4);
        }
      }
    }
    label407:
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
    AppMethodBeat.o(136691);
  }
  
  public final int getId()
  {
    return 26;
  }
  
  public final String getName()
  {
    return "SearchTopContactInnerRankTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.s
 * JD-Core Version:    0.7.0.1
 */