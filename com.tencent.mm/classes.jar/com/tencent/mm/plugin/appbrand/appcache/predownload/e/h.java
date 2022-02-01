package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class h
  extends MAutoStorage<g>
{
  public static final String[] iBh;
  
  static
  {
    AppMethodBeat.i(44445);
    iBh = new String[] { MAutoStorage.getCreateSQLs(g.iBg, "WxaAttrVersionServerNotifyRecord") };
    AppMethodBeat.o(44445);
  }
  
  public h(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, g.iBg, "WxaAttrVersionServerNotifyRecord", g.INDEX_CREATE);
  }
  
  public final g VG(String paramString)
  {
    AppMethodBeat.i(226381);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(226381);
      return null;
    }
    g localg = new g();
    localg.field_username = paramString;
    if (get(localg, new String[0]))
    {
      AppMethodBeat.o(226381);
      return localg;
    }
    AppMethodBeat.o(226381);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.e.h
 * JD-Core Version:    0.7.0.1
 */