package com.tencent.mm.plugin.fav.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  private SQLiteStatement Aeg;
  
  public final void a(int paramInt1, long paramLong1, String paramString1, long paramLong2, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(101560);
    paramString2 = d.aEg(paramString2);
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(101560);
      return;
    }
    boolean bool = this.HqR.inTransaction();
    if (!bool) {
      this.HqR.beginTransaction();
    }
    try
    {
      fxq().bindString(1, paramString2);
      fxq().execute();
      this.Aeg.bindLong(1, 196608L);
      this.Aeg.bindLong(2, paramInt1);
      this.Aeg.bindLong(3, paramLong1);
      this.Aeg.bindString(4, paramString1);
      this.Aeg.bindLong(5, paramLong2);
      this.Aeg.bindLong(6, paramInt2);
      this.Aeg.execute();
      if (!bool) {
        this.HqR.commit();
      }
      AppMethodBeat.o(101560);
      return;
    }
    catch (SQLiteException paramString2)
    {
      Log.e("MicroMsg.FTS.FTS5FavoriteStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(196608), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
      paramString1 = fxp().simpleQueryForString();
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        Log.e("MicroMsg.FTS.FTS5FavoriteStorage", ">> ".concat(String.valueOf(paramString1)));
      }
      AppMethodBeat.o(101560);
      throw paramString2;
    }
  }
  
  public final void aXv()
  {
    AppMethodBeat.i(101557);
    if (aXw()) {
      this.HqR.aG(-106L, 4L);
    }
    String str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, fav_type) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[] { fxn() });
    this.Aeg = this.HqR.compileStatement(str);
    AppMethodBeat.o(101557);
  }
  
  public final boolean aXw()
  {
    AppMethodBeat.i(101558);
    if (!iV(-106, 4))
    {
      AppMethodBeat.o(101558);
      return true;
    }
    AppMethodBeat.o(101558);
    return false;
  }
  
  public final String dRh()
  {
    AppMethodBeat.i(101559);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, fav_type INT DEFAULT 0);", new Object[] { fxn() });
    AppMethodBeat.o(101559);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.a.a
 * JD-Core Version:    0.7.0.1
 */