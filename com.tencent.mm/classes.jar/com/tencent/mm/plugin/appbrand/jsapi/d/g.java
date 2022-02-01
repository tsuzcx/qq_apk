package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public class g<CONTEXT extends c>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  protected q ksX;
  
  public void d(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143628);
    ac.i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", new Object[] { paramJSONObject });
    this.ksX = ((q)paramCONTEXT.as(q.class));
    if (this.ksX == null)
    {
      this.ksX = r(paramCONTEXT);
      this.ksX.start();
      paramCONTEXT.a(this.ksX);
    }
    this.ksX.hSN = g(paramCONTEXT, paramJSONObject);
    paramJSONObject = this.ksX;
    paramJSONObject.iel = false;
    paramJSONObject.Yv(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.g
 * JD-Core Version:    0.7.0.1
 */