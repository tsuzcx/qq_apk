package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import java.util.LinkedList;
import java.util.List;

final class c$i
  extends i
{
  private int sAS = 0;
  private int sAT = 0;
  
  public c$i(c paramc, j paramj)
  {
    super(paramj);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(52733);
    afX("start");
    paramk.sxM = com.tencent.mm.plugin.fts.a.a.h.a(this.syx.query, false, this.sAF.sAE);
    Object localObject2 = this.sAF.sAz;
    Object localObject1 = paramk.sxM;
    int i = this.syx.syF;
    String str = ((com.tencent.mm.plugin.fts.a.a.h)localObject1).cKw();
    if (i != 2147483647) {}
    for (localObject1 = " LIMIT " + (i + 1);; localObject1 = "")
    {
      localObject1 = String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject2).cKq(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cKr(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cKq(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cKr(), ((com.tencent.mm.plugin.fts.c.c)localObject2).cKr(), str });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).swc.rawQuery((String)localObject1, null);
      paramk.syK = new LinkedList();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new m();
        ((m)localObject2).type = ((Cursor)localObject1).getInt(0);
        ((m)localObject2).sxF = ((Cursor)localObject1).getInt(1);
        ((m)localObject2).syN = ((Cursor)localObject1).getLong(2);
        ((m)localObject2).sxG = ((Cursor)localObject1).getString(3);
        ((m)localObject2).timestamp = ((Cursor)localObject1).getLong(4);
        ((m)localObject2).userData = Integer.valueOf(((Cursor)localObject1).getInt(5));
        paramk.syK.add(localObject2);
        i = this.sAS;
        this.sAS = (((Integer)((m)localObject2).userData).intValue() + i);
        this.sAT += 1;
      }
    }
    ((Cursor)localObject1).close();
    afX("groupMessage");
    if (paramk.sxM.syn.length > 1)
    {
      localObject1 = com.tencent.mm.plugin.fts.a.a.h.bi(paramk.sxM.syn[0], true);
      localObject1 = ((com.tencent.mm.plugin.fts.c.a)((n)g.ad(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.h)localObject1, null, com.tencent.mm.plugin.fts.a.c.swu, com.tencent.mm.plugin.fts.a.c.swy);
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new m();
        ((m)localObject2).sxG = "create_talker_message​";
        paramk.syK.add(0, localObject2);
      }
      ((Cursor)localObject1).close();
      afX("findTalkerConversation");
    }
    AppMethodBeat.o(52733);
  }
  
  public final String bdq()
  {
    AppMethodBeat.i(52734);
    String str = String.format("{totalMsgCount: %d conversationCount: %d}", new Object[] { Integer.valueOf(this.sAS), Integer.valueOf(this.sAT) });
    AppMethodBeat.o(52734);
    return str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.i
 * JD-Core Version:    0.7.0.1
 */