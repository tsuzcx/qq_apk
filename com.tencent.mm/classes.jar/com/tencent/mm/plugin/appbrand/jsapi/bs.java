package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class bs
  extends d
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "opNativeRedDot";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45560);
    String str = paramJSONObject.optString("op");
    int j = paramJSONObject.optInt("redDotType", 0);
    Log.i("MicroMsg.JsApiOpNativeRedDot", "op:%s redDotType:%d", new Object[] { str, Integer.valueOf(j) });
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        Log.w("MicroMsg.JsApiOpNativeRedDot", "unknown op:%s", new Object[] { str });
        paramf.i(paramInt, h("fail unknown op", null));
        AppMethodBeat.o(45560);
        return;
        if (str.equals("clear")) {
          i = 0;
        }
        break;
      }
    }
    a.zc(j);
    paramf.i(paramInt, h("ok", null));
    AppMethodBeat.o(45560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bs
 * JD-Core Version:    0.7.0.1
 */