package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.utils.u;
import com.tencent.mm.plugin.appbrand.utils.u.a;
import com.tencent.mm.plugin.appbrand.utils.u.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "Reporter", "luggage-wechat-full-sdk_release"})
public final class w
  extends c<ad>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "loadJsFiles";
  public static final a oRV;
  
  static
  {
    AppMethodBeat.i(147945);
    oRV = new a((byte)0);
    AppMethodBeat.o(147945);
  }
  
  public static final void a(AppBrandRuntime paramAppBrandRuntime, JSONArray paramJSONArray, i parami, q paramq, String paramString, b paramb)
  {
    AppMethodBeat.i(243963);
    a.a(paramAppBrandRuntime, paramJSONArray, parami, paramq, paramString, paramb);
    AppMethodBeat.o(243963);
  }
  
  public final boolean bPy()
  {
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "loadJsFiles", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "paths", "Lorg/json/JSONArray;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "scriptProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "reportKey", "reporter", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "toJavascriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static void a(AppBrandRuntime paramAppBrandRuntime, JSONArray paramJSONArray, i parami, q paramq, final String paramString, w.b paramb)
    {
      AppMethodBeat.i(244170);
      p.k(paramAppBrandRuntime, "runtime");
      if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
      {
        if (paramb != null)
        {
          l1 = Util.nowMilliSecond();
          long l2 = Util.nowMilliSecond();
          paramb.a(paramString, new d.a[0], new boolean[0], new Object[0], l1, l2);
          AppMethodBeat.o(244170);
          return;
        }
        AppMethodBeat.o(244170);
        return;
      }
      if (parami == null)
      {
        AppMethodBeat.o(244170);
        return;
      }
      if (paramq == null)
      {
        AppMethodBeat.o(244170);
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
              locala1 = paramq.acF((String)localObject);
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
            if ((com.tencent.mm.plugin.appbrand.m.v)parami.Q(com.tencent.mm.plugin.appbrand.m.v.class) == null)
            {
              localObject = paramq.acE((String)localObject);
              if (localObject == null) {
                p.iCn();
              }
              localObject = org.apache.commons.a.d.a((InputStream)localObject, kotlin.n.d.UTF_8);
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
        locala.cyv = ((String)localObject);
        locala.cyw = ((String)localObject).length();
        u.a(parami, (String)localObject, (u.a)new a(arrayOfBoolean, i, localValueCallback));
        break;
        com.tencent.mm.plugin.appbrand.utils.v.a(paramAppBrandRuntime, parami, (String)localObject, locala1, (u.a)new b(localValueCallback, arrayOfBoolean, i, locala, arrayOfObject));
        break;
        AppMethodBeat.o(244170);
        return;
      }
    }
    
    private static d.a b(q.a parama)
    {
      AppMethodBeat.i(244168);
      d.a locala = new d.a();
      locala.a(parama);
      locala.cyw = parama.nEz;
      AppMethodBeat.o(244168);
      return locala;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$loadJsFiles$1", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallback;", "onFailure", "", "ret", "", "onSuccess", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements u.a
    {
      a(boolean[] paramArrayOfBoolean, int paramInt, ValueCallback paramValueCallback) {}
      
      public final void dL(String paramString)
      {
        AppMethodBeat.i(239110);
        this.oRW[i] = false;
        ValueCallback localValueCallback = localValueCallback;
        if (localValueCallback != null)
        {
          localValueCallback.onReceiveValue(paramString);
          AppMethodBeat.o(239110);
          return;
        }
        AppMethodBeat.o(239110);
      }
      
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(239109);
        this.oRW[i] = true;
        ValueCallback localValueCallback = localValueCallback;
        if (localValueCallback != null)
        {
          localValueCallback.onReceiveValue(paramString);
          AppMethodBeat.o(239109);
          return;
        }
        AppMethodBeat.o(239109);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$loadJsFiles$2", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallbackV8Ex;", "condition", "", "ret", "", "countdownAndCallback", "", "onFailure", "onResult", "details", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine$ExecuteDetails;", "onSuccess", "luggage-wechat-full-sdk_release"})
    public static final class b
      implements u.b
    {
      private String fGw;
      private int oRY = 2;
      
      b(ValueCallback paramValueCallback, boolean[] paramArrayOfBoolean, int paramInt, d.a parama, Object[] paramArrayOfObject) {}
      
      private final void bRZ()
      {
        AppMethodBeat.i(244047);
        this.oRY -= 1;
        if (this.oRY == 0)
        {
          ValueCallback localValueCallback = this.oRX;
          if (localValueCallback != null)
          {
            localValueCallback.onReceiveValue(this.fGw);
            AppMethodBeat.o(244047);
            return;
          }
        }
        AppMethodBeat.o(244047);
      }
      
      public final void a(m.c paramc)
      {
        AppMethodBeat.i(244053);
        if ((paramc != null) && (paramc.sourceLength > 0)) {
          locala.cyw = paramc.sourceLength;
        }
        arrayOfObject[i] = paramc;
        bRZ();
        AppMethodBeat.o(244053);
      }
      
      public final void dL(String paramString)
      {
        AppMethodBeat.i(244052);
        arrayOfBoolean[i] = false;
        this.fGw = paramString;
        bRZ();
        AppMethodBeat.o(244052);
      }
      
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(244050);
        arrayOfBoolean[i] = true;
        this.fGw = paramString;
        bRZ();
        AppMethodBeat.o(244050);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onReceiveValue"})
    static final class c<T>
      implements ValueCallback<String>
    {
      c(w.b paramb, String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "", "batchReportEvaluateDetails", "", "reportKey", "", "scripts", "", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "results", "", "extras", "evalStartMs", "", "evalEndMs", "(Ljava/lang/String;[Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;[Z[Ljava/lang/Object;JJ)V", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$invoke$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "batchReportEvaluateDetails", "", "reportKey", "", "scripts", "", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "results", "", "extras", "", "evalStartMs", "", "evalEndMs", "(Ljava/lang/String;[Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;[Z[Ljava/lang/Object;JJ)V", "luggage-wechat-full-sdk_release"})
  public static final class c
    implements w.b
  {
    c(ad paramad, JSONArray paramJSONArray, int paramInt) {}
    
    public final void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(240764);
      p.k(paramArrayOfa, "scripts");
      p.k(paramArrayOfBoolean, "results");
      p.k(paramArrayOfObject, "extras");
      Object localObject = new StringBuilder("invoke with appId:").append(this.oEB.getAppId()).append(" paths:").append(this.oSg).append(" key:").append(paramString).append(", results:");
      String str = Arrays.toString(paramArrayOfBoolean);
      p.j(str, "java.util.Arrays.toString(this)");
      Log.i("Luggage.WXA.JsApiLoadJsFiles", str);
      this.oEB.j(this.otk, this.oSf.agS("ok"));
      localObject = (w.b)this.oEB.R(w.b.class);
      if (localObject != null)
      {
        ((w.b)localObject).a(paramString, paramArrayOfa, paramArrayOfBoolean, paramArrayOfObject, paramLong1, paramLong2);
        AppMethodBeat.o(240764);
        return;
      }
      AppMethodBeat.o(240764);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.w
 * JD-Core Version:    0.7.0.1
 */