package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class c$f
  extends com.tencent.mm.plugin.fts.a.a.h
{
  c$f(c paramc, i parami)
  {
    super(parami);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136756);
    Pg("start");
    paramj.mRX = com.tencent.mm.plugin.fts.a.a.g.a(this.mSJ.query, false, this.mUU.mUT);
    Object localObject1 = this.mUU.mUM;
    Object localObject3 = paramj.mRX;
    Object localObject2 = this.mSJ.mSN;
    localObject3 = ((com.tencent.mm.plugin.fts.a.a.g)localObject3).bBX();
    localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.c)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.c)localObject1).bBS(), ((com.tencent.mm.plugin.fts.c.c)localObject1).bBR(), ((com.tencent.mm.plugin.fts.c.c)localObject1).bBS(), ((com.tencent.mm.plugin.fts.c.c)localObject1).bBS(), localObject3 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).mQr.rawQuery((String)localObject3, new String[] { localObject2 });
    paramj.mSW = new ArrayList();
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = new m().g((Cursor)localObject1);
      paramj.mSW.add(localObject2);
    }
    ((Cursor)localObject1).close();
    Pg("findConversationMessage");
    if ((paramj.mRX.mSz.length > 1) && (!this.mSJ.mSS.contains("create_talker_message​")))
    {
      localObject1 = com.tencent.mm.plugin.fts.a.a.g.aU(paramj.mRX.mSz[0], true);
      localObject1 = ((com.tencent.mm.plugin.fts.c.a)((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.g)localObject1, null, com.tencent.mm.plugin.fts.a.c.mQJ, com.tencent.mm.plugin.fts.a.c.mQN);
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new l();
        ((l)localObject2).mRV = "create_talker_message​";
        paramj.mSW.add(0, localObject2);
      }
      ((Cursor)localObject1).close();
      Pg("findTalkerConversation");
    }
    AppMethodBeat.o(136756);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.f
 * JD-Core Version:    0.7.0.1
 */