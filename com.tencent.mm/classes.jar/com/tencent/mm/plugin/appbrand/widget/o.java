package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;

public final class o
  extends j<n>
{
  public static final String[] gLs;
  public static final String[] gLt;
  
  static
  {
    AppMethodBeat.i(76413);
    gLs = new String[] { j.getCreateSQLs(n.gLr, "WxaWidgetInfo") };
    gLt = new String[0];
    AppMethodBeat.o(76413);
  }
  
  public o(e parame)
  {
    super(parame, n.gLr, "WxaWidgetInfo", gLt);
  }
  
  public final n NA(String paramString)
  {
    AppMethodBeat.i(76412);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(76412);
      return null;
    }
    n localn = new n();
    localn.field_appId = paramString;
    localn.field_appIdHash = paramString.hashCode();
    if (!get(localn, new String[] { "appIdHash" }))
    {
      AppMethodBeat.o(76412);
      return null;
    }
    AppMethodBeat.o(76412);
    return localn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.o
 * JD-Core Version:    0.7.0.1
 */