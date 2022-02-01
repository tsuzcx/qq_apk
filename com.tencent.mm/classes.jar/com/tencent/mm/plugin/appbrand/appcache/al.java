package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class al
  extends MAutoStorage<an>
{
  public static final String[] nVW;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(44319);
    nVW = new String[] { MAutoStorage.getCreateSQLs(an.DB_INFO, "PluginCodeUsageLRURecord") };
    AppMethodBeat.o(44319);
  }
  
  public al(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, an.DB_INFO, "PluginCodeUsageLRURecord", an.INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final void bB(String paramString, int paramInt)
  {
    AppMethodBeat.i(44318);
    an localan = new an();
    localan.field_appId = paramString;
    localan.field_version = paramInt;
    super.delete(localan, an.qDJ);
    AppMethodBeat.o(44318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.al
 * JD-Core Version:    0.7.0.1
 */