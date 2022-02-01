package com.tencent.mm.plugin.appbrand.q.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;

public class a
{
  private com.tencent.mm.plugin.appbrand.q.d mcu;
  
  public final void a(r paramr, i parami)
  {
    AppMethodBeat.i(147386);
    ae.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
    this.mcu = new com.tencent.mm.plugin.appbrand.q.d(paramr, parami);
    parami.addJavascriptInterface(this.mcu, "gJavaBroker");
    AppMethodBeat.o(147386);
  }
  
  protected void a(StringBuffer paramStringBuffer) {}
  
  protected String buk()
  {
    AppMethodBeat.i(147389);
    String str = com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/node_jsapi.js");
    AppMethodBeat.o(147389);
    return str;
  }
  
  public final void bup()
  {
    AppMethodBeat.i(147387);
    ae.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
    if (this.mcu == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147387);
      throw localIllegalStateException;
    }
    this.mcu.bul();
    AppMethodBeat.o(147387);
  }
  
  public final String buq()
  {
    AppMethodBeat.i(147388);
    if (this.mcu == null)
    {
      localObject = new IllegalStateException("You had not called whenCreateJsRuntime!");
      AppMethodBeat.o(147388);
      throw ((Throwable)localObject);
    }
    Object localObject = new StringBuffer();
    a((StringBuffer)localObject);
    ((StringBuffer)localObject).append(buk());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(147388);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.b.a
 * JD-Core Version:    0.7.0.1
 */