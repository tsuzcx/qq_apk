package com.tencent.mm.plugin.appbrand.u.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private com.tencent.mm.plugin.appbrand.u.d qlD;
  
  static
  {
    AppMethodBeat.i(244191);
    b.a(new a());
    AppMethodBeat.o(244191);
  }
  
  public final void a(v paramv, i parami)
  {
    AppMethodBeat.i(147386);
    Log.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
    this.qlD = new com.tencent.mm.plugin.appbrand.u.d(paramv, parami);
    parami.addJavascriptInterface(this.qlD, "gJavaBroker");
    AppMethodBeat.o(147386);
  }
  
  protected void a(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(244190);
    paramStringBuffer.append(";const _switchTimer = true;");
    AppMethodBeat.o(244190);
  }
  
  public final void ccD()
  {
    AppMethodBeat.i(147387);
    Log.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
    if (this.qlD == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147387);
      throw localIllegalStateException;
    }
    this.qlD.ccA();
    AppMethodBeat.o(147387);
  }
  
  public final String ccE()
  {
    AppMethodBeat.i(147388);
    if (this.qlD == null)
    {
      localObject = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147388);
      throw ((Throwable)localObject);
    }
    Object localObject = new StringBuffer();
    a((StringBuffer)localObject);
    ((StringBuffer)localObject).append(ccz());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(147388);
    return localObject;
  }
  
  protected String ccz()
  {
    AppMethodBeat.i(147389);
    String str = com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/node_jsapi.js");
    AppMethodBeat.o(147389);
    return str;
  }
  
  public static class a
    implements b.a
  {
    public void a(AppBrandRuntime paramAppBrandRuntime, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(245477);
      try
      {
        paramJSONObject.put("switchFs", 1);
        AppMethodBeat.o(245477);
        return;
      }
      catch (JSONException paramAppBrandRuntime)
      {
        AppMethodBeat.o(245477);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.b.a
 * JD-Core Version:    0.7.0.1
 */