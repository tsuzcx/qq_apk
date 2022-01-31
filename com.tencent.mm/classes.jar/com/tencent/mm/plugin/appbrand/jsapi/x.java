package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class x
  extends JsApiUploadWeRunData
{
  public static final int CTRL_INDEX = 324;
  public static final String NAME = "addWeRunData";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.d("MicroMsg.JsApiAddWeRunData", "JsApiAddWeRunData!");
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null", null));
      y.e("MicroMsg.JsApiAddWeRunData", "data is null");
      return;
    }
    a(this, paramc, paramInt, paramJSONObject.optInt("step"), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x
 * JD-Core Version:    0.7.0.1
 */