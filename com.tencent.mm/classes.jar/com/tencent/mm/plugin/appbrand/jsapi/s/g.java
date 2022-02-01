package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.net.nsd.NsdManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.o;
import com.tencent.mm.plugin.appbrand.t.o.1;
import com.tencent.mm.plugin.appbrand.t.o.2;
import com.tencent.mm.plugin.appbrand.t.o.a;
import com.tencent.mm.plugin.appbrand.t.o.b;
import com.tencent.mm.plugin.appbrand.t.o.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class g
  extends c<f>
{
  public static final int CTRL_INDEX = 529;
  public static final String NAME = "operateLocalServicesScan";
  final Map<String, a> sjN;
  
  public g()
  {
    AppMethodBeat.i(144239);
    this.sjN = new ConcurrentHashMap();
    AppMethodBeat.o(144239);
  }
  
  static String h(f paramf, String paramString)
  {
    AppMethodBeat.i(144241);
    paramf = paramf.getAppId() + "#" + paramString;
    AppMethodBeat.o(144241);
    return paramf;
  }
  
  public final void a(final f paramf, JSONObject arg2, int paramInt)
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
        paramf.callback(paramInt, ZP("fail:invalid param"));
        AppMethodBeat.o(144240);
        return;
      }
      synchronized (this.sjN)
      {
        localObject2 = this.sjN.keySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((String)((Iterator)localObject2).next()).contains(paramf.getAppId()))
          {
            paramf.callback(paramInt, ZP("fail:scan task already exist"));
            AppMethodBeat.o(144240);
            return;
          }
        }
        ??? = new a(paramf);
        ((a)???).sjS.set(paramInt);
        this.sjN.put(h(paramf, ???), ???);
        localObject2 = o.toD;
        NsdManager localNsdManager = o.cCu();
        o.1 local1 = new o.1((o)localObject2, (o.b)???);
        ((o)localObject2).toE.put(???, local1);
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
                synchronized (g.this.sjN)
                {
                  if (!g.this.sjN.containsKey(g.h(g.1.this.rDf, g.1.this.sjO)))
                  {
                    Log.i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
                    AppMethodBeat.o(144228);
                    return;
                  }
                  o.toD.a(g.1.this.sjP);
                  g.this.sjN.remove(g.h(g.1.this.rDf, g.1.this.sjO));
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
      synchronized (this.sjN)
      {
        ??? = this.sjN.values().iterator();
        for (int i = 1; ((Iterator)???).hasNext(); i = 0)
        {
          localObject2 = (a)((Iterator)???).next();
          ((a)localObject2).sjT.set(paramInt);
          o.toD.a((o.b)localObject2);
        }
        if (i != 0) {
          paramf.callback(paramInt, ZP("fail:task not found"));
        }
        this.sjN.clear();
        AppMethodBeat.o(144240);
        return;
      }
    }
    paramf.callback(paramInt, ZP("fail:invalid param"));
    AppMethodBeat.o(144240);
  }
  
  final class a
    implements o.b
  {
    f qrk;
    AtomicInteger sjS;
    AtomicInteger sjT;
    
    a(f paramf)
    {
      AppMethodBeat.i(144232);
      this.sjS = new AtomicInteger();
      this.sjT = new AtomicInteger();
      this.qrk = paramf;
      AppMethodBeat.o(144232);
    }
    
    public final void a(o.c paramc)
    {
      AppMethodBeat.i(144237);
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
      o localo = o.toD;
      o.a local1 = new o.a()
      {
        public final void c(o.c paramAnonymousc)
        {
          AppMethodBeat.i(144230);
          Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
          a.c(g.a.this.qrk, paramAnonymousc);
          AppMethodBeat.o(144230);
        }
        
        public final void d(o.c paramAnonymousc)
        {
          AppMethodBeat.i(144231);
          Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
          a.a(g.a.this.qrk, paramAnonymousc);
          AppMethodBeat.o(144231);
        }
      };
      h.ahAA.g(new o.2(localo, paramc, local1), "LocalServiceMgr#resolveService");
      AppMethodBeat.o(144237);
    }
    
    public final void b(o.c paramc)
    {
      AppMethodBeat.i(144238);
      a.b(this.qrk, paramc);
      AppMethodBeat.o(144238);
    }
    
    public final void cts()
    {
      AppMethodBeat.i(144233);
      this.qrk.callback(this.sjS.get(), g.this.ZP("fail"));
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
      AppMethodBeat.o(144233);
    }
    
    public final void ctt()
    {
      AppMethodBeat.i(144234);
      this.qrk.callback(this.sjT.get(), g.this.ZP("fail"));
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
      AppMethodBeat.o(144234);
    }
    
    public final void ctu()
    {
      AppMethodBeat.i(144235);
      this.qrk.callback(this.sjS.get(), g.this.ZP("ok"));
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
      AppMethodBeat.o(144235);
    }
    
    public final void ctv()
    {
      AppMethodBeat.i(144236);
      Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
      this.qrk.callback(this.sjT.get(), g.this.ZP("ok"));
      a.y(this.qrk);
      AppMethodBeat.o(144236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.g
 * JD-Core Version:    0.7.0.1
 */