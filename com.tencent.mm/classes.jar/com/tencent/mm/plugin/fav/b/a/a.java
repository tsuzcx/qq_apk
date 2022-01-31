package com.tencent.mm.plugin.fav.b.a;

import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  private SQLiteStatement kak;
  
  protected final boolean BA()
  {
    return !cT(-106, 4);
  }
  
  protected final void Bz()
  {
    if (BA()) {
      this.kuE.A(-106L, 4L);
    }
    String str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, fav_type) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[] { aVs() });
    this.kak = this.kuE.compileStatement(str);
  }
  
  public final void a(int paramInt1, long paramLong1, String paramString1, long paramLong2, String paramString2, int paramInt2)
  {
    paramString2 = d.DQ(paramString2);
    if (bk.bl(paramString2)) {}
    for (;;)
    {
      return;
      boolean bool = this.kuE.inTransaction();
      if (!bool) {
        this.kuE.beginTransaction();
      }
      try
      {
        this.kuF.bindString(1, paramString2);
        this.kuF.execute();
        this.kak.bindLong(1, 196608L);
        this.kak.bindLong(2, paramInt1);
        this.kak.bindLong(3, paramLong1);
        this.kak.bindString(4, paramString1);
        this.kak.bindLong(5, paramLong2);
        this.kak.bindLong(6, paramInt2);
        this.kak.execute();
        if (bool) {
          continue;
        }
        this.kuE.commit();
        return;
      }
      catch (SQLiteException paramString2)
      {
        y.e("MicroMsg.FTS.FTS5FavoriteStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(196608), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
        paramString1 = this.kuM.simpleQueryForString();
        if ((paramString1 != null) && (paramString1.length() > 0)) {
          y.e("MicroMsg.FTS.FTS5FavoriteStorage", ">> " + paramString1);
        }
        throw paramString2;
      }
    }
  }
  
  protected final String aQT()
  {
    return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, fav_type INT DEFAULT 0);", new Object[] { aVs() });
  }
  
  public final String getName()
  {
    return "FTS5FavoriteStorage";
  }
  
  public final int getPriority()
  {
    return 256;
  }
  
  protected final String getTableName()
  {
    return "Favorite";
  }
  
  public final int getType()
  {
    return 256;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.a
 * JD-Core Version:    0.7.0.1
 */