package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.protocal.protobuf.gcg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

@Deprecated
public final class u
  extends c
  implements l
{
  private q emf;
  private o esY;
  
  public final void apC()
  {
    AppMethodBeat.i(44954);
    cdl();
    AppMethodBeat.o(44954);
  }
  
  public final String aph()
  {
    AppMethodBeat.i(44957);
    Object localObject = arC();
    String str = getRuntime().getAppConfig().qVW;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(44957);
    return localObject;
  }
  
  public final i arz()
  {
    AppMethodBeat.i(44952);
    this.emf = new q();
    q localq = this.emf;
    AppMethodBeat.o(44952);
    return localq;
  }
  
  public final void callback(int paramInt, String paramString)
  {
    AppMethodBeat.i(44953);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = "{}";
    }
    this.emf.ao(paramInt, str);
    AppMethodBeat.o(44953);
  }
  
  public final void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44955);
    super.d(paramAppBrandRuntime);
    cpF();
    if (x.reA != null)
    {
      this.esY = x.reA;
      x.reA = null;
    }
    for (;;)
    {
      this.esY.a(this, getRuntime().getInitConfig().extInfo);
      this.emf.a(this.esY);
      AppMethodBeat.o(44955);
      return;
      this.esY = new o();
    }
  }
  
  public final void eU(String paramString)
  {
    AppMethodBeat.i(44958);
    Log.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
    gcg localgcg = new gcg();
    localgcg.acau = getRuntime().ccN().getCurrentPage().getCurrentPageView().getComponentId();
    localgcg.rRQ = paramString;
    paramString = x.a(localgcg, this.esY, "domEvent");
    this.emf.a(paramString);
    AppMethodBeat.o(44958);
  }
  
  public final boolean eV(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u
 * JD-Core Version:    0.7.0.1
 */