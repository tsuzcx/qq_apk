package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.d;
import java.io.InputStream;
import org.apache.commons.a.e;
import org.json.JSONArray;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class w
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.page.z>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "loadJsFiles";
  public static final a kPY;
  
  static
  {
    AppMethodBeat.i(147945);
    kPY = new a((byte)0);
    AppMethodBeat.o(147945);
  }
  
  public static final void a(AppBrandRuntime paramAppBrandRuntime, JSONArray paramJSONArray, i parami, com.tencent.mm.plugin.appbrand.appcache.q paramq)
  {
    AppMethodBeat.i(220961);
    a.a(paramAppBrandRuntime, paramJSONArray, parami, paramq, null, 32);
    AppMethodBeat.o(220961);
  }
  
  public final boolean biK()
  {
    return true;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "loadJsFiles", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "paths", "Lorg/json/JSONArray;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "scriptProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "options", "Lorg/json/JSONObject;", "callback", "Lkotlin/Function0;", "toJsValidationInjectionCallback", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallback;", "Landroid/webkit/ValueCallback;", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    private static void a(AppBrandRuntime paramAppBrandRuntime, JSONArray paramJSONArray, i parami, com.tencent.mm.plugin.appbrand.appcache.q paramq, d.g.a.a<d.z> parama)
    {
      AppMethodBeat.i(220959);
      p.h(paramAppBrandRuntime, "runtime");
      p.h(parama, "callback");
      if (paramJSONArray == null)
      {
        AppMethodBeat.o(220959);
        return;
      }
      if (paramJSONArray.length() <= 0)
      {
        parama.invoke();
        AppMethodBeat.o(220959);
        return;
      }
      if (parami == null)
      {
        AppMethodBeat.o(220959);
        return;
      }
      if (paramq == null)
      {
        AppMethodBeat.o(220959);
        return;
      }
      String str = paramAppBrandRuntime.getAppId();
      int j = paramJSONArray.length();
      int i = 0;
      if (i < j)
      {
        Object localObject2 = paramJSONArray.optString(i, null);
        if (localObject2 == null) {}
        q.a locala;
        for (;;)
        {
          i += 1;
          break;
          if (i == paramJSONArray.length() - 1) {}
          for (localObject1 = (ValueCallback)new b(parama);; localObject1 = null)
          {
            locala = paramq.LM((String)localObject2);
            if (locala != null) {
              break label214;
            }
            ae.e("Luggage.WXA.JsApiLoadJsFiles", "loadJsFiles appId[" + str + "] path[" + (String)localObject2 + "] EMPTY");
            if (localObject1 == null) {
              break;
            }
            ((ValueCallback)localObject1).onReceiveValue("404");
            break;
          }
          label214:
          if ((v)parami.P(v.class) != null) {
            break label265;
          }
          localObject2 = paramq.LL((String)localObject2);
          if (localObject2 == null) {
            p.gkB();
          }
          parami.evaluateJavascript(e.a((InputStream)localObject2, d.UTF_8), (ValueCallback)localObject1);
        }
        label265:
        if (localObject1 == null) {}
        for (Object localObject1 = null;; localObject1 = (s.a)new c((ValueCallback)localObject1))
        {
          t.a(paramAppBrandRuntime, parami, (String)localObject2, locala, (s.a)localObject1);
          break;
        }
      }
      AppMethodBeat.o(220959);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<d.z>
    {
      public static final a kPZ;
      
      static
      {
        AppMethodBeat.i(147937);
        kPZ = new a();
        AppMethodBeat.o(147937);
      }
      
      a()
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "onReceiveValue"})
    static final class b<T>
      implements ValueCallback<String>
    {
      b(d.g.a.a parama) {}
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$toJsValidationInjectionCallback$1", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallback;", "onFailure", "", "ret", "", "onSuccess", "luggage-wechat-full-sdk_release"})
    public static final class c
      implements s.a
    {
      c(ValueCallback<String> paramValueCallback) {}
      
      public final void cV(String paramString)
      {
        AppMethodBeat.i(147940);
        this.kQa.onReceiveValue(paramString);
        AppMethodBeat.o(147940);
      }
      
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(147939);
        this.kQa.onReceiveValue(paramString);
        AppMethodBeat.o(147939);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    b(w paramw, com.tencent.mm.plugin.appbrand.page.z paramz, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.w
 * JD-Core Version:    0.7.0.1
 */