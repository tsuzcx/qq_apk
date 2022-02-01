package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.luggage.sdk.processes.main.LuggageRegisterTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.file.ax;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Iterator;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends w
{
  public volatile c tfX;
  public a tfY;
  
  public l(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject)
  {
    AppMethodBeat.i(319965);
    super.a(paramAppBrandInitConfig, paramObject);
    if (this.tfY != null) {
      this.tfY.onRuntimeReceiveReturnData(paramAppBrandInitConfig, paramObject);
    }
    AppMethodBeat.o(319965);
  }
  
  public final com.tencent.mm.plugin.appbrand.q.a asD()
  {
    AppMethodBeat.i(47533);
    com.tencent.mm.plugin.appbrand.q.a.c localc = new com.tencent.mm.plugin.appbrand.q.a.c();
    AppMethodBeat.o(47533);
    return localc;
  }
  
  final void cBq()
  {
    AppMethodBeat.i(319955);
    super.Y(new l.2(this, AndroidContextUtil.castActivityOrNull(this.mContext)));
    AppMethodBeat.o(319955);
  }
  
  public final k cBr()
  {
    AppMethodBeat.i(319958);
    k localk = (k)super.ccK();
    AppMethodBeat.o(319958);
    return localk;
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.ah cbu()
  {
    AppMethodBeat.i(47530);
    h localh = new h(AndroidContextUtil.castActivityOrNull(this.mContext));
    AppMethodBeat.o(47530);
    return localh;
  }
  
  public final com.tencent.mm.plugin.appbrand.l.b ccA()
  {
    return com.tencent.mm.plugin.appbrand.l.b.ruj;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(47531);
    ccJ();
    ccE();
    com.tencent.mm.plugin.appbrand.report.quality.b.S(this);
    b(b.c.class, i.tfS);
    b(com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.c.class, i.tfS);
    a(new AppBrandRuntime.b()
    {
      public final void prepare()
      {
        AppMethodBeat.i(47529);
        g.jPX().h(new com.tencent.mm.vending.c.a()
        {
          private Void ceW()
          {
            AppMethodBeat.i(47527);
            l.c(l.this);
            Object localObject2 = l.this;
            Object localObject1 = ((w)localObject2).getInitConfig();
            if ((localObject1 == null) || (((AppBrandInitConfigWC)localObject1).eoV == null) || (((AppBrandInitConfigWC)localObject1).eoV.qYE != 7))
            {
              Log.i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
              localObject1 = aguz;
              AppMethodBeat.o(47527);
              return localObject1;
            }
            String str1 = com.tencent.mm.plugin.appbrand.utils.ah.l((AppBrandInitConfigWC)localObject1);
            Log.d("MicroMsg.OpenSdkJsApiProcessor", "openapiInvokeData:%s", new Object[] { str1 });
            JSONObject localJSONObject1;
            JSONObject localJSONObject2;
            com.tencent.mm.plugin.appbrand.af.k localk;
            label149:
            String str2;
            do
            {
              try
              {
                localJSONObject1 = new JSONObject(str1);
                localJSONObject2 = new JSONObject(localJSONObject1.getString("args"));
                localk = new com.tencent.mm.plugin.appbrand.af.k();
                if (((w)localObject2).asx().a(localk) != com.tencent.mm.plugin.appbrand.appstorage.r.qML) {
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
                  if ((!(localObject3 instanceof String)) || (!com.tencent.mm.plugin.appbrand.utils.ah.agH((String)localObject3))) {
                    break;
                  }
                  localJSONObject2.put(str2, com.tencent.mm.plugin.appbrand.utils.ah.a((w)localObject2, (String)localk.value, (String)localObject3));
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
                if (((localObject4 instanceof String)) && (com.tencent.mm.plugin.appbrand.utils.ah.agH((String)localObject4))) {
                  ((JSONArray)localObject3).put(com.tencent.mm.plugin.appbrand.utils.ah.a((w)localObject2, (String)localk.value, (String)localObject4));
                }
              }
              else
              {
                localJSONObject2.put(str2, localObject3);
                break label149;
                label340:
                localJSONObject1.put("args", localJSONObject2.toString());
                localObject2 = localJSONObject1.toString();
                if (!TextUtils.isEmpty(localJSONException.qYh)) {
                  localJSONException.qYh = ((String)localObject2);
                }
                for (;;)
                {
                  Log.d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", new Object[] { str1 });
                  break;
                  localJSONException.eoV.qYH = ((String)localObject2);
                }
              }
              i += 1;
            }
          }
        }).b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(47529);
      }
    });
    b(AssetReader.qDV);
    new LuggageRegisterTask(this).bQt();
    AndroidContextUtil.castActivityOrNull(this.mContext).setRequestedOrientation(1);
    com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
    com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.z(this);
    com.tencent.mm.plugin.appbrand.backgroundfetch.i.z(this);
    AppMethodBeat.o(47531);
  }
  
  public final void onReady()
  {
    AppMethodBeat.i(47532);
    Object localObject2 = this.tfX;
    String str = com.tencent.mm.plugin.appbrand.utils.ah.l(getInitConfig());
    boolean bool = com.tencent.mm.plugin.appbrand.utils.ah.m(getInitConfig());
    s.u(str, "invokeData");
    Object localObject1;
    if (((c)localObject2).tfN.getInitConfig().epg != null) {
      localObject1 = (o)new r(((c)localObject2).tfN);
    }
    for (;;)
    {
      ((c)localObject2).tfO = ((o)localObject1);
      localObject2 = ((c)localObject2).tfO;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("invokeProcess");
        localObject1 = null;
      }
      ((o)localObject1).adv(str);
      AppMethodBeat.o(47532);
      return;
      if (bool) {
        localObject1 = (o)new NewSDKInvokeProcess(((c)localObject2).tfN);
      } else {
        localObject1 = (o)new q(((c)localObject2).tfN);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onRuntimeReceiveReturnData(AppBrandInitConfig paramAppBrandInitConfig, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l
 * JD-Core Version:    0.7.0.1
 */