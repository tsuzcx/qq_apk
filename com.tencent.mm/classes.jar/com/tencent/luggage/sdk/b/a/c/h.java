package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.debugger.l;
import com.tencent.mm.plugin.appbrand.debugger.n;
import com.tencent.mm.plugin.appbrand.debugger.u;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.jsapi.cg;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public class h<SERVICE extends c>
  extends e<SERVICE>
  implements com.tencent.mm.plugin.appbrand.debugger.i
{
  public static final b.a ceG;
  private n bZF;
  private l ceH;
  
  static
  {
    AppMethodBeat.i(146863);
    ceG = new a((byte)0);
    AppMethodBeat.o(146863);
  }
  
  public h(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
    AppMethodBeat.i(146856);
    super.b(com.tencent.mm.plugin.appbrand.debugger.i.class, this);
    AppMethodBeat.o(146856);
  }
  
  protected final void BE()
  {
    AppMethodBeat.i(146860);
    Dj();
    AppMethodBeat.o(146860);
  }
  
  protected final void BF() {}
  
  public final String Bj()
  {
    AppMethodBeat.i(146855);
    Object localObject = ((c)CM()).Do();
    String str = ((c)CM()).CO().getAppConfig().jBO;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(146855);
    return localObject;
  }
  
  public final boolean Bl()
  {
    return false;
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsruntime.i Bm()
  {
    AppMethodBeat.i(146857);
    this.bZF = new n();
    n localn = this.bZF;
    AppMethodBeat.o(146857);
    return localn;
  }
  
  public final void By()
  {
    AppMethodBeat.i(146859);
    super.By();
    this.bZF.jHl.bringToFront();
    AppMethodBeat.o(146859);
  }
  
  public final void bX(String paramString)
  {
    AppMethodBeat.i(146854);
    ac.d("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", new Object[] { paramString });
    dtq localdtq = new dtq();
    localdtq.GbL = ((c)CM()).Dn().aUT();
    localdtq.GbK = paramString;
    paramString = u.a(localdtq, this.ceH, "domEvent");
    this.bZF.a(paramString);
    AppMethodBeat.o(146854);
  }
  
  protected final void bY(String paramString) {}
  
  protected final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146858);
    ((c)CM()).bey();
    if (u.jHL != null)
    {
      this.ceH = u.jHL;
      u.jHL = null;
    }
    for (;;)
    {
      this.ceH.a((c)CM(), ((c)CM()).CO().DC().extInfo);
      this.bZF.a(this.ceH);
      AppMethodBeat.o(146858);
      return;
      this.ceH = new l();
    }
  }
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146862);
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "{}";
    }
    ac.d("Luggage.MPRemoteDebugServiceLogic", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(paramInt) });
    this.bZF.jHg = paramString1;
    n localn = this.bZF;
    paramString2 = str;
    if (TextUtils.isEmpty(str)) {
      paramString2 = "{}";
    }
    if (paramInt == 0) {}
    for (str = "undefined";; str = String.valueOf(paramInt))
    {
      localn.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { "WeixinJSBridge", "WeixinJSBridge", paramString1, paramString2, str, cg.afA() }), null);
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
    this.bZF.X(paramInt, str);
    AppMethodBeat.o(146861);
    return true;
  }
  
  static final class a
    implements b.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.h
 * JD-Core Version:    0.7.0.1
 */