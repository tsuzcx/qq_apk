package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.debugger.j;
import com.tencent.mm.plugin.appbrand.debugger.m;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.debugger.w;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class h<SERVICE extends c>
  extends e<SERVICE>
  implements j
{
  public static final b.a coX;
  private o cjX;
  private m coY;
  
  static
  {
    AppMethodBeat.i(146863);
    coX = new a((byte)0);
    AppMethodBeat.o(146863);
  }
  
  public h(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
    AppMethodBeat.i(146856);
    super.b(j.class, this);
    AppMethodBeat.o(146856);
  }
  
  public final String CI()
  {
    AppMethodBeat.i(146855);
    Object localObject = ((c)El()).EN();
    String str = ((c)El()).En().getAppConfig().jVK;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(146855);
    return localObject;
  }
  
  public final boolean CK()
  {
    return false;
  }
  
  protected final i CL()
  {
    AppMethodBeat.i(146857);
    this.cjX = new o();
    o localo = this.cjX;
    AppMethodBeat.o(146857);
    return localo;
  }
  
  public final void CX()
  {
    AppMethodBeat.i(146859);
    super.CX();
    this.cjX.kbx.bringToFront();
    AppMethodBeat.o(146859);
  }
  
  protected final void Dd()
  {
    AppMethodBeat.i(146860);
    EI();
    AppMethodBeat.o(146860);
  }
  
  protected final void De() {}
  
  protected final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146858);
    ((c)El()).bic();
    if (v.kbX != null)
    {
      this.coY = v.kbX;
      v.kbX = null;
    }
    for (;;)
    {
      this.coY.a((c)El(), ((c)El()).En().Fb().extInfo);
      this.cjX.a(this.coY);
      AppMethodBeat.o(146858);
      return;
      this.coY = new m();
    }
  }
  
  public final void cR(String paramString)
  {
    AppMethodBeat.i(146854);
    ad.d("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", new Object[] { paramString });
    dzk localdzk = new dzk();
    localdzk.HMI = ((c)El()).EM().aXC();
    localdzk.HMH = paramString;
    paramString = v.a(localdzk, this.coY, "domEvent");
    this.cjX.a(paramString);
    AppMethodBeat.o(146854);
  }
  
  public final boolean cS(String paramString)
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
    ad.d("Luggage.MPRemoteDebugServiceLogic", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(paramInt) });
    this.cjX.kbs = paramString1;
    o localo = this.cjX;
    paramString2 = str;
    if (TextUtils.isEmpty(str)) {
      paramString2 = "{}";
    }
    if (paramInt == 0) {}
    for (str = "undefined";; str = String.valueOf(paramInt))
    {
      localo.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { "WeixinJSBridge", "WeixinJSBridge", paramString1, paramString2, str, cj.aim() }), null);
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
    this.cjX.Z(paramInt, str);
    AppMethodBeat.o(146861);
    return true;
  }
  
  static final class a
    implements b.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.h
 * JD-Core Version:    0.7.0.1
 */