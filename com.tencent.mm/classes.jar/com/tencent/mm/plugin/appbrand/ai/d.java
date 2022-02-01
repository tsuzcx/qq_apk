package com.tencent.mm.plugin.appbrand.ai;

import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.d.a.a;
import com.tencent.luggage.sdk.b.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.b;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
  extends v
{
  final AtomicBoolean qxl;
  private com.tencent.mm.plugin.appbrand.v.b.a tTi;
  final SparseArray<com.tencent.luggage.sdk.b.a.d.a> uSq;
  final Map<com.tencent.luggage.sdk.b.a.d.a, g> uSr;
  
  d(w paramw)
  {
    super(paramw);
    AppMethodBeat.i(317821);
    this.uSq = new SparseArray(1);
    this.tTi = null;
    this.qxl = new AtomicBoolean(false);
    this.uSr = new HashMap();
    AppMethodBeat.o(317821);
  }
  
  public final void a(final int paramInt, m paramm)
  {
    AppMethodBeat.i(317874);
    final com.tencent.luggage.sdk.b.a.d.a locala = (com.tencent.luggage.sdk.b.a.d.a)this.uSq.get(paramInt);
    if (locala != null) {
      paramm.hmL.w(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(317812);
          d locald = d.this;
          int i = paramInt;
          com.tencent.luggage.sdk.b.a.d.a locala = locala;
          locala.esg.destroy();
          locala.esf.notifyDestroy();
          locald.uSr.remove(locala);
          locald.uSq.remove(i);
          AppMethodBeat.o(317812);
        }
      });
    }
    super.a(paramInt, paramm);
    AppMethodBeat.o(317874);
  }
  
  public final void a(final int paramInt, final g paramg, final List<String> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(317836);
    Log.i("MicroMsg.V8EngineWorkerManagerLU", "hy: trigger bind to %d", new Object[] { Integer.valueOf(paramInt) });
    final m localm = nR(paramInt);
    Object localObject = new WeakReference(localm);
    if ((localm == null) || (paramg == null))
    {
      Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: worker not in map!");
      AppMethodBeat.o(317836);
      return;
    }
    localObject = a(paramInt, (WeakReference)localObject);
    localm.hmL.u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317823);
        com.tencent.luggage.sdk.b.a.d.a locala = new com.tencent.luggage.sdk.b.a.d.a(new a.a(paramg)
        {
          public final boolean doInnerLoopTask()
          {
            AppMethodBeat.i(317846);
            boolean bool = d.1.this.hnm.hmL.doInnerLoopTask();
            AppMethodBeat.o(317846);
            return bool;
          }
          
          public final String nativeInvokeHandler(final String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, int paramAnonymous2Int, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(317835);
            if ((d.1.this.hob == null) || (!d.1.this.hob.contains(paramAnonymous2String1)))
            {
              d.1.this.uSs.a(paramAnonymous2Int, g.aE(paramAnonymous2String1, "fail:not supported"), d.1.this.hoc);
              AppMethodBeat.o(317835);
              return "fail:not supported";
            }
            try
            {
              paramAnonymous2String1 = d.1.this.uSs.a(paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2String3, paramAnonymous2Int, paramAnonymous2Boolean, d.1.this.hoc);
              AppMethodBeat.o(317835);
              return paramAnonymous2String1;
            }
            finally
            {
              Log.printErrStackTrace("MicroMsg.V8EngineWorkerManagerLU", paramAnonymous2String1, "IMBInvokeHandler.invoke", new Object[0]);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  throw paramAnonymous2String1;
                }
              });
              AppMethodBeat.o(317835);
            }
            return "";
          }
          
          public final void resumeLoopTasks()
          {
            AppMethodBeat.i(317838);
            d.1.this.hnm.hmL.resumeLoopTasks();
            AppMethodBeat.o(317838);
          }
        });
        ??? = new AppBrandCommonBindingJniParams();
        long l1 = localm.hmL.getIsolatePtr();
        long l2 = localm.aEn();
        long l3 = localm.hmL.getUVLoopPtr();
        ((AppBrandCommonBindingJniParams)???).wasmCachePath = d.this.arO();
        if (!TextUtils.isEmpty(((AppBrandCommonBindingJniParams)???).wasmCachePath)) {
          ((AppBrandCommonBindingJniParams)???).wasmCachePath = com.tencent.mm.vfs.y.n(((AppBrandCommonBindingJniParams)???).wasmCachePath, true);
        }
        if ((paramg instanceof com.tencent.luggage.sdk.b.a.d.d))
        {
          f localf = ((com.tencent.luggage.sdk.b.a.d.d)paramg).esM;
          if (localf != null) {
            ((AppBrandCommonBindingJniParams)???).wasmOptState = localf.arP();
          }
        }
        locala.esf.notifyCreate((AppBrandCommonBindingJniParams)???);
        locala.esf.notifyBindTo(l1, l2, l3);
        locala.esg.bindTo(localm.hmL.getIsolatePtr(), localm.aEn());
        d.this.uSq.put(paramInt, locala);
        if ((!paramBoolean) || (d.this.qxl.get()))
        {
          locala.esf.notifyRuntimeReady(paramg.getAppId(), d.this.c(paramg));
          AppMethodBeat.o(317823);
          return;
        }
        synchronized (d.this.uSr)
        {
          d.this.uSr.put(locala, paramg);
          AppMethodBeat.o(317823);
          return;
        }
      }
    });
    AppMethodBeat.o(317836);
  }
  
  public final void a(m paramm, String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(317852);
    if (paramm != null)
    {
      if (paramValueCallback != null)
      {
        paramm.a(paramString, new m.b()
        {
          public final void onResult(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(317807);
            paramValueCallback.onReceiveValue(paramAnonymousString);
            AppMethodBeat.o(317807);
          }
        });
        AppMethodBeat.o(317852);
        return;
      }
      paramm.a(paramString, null);
      AppMethodBeat.o(317852);
      return;
    }
    Log.w("MicroMsg.V8EngineWorkerManagerLU", "hy: engine context released");
    AppMethodBeat.o(317852);
  }
  
  public final void a(ArrayList<v.b> paramArrayList, i parami, g paramg)
  {
    AppMethodBeat.i(317832);
    if (!(paramg instanceof com.tencent.mm.plugin.appbrand.y))
    {
      Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: component is not service. do nothing");
      AppMethodBeat.o(317832);
      return;
    }
    this.tTi = new com.tencent.mm.plugin.appbrand.v.b.a();
    this.tTi.a((com.tencent.mm.plugin.appbrand.y)paramg, parami);
    paramArrayList.add(0, new v.b(((com.tencent.mm.plugin.appbrand.y)paramg).arG() + "node.js", this.tTi.cDa()));
    AppMethodBeat.o(317832);
  }
  
  public final void aEr()
  {
    AppMethodBeat.i(317843);
    super.aEr();
    if (this.qxl.getAndSet(true))
    {
      AppMethodBeat.o(317843);
      return;
    }
    synchronized (this.uSr)
    {
      Iterator localIterator = this.uSr.keySet().iterator();
      if (localIterator.hasNext())
      {
        com.tencent.luggage.sdk.b.a.d.a locala = (com.tencent.luggage.sdk.b.a.d.a)localIterator.next();
        g localg = (g)this.uSr.get(locala);
        locala.esf.notifyRuntimeReady(localg.getAppId(), c(localg));
      }
    }
    AppMethodBeat.o(317843);
  }
  
  protected String arO()
  {
    return "";
  }
  
  protected String c(g paramg)
  {
    return "";
  }
  
  public final void exit()
  {
    AppMethodBeat.i(317867);
    super.exit();
    this.tTi = null;
    this.uSq.clear();
    this.uSr.clear();
    AppMethodBeat.o(317867);
  }
  
  static final class a
    extends v.b
  {
    String appId;
    boolean uSA;
    String uSz;
    
    a(v.b paramb, String paramString1, String paramString2, boolean paramBoolean)
    {
      super(paramb.script);
      this.uSz = paramString1;
      this.appId = paramString2;
      this.uSA = paramBoolean;
    }
    
    a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      super(paramString2);
      this.uSz = null;
      this.appId = paramString3;
      this.uSA = paramBoolean;
    }
    
    a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
    {
      super(paramString2, paramString4, paramString5);
      this.uSz = null;
      this.appId = paramString3;
      this.uSA = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ai.d
 * JD-Core Version:    0.7.0.1
 */