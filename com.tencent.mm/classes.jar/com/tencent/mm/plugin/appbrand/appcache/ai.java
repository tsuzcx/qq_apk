package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ai
  extends MAutoStorage<ah>
{
  public static final String[] nVW;
  
  static
  {
    AppMethodBeat.i(44314);
    nVW = new String[] { MAutoStorage.getCreateSQLs(ah.DB_INFO, "PkgUpdateStats") };
    AppMethodBeat.o(44314);
  }
  
  public ai(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ah.DB_INFO, "PkgUpdateStats", ah.INDEX_CREATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ai
 * JD-Core Version:    0.7.0.1
 */