package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class i<CONTEXT extends e>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  protected t oUM;
  
  public void c(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143628);
    Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", new Object[] { paramJSONObject });
    this.oUM = ((t)paramCONTEXT.av(t.class));
    if (this.oUM == null)
    {
      this.oUM = t(paramCONTEXT);
      this.oUM.start();
      paramCONTEXT.a(this.oUM);
    }
    this.oUM.mab = f(paramCONTEXT, paramJSONObject);
    paramJSONObject = paramJSONObject.optString("type", "gcj02");
    this.oUM.type = paramJSONObject;
    paramJSONObject = this.oUM;
    paramJSONObject.mlr = false;
    paramJSONObject.sendMessage(1);
    paramCONTEXT.j(paramInt, h("ok", null));
    AppMethodBeat.o(143628);
  }
  
  protected Bundle f(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    return null;
  }
  
  protected t t(CONTEXT paramCONTEXT)
  {
    AppMethodBeat.i(143629);
    paramCONTEXT = new t(paramCONTEXT);
    AppMethodBeat.o(143629);
    return paramCONTEXT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.i
 * JD-Core Version:    0.7.0.1
 */