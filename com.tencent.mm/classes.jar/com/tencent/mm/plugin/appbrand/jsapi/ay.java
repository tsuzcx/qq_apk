package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class ay
  extends a
{
  public static final int CTRL_INDEX = 65;
  public static final String NAME = "systemLog";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("message");
    y.i("AppBrandLog." + paramc.getAppId(), paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ay
 * JD-Core Version:    0.7.0.1
 */