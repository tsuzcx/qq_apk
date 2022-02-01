package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.protocal.protobuf.ffu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

@Deprecated
public final class u
  extends c
  implements l
{
  private o cAD;
  private q cum;
  
  public final String OZ()
  {
    AppMethodBeat.i(44957);
    Object localObject = Ro();
    String str = getRuntime().getAppConfig().nWl;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(44957);
    return localObject;
  }
  
  public final void Pu()
  {
    AppMethodBeat.i(44954);
    bDY();
    AppMethodBeat.o(44954);
  }
  
  public final i Rl()
  {
    AppMethodBeat.i(44952);
    this.cum = new q();
    q localq = this.cum;
    AppMethodBeat.o(44952);
    return localq;
  }
  
  public final void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44955);
    super.d(paramAppBrandRuntime);
    bPz();
    if (x.odG != null)
    {
      this.cAD = x.odG;
      x.odG = null;
    }
    for (;;)
    {
      this.cAD.a(this, getRuntime().bDy().extInfo);
      this.cum.a(this.cAD);
      AppMethodBeat.o(44955);
      return;
      this.cAD = new o();
    }
  }
  
  public final void dJ(String paramString)
  {
    AppMethodBeat.i(44958);
    Log.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
    ffu localffu = new ffu();
    localffu.UGl = getRuntime().bDz().getCurrentPage().getCurrentPageView().getComponentId();
    localffu.UGk = paramString;
    paramString = x.a(localffu, this.cAD, "domEvent");
    this.cum.a(paramString);
    AppMethodBeat.o(44958);
  }
  
  public final boolean dK(String paramString)
  {
    return false;
  }
  
  public final void j(int paramInt, String paramString)
  {
    AppMethodBeat.i(44953);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = "{}";
    }
    this.cum.af(paramInt, str);
    AppMethodBeat.o(44953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u
 * JD-Core Version:    0.7.0.1
 */