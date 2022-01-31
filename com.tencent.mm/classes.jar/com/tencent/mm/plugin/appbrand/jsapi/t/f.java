package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.page.s;
import org.json.JSONObject;

public final class f
  extends a<s>
{
  public static final int CTRL_INDEX = 298;
  public static final String NAME = "insertHTMLWebView";
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("htmlId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.f
 * JD-Core Version:    0.7.0.1
 */