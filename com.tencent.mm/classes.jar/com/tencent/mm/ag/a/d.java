package com.tencent.mm.ag.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class d
  extends MAutoStorage<c>
{
  public static final String[] iBh;
  public static final String[] iBi;
  
  static
  {
    AppMethodBeat.i(2617);
    iBh = new String[] { MAutoStorage.getCreateSQLs(c.iBg, "WxaUpdateableMsg") };
    iBi = new String[0];
    AppMethodBeat.o(2617);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.iBg, "WxaUpdateableMsg", iBi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ag.a.d
 * JD-Core Version:    0.7.0.1
 */