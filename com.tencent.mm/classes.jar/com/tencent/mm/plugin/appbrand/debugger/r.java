package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

@Deprecated
public final class r
  extends c
  implements i
{
  private n bZF;
  private l ceH;
  
  public final void BE()
  {
    AppMethodBeat.i(44954);
    aUp();
    AppMethodBeat.o(44954);
  }
  
  public final String Bj()
  {
    AppMethodBeat.i(44957);
    Object localObject = Do();
    String str = getRuntime().getAppConfig().jBO;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(44957);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i Dl()
  {
    AppMethodBeat.i(44952);
    this.bZF = new n();
    n localn = this.bZF;
    AppMethodBeat.o(44952);
    return localn;
  }
  
  public final void bX(String paramString)
  {
    AppMethodBeat.i(44958);
    ac.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
    dtq localdtq = new dtq();
    localdtq.GbL = getRuntime().aTT().getCurrentPage().getCurrentPageView().aUT();
    localdtq.GbK = paramString;
    paramString = u.a(localdtq, this.ceH, "domEvent");
    this.bZF.a(paramString);
    AppMethodBeat.o(44958);
  }
  
  public final void bY(String paramString) {}
  
  public final void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44955);
    super.d(paramAppBrandRuntime);
    bey();
    if (u.jHL != null)
    {
      this.ceH = u.jHL;
      u.jHL = null;
    }
    for (;;)
    {
      this.ceH.a(this, getRuntime().aTS().extInfo);
      this.bZF.a(this.ceH);
      AppMethodBeat.o(44955);
      return;
      this.ceH = new l();
    }
  }
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(44953);
    String str = paramString;
    if (bs.isNullOrNil(paramString)) {
      str = "{}";
    }
    this.bZF.X(paramInt, str);
    AppMethodBeat.o(44953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.r
 * JD-Core Version:    0.7.0.1
 */