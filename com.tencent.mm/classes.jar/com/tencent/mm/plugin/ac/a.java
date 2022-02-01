package com.tencent.mm.plugin.ac;

import android.app.Service;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.webview.d.b;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder;", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "name", "", "appId", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "TAG", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "build", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "JsApiWebViewStub_Callback_AIDL", "webview-sdk_release"})
public final class a
{
  private final b IBt;
  public final Class<? extends Service> IBu;
  public final JsapiPermissionWrapper IBv;
  final String TAG;
  public final String appId;
  public final String name;
  
  public a(Class<? extends Service> paramClass, String paramString1, String paramString2, JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(224855);
    this.IBu = paramClass;
    this.name = paramString1;
    this.appId = paramString2;
    this.IBv = paramJsapiPermissionWrapper;
    this.TAG = "MicroMsg.JsApiHandlerBuilder";
    this.IBt = ((b)new c(this));
    AppMethodBeat.o(224855);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class c
    implements b
  {
    c(a parama) {}
    
    public final void h(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(224854);
      HashMap localHashMap = new HashMap();
      Map localMap = (Map)localHashMap;
      p.g(paramString2, "ret");
      localMap.put("err_msg", paramString2);
      if (paramMap != null) {
        localHashMap.putAll(paramMap);
      }
      paramString1 = n.a.a(paramString1, (Map)localHashMap, false, "");
      paramString2 = new i(paramString1).FJ("__params").toString();
      p.g(paramString2, "JSONObject(resp).getJSON…ct(\"__params\").toString()");
      Log.d(this.IBz.TAG, "invoke callback: " + paramString2 + ", " + paramString1);
      AppMethodBeat.o(224854);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.a
 * JD-Core Version:    0.7.0.1
 */