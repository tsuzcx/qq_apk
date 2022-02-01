package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.ui.w;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends com.tencent.mm.plugin.appbrand.p
{
  public volatile c lTa;
  
  public l(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
  }
  
  public final com.tencent.mm.plugin.appbrand.m.a Fk()
  {
    AppMethodBeat.i(47533);
    a.c localc = new a.c();
    AppMethodBeat.o(47533);
    return localc;
  }
  
  public final w aWt()
  {
    AppMethodBeat.i(47530);
    h localh = new h(com.tencent.mm.sdk.f.a.jw(this.mContext));
    AppMethodBeat.o(47530);
    return localh;
  }
  
  public final b aXn()
  {
    return b.krT;
  }
  
  @SuppressLint({"MissingSuperCall", "SourceLockedOrientationActivity"})
  public final void onCreate()
  {
    AppMethodBeat.i(47531);
    aXt();
    aXs();
    com.tencent.mm.plugin.appbrand.report.quality.a.C(this);
    b(b.b.class, i.lSW);
    b(a.b.class, i.lSW);
    a(new AppBrandRuntime.b()
    {
      public final void prepare()
      {
        AppMethodBeat.i(47529);
        g.fWL().h(new com.tencent.mm.vending.c.a()
        {
          private Void aZf()
          {
            AppMethodBeat.i(47527);
            l.c(l.this);
            Object localObject2 = l.this;
            Object localObject1 = ((com.tencent.mm.plugin.appbrand.p)localObject2).aXx();
            if ((localObject1 == null) || (((AppBrandInitConfigWC)localObject1).cmx == null) || (((AppBrandInitConfigWC)localObject1).cmx.kbg != 7))
            {
              ae.i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
              localObject1 = LEs;
              AppMethodBeat.o(47527);
              return localObject1;
            }
            String str1 = aa.j((AppBrandInitConfigWC)localObject1);
            ae.d("MicroMsg.OpenSdkJsApiProcessor", "openapiInvokeData:%s", new Object[] { str1 });
            JSONObject localJSONObject1;
            JSONObject localJSONObject2;
            com.tencent.mm.plugin.appbrand.y.i locali;
            label149:
            String str2;
            do
            {
              try
              {
                localJSONObject1 = new JSONObject(str1);
                localJSONObject2 = new JSONObject(localJSONObject1.getString("args"));
                locali = new com.tencent.mm.plugin.appbrand.y.i();
                if (((com.tencent.mm.plugin.appbrand.p)localObject2).Fd().a(locali) != m.jPM) {
                  break;
                }
                Iterator localIterator = localJSONObject2.keys();
                for (;;)
                {
                  if (!localIterator.hasNext()) {
                    break label340;
                  }
                  str2 = (String)localIterator.next();
                  localObject3 = localJSONObject2.get(str2);
                  if ((!(localObject3 instanceof String)) || (!aa.VP((String)localObject3))) {
                    break;
                  }
                  localJSONObject2.put(str2, aa.a((com.tencent.mm.plugin.appbrand.p)localObject2, (String)locali.value, (String)localObject3));
                }
              }
              catch (JSONException localJSONException)
              {
                ae.m("MicroMsg.OpenSdkJsApiProcessor", "", new Object[] { localJSONException });
              }
            } while (!(localObject3 instanceof JSONArray));
            Object localObject3 = (JSONArray)localObject3;
            int i = 0;
            for (;;)
            {
              if (i < ((JSONArray)localObject3).length())
              {
                Object localObject4 = ((JSONArray)localObject3).get(i);
                if (((localObject4 instanceof String)) && (aa.VP((String)localObject4))) {
                  ((JSONArray)localObject3).put(aa.a((com.tencent.mm.plugin.appbrand.p)localObject2, (String)locali.value, (String)localObject4));
                }
              }
              else
              {
                localJSONObject2.put(str2, localObject3);
                break label149;
                label340:
                localJSONObject1.put("args", localJSONObject2.toString());
                localObject2 = localJSONObject1.toString();
                if (!TextUtils.isEmpty(localJSONException.kaN)) {
                  localJSONException.kaN = ((String)localObject2);
                }
                for (;;)
                {
                  ae.d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", new Object[] { str1 });
                  break;
                  localJSONException.cmx.kbj = ((String)localObject2);
                }
              }
              i += 1;
            }
          }
        }).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(47529);
      }
    });
    a(AssetReader.jIn);
    this.jCl.a(this.mAppId, aXx().dQv, e.h(aXx()));
    com.tencent.mm.sdk.f.a.jw(this.mContext).setRequestedOrientation(1);
    com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
    com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.p(this);
    com.tencent.mm.plugin.appbrand.backgroundfetch.i.p(this);
    AppMethodBeat.o(47531);
  }
  
  @SuppressLint({"MissingSuperCall"})
  public final void onReady()
  {
    AppMethodBeat.i(47532);
    c localc = this.lTa;
    String str = aa.j(aXx());
    int i;
    o localo;
    if (!TextUtils.isEmpty(aXx().kaN))
    {
      i = 1;
      d.g.b.p.h(str, "invokeData");
      if (localc.lSR.aXx().cmC == null) {
        break label110;
      }
      localo = (o)new r(localc.lSR);
    }
    for (;;)
    {
      localc.lSQ = localo;
      localo = localc.lSQ;
      if (localo == null) {
        d.g.b.p.bdF("invokeProcess");
      }
      localo.SN(str);
      AppMethodBeat.o(47532);
      return;
      i = 0;
      break;
      label110:
      if (i != 0) {
        localo = (o)new NewSDKInvokeProcess(localc.lSR);
      } else {
        localo = (o)new q(localc.lSR);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l
 * JD-Core Version:    0.7.0.1
 */