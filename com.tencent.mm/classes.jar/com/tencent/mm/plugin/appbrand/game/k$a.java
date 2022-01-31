package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.v.l.a;
import com.tencent.mm.plugin.appbrand.v.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class k$a
  extends e
{
  k$a(k paramk, c paramc, com.tencent.mm.plugin.appbrand.i.l paraml)
  {
    super(paramc, paraml);
  }
  
  protected final void Zn()
  {
    super.Zn();
    y.i("MicroMsg.WAGameWeixinJSContextLogic", "hy: injected WAGameJSContextInterface");
  }
  
  protected final d Zo()
  {
    return super.Zo();
  }
  
  protected final String Zp()
  {
    return "WAGameSubContext.js";
  }
  
  protected final String Zq()
  {
    return WxaCommLibRuntimeReader.qX("WAGameSubContext.js");
  }
  
  protected final int Zr()
  {
    return WxaCommLibRuntimeReader.abQ().fEN;
  }
  
  protected final void Zs() {}
  
  protected final void Zt() {}
  
  protected final void a(f paramf, String paramString1, String paramString2)
  {
    y.i("MicroMsg.WAGameWeixinJSContextLogic", "hy: injectSdkScript %s", new Object[] { paramString1 });
    long l = System.currentTimeMillis();
    boolean bool = this.fxC.aan();
    com.tencent.mm.plugin.appbrand.v.l.a(this.fxC, paramf, paramString1, paramString1, "v" + WxaCommLibRuntimeReader.abQ().fEN, paramString2, l.a.hlv, new k.a.2(this, paramString1, bool, l, paramString2));
    p.a(this.fxC.getRuntime(), paramf);
  }
  
  protected final void a(f paramf, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.v.k.a parama)
  {
    y.i("MicroMsg.WAGameWeixinJSContextLogic", "hy: inject appscript from js context interface: %s", new Object[] { paramString1 });
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.appbrand.v.l.a(this.fxC.getRuntime(), paramf, paramString1, paramString1 + "_" + this.fxC.mAppId, this.fxC.getRuntime().ZB().fPS.bIW, paramString2, l.a.hlw, new k.a.1(this, paramString1, paramString2, l, parama));
  }
  
  protected final void cC(boolean paramBoolean)
  {
    h.nFQ.a(778L, 17L, 1L, false);
    if (paramBoolean)
    {
      h.nFQ.a(778L, 19L, 1L, false);
      return;
    }
    h.nFQ.a(778L, 18L, 1L, false);
    com.tencent.mm.plugin.appbrand.report.c.H(this.gat.gap.getRuntime().mAppId, 24, 0);
    com.tencent.mm.plugin.appbrand.report.c.a(this.gat.gap.mAppId, this.gat.gap.getRuntime().aaa().fPS.fEN, this.gat.gap.getRuntime().aaa().fPS.fEM, 778, 18);
  }
  
  protected final void cD(boolean paramBoolean)
  {
    h.nFQ.a(778L, 21L, 1L, false);
    if (paramBoolean)
    {
      h.nFQ.a(778L, 23L, 1L, false);
      return;
    }
    h.nFQ.a(778L, 22L, 1L, false);
    com.tencent.mm.plugin.appbrand.report.c.H(this.gat.gap.mAppId, 24, 0);
    com.tencent.mm.plugin.appbrand.report.c.a(this.gat.gap.mAppId, this.gat.gap.getRuntime().aaa().fPS.fEN, this.gat.gap.getRuntime().aaa().fPS.fEM, 778, 22);
  }
  
  protected final void qs(String paramString)
  {
    y.i("MicroMsg.WAGameWeixinJSContextLogic", "hy: onAppScriptInjectBegin path:%s", new Object[] { paramString });
    if ((!com.tencent.magicbrush.a.bl(paramString)) && (paramString.equals("game.js"))) {
      com.tencent.mm.plugin.appbrand.game.e.a.ahj().gcV = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.k.a
 * JD-Core Version:    0.7.0.1
 */