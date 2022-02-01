package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;

public final class o
  extends j<n>
{
  public static final String[] hEf;
  public static final String[] hEg;
  
  static
  {
    AppMethodBeat.i(76413);
    hEf = new String[] { j.getCreateSQLs(n.hEe, "WxaWidgetInfo") };
    hEg = new String[0];
    AppMethodBeat.o(76413);
  }
  
  public o(e parame)
  {
    super(parame, n.hEe, "WxaWidgetInfo", hEg);
  }
  
  public final n Vo(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.o
 * JD-Core Version:    0.7.0.1
 */