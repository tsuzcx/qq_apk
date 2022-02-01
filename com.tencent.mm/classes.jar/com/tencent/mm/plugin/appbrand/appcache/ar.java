package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class ar
  extends c<aq>
{
  public static final String[] nVW;
  
  static
  {
    AppMethodBeat.i(90566);
    nVW = new String[] { MAutoStorage.getCreateSQLs(aq.nVV, "PushWxaPkgDecryptKeyTable") };
    AppMethodBeat.o(90566);
  }
  
  public ar(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aq.nVV, "PushWxaPkgDecryptKeyTable", aq.INDEX_CREATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ar
 * JD-Core Version:    0.7.0.1
 */