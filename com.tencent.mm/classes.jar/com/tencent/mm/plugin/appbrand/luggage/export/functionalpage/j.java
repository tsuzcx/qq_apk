package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.plugin.appbrand.n.a.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends o
{
  volatile c lqZ;
  
  public j(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
  }
  
  public final com.tencent.mm.plugin.appbrand.n.a DG()
  {
    AppMethodBeat.i(47533);
    a.c localc = new a.c();
    AppMethodBeat.o(47533);
    return localc;
  }
  
  public final u aSE()
  {
    AppMethodBeat.i(47530);
    g localg = new g(com.tencent.mm.sdk.f.a.jg(this.mContext));
    AppMethodBeat.o(47530);
    return localg;
  }
  
  public final b aTI()
  {
    return b.jUp;
  }
  
  @SuppressLint({"MissingSuperCall", "SourceLockedOrientationActivity"})
  public final void onCreate()
  {
    AppMethodBeat.i(47531);
    aTN();
    com.tencent.mm.plugin.appbrand.report.quality.a.K(this);
    a(new AppBrandRuntime.b()
    {
      public final void prepare()
      {
        AppMethodBeat.i(47529);
        com.tencent.mm.cn.g.fBc().h(new com.tencent.mm.vending.c.a()
        {
          private Void aVo()
          {
            AppMethodBeat.i(47527);
            j.c(j.this);
            Object localObject1 = j.this;
            AppBrandInitConfigWC localAppBrandInitConfigWC = ((o)localObject1).aTS();
            if ((localAppBrandInitConfigWC == null) || (localAppBrandInitConfigWC.cce == null) || (localAppBrandInitConfigWC.cce.jDQ != 7))
            {
              ac.i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
              localObject1 = Jql;
              AppMethodBeat.o(47527);
              return localObject1;
            }
            String str1 = localAppBrandInitConfigWC.cce.jDT;
            ac.d("MicroMsg.OpenSdkJsApiProcessor", "openapiInvokeData:%s", new Object[] { str1 });
            JSONObject localJSONObject1;
            JSONObject localJSONObject2;
            com.tencent.mm.plugin.appbrand.z.i locali;
            label152:
            String str2;
            do
            {
              try
              {
                localJSONObject1 = new JSONObject(str1);
                localJSONObject2 = new JSONObject(localJSONObject1.getString("args"));
                locali = new com.tencent.mm.plugin.appbrand.z.i();
                if (((o)localObject1).Dz().a(locali) != l.jsB) {
                  break;
                }
                Iterator localIterator = localJSONObject2.keys();
                for (;;)
                {
                  if (!localIterator.hasNext()) {
                    break label340;
                  }
                  str2 = (String)localIterator.next();
                  localObject2 = localJSONObject2.getString(str2);
                  if (!y.Ry((String)localObject2)) {
                    break;
                  }
                  localJSONObject2.put(str2, y.a((o)localObject1, (String)locali.value, (String)localObject2));
                }
              }
              catch (JSONException localJSONException)
              {
                ac.m("MicroMsg.OpenSdkJsApiProcessor", "", new Object[] { localJSONException });
              }
            } while (!y.Rz((String)localObject2));
            Object localObject2 = new JSONArray((String)localObject2);
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              if (i < ((JSONArray)localObject2).length())
              {
                String str3 = ((JSONArray)localObject2).getString(i);
                if (y.Ry(str3)) {
                  localJSONArray.put(y.a(localJSONException, (String)locali.value, str3));
                } else {
                  localJSONArray.put(str3);
                }
              }
              else
              {
                localJSONObject2.put(str2, localJSONArray.toString());
                break label152;
                label340:
                localJSONObject1.put("args", localJSONObject2.toString());
                localAppBrandInitConfigWC.cce.jDT = localJSONObject1.toString();
                ac.d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", new Object[] { str1 });
                break;
              }
              i += 1;
            }
          }
        }).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(47529);
      }
    });
    a(AssetReader.jly);
    aTO();
    this.jge.a(this.mAppId, aTS().joY, e.i(aTS()));
    com.tencent.mm.sdk.f.a.jg(this.mContext).setRequestedOrientation(1);
    com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
    com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.x(this);
    com.tencent.mm.plugin.appbrand.backgroundfetch.i.x(this);
    AppMethodBeat.o(47531);
  }
  
  @SuppressLint({"MissingSuperCall"})
  public final void onReady()
  {
    AppMethodBeat.i(47532);
    c localc = this.lqZ;
    Object localObject1 = aTS().cce.jDT;
    k.h(localObject1, "invokeData");
    ac.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke with appId(" + localc.lqS.mAppId + ") data(" + (String)localObject1 + ')');
    String str1;
    String str2;
    String str3;
    int i;
    try
    {
      localObject1 = new com.tencent.mm.ab.i((String)localObject1);
      str1 = ((com.tencent.mm.ab.i)localObject1).optString("name");
      str2 = ((com.tencent.mm.ab.i)localObject1).optString("args");
      str3 = ((com.tencent.mm.ab.i)localObject1).optString("transitiveData");
      localCharSequence = (CharSequence)str1;
      if (localCharSequence == null) {
        break label455;
      }
      if (localCharSequence.length() != 0) {
        break label469;
      }
    }
    catch (com.tencent.mm.ab.g localg)
    {
      do
      {
        CharSequence localCharSequence;
        ac.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke, json parse e = ".concat(String.valueOf(localg)));
        AppMethodBeat.o(47532);
        return;
        switch (localg.hashCode())
        {
        }
      } while (!localg.equals("webview"));
      localObject2 = localc.lqS.aTT();
      k.g(localObject2, "runtime.pageContainer");
      localObject2 = ((com.tencent.mm.plugin.appbrand.page.v)localObject2).getPageView();
      if (localObject2 != null) {
        break label425;
      }
      localObject2 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(47532);
      throw ((Throwable)localObject2);
    }
    catch (RuntimeException localRuntimeException)
    {
      label159:
      label174:
      AppMethodBeat.o(47532);
      return;
    }
    if (i == 0)
    {
      localCharSequence = (CharSequence)str2;
      if (localCharSequence != null) {
        if (localCharSequence.length() != 0) {
          break label474;
        }
      }
    }
    else
    {
      localc.dM(str3, "fail invalid args");
      AppMethodBeat.o(47532);
      return;
      localObject1 = ((com.tencent.mm.ab.i)localObject1).optString("jsapiType");
      if (localObject1 != null) {}
    }
    for (;;)
    {
      localc.dM(str3, "fail invalid args");
      localObject1 = (Throwable)new RuntimeException();
      AppMethodBeat.o(47532);
      throw ((Throwable)localObject1);
      Object localObject2;
      if (localRuntimeException.equals("appservice"))
      {
        Object localObject3 = localc.lqS.aTU();
        if (localObject3 == null)
        {
          localObject3 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(47532);
          throw ((Throwable)localObject3);
        }
        label425:
        for (localObject3 = (m)localObject3;; localObject3 = (m)localObject3)
        {
          localc.lqQ += 1;
          i = localc.lqQ;
          localc.lqR.put(i, new n(str3));
          if (localObject3 != null) {
            break;
          }
          localObject3 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
          AppMethodBeat.o(47532);
          throw ((Throwable)localObject3);
        }
        ((d)localObject3).x(str1, str2, i);
        AppMethodBeat.o(47532);
        return;
        label455:
        i = 1;
        break;
        label469:
        label474:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label477;
          }
          break label159;
          i = 0;
          break;
        }
        label477:
        break label174;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j
 * JD-Core Version:    0.7.0.1
 */