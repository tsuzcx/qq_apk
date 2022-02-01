package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class f
  extends MAutoStorage<e>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(213353);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(e.info, "LuckyMoneyDetailOpenRecord") };
    AppMethodBeat.o(213353);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, e.info, "LuckyMoneyDetailOpenRecord", null);
    this.db = paramISQLiteDatabase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.f
 * JD-Core Version:    0.7.0.1
 */