package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ag
  extends MAutoStorage<af>
{
  public static final String[] iBh;
  
  static
  {
    AppMethodBeat.i(44314);
    iBh = new String[] { MAutoStorage.getCreateSQLs(af.kLR, "PkgUpdateStats") };
    AppMethodBeat.o(44314);
  }
  
  public ag(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, af.kLR, "PkgUpdateStats", af.INDEX_CREATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ag
 * JD-Core Version:    0.7.0.1
 */