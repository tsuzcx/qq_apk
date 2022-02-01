package com.tencent.mm.plugin.appbrand.ag;

import android.util.SparseArray;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public class c
  extends v
{
  private com.tencent.mm.plugin.appbrand.u.b.a nMl;
  final SparseArray<com.tencent.luggage.sdk.b.a.c.a> oFn;
  
  c(w paramw)
  {
    super(paramw);
    AppMethodBeat.i(230024);
    this.oFn = new SparseArray(1);
    this.nMl = null;
    AppMethodBeat.o(230024);
  }
  
  protected String OB()
  {
    return "";
  }
  
  protected String a(g paramg)
  {
    return "";
  }
  
  public final void a(final int paramInt, final g paramg)
  {
    AppMethodBeat.i(230027);
    Log.i("MicroMsg.V8EngineWorkerManagerLU", "hy: trigger bind to %d", new Object[] { Integer.valueOf(paramInt) });
    final m localm = iT(paramInt);
    if ((localm == null) || (paramg == null))
    {
      Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: worker not in map!");
      AppMethodBeat.o(230027);
      return;
    }
    localm.dpQ.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(230022);
        com.tencent.luggage.sdk.b.a.c.a locala = new com.tencent.luggage.sdk.b.a.c.a(new a.a(paramg)
        {
          public final boolean doInnerLoopTask()
          {
            AppMethodBeat.i(230021);
            boolean bool = c.3.this.dqs.dpQ.doInnerLoopTask();
            AppMethodBeat.o(230021);
            return bool;
          }
          
          public final String nativeInvokeHandler(final String paramAnonymous2String1, String paramAnonymous2String2, int paramAnonymous2Int, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(230019);
            if (c.3.this.oFq == null)
            {
              Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: component released when nativeInvokeHandler: %s, %s, %d, %b", new Object[] { paramAnonymous2String1, paramAnonymous2String2, Integer.valueOf(paramAnonymous2Int), Boolean.valueOf(paramAnonymous2Boolean) });
              AppMethodBeat.o(230019);
              return null;
            }
            try
            {
              paramAnonymous2String1 = c.3.this.oFq.a(paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2Int, paramAnonymous2Boolean, new o()
              {
                public final void evaluateJavascript(String paramAnonymous3String, ValueCallback<String> paramAnonymous3ValueCallback)
                {
                  AppMethodBeat.i(230018);
                  c localc = c.this;
                  m localm = c.3.this.dqs;
                  if (localm != null)
                  {
                    if (paramAnonymous3ValueCallback != null)
                    {
                      localm.a(paramAnonymous3String, new c.4(localc, paramAnonymous3ValueCallback));
                      AppMethodBeat.o(230018);
                      return;
                    }
                    localm.a(paramAnonymous3String, null);
                    AppMethodBeat.o(230018);
                    return;
                  }
                  Log.w("MicroMsg.V8EngineWorkerManagerLU", "hy: engine context released");
                  AppMethodBeat.o(230018);
                }
              });
              AppMethodBeat.o(230019);
              return paramAnonymous2String1;
            }
            catch (Throwable paramAnonymous2String1)
            {
              Log.printErrStackTrace("MicroMsg.V8EngineWorkerManagerLU", paramAnonymous2String1, "IMBInvokeHandler.invoke", new Object[0]);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  throw paramAnonymous2String1;
                }
              });
              AppMethodBeat.o(230019);
            }
            return "";
          }
          
          public final void resumeLoopTasks()
          {
            AppMethodBeat.i(230020);
            c.3.this.dqs.dpQ.resumeLoopTasks();
            AppMethodBeat.o(230020);
          }
        });
        AppBrandCommonBindingJniParams localAppBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
        localAppBrandCommonBindingJniParams.jsContext = localm.XK();
        localAppBrandCommonBindingJniParams.jsEngine = localm.dpQ.getIsolatePtr();
        localAppBrandCommonBindingJniParams.uvLoop = localm.dpQ.getUVLoopPtr();
        localAppBrandCommonBindingJniParams.wasmCachePath = c.this.OB();
        locala.cAE.notifyCreate(localAppBrandCommonBindingJniParams);
        locala.cAF.bindTo(localm.dpQ.getIsolatePtr(), localm.XK());
        c.this.oFn.put(paramInt, locala);
        locala.cAE.notifyRuntimeReady(paramg.getAppId(), c.this.a(paramg));
        AppMethodBeat.o(230022);
      }
    });
    AppMethodBeat.o(230027);
  }
  
  public final void a(m paramm, final v.a parama)
  {
    AppMethodBeat.i(147756);
    if ((parama instanceof a))
    {
      String str = ((a)parama).oFu;
      if (!Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.V8EngineWorkerManagerLU", "hy: %s has sourcemap", new Object[] { parama.filePath });
        paramm.a(str, null);
      }
    }
    Log.i("MicroMsg.V8EngineWorkerManagerLU", "hy: evaluating %s", new Object[] { parama.filePath });
    final long l = System.currentTimeMillis();
    paramm.a(parama.filePath, parama.script, new m.b()
    {
      public final void a(String paramAnonymousString, m.c paramAnonymousc)
      {
        AppMethodBeat.i(147755);
        System.currentTimeMillis();
        c.this.a(parama);
        AppMethodBeat.o(147755);
      }
    });
    AppMethodBeat.o(147756);
  }
  
  protected void a(v.a parama) {}
  
  public final void a(ArrayList<v.a> paramArrayList, i parami, g paramg)
  {
    AppMethodBeat.i(230025);
    if (!(paramg instanceof s))
    {
      Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: component is not service. do nothing");
      AppMethodBeat.o(230025);
      return;
    }
    this.nMl = new com.tencent.mm.plugin.appbrand.u.b.a();
    this.nMl.a((s)paramg, parami);
    paramArrayList.add(0, new v.a(((s)paramg).Ou() + "node.js", this.nMl.bPX()));
    AppMethodBeat.o(230025);
  }
  
  public final void terminate(final int paramInt)
  {
    AppMethodBeat.i(230026);
    Log.i("MicroMsg.V8EngineWorkerManagerLU", "hy: trigger terminate %d", new Object[] { Integer.valueOf(paramInt) });
    m localm = iT(paramInt);
    if (localm == null)
    {
      Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: worker not in map!");
      AppMethodBeat.o(230026);
      return;
    }
    localm.dpQ.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(230017);
        com.tencent.luggage.sdk.b.a.c.a locala = (com.tencent.luggage.sdk.b.a.c.a)c.this.oFn.get(paramInt);
        if (locala == null)
        {
          Log.w("MicroMsg.V8EngineWorkerManagerLU", "hy: not prepared binding!");
          AppMethodBeat.o(230017);
          return;
        }
        locala.cAF.destroy();
        locala.cAE.notifyDestroy();
        c.this.oFn.remove(paramInt);
        AppMethodBeat.o(230017);
      }
    });
    super.terminate(paramInt);
    AppMethodBeat.o(230026);
  }
  
  static final class a
    extends v.a
  {
    String appId;
    String oFu;
    boolean oFv;
    
    a(v.a parama, String paramString1, String paramString2, boolean paramBoolean)
    {
      super(parama.script);
      this.oFu = paramString1;
      this.appId = paramString2;
      this.oFv = paramBoolean;
    }
    
    a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      super(paramString2);
      this.oFu = null;
      this.appId = paramString3;
      this.oFv = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c
 * JD-Core Version:    0.7.0.1
 */