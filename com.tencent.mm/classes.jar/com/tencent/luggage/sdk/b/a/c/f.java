package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.m.a;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.m.y;
import com.tencent.mm.plugin.appbrand.p.e;
import com.tencent.mm.plugin.appbrand.utils.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f<Service extends d>
  extends com.tencent.luggage.sdk.b.a.a.a<Service>
  implements e
{
  final a cAt;
  
  public f(Service paramService)
  {
    super(paramService);
    if (Ry())
    {
      this.cAt = new a(new a.a((com.tencent.mm.plugin.appbrand.jsapi.f)QK())
      {
        public final boolean doInnerLoopTask()
        {
          AppMethodBeat.i(235054);
          if (f.this.QK() == null)
          {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: component released when doInnerLoopTask");
            AppMethodBeat.o(235054);
            return false;
          }
          q localq = f.a(f.this);
          if (localq == null)
          {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js thread handler not installed");
            AppMethodBeat.o(235054);
            return false;
          }
          boolean bool = localq.doInnerLoopTask();
          AppMethodBeat.o(235054);
          return bool;
        }
        
        public final void resumeLoopTasks()
        {
          AppMethodBeat.i(235052);
          if (f.this.QK() == null)
          {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: component released when resumeLoopTasks");
            AppMethodBeat.o(235052);
            return;
          }
          q localq = f.a(f.this);
          if (localq == null)
          {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js thread handler not installed");
            AppMethodBeat.o(235052);
            return;
          }
          localq.resumeLoopTasks();
          AppMethodBeat.o(235052);
        }
        
        public final boolean syncInitModule(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(235056);
          if (!Util.isNullOrNil(paramAnonymousString2)) {}
          for (;;)
          {
            try
            {
              paramAnonymousString2 = new JSONObject(paramAnonymousString2);
              boolean bool = f.this.c(paramAnonymousString1, paramAnonymousString2);
              AppMethodBeat.o(235056);
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
      return;
    }
    this.cAt = null;
  }
  
  protected Map<String, o> PX()
  {
    return null;
  }
  
  public abstract boolean Pb();
  
  protected i Pc()
  {
    return null;
  }
  
  protected void Pd()
  {
    Log.i("Luggage.BaseAppBrandServiceLogic", "hy: base service js runtime post created");
    AppBrandCommonBindingJni localAppBrandCommonBindingJni;
    AppBrandCommonBindingJniParams localAppBrandCommonBindingJniParams;
    if (Ry())
    {
      localAppBrandCommonBindingJni = ((a)Objects.requireNonNull(this.cAt)).czK;
      if ((v)T(v.class) != null) {
        break label67;
      }
      Log.e("Luggage.BaseAppBrandServiceLogic", "add on v8 not ready!");
      localAppBrandCommonBindingJniParams = null;
    }
    for (;;)
    {
      localAppBrandCommonBindingJni.notifyCreate(localAppBrandCommonBindingJniParams);
      j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(238354);
          Log.i("Luggage.BaseAppBrandServiceLogic", "hy: base service js runtime post created run");
          Object localObject = (v)f.this.T(v.class);
          if (localObject == null)
          {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: v8 not ready or released!");
            AppMethodBeat.o(238354);
            return;
          }
          f.this.cAt.czK.notifyBindTo(((v)localObject).getIsolatePtr(), ((v)localObject).acn(), ((v)localObject).getUVLoopPtr());
          f.this.cAt.czL.bindTo(((v)localObject).getIsolatePtr(), ((v)localObject).acn());
          localObject = (k)f.this.T(k.class);
          if (localObject != null)
          {
            ((k)localObject).a(new y()
            {
              public final ByteBuffer eb(String paramAnonymous2String)
              {
                AppMethodBeat.i(246386);
                paramAnonymous2String = f.this.cAt.czL.eb(paramAnonymous2String);
                AppMethodBeat.o(246386);
                return paramAnonymous2String;
              }
            });
            AppMethodBeat.o(238354);
            return;
          }
          Log.w("Luggage.BaseAppBrandServiceLogic", "hy: buffer url addon not exist!");
          AppMethodBeat.o(238354);
        }
      });
      return;
      label67:
      localAppBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
      localAppBrandCommonBindingJniParams.wasmCachePath = RA();
      if (!TextUtils.isEmpty(localAppBrandCommonBindingJniParams.wasmCachePath)) {
        localAppBrandCommonBindingJniParams.wasmCachePath = u.n(localAppBrandCommonBindingJniParams.wasmCachePath, true);
      }
      localAppBrandCommonBindingJniParams.wasmOptState = RB();
    }
  }
  
  protected void Pe()
  {
    if ((QK() == null) || (((d)QK()).getJsRuntime() == null))
    {
      Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js runtime released when destroy");
      return;
    }
    m localm = (m)T(m.class);
    if (localm == null)
    {
      Log.w("Luggage.BaseAppBrandServiceLogic", "hy: no AppBrandJsRuntimeAddonDestroyListener");
      return;
    }
    localm.a(new m.a()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(242579);
        Log.i("Luggage.BaseAppBrandServiceLogic", "hy: common binding triggered destroy");
        f.this.cAt.czL.destroy();
        f.this.cAt.czK.notifyDestroy();
        AppMethodBeat.o(242579);
      }
    });
  }
  
  protected void Pf() {}
  
  public void Po()
  {
    if (Ry()) {
      j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(243253);
          f.this.cAt.czK.notifyResume();
          AppMethodBeat.o(243253);
        }
      });
    }
  }
  
  public void Pp()
  {
    if (Ry()) {
      j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(242965);
          f.this.cAt.czK.notifyPause();
          AppMethodBeat.o(242965);
        }
      });
    }
  }
  
  protected void Pt() {}
  
  protected abstract void Pu();
  
  protected abstract void Pv();
  
  public final com.tencent.luggage.sdk.e.d QM()
  {
    if (QK() == null) {
      return null;
    }
    return ((d)QK()).QM();
  }
  
  public final <T> T R(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((d)QK()).bBP());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.R(paramClass);
  }
  
  protected String RA()
  {
    return "";
  }
  
  public int RB()
  {
    return -2;
  }
  
  public final void Rj()
  {
    ((d)QK()).Rj();
  }
  
  public boolean Rp()
  {
    return false;
  }
  
  protected boolean Ry()
  {
    return true;
  }
  
  public final a Rz()
  {
    if (Ry()) {
      return (a)Objects.requireNonNull(this.cAt);
    }
    return null;
  }
  
  final <T extends j> T T(Class<T> paramClass)
  {
    if ((QK() == null) || (((d)QK()).getJsRuntime() == null))
    {
      Log.w("Luggage.BaseAppBrandServiceLogic", "hy: js runtime not ready");
      return null;
    }
    return ((d)QK()).getJsRuntime().Q(paramClass);
  }
  
  protected void c(final AppBrandRuntime paramAppBrandRuntime)
  {
    if (Ry())
    {
      j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(244313);
          f.this.cAt.czK.notifyRuntimeReady(f.this.getAppId(), paramAppBrandRuntime.Sp().nYR.md5);
          AppMethodBeat.o(244313);
        }
      });
      paramAppBrandRuntime.ntR.a(new c.a()
      {
        public final void a(String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(242772);
          if (b.nKR == paramAnonymousb) {
            f.this.j(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(249097);
                f.this.cAt.czK.notifySuspend();
                AppMethodBeat.o(249097);
              }
            });
          }
          AppMethodBeat.o(242772);
        }
      });
    }
  }
  
  protected boolean c(String paramString, JSONObject paramJSONObject)
  {
    return false;
  }
  
  public boolean d(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public String dZ(String paramString)
  {
    return null;
  }
  
  public void f(JSONObject paramJSONObject) {}
  
  public void g(JSONObject paramJSONObject) {}
  
  public final String getAppId()
  {
    return ((d)QK()).getAppId();
  }
  
  final void j(Runnable paramRunnable)
  {
    q localq = (q)T(q.class);
    if (localq == null)
    {
      Log.w("Luggage.BaseAppBrandServiceLogic", "hy: no js thread addon. may be remote debug env");
      return;
    }
    if (QK() != null) {}
    for (com.tencent.luggage.sdk.e.d locald = ((d)QK()).QM();; locald = null)
    {
      Object localObject = paramRunnable;
      if (locald != null) {
        localObject = w.a(locald, paramRunnable);
      }
      localq.post((Runnable)localObject);
      return;
    }
  }
  
  public boolean k(int paramInt, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.f
 * JD-Core Version:    0.7.0.1
 */