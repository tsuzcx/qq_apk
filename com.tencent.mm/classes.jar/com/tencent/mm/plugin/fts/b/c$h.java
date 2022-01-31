package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import java.util.ArrayList;
import java.util.List;

final class c$h
  extends com.tencent.mm.plugin.fts.a.a.h
{
  c$h(c paramc, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    DW("start");
    paramj.kwi = com.tencent.mm.plugin.fts.a.a.g.a(this.kwT.bVk, false, this.kze.kzd);
    Object localObject1 = this.kze.kyW;
    Object localObject3 = paramj.kwi;
    Object localObject2 = this.kwT.kwY;
    localObject3 = ((com.tencent.mm.plugin.fts.a.a.g)localObject3).aVy();
    localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.c)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.c)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.c)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.c)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.c)localObject1).aVt(), localObject3 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery((String)localObject3, new String[] { localObject2 });
    paramj.kxh = new ArrayList();
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = new m().h((Cursor)localObject1);
      paramj.kxh.add(localObject2);
    }
    ((Cursor)localObject1).close();
    DW("findConversationMessage");
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
  
  public final int getId()
  {
    return 14;
  }
  
  public final String getName()
  {
    return "SearchConversationMessageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.h
 * JD-Core Version:    0.7.0.1
 */