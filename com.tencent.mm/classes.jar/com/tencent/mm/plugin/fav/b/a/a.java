package com.tencent.mm.plugin.fav.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  private SQLiteStatement muG;
  
  public final void Pn()
  {
    AppMethodBeat.i(5297);
    if (Po()) {
      this.mQr.M(-106L, 4L);
    }
    String str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, fav_type) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[] { bBR() });
    this.muG = this.mQr.compileStatement(str);
    AppMethodBeat.o(5297);
  }
  
  public final boolean Po()
  {
    AppMethodBeat.i(5298);
    if (!er(-106, 4))
    {
      AppMethodBeat.o(5298);
      return true;
    }
    AppMethodBeat.o(5298);
    return false;
  }
  
  public final void a(int paramInt1, long paramLong1, String paramString1, long paramLong2, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(5300);
    paramString2 = d.OZ(paramString2);
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(5300);
      return;
    }
    boolean bool = this.mQr.inTransaction();
    if (!bool) {
      this.mQr.beginTransaction();
    }
    try
    {
      this.mQs.bindString(1, paramString2);
      this.mQs.execute();
      this.muG.bindLong(1, 196608L);
      this.muG.bindLong(2, paramInt1);
      this.muG.bindLong(3, paramLong1);
      this.muG.bindString(4, paramString1);
      this.muG.bindLong(5, paramLong2);
      this.muG.bindLong(6, paramInt2);
      this.muG.execute();
      if (!bool) {
        this.mQr.commit();
      }
      AppMethodBeat.o(5300);
      return;
    }
    catch (SQLiteException paramString2)
    {
      ab.e("MicroMsg.FTS.FTS5FavoriteStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(196608), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
      paramString1 = this.mQz.simpleQueryForString();
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        ab.e("MicroMsg.FTS.FTS5FavoriteStorage", ">> ".concat(String.valueOf(paramString1)));
      }
      AppMethodBeat.o(5300);
      throw paramString2;
    }
  }
  
  public final String bxi()
  {
    AppMethodBeat.i(5299);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, fav_type INT DEFAULT 0);", new Object[] { bBR() });
    AppMethodBeat.o(5299);
    return str;
  }
  
  public final String getName()
  {
    return "FTS5FavoriteStorage";
  }
  
  public final int getPriority()
  {
    return 256;
  }
  
  public final String getTableName()
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