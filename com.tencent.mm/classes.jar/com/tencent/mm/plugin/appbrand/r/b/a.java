package com.tencent.mm.plugin.appbrand.r.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;

public class a
{
  private com.tencent.mm.plugin.appbrand.r.d kWF;
  
  public final void a(q paramq, i parami)
  {
    AppMethodBeat.i(147386);
    ad.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
    this.kWF = new com.tencent.mm.plugin.appbrand.r.d(paramq, parami);
    parami.addJavascriptInterface(this.kWF, "gJavaBroker");
    AppMethodBeat.o(147386);
  }
  
  protected void a(StringBuffer paramStringBuffer) {}
  
  protected String biE()
  {
    AppMethodBeat.i(147389);
    String str = com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/node_jsapi.js");
    AppMethodBeat.o(147389);
    return str;
  }
  
  public final void biK()
  {
    AppMethodBeat.i(147387);
    ad.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
    if (this.kWF == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147387);
      throw localIllegalStateException;
    }
    this.kWF.biG();
    AppMethodBeat.o(147387);
  }
  
  public final String biL()
  {
    AppMethodBeat.i(147388);
    if (this.kWF == null)
    {
      localObject = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147388);
      throw ((Throwable)localObject);
    }
    Object localObject = new StringBuffer();
    a((StringBuffer)localObject);
    ((StringBuffer)localObject).append(biE());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(147388);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.b.a
 * JD-Core Version:    0.7.0.1
 */