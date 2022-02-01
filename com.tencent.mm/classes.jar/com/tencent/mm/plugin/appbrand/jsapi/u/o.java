package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class o
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 534;
  public static final String NAME = "setVolume";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137688);
    ac.i("MicroMsg.JsApiSetVolume", "invoke JsApiSetVolume!");
    if (paramc == null)
    {
      ac.e("MicroMsg.JsApiSetVolume", "fail:component is null");
      AppMethodBeat.o(137688);
      return;
    }
    Object localObject = paramc.getContext();
    if (localObject == null)
    {
      ac.e("MicroMsg.JsApiSetVolume", "fail:context is null");
      paramc.h(paramInt, e("fail:context is null", null));
      AppMethodBeat.o(137688);
      return;
    }
    if (!(localObject instanceof Activity))
    {
      ac.e("MicroMsg.JsApiSetVolume", "fail:context is not Activity");
      paramc.h(paramInt, e("fail:context is not Activity", null));
      AppMethodBeat.o(137688);
      return;
    }
    localObject = (AudioManager)((Context)localObject).getSystemService("audio");
    if (localObject == null)
    {
      ac.e("MicroMsg.JsApiSetVolume", "fail:manager is null");
      paramc.h(paramInt, e("fail:manager is null", null));
      AppMethodBeat.o(137688);
      return;
    }
    int m = ((AudioManager)localObject).getStreamVolume(3);
    int j = ((AudioManager)localObject).getStreamMaxVolume(3);
    int k = paramJSONObject.optInt("value", m);
    ac.i("MicroMsg.JsApiSetVolume", "JsApiSetVolume value:%d, current:%d, max:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
    int i;
    if (k < 0) {
      i = 0;
    }
    while (i != m)
    {
      com.tencent.mm.compatible.b.a.b((AudioManager)localObject, 3, i);
      paramc.h(paramInt, e("ok", null));
      AppMethodBeat.o(137688);
      return;
      i = j;
      if (k <= j) {
        i = k;
      }
    }
    paramc.h(paramInt, e("fail:volume does not change", null));
    AppMethodBeat.o(137688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.o
 * JD-Core Version:    0.7.0.1
 */