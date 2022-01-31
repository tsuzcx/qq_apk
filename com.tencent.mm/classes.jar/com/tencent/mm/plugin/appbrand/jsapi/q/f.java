package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 535;
  public static final String NAME = "getVolume";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.i("MicroMsg.JsApiGetVolume", "invoke JsApiGetVolume!");
    if (paramc == null)
    {
      y.e("MicroMsg.JsApiGetVolume", "component is null");
      return;
    }
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetVolume", "fail:context is null");
      paramc.C(paramInt, h("fail:context is null", null));
      return;
    }
    if (!(paramJSONObject instanceof Activity))
    {
      y.e("MicroMsg.JsApiGetVolume", "fail:context is not Activity");
      paramc.C(paramInt, h("fail:context is not Activity", null));
      return;
    }
    paramJSONObject = (AudioManager)paramJSONObject.getSystemService("audio");
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetVolume", "fail:manager is null");
      paramc.C(paramInt, h("fail:manager is null", null));
      return;
    }
    int i = paramJSONObject.getStreamVolume(3);
    int j = paramJSONObject.getStreamMaxVolume(3);
    y.i("MicroMsg.JsApiGetVolume", "JsApiGetVolume %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    paramJSONObject = new HashMap();
    paramJSONObject.put("currentVolume", Integer.valueOf(i));
    paramJSONObject.put("maxVolume", Integer.valueOf(j));
    paramc.C(paramInt, h("ok", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.f
 * JD-Core Version:    0.7.0.1
 */