package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.ArrayList;
import java.util.List;

final class a$k
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public a$k(a parama, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    super.a(paramj);
    Object localObject1 = a.a(this.kyt);
    Object localObject2 = this.kwT.bVk;
    String str = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs() });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery(str, new String[] { localObject2 });
    paramj.kxh = new ArrayList();
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = new l();
      ((l)localObject2).kwg = ((Cursor)localObject1).getString(0);
      paramj.kxh.add(localObject2);
    }
    ((Cursor)localObject1).close();
    paramj.aYY = 0;
  }
  
  public final String getName()
  {
    return "SearchChatroomByMemberTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.k
 * JD-Core Version:    0.7.0.1
 */