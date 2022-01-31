package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.i.t;
import com.tencent.mm.plugin.appbrand.i.u;
import com.tencent.mm.plugin.appbrand.i.y;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import java.util.Map;

public class b
  extends com.tencent.luggage.sdk.b.a.c.b<c>
{
  private com.tencent.mm.plugin.appbrand.n.b.a iJm = null;
  private com.tencent.luggage.game.a.a iJn = null;
  com.tencent.luggage.game.a.c iJo = null;
  
  public b(c paramc)
  {
    super(paramc);
  }
  
  public final com.tencent.luggage.sdk.b.a.c.a a(com.tencent.mm.plugin.appbrand.i.i parami, com.tencent.mm.plugin.appbrand.i.q paramq)
  {
    AppMethodBeat.i(143538);
    boolean bool = parami instanceof u;
    if ((ae.aum()) || (bool))
    {
      parami = new a((c)this.bDN, paramq);
      AppMethodBeat.o(143538);
      return parami;
    }
    AppMethodBeat.o(143538);
    return null;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.i parami)
  {
    AppMethodBeat.i(143544);
    super.a(parami);
    if (this.iJn != null) {
      this.iJn.a(parami, false);
    }
    AppMethodBeat.o(143544);
  }
  
  public final void u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(143537);
    super.u(paramString1, paramString2);
    try
    {
      com.tencent.mm.plugin.appbrand.report.g.a((c)this.bDN, paramString1, paramString2);
      AppMethodBeat.o(143537);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(143537);
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.i.i uR()
  {
    Object localObject3 = null;
    AppMethodBeat.i(143536);
    long l = System.currentTimeMillis();
    if (((c)this.bDN).getContext() == null) {
      ah.getContext();
    }
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lUe, false)) {}
    for (Object localObject1 = y.aAM();; localObject1 = null)
    {
      if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lUd, false)) {}
      for (Object localObject2 = com.tencent.mm.plugin.appbrand.s.d.Fk("wxa_library/v8_snapshot.bin");; localObject2 = null)
      {
        int i = WxaCommLibRuntimeReader.avI().gXf;
        ae.aum();
        localObject2 = t.d(i, (String)localObject1, (byte[])localObject2);
        if ((localObject2 instanceof u))
        {
          this.iJm = new com.tencent.mm.plugin.appbrand.n.a();
          localObject1 = this.iJm;
          r localr = (r)this.bDN;
          ab.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
          ((com.tencent.mm.plugin.appbrand.n.b.a)localObject1).iuk = new com.tencent.mm.plugin.appbrand.n.d(localr, (com.tencent.mm.plugin.appbrand.i.i)localObject2);
          ((com.tencent.mm.plugin.appbrand.i.i)localObject2).addJavascriptInterface(((com.tencent.mm.plugin.appbrand.n.b.a)localObject1).iuk, "gJavaBroker");
        }
        com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
        localObject1 = localObject3;
        if (((c)this.bDN).aud()) {
          localObject1 = com.tencent.mm.plugin.appbrand.task.g.iKS;
        }
        com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.task.g)localObject1, ((c)this.bDN).getAppId(), l, com.tencent.mm.plugin.appbrand.report.c.g((com.tencent.mm.plugin.appbrand.i.i)localObject2));
        AppMethodBeat.o(143536);
        return localObject2;
      }
    }
  }
  
  public final void uS()
  {
    AppMethodBeat.i(143543);
    super.uS();
    com.tencent.mm.plugin.appbrand.i.i locali = ((c)this.bDN).aAO();
    if (this.iJn != null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.luggage.g.d.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.iJn == null) {
        break;
      }
      AppMethodBeat.o(143543);
      return;
    }
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lUU, true))
    {
      this.iJn = new b.1(this, ((c)this.bDN).getContext());
      this.iJn.a(locali);
      if (((c)this.bDN).isRunning()) {
        this.iJn.a(((c)this.bDN).getRuntime(), false);
      }
    }
    AppMethodBeat.o(143543);
  }
  
  public final void uT()
  {
    AppMethodBeat.i(143541);
    super.uT();
    if (this.iJn != null) {
      this.iJn.cleanup();
    }
    AppMethodBeat.o(143541);
  }
  
  public final void uU()
  {
    AppMethodBeat.i(143542);
    if (this.iJm != null)
    {
      Object localObject = this.iJm;
      ab.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
      if (((com.tencent.mm.plugin.appbrand.n.b.a)localObject).iuk == null)
      {
        localObject = new IllegalStateException("You had not called whenCreateJsRuntime!");
        AppMethodBeat.o(143542);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.plugin.appbrand.n.b.a)localObject).iuk.aIz();
    }
    AppMethodBeat.o(143542);
  }
  
  public final Map<String, m> wM()
  {
    AppMethodBeat.i(143540);
    Map localMap = com.tencent.mm.plugin.appbrand.jsapi.q.aBx();
    AppMethodBeat.o(143540);
    return localMap;
  }
  
  public final String wx()
  {
    AppMethodBeat.i(143539);
    Object localObject1 = super.wx();
    if (this.iJm != null)
    {
      if ((com.tencent.mm.plugin.appbrand.w.b.aSw()) || (f.IS_FLAVOR_RED)) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = new StringBuilder().append((String)localObject1);
        localObject2 = this.iJm;
        ab.i("MicroMsg.AppBrandNodeJSInstallHelper", "getNodeInjectJs");
        if (((com.tencent.mm.plugin.appbrand.n.b.a)localObject2).iuk != null) {
          break;
        }
        localObject1 = new IllegalStateException("You had not called whenCreateJsRuntime!");
        AppMethodBeat.o(143539);
        throw ((Throwable)localObject1);
      }
      Object localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(String.format("var useSkiaCanvas = %s;", new Object[] { Boolean.valueOf(bool) }));
      ((StringBuffer)localObject2).append(com.tencent.mm.plugin.appbrand.s.d.Fj("wxa_library/node_jsapi.js"));
      localObject1 = ((StringBuffer)localObject2).toString();
    }
    for (;;)
    {
      if (this.iJn != null) {}
      for (localObject1 = (String)localObject1 + com.tencent.mm.plugin.appbrand.s.d.Fj("wxa_library/NativeGlobal-WAService.js");; localObject1 = (String)localObject1 + com.tencent.mm.plugin.appbrand.s.d.Fj("wxa_library/NativeGlobal-Dummy.js"))
      {
        AppMethodBeat.o(143539);
        return localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b
 * JD-Core Version:    0.7.0.1
 */