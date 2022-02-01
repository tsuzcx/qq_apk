package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ah
  extends MAutoStorage<ag>
{
  public static final String[] lqL;
  
  static
  {
    AppMethodBeat.i(44314);
    lqL = new String[] { MAutoStorage.getCreateSQLs(ag.nFK, "PkgUpdateStats") };
    AppMethodBeat.o(44314);
  }
  
  public ah(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ag.nFK, "PkgUpdateStats", ag.INDEX_CREATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ah
 * JD-Core Version:    0.7.0.1
 */