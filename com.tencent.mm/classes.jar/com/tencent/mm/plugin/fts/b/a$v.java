package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class a$v
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private long kyR;
  private int kyS = 0;
  
  public a$v(a parama, long paramLong)
  {
    this.kyR = paramLong;
  }
  
  public final String afJ()
  {
    return String.format("{mLabelId: %d mContactCount: %d}", new Object[] { Long.valueOf(this.kyR), Integer.valueOf(this.kyS) });
  }
  
  public final boolean execute()
  {
    Object localObject1 = new ArrayList(32);
    Object localObject2 = a.a(this.kyt);
    long l = this.kyR;
    localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).kuE.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[] { Long.toString(l) });
    while (((Cursor)localObject2).moveToNext()) {
      ((ArrayList)localObject1).add(((Cursor)localObject2).getString(0));
    }
    ((Cursor)localObject2).close();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!a.b(this.kyt).containsKey(localObject2))
      {
        List localList = a.a(this.kyt).c(c.kuW, (String)localObject2);
        a.b(this.kyt).put(localObject2, localList);
      }
    }
    return true;
  }
  
  public final String getName()
  {
    return "UpdateLabelTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.v
 * JD-Core Version:    0.7.0.1
 */