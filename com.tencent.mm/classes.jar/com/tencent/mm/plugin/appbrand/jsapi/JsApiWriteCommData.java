package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import org.json.JSONObject;

public final class JsApiWriteCommData
  extends a
{
  public static final int CTRL_INDEX = 445;
  public static final String NAME = "writeCommData";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppBrandMainProcessService.a(new JsApiWriteCommData.WriteCommDataTask(this, paramc, paramInt, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData
 * JD-Core Version:    0.7.0.1
 */