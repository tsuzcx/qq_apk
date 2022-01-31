package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a$o
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public a$o(a parama, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    Object localObject2 = bk.G(this.kwT.bVk.split(","));
    Object localObject1 = a.a(this.kyt);
    Object localObject3 = new StringBuffer();
    ((StringBuffer)localObject3).append("member IN (");
    int i = 0;
    while (i < ((List)localObject2).size())
    {
      ((StringBuffer)localObject3).append("'");
      ((StringBuffer)localObject3).append((String)((List)localObject2).get(i));
      ((StringBuffer)localObject3).append("'");
      if (i != ((List)localObject2).size() - 1) {
        ((StringBuffer)localObject3).append(",");
      }
      i += 1;
    }
    ((StringBuffer)localObject3).append(")");
    localObject2 = String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((StringBuffer)localObject3).toString() });
    localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery((String)localObject2, null);
    localObject2 = new HashMap();
    if (((Cursor)localObject3).moveToNext())
    {
      String str = ((Cursor)localObject3).getString(0);
      if (((HashMap)localObject2).containsKey(str)) {}
      for (localObject1 = (List)((HashMap)localObject2).get(str);; localObject1 = new ArrayList())
      {
        l locall = new l();
        locall.kwg = ((Cursor)localObject3).getString(1);
        locall.kxk = ((Cursor)localObject3).getLong(2);
        ((List)localObject1).add(locall);
        ((HashMap)localObject2).put(str, localObject1);
        break;
      }
    }
    ((Cursor)localObject3).close();
    paramj.kxh = new ArrayList();
    localObject1 = new l();
    ((l)localObject1).userData = localObject2;
    paramj.kxh.add(localObject1);
  }
  
  public final String getName()
  {
    return "SearchCommonChatroomTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.o
 * JD-Core Version:    0.7.0.1
 */