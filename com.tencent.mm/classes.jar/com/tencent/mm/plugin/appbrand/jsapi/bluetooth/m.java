package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 173;
  private static final String NAME = "openBluetoothAdapter";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(94203);
    c.kS(0);
    paramJSONObject = paramc.getAppId();
    ab.i("MicroMsg.JsApiOpenBluetoothAdapter", "appid:%s openBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = a.a(paramJSONObject, new b.a()new h
    {
      public final void ed(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94194);
        m.c.a(paramc, paramAnonymousBoolean, false);
        AppMethodBeat.o(94194);
      }
    }, new h()new m.3
    {
      public final void ah(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(94195);
        m.b.a(paramc, paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(94195);
      }
    }, new m.3(this, paramc));
    HashMap localHashMap = new HashMap();
    switch (paramJSONObject.errCode)
    {
    default: 
      localHashMap.put("errCode", Integer.valueOf(paramJSONObject.errCode));
      paramc.h(paramInt, j(paramJSONObject.errMsg, localHashMap));
      c.kS(2);
      AppMethodBeat.o(94203);
      return;
    case 0: 
      paramc.h(paramInt, j("ok", localHashMap));
      c.kS(1);
      AppMethodBeat.o(94203);
      return;
    case 10009: 
      localHashMap.put("errCode", Integer.valueOf(10009));
      paramc.h(paramInt, j("fail:system not support", localHashMap));
      c.df(2, 8);
      AppMethodBeat.o(94203);
      return;
    }
    localHashMap.put("errCode", Integer.valueOf(10001));
    paramc.h(paramInt, j("fail:not available", localHashMap));
    c.df(2, 7);
    AppMethodBeat.o(94203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m
 * JD-Core Version:    0.7.0.1
 */