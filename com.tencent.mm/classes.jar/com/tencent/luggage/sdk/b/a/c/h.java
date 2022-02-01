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
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class h<SERVICE extends c>
  extends e<SERVICE>
  implements com.tencent.mm.plugin.appbrand.debugger.i
{
  public static final b.a chL;
  private n ccI;
  private l chM;
  
  static
  {
    AppMethodBeat.i(146863);
    chL = new a((byte)0);
    AppMethodBeat.o(146863);
  }
  
  public h(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
    AppMethodBeat.i(146856);
    super.b(com.tencent.mm.plugin.appbrand.debugger.i.class, this);
    AppMethodBeat.o(146856);
  }
  
  public final String BF()
  {
    AppMethodBeat.i(146855);
    Object localObject = ((c)Dj()).DL();
    String str = ((c)Dj()).Dl().getAppConfig().jbB;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(146855);
    return localObject;
  }
  
  public final boolean BH()
  {
    return false;
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsruntime.i BI()
  {
    AppMethodBeat.i(146857);
    this.ccI = new n();
    n localn = this.ccI;
    AppMethodBeat.o(146857);
    return localn;
  }
  
  public final void BU()
  {
    AppMethodBeat.i(146859);
    super.BU();
    this.ccI.jgW.bringToFront();
    AppMethodBeat.o(146859);
  }
  
  protected final void Ca()
  {
    AppMethodBeat.i(146860);
    DG();
    AppMethodBeat.o(146860);
  }
  
  protected final void Cb() {}
  
  protected final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146858);
    ((c)Dj()).aXB();
    if (u.jhw != null)
    {
      this.chM = u.jhw;
      u.jhw = null;
    }
    for (;;)
    {
      this.chM.a((c)Dj(), ((c)Dj()).Dl().DZ().extInfo);
      this.ccI.a(this.chM);
      AppMethodBeat.o(146858);
      return;
      this.chM = new l();
    }
  }
  
  public final void ch(String paramString)
  {
    AppMethodBeat.i(146854);
    ad.d("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", new Object[] { paramString });
    dnz localdnz = new dnz();
    localdnz.EEy = ((c)Dj()).DK().aOd();
    localdnz.EEx = paramString;
    paramString = u.a(localdnz, this.chM, "domEvent");
    this.ccI.a(paramString);
    AppMethodBeat.o(146854);
  }
  
  protected final void ci(String paramString) {}
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146862);
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "{}";
    }
    ad.d("Luggage.MPRemoteDebugServiceLogic", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(paramInt) });
    this.ccI.jgR = paramString1;
    n localn = this.ccI;
    paramString2 = str;
    if (TextUtils.isEmpty(str)) {
      paramString2 = "{}";
    }
    if (paramInt == 0) {}
    for (str = "undefined";; str = String.valueOf(paramInt))
    {
      localn.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { "WeixinJSBridge", "WeixinJSBridge", paramString1, paramString2, str, cg.aek() }), null);
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
    this.ccI.W(paramInt, str);
    AppMethodBeat.o(146861);
    return true;
  }
  
  static final class a
    implements b.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.h
 * JD-Core Version:    0.7.0.1
 */