package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class h
  extends b<e>
{
  public static final int CTRL_INDEX = 68;
  public static final String NAME = "removeCanvas";
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("canvasId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.h
 * JD-Core Version:    0.7.0.1
 */