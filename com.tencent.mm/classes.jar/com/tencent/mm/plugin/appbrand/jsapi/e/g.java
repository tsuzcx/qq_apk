package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class g<CONTEXT extends c>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  protected q jSl;
  
  public void d(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143628);
    ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", new Object[] { paramJSONObject });
    this.jSl = ((q)paramCONTEXT.as(q.class));
    if (this.jSl == null)
    {
      this.jSl = r(paramCONTEXT);
      this.jSl.start();
      paramCONTEXT.a(this.jSl);
    }
    this.jSl.hsl = g(paramCONTEXT, paramJSONObject);
    paramJSONObject = this.jSl;
    paramJSONObject.hDJ = false;
    paramJSONObject.Wm(1);
    paramCONTEXT.h(paramInt, e("ok", null));
    AppMethodBeat.o(143628);
  }
  
  protected Bundle g(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    return null;
  }
  
  protected q r(CONTEXT paramCONTEXT)
  {
    AppMethodBeat.i(143629);
    paramCONTEXT = new q(paramCONTEXT);
    AppMethodBeat.o(143629);
    return paramCONTEXT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.g
 * JD-Core Version:    0.7.0.1
 */