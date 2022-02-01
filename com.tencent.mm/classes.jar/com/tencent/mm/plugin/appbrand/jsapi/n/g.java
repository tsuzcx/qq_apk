package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.page.aa;
import org.json.JSONObject;

public class g
  extends y<aa>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "initReady";
  
  public String a(aa paramaa, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134879);
    paramaa.Tn("initReady");
    paramaa = e("ok", null);
    AppMethodBeat.o(134879);
    return paramaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.g
 * JD-Core Version:    0.7.0.1
 */