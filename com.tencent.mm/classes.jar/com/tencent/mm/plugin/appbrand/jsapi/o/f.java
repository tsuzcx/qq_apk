package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.net.nsd.NsdManager;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s.p.1;
import com.tencent.mm.plugin.appbrand.s.p.2;
import com.tencent.mm.plugin.appbrand.s.p.a;
import com.tencent.mm.plugin.appbrand.s.p.b;
import com.tencent.mm.plugin.appbrand.s.p.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class f
  extends d<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 529;
  public static final String NAME = "operateLocalServicesScan";
  final Map<String, a> mgp;
  
  public f()
  {
    AppMethodBeat.i(144239);
    this.mgp = new ConcurrentHashMap();
    AppMethodBeat.o(144239);
  }
  
  static String h(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(144241);
    paramf = paramf.getAppId() + "#" + paramString;
    AppMethodBeat.o(144241);
    return paramf;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject arg2, int paramInt)
  {
    AppMethodBeat.i(144240);
    ??? = ???.optString("action");
    Log.i("MicroMsg.JsApiOperateLocalServicesScan", "action = ".concat(String.valueOf(???)));
    Object localObject2;
    if (TextUtils.equals("start", (CharSequence)???))
    {
      ??? = ???.optString("serviceType");
      if (TextUtils.isEmpty(???))
      {
        paramf.i(paramInt, h("fail:invalid param", null));
        AppMethodBeat.o(144240);
        return;
      }
      synchronized (this.mgp)
      {
        localObject2 = this.mgp.keySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((String)((Iterator)localObject2).next()).contains(paramf.getAppId()))
          {
            paramf.i(paramInt, h("fail:scan task already exist", null));
            AppMethodBeat.o(144240);
            return;
          }
        }
        ??? = new a(paramf);
        ((a)???).mgv.set(paramInt);
        this.mgp.put(h(paramf, ???), ???);
        localObject2 = com.tencent.mm.plugin.appbrand.s.p.njc;
        NsdManager localNsdManager = com.tencent.mm.plugin.appbrand.s.p.bPK();
        p.1 local1 = new p.1((com.tencent.mm.plugin.appbrand.s.p)localObject2, (p.b)???);
        ((com.tencent.mm.plugin.appbrand.s.p)localObject2).njd.put(???, local1);
        localNsdManager.discoverServices(???, 1, local1);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(144229);
            ThreadPool.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(144228);
                synchronized (f.this.mgp)
                {
                  if (!f.this.mgp.containsKey(f.h(f.1.this.lDL, f.1.this.mgq)))
                  {
                    Log.i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
                    AppMethodBeat.o(144228);
                    return;
                  }
                  com.tencent.mm.plugin.appbrand.s.p.njc.a(f.1.this.mgs);
                  f.this.mgp.remove(f.h(f.1.this.lDL, f.1.this.mgq));
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
      synchronized (this.mgp)
      {
        ??? = this.mgp.values().iterator();
        for (int i = 1; ((Iterator)???).hasNext(); i = 0)
        {
          localObject2 = (a)((Iterator)???).next();
          ((a)localObject2).mgw.set(paramInt);
          com.tencent.mm.plugin.appbrand.s.p.njc.a((p.b)localObject2);
        }
        if (i != 0) {
          paramf.i(paramInt, h("fail:task not found", null));
        }
        this.mgp.clear();
        AppMethodBeat.o(144240);
        return;
      }
    }
    paramf.i(paramInt, h("fail:invalid param", null));
    AppMethodBeat.o(144240);
  }
  
  final class a
    implements p.b
  {
    com.tencent.mm.plugin.appbrand.jsapi.f kzr;
    AtomicInteger mgv;
    AtomicInteger mgw;
    
    a(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
    {
      AppMethodBeat.i(144232);
      this.mgv = new AtomicInteger();
      this.mgw = new AtomicInteger();
      this.kzr = paramf;
      AppMethodBeat.o(144232);
    }
    
    public final void a(p.c paramc)
    {
      AppMethodBeat.i(144237);
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
      com.tencent.mm.plugin.appbrand.s.p localp = com.tencent.mm.plugin.appbrand.s.p.njc;
      p.a local1 = new p.a()
      {
        public final void c(p.c paramAnonymousc)
        {
          AppMethodBeat.i(144230);
          Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
          a.c(f.a.this.kzr, paramAnonymousc);
          AppMethodBeat.o(144230);
        }
        
        public final void d(p.c paramAnonymousc)
        {
          AppMethodBeat.i(144231);
          Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
          a.a(f.a.this.kzr, paramAnonymousc);
          AppMethodBeat.o(144231);
        }
      };
      h.RTc.b(new p.2(localp, paramc, local1), "LocalServiceMgr#resolveService");
      AppMethodBeat.o(144237);
    }
    
    public final void b(p.c paramc)
    {
      AppMethodBeat.i(144238);
      a.b(this.kzr, paramc);
      AppMethodBeat.o(144238);
    }
    
    public final void bHE()
    {
      AppMethodBeat.i(144233);
      this.kzr.i(this.mgv.get(), f.this.h("fail", null));
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
      AppMethodBeat.o(144233);
    }
    
    public final void bHF()
    {
      AppMethodBeat.i(144234);
      this.kzr.i(this.mgw.get(), f.this.h("fail", null));
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
      AppMethodBeat.o(144234);
    }
    
    public final void bHG()
    {
      AppMethodBeat.i(144235);
      this.kzr.i(this.mgv.get(), f.this.h("ok", null));
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
      AppMethodBeat.o(144235);
    }
    
    public final void bHH()
    {
      AppMethodBeat.i(144236);
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
      this.kzr.i(this.mgw.get(), f.this.h("ok", null));
      a.t(this.kzr);
      AppMethodBeat.o(144236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.f
 * JD-Core Version:    0.7.0.1
 */