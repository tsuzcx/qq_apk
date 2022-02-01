package com.tencent.mm.plugin.ac;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.c;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.f.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.e.m;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder;", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "name", "", "appId", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "TAG", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "build", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "JsApiWebViewStub_Callback_AIDL", "webview-sdk_release"})
public final class a
{
  private final com.tencent.mm.plugin.webview.c.b DRu;
  public final Class<? extends Service> DRv;
  public final JsapiPermissionWrapper DRw;
  final String TAG;
  public final String appId;
  public final String name;
  
  public a(Class<? extends Service> paramClass, String paramString1, String paramString2, JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(214001);
    this.DRv = paramClass;
    this.name = paramString1;
    this.appId = paramString2;
    this.DRw = paramJsapiPermissionWrapper;
    this.TAG = "MicroMsg.JsApiHandlerBuilder";
    this.DRu = ((com.tencent.mm.plugin.webview.c.b)new c(this));
    AppMethodBeat.o(214001);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder$JsApiWebViewStub_Callback_AIDL;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL$Stub;", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "TAG", "", "asBinder", "Landroid/os/IBinder;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "closeWindow", "", "bundle", "dealNext", "getA8keyScene", "getCommitUrl", "getCurrentUrl", "getInitUrl", "getPublisher", "handleMsg", "func", "param", "hideMenuEntry", "ishide", "invokeAsResult", "loadUrl", "url", "jsCode", "onHandleEnd", "callbackId", "ret", "retData", "onSceneEnd", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "requestClearMsgList", "setCustomMenu", "setFontSizeCb", "font", "setFooterBarVisible", "visible", "setMenuItemsVisible", "setPageOwner", "userName", "nickName", "setRecogResultForQBarImg", "filePath", "result", "codeType", "codeVersion", "setShareBtnVisible", "setTitlePbVisibility", "visibility", "webview-sdk_release"})
  public static final class a
    extends f.a
  {
    private final com.tencent.mm.plugin.webview.c.f DRx;
    private final String TAG;
    
    public a(com.tencent.mm.plugin.webview.c.f paramf)
    {
      AppMethodBeat.i(213998);
      this.DRx = paramf;
      this.TAG = "MicroMsg.JsApiWebViewStub_Callback_AIDL";
      AppMethodBeat.o(213998);
    }
    
    public final boolean WE(int paramInt)
    {
      return true;
    }
    
    public final boolean a(com.tencent.mm.plugin.webview.stub.d paramd)
    {
      return false;
    }
    
    public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
    {
      AppMethodBeat.i(213994);
      this.DRx.a(paramString1, paramString2, com.tencent.mm.plugin.webview.c.l.aB(paramBundle), paramBoolean);
      AppMethodBeat.o(213994);
      return true;
    }
    
    public final void aA(Bundle paramBundle) {}
    
    public final void aHa(String paramString) {}
    
    public final IBinder asBinder()
    {
      AppMethodBeat.i(213997);
      IBinder localIBinder = super.asBinder();
      AppMethodBeat.o(213997);
      return localIBinder;
    }
    
    public final void az(Bundle paramBundle) {}
    
    public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
    
    public final void ePd() {}
    
    public final String ePe()
    {
      return this.TAG;
    }
    
    public final String ePf()
    {
      return this.TAG;
    }
    
    public final int ePg()
    {
      return 0;
    }
    
    public final void ePh() {}
    
    public final Bundle eU(String paramString1, String paramString2)
    {
      AppMethodBeat.i(213996);
      paramString1 = new Bundle();
      AppMethodBeat.o(213996);
      return paramString1;
    }
    
    public final String eaf()
    {
      return this.TAG;
    }
    
    public final boolean g(int paramInt, Bundle paramBundle)
    {
      return true;
    }
    
    public final String getCurrentUrl()
    {
      return this.TAG;
    }
    
    public final Bundle k(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(213995);
      ae.i(this.TAG, "invokeAsResult:".concat(String.valueOf(paramInt)));
      Bundle localBundle = new Bundle();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(213995);
        return localBundle;
        if (paramBundle == null) {
          p.gkB();
        }
        paramBundle.setClassLoader(e.m.class.getClassLoader());
        Object localObject1 = this.DRx.getContext();
        Object localObject2 = paramBundle.getString("open_ui_with_webview_ui_plugin_name");
        Object localObject3 = paramBundle.getString("open_ui_with_webview_ui_plugin_entry");
        Intent localIntent = new Intent();
        paramBundle = paramBundle.getBundle("open_ui_with_webview_ui_extras");
        if (paramBundle == null) {
          p.gkB();
        }
        com.tencent.mm.br.d.b((Context)localObject1, (String)localObject2, (String)localObject3, localIntent.putExtras(paramBundle));
        continue;
        localObject3 = new b.a();
        localIntent = new Intent();
        if (paramBundle == null) {
          p.gkB();
        }
        paramInt = paramBundle.getInt("scene");
        int i = paramBundle.getInt(e.b.JoW, 10000);
        localObject2 = paramBundle.getString("url");
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2))
        {
          j = (int)(System.currentTimeMillis() / 1000L);
          localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, paramInt, i, j);
        }
        localObject2 = (com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
        Context localContext = this.DRx.getContext();
        int j = paramBundle.getInt("item_show_type");
        paramBundle.getBoolean("isNativePage");
        localBundle.putBoolean("success", ((com.tencent.mm.plugin.brandservice.a.b)localObject2).a(localContext, (String)localObject1, j, paramInt, i, localIntent, paramBundle.getInt("openType"), (b.a)localObject3));
        if ((!((b.a)localObject3).success) && (((b.a)localObject3).message != null)) {
          localBundle.putString("desc", ((b.a)localObject3).message);
        }
      }
    }
    
    public final void kG(String paramString1, String paramString2) {}
    
    public final void kH(String paramString1, String paramString2) {}
    
    public final void u(int paramInt, Bundle paramBundle) {}
    
    public final void uW(boolean paramBoolean) {}
    
    public final void uX(boolean paramBoolean) {}
    
    public final void uY(boolean paramBoolean) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder$build$2", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
  public static final class b
    implements com.tencent.mm.plugin.webview.core.d
  {
    public b(com.tencent.mm.plugin.webview.c.f paramf, int paramInt) {}
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(213999);
      p.h(paramc, "conn");
      this.DRy.b(paramc.eQS());
      paramc.eQS().a((com.tencent.mm.plugin.webview.stub.f)new a.a(this.DRy), this.DRz);
      this.DRy.ve(true);
      AppMethodBeat.o(213999);
    }
    
    public final boolean ePi()
    {
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class c
    implements com.tencent.mm.plugin.webview.c.b
  {
    c(a parama) {}
    
    public final void i(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(214000);
      HashMap localHashMap = new HashMap();
      Map localMap = (Map)localHashMap;
      p.g(paramString2, "ret");
      localMap.put("err_msg", paramString2);
      if (paramMap != null) {
        localHashMap.putAll(paramMap);
      }
      paramString1 = l.a.a(paramString1, (Map)localHashMap, false, "");
      paramString2 = new i(paramString1).xx("__params").toString();
      p.g(paramString2, "JSONObject(resp).getJSON…ct(\"__params\").toString()");
      ae.d(this.DRA.TAG, "invoke callback: " + paramString2 + ", " + paramString1);
      AppMethodBeat.o(214000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.a
 * JD-Core Version:    0.7.0.1
 */