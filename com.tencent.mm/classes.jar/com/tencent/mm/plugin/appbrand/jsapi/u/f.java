package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.page.z;
import org.json.JSONObject;

public final class f
  extends a<z>
{
  public static final int CTRL_INDEX = 298;
  public static final String NAME = "insertHTMLWebView";
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(131673);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(131673);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.f
 * JD-Core Version:    0.7.0.1
 */