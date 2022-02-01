package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class f
  extends MAutoStorage<e>
{
  public static final String[] iBh;
  public static final String[] iBi;
  
  static
  {
    AppMethodBeat.i(76399);
    iBh = new String[] { MAutoStorage.getCreateSQLs(e.iBg, "DynamicMsgCacheData") };
    iBi = new String[0];
    AppMethodBeat.o(76399);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, e.iBg, "DynamicMsgCacheData", iBi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f
 * JD-Core Version:    0.7.0.1
 */