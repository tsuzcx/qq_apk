package com.tencent.luggage.sdk.b.a.d;

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
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.protocal.protobuf.gcg;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class k<SERVICE extends d>
  extends f<SERVICE>
  implements l
{
  public static final b.a esX;
  private q emf;
  private o esY;
  
  static
  {
    AppMethodBeat.i(146863);
    esX = new a((byte)0);
    AppMethodBeat.o(146863);
  }
  
  public k(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
    AppMethodBeat.i(146856);
    super.b(l.class, this);
    AppMethodBeat.o(146856);
  }
  
  protected final void apC()
  {
    AppMethodBeat.i(146860);
    arx();
    AppMethodBeat.o(146860);
  }
  
  protected final void apD() {}
  
  public final String aph()
  {
    AppMethodBeat.i(146855);
    Object localObject = ((d)aqX()).arC();
    String str = ((d)aqX()).aqZ().getAppConfig().qVW;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(146855);
    return localObject;
  }
  
  public final boolean apj()
  {
    return false;
  }
  
  protected final i apk()
  {
    AppMethodBeat.i(146857);
    this.emf = new q();
    q localq = this.emf;
    AppMethodBeat.o(146857);
    return localq;
  }
  
  public final void apw()
  {
    AppMethodBeat.i(146859);
    super.apw();
    this.emf.rdV.bringToFront();
    AppMethodBeat.o(146859);
  }
  
  public final boolean arD()
  {
    return true;
  }
  
  protected final boolean arM()
  {
    return false;
  }
  
  protected final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146858);
    super.c(paramAppBrandRuntime);
    ((d)aqX()).cpF();
    if (x.reA != null)
    {
      this.esY = x.reA;
      x.reA = null;
    }
    for (;;)
    {
      this.esY.a((d)aqX(), ((d)aqX()).aqZ().asA().extInfo);
      this.esY.eoY = ((d)aqX()).aqZ().asA().eoY;
      this.emf.a(this.esY);
      AppMethodBeat.o(146858);
      return;
      this.esY = new o();
    }
  }
  
  public final void eU(String paramString)
  {
    AppMethodBeat.i(146854);
    Log.d("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", new Object[] { paramString });
    gcg localgcg = new gcg();
    localgcg.acau = ((d)aqX()).arB().getComponentId();
    localgcg.rRQ = paramString;
    paramString = x.a(localgcg, this.esY, "domEvent");
    this.emf.a(paramString);
    AppMethodBeat.o(146854);
  }
  
  public final boolean eV(String paramString)
  {
    return false;
  }
  
  public final boolean g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146862);
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "{}";
    }
    Log.d("Luggage.MPRemoteDebugServiceLogic", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(paramInt) });
    this.emf.rdR = paramString1;
    q localq = this.emf;
    paramString2 = str;
    if (TextUtils.isEmpty(str)) {
      paramString2 = "{}";
    }
    if (paramInt == 0) {}
    for (str = "undefined";; str = String.valueOf(paramInt))
    {
      localq.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { "WeixinJSBridge", "WeixinJSBridge", paramString1, paramString2, str, di.aZl() }), null);
      AppMethodBeat.o(146862);
      return true;
    }
  }
  
  public final boolean k(int paramInt, String paramString)
  {
    AppMethodBeat.i(146861);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "{}";
    }
    this.emf.ao(paramInt, str);
    AppMethodBeat.o(146861);
    return true;
  }
  
  static final class a
    implements b.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.k
 * JD-Core Version:    0.7.0.1
 */