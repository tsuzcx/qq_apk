package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.debugger.l;
import com.tencent.mm.plugin.appbrand.debugger.n;
import com.tencent.mm.plugin.appbrand.debugger.p;
import com.tencent.mm.plugin.appbrand.debugger.t;
import com.tencent.mm.plugin.appbrand.debugger.u;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.protocal.protobuf.cty;
import org.json.JSONObject;

public class g<SERVICE extends c>
  extends e<SERVICE>
  implements com.tencent.mm.plugin.appbrand.debugger.i
{
  public static final b.a bEQ;
  private n bBg;
  private l bER;
  
  static
  {
    AppMethodBeat.i(140792);
    bEQ = new g.a((byte)0);
    AppMethodBeat.o(140792);
  }
  
  public g(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
    AppMethodBeat.i(140785);
    super.b(com.tencent.mm.plugin.appbrand.debugger.i.class, this);
    AppMethodBeat.o(140785);
  }
  
  protected final void a(com.tencent.mm.plugin.appbrand.i parami)
  {
    AppMethodBeat.i(140787);
    ((c)this.bDN).aBr();
    if (t.hmt != null)
    {
      this.bER = t.hmt;
      t.hmt = null;
    }
    for (;;)
    {
      this.bER.a((c)this.bDN, ((c)this.bDN).wj().wS().extInfo);
      this.bBg.a(this.bER);
      AppMethodBeat.o(140787);
      return;
      this.bER = new l();
    }
  }
  
  public final void bS(String paramString)
  {
    AppMethodBeat.i(140783);
    d.d("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", new Object[] { paramString });
    cty localcty = new cty();
    localcty.ycT = ((c)this.bDN).wD().hashCode();
    localcty.ycS = paramString;
    paramString = t.a(localcty, this.bER, "domEvent");
    this.bBg.a(paramString);
    AppMethodBeat.o(140783);
  }
  
  protected final void bT(String paramString) {}
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(140791);
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "{}";
    }
    d.d("Luggage.MPRemoteDebugServiceLogic", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(paramInt) });
    this.bBg.hlN = paramString1;
    n localn = this.bBg;
    paramString2 = str;
    if (TextUtils.isEmpty(str)) {
      paramString2 = "{}";
    }
    if (paramInt == 0) {}
    for (str = "undefined";; str = String.valueOf(paramInt))
    {
      localn.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { "WeixinJSBridge", "WeixinJSBridge", paramString1, paramString2, str, bs.Qy() }), null);
      AppMethodBeat.o(140791);
      return true;
    }
  }
  
  public final boolean i(int paramInt, String paramString)
  {
    AppMethodBeat.i(140790);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "{}";
    }
    this.bBg.hlP.O(paramInt, str);
    AppMethodBeat.o(140790);
    return true;
  }
  
  protected final void tW()
  {
    AppMethodBeat.i(140789);
    ((c)this.bDN).auf();
    AppMethodBeat.o(140789);
  }
  
  public final String uO()
  {
    AppMethodBeat.i(140784);
    Object localObject = ((c)this.bDN).wE();
    String str = ((c)this.bDN).wj().getAppConfig().hgZ;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(140784);
    return localObject;
  }
  
  public final boolean uQ()
  {
    return false;
  }
  
  protected final com.tencent.mm.plugin.appbrand.i.i uR()
  {
    AppMethodBeat.i(140786);
    this.bBg = new n();
    n localn = this.bBg;
    AppMethodBeat.o(140786);
    return localn;
  }
  
  public final void vb()
  {
    AppMethodBeat.i(140788);
    super.vb();
    this.bBg.hlR.bringToFront();
    AppMethodBeat.o(140788);
  }
  
  protected final void vj() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.g
 * JD-Core Version:    0.7.0.1
 */