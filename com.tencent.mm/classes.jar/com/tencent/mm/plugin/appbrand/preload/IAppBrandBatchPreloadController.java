package com.tencent.mm.plugin.appbrand.preload;

import com.tencent.mm.kernel.c.a;
import org.json.JSONObject;

public abstract interface IAppBrandBatchPreloadController
  extends a
{
  public abstract String preload(JSONObject paramJSONObject, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController
 * JD-Core Version:    0.7.0.1
 */