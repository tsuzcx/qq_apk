package com.tencent.mm.plugin.appbrand.q.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;

public class a
{
  private com.tencent.mm.plugin.appbrand.q.d lXN;
  
  public final void a(q paramq, i parami)
  {
    AppMethodBeat.i(147386);
    ad.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
    this.lXN = new com.tencent.mm.plugin.appbrand.q.d(paramq, parami);
    parami.addJavascriptInterface(this.lXN, "gJavaBroker");
    AppMethodBeat.o(147386);
  }
  
  protected void a(StringBuffer paramStringBuffer) {}
  
  public final void btE()
  {
    AppMethodBeat.i(147387);
    ad.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
    if (this.lXN == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147387);
      throw localIllegalStateException;
    }
    this.lXN.btA();
    AppMethodBeat.o(147387);
  }
  
  public final String btF()
  {
    AppMethodBeat.i(147388);
    if (this.lXN == null)
    {
      localObject = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147388);
      throw ((Throwable)localObject);
    }
    Object localObject = new StringBuffer();
    a((StringBuffer)localObject);
    ((StringBuffer)localObject).append(btz());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(147388);
    return localObject;
  }
  
  protected String btz()
  {
    AppMethodBeat.i(147389);
    String str = com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/node_jsapi.js");
    AppMethodBeat.o(147389);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.b.a
 * JD-Core Version:    0.7.0.1
 */