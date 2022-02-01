package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import org.json.JSONObject;

public class h
  extends a
{
  public static final int CTRL_INDEX = 251;
  public static final String NAME = "navigateToMiniProgram";
  
  protected c.c b(g paramg, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(245816);
    paramg = new h.1(this, paramg, paramInt);
    AppMethodBeat.o(245816);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h
 * JD-Core Version:    0.7.0.1
 */