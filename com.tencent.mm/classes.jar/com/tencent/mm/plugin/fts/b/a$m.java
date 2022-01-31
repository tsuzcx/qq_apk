package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class a$m
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public a$m(a parama, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    super.a(paramj);
    Object localObject1 = a.a(this.kyt);
    Object localObject2 = this.kwT.kwY;
    Object localObject3 = paramj.kwi.aVy();
    localObject3 = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), localObject3 });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery((String)localObject3, new String[] { localObject2 });
    localObject2 = new HashSet();
    paramj.kxh = new ArrayList();
    while (((Cursor)localObject1).moveToNext())
    {
      localObject3 = new l();
      ((l)localObject3).kwg = ((Cursor)localObject1).getString(0);
      if (((HashSet)localObject2).add(((l)localObject3).kwg)) {
        paramj.kxh.add(localObject3);
      }
    }
    ((Cursor)localObject1).close();
    paramj.aYY = 0;
  }
  
  public final String getName()
  {
    return "SearchChatroomInMemberTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.m
 * JD-Core Version:    0.7.0.1
 */