package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class u
  extends MAutoStorage<t>
{
  public static final String[] nVW;
  public static final String[] nVX;
  
  static
  {
    AppMethodBeat.i(76413);
    nVW = new String[] { MAutoStorage.getCreateSQLs(t.nVV, "WxaWidgetInfo") };
    nVX = new String[0];
    AppMethodBeat.o(76413);
  }
  
  public u(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, t.nVV, "WxaWidgetInfo", nVX);
  }
  
  public final t agX(String paramString)
  {
    AppMethodBeat.i(76412);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(76412);
      return null;
    }
    t localt = new t();
    localt.field_appId = paramString;
    localt.field_appIdHash = paramString.hashCode();
    if (!get(localt, new String[] { "appIdHash" }))
    {
      AppMethodBeat.o(76412);
      return null;
    }
    AppMethodBeat.o(76412);
    return localt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.u
 * JD-Core Version:    0.7.0.1
 */