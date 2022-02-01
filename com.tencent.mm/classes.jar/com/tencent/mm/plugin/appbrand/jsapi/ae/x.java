package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class x
  extends c
{
  public static final int CTRL_INDEX = 534;
  public static final String NAME = "setVolume";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137688);
    Log.i("MicroMsg.JsApiSetVolume", "invoke JsApiSetVolume!");
    if (paramf == null)
    {
      Log.e("MicroMsg.JsApiSetVolume", "fail:component is null");
      AppMethodBeat.o(137688);
      return;
    }
    Object localObject = paramf.getContext();
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiSetVolume", "fail:context is null");
      paramf.callback(paramInt, ZP("fail:context is null"));
      AppMethodBeat.o(137688);
      return;
    }
    if (!(localObject instanceof Activity))
    {
      Log.e("MicroMsg.JsApiSetVolume", "fail:context is not Activity");
      paramf.callback(paramInt, ZP("fail:context is not Activity"));
      AppMethodBeat.o(137688);
      return;
    }
    localObject = (AudioManager)((Context)localObject).getSystemService("audio");
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiSetVolume", "fail:manager is null");
      paramf.callback(paramInt, ZP("fail:manager is null"));
      AppMethodBeat.o(137688);
      return;
    }
    int m = ((AudioManager)localObject).getStreamVolume(3);
    int j = ((AudioManager)localObject).getStreamMaxVolume(3);
    int k = paramJSONObject.optInt("value", m);
    Log.i("MicroMsg.JsApiSetVolume", "JsApiSetVolume value:%d, current:%d, max:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
    int i;
    if (k < 0) {
      i = 0;
    }
    while (i != m)
    {
      a.a((AudioManager)localObject, 3, i, 0);
      paramf.callback(paramInt, ZP("ok"));
      AppMethodBeat.o(137688);
      return;
      i = j;
      if (k <= j) {
        i = k;
      }
    }
    paramf.callback(paramInt, ZP("fail:volume does not change"));
    AppMethodBeat.o(137688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.x
 * JD-Core Version:    0.7.0.1
 */