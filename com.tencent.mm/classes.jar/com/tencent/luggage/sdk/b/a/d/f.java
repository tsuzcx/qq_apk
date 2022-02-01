package com.tencent.luggage.sdk.b.a.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.j;
import com.tencent.mm.plugin.appbrand.n.k;
import com.tencent.mm.plugin.appbrand.n.m.a;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.utils.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f<Service extends d>
  extends com.tencent.luggage.sdk.b.a.a.a<Service>
  implements e
{
  final a esO;
  
  public f(Service paramService)
  {
    super(paramService);
    if (arM())
    {
      this.esO = new a(new a.a((g)aqX())
      {
        public final boolean doInnerLoopTask()
        {
          AppMethodBeat.i(220331);
          if (f.this.aqX() == null)
          {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: component released when doInnerLoopTask");
            AppMethodBeat.o(220331);
            return false;
          }
          q localq = f.a(f.this);
          if (localq == null)
          {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js thread handler not installed");
            AppMethodBeat.o(220331);
            return false;
          }
          boolean bool = localq.doInnerLoopTask();
          AppMethodBeat.o(220331);
          return bool;
        }
        
        public final void resumeLoopTasks()
        {
          AppMethodBeat.i(220330);
          if (f.this.aqX() == null)
          {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: component released when resumeLoopTasks");
            AppMethodBeat.o(220330);
            return;
          }
          q localq = f.a(f.this);
          if (localq == null)
          {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js thread handler not installed");
            AppMethodBeat.o(220330);
            return;
          }
          localq.resumeLoopTasks();
          AppMethodBeat.o(220330);
        }
        
        public final boolean syncInitModule(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(220334);
          if (!Util.isNullOrNil(paramAnonymousString2)) {}
          for (;;)
          {
            try
            {
              paramAnonymousString2 = new JSONObject(paramAnonymousString2);
              boolean bool = f.this.c(paramAnonymousString1, paramAnonymousString2);
              AppMethodBeat.o(220334);
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
    this.esO = null;
  }
  
  public final <T> T aa(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((d)aqX()).cbl());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.aa(paramClass);
  }
  
  final <T extends j> T ac(Class<T> paramClass)
  {
    if ((aqX() == null) || (((d)aqX()).getJsRuntime() == null))
    {
      Log.w("Luggage.BaseAppBrandServiceLogic", "hy: js runtime not ready");
      return null;
    }
    return ((d)aqX()).getJsRuntime().Z(paramClass);
  }
  
  protected void apB() {}
  
  protected abstract void apC();
  
  protected abstract void apD();
  
  public abstract boolean apj();
  
  protected i apk()
  {
    return null;
  }
  
  protected void apl()
  {
    Log.i("Luggage.BaseAppBrandServiceLogic", "hy: base service js runtime post created");
    AppBrandCommonBindingJni localAppBrandCommonBindingJni;
    AppBrandCommonBindingJniParams localAppBrandCommonBindingJniParams;
    if (arM())
    {
      localAppBrandCommonBindingJni = ((a)Objects.requireNonNull(this.esO)).esf;
      if ((v)ac(v.class) != null) {
        break label67;
      }
      Log.e("Luggage.BaseAppBrandServiceLogic", "add on v8 not ready!");
      localAppBrandCommonBindingJniParams = null;
    }
    for (;;)
    {
      localAppBrandCommonBindingJni.notifyCreate(localAppBrandCommonBindingJniParams);
      m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220325);
          Log.i("Luggage.BaseAppBrandServiceLogic", "hy: base service js runtime post created run");
          Object localObject = (v)f.this.ac(v.class);
          if (localObject == null)
          {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: v8 not ready or released!");
            AppMethodBeat.o(220325);
            return;
          }
          f.this.esO.esf.notifyBindTo(((v)localObject).getIsolatePtr(), ((v)localObject).aEn(), ((v)localObject).getUVLoopPtr());
          if (!com.tencent.mm.appbrand.v8.m.aEk()) {
            f.this.esO.esf.notifyBindConsoleTo(((v)localObject).getIsolatePtr(), ((v)localObject).aEn(), ((v)localObject).getUVLoopPtr());
          }
          f.this.esO.esg.bindTo(((v)localObject).getIsolatePtr(), ((v)localObject).aEn());
          localObject = (k)f.this.ac(k.class);
          if (localObject != null)
          {
            ((k)localObject).a(new com.tencent.mm.plugin.appbrand.n.y()
            {
              public final ByteBuffer fu(String paramAnonymous2String)
              {
                AppMethodBeat.i(220335);
                paramAnonymous2String = f.this.esO.esg.fu(paramAnonymous2String);
                AppMethodBeat.o(220335);
                return paramAnonymous2String;
              }
            });
            AppMethodBeat.o(220325);
            return;
          }
          Log.w("Luggage.BaseAppBrandServiceLogic", "hy: buffer url addon not exist!");
          AppMethodBeat.o(220325);
        }
      });
      return;
      label67:
      localAppBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
      localAppBrandCommonBindingJniParams.wasmCachePath = arO();
      if (!TextUtils.isEmpty(localAppBrandCommonBindingJniParams.wasmCachePath)) {
        localAppBrandCommonBindingJniParams.wasmCachePath = com.tencent.mm.vfs.y.n(localAppBrandCommonBindingJniParams.wasmCachePath, true);
      }
      localAppBrandCommonBindingJniParams.wasmOptState = arP();
    }
  }
  
  protected void apm()
  {
    if ((aqX() == null) || (((d)aqX()).getJsRuntime() == null))
    {
      Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js runtime released when destroy");
      return;
    }
    com.tencent.mm.plugin.appbrand.n.m localm = (com.tencent.mm.plugin.appbrand.n.m)ac(com.tencent.mm.plugin.appbrand.n.m.class);
    if (localm == null)
    {
      Log.w("Luggage.BaseAppBrandServiceLogic", "hy: no AppBrandJsRuntimeAddonDestroyListener");
      return;
    }
    localm.a(new m.a()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(220327);
        Log.i("Luggage.BaseAppBrandServiceLogic", "hy: common binding triggered destroy");
        f.this.esO.esg.destroy();
        f.this.esO.esf.notifyDestroy();
        AppMethodBeat.o(220327);
      }
    }, true);
  }
  
  protected void apn() {}
  
  public void apw()
  {
    if (arM()) {
      m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220328);
          f.this.esO.esf.notifyResume();
          AppMethodBeat.o(220328);
        }
      });
    }
  }
  
  public void apx()
  {
    if (arM()) {
      m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220326);
          f.this.esO.esf.notifyPause();
          AppMethodBeat.o(220326);
        }
      });
    }
  }
  
  public final com.tencent.luggage.sdk.e.d aqZ()
  {
    if (aqX() == null) {
      return null;
    }
    return ((d)aqX()).aqZ();
  }
  
  protected Map<String, p> aqh()
  {
    return null;
  }
  
  public boolean arD()
  {
    return false;
  }
  
  protected boolean arM()
  {
    return true;
  }
  
  public final a arN()
  {
    if (arM()) {
      return (a)Objects.requireNonNull(this.esO);
    }
    return null;
  }
  
  protected String arO()
  {
    return "";
  }
  
  public int arP()
  {
    return -2;
  }
  
  public final void arx()
  {
    ((d)aqX()).arx();
  }
  
  protected void c(final AppBrandRuntime paramAppBrandRuntime)
  {
    if (arM())
    {
      m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220324);
          f.this.esO.esf.notifyRuntimeReady(f.this.getAppId(), paramAppBrandRuntime.asG().qYY.md5);
          AppMethodBeat.o(220324);
        }
      });
      paramAppBrandRuntime.qsB.a(new c.a()
      {
        public final void onRunningStateChanged(String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(220329);
          if (b.qKy == paramAnonymousb) {
            f.this.m(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(220332);
                f.this.esO.esf.notifySuspend();
                AppMethodBeat.o(220332);
              }
            });
          }
          AppMethodBeat.o(220329);
        }
      });
    }
  }
  
  protected boolean c(String paramString, JSONObject paramJSONObject)
  {
    return false;
  }
  
  public void e(JSONObject paramJSONObject) {}
  
  public void f(JSONObject paramJSONObject) {}
  
  public String fs(String paramString)
  {
    return null;
  }
  
  public boolean g(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public final String getAppId()
  {
    return ((d)aqX()).getAppId();
  }
  
  public boolean k(int paramInt, String paramString)
  {
    return false;
  }
  
  final void m(Runnable paramRunnable)
  {
    q localq = (q)ac(q.class);
    if (localq == null)
    {
      Log.w("Luggage.BaseAppBrandServiceLogic", "hy: no js thread addon. may be remote debug env");
      return;
    }
    if (aqX() != null) {}
    for (com.tencent.luggage.sdk.e.d locald = ((d)aqX()).aqZ();; locald = null)
    {
      Object localObject = paramRunnable;
      if (locald != null) {
        localObject = ab.a(locald, paramRunnable);
      }
      localq.post((Runnable)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.f
 * JD-Core Version:    0.7.0.1
 */