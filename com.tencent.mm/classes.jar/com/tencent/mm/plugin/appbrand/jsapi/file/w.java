package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.appbrand.utils.s.b;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import org.apache.commons.a.e;
import org.json.JSONArray;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "Reporter", "luggage-wechat-full-sdk_release"})
public final class w
  extends com.tencent.mm.plugin.appbrand.jsapi.d<ac>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "loadJsFiles";
  public static final a lUW;
  
  static
  {
    AppMethodBeat.i(147945);
    lUW = new a((byte)0);
    AppMethodBeat.o(147945);
  }
  
  public static final void a(AppBrandRuntime paramAppBrandRuntime, JSONArray paramJSONArray, i parami, q paramq, String paramString, b paramb)
  {
    AppMethodBeat.i(230091);
    a.a(paramAppBrandRuntime, paramJSONArray, parami, paramq, paramString, paramb);
    AppMethodBeat.o(230091);
  }
  
  public final boolean bEa()
  {
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "loadJsFiles", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "paths", "Lorg/json/JSONArray;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "scriptProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "reportKey", "reporter", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "toJavascriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static void a(AppBrandRuntime paramAppBrandRuntime, JSONArray paramJSONArray, i parami, q paramq, final String paramString, w.b paramb)
    {
      AppMethodBeat.i(230089);
      p.h(paramAppBrandRuntime, "runtime");
      if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
      {
        if (paramb != null)
        {
          l1 = Util.nowMilliSecond();
          long l2 = Util.nowMilliSecond();
          paramb.a(paramString, new d.a[0], new boolean[0], new Object[0], l1, l2);
          AppMethodBeat.o(230089);
          return;
        }
        AppMethodBeat.o(230089);
        return;
      }
      if (parami == null)
      {
        AppMethodBeat.o(230089);
        return;
      }
      if (paramq == null)
      {
        AppMethodBeat.o(230089);
        return;
      }
      String str = paramAppBrandRuntime.getAppId();
      final long l1 = Util.nowMilliSecond();
      final d.a[] arrayOfa = new d.a[paramJSONArray.length()];
      int j = paramJSONArray.length();
      final boolean[] arrayOfBoolean = new boolean[j];
      final int i = 0;
      while (i < j)
      {
        arrayOfBoolean[i] = false;
        i += 1;
      }
      final Object[] arrayOfObject = new Object[paramJSONArray.length()];
      i = 0;
      j = paramJSONArray.length();
      Object localObject;
      final ValueCallback localValueCallback;
      q.a locala1;
      label326:
      final d.a locala;
      for (;;)
      {
        if (i < j)
        {
          localObject = paramJSONArray.optString(i, null);
          if (localObject == null)
          {
            i += 1;
          }
          else
          {
            if (i == paramJSONArray.length() - 1) {}
            for (localValueCallback = (ValueCallback)new c(paramb, paramString, arrayOfa, arrayOfBoolean, arrayOfObject, l1);; localValueCallback = null)
            {
              locala1 = paramq.UV((String)localObject);
              if (locala1 != null) {
                break label326;
              }
              Log.e("Luggage.WXA.JsApiLoadJsFiles", "loadJsFiles appId[" + str + "] path[" + (String)localObject + "] EMPTY");
              if (localValueCallback != null) {
                localValueCallback.onReceiveValue("404");
              }
              arrayOfa[i] = null;
              arrayOfBoolean[i] = false;
              arrayOfObject[i] = null;
              break;
            }
            locala = b(locala1);
            locala.scriptName = ((String)localObject);
            arrayOfa[i] = locala;
            if ((v)parami.R(v.class) == null)
            {
              localObject = paramq.UU((String)localObject);
              if (localObject == null) {
                p.hyc();
              }
              localObject = e.a((InputStream)localObject, kotlin.n.d.UTF_8);
              if (localObject != null) {
                break label478;
              }
              localObject = "";
            }
          }
        }
      }
      label478:
      for (;;)
      {
        locala.czz = ((String)localObject);
        locala.czA = ((String)localObject).length();
        s.a(parami, (String)localObject, (s.a)new a(arrayOfBoolean, i, localValueCallback));
        break;
        t.a(paramAppBrandRuntime, parami, (String)localObject, locala1, (s.a)new b(localValueCallback, arrayOfBoolean, i, locala, arrayOfObject));
        break;
        AppMethodBeat.o(230089);
        return;
      }
    }
    
    private static d.a b(q.a parama)
    {
      AppMethodBeat.i(230088);
      d.a locala = new d.a();
      locala.a(parama);
      locala.czA = parama.kKK;
      AppMethodBeat.o(230088);
      return locala;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$loadJsFiles$1", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallback;", "onFailure", "", "ret", "", "onSuccess", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements s.a
    {
      a(boolean[] paramArrayOfBoolean, int paramInt, ValueCallback paramValueCallback) {}
      
      public final void du(String paramString)
      {
        AppMethodBeat.i(230083);
        this.lUX[i] = false;
        ValueCallback localValueCallback = localValueCallback;
        if (localValueCallback != null)
        {
          localValueCallback.onReceiveValue(paramString);
          AppMethodBeat.o(230083);
          return;
        }
        AppMethodBeat.o(230083);
      }
      
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(230082);
        this.lUX[i] = true;
        ValueCallback localValueCallback = localValueCallback;
        if (localValueCallback != null)
        {
          localValueCallback.onReceiveValue(paramString);
          AppMethodBeat.o(230082);
          return;
        }
        AppMethodBeat.o(230082);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$loadJsFiles$2", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallbackV8Ex;", "condition", "", "ret", "", "countdownAndCallback", "", "onFailure", "onResult", "details", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine$ExecuteDetails;", "onSuccess", "luggage-wechat-full-sdk_release"})
    public static final class b
      implements s.b
    {
      private int condition = 2;
      private String dNk;
      
      b(ValueCallback paramValueCallback, boolean[] paramArrayOfBoolean, int paramInt, d.a parama, Object[] paramArrayOfObject) {}
      
      private final void bGn()
      {
        AppMethodBeat.i(230084);
        this.condition -= 1;
        if (this.condition == 0)
        {
          ValueCallback localValueCallback = this.lUY;
          if (localValueCallback != null)
          {
            localValueCallback.onReceiveValue(this.dNk);
            AppMethodBeat.o(230084);
            return;
          }
        }
        AppMethodBeat.o(230084);
      }
      
      public final void a(m.c paramc)
      {
        AppMethodBeat.i(230087);
        if ((paramc != null) && (paramc.sourceLength > 0)) {
          locala.czA = paramc.sourceLength;
        }
        arrayOfObject[i] = paramc;
        bGn();
        AppMethodBeat.o(230087);
      }
      
      public final void du(String paramString)
      {
        AppMethodBeat.i(230086);
        arrayOfBoolean[i] = false;
        this.dNk = paramString;
        bGn();
        AppMethodBeat.o(230086);
      }
      
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(230085);
        arrayOfBoolean[i] = true;
        this.dNk = paramString;
        bGn();
        AppMethodBeat.o(230085);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onReceiveValue"})
    static final class c<T>
      implements ValueCallback<String>
    {
      c(w.b paramb, String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "", "batchReportEvaluateDetails", "", "reportKey", "", "scripts", "", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "results", "", "extras", "evalStartMs", "", "evalEndMs", "(Ljava/lang/String;[Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;[Z[Ljava/lang/Object;JJ)V", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$invoke$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "batchReportEvaluateDetails", "", "reportKey", "", "scripts", "", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "results", "", "extras", "", "evalStartMs", "", "evalEndMs", "(Ljava/lang/String;[Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;[Z[Ljava/lang/Object;JJ)V", "luggage-wechat-full-sdk_release"})
  public static final class c
    implements w.b
  {
    c(ac paramac, JSONArray paramJSONArray, int paramInt) {}
    
    public final void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(230090);
      p.h(paramArrayOfa, "scripts");
      p.h(paramArrayOfBoolean, "results");
      p.h(paramArrayOfObject, "extras");
      Object localObject = new StringBuilder("invoke with appId:").append(this.lIn.getAppId()).append(" paths:").append(this.lVg).append(" key:").append(paramString).append(", results:");
      String str = Arrays.toString(paramArrayOfBoolean);
      p.g(str, "java.util.Arrays.toString(this)");
      Log.i("Luggage.WXA.JsApiLoadJsFiles", str);
      this.lIn.i(this.lyo, this.lVf.Zf("ok"));
      localObject = (w.b)this.lIn.S(w.b.class);
      if (localObject != null)
      {
        ((w.b)localObject).a(paramString, paramArrayOfa, paramArrayOfBoolean, paramArrayOfObject, paramLong1, paramLong2);
        AppMethodBeat.o(230090);
        return;
      }
      AppMethodBeat.o(230090);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.w
 * JD-Core Version:    0.7.0.1
 */