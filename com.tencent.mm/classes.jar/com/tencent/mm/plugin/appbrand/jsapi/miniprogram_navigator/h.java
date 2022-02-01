package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.g;
import org.json.JSONObject;

public class h
  extends a
{
  public static final int CTRL_INDEX = 251;
  public static final String NAME = "navigateToMiniProgram";
  
  private static double F(double paramDouble)
  {
    AppMethodBeat.i(326205);
    if (paramDouble == -2.0D)
    {
      AppMethodBeat.o(326205);
      return paramDouble;
    }
    double d = paramDouble;
    if (paramDouble < 0.0D) {
      d = 0.0D;
    }
    paramDouble = i.mn();
    AppMethodBeat.o(326205);
    return d * paramDouble;
  }
  
  protected c.c a(g paramg, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(326209);
    paramg = new h.1(this, paramg, paramInt);
    AppMethodBeat.o(326209);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h
 * JD-Core Version:    0.7.0.1
 */