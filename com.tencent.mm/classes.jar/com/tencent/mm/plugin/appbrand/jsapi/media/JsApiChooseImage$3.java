package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import org.json.JSONObject;

final class JsApiChooseImage$3
  implements a.a
{
  JsApiChooseImage$3(JsApiChooseImage paramJsApiChooseImage, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt != 113) {
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      this.gvl.a(this.ggH, this.gbZ, this.dIS);
      return;
    }
    this.ggH.C(this.dIS, this.gvl.h("fail:system permission denied", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.3
 * JD-Core Version:    0.7.0.1
 */