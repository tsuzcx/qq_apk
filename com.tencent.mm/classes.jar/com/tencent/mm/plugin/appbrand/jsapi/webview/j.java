package com.tencent.mm.plugin.appbrand.jsapi.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.ah;
import org.json.JSONObject;

public final class j
  extends c<ah>
{
  public static final int CTRL_INDEX = 299;
  public static final String NAME = "removeHTMLWebView";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47018);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(47018);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.j
 * JD-Core Version:    0.7.0.1
 */