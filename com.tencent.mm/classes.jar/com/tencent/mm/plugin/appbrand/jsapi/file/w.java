package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.n.d;
import d.z;
import java.io.InputStream;
import org.apache.commons.a.e;
import org.json.JSONArray;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class w
  extends com.tencent.mm.plugin.appbrand.jsapi.a<aa>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "loadJsFiles";
  public static final a kMI;
  
  static
  {
    AppMethodBeat.i(147945);
    kMI = new a((byte)0);
    AppMethodBeat.o(147945);
  }
  
  public static final void a(AppBrandRuntime paramAppBrandRuntime, JSONArray paramJSONArray, i parami, com.tencent.mm.plugin.appbrand.appcache.q paramq)
  {
    AppMethodBeat.i(183055);
    a.a(paramAppBrandRuntime, paramJSONArray, parami, paramq, (d.g.a.a)w.a.a.kMJ);
    AppMethodBeat.o(183055);
  }
  
  public final boolean bib()
  {
    return true;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "loadJsFiles", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "paths", "Lorg/json/JSONArray;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "scriptProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "callback", "Lkotlin/Function0;", "toJsValidationInjectionCallback", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallback;", "Landroid/webkit/ValueCallback;", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    private static com.tencent.mm.plugin.appbrand.utils.q.a a(ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(147942);
      if (paramValueCallback == null)
      {
        AppMethodBeat.o(147942);
        return null;
      }
      paramValueCallback = (com.tencent.mm.plugin.appbrand.utils.q.a)new c(paramValueCallback);
      AppMethodBeat.o(147942);
      return paramValueCallback;
    }
    
    public static void a(AppBrandRuntime paramAppBrandRuntime, JSONArray paramJSONArray, i parami, com.tencent.mm.plugin.appbrand.appcache.q paramq, d.g.a.a<z> parama)
    {
      AppMethodBeat.i(183054);
      p.h(paramAppBrandRuntime, "runtime");
      p.h(parama, "callback");
      if (paramJSONArray == null)
      {
        AppMethodBeat.o(183054);
        return;
      }
      if (paramJSONArray.length() <= 0)
      {
        parama.invoke();
        AppMethodBeat.o(183054);
        return;
      }
      if (parami == null)
      {
        AppMethodBeat.o(183054);
        return;
      }
      if (paramq == null)
      {
        AppMethodBeat.o(183054);
        return;
      }
      String str = paramAppBrandRuntime.getAppId();
      int j = paramJSONArray.length();
      int i = 0;
      if (i < j)
      {
        Object localObject = paramJSONArray.optString(i, null);
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (i == paramJSONArray.length() - 1) {}
          com.tencent.mm.plugin.appbrand.appcache.q.a locala;
          for (ValueCallback localValueCallback = (ValueCallback)new b(parama);; localValueCallback = null)
          {
            locala = paramq.Ll((String)localObject);
            if (locala != null) {
              break label214;
            }
            ad.e("Luggage.WXA.JsApiLoadJsFiles", "loadJsFiles appId[" + str + "] path[" + (String)localObject + "] EMPTY");
            if (localValueCallback == null) {
              break;
            }
            localValueCallback.onReceiveValue("404");
            break;
          }
          label214:
          if ((v)parami.P(v.class) == null)
          {
            localObject = paramq.Lk((String)localObject);
            if (localObject == null) {
              p.gfZ();
            }
            parami.evaluateJavascript(e.a((InputStream)localObject, d.UTF_8), localValueCallback);
          }
          else
          {
            r.a(paramAppBrandRuntime, parami, (String)localObject, locala, a(localValueCallback));
          }
        }
      }
      AppMethodBeat.o(183054);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "onReceiveValue"})
    static final class b<T>
      implements ValueCallback<String>
    {
      b(d.g.a.a parama) {}
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$toJsValidationInjectionCallback$1", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallback;", "onFailure", "", "ret", "", "onSuccess", "luggage-wechat-full-sdk_release"})
    public static final class c
      implements com.tencent.mm.plugin.appbrand.utils.q.a
    {
      c(ValueCallback<String> paramValueCallback) {}
      
      public final void cT(String paramString)
      {
        AppMethodBeat.i(147940);
        this.kMK.onReceiveValue(paramString);
        AppMethodBeat.o(147940);
      }
      
      public final void onSuccess(String paramString)
      {
        AppMethodBeat.i(147939);
        this.kMK.onReceiveValue(paramString);
        AppMethodBeat.o(147939);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(w paramw, aa paramaa, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.w
 * JD-Core Version:    0.7.0.1
 */