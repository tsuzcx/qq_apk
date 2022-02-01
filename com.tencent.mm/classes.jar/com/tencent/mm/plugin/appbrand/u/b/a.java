package com.tencent.mm.plugin.appbrand.u.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private com.tencent.mm.plugin.appbrand.u.d nkf;
  
  static
  {
    AppMethodBeat.i(229943);
    b.a(new a());
    AppMethodBeat.o(229943);
  }
  
  public final void a(s params, i parami)
  {
    AppMethodBeat.i(147386);
    Log.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
    this.nkf = new com.tencent.mm.plugin.appbrand.u.d(params, parami);
    parami.addJavascriptInterface(this.nkf, "gJavaBroker");
    AppMethodBeat.o(147386);
  }
  
  protected void a(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(229942);
    paramStringBuffer.append(";const _switchTimer = true;");
    AppMethodBeat.o(229942);
  }
  
  protected String bPR()
  {
    AppMethodBeat.i(147389);
    String str = com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/node_jsapi.js");
    AppMethodBeat.o(147389);
    return str;
  }
  
  public final void bPW()
  {
    AppMethodBeat.i(147387);
    Log.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
    if (this.nkf == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147387);
      throw localIllegalStateException;
    }
    this.nkf.bPS();
    AppMethodBeat.o(147387);
  }
  
  public final String bPX()
  {
    AppMethodBeat.i(147388);
    if (this.nkf == null)
    {
      localObject = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147388);
      throw ((Throwable)localObject);
    }
    Object localObject = new StringBuffer();
    a((StringBuffer)localObject);
    ((StringBuffer)localObject).append(bPR());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(147388);
    return localObject;
  }
  
  public static class a
    implements b.a
  {
    public void a(AppBrandRuntime paramAppBrandRuntime, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(229941);
      try
      {
        paramJSONObject.put("switchFs", 1);
        AppMethodBeat.o(229941);
        return;
      }
      catch (JSONException paramAppBrandRuntime)
      {
        AppMethodBeat.o(229941);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.b.a
 * JD-Core Version:    0.7.0.1
 */