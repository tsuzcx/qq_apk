package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.net.nsd.NsdManager;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q.p;
import com.tencent.mm.plugin.appbrand.q.p.1;
import com.tencent.mm.plugin.appbrand.q.p.2;
import com.tencent.mm.plugin.appbrand.q.p.a;
import com.tencent.mm.plugin.appbrand.q.p.b;
import com.tencent.mm.plugin.appbrand.q.p.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class h
  extends a<c>
{
  public static final int CTRL_INDEX = 529;
  public static final String NAME = "operateLocalServicesScan";
  final Map<String, a> kax;
  
  public h()
  {
    AppMethodBeat.i(144239);
    this.kax = new ConcurrentHashMap();
    AppMethodBeat.o(144239);
  }
  
  static String h(c paramc, String paramString)
  {
    AppMethodBeat.i(144241);
    paramc = paramc.getAppId() + "#" + paramString;
    AppMethodBeat.o(144241);
    return paramc;
  }
  
  public final void a(final c paramc, JSONObject arg2, int paramInt)
  {
    AppMethodBeat.i(144240);
    ??? = ???.optString("action");
    ad.i("MicroMsg.JsApiOperateLocalServicesScan", "action = ".concat(String.valueOf(???)));
    Object localObject2;
    if (TextUtils.equals("start", (CharSequence)???))
    {
      ??? = ???.optString("serviceType");
      if (TextUtils.isEmpty(???))
      {
        paramc.h(paramInt, e("fail:invalid param", null));
        AppMethodBeat.o(144240);
        return;
      }
      synchronized (this.kax)
      {
        localObject2 = this.kax.keySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((String)((Iterator)localObject2).next()).contains(paramc.getAppId()))
          {
            paramc.h(paramInt, e("fail:scan task already exist", null));
            AppMethodBeat.o(144240);
            return;
          }
        }
        ??? = new a(paramc);
        ((a)???).kaC.set(paramInt);
        this.kax.put(h(paramc, ???), ???);
        localObject2 = p.kVL;
        NsdManager localNsdManager = p.biz();
        p.1 local1 = new p.1((p)localObject2, (p.b)???);
        ((p)localObject2).kVM.put(???, local1);
        localNsdManager.discoverServices(???, 1, local1);
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(144229);
            com.tencent.mm.sdk.g.b.c(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(144228);
                synchronized (h.this.kax)
                {
                  if (!h.this.kax.containsKey(h.h(h.1.this.jBi, h.1.this.kay)))
                  {
                    ad.i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
                    AppMethodBeat.o(144228);
                    return;
                  }
                  p.kVL.a(h.1.this.kaz);
                  h.this.kax.remove(h.h(h.1.this.jBi, h.1.this.kay));
                  AppMethodBeat.o(144228);
                  return;
                }
              }
            }, "stopScanServices");
            AppMethodBeat.o(144229);
          }
        }, 30000L);
        AppMethodBeat.o(144240);
        return;
      }
    }
    if (TextUtils.equals("stop", (CharSequence)???)) {
      synchronized (this.kax)
      {
        ??? = this.kax.values().iterator();
        for (int i = 1; ((Iterator)???).hasNext(); i = 0)
        {
          localObject2 = (a)((Iterator)???).next();
          ((a)localObject2).kaD.set(paramInt);
          p.kVL.a((p.b)localObject2);
        }
        if (i != 0) {
          paramc.h(paramInt, e("fail:task not found", null));
        }
        this.kax.clear();
        AppMethodBeat.o(144240);
        return;
      }
    }
    paramc.h(paramInt, e("fail:invalid param", null));
    AppMethodBeat.o(144240);
  }
  
  final class a
    implements p.b
  {
    c iCF;
    AtomicInteger kaC;
    AtomicInteger kaD;
    
    a(c paramc)
    {
      AppMethodBeat.i(144232);
      this.kaC = new AtomicInteger();
      this.kaD = new AtomicInteger();
      this.iCF = paramc;
      AppMethodBeat.o(144232);
    }
    
    public final void a(p.c paramc)
    {
      AppMethodBeat.i(144237);
      ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
      p localp = p.kVL;
      p.a local1 = new p.a()
      {
        public final void c(p.c paramAnonymousc)
        {
          AppMethodBeat.i(144230);
          ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
          b.c(h.a.this.iCF, paramAnonymousc);
          AppMethodBeat.o(144230);
        }
        
        public final void d(p.c paramAnonymousc)
        {
          AppMethodBeat.i(144231);
          ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
          b.a(h.a.this.iCF, paramAnonymousc);
          AppMethodBeat.o(144231);
        }
      };
      com.tencent.e.h.Iye.f(new p.2(localp, paramc, local1), "LocalServiceMgr#resolveService");
      AppMethodBeat.o(144237);
    }
    
    public final void b(p.c paramc)
    {
      AppMethodBeat.i(144238);
      b.b(this.iCF, paramc);
      AppMethodBeat.o(144238);
    }
    
    public final void baX()
    {
      AppMethodBeat.i(144233);
      this.iCF.h(this.kaC.get(), h.this.e("fail", null));
      ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
      AppMethodBeat.o(144233);
    }
    
    public final void baY()
    {
      AppMethodBeat.i(144234);
      this.iCF.h(this.kaD.get(), h.this.e("fail", null));
      ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
      AppMethodBeat.o(144234);
    }
    
    public final void baZ()
    {
      AppMethodBeat.i(144235);
      this.iCF.h(this.kaC.get(), h.this.e("ok", null));
      ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
      AppMethodBeat.o(144235);
    }
    
    public final void bba()
    {
      AppMethodBeat.i(144236);
      ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
      this.iCF.h(this.kaD.get(), h.this.e("ok", null));
      b.u(this.iCF);
      AppMethodBeat.o(144236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.h
 * JD-Core Version:    0.7.0.1
 */