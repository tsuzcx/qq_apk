package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

@Deprecated
public final class s
  extends c
  implements j
{
  private o cjZ;
  private m cpc;
  
  public final String CL()
  {
    AppMethodBeat.i(44957);
    Object localObject = EP();
    String str = getRuntime().getAppConfig().jZa;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(44957);
    return localObject;
  }
  
  public final void Dg()
  {
    AppMethodBeat.i(44954);
    aXT();
    AppMethodBeat.o(44954);
  }
  
  public final i EM()
  {
    AppMethodBeat.i(44952);
    this.cjZ = new o();
    o localo = this.cjZ;
    AppMethodBeat.o(44952);
    return localo;
  }
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(44958);
    ae.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
    ebb localebb = new ebb();
    localebb.IgP = getRuntime().aXy().getCurrentPage().getCurrentPageView().aXX();
    localebb.IgO = paramString;
    paramString = v.a(localebb, this.cpc, "domEvent");
    this.cjZ.a(paramString);
    AppMethodBeat.o(44958);
  }
  
  public final boolean cU(String paramString)
  {
    return false;
  }
  
  public final void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44955);
    super.d(paramAppBrandRuntime);
    biL();
    if (v.kfo != null)
    {
      this.cpc = v.kfo;
      v.kfo = null;
    }
    for (;;)
    {
      this.cpc.a(this, getRuntime().aXx().extInfo);
      this.cjZ.a(this.cpc);
      AppMethodBeat.o(44955);
      return;
      this.cpc = new m();
    }
  }
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(44953);
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = "{}";
    }
    this.cjZ.Z(paramInt, str);
    AppMethodBeat.o(44953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s
 * JD-Core Version:    0.7.0.1
 */