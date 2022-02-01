package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class ap
  extends c<ao>
{
  public static final String[] iBh;
  
  static
  {
    AppMethodBeat.i(90566);
    iBh = new String[] { MAutoStorage.getCreateSQLs(ao.iBg, "PushWxaPkgDecryptKeyTable") };
    AppMethodBeat.o(90566);
  }
  
  public ap(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ao.iBg, "PushWxaPkgDecryptKeyTable", ao.INDEX_CREATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap
 * JD-Core Version:    0.7.0.1
 */