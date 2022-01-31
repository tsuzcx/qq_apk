package com.tencent.mm.plugin.appbrand.jsapi.container;

import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  public static final int CTRL_INDEX = 512;
  public static final String NAME = "removePositioningContainer";
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("containerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.b
 * JD-Core Version:    0.7.0.1
 */