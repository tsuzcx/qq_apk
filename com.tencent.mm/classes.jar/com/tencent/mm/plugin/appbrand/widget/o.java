package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class o
  extends j<n>
{
  public static final String[] fkl;
  public static final String[] fkm;
  
  static
  {
    AppMethodBeat.i(70664);
    fkl = new String[] { j.getCreateSQLs(n.fkk, "WxaWidgetInfo") };
    fkm = new String[0];
    AppMethodBeat.o(70664);
  }
  
  public o(e parame)
  {
    super(parame, n.fkk, "WxaWidgetInfo", fkm);
  }
  
  public final n FC(String paramString)
  {
    AppMethodBeat.i(70663);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70663);
      return null;
    }
    n localn = new n();
    localn.field_appId = paramString;
    localn.field_appIdHash = paramString.hashCode();
    if (!get(localn, new String[] { "appIdHash" }))
    {
      AppMethodBeat.o(70663);
      return null;
    }
    AppMethodBeat.o(70663);
    return localn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.o
 * JD-Core Version:    0.7.0.1
 */