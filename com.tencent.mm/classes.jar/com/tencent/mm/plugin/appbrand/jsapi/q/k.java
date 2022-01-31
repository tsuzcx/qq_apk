package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class k
  extends a
{
  public static final int CTRL_INDEX = 534;
  public static final String NAME = "setVolume";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.i("MicroMsg.JsApiSetVolume", "invoke JsApiSetVolume!");
    if (paramc == null)
    {
      y.e("MicroMsg.JsApiSetVolume", "fail:component is null");
      return;
    }
    Object localObject = paramc.getContext();
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiSetVolume", "fail:context is null");
      paramc.C(paramInt, h("fail:context is null", null));
      return;
    }
    if (!(localObject instanceof Activity))
    {
      y.e("MicroMsg.JsApiSetVolume", "fail:context is not Activity");
      paramc.C(paramInt, h("fail:context is not Activity", null));
      return;
    }
    localObject = (AudioManager)((Context)localObject).getSystemService("audio");
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiSetVolume", "fail:manager is null");
      paramc.C(paramInt, h("fail:manager is null", null));
      return;
    }
    int m = ((AudioManager)localObject).getStreamVolume(3);
    int j = ((AudioManager)localObject).getStreamMaxVolume(3);
    int k = paramJSONObject.optInt("value", m);
    y.i("MicroMsg.JsApiSetVolume", "JsApiSetVolume value:%d, current:%d, max:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
    int i;
    if (k < 0) {
      i = 0;
    }
    while (i != m)
    {
      ((AudioManager)localObject).setStreamVolume(3, i, 0);
      paramc.C(paramInt, h("ok", null));
      return;
      i = j;
      if (k <= j) {
        i = k;
      }
    }
    paramc.C(paramInt, h("fail:volume does not change", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.k
 * JD-Core Version:    0.7.0.1
 */