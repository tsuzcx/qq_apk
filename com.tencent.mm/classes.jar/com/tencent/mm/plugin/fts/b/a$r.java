package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class a$r
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public a$r(a parama, i parami)
  {
    super(parami);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136690);
    Pg("start");
    paramj.mRX = g.aU(this.mSJ.query, true);
    Object localObject1 = a.a(this.mUg);
    Object localObject2 = paramj.mRX;
    Object localObject3 = ((g)localObject2).bBX();
    long l1 = System.currentTimeMillis();
    long l2 = ((g)localObject2).mSA.size();
    localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), Long.valueOf(l1 - 1209600000L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), ((com.tencent.mm.plugin.fts.c.a)localObject1).bBS(), localObject3 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).mQr.rawQuery((String)localObject3, new String[] { ((g)localObject2).mSx });
    localObject2 = new ArrayList();
    localObject3 = new HashSet();
    ((HashSet)localObject3).addAll(this.mSJ.mSS);
    while (((Cursor)localObject1).moveToNext())
    {
      m localm = new m().h((Cursor)localObject1);
      if (((HashSet)localObject3).add(localm.mRV)) {
        if (((List)localObject2).size() <= this.mSJ.mSR)
        {
          ((List)localObject2).add(localm);
          if (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            paramj = new InterruptedException("Task is Cancel: " + this.mSJ.query);
            AppMethodBeat.o(136690);
            throw paramj;
          }
        }
      }
    }
    ((Cursor)localObject1).close();
    if (Thread.interrupted())
    {
      paramj = new InterruptedException();
      AppMethodBeat.o(136690);
      throw paramj;
    }
    Pg("orm");
    paramj.mSW = new ArrayList(((List)localObject2).size());
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (m)((Iterator)localObject1).next();
      ((m)localObject2).bCa();
      ((m)localObject2).a(paramj.mRX);
      paramj.mSW.add(localObject2);
    }
    if (Thread.interrupted())
    {
      paramj = new InterruptedException();
      AppMethodBeat.o(136690);
      throw paramj;
    }
    if (this.mSJ.mST != null) {
      Collections.sort(paramj.mSW, this.mSJ.mST);
    }
    Pg("calOffsets");
    if ((paramj.mRX.mSA.size() > 1) && (a.a(this.mUg).b(paramj.mRX)))
    {
      localObject1 = new l();
      ((l)localObject1).mRV = "create_chatroom​";
      if (paramj.mSW.size() <= 3) {
        break label599;
      }
      paramj.mSW.add(3, localObject1);
    }
    for (;;)
    {
      Pg("checkChatroom");
      AppMethodBeat.o(136690);
      return;
      label599:
      paramj.mSW.add(localObject1);
    }
  }
  
  public final int getId()
  {
    return 25;
  }
  
  public final String getName()
  {
    return "SearchTopChatroomInnerRankTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.r
 * JD-Core Version:    0.7.0.1
 */