package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class i
  extends MAutoStorage<h>
{
  public static final String[] nVW;
  public static final String[] nVX;
  
  static
  {
    AppMethodBeat.i(76399);
    nVW = new String[] { MAutoStorage.getCreateSQLs(h.nVV, "DynamicMsgCacheData") };
    nVX = new String[0];
    AppMethodBeat.o(76399);
  }
  
  public i(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, h.nVV, "DynamicMsgCacheData", nVX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i
 * JD-Core Version:    0.7.0.1
 */