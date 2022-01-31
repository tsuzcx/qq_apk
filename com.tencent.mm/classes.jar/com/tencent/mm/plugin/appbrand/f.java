package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.plugin.appbrand.v.l.a;
import com.tencent.mm.plugin.appbrand.v.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends e
{
  f(o paramo, com.tencent.mm.plugin.appbrand.i.l paraml)
  {
    super(paramo, paraml);
  }
  
  protected final d Zo()
  {
    d locald = super.Zo();
    if (locald != null) {
      locald.setJsExceptionHandler(new f.3(this, locald));
    }
    return locald;
  }
  
  protected final String Zp()
  {
    return "WASubContext.js";
  }
  
  protected final String Zq()
  {
    return WxaCommLibRuntimeReader.qX("WASubContext.js");
  }
  
  protected final int Zr()
  {
    return WxaCommLibRuntimeReader.abQ().fEN;
  }
  
  protected final void Zs()
  {
    h.nFQ.a(370L, 39L, 1L, false);
    c.a(this.fxC.mAppId, this.fxC.getRuntime().ZB().fPS.fEN, this.fxC.getRuntime().ZB().fPS.fEM, 370, 39);
  }
  
  protected final void Zt()
  {
    h.nFQ.a(370L, 48L, 1L, false);
    c.a(this.fxC.mAppId, this.fxC.getRuntime().ZB().fPS.fEN, this.fxC.getRuntime().ZB().fPS.fEM, 370, 48);
  }
  
  protected final void a(com.tencent.mm.plugin.appbrand.i.f paramf, String paramString1, String paramString2)
  {
    y.i("MicroMsg.AppBrandJSContextInterfaceWC", "hy: injectSdkScript %s", new Object[] { paramString1 });
    long l = System.currentTimeMillis();
    boolean bool = this.fxC.aan();
    com.tencent.mm.plugin.appbrand.v.l.a(this.fxC, paramf, paramString1, paramString1, "v" + WxaCommLibRuntimeReader.abQ().fEN, paramString2, l.a.hlv, new f.2(this, bool, l, paramString1, paramString2));
    p.a(this.fxC.getRuntime(), paramf);
  }
  
  protected final void a(com.tencent.mm.plugin.appbrand.i.f paramf, String paramString1, String paramString2, k.a parama)
  {
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.appbrand.v.l.a(this.fxC.getRuntime(), paramf, paramString1, paramString2, l.a.hlw, new f.1(this, paramString1, paramString2, l, parama));
  }
  
  protected final void cC(boolean paramBoolean)
  {
    h.nFQ.a(370L, 40L, 1L, false);
    if (paramBoolean) {
      h.nFQ.a(370L, 41L, 1L, false);
    }
    do
    {
      return;
      h.nFQ.a(370L, 42L, 1L, false);
    } while (this.fxC.getRuntime() == null);
    c.a(this.fxC.mAppId, this.fxC.getRuntime().ZB().fPS.fEN, this.fxC.getRuntime().ZB().fPS.fEM, 370, 42);
  }
  
  protected final void cD(boolean paramBoolean)
  {
    h.nFQ.a(370L, 44L, 1L, false);
    if (paramBoolean)
    {
      h.nFQ.a(370L, 45L, 1L, false);
      return;
    }
    h.nFQ.a(370L, 46L, 1L, false);
    c.a(this.fxC.mAppId, this.fxC.getRuntime().ZB().fPS.fEN, this.fxC.getRuntime().ZB().fPS.fEM, 370, 46);
  }
  
  public final int create(String paramString)
  {
    int i = super.create(paramString);
    y.i("MicroMsg.AppBrandJSContextInterfaceWC", "hy: on create new context, id is %d", new Object[] { Integer.valueOf(i) });
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f
 * JD-Core Version:    0.7.0.1
 */