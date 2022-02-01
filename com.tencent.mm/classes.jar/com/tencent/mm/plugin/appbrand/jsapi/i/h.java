package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class h<CONTEXT extends f>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  protected s lXb;
  
  public void d(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143628);
    Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", new Object[] { paramJSONObject });
    this.lXb = ((s)paramCONTEXT.aw(s.class));
    if (this.lXb == null)
    {
      this.lXb = r(paramCONTEXT);
      this.lXb.start();
      paramCONTEXT.a(this.lXb);
    }
    this.lXb.jkf = g(paramCONTEXT, paramJSONObject);
    paramJSONObject = this.lXb;
    paramJSONObject.jvO = false;
    paramJSONObject.sendMessage(1);
    paramCONTEXT.i(paramInt, h("ok", null));
    AppMethodBeat.o(143628);
  }
  
  protected Bundle g(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    return null;
  }
  
  protected s r(CONTEXT paramCONTEXT)
  {
    AppMethodBeat.i(143629);
    paramCONTEXT = new s(paramCONTEXT);
    AppMethodBeat.o(143629);
    return paramCONTEXT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.h
 * JD-Core Version:    0.7.0.1
 */