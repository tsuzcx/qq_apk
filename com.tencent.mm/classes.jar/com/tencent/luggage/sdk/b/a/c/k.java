package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.debugger.l;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.debugger.x;
import com.tencent.mm.plugin.appbrand.debugger.y;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.protocal.protobuf.ffu;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class k<SERVICE extends d>
  extends f<SERVICE>
  implements l
{
  public static final b.a cAC;
  private o cAD;
  private q cum;
  
  static
  {
    AppMethodBeat.i(146863);
    cAC = new a((byte)0);
    AppMethodBeat.o(146863);
  }
  
  public k(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
    AppMethodBeat.i(146856);
    super.b(l.class, this);
    AppMethodBeat.o(146856);
  }
  
  public final String OZ()
  {
    AppMethodBeat.i(146855);
    Object localObject = ((d)QK()).Ro();
    String str = ((d)QK()).QM().getAppConfig().nWl;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(146855);
    return localObject;
  }
  
  public final boolean Pb()
  {
    return false;
  }
  
  protected final i Pc()
  {
    AppMethodBeat.i(146857);
    this.cum = new q();
    q localq = this.cum;
    AppMethodBeat.o(146857);
    return localq;
  }
  
  public final void Po()
  {
    AppMethodBeat.i(146859);
    super.Po();
    this.cum.odf.bringToFront();
    AppMethodBeat.o(146859);
  }
  
  protected final void Pu()
  {
    AppMethodBeat.i(146860);
    Rj();
    AppMethodBeat.o(146860);
  }
  
  protected final void Pv() {}
  
  public final boolean Rp()
  {
    return true;
  }
  
  protected final boolean Ry()
  {
    return false;
  }
  
  protected final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146858);
    super.c(paramAppBrandRuntime);
    ((d)QK()).bPz();
    if (x.odG != null)
    {
      this.cAD = x.odG;
      x.odG = null;
    }
    for (;;)
    {
      this.cAD.a((d)QK(), ((d)QK()).QM().Sk().extInfo);
      this.cum.a(this.cAD);
      AppMethodBeat.o(146858);
      return;
      this.cAD = new o();
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
    this.cum.odb = paramString1;
    q localq = this.cum;
    paramString2 = str;
    if (TextUtils.isEmpty(str)) {
      paramString2 = "{}";
    }
    if (paramInt == 0) {}
    for (str = "undefined";; str = String.valueOf(paramInt))
    {
      localq.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { "WeixinJSBridge", "WeixinJSBridge", paramString1, paramString2, str, cy.aGk() }), null);
      AppMethodBeat.o(146862);
      return true;
    }
  }
  
  public final void dJ(String paramString)
  {
    AppMethodBeat.i(146854);
    Log.d("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", new Object[] { paramString });
    ffu localffu = new ffu();
    localffu.UGl = ((d)QK()).Rn().getComponentId();
    localffu.UGk = paramString;
    paramString = x.a(localffu, this.cAD, "domEvent");
    this.cum.a(paramString);
    AppMethodBeat.o(146854);
  }
  
  public final boolean dK(String paramString)
  {
    return false;
  }
  
  public final boolean k(int paramInt, String paramString)
  {
    AppMethodBeat.i(146861);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "{}";
    }
    this.cum.af(paramInt, str);
    AppMethodBeat.o(146861);
    return true;
  }
  
  static final class a
    implements b.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.k
 * JD-Core Version:    0.7.0.1
 */