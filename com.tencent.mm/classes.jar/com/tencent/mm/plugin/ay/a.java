package com.tencent.mm.plugin.ay;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.api.c.a;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.stub.f.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.f.s;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder;", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "name", "", "appId", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "TAG", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "build", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "JsApiWebViewStub_Callback_AIDL", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  final String TAG;
  public final Class<? extends Service> WlU;
  public final JsapiPermissionWrapper WlV;
  private final com.tencent.mm.plugin.webview.jsapi.c WlW;
  public final String appId;
  public final String name;
  
  public a(Class<? extends Service> paramClass, String paramString1, String paramString2, JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(266814);
    this.WlU = paramClass;
    this.name = paramString1;
    this.appId = paramString2;
    this.WlV = paramJsapiPermissionWrapper;
    this.TAG = "MicroMsg.JsApiHandlerBuilder";
    this.WlW = new a..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(266814);
  }
  
  private static final void a(a parama, String paramString1, String paramString2, Map paramMap)
  {
    AppMethodBeat.i(266822);
    s.u(parama, "this$0");
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    s.s(paramString2, "ret");
    localMap.put("err_msg", paramString2);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    paramString1 = p.a.a(paramString1, (Map)localHashMap, false, "");
    paramString2 = new i(paramString1).Fs("__params").toString();
    s.s(paramString2, "JSONObject(resp).getJSON…ct(\"__params\").toString()");
    Log.d(parama.TAG, "invoke callback: " + paramString2 + ", " + paramString1);
    AppMethodBeat.o(266822);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder$JsApiWebViewStub_Callback_AIDL;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL$Stub;", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "TAG", "", "asBinder", "Landroid/os/IBinder;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "closeWindow", "", "bundle", "dealNext", "getA8keyScene", "getCommitUrl", "getCurrentUrl", "getInitUrl", "getPublisher", "handleMsg", "func", "param", "hideMenuEntry", "ishide", "invokeAsResult", "loadUrl", "url", "jsCode", "onHandleEnd", "callbackId", "ret", "retData", "onSceneEnd", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "requestClearMsgList", "setCustomMenu", "setFontSizeCb", "font", "setFooterBarVisible", "visible", "setMenuItemsVisible", "setPageOwner", "userName", "nickName", "setRecogResultForQBarImg", "filePath", "result", "codeType", "codeVersion", "setShareBtnVisible", "setTitlePbVisibility", "visibility", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class a
    extends f.a
  {
    private final String TAG;
    private final j WlX;
    
    public a(j paramj)
    {
      AppMethodBeat.i(266725);
      this.WlX = paramj;
      this.TAG = "MicroMsg.JsApiWebViewStub_Callback_AIDL";
      AppMethodBeat.o(266725);
    }
    
    public final void Il(boolean paramBoolean) {}
    
    public final void Im(boolean paramBoolean) {}
    
    public final void In(boolean paramBoolean) {}
    
    public final boolean a(d paramd)
    {
      return false;
    }
    
    public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
    {
      AppMethodBeat.i(266733);
      this.WlX.a(paramString1, paramString2, p.bm(paramBundle), paramBoolean);
      AppMethodBeat.o(266733);
      return true;
    }
    
    public void aF(Bundle paramBundle) {}
    
    public IBinder asBinder()
    {
      AppMethodBeat.i(266799);
      IBinder localIBinder = super.asBinder();
      AppMethodBeat.o(266799);
      return localIBinder;
    }
    
    public final boolean asR(int paramInt)
    {
      return true;
    }
    
    public final void bif(String paramString) {}
    
    public final void bk(Bundle paramBundle) {}
    
    public final String cxY()
    {
      return this.TAG;
    }
    
    public final void f(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
    
    public final String getCurrentUrl()
    {
      return this.TAG;
    }
    
    public final boolean i(int paramInt, Bundle paramBundle)
    {
      return true;
    }
    
    public final void ioZ() {}
    
    public final String ipa()
    {
      return this.TAG;
    }
    
    public final String ipb()
    {
      return this.TAG;
    }
    
    public final int ipc()
    {
      return 0;
    }
    
    public final void ipd() {}
    
    public final Bundle m(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(266746);
      Log.i(this.TAG, s.X("invokeAsResult:", Integer.valueOf(paramInt)));
      Bundle localBundle = new Bundle();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(266746);
        return localBundle;
        s.checkNotNull(paramBundle);
        paramBundle.setClassLoader(f.s.class.getClassLoader());
        Object localObject1 = this.WlX.getContext();
        Object localObject2 = paramBundle.getString("open_ui_with_webview_ui_plugin_name");
        Object localObject3 = paramBundle.getString("open_ui_with_webview_ui_plugin_entry");
        Intent localIntent = new Intent();
        paramBundle = paramBundle.getBundle("open_ui_with_webview_ui_extras");
        s.checkNotNull(paramBundle);
        com.tencent.mm.br.c.b((Context)localObject1, (String)localObject2, (String)localObject3, localIntent.putExtras(paramBundle));
        continue;
        localObject3 = new c.a();
        localIntent = new Intent();
        s.checkNotNull(paramBundle);
        paramInt = paramBundle.getInt("scene");
        int i = paramBundle.getInt(f.b.adwc, 10000);
        localObject2 = paramBundle.getString("url");
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).isMpUrl((String)localObject2))
        {
          j = (int)(System.currentTimeMillis() / 1000L);
          localObject1 = ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).e((String)localObject2, paramInt, i, j);
        }
        localObject2 = (com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
        Context localContext = this.WlX.getContext();
        int j = paramBundle.getInt("item_show_type");
        paramBundle.getBoolean("isNativePage");
        localBundle.putBoolean("success", ((com.tencent.mm.plugin.brandservice.api.c)localObject2).a(localContext, (String)localObject1, j, paramInt, i, localIntent, paramBundle.getInt("openType"), (c.a)localObject3));
        if ((!((c.a)localObject3).success) && (((c.a)localObject3).message != null)) {
          localBundle.putString("desc", ((c.a)localObject3).message);
        }
      }
    }
    
    public final Bundle nK(String paramString1, String paramString2)
    {
      AppMethodBeat.i(266779);
      paramString1 = new Bundle();
      AppMethodBeat.o(266779);
      return paramString1;
    }
    
    public final void nL(String paramString1, String paramString2) {}
    
    public final void nM(String paramString1, String paramString2) {}
    
    public final void y(int paramInt, Bundle paramBundle) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder$build$2", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.webview.core.f
  {
    public b(j paramj, int paramInt, a parama) {}
    
    public final void a(com.tencent.mm.plugin.webview.core.e parame)
    {
      AppMethodBeat.i(266728);
      s.u(parame, "conn");
      try
      {
        this.WlY.sLC = parame.irJ();
        parame.irJ().a((com.tencent.mm.plugin.webview.stub.f)new a.a(this.WlY), this.WlZ);
        this.WlY.Iy(true);
        AppMethodBeat.o(266728);
        return;
      }
      finally
      {
        Log.e(this.Wma.TAG, s.X("onConnected ex ", parame.getMessage()));
        AppMethodBeat.o(266728);
      }
    }
    
    public final boolean fTZ()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ay.a
 * JD-Core Version:    0.7.0.1
 */