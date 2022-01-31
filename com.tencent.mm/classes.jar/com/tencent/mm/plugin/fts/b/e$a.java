package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.h;
import java.util.LinkedList;

final class e$a
  extends com.tencent.mm.plugin.fts.a.a.a
{
  int kzx;
  int kzy;
  
  private e$a(e parame) {}
  
  public final String afJ()
  {
    return String.format("{topHitsUpdateCount: %d deleteExpiredCount: %d}", new Object[] { Integer.valueOf(this.kzy), Integer.valueOf(this.kzx) });
  }
  
  public final boolean execute()
  {
    this.kzy = this.kzz.kzv.aVT();
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.fts.c.e locale = this.kzz.kzv;
    Object localObject = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", new Object[] { locale.aVs() });
    localObject = locale.kuE.rawQuery((String)localObject, new String[] { String.valueOf(l - 5184000000L) });
    LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext()) {
      localLinkedList.add(Long.valueOf(((Cursor)localObject).getLong(0)));
    }
    ((Cursor)localObject).close();
    locale.by(localLinkedList);
    this.kzx = localLinkedList.size();
    return true;
  }
  
  public final String getName()
  {
    return "BuildTopHitsIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e.a
 * JD-Core Version:    0.7.0.1
 */