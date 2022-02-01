package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class i<CONTEXT extends f>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  protected u rZZ;
  
  public void d(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143628);
    Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", new Object[] { paramJSONObject });
    this.rZZ = ((u)paramCONTEXT.aO(u.class));
    if (this.rZZ == null)
    {
      this.rZZ = v(paramCONTEXT);
      this.rZZ.start();
      paramCONTEXT.a(this.rZZ);
    }
    this.rZZ.oSS = f(paramCONTEXT, paramJSONObject);
    paramJSONObject = paramJSONObject.optString("type", "gcj02");
    this.rZZ.type = paramJSONObject;
    paramJSONObject = this.rZZ;
    paramJSONObject.pfd = false;
    paramJSONObject.sendMessage(1);
    paramCONTEXT.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(143628);
  }
  
  protected Bundle f(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    return null;
  }
  
  protected u v(CONTEXT paramCONTEXT)
  {
    AppMethodBeat.i(143629);
    paramCONTEXT = new u(paramCONTEXT);
    AppMethodBeat.o(143629);
    return paramCONTEXT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.i
 * JD-Core Version:    0.7.0.1
 */