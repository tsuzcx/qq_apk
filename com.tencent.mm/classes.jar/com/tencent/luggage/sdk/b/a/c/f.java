package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.m.a;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.m.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f<Service extends d>
  extends com.tencent.luggage.sdk.b.a.a.a<Service>
  implements com.tencent.mm.plugin.appbrand.p.f
{
  final a cBl = new a(new a.a((g)NN())
  {
    public final boolean doInnerLoopTask()
    {
      AppMethodBeat.i(229855);
      if (f.this.NN() == null)
      {
        Log.e("Luggage.BaseAppBrandServiceLogic", "hy: component released when doInnerLoopTask");
        AppMethodBeat.o(229855);
        return false;
      }
      q localq = f.a(f.this);
      if (localq == null)
      {
        Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js thread handler not installed");
        AppMethodBeat.o(229855);
        return false;
      }
      boolean bool = localq.doInnerLoopTask();
      AppMethodBeat.o(229855);
      return bool;
    }
    
    public final void resumeLoopTasks()
    {
      AppMethodBeat.i(229854);
      if (f.this.NN() == null)
      {
        Log.e("Luggage.BaseAppBrandServiceLogic", "hy: component released when resumeLoopTasks");
        AppMethodBeat.o(229854);
        return;
      }
      q localq = f.a(f.this);
      if (localq == null)
      {
        Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js thread handler not installed");
        AppMethodBeat.o(229854);
        return;
      }
      localq.resumeLoopTasks();
      AppMethodBeat.o(229854);
    }
    
    public final boolean syncInitModule(String paramAnonymousString1, String paramAnonymousString2)
    {
      AppMethodBeat.i(229856);
      if (!Util.isNullOrNil(paramAnonymousString2)) {}
      for (;;)
      {
        try
        {
          paramAnonymousString2 = new JSONObject(paramAnonymousString2);
          boolean bool = f.this.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(229856);
          return bool;
        }
        catch (JSONException paramAnonymousString2)
        {
          Log.printErrStackTrace("Luggage.BaseAppBrandServiceLogic", paramAnonymousString2, "hy: param is not in json format", new Object[0]);
        }
        paramAnonymousString2 = null;
      }
    }
  });
  
  public f(Service paramService)
  {
    super(paramService);
  }
  
  private void j(Runnable paramRunnable)
  {
    q localq = (q)U(q.class);
    if (localq == null)
    {
      Log.w("Luggage.BaseAppBrandServiceLogic", "hy: no js thread addon. may be remote debug env");
      return;
    }
    localq.post(paramRunnable);
  }
  
  protected void MB() {}
  
  protected abstract void MC();
  
  protected abstract void MD();
  
  public abstract boolean Mj();
  
  protected i Mk()
  {
    return null;
  }
  
  protected void Ml()
  {
    Log.i("Luggage.BaseAppBrandServiceLogic", "hy: base service js runtime post created");
    j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(229858);
        Log.i("Luggage.BaseAppBrandServiceLogic", "hy: base service js runtime post created run");
        Object localObject = (v)f.this.U(v.class);
        if (localObject == null)
        {
          Log.e("Luggage.BaseAppBrandServiceLogic", "hy: v8 not ready or released!");
          AppMethodBeat.o(229858);
          return;
        }
        f.this.cBl.cAE.notifyCreate(f.this.OA());
        f.this.cBl.cAF.bindTo(((v)localObject).getIsolatePtr(), ((v)localObject).XK());
        localObject = (k)f.this.U(k.class);
        if (localObject != null)
        {
          ((k)localObject).a(new y()
          {
            public final ByteBuffer dI(String paramAnonymous2String)
            {
              AppMethodBeat.i(229857);
              paramAnonymous2String = f.this.cBl.cAF.dI(paramAnonymous2String);
              AppMethodBeat.o(229857);
              return paramAnonymous2String;
            }
          });
          AppMethodBeat.o(229858);
          return;
        }
        Log.w("Luggage.BaseAppBrandServiceLogic", "hy: buffer url addon not exist!");
        AppMethodBeat.o(229858);
      }
    });
  }
  
  protected void Mm()
  {
    if ((NN() == null) || (((d)NN()).getJsRuntime() == null))
    {
      Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js runtime released when destroy");
      return;
    }
    m localm = (m)U(m.class);
    if (localm == null)
    {
      Log.w("Luggage.BaseAppBrandServiceLogic", "hy: no AppBrandJsRuntimeAddonDestroyListener");
      return;
    }
    localm.a(new m.a()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(229860);
        Log.i("Luggage.BaseAppBrandServiceLogic", "hy: common binding triggered destroy");
        f.this.cBl.cAF.destroy();
        f.this.cBl.cAE.notifyDestroy();
        AppMethodBeat.o(229860);
      }
    });
  }
  
  protected void Mn() {}
  
  public void Mw()
  {
    j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(229862);
        f.this.cBl.cAE.notifyResume();
        AppMethodBeat.o(229862);
      }
    });
  }
  
  public void Mx()
  {
    j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(229861);
        f.this.cBl.cAE.notifyPause();
        AppMethodBeat.o(229861);
      }
    });
  }
  
  public final com.tencent.luggage.sdk.d.d NP()
  {
    if (NN() == null) {
      return null;
    }
    return ((d)NN()).NP();
  }
  
  protected Map<String, p> Nf()
  {
    return null;
  }
  
  protected final AppBrandCommonBindingJniParams OA()
  {
    v localv = (v)U(v.class);
    if (localv == null)
    {
      Log.e("Luggage.BaseAppBrandServiceLogic", "add on v8 not ready!");
      return null;
    }
    AppBrandCommonBindingJniParams localAppBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
    localAppBrandCommonBindingJniParams.jsContext = localv.XK();
    localAppBrandCommonBindingJniParams.jsEngine = localv.getIsolatePtr();
    localAppBrandCommonBindingJniParams.uvLoop = localv.getUVLoopPtr();
    localAppBrandCommonBindingJniParams.wasmCachePath = OB();
    return localAppBrandCommonBindingJniParams;
  }
  
  protected String OB()
  {
    return "";
  }
  
  public final void Om()
  {
    ((d)NN()).Om();
  }
  
  public final a Oz()
  {
    return this.cBl;
  }
  
  public final <T> T S(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((d)NN()).bqZ());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.S(paramClass);
  }
  
  final <T extends j> T U(Class<T> paramClass)
  {
    if ((NN() == null) || (((d)NN()).getJsRuntime() == null))
    {
      Log.w("Luggage.BaseAppBrandServiceLogic", "hy: js runtime not ready");
      return null;
    }
    return ((d)NN()).getJsRuntime().R(paramClass);
  }
  
  protected void c(final AppBrandRuntime paramAppBrandRuntime)
  {
    j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(229859);
        f.this.cBl.cAE.notifyRuntimeReady(f.this.getAppId(), paramAppBrandRuntime.OT().leE.md5);
        AppMethodBeat.o(229859);
      }
    });
  }
  
  public void c(JSONObject paramJSONObject) {}
  
  public void d(JSONObject paramJSONObject) {}
  
  public boolean d(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  protected boolean d(String paramString, JSONObject paramJSONObject)
  {
    return false;
  }
  
  public String dH(String paramString)
  {
    return null;
  }
  
  public final String getAppId()
  {
    return ((d)NN()).getAppId();
  }
  
  public boolean j(int paramInt, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.f
 * JD-Core Version:    0.7.0.1
 */