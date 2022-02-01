package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

@Deprecated
public final class s
  extends c
  implements j
{
  private o cjX;
  private m coY;
  
  public final String CI()
  {
    AppMethodBeat.i(44957);
    Object localObject = EN();
    String str = getRuntime().getAppConfig().jVK;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(44957);
    return localObject;
  }
  
  public final void Dd()
  {
    AppMethodBeat.i(44954);
    aXy();
    AppMethodBeat.o(44954);
  }
  
  public final i EK()
  {
    AppMethodBeat.i(44952);
    this.cjX = new o();
    o localo = this.cjX;
    AppMethodBeat.o(44952);
    return localo;
  }
  
  public final void cR(String paramString)
  {
    AppMethodBeat.i(44958);
    ad.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
    dzk localdzk = new dzk();
    localdzk.HMI = getRuntime().aXd().getCurrentPage().getCurrentPageView().aXC();
    localdzk.HMH = paramString;
    paramString = v.a(localdzk, this.coY, "domEvent");
    this.cjX.a(paramString);
    AppMethodBeat.o(44958);
  }
  
  public final boolean cS(String paramString)
  {
    return false;
  }
  
  public final void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44955);
    super.d(paramAppBrandRuntime);
    bic();
    if (v.kbX != null)
    {
      this.coY = v.kbX;
      v.kbX = null;
    }
    for (;;)
    {
      this.coY.a(this, getRuntime().aXc().extInfo);
      this.cjX.a(this.coY);
      AppMethodBeat.o(44955);
      return;
      this.coY = new m();
    }
  }
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(44953);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = "{}";
    }
    this.cjX.Z(paramInt, str);
    AppMethodBeat.o(44953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s
 * JD-Core Version:    0.7.0.1
 */