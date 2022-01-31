package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o.o;
import com.tencent.mm.plugin.appbrand.o.o.2;
import com.tencent.mm.plugin.appbrand.o.o.b;
import com.tencent.mm.plugin.appbrand.o.o.c;
import java.util.concurrent.atomic.AtomicInteger;

final class h$a
  implements o.b
{
  com.tencent.mm.plugin.appbrand.jsapi.c gxF;
  AtomicInteger gxG = new AtomicInteger();
  AtomicInteger gxH = new AtomicInteger();
  
  h$a(h paramh, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    this.gxF = paramc;
  }
  
  public final void a(o.c paramc)
  {
    com.tencent.luggage.j.c.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
    o localo = o.gRH;
    h.a.1 local1 = new h.a.1(this);
    NsdServiceInfo localNsdServiceInfo = new NsdServiceInfo();
    localNsdServiceInfo.setServiceName(paramc.gRN);
    localNsdServiceInfo.setServiceType(paramc.gRO);
    o.amO().resolveService(localNsdServiceInfo, new o.2(localo, local1));
  }
  
  public final void ajB()
  {
    this.gxF.C(this.gxG.get(), this.gxD.h("fail", null));
    com.tencent.luggage.j.c.i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
  }
  
  public final void ajC()
  {
    this.gxF.C(this.gxH.get(), this.gxD.h("fail", null));
    com.tencent.luggage.j.c.i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
  }
  
  public final void ajD()
  {
    this.gxF.C(this.gxG.get(), this.gxD.h("ok", null));
    com.tencent.luggage.j.c.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
  }
  
  public final void ajE()
  {
    com.tencent.luggage.j.c.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
    this.gxF.C(this.gxH.get(), this.gxD.h("ok", null));
    a.m(this.gxF);
  }
  
  public final void b(o.c paramc)
  {
    a.b(this.gxF, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.h.a
 * JD-Core Version:    0.7.0.1
 */