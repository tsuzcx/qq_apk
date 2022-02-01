package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.p.a.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Iterator;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends com.tencent.mm.plugin.appbrand.q
{
  public volatile c naC;
  private l.a naD;
  
  public l(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
  }
  
  public final com.tencent.mm.plugin.appbrand.p.a OR()
  {
    AppMethodBeat.i(47533);
    a.c localc = new a.c();
    AppMethodBeat.o(47533);
    return localc;
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject)
  {
    AppMethodBeat.i(227147);
    super.a(paramAppBrandInitConfig, paramObject);
    if (this.naD != null) {
      this.naD.c(paramAppBrandInitConfig, paramObject);
    }
    AppMethodBeat.o(227147);
  }
  
  public final void a(l.a parama)
  {
    this.naD = parama;
  }
  
  final void bOG()
  {
    AppMethodBeat.i(227145);
    super.R(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227144);
        if ((this.val$context instanceof AppBrandPluginUI)) {
          ((AppBrandPluginUI)this.val$context).finish();
        }
        AppMethodBeat.o(227144);
      }
    });
    AppMethodBeat.o(227145);
  }
  
  public final k bOH()
  {
    AppMethodBeat.i(227146);
    k localk = (k)super.bsz();
    AppMethodBeat.o(227146);
    return localk;
  }
  
  public final ab bro()
  {
    AppMethodBeat.i(47530);
    h localh = new h(AndroidContextUtil.castActivityOrNull(this.mContext));
    AppMethodBeat.o(47530);
    return localh;
  }
  
  public final com.tencent.mm.plugin.appbrand.k.b bsq()
  {
    return com.tencent.mm.plugin.appbrand.k.b.lvC;
  }
  
  @SuppressLint({"MissingSuperCall", "SourceLockedOrientationActivity"})
  public final void onCreate()
  {
    AppMethodBeat.i(47531);
    bsy();
    bsv();
    com.tencent.mm.plugin.appbrand.report.quality.b.H(this);
    b(b.b.class, i.nax);
    b(a.b.class, i.nax);
    a(new AppBrandRuntime.b()
    {
      public final void prepare()
      {
        AppMethodBeat.i(47529);
        g.hio().h(new com.tencent.mm.vending.c.a()
        {
          private Void buw()
          {
            AppMethodBeat.i(47527);
            l.c(l.this);
            Object localObject2 = l.this;
            Object localObject1 = ((com.tencent.mm.plugin.appbrand.q)localObject2).bsC();
            if ((localObject1 == null) || (((AppBrandInitConfigWC)localObject1).cys == null) || (((AppBrandInitConfigWC)localObject1).cys.leo != 7))
            {
              Log.i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
              localObject1 = QZL;
              AppMethodBeat.o(47527);
              return localObject1;
            }
            String str1 = aa.m((AppBrandInitConfigWC)localObject1);
            Log.d("MicroMsg.OpenSdkJsApiProcessor", "openapiInvokeData:%s", new Object[] { str1 });
            JSONObject localJSONObject1;
            JSONObject localJSONObject2;
            com.tencent.mm.plugin.appbrand.ac.i locali;
            label149:
            String str2;
            do
            {
              try
              {
                localJSONObject1 = new JSONObject(str1);
                localJSONObject2 = new JSONObject(localJSONObject1.getString("args"));
                locali = new com.tencent.mm.plugin.appbrand.ac.i();
                if (((com.tencent.mm.plugin.appbrand.q)localObject2).OK().a(locali) != m.kSu) {
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
                  if ((!(localObject3 instanceof String)) || (!aa.afL((String)localObject3))) {
                    break;
                  }
                  localJSONObject2.put(str2, aa.a((com.tencent.mm.plugin.appbrand.q)localObject2, (String)locali.value, (String)localObject3));
                }
              }
              catch (JSONException localJSONException)
              {
                Log.printInfoStack("MicroMsg.OpenSdkJsApiProcessor", "", new Object[] { localJSONException });
              }
            } while (!(localObject3 instanceof JSONArray));
            Object localObject3 = (JSONArray)localObject3;
            int i = 0;
            for (;;)
            {
              if (i < ((JSONArray)localObject3).length())
              {
                Object localObject4 = ((JSONArray)localObject3).get(i);
                if (((localObject4 instanceof String)) && (aa.afL((String)localObject4))) {
                  ((JSONArray)localObject3).put(aa.a((com.tencent.mm.plugin.appbrand.q)localObject2, (String)locali.value, (String)localObject4));
                }
              }
              else
              {
                localJSONObject2.put(str2, localObject3);
                break label149;
                label340:
                localJSONObject1.put("args", localJSONObject2.toString());
                localObject2 = localJSONObject1.toString();
                if (!TextUtils.isEmpty(localJSONException.ldR)) {
                  localJSONException.ldR = ((String)localObject2);
                }
                for (;;)
                {
                  Log.d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", new Object[] { str1 });
                  break;
                  localJSONException.cys.ler = ((String)localObject2);
                }
              }
              i += 1;
            }
          }
        }).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(47529);
      }
    });
    a(AssetReader.kKj);
    this.kDi.N(this);
    AndroidContextUtil.castActivityOrNull(this.mContext).setRequestedOrientation(1);
    com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
    com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.s(this);
    com.tencent.mm.plugin.appbrand.backgroundfetch.i.s(this);
    AppMethodBeat.o(47531);
  }
  
  @SuppressLint({"MissingSuperCall"})
  public final void onReady()
  {
    AppMethodBeat.i(47532);
    c localc = this.naC;
    String str = aa.m(bsC());
    boolean bool = aa.n(bsC());
    p.h(str, "invokeData");
    o localo;
    if (localc.nas.bsC().cyx != null) {
      localo = (o)new r(localc.nas);
    }
    for (;;)
    {
      localc.nar = localo;
      localo = localc.nar;
      if (localo == null) {
        p.btv("invokeProcess");
      }
      localo.acv(str);
      AppMethodBeat.o(47532);
      return;
      if (bool) {
        localo = (o)new NewSDKInvokeProcess(localc.nas);
      } else {
        localo = (o)new q(localc.nas);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l
 * JD-Core Version:    0.7.0.1
 */