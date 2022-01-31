package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class JsApiChooseMedia$4
  implements a.a
{
  JsApiChooseMedia$4(JsApiChooseMedia paramJsApiChooseMedia, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt != 119)
    {
      y.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission requestCode is not for choose media");
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      y.i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
      this.gvD.a(this.ggH, this.gbZ, this.dIS);
      return;
    }
    y.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
    this.ggH.C(this.dIS, this.gvD.h("fail:system permission denied", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.4
 * JD-Core Version:    0.7.0.1
 */