package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.net.nsd.NsdManager;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.s.p;
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
  extends c<e>
{
  public static final int CTRL_INDEX = 529;
  public static final String NAME = "operateLocalServicesScan";
  final Map<String, a> pew;
  
  public f()
  {
    AppMethodBeat.i(144239);
    this.pew = new ConcurrentHashMap();
    AppMethodBeat.o(144239);
  }
  
  static String h(e parame, String paramString)
  {
    AppMethodBeat.i(144241);
    parame = parame.getAppId() + "#" + paramString;
    AppMethodBeat.o(144241);
    return parame;
  }
  
  public final void a(final e parame, JSONObject arg2, int paramInt)
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
        parame.j(paramInt, h("fail:invalid param", null));
        AppMethodBeat.o(144240);
        return;
      }
      synchronized (this.pew)
      {
        localObject2 = this.pew.keySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((String)((Iterator)localObject2).next()).contains(parame.getAppId()))
          {
            parame.j(paramInt, h("fail:scan task already exist", null));
            AppMethodBeat.o(144240);
            return;
          }
        }
        ??? = new a(parame);
        ((a)???).peB.set(paramInt);
        this.pew.put(h(parame, ???), ???);
        localObject2 = p.qjN;
        NsdManager localNsdManager = p.ccb();
        p.1 local1 = new p.1((p)localObject2, (p.b)???);
        ((p)localObject2).qjO.put(???, local1);
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
                synchronized (f.this.pew)
                {
                  if (!f.this.pew.containsKey(f.h(f.1.this.ozm, f.1.this.pex)))
                  {
                    Log.i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
                    AppMethodBeat.o(144228);
                    return;
                  }
                  p.qjN.a(f.1.this.pey);
                  f.this.pew.remove(f.h(f.1.this.ozm, f.1.this.pex));
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
      synchronized (this.pew)
      {
        ??? = this.pew.values().iterator();
        for (int i = 1; ((Iterator)???).hasNext(); i = 0)
        {
          localObject2 = (a)((Iterator)???).next();
          ((a)localObject2).peC.set(paramInt);
          p.qjN.a((p.b)localObject2);
        }
        if (i != 0) {
          parame.j(paramInt, h("fail:task not found", null));
        }
        this.pew.clear();
        AppMethodBeat.o(144240);
        return;
      }
    }
    parame.j(paramInt, h("fail:invalid param", null));
    AppMethodBeat.o(144240);
  }
  
  final class a
    implements p.b
  {
    e nsD;
    AtomicInteger peB;
    AtomicInteger peC;
    
    a(e parame)
    {
      AppMethodBeat.i(144232);
      this.peB = new AtomicInteger();
      this.peC = new AtomicInteger();
      this.nsD = parame;
      AppMethodBeat.o(144232);
    }
    
    public final void a(p.c paramc)
    {
      AppMethodBeat.i(144237);
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
      p localp = p.qjN;
      p.a local1 = new p.a()
      {
        public final void c(p.c paramAnonymousc)
        {
          AppMethodBeat.i(144230);
          Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
          a.c(f.a.this.nsD, paramAnonymousc);
          AppMethodBeat.o(144230);
        }
        
        public final void d(p.c paramAnonymousc)
        {
          AppMethodBeat.i(144231);
          Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
          a.a(f.a.this.nsD, paramAnonymousc);
          AppMethodBeat.o(144231);
        }
      };
      h.ZvG.d(new p.2(localp, paramc, local1), "LocalServiceMgr#resolveService");
      AppMethodBeat.o(144237);
    }
    
    public final void b(p.c paramc)
    {
      AppMethodBeat.i(144238);
      a.b(this.nsD, paramc);
      AppMethodBeat.o(144238);
    }
    
    public final void bTn()
    {
      AppMethodBeat.i(144233);
      this.nsD.j(this.peB.get(), f.this.h("fail", null));
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
      AppMethodBeat.o(144233);
    }
    
    public final void bTo()
    {
      AppMethodBeat.i(144234);
      this.nsD.j(this.peC.get(), f.this.h("fail", null));
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
      AppMethodBeat.o(144234);
    }
    
    public final void bTp()
    {
      AppMethodBeat.i(144235);
      this.nsD.j(this.peB.get(), f.this.h("ok", null));
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
      AppMethodBeat.o(144235);
    }
    
    public final void bTq()
    {
      AppMethodBeat.i(144236);
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
      this.nsD.j(this.peC.get(), f.this.h("ok", null));
      a.w(this.nsD);
      AppMethodBeat.o(144236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.f
 * JD-Core Version:    0.7.0.1
 */