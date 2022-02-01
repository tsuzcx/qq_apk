package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.sdk.processes.main.LuggageRegisterTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Iterator;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends t
{
  public volatile c qaR;
  private a qaS;
  
  public l(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
  }
  
  @SuppressLint({"MissingSuperCall"})
  public final void NR()
  {
    AppMethodBeat.i(47532);
    c localc = this.qaR;
    String str = ac.h(bDy());
    boolean bool = ac.i(bDy());
    p.k(str, "invokeData");
    o localo;
    if (localc.qaH.bDy().cxc != null) {
      localo = (o)new r(localc.qaH);
    }
    for (;;)
    {
      localc.qaG = localo;
      localo = localc.qaG;
      if (localo == null) {
        p.bGy("invokeProcess");
      }
      localo.akp(str);
      AppMethodBeat.o(47532);
      return;
      if (bool) {
        localo = (o)new NewSDKInvokeProcess(localc.qaH);
      } else {
        localo = (o)new q(localc.qaH);
      }
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.p.a Sn()
  {
    AppMethodBeat.i(47533);
    com.tencent.mm.plugin.appbrand.p.a.c localc = new com.tencent.mm.plugin.appbrand.p.a.c();
    AppMethodBeat.o(47533);
    return localc;
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject)
  {
    AppMethodBeat.i(246091);
    super.a(paramAppBrandInitConfig, paramObject);
    if (this.qaS != null) {
      this.qaS.c(paramAppBrandInitConfig, paramObject);
    }
    AppMethodBeat.o(246091);
  }
  
  public final void a(a parama)
  {
    this.qaS = parama;
  }
  
  public final aa bCe()
  {
    AppMethodBeat.i(47530);
    h localh = new h(AndroidContextUtil.castActivityOrNull(this.mContext));
    AppMethodBeat.o(47530);
    return localh;
  }
  
  public final com.tencent.mm.plugin.appbrand.k.b bDk()
  {
    return com.tencent.mm.plugin.appbrand.k.b.oqy;
  }
  
  final void caW()
  {
    AppMethodBeat.i(246083);
    super.S(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(270634);
        if ((this.val$context instanceof AppBrandPluginUI)) {
          ((AppBrandPluginUI)this.val$context).finish();
        }
        AppMethodBeat.o(270634);
      }
    });
    AppMethodBeat.o(246083);
  }
  
  public final k caX()
  {
    AppMethodBeat.i(246087);
    k localk = (k)super.bDv();
    AppMethodBeat.o(246087);
    return localk;
  }
  
  @SuppressLint({"MissingSuperCall", "SourceLockedOrientationActivity"})
  public final void onCreate()
  {
    AppMethodBeat.i(47531);
    bDu();
    bDp();
    com.tencent.mm.plugin.appbrand.report.quality.b.I(this);
    b(b.c.class, i.qaM);
    b(com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.c.class, i.qaM);
    a(new AppBrandRuntime.b()
    {
      public final void prepare()
      {
        AppMethodBeat.i(47529);
        g.ijP().h(new com.tencent.mm.vending.c.a()
        {
          private Void bFz()
          {
            AppMethodBeat.i(47527);
            l.c(l.this);
            Object localObject2 = l.this;
            Object localObject1 = ((t)localObject2).bDy();
            if ((localObject1 == null) || (((AppBrandInitConfigWC)localObject1).cwV == null) || (((AppBrandInitConfigWC)localObject1).cwV.nYB != 7))
            {
              Log.i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
              localObject1 = YAb;
              AppMethodBeat.o(47527);
              return localObject1;
            }
            String str1 = ac.h((AppBrandInitConfigWC)localObject1);
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
                if (((t)localObject2).Sh().a(locali) != m.nMR) {
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
                  if ((!(localObject3 instanceof String)) || (!ac.ann((String)localObject3))) {
                    break;
                  }
                  localJSONObject2.put(str2, ac.a((t)localObject2, (String)locali.value, (String)localObject3));
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
                if (((localObject4 instanceof String)) && (ac.ann((String)localObject4))) {
                  ((JSONArray)localObject3).put(ac.a((t)localObject2, (String)locali.value, (String)localObject4));
                }
              }
              else
              {
                localJSONObject2.put(str2, localObject3);
                break label149;
                label340:
                localJSONObject1.put("args", localJSONObject2.toString());
                localObject2 = localJSONObject1.toString();
                if (!TextUtils.isEmpty(localJSONException.nYf)) {
                  localJSONException.nYf = ((String)localObject2);
                }
                for (;;)
                {
                  Log.d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", new Object[] { str1 });
                  break;
                  localJSONException.cwV.nYE = ((String)localObject2);
                }
              }
              i += 1;
            }
          }
        }).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(47529);
      }
    });
    a(AssetReader.nEa);
    new LuggageRegisterTask(this).bsM();
    AndroidContextUtil.castActivityOrNull(this.mContext).setRequestedOrientation(1);
    com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
    com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.t(this);
    com.tencent.mm.plugin.appbrand.backgroundfetch.i.t(this);
    AppMethodBeat.o(47531);
  }
  
  public static abstract interface a
  {
    public abstract void c(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l
 * JD-Core Version:    0.7.0.1
 */