package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class JsApiUploadWeRunData
  extends a
{
  public static final int CTRL_INDEX = 323;
  public static final String NAME = "uploadWeRunData";
  private JsApiUploadWeRunData.UploadMiniAppStepTask ghD;
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null", null));
      y.e("MicroMsg.JsApiUploadWeRunData", "data is null");
      return;
    }
    a(this, paramc, paramInt, paramJSONObject.optInt("step"), false);
  }
  
  public final void a(i parami, c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 <= 0)
    {
      paramc.C(paramInt1, parami.h("fail:step invalid", null));
      return;
    }
    this.ghD = new JsApiUploadWeRunData.UploadMiniAppStepTask(parami, paramc, paramInt1, paramInt2, paramBoolean);
    this.ghD.ahC();
    AppBrandMainProcessService.a(this.ghD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData
 * JD-Core Version:    0.7.0.1
 */