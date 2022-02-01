package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

@Deprecated
public final class r
  extends c
  implements i
{
  private n ccI;
  private l chM;
  
  public final String BF()
  {
    AppMethodBeat.i(44957);
    Object localObject = DL();
    String str = getRuntime().getAppConfig().jbB;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(44957);
    return localObject;
  }
  
  public final void Ca()
  {
    AppMethodBeat.i(44954);
    aNz();
    AppMethodBeat.o(44954);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i DI()
  {
    AppMethodBeat.i(44952);
    this.ccI = new n();
    n localn = this.ccI;
    AppMethodBeat.o(44952);
    return localn;
  }
  
  public final void ch(String paramString)
  {
    AppMethodBeat.i(44958);
    ad.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
    dnz localdnz = new dnz();
    localdnz.EEy = getRuntime().aNd().getCurrentPage().getCurrentPageView().aOd();
    localdnz.EEx = paramString;
    paramString = u.a(localdnz, this.chM, "domEvent");
    this.ccI.a(paramString);
    AppMethodBeat.o(44958);
  }
  
  public final void ci(String paramString) {}
  
  public final void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44955);
    super.d(paramAppBrandRuntime);
    aXB();
    if (u.jhw != null)
    {
      this.chM = u.jhw;
      u.jhw = null;
    }
    for (;;)
    {
      this.chM.a(this, getRuntime().aNc().extInfo);
      this.ccI.a(this.chM);
      AppMethodBeat.o(44955);
      return;
      this.chM = new l();
    }
  }
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(44953);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = "{}";
    }
    this.ccI.W(paramInt, str);
    AppMethodBeat.o(44953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.r
 * JD-Core Version:    0.7.0.1
 */