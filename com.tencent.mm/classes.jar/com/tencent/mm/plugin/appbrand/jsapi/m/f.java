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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
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
  final Map<String, a> lba;
  
  public f()
  {
    AppMethodBeat.i(144239);
    this.lba = new ConcurrentHashMap();
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
    ae.i("MicroMsg.JsApiOperateLocalServicesScan", "action = ".concat(String.valueOf(???)));
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
      synchronized (this.lba)
      {
        localObject2 = this.lba.keySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((String)((Iterator)localObject2).next()).contains(paramc.getAppId()))
          {
            paramc.h(paramInt, e("fail:scan task already exist", null));
            AppMethodBeat.o(144240);
            return;
          }
        }
        ??? = new a(paramc);
        ((a)???).lbf.set(paramInt);
        this.lba.put(h(paramc, ???), ???);
        localObject2 = p.mbp;
        NsdManager localNsdManager = p.bud();
        p.1 local1 = new p.1((p)localObject2, (p.b)???);
        ((p)localObject2).mbq.put(???, local1);
        localNsdManager.discoverServices(???, 1, local1);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(144229);
            b.c(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(144228);
                synchronized (f.this.lba)
                {
                  if (!f.this.lba.containsKey(f.h(f.1.this.kzs, f.1.this.lbb)))
                  {
                    ae.i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
                    AppMethodBeat.o(144228);
                    return;
                  }
                  p.mbp.a(f.1.this.lbc);
                  f.this.lba.remove(f.h(f.1.this.kzs, f.1.this.lbb));
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
      synchronized (this.lba)
      {
        ??? = this.lba.values().iterator();
        for (int i = 1; ((Iterator)???).hasNext(); i = 0)
        {
          localObject2 = (a)((Iterator)???).next();
          ((a)localObject2).lbg.set(paramInt);
          p.mbp.a((p.b)localObject2);
        }
        if (i != 0) {
          paramc.h(paramInt, e("fail:task not found", null));
        }
        this.lba.clear();
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
    c jyJ;
    AtomicInteger lbf;
    AtomicInteger lbg;
    
    a(c paramc)
    {
      AppMethodBeat.i(144232);
      this.lbf = new AtomicInteger();
      this.lbg = new AtomicInteger();
      this.jyJ = paramc;
      AppMethodBeat.o(144232);
    }
    
    public final void a(p.c paramc)
    {
      AppMethodBeat.i(144237);
      ae.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
      p localp = p.mbp;
      p.a local1 = new p.a()
      {
        public final void c(p.c paramAnonymousc)
        {
          AppMethodBeat.i(144230);
          ae.i("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
          a.c(f.a.this.jyJ, paramAnonymousc);
          AppMethodBeat.o(144230);
        }
        
        public final void d(p.c paramAnonymousc)
        {
          AppMethodBeat.i(144231);
          ae.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
          a.a(f.a.this.jyJ, paramAnonymousc);
          AppMethodBeat.o(144231);
        }
      };
      h.MqF.f(new p.2(localp, paramc, local1), "LocalServiceMgr#resolveService");
      AppMethodBeat.o(144237);
    }
    
    public final void b(p.c paramc)
    {
      AppMethodBeat.i(144238);
      a.b(this.jyJ, paramc);
      AppMethodBeat.o(144238);
    }
    
    public final void bmf()
    {
      AppMethodBeat.i(144233);
      this.jyJ.h(this.lbf.get(), f.this.e("fail", null));
      ae.i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
      AppMethodBeat.o(144233);
    }
    
    public final void bmg()
    {
      AppMethodBeat.i(144234);
      this.jyJ.h(this.lbg.get(), f.this.e("fail", null));
      ae.i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
      AppMethodBeat.o(144234);
    }
    
    public final void bmh()
    {
      AppMethodBeat.i(144235);
      this.jyJ.h(this.lbf.get(), f.this.e("ok", null));
      ae.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
      AppMethodBeat.o(144235);
    }
    
    public final void bmi()
    {
      AppMethodBeat.i(144236);
      ae.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
      this.jyJ.h(this.lbg.get(), f.this.e("ok", null));
      a.t(this.jyJ);
      AppMethodBeat.o(144236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.f
 * JD-Core Version:    0.7.0.1
 */