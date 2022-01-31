package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d$a
  extends a
{
  public String kzt;
  
  public d$a(d paramd) {}
  
  public final boolean execute()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.kzt);
    ((StringBuffer)localObject).append("​");
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.fts.a.d.aD(this.kzt, false));
    ((StringBuffer)localObject).append("​");
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.fts.a.d.aD(this.kzt, true));
    com.tencent.mm.plugin.fts.c.d locald = this.kzu.kzs;
    String str = this.kzt;
    localObject = ((StringBuffer)localObject).toString();
    Cursor localCursor = locald.kuE.rawQuery(String.format("SELECT docid FROM %s WHERE history = ?", new Object[] { "FTS5MetaSOSHistory" }), new String[] { str });
    long l = -1L;
    if (localCursor.moveToNext()) {
      l = localCursor.getLong(0);
    }
    localCursor.close();
    if (l >= 0L)
    {
      locald.kzS.bindLong(1, System.currentTimeMillis());
      locald.kzS.bindLong(2, l);
      locald.kzS.execute();
    }
    do
    {
      return true;
      if (!locald.kuE.inTransaction()) {
        locald.kuE.beginTransaction();
      }
      locald.kuF.bindString(1, (String)localObject);
      locald.kuF.execute();
      locald.kuG.bindString(1, str);
      locald.kuG.bindLong(2, System.currentTimeMillis());
      locald.kuG.execute();
    } while (!locald.kuE.inTransaction());
    locald.kuE.commit();
    return true;
  }
  
  public final String getName()
  {
    return "AddSOSHistoryTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.d.a
 * JD-Core Version:    0.7.0.1
 */