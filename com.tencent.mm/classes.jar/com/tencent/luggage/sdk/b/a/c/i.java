package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.debugger.j;
import com.tencent.mm.plugin.appbrand.debugger.m;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.debugger.w;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class i<SERVICE extends c>
  extends e<SERVICE>
  implements j
{
  public static final b.a cpb;
  private o cjZ;
  private m cpc;
  
  static
  {
    AppMethodBeat.i(146863);
    cpb = new a((byte)0);
    AppMethodBeat.o(146863);
  }
  
  public i(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
    AppMethodBeat.i(146856);
    super.b(j.class, this);
    AppMethodBeat.o(146856);
  }
  
  public final String CL()
  {
    AppMethodBeat.i(146855);
    Object localObject = ((c)Eo()).EP();
    String str = ((c)Eo()).Eq().getAppConfig().jZa;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(146855);
    return localObject;
  }
  
  public final boolean CN()
  {
    return false;
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsruntime.i CO()
  {
    AppMethodBeat.i(146857);
    this.cjZ = new o();
    o localo = this.cjZ;
    AppMethodBeat.o(146857);
    return localo;
  }
  
  public final void Da()
  {
    AppMethodBeat.i(146859);
    super.Da();
    this.cjZ.keO.bringToFront();
    AppMethodBeat.o(146859);
  }
  
  protected final void Dg()
  {
    AppMethodBeat.i(146860);
    EK();
    AppMethodBeat.o(146860);
  }
  
  protected final void Dh() {}
  
  protected final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146858);
    ((c)Eo()).biL();
    if (v.kfo != null)
    {
      this.cpc = v.kfo;
      v.kfo = null;
    }
    for (;;)
    {
      this.cpc.a((c)Eo(), ((c)Eo()).Eq().Fg().extInfo);
      this.cjZ.a(this.cpc);
      AppMethodBeat.o(146858);
      return;
      this.cpc = new m();
    }
  }
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(146854);
    ae.d("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", new Object[] { paramString });
    ebb localebb = new ebb();
    localebb.IgP = ((c)Eo()).EO().aXX();
    localebb.IgO = paramString;
    paramString = v.a(localebb, this.cpc, "domEvent");
    this.cjZ.a(paramString);
    AppMethodBeat.o(146854);
  }
  
  public final boolean cU(String paramString)
  {
    return false;
  }
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146862);
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "{}";
    }
    ae.d("Luggage.MPRemoteDebugServiceLogic", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(paramInt) });
    this.cjZ.keJ = paramString1;
    o localo = this.cjZ;
    paramString2 = str;
    if (TextUtils.isEmpty(str)) {
      paramString2 = "{}";
    }
    if (paramInt == 0) {}
    for (str = "undefined";; str = String.valueOf(paramInt))
    {
      localo.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { "WeixinJSBridge", "WeixinJSBridge", paramString1, paramString2, str, cj.aiB() }), null);
      AppMethodBeat.o(146862);
      return true;
    }
  }
  
  public final boolean i(int paramInt, String paramString)
  {
    AppMethodBeat.i(146861);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "{}";
    }
    this.cjZ.Z(paramInt, str);
    AppMethodBeat.o(146861);
    return true;
  }
  
  static final class a
    implements b.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.i
 * JD-Core Version:    0.7.0.1
 */