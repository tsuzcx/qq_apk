package com.tencent.mm.plugin.appbrand.v.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private com.tencent.mm.plugin.appbrand.v.d tqB;
  
  static
  {
    AppMethodBeat.i(321222);
    b.a(new a());
    AppMethodBeat.o(321222);
  }
  
  public final void a(y paramy, i parami)
  {
    AppMethodBeat.i(147386);
    Log.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
    this.tqB = new com.tencent.mm.plugin.appbrand.v.d(paramy, parami);
    parami.addJavascriptInterface(this.tqB, "gJavaBroker");
    AppMethodBeat.o(147386);
  }
  
  protected void a(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(321235);
    paramStringBuffer.append(";const _switchTimer = true;");
    AppMethodBeat.o(321235);
  }
  
  protected String cCV()
  {
    AppMethodBeat.i(147389);
    String str = com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/node_jsapi.js");
    AppMethodBeat.o(147389);
    return str;
  }
  
  public final void cCZ()
  {
    AppMethodBeat.i(147387);
    Log.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
    if (this.tqB == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147387);
      throw localIllegalStateException;
    }
    this.tqB.cCW();
    AppMethodBeat.o(147387);
  }
  
  public final String cDa()
  {
    AppMethodBeat.i(147388);
    if (this.tqB == null)
    {
      localObject = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147388);
      throw ((Throwable)localObject);
    }
    Object localObject = new StringBuffer();
    a((StringBuffer)localObject);
    ((StringBuffer)localObject).append(cCV());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(147388);
    return localObject;
  }
  
  public static class a
    implements b.a
  {
    public void a(AppBrandRuntime paramAppBrandRuntime, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(321226);
      try
      {
        paramJSONObject.put("switchFs", 1);
        AppMethodBeat.o(321226);
        return;
      }
      catch (JSONException paramAppBrandRuntime)
      {
        AppMethodBeat.o(321226);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.b.a
 * JD-Core Version:    0.7.0.1
 */