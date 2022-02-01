package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.evi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

@Deprecated
public final class s
  extends c
  implements j
{
  private m cBt;
  private o cvW;
  
  public final void MC()
  {
    AppMethodBeat.i(44954);
    bta();
    AppMethodBeat.o(44954);
  }
  
  public final String Mh()
  {
    AppMethodBeat.i(44957);
    Object localObject = Or();
    String str = getRuntime().getAppConfig().lcc;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(44957);
    return localObject;
  }
  
  public final i Oo()
  {
    AppMethodBeat.i(44952);
    this.cvW = new o();
    o localo = this.cvW;
    AppMethodBeat.o(44952);
    return localo;
  }
  
  public final void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(44955);
    super.d(paramAppBrandRuntime);
    bEb();
    if (v.liX != null)
    {
      this.cBt = v.liX;
      v.liX = null;
    }
    for (;;)
    {
      this.cBt.a(this, getRuntime().bsC().extInfo);
      this.cvW.a(this.cBt);
      AppMethodBeat.o(44955);
      return;
      this.cBt = new m();
    }
  }
  
  public final void ds(String paramString)
  {
    AppMethodBeat.i(44958);
    Log.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
    evi localevi = new evi();
    localevi.Ntn = getRuntime().bsD().getCurrentPage().getCurrentPageView().getComponentId();
    localevi.Ntm = paramString;
    paramString = v.a(localevi, this.cBt, "domEvent");
    this.cvW.a(paramString);
    AppMethodBeat.o(44958);
  }
  
  public final boolean dt(String paramString)
  {
    return false;
  }
  
  public final void i(int paramInt, String paramString)
  {
    AppMethodBeat.i(44953);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = "{}";
    }
    this.cvW.ad(paramInt, str);
    AppMethodBeat.o(44953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s
 * JD-Core Version:    0.7.0.1
 */