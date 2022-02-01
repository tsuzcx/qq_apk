package com.tencent.mm.plugin.appbrand.ah;

import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.v.b;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
  extends com.tencent.mm.appbrand.v8.v
{
  final AtomicBoolean nxX;
  private com.tencent.mm.plugin.appbrand.u.b.a qOz;
  final SparseArray<com.tencent.luggage.sdk.b.a.c.a> rGZ;
  final Map<com.tencent.luggage.sdk.b.a.c.a, com.tencent.mm.plugin.appbrand.jsapi.f> rHa;
  
  d(w paramw)
  {
    super(paramw);
    AppMethodBeat.i(246539);
    this.rGZ = new SparseArray(1);
    this.qOz = null;
    this.nxX = new AtomicBoolean(false);
    this.rHa = new HashMap();
    AppMethodBeat.o(246539);
  }
  
  protected String RA()
  {
    return "";
  }
  
  public final void a(final int paramInt, m paramm)
  {
    AppMethodBeat.i(293008);
    final com.tencent.luggage.sdk.b.a.c.a locala = (com.tencent.luggage.sdk.b.a.c.a)this.rGZ.get(paramInt);
    if (locala != null) {
      paramm.fiy.s(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(293025);
          d locald = d.this;
          int i = paramInt;
          com.tencent.luggage.sdk.b.a.c.a locala = locala;
          locala.czL.destroy();
          locala.czK.notifyDestroy();
          locald.rHa.remove(locala);
          locald.rGZ.remove(i);
          AppMethodBeat.o(293025);
        }
      });
    }
    super.a(paramInt, paramm);
    AppMethodBeat.o(293008);
  }
  
  public final void a(final int paramInt, final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final List<String> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(246542);
    Log.i("MicroMsg.V8EngineWorkerManagerLU", "hy: trigger bind to %d", new Object[] { Integer.valueOf(paramInt) });
    final m localm = kj(paramInt);
    if ((localm == null) || (paramf == null))
    {
      Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: worker not in map!");
      AppMethodBeat.o(246542);
      return;
    }
    final o local1 = new o()
    {
      public final void evaluateJavascript(String paramAnonymousString, ValueCallback<String> paramAnonymousValueCallback)
      {
        AppMethodBeat.i(293035);
        d.this.a(localm, paramAnonymousString, paramAnonymousValueCallback);
        AppMethodBeat.o(293035);
      }
    };
    localm.fiy.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293043);
        com.tencent.luggage.sdk.b.a.c.a locala = new com.tencent.luggage.sdk.b.a.c.a(new d.2.1(this, paramf));
        ??? = new AppBrandCommonBindingJniParams();
        long l1 = localm.fiy.getIsolatePtr();
        long l2 = localm.acn();
        long l3 = localm.fiy.getUVLoopPtr();
        ((AppBrandCommonBindingJniParams)???).wasmCachePath = d.this.RA();
        if (!TextUtils.isEmpty(((AppBrandCommonBindingJniParams)???).wasmCachePath)) {
          ((AppBrandCommonBindingJniParams)???).wasmCachePath = u.n(((AppBrandCommonBindingJniParams)???).wasmCachePath, true);
        }
        if ((paramf instanceof com.tencent.luggage.sdk.b.a.c.d))
        {
          com.tencent.luggage.sdk.b.a.c.f localf = ((com.tencent.luggage.sdk.b.a.c.d)paramf).cAr;
          if (localf != null) {
            ((AppBrandCommonBindingJniParams)???).wasmOptState = localf.RB();
          }
        }
        locala.czK.notifyCreate((AppBrandCommonBindingJniParams)???);
        locala.czK.notifyBindTo(l1, l2, l3);
        locala.czL.bindTo(localm.fiy.getIsolatePtr(), localm.acn());
        d.this.rGZ.put(paramInt, locala);
        if ((!paramBoolean) || (d.this.nxX.get()))
        {
          locala.czK.notifyRuntimeReady(paramf.getAppId(), d.this.c(paramf));
          AppMethodBeat.o(293043);
          return;
        }
        synchronized (d.this.rHa)
        {
          d.this.rHa.put(locala, paramf);
          AppMethodBeat.o(293043);
          return;
        }
      }
    });
    AppMethodBeat.o(246542);
  }
  
  public final void a(m paramm, String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(246544);
    if (paramm != null)
    {
      if (paramValueCallback != null)
      {
        paramm.a(paramString, new m.b()
        {
          public final void a(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(293047);
            paramValueCallback.onReceiveValue(paramAnonymousString);
            AppMethodBeat.o(293047);
          }
        });
        AppMethodBeat.o(246544);
        return;
      }
      paramm.a(paramString, null);
      AppMethodBeat.o(246544);
      return;
    }
    Log.w("MicroMsg.V8EngineWorkerManagerLU", "hy: engine context released");
    AppMethodBeat.o(246544);
  }
  
  public final void a(ArrayList<v.b> paramArrayList, i parami, com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(246540);
    if (!(paramf instanceof com.tencent.mm.plugin.appbrand.v))
    {
      Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: component is not service. do nothing");
      AppMethodBeat.o(246540);
      return;
    }
    this.qOz = new com.tencent.mm.plugin.appbrand.u.b.a();
    this.qOz.a((com.tencent.mm.plugin.appbrand.v)paramf, parami);
    paramArrayList.add(0, new v.b(((com.tencent.mm.plugin.appbrand.v)paramf).Rs() + "node.js", this.qOz.ccE()));
    AppMethodBeat.o(246540);
  }
  
  public final void acr()
  {
    AppMethodBeat.i(246543);
    super.acr();
    if (this.nxX.getAndSet(true))
    {
      AppMethodBeat.o(246543);
      return;
    }
    synchronized (this.rHa)
    {
      Iterator localIterator = this.rHa.keySet().iterator();
      if (localIterator.hasNext())
      {
        com.tencent.luggage.sdk.b.a.c.a locala = (com.tencent.luggage.sdk.b.a.c.a)localIterator.next();
        com.tencent.mm.plugin.appbrand.jsapi.f localf = (com.tencent.mm.plugin.appbrand.jsapi.f)this.rHa.get(locala);
        locala.czK.notifyRuntimeReady(localf.getAppId(), c(localf));
      }
    }
    AppMethodBeat.o(246543);
  }
  
  protected String c(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    return "";
  }
  
  public final void exit()
  {
    AppMethodBeat.i(246571);
    super.exit();
    this.qOz = null;
    this.rGZ.clear();
    this.rHa.clear();
    AppMethodBeat.o(246571);
  }
  
  static final class a
    extends v.b
  {
    String appId;
    String rHh;
    boolean rHi;
    
    a(v.b paramb, String paramString1, String paramString2, boolean paramBoolean)
    {
      super(paramb.script);
      this.rHh = paramString1;
      this.appId = paramString2;
      this.rHi = paramBoolean;
    }
    
    a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      super(paramString2);
      this.rHh = null;
      this.appId = paramString3;
      this.rHi = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.d
 * JD-Core Version:    0.7.0.1
 */