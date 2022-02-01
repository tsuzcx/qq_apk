package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ak
  extends MAutoStorage<am>
{
  public static final String[] lqL;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(44319);
    lqL = new String[] { MAutoStorage.getCreateSQLs(am.nFK, "PluginCodeUsageLRURecord") };
    AppMethodBeat.o(44319);
  }
  
  public ak(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, am.nFK, "PluginCodeUsageLRURecord", am.INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final void bk(String paramString, int paramInt)
  {
    AppMethodBeat.i(44318);
    am localam = new am();
    localam.field_appId = paramString;
    localam.field_version = paramInt;
    super.delete(localam, am.nDP);
    AppMethodBeat.o(44318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ak
 * JD-Core Version:    0.7.0.1
 */