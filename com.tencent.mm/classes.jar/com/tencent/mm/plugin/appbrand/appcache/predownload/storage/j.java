package com.tencent.mm.plugin.appbrand.appcache.predownload.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class j
  extends MAutoStorage<i>
{
  public static final String[] nVW;
  
  static
  {
    AppMethodBeat.i(44445);
    nVW = new String[] { MAutoStorage.getCreateSQLs(i.nVV, "WxaAttrVersionServerNotifyRecord") };
    AppMethodBeat.o(44445);
  }
  
  public j(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, i.nVV, "WxaAttrVersionServerNotifyRecord", i.INDEX_CREATE);
  }
  
  public final i VM(String paramString)
  {
    AppMethodBeat.i(320430);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(320430);
      return null;
    }
    i locali = new i();
    locali.field_username = paramString;
    if (get(locali, new String[0]))
    {
      AppMethodBeat.o(320430);
      return locali;
    }
    AppMethodBeat.o(320430);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.storage.j
 * JD-Core Version:    0.7.0.1
 */