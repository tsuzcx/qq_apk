package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import org.json.JSONObject;

public class e
  extends a<h>
{
  public static final int CTRL_INDEX = 252;
  public static final String NAME = "navigateBackMiniProgram";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(140839);
    paramh.A(new e.1(this, paramh, paramJSONObject.optJSONObject("extraData"), paramJSONObject.optJSONObject("privateExtraData"), paramInt));
    AppMethodBeat.o(140839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e
 * JD-Core Version:    0.7.0.1
 */