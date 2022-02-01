package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.page.z;
import org.json.JSONObject;

public class g
  extends y<z>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "initReady";
  
  public String a(z paramz, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134879);
    paramz.TY("initReady");
    paramz = e("ok", null);
    AppMethodBeat.o(134879);
    return paramz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.g
 * JD-Core Version:    0.7.0.1
 */