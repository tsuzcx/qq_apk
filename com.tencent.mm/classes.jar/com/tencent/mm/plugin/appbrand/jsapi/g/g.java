package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class g<CONTEXT extends c>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  protected r kRV;
  
  public void d(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143628);
    ae.i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", new Object[] { paramJSONObject });
    this.kRV = ((r)paramCONTEXT.as(r.class));
    if (this.kRV == null)
    {
      this.kRV = r(paramCONTEXT);
      this.kRV.start();
      paramCONTEXT.a(this.kRV);
    }
    this.kRV.ioY = g(paramCONTEXT, paramJSONObject);
    paramJSONObject = this.kRV;
    paramJSONObject.iAz = false;
    paramJSONObject.abg(1);
    paramCONTEXT.h(paramInt, e("ok", null));
    AppMethodBeat.o(143628);
  }
  
  protected Bundle g(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    return null;
  }
  
  protected r r(CONTEXT paramCONTEXT)
  {
    AppMethodBeat.i(143629);
    paramCONTEXT = new r(paramCONTEXT);
    AppMethodBeat.o(143629);
    return paramCONTEXT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.g
 * JD-Core Version:    0.7.0.1
 */