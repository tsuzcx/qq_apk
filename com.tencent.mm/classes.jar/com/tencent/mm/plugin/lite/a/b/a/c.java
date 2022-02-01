package com.tencent.mm.plugin.lite.a.b.a;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.h;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URL;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppAppBrandJsRuntime;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "()V", "mLiteAppAppBrandJsRuntimeAddon", "Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppAppBrandJsRuntimeAddon;", "addJavascriptInterface", "", "obj", "", "name", "", "destroy", "evaluateJavascript", "sourceURL", "Ljava/net/URL;", "script", "cb", "Landroid/webkit/ValueCallback;", "cacheCategory", "cacheKey", "cacheType", "", "getAddon", "T", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "addon", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "setJsExceptionHandler", "handler", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsExceptionHandler;", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements i
{
  public static final a JZN;
  private d JZO;
  
  static
  {
    AppMethodBeat.i(271575);
    JZN = new a((byte)0);
    AppMethodBeat.o(271575);
  }
  
  public c()
  {
    AppMethodBeat.i(271572);
    this.JZO = new d();
    AppMethodBeat.o(271572);
  }
  
  public final <T extends j> T Z(Class<T> paramClass)
  {
    AppMethodBeat.i(271606);
    Log.i("WxaLiteApp.LiteAppAppBrandJsRuntime", "getAddon");
    paramClass = (j)this.JZO;
    AppMethodBeat.o(271606);
    return paramClass;
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(271578);
    Log.i("WxaLiteApp.LiteAppAppBrandJsRuntime", "evaluateJavascript URL:%s script:%s ", new Object[] { String.valueOf(paramURL), paramString });
    AppMethodBeat.o(271578);
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(271583);
    Log.i("WxaLiteApp.LiteAppAppBrandJsRuntime", "evaluateJavascript URL:%s script:%s cacheCategory:%s cacheKey:%s cacheType:%d", new Object[] { String.valueOf(paramURL), paramString3, paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(271583);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(271590);
    Log.i("WxaLiteApp.LiteAppAppBrandJsRuntime", "addJavascriptInterface name:%s ", new Object[] { paramString });
    AppMethodBeat.o(271590);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(271601);
    Log.i("WxaLiteApp.LiteAppAppBrandJsRuntime", "destroy");
    AppMethodBeat.o(271601);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(271587);
    Log.i("WxaLiteApp.LiteAppAppBrandJsRuntime", "evaluateJavascript script:%s ", new Object[] { paramString });
    AppMethodBeat.o(271587);
  }
  
  public final void setJsExceptionHandler(h paramh)
  {
    AppMethodBeat.i(271596);
    if (paramh != null) {}
    for (int i = paramh.hashCode();; i = 0)
    {
      Log.i("WxaLiteApp.LiteAppAppBrandJsRuntime", "setJsExceptionHandler handler:%s ", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(271596);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppAppBrandJsRuntime$Companion;", "", "()V", "TAG", "", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */