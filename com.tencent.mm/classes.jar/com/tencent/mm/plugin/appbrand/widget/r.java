package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class r
  extends MAutoStorage<q>
{
  public static final String[] lqL;
  public static final String[] lqM;
  
  static
  {
    AppMethodBeat.i(76413);
    lqL = new String[] { MAutoStorage.getCreateSQLs(q.lqK, "WxaWidgetInfo") };
    lqM = new String[0];
    AppMethodBeat.o(76413);
  }
  
  public r(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, q.lqK, "WxaWidgetInfo", lqM);
  }
  
  public final q anA(String paramString)
  {
    AppMethodBeat.i(76412);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(76412);
      return null;
    }
    q localq = new q();
    localq.field_appId = paramString;
    localq.field_appIdHash = paramString.hashCode();
    if (!get(localq, new String[] { "appIdHash" }))
    {
      AppMethodBeat.o(76412);
      return null;
    }
    AppMethodBeat.o(76412);
    return localq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.r
 * JD-Core Version:    0.7.0.1
 */