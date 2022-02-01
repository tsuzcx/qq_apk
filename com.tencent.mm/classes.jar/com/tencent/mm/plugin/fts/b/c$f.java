package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class c$f
  extends i
{
  c$f(c paramc, j paramj)
  {
    super(paramj);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(52730);
    afX("start");
    paramk.sxM = com.tencent.mm.plugin.fts.a.a.h.a(this.syx.query, false, this.sAF.sAE);
    Object localObject1 = this.sAF.sAz;
    Object localObject3 = paramk.sxM;
    Object localObject2 = this.syx.syB;
    localObject3 = ((com.tencent.mm.plugin.fts.a.a.h)localObject3).cKw();
    localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cKq(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cKr(), ((com.tencent.mm.plugin.fts.c.c)localObject1).cKr(), localObject3 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).swc.rawQuery((String)localObject3, new String[] { localObject2 });
    paramk.syK = new ArrayList();
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject1);
      paramk.syK.add(localObject2);
    }
    ((Cursor)localObject1).close();
    afX("findConversationMessage");
    if ((paramk.sxM.syn.length > 1) && (!this.syx.syG.contains("create_talker_message​")))
    {
      localObject1 = com.tencent.mm.plugin.fts.a.a.h.bi(paramk.sxM.syn[0], true);
      localObject1 = ((com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.swu, com.tencent.mm.plugin.fts.a.c.swy);
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new m();
        ((m)localObject2).sxG = "create_talker_message​";
        paramk.syK.add(0, localObject2);
      }
      ((Cursor)localObject1).close();
      afX("findTalkerConversation");
    }
    AppMethodBeat.o(52730);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.f
 * JD-Core Version:    0.7.0.1
 */