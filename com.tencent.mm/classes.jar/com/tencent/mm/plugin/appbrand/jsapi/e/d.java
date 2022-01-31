package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import org.json.JSONObject;

public class d<CONTEXT extends c>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  protected volatile l hMZ;
  
  public void c(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93822);
    com.tencent.luggage.g.d.i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", new Object[] { paramJSONObject });
    boolean bool;
    try
    {
      if (this.hMZ == null)
      {
        this.hMZ = new l(paramCONTEXT);
        this.hMZ.start();
      }
      bool = paramJSONObject.optBoolean("enable");
      if ((!bool) && (!q(paramCONTEXT)))
      {
        paramCONTEXT.h(paramInt, j("ok", null));
        AppMethodBeat.o(93822);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(93822);
    }
    this.hMZ.fPG = e(paramCONTEXT, paramJSONObject);
    if (bool)
    {
      if (!q(paramCONTEXT))
      {
        paramCONTEXT.h(paramInt, j("fail:system permission denied", null));
        AppMethodBeat.o(93822);
        return;
      }
      this.hMZ.sendMessage(1);
    }
    for (;;)
    {
      paramCONTEXT.h(paramInt, j("ok", null));
      AppMethodBeat.o(93822);
      return;
      this.hMZ.sendMessage(2);
    }
  }
  
  protected Bundle e(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.d
 * JD-Core Version:    0.7.0.1
 */