package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ai
  extends MAutoStorage<ah>
{
  public static final String[] iBh;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(44317);
    iBh = new String[] { MAutoStorage.getCreateSQLs(ah.kLR, "PkgUsageLRURecord") };
    AppMethodBeat.o(44317);
  }
  
  public ai(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ah.kLR, "PkgUsageLRURecord", ah.INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final void aS(String paramString, int paramInt)
  {
    AppMethodBeat.i(44316);
    ah localah = new ah();
    localah.field_appId = paramString;
    localah.field_type = paramInt;
    super.delete(localah, ah.kJX);
    AppMethodBeat.o(44316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ai
 * JD-Core Version:    0.7.0.1
 */