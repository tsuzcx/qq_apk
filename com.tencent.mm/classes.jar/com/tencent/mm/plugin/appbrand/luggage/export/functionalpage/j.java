package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
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
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.o.a.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends o
{
  volatile c kPA;
  
  public j(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
  }
  
  public final com.tencent.mm.plugin.appbrand.o.a Ed()
  {
    AppMethodBeat.i(47533);
    a.c localc = new a.c();
    AppMethodBeat.o(47533);
    return localc;
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.v aLO()
  {
    AppMethodBeat.i(47530);
    g localg = new g(com.tencent.mm.sdk.f.a.iV(this.mContext));
    AppMethodBeat.o(47530);
    return localg;
  }
  
  public final b aMS()
  {
    return b.jtU;
  }
  
  @SuppressLint({"MissingSuperCall", "SourceLockedOrientationActivity"})
  public final void onCreate()
  {
    AppMethodBeat.i(47531);
    aMX();
    com.tencent.mm.plugin.appbrand.report.quality.a.K(this);
    a(new AppBrandRuntime.b()
    {
      public final void prepare()
      {
        AppMethodBeat.i(47529);
        com.tencent.mm.co.g.fkM().h(new com.tencent.mm.vending.c.a()
        {
          private Void aOw()
          {
            AppMethodBeat.i(47527);
            j.c(j.this);
            Object localObject1 = j.this;
            AppBrandInitConfigWC localAppBrandInitConfigWC = ((o)localObject1).aNc();
            if ((localAppBrandInitConfigWC == null) || (localAppBrandInitConfigWC.cfi == null) || (localAppBrandInitConfigWC.cfi.jdC != 7))
            {
              ad.i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
              localObject1 = HPQ;
              AppMethodBeat.o(47527);
              return localObject1;
            }
            String str1 = localAppBrandInitConfigWC.cfi.jdF;
            ad.d("MicroMsg.OpenSdkJsApiProcessor", "openapiInvokeData:%s", new Object[] { str1 });
            JSONObject localJSONObject1;
            JSONObject localJSONObject2;
            com.tencent.mm.plugin.appbrand.aa.i locali;
            label152:
            String str2;
            do
            {
              try
              {
                localJSONObject1 = new JSONObject(str1);
                localJSONObject2 = new JSONObject(localJSONObject1.getString("args"));
                locali = new com.tencent.mm.plugin.appbrand.aa.i();
                if (((o)localObject1).DW().a(locali) != l.iSq) {
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
                  if (!x.Np((String)localObject2)) {
                    break;
                  }
                  localJSONObject2.put(str2, x.a((o)localObject1, (String)locali.value, (String)localObject2));
                }
              }
              catch (JSONException localJSONException)
              {
                ad.m("MicroMsg.OpenSdkJsApiProcessor", "", new Object[] { localJSONException });
              }
            } while (!x.Nq((String)localObject2));
            Object localObject2 = new JSONArray((String)localObject2);
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              if (i < ((JSONArray)localObject2).length())
              {
                String str3 = ((JSONArray)localObject2).getString(i);
                if (x.Np(str3)) {
                  localJSONArray.put(x.a(localJSONException, (String)locali.value, str3));
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
                localAppBrandInitConfigWC.cfi.jdF = localJSONObject1.toString();
                ad.d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", new Object[] { str1 });
                break;
              }
              i += 1;
            }
          }
        }).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(47529);
      }
    });
    a(AssetReader.iLr);
    aMY();
    this.iGc.a(this.mAppId, aNc().iOP, e.i(aNc()));
    com.tencent.mm.sdk.f.a.iV(this.mContext).setRequestedOrientation(1);
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
    c localc = this.kPA;
    Object localObject1 = aNc().cfi.jdF;
    k.h(localObject1, "invokeData");
    ad.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke with appId(" + localc.kPt.mAppId + ") data(" + (String)localObject1 + ')');
    String str1;
    String str2;
    String str3;
    int i;
    try
    {
      localObject1 = new com.tencent.mm.ac.i((String)localObject1);
      str1 = ((com.tencent.mm.ac.i)localObject1).optString("name");
      str2 = ((com.tencent.mm.ac.i)localObject1).optString("args");
      str3 = ((com.tencent.mm.ac.i)localObject1).optString("transitiveData");
      localCharSequence = (CharSequence)str1;
      if (localCharSequence == null) {
        break label455;
      }
      if (localCharSequence.length() != 0) {
        break label469;
      }
    }
    catch (com.tencent.mm.ac.g localg)
    {
      do
      {
        CharSequence localCharSequence;
        ad.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke, json parse e = ".concat(String.valueOf(localg)));
        AppMethodBeat.o(47532);
        return;
        switch (localg.hashCode())
        {
        }
      } while (!localg.equals("webview"));
      localObject2 = localc.kPt.aNd();
      k.g(localObject2, "runtime.pageContainer");
      localObject2 = ((u)localObject2).getPageView();
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
      localc.dA(str3, "fail invalid args");
      AppMethodBeat.o(47532);
      return;
      localObject1 = ((com.tencent.mm.ac.i)localObject1).optString("jsapiType");
      if (localObject1 != null) {}
    }
    for (;;)
    {
      localc.dA(str3, "fail invalid args");
      localObject1 = (Throwable)new RuntimeException();
      AppMethodBeat.o(47532);
      throw ((Throwable)localObject1);
      Object localObject2;
      if (localRuntimeException.equals("appservice"))
      {
        Object localObject3 = localc.kPt.aNe();
        if (localObject3 == null)
        {
          localObject3 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(47532);
          throw ((Throwable)localObject3);
        }
        label425:
        for (localObject3 = (m)localObject3;; localObject3 = (m)localObject3)
        {
          localc.kPr += 1;
          i = localc.kPr;
          localc.kPs.put(i, new n(str3));
          if (localObject3 != null) {
            break;
          }
          localObject3 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponentImpl");
          AppMethodBeat.o(47532);
          throw ((Throwable)localObject3);
        }
        ((d)localObject3).w(str1, str2, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j
 * JD-Core Version:    0.7.0.1
 */