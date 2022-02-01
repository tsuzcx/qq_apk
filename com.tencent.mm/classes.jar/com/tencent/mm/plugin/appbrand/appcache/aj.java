package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class aj
  extends MAutoStorage<al>
{
  public static final String[] iBh;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(44319);
    iBh = new String[] { MAutoStorage.getCreateSQLs(al.kLR, "PluginCodeUsageLRURecord") };
    AppMethodBeat.o(44319);
  }
  
  public aj(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, al.kLR, "PluginCodeUsageLRURecord", al.INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final void aS(String paramString, int paramInt)
  {
    AppMethodBeat.i(44318);
    al localal = new al();
    localal.field_appId = paramString;
    localal.field_version = paramInt;
    super.delete(localal, al.kJX);
    AppMethodBeat.o(44318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj
 * JD-Core Version:    0.7.0.1
 */