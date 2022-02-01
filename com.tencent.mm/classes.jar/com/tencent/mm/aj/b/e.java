package com.tencent.mm.aj.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e
  extends MAutoStorage<d>
{
  public static final String[] lqL;
  public static final String[] lqM;
  
  static
  {
    AppMethodBeat.i(2617);
    lqL = new String[] { MAutoStorage.getCreateSQLs(d.lqK, "WxaUpdateableMsg") };
    lqM = new String[0];
    AppMethodBeat.o(2617);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, d.lqK, "WxaUpdateableMsg", lqM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.b.e
 * JD-Core Version:    0.7.0.1
 */