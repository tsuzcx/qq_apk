package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
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
  
  protected final void a(j paramj)
  {
    DW("start");
    paramj.kwi = g.aF(this.kwT.bVk, true);
    Object localObject1 = a.a(this.kyt);
    Object localObject2 = paramj.kwi;
    Object localObject3 = ((g)localObject2).aVy();
    long l1 = System.currentTimeMillis();
    long l2 = ((g)localObject2).kwK.size();
    localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), Long.valueOf(l1 - 1209600000L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), localObject3 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery((String)localObject3, new String[] { ((g)localObject2).kwH });
    localObject2 = new ArrayList();
    localObject3 = new HashSet();
    ((HashSet)localObject3).addAll(this.kwT.kxd);
    while (((Cursor)localObject1).moveToNext())
    {
      m localm = new m().i((Cursor)localObject1);
      if (((HashSet)localObject3).add(localm.kwg)) {
        if (((List)localObject2).size() <= this.kwT.kxc)
        {
          ((List)localObject2).add(localm);
          if (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            throw new InterruptedException("Task is Cancel: " + this.kwT.bVk);
          }
        }
      }
    }
    ((Cursor)localObject1).close();
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    DW("orm");
    paramj.kxh = new ArrayList(((List)localObject2).size());
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (m)((Iterator)localObject1).next();
      ((m)localObject2).aVA();
      ((m)localObject2).a(paramj.kwi);
      paramj.kxh.add(localObject2);
    }
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    if (this.kwT.kxe != null) {
      Collections.sort(paramj.kxh, this.kwT.kxe);
    }
    DW("calOffsets");
    if ((paramj.kwi.kwK.size() > 1) && (a.a(this.kyt).b(paramj.kwi)))
    {
      localObject1 = new l();
      ((l)localObject1).kwg = "create_chatroom​";
      if (paramj.kxh.size() <= 3) {
        break label568;
      }
      paramj.kxh.add(3, localObject1);
    }
    for (;;)
    {
      DW("checkChatroom");
      return;
      label568:
      paramj.kxh.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.r
 * JD-Core Version:    0.7.0.1
 */