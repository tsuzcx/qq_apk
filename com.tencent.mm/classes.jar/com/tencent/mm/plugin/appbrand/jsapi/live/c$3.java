package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class c$3
  implements a.a
{
  c$3(c paramc, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "onRequestPermissionsResult callback requestCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 117) {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0)) {
        ai.l(new c.3.1(this), 50L);
      }
    }
    while (paramInt != 118)
    {
      return;
      y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "onRequestPermissionsResult callback not grant");
      this.ggE.C(this.dIS, this.gsn.h("fail:system permission denied", null));
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      ai.l(new c.3.2(this), 50L);
      return;
    }
    y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "onRequestPermissionsResult callback not grant");
    this.ggE.C(this.dIS, this.gsn.h("fail:system permission denied", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.3
 * JD-Core Version:    0.7.0.1
 */