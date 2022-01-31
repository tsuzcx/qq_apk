package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.ArrayList;
import java.util.List;

public final class a$p
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public a$p(a parama, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    long l = Long.valueOf(this.kwT.bVk).longValue();
    Object localObject1 = a.a(this.kyt);
    Object localObject2 = String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), Long.valueOf(l), Integer.valueOf(131072) });
    localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery((String)localObject2, null);
    paramj.kxh = new ArrayList();
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = new l();
      ((l)localObject2).kwg = ((Cursor)localObject1).getString(0);
      paramj.kxh.add(localObject2);
    }
    ((Cursor)localObject1).close();
  }
  
  public final String getName()
  {
    return "SearchContactSmallerTimestampTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.p
 * JD-Core Version:    0.7.0.1
 */