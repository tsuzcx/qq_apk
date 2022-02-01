package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class u
  extends MAutoStorage<t>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(65224);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(t.info, "LuckyMoneyEnvelopeResource") };
    AppMethodBeat.o(65224);
  }
  
  public u(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, t.info, "LuckyMoneyEnvelopeResource", null);
    this.db = paramISQLiteDatabase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.u
 * JD-Core Version:    0.7.0.1
 */