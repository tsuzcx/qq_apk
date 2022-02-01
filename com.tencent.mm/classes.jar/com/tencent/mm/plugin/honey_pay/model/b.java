package com.tencent.mm.plugin.honey_pay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  private static final String[] jTH;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(64646);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "HoneyPayMsgRecord") };
    jTH = new String[] { "*", "rowid" };
    AppMethodBeat.o(64646);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "HoneyPayMsgRecord", null);
    this.db = paramISQLiteDatabase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.b
 * JD-Core Version:    0.7.0.1
 */