package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.u.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect
  extends a
{
  public static final int CTRL_INDEX = 214;
  public static final String NAME = "checkIsSupportFacialRecognition";
  private JsApiCheckIsSupportFaceDetect.GetIsSupportFaceTask glh = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
    this.glh = new JsApiCheckIsSupportFaceDetect.GetIsSupportFaceTask(paramc, paramInt, this);
    i.aU(this.glh);
    AppBrandMainProcessService.a(this.glh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect
 * JD-Core Version:    0.7.0.1
 */