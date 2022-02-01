package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.net.nsd.NsdManager;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o.p;
import com.tencent.mm.plugin.appbrand.o.p.1;
import com.tencent.mm.plugin.appbrand.o.p.2;
import com.tencent.mm.plugin.appbrand.o.p.a;
import com.tencent.mm.plugin.appbrand.o.p.b;
import com.tencent.mm.plugin.appbrand.o.p.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 529;
  public static final String NAME = "operateLocalServicesScan";
  final Map<String, a> kXr;
  
  public f()
  {
    AppMethodBeat.i(144239);
    this.kXr = new ConcurrentHashMap();
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
      synchronized (this.kXr)
      {
        localObject2 = this.kXr.keySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((String)((Iterator)localObject2).next()).contains(paramc.getAppId()))
          {
            paramc.h(paramInt, e("fail:scan task already exist", null));
            AppMethodBeat.o(144240);
            return;
          }
        }
        ??? = new a(paramc);
        ((a)???).kXw.set(paramInt);
        this.kXr.put(h(paramc, ???), ???);
        localObject2 = p.lWJ;
        NsdManager localNsdManager = p.bts();
        p.1 local1 = new p.1((p)localObject2, (p.b)???);
        ((p)localObject2).lWK.put(???, local1);
        localNsdManager.discoverServices(???, 1, local1);
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(144229);
            b.c(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(144228);
                synchronized (f.this.kXr)
                {
                  if (!f.this.kXr.containsKey(f.h(f.1.this.kwd, f.1.this.kXs)))
                  {
                    ad.i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
                    AppMethodBeat.o(144228);
                    return;
                  }
                  p.lWJ.a(f.1.this.kXt);
                  f.this.kXr.remove(f.h(f.1.this.kwd, f.1.this.kXs));
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
      synchronized (this.kXr)
      {
        ??? = this.kXr.values().iterator();
        for (int i = 1; ((Iterator)???).hasNext(); i = 0)
        {
          localObject2 = (a)((Iterator)???).next();
          ((a)localObject2).kXx.set(paramInt);
          p.lWJ.a((p.b)localObject2);
        }
        if (i != 0) {
          paramc.h(paramInt, e("fail:task not found", null));
        }
        this.kXr.clear();
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
    c jvO;
    AtomicInteger kXw;
    AtomicInteger kXx;
    
    a(c paramc)
    {
      AppMethodBeat.i(144232);
      this.kXw = new AtomicInteger();
      this.kXx = new AtomicInteger();
      this.jvO = paramc;
      AppMethodBeat.o(144232);
    }
    
    public final void a(p.c paramc)
    {
      AppMethodBeat.i(144237);
      ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
      p localp = p.lWJ;
      p.a local1 = new p.a()
      {
        public final void c(p.c paramAnonymousc)
        {
          AppMethodBeat.i(144230);
          ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
          a.c(f.a.this.jvO, paramAnonymousc);
          AppMethodBeat.o(144230);
        }
        
        public final void d(p.c paramAnonymousc)
        {
          AppMethodBeat.i(144231);
          ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
          a.a(f.a.this.jvO, paramAnonymousc);
          AppMethodBeat.o(144231);
        }
      };
      h.LTJ.f(new p.2(localp, paramc, local1), "LocalServiceMgr#resolveService");
      AppMethodBeat.o(144237);
    }
    
    public final void b(p.c paramc)
    {
      AppMethodBeat.i(144238);
      a.b(this.jvO, paramc);
      AppMethodBeat.o(144238);
    }
    
    public final void blw()
    {
      AppMethodBeat.i(144233);
      this.jvO.h(this.kXw.get(), f.this.e("fail", null));
      ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
      AppMethodBeat.o(144233);
    }
    
    public final void blx()
    {
      AppMethodBeat.i(144234);
      this.jvO.h(this.kXx.get(), f.this.e("fail", null));
      ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
      AppMethodBeat.o(144234);
    }
    
    public final void bly()
    {
      AppMethodBeat.i(144235);
      this.jvO.h(this.kXw.get(), f.this.e("ok", null));
      ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
      AppMethodBeat.o(144235);
    }
    
    public final void blz()
    {
      AppMethodBeat.i(144236);
      ad.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
      this.jvO.h(this.kXx.get(), f.this.e("ok", null));
      a.t(this.jvO);
      AppMethodBeat.o(144236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.f
 * JD-Core Version:    0.7.0.1
 */