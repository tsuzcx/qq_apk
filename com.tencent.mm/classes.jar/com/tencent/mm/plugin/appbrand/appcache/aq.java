package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class aq
  extends c<ap>
{
  public static final String[] lqL;
  
  static
  {
    AppMethodBeat.i(90566);
    lqL = new String[] { MAutoStorage.getCreateSQLs(ap.lqK, "PushWxaPkgDecryptKeyTable") };
    AppMethodBeat.o(90566);
  }
  
  public aq(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ap.lqK, "PushWxaPkgDecryptKeyTable", ap.INDEX_CREATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aq
 * JD-Core Version:    0.7.0.1
 */