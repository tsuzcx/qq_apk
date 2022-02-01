package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends com.tencent.mm.plugin.appbrand.o
{
  public volatile c lOz;
  
  public l(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
  }
  
  public final com.tencent.mm.plugin.appbrand.m.a Ff()
  {
    AppMethodBeat.i(47533);
    a.c localc = new a.c();
    AppMethodBeat.o(47533);
    return localc;
  }
  
  public final v aVS()
  {
    AppMethodBeat.i(47530);
    h localh = new h(com.tencent.mm.sdk.f.a.jq(this.mContext));
    AppMethodBeat.o(47530);
    return localh;
  }
  
  public final b aWS()
  {
    return b.koD;
  }
  
  @SuppressLint({"MissingSuperCall", "SourceLockedOrientationActivity"})
  public final void onCreate()
  {
    AppMethodBeat.i(47531);
    aWY();
    aWX();
    com.tencent.mm.plugin.appbrand.report.quality.a.B(this);
    b(b.b.class, i.lOv);
    b(a.b.class, i.lOv);
    a(new AppBrandRuntime.b()
    {
      public final void prepare()
      {
        AppMethodBeat.i(47529);
        g.fSm().h(new com.tencent.mm.vending.c.a()
        {
          private Void aYJ()
          {
            AppMethodBeat.i(47527);
            l.c(l.this);
            Object localObject2 = l.this;
            Object localObject1 = ((com.tencent.mm.plugin.appbrand.o)localObject2).aXc();
            if ((localObject1 == null) || (((AppBrandInitConfigWC)localObject1).cmv == null) || (((AppBrandInitConfigWC)localObject1).cmv.jXR != 7))
            {
              ad.i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
              localObject1 = LhQ;
              AppMethodBeat.o(47527);
              return localObject1;
            }
            String str1 = y.j((AppBrandInitConfigWC)localObject1);
            ad.d("MicroMsg.OpenSdkJsApiProcessor", "openapiInvokeData:%s", new Object[] { str1 });
            JSONObject localJSONObject1;
            JSONObject localJSONObject2;
            com.tencent.mm.plugin.appbrand.z.i locali;
            label149:
            String str2;
            do
            {
              try
              {
                localJSONObject1 = new JSONObject(str1);
                localJSONObject2 = new JSONObject(localJSONObject1.getString("args"));
                locali = new com.tencent.mm.plugin.appbrand.z.i();
                if (((com.tencent.mm.plugin.appbrand.o)localObject2).EY().a(locali) != com.tencent.mm.plugin.appbrand.appstorage.l.jMv) {
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
                  if ((!(localObject3 instanceof String)) || (!y.Ve((String)localObject3))) {
                    break;
                  }
                  localJSONObject2.put(str2, y.a((com.tencent.mm.plugin.appbrand.o)localObject2, (String)locali.value, (String)localObject3));
                }
              }
              catch (JSONException localJSONException)
              {
                ad.m("MicroMsg.OpenSdkJsApiProcessor", "", new Object[] { localJSONException });
              }
            } while (!(localObject3 instanceof JSONArray));
            Object localObject3 = (JSONArray)localObject3;
            int i = 0;
            for (;;)
            {
              if (i < ((JSONArray)localObject3).length())
              {
                Object localObject4 = ((JSONArray)localObject3).get(i);
                if (((localObject4 instanceof String)) && (y.Ve((String)localObject4))) {
                  ((JSONArray)localObject3).put(y.a((com.tencent.mm.plugin.appbrand.o)localObject2, (String)locali.value, (String)localObject4));
                }
              }
              else
              {
                localJSONObject2.put(str2, localObject3);
                break label149;
                label340:
                localJSONObject1.put("args", localJSONObject2.toString());
                localObject2 = localJSONObject1.toString();
                if (!TextUtils.isEmpty(localJSONException.jXy)) {
                  localJSONException.jXy = ((String)localObject2);
                }
                for (;;)
                {
                  ad.d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", new Object[] { str1 });
                  break;
                  localJSONException.cmv.jXU = ((String)localObject2);
                }
              }
              i += 1;
            }
          }
        }).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(47529);
      }
    });
    a(AssetReader.jFo);
    this.jzk.a(this.mAppId, aXc().dPf, e.h(aXc()));
    com.tencent.mm.sdk.f.a.jq(this.mContext).setRequestedOrientation(1);
    com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
    com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.o(this);
    com.tencent.mm.plugin.appbrand.backgroundfetch.i.o(this);
    AppMethodBeat.o(47531);
  }
  
  @SuppressLint({"MissingSuperCall"})
  public final void onReady()
  {
    AppMethodBeat.i(47532);
    c localc = this.lOz;
    String str = y.j(aXc());
    int i;
    o localo;
    if (!TextUtils.isEmpty(aXc().jXy))
    {
      i = 1;
      p.h(str, "invokeData");
      if (localc.lOq.aXc().cmA == null) {
        break label110;
      }
      localo = (o)new r(localc.lOq);
    }
    for (;;)
    {
      localc.lOp = localo;
      localo = localc.lOp;
      if (localo == null) {
        p.bcb("invokeProcess");
      }
      localo.Se(str);
      AppMethodBeat.o(47532);
      return;
      i = 0;
      break;
      label110:
      if (i != 0) {
        localo = (o)new NewSDKInvokeProcess(localc.lOq);
      } else {
        localo = (o)new q(localc.lOq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l
 * JD-Core Version:    0.7.0.1
 */