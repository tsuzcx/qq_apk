package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import org.json.JSONObject;

public final class g
  extends b
{
  public static final int CTRL_INDEX = 299;
  public static final String NAME = "removeHTMLWebView";
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(131676);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(131676);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.g
 * JD-Core Version:    0.7.0.1
 */