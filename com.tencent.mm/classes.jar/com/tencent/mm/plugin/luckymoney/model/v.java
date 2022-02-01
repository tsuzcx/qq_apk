package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class v
  extends MAutoStorage<u>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(65224);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(u.info, "LuckyMoneyEnvelopeResource") };
    AppMethodBeat.o(65224);
  }
  
  public v(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, u.info, "LuckyMoneyEnvelopeResource", null);
    this.db = paramISQLiteDatabase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.v
 * JD-Core Version:    0.7.0.1
 */