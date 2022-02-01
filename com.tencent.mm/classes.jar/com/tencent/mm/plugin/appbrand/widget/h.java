package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class h
  extends MAutoStorage<g>
{
  public static final String[] lqL;
  public static final String[] lqM;
  
  static
  {
    AppMethodBeat.i(76399);
    lqL = new String[] { MAutoStorage.getCreateSQLs(g.lqK, "DynamicMsgCacheData") };
    lqM = new String[0];
    AppMethodBeat.o(76399);
  }
  
  public h(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, g.lqK, "DynamicMsgCacheData", lqM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.h
 * JD-Core Version:    0.7.0.1
 */