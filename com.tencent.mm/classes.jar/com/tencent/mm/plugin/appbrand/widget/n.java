package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class n
  extends MAutoStorage<m>
{
  public static final String[] iBh;
  public static final String[] iBi;
  
  static
  {
    AppMethodBeat.i(76413);
    iBh = new String[] { MAutoStorage.getCreateSQLs(m.iBg, "WxaWidgetInfo") };
    iBi = new String[0];
    AppMethodBeat.o(76413);
  }
  
  public n(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, m.iBg, "WxaWidgetInfo", iBi);
  }
  
  public final m afV(String paramString)
  {
    AppMethodBeat.i(76412);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(76412);
      return null;
    }
    m localm = new m();
    localm.field_appId = paramString;
    localm.field_appIdHash = paramString.hashCode();
    if (!get(localm, new String[] { "appIdHash" }))
    {
      AppMethodBeat.o(76412);
      return null;
    }
    AppMethodBeat.o(76412);
    return localm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.n
 * JD-Core Version:    0.7.0.1
 */