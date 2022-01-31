package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

public final class JsApiInstallDownloadTask
  extends a<c>
{
  public static final int CTRL_INDEX = 442;
  public static final String NAME = "installDownloadTask";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppBrandMainProcessService.a(new JsApiInstallDownloadTask.InstallDownloadTask(this, paramc, paramInt, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask
 * JD-Core Version:    0.7.0.1
 */