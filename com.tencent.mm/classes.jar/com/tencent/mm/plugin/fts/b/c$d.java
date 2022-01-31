package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.wcdb.database.SQLiteStatement;

final class c$d
  extends a
{
  private String drJ;
  
  public c$d(c paramc, String paramString)
  {
    this.drJ = paramString;
  }
  
  public final String afJ()
  {
    return String.format("{conversation: %s}", new Object[] { this.drJ });
  }
  
  public final boolean execute()
  {
    com.tencent.mm.plugin.fts.c.c localc = this.kze.kyW;
    String str = this.drJ;
    localc.kzQ.bindLong(1, -1L);
    localc.kzQ.bindString(2, str);
    localc.kzQ.bindLong(3, -1L);
    localc.kzQ.execute();
    return true;
  }
  
  public final String getName()
  {
    return "DeleteTalkerTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.d
 * JD-Core Version:    0.7.0.1
 */