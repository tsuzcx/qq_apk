package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.ArrayList;
import java.util.List;

final class a$l
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public a$l(a parama, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    int i = 0;
    super.a(paramj);
    Object localObject = a.a(this.kyt);
    String str1 = this.kwT.bVk;
    String str2 = String.format("SELECT count(aux_index) FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject).aVs() });
    localObject = ((com.tencent.mm.plugin.fts.a.a)localObject).kuE.rawQuery(str2, new String[] { str1 });
    if (((Cursor)localObject).moveToNext()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    localObject = new l();
    ((l)localObject).userData = Integer.valueOf(i);
    paramj.kxh = new ArrayList();
    paramj.kxh.add(localObject);
  }
  
  public final String getName()
  {
    return "SearchChatroomCountTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.l
 * JD-Core Version:    0.7.0.1
 */