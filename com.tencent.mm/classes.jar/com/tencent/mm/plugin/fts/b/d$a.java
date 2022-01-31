package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d$a
  extends a
{
  public String mVj;
  
  public d$a(d paramd) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(136768);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.mVj);
    ((StringBuffer)localObject).append("​");
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.fts.a.d.aR(this.mVj, false));
    ((StringBuffer)localObject).append("​");
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.fts.a.d.aR(this.mVj, true));
    com.tencent.mm.plugin.fts.c.d locald = this.mVk.mVi;
    String str = this.mVj;
    localObject = ((StringBuffer)localObject).toString();
    Cursor localCursor = locald.mQr.rawQuery(String.format("SELECT docid FROM %s WHERE history = ?", new Object[] { "FTS5MetaSOSHistory" }), new String[] { str });
    long l = -1L;
    if (localCursor.moveToNext()) {
      l = localCursor.getLong(0);
    }
    localCursor.close();
    if (l >= 0L)
    {
      locald.mVJ.bindLong(1, System.currentTimeMillis());
      locald.mVJ.bindLong(2, l);
      locald.mVJ.execute();
    }
    for (;;)
    {
      AppMethodBeat.o(136768);
      return true;
      if (!locald.mQr.inTransaction()) {
        locald.mQr.beginTransaction();
      }
      locald.mQs.bindString(1, (String)localObject);
      locald.mQs.execute();
      locald.mQt.bindString(1, str);
      locald.mQt.bindLong(2, System.currentTimeMillis());
      locald.mQt.execute();
      if (locald.mQr.inTransaction()) {
        locald.mQr.commit();
      }
    }
  }
  
  public final String getName()
  {
    return "AddSOSHistoryTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.d.a
 * JD-Core Version:    0.7.0.1
 */