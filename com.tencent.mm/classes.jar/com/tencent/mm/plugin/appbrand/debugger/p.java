package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  extends com.tencent.mm.plugin.appbrand.p
{
  l fSN;
  j fSm;
  
  public final void C(int paramInt, String paramString)
  {
    String str = paramString;
    if (bk.bl(paramString)) {
      str = "{}";
    }
    this.fSN.fSp.B(paramInt, str);
  }
  
  protected final int a(f paramf, int paramInt)
  {
    return paramInt;
  }
  
  public final f aat()
  {
    this.fSN = new l();
    return this.fSN;
  }
  
  protected final void aav() {}
  
  protected final void cE(boolean paramBoolean)
  {
    super.cE(paramBoolean);
    this.fSN.fSq.bringToFront();
  }
  
  public final void g(i parami)
  {
    super.g(parami);
    ahM();
    if (r.fST != null)
    {
      this.fSm = r.fST;
      r.fST = null;
    }
    for (;;)
    {
      this.fSm.a(this, getRuntime().aac().extInfo);
      this.fSN.a(this.fSm);
      return;
      this.fSm = new j();
    }
  }
  
  public final void i(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (bk.bl(paramString2)) {
      str = "{}";
    }
    y.d("MicroMsg.RemoteDebugService", "dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(paramInt) });
    this.fSN.fSn = paramString1;
    l locall = this.fSN;
    if (paramInt == 0) {}
    for (paramString2 = "undefined";; paramString2 = String.valueOf(paramInt))
    {
      locall.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\" , %s, %s, %s)", new Object[] { paramString1, str, paramString2, bc.CG() }), null);
      return;
    }
  }
  
  protected final void pT()
  {
    aas();
  }
  
  public final void qJ(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.p
 * JD-Core Version:    0.7.0.1
 */