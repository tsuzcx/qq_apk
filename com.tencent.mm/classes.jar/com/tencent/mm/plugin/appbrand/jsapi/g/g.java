package com.tencent.mm.plugin.appbrand.jsapi.g;

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
  protected q kOt;
  
  public void d(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143628);
    ad.i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", new Object[] { paramJSONObject });
    this.kOt = ((q)paramCONTEXT.as(q.class));
    if (this.kOt == null)
    {
      this.kOt = r(paramCONTEXT);
      this.kOt.start();
      paramCONTEXT.a(this.kOt);
    }
    this.kOt.ime = g(paramCONTEXT, paramJSONObject);
    paramJSONObject = this.kOt;
    paramJSONObject.ixG = false;
    paramJSONObject.aaA(1);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.g
 * JD-Core Version:    0.7.0.1
 */