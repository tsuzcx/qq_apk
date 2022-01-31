package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import org.json.JSONObject;

public final class i
  extends c
{
  public static final int CTRL_INDEX = 83;
  public static final String NAME = "updateCanvas";
  
  protected final boolean aii()
  {
    return true;
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("canvasId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.i
 * JD-Core Version:    0.7.0.1
 */