package com.tencent.mm.message.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e
  extends MAutoStorage<d>
{
  public static final String[] nVW;
  public static final String[] nVX;
  
  static
  {
    AppMethodBeat.i(2617);
    nVW = new String[] { MAutoStorage.getCreateSQLs(d.nVV, "WxaUpdateableMsg") };
    nVX = new String[0];
    AppMethodBeat.o(2617);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, d.nVV, "WxaUpdateableMsg", nVX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.message.c.e
 * JD-Core Version:    0.7.0.1
 */