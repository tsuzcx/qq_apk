package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class bd
  extends a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "opNativeRedDot";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45560);
    String str = paramJSONObject.optString("op");
    int j = paramJSONObject.optInt("redDotType", 0);
    ac.i("MicroMsg.JsApiOpNativeRedDot", "op:%s redDotType:%d", new Object[] { str, Integer.valueOf(j) });
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        ac.w("MicroMsg.JsApiOpNativeRedDot", "unknown op:%s", new Object[] { str });
        paramc.h(paramInt, e("fail unknown op", null));
        AppMethodBeat.o(45560);
        return;
        if (str.equals("clear")) {
          i = 0;
        }
        break;
      }
    }
    com.tencent.mm.plugin.appbrand.u.a.uB(j);
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(45560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bd
 * JD-Core Version:    0.7.0.1
 */