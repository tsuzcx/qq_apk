package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.m.p;
import com.tencent.mm.plugin.appbrand.m.p.2;
import com.tencent.mm.plugin.appbrand.m.p.a;
import com.tencent.mm.plugin.appbrand.m.p.b;
import com.tencent.mm.plugin.appbrand.m.p.c;
import com.tencent.mm.sdk.g.a.e;
import java.util.concurrent.atomic.AtomicInteger;

final class i$a
  implements p.b
{
  c gOO;
  AtomicInteger hUg;
  AtomicInteger hUh;
  
  i$a(i parami, c paramc)
  {
    AppMethodBeat.i(108065);
    this.hUg = new AtomicInteger();
    this.hUh = new AtomicInteger();
    this.gOO = paramc;
    AppMethodBeat.o(108065);
  }
  
  public final void a(p.c paramc)
  {
    AppMethodBeat.i(108070);
    com.tencent.luggage.g.d.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
    p localp = p.itw;
    p.a local1 = new p.a()
    {
      public final void c(p.c paramAnonymousc)
      {
        AppMethodBeat.i(108063);
        com.tencent.luggage.g.d.i("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
        a.c(i.a.this.gOO, paramAnonymousc);
        AppMethodBeat.o(108063);
      }
      
      public final void d(p.c paramAnonymousc)
      {
        AppMethodBeat.i(108064);
        com.tencent.luggage.g.d.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
        a.a(i.a.this.gOO, paramAnonymousc);
        AppMethodBeat.o(108064);
      }
    };
    com.tencent.mm.sdk.g.d.ysm.b(new p.2(localp, paramc, local1), "LocalServiceMgr#resolveService");
    AppMethodBeat.o(108070);
  }
  
  public final void aDU()
  {
    AppMethodBeat.i(108066);
    this.gOO.h(this.hUg.get(), this.hUe.j("fail", null));
    com.tencent.luggage.g.d.i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
    AppMethodBeat.o(108066);
  }
  
  public final void aDV()
  {
    AppMethodBeat.i(108067);
    this.gOO.h(this.hUh.get(), this.hUe.j("fail", null));
    com.tencent.luggage.g.d.i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
    AppMethodBeat.o(108067);
  }
  
  public final void aDW()
  {
    AppMethodBeat.i(108068);
    this.gOO.h(this.hUg.get(), this.hUe.j("ok", null));
    com.tencent.luggage.g.d.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
    AppMethodBeat.o(108068);
  }
  
  public final void aDX()
  {
    AppMethodBeat.i(108069);
    com.tencent.luggage.g.d.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
    this.gOO.h(this.hUh.get(), this.hUe.j("ok", null));
    a.t(this.gOO);
    AppMethodBeat.o(108069);
  }
  
  public final void b(p.c paramc)
  {
    AppMethodBeat.i(108071);
    a.b(this.gOO, paramc);
    AppMethodBeat.o(108071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.i.a
 * JD-Core Version:    0.7.0.1
 */