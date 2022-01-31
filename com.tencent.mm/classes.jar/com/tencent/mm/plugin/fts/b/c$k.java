package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import java.util.LinkedList;
import java.util.List;

final class c$k
  extends com.tencent.mm.plugin.fts.a.a.h
{
  private int kzq = 0;
  private int kzr = 0;
  
  public c$k(c paramc, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    DW("start");
    paramj.kwi = com.tencent.mm.plugin.fts.a.a.g.a(this.kwT.bVk, false, this.kze.kzd);
    Object localObject2 = this.kze.kyW;
    Object localObject1 = paramj.kwi;
    int i = this.kwT.kxc;
    String str = ((com.tencent.mm.plugin.fts.a.a.g)localObject1).aVy();
    if (i != 2147483647) {}
    for (localObject1 = " LIMIT " + (i + 1);; localObject1 = "")
    {
      localObject1 = String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject2).aVs(), ((com.tencent.mm.plugin.fts.c.c)localObject2).aVt(), ((com.tencent.mm.plugin.fts.c.c)localObject2).aVs(), ((com.tencent.mm.plugin.fts.c.c)localObject2).aVt(), ((com.tencent.mm.plugin.fts.c.c)localObject2).aVt(), str });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).kuE.rawQuery((String)localObject1, null);
      paramj.kxh = new LinkedList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new l();
        ((l)localObject2).type = ((Cursor)localObject1).getInt(0);
        ((l)localObject2).kwf = ((Cursor)localObject1).getInt(1);
        ((l)localObject2).kxk = ((Cursor)localObject1).getLong(2);
        ((l)localObject2).kwg = ((Cursor)localObject1).getString(3);
        ((l)localObject2).timestamp = ((Cursor)localObject1).getLong(4);
        ((l)localObject2).userData = Integer.valueOf(((Cursor)localObject1).getInt(5));
        paramj.kxh.add(localObject2);
        i = this.kzq;
        this.kzq = (((Integer)((l)localObject2).userData).intValue() + i);
        this.kzr += 1;
      }
    }
    ((Cursor)localObject1).close();
    DW("groupMessage");
    if (paramj.kwi.kwJ.length > 1)
    {
      localObject1 = com.tencent.mm.plugin.fts.a.a.g.aF(paramj.kwi.kwJ[0], true);
      localObject1 = ((com.tencent.mm.plugin.fts.c.a)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.g)localObject1, null, com.tencent.mm.plugin.fts.a.c.kuW, com.tencent.mm.plugin.fts.a.c.kva);
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new l();
        ((l)localObject2).kwg = "create_talker_message​";
        paramj.kxh.add(0, localObject2);
      }
      ((Cursor)localObject1).close();
      DW("findTalkerConversation");
    }
  }
  
  public final String afJ()
  {
    return String.format("{totalMsgCount: %d conversationCount: %d}", new Object[] { Integer.valueOf(this.kzq), Integer.valueOf(this.kzr) });
  }
  
  public final int getId()
  {
    return 15;
  }
  
  public final String getName()
  {
    return "SearchTopGroupMessageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.k
 * JD-Core Version:    0.7.0.1
 */