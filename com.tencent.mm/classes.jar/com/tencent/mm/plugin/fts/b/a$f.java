package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class a$f
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int kyI = 0;
  private int kyJ = 0;
  
  private a$f(a parama) {}
  
  public final String afJ()
  {
    return String.format("{users: %d labels: %d}", new Object[] { Integer.valueOf(this.kyI), Integer.valueOf(this.kyJ) });
  }
  
  public final boolean execute()
  {
    Cursor localCursor = a.a(this.kyt).kuE.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(0);
      long l = localCursor.getLong(1);
      List localList = (List)a.g(this.kyt).get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(16);
        a.g(this.kyt).put(str, localObject);
        this.kyI += 1;
      }
      ((List)localObject).add(Long.valueOf(l));
      this.kyJ += 1;
    }
    localCursor.close();
    return true;
  }
  
  public final String getName()
  {
    return "LoadLabelCacheTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.f
 * JD-Core Version:    0.7.0.1
 */