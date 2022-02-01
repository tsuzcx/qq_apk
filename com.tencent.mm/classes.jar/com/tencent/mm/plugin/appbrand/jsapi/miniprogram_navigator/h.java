package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import org.json.JSONObject;

public class h
  extends a
{
  public static final int CTRL_INDEX = 251;
  public static final String NAME = "navigateToMiniProgram";
  
  protected c.c b(d paramd, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(229904);
    paramd = new h.1(this, paramd, paramInt);
    AppMethodBeat.o(229904);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h
 * JD-Core Version:    0.7.0.1
 */