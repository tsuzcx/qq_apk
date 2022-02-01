package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.s.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.Metadata;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "Reporter", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends c<ad>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "loadJsFiles";
  public static final a rXv;
  
  static
  {
    AppMethodBeat.i(147945);
    rXv = new a((byte)0);
    AppMethodBeat.o(147945);
  }
  
  public static final void a(AppBrandRuntime paramAppBrandRuntime, JSONArray paramJSONArray, i parami, com.tencent.mm.plugin.appbrand.appcache.s params, String paramString, b paramb)
  {
    AppMethodBeat.i(329050);
    a.a(paramAppBrandRuntime, paramJSONArray, parami, params, paramString, paramb);
    AppMethodBeat.o(329050);
  }
  
  public final boolean cpE()
  {
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "loadJsFiles", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "paths", "Lorg/json/JSONArray;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "scriptProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "reportKey", "reporter", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "toJavascriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(AppBrandRuntime paramAppBrandRuntime, JSONArray paramJSONArray, i parami, com.tencent.mm.plugin.appbrand.appcache.s params, String paramString, w.b paramb)
    {
      AppMethodBeat.i(328981);
      kotlin.g.b.s.u(paramAppBrandRuntime, "runtime");
      if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
      {
        if (paramb != null)
        {
          paramAppBrandRuntime = (d.a[])new d.a[0];
          l1 = Util.nowMilliSecond();
          long l2 = Util.nowMilliSecond();
          paramb.a(paramString, paramAppBrandRuntime, new boolean[0], new Object[0], l1, l2);
        }
        AppMethodBeat.o(328981);
        return;
      }
      if (parami == null)
      {
        AppMethodBeat.o(328981);
        return;
      }
      if (params == null)
      {
        AppMethodBeat.o(328981);
        return;
      }
      String str = paramAppBrandRuntime.mAppId;
      long l1 = Util.nowMilliSecond();
      d.a[] arrayOfa = new d.a[paramJSONArray.length()];
      final int i = 0;
      int j = paramJSONArray.length();
      final boolean[] arrayOfBoolean = new boolean[j];
      while (i < j)
      {
        arrayOfBoolean[i] = false;
        i += 1;
      }
      final Object[] arrayOfObject = new Object[paramJSONArray.length()];
      i = 0;
      int k = paramJSONArray.length();
      Object localObject;
      if (k > 0)
      {
        j = i + 1;
        localObject = paramJSONArray.optString(i, null);
        if (localObject != null) {
          if (i != paramJSONArray.length() - 1) {
            break label324;
          }
        }
      }
      s.a locala1;
      label311:
      label324:
      for (final w.a..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = new w.a..ExternalSyntheticLambda0(paramb, paramString, arrayOfa, arrayOfBoolean, arrayOfObject, l1);; localExternalSyntheticLambda0 = null)
      {
        locala1 = params.Ve((String)localObject);
        if (locala1 != null) {
          break;
        }
        Log.e("Luggage.WXA.JsApiLoadJsFiles", "loadJsFiles appId[" + str + "] path[" + (String)localObject + "] EMPTY");
        if (localExternalSyntheticLambda0 != null) {
          localExternalSyntheticLambda0.onReceiveValue("404");
        }
        arrayOfa[i] = null;
        arrayOfBoolean[i] = false;
        arrayOfObject[i] = null;
        if (j < k) {
          break label565;
        }
        AppMethodBeat.o(328981);
        return;
      }
      final d.a locala = new d.a();
      locala.qEr = locala1.qEr;
      locala.appVersion = locala1.appVersion;
      locala.qEs = locala1.qEs;
      locala.qEt = locala1.qEt;
      locala.qEu = locala1.qEu;
      locala.fileName = locala1.fileName;
      locala.qEv = locala1.qEv;
      locala.qEw = locala1.qEw;
      locala.eqQ = locala1.qEw;
      locala.scriptName = ((String)localObject);
      arrayOfa[i] = locala;
      if ((v)parami.Z(v.class) == null)
      {
        localObject = params.Vd((String)localObject);
        kotlin.g.b.s.checkNotNull(localObject);
        localObject = org.apache.commons.b.d.a((InputStream)localObject, kotlin.n.d.UTF_8);
        if (localObject != null) {
          break label572;
        }
        localObject = "";
      }
      label565:
      label572:
      for (;;)
      {
        locala.eqP = ((String)localObject);
        locala.eqQ = ((String)localObject).length();
        z.a(parami, (String)localObject, (z.a)new a(arrayOfBoolean, i, localExternalSyntheticLambda0));
        break label311;
        aa.a(paramAppBrandRuntime, parami, (String)localObject, locala1, (z.a)new b(localExternalSyntheticLambda0, arrayOfBoolean, i, locala, arrayOfObject));
        break label311;
        i = j;
        break;
      }
    }
    
    private static final void a(w.b paramb, String paramString1, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong, String paramString2)
    {
      AppMethodBeat.i(328988);
      kotlin.g.b.s.u(paramArrayOfa, "$reportScripts");
      kotlin.g.b.s.u(paramArrayOfBoolean, "$reportResults");
      kotlin.g.b.s.u(paramArrayOfObject, "$reportExtras");
      long l = Util.nowMilliSecond();
      if (paramb != null) {
        paramb.a(paramString1, paramArrayOfa, paramArrayOfBoolean, paramArrayOfObject, paramLong, l);
      }
      AppMethodBeat.o(328988);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$loadJsFiles$1", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallback;", "onFailure", "", "ret", "", "onSuccess", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements z.a
    {
      a(boolean[] paramArrayOfBoolean, int paramInt, ValueCallback<String> paramValueCallback) {}
      
      public final void eW(String paramString)
      {
        AppMethodBeat.i(328937);
        this.rXw[i] = false;
        ValueCallback localValueCallback = localExternalSyntheticLambda0;
        if (localValueCallback != null) {
          localValueCallback.onReceiveValue(paramString);
        }
        AppMethodBeat.o(328937);
      }
      
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(328930);
        this.rXw[i] = true;
        ValueCallback localValueCallback = localExternalSyntheticLambda0;
        if (localValueCallback != null) {
          localValueCallback.onReceiveValue(paramString);
        }
        AppMethodBeat.o(328930);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$loadJsFiles$2", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallbackV8Ex;", "condition", "", "ret", "", "countdownAndCallback", "", "onFailure", "onResult", "details", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine$ExecuteDetails;", "onSuccess", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements z.b
    {
      private String hLS;
      private int rXy = 2;
      
      b(ValueCallback<String> paramValueCallback, boolean[] paramArrayOfBoolean, int paramInt, d.a parama, Object[] paramArrayOfObject) {}
      
      private final void csd()
      {
        AppMethodBeat.i(328931);
        this.rXy -= 1;
        if (this.rXy == 0)
        {
          ValueCallback localValueCallback = this.rXx;
          if (localValueCallback != null) {
            localValueCallback.onReceiveValue(this.hLS);
          }
        }
        AppMethodBeat.o(328931);
      }
      
      public final void a(m.c paramc)
      {
        AppMethodBeat.i(328950);
        if ((paramc != null) && (paramc.sourceLength > 0)) {
          locala.eqQ = paramc.sourceLength;
        }
        arrayOfObject[i] = paramc;
        csd();
        AppMethodBeat.o(328950);
      }
      
      public final void eW(String paramString)
      {
        AppMethodBeat.i(328946);
        arrayOfBoolean[i] = false;
        this.hLS = paramString;
        csd();
        AppMethodBeat.o(328946);
      }
      
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(328939);
        arrayOfBoolean[i] = true;
        this.hLS = paramString;
        csd();
        AppMethodBeat.o(328939);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "", "batchReportEvaluateDetails", "", "reportKey", "", "scripts", "", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "results", "", "extras", "evalStartMs", "", "evalEndMs", "(Ljava/lang/String;[Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;[Z[Ljava/lang/Object;JJ)V", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$invoke$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "batchReportEvaluateDetails", "", "reportKey", "", "scripts", "", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "results", "", "extras", "", "evalStartMs", "", "evalEndMs", "(Ljava/lang/String;[Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;[Z[Ljava/lang/Object;JJ)V", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements w.b
  {
    c(ad paramad, JSONArray paramJSONArray, int paramInt, w paramw) {}
    
    public final void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(328984);
      kotlin.g.b.s.u(paramArrayOfa, "scripts");
      kotlin.g.b.s.u(paramArrayOfBoolean, "results");
      kotlin.g.b.s.u(paramArrayOfObject, "extras");
      Object localObject = new StringBuilder("invoke with appId:").append(this.rHK.getAppId()).append(" paths:").append(this.rXB).append(" key:").append(paramString).append(", results:");
      String str = Arrays.toString(paramArrayOfBoolean);
      kotlin.g.b.s.s(str, "java.util.Arrays.toString(this)");
      Log.i("Luggage.WXA.JsApiLoadJsFiles", str);
      this.rHK.callback(this.rxe, this.rXC.ZP("ok"));
      localObject = (w.b)this.rHK.aa(w.b.class);
      if (localObject != null) {
        ((w.b)localObject).a(paramString, paramArrayOfa, paramArrayOfBoolean, paramArrayOfObject, paramLong1, paramLong2);
      }
      AppMethodBeat.o(328984);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.w
 * JD-Core Version:    0.7.0.1
 */