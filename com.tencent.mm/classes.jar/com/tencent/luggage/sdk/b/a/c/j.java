package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.debugger.m;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.debugger.w;
import com.tencent.mm.plugin.appbrand.jsapi.cx;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.protocal.protobuf.evi;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class j<SERVICE extends d>
  extends f<SERVICE>
  implements com.tencent.mm.plugin.appbrand.debugger.j
{
  public static final b.a cBs;
  private m cBt;
  private o cvW;
  
  static
  {
    AppMethodBeat.i(146863);
    cBs = new a((byte)0);
    AppMethodBeat.o(146863);
  }
  
  public j(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
    AppMethodBeat.i(146856);
    super.b(com.tencent.mm.plugin.appbrand.debugger.j.class, this);
    AppMethodBeat.o(146856);
  }
  
  protected final void MC()
  {
    AppMethodBeat.i(146860);
    Om();
    AppMethodBeat.o(146860);
  }
  
  protected final void MD() {}
  
  public final String Mh()
  {
    AppMethodBeat.i(146855);
    Object localObject = ((d)NN()).Or();
    String str = ((d)NN()).NP().getAppConfig().lcc;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(146855);
    return localObject;
  }
  
  public final boolean Mj()
  {
    return false;
  }
  
  protected final i Mk()
  {
    AppMethodBeat.i(146857);
    this.cvW = new o();
    o localo = this.cvW;
    AppMethodBeat.o(146857);
    return localo;
  }
  
  public final void Mw()
  {
    AppMethodBeat.i(146859);
    super.Mw();
    this.cvW.lix.bringToFront();
    AppMethodBeat.o(146859);
  }
  
  protected final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146858);
    super.c(paramAppBrandRuntime);
    ((d)NN()).bEb();
    if (v.liX != null)
    {
      this.cBt = v.liX;
      v.liX = null;
    }
    for (;;)
    {
      this.cBt.a((d)NN(), ((d)NN()).NP().ON().extInfo);
      this.cvW.a(this.cBt);
      AppMethodBeat.o(146858);
      return;
      this.cBt = new m();
    }
  }
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146862);
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "{}";
    }
    Log.d("Luggage.MPRemoteDebugServiceLogic", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(paramInt) });
    this.cvW.lit = paramString1;
    o localo = this.cvW;
    paramString2 = str;
    if (TextUtils.isEmpty(str)) {
      paramString2 = "{}";
    }
    if (paramInt == 0) {}
    for (str = "undefined";; str = String.valueOf(paramInt))
    {
      localo.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { "WeixinJSBridge", "WeixinJSBridge", paramString1, paramString2, str, cx.ayR() }), null);
      AppMethodBeat.o(146862);
      return true;
    }
  }
  
  public final void ds(String paramString)
  {
    AppMethodBeat.i(146854);
    Log.d("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", new Object[] { paramString });
    evi localevi = new evi();
    localevi.Ntn = ((d)NN()).Oq().getComponentId();
    localevi.Ntm = paramString;
    paramString = v.a(localevi, this.cBt, "domEvent");
    this.cvW.a(paramString);
    AppMethodBeat.o(146854);
  }
  
  public final boolean dt(String paramString)
  {
    return false;
  }
  
  public final boolean j(int paramInt, String paramString)
  {
    AppMethodBeat.i(146861);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "{}";
    }
    this.cvW.ad(paramInt, str);
    AppMethodBeat.o(146861);
    return true;
  }
  
  static final class a
    implements b.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.j
 * JD-Core Version:    0.7.0.1
 */