package com.tencent.mm.plugin.aw;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.brandservice.a.c.a;
import com.tencent.mm.plugin.webview.d.b;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.plugin.webview.stub.f.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.f.r;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder;", "", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "name", "", "appId", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/JsapiPermissionWrapper;)V", "TAG", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "build", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "JsApiWebViewStub_Callback_AIDL", "webview-sdk_release"})
public final class a
{
  private final b PvG;
  public final Class<? extends Service> PvH;
  public final JsapiPermissionWrapper PvI;
  final String TAG;
  public final String appId;
  public final String name;
  
  public a(Class<? extends Service> paramClass, String paramString1, String paramString2, JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(212372);
    this.PvH = paramClass;
    this.name = paramString1;
    this.appId = paramString2;
    this.PvI = paramJsapiPermissionWrapper;
    this.TAG = "MicroMsg.JsApiHandlerBuilder";
    this.PvG = ((b)new c(this));
    AppMethodBeat.o(212372);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder$JsApiWebViewStub_Callback_AIDL;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL$Stub;", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "TAG", "", "asBinder", "Landroid/os/IBinder;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "closeWindow", "", "bundle", "dealNext", "getA8keyScene", "getCommitUrl", "getCurrentUrl", "getInitUrl", "getPublisher", "handleMsg", "func", "param", "hideMenuEntry", "ishide", "invokeAsResult", "loadUrl", "url", "jsCode", "onHandleEnd", "callbackId", "ret", "retData", "onSceneEnd", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "requestClearMsgList", "setCustomMenu", "setFontSizeCb", "font", "setFooterBarVisible", "visible", "setMenuItemsVisible", "setPageOwner", "userName", "nickName", "setRecogResultForQBarImg", "filePath", "result", "codeType", "codeVersion", "setShareBtnVisible", "setTitlePbVisibility", "visibility", "webview-sdk_release"})
  public static final class a
    extends f.a
  {
    private final com.tencent.mm.plugin.webview.d.h PvJ;
    private final String TAG;
    
    public a(com.tencent.mm.plugin.webview.d.h paramh)
    {
      AppMethodBeat.i(212901);
      this.PvJ = paramh;
      this.TAG = "MicroMsg.JsApiWebViewStub_Callback_AIDL";
      AppMethodBeat.o(212901);
    }
    
    public final void CG(boolean paramBoolean) {}
    
    public final void CH(boolean paramBoolean) {}
    
    public final void CI(boolean paramBoolean) {}
    
    public final boolean a(com.tencent.mm.plugin.webview.stub.d paramd)
    {
      return false;
    }
    
    public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
    {
      AppMethodBeat.i(212874);
      this.PvJ.a(paramString1, paramString2, n.aJ(paramBundle), paramBoolean);
      AppMethodBeat.o(212874);
      return true;
    }
    
    public final void aH(Bundle paramBundle) {}
    
    public final void aI(Bundle paramBundle) {}
    
    public final boolean amZ(int paramInt)
    {
      return true;
    }
    
    public final IBinder asBinder()
    {
      AppMethodBeat.i(212885);
      IBinder localIBinder = super.asBinder();
      AppMethodBeat.o(212885);
      return localIBinder;
    }
    
    public final String bXN()
    {
      return this.TAG;
    }
    
    public final void bix(String paramString) {}
    
    public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
    
    public final void gPF() {}
    
    public final String gPG()
    {
      return this.TAG;
    }
    
    public final String gPH()
    {
      return this.TAG;
    }
    
    public final int gPI()
    {
      return 0;
    }
    
    public final void gPJ() {}
    
    public final String getCurrentUrl()
    {
      return this.TAG;
    }
    
    public final boolean h(int paramInt, Bundle paramBundle)
    {
      return true;
    }
    
    public final Bundle l(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(212877);
      Log.i(this.TAG, "invokeAsResult:".concat(String.valueOf(paramInt)));
      Bundle localBundle = new Bundle();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(212877);
        return localBundle;
        if (paramBundle == null) {
          p.iCn();
        }
        paramBundle.setClassLoader(f.r.class.getClassLoader());
        Object localObject1 = this.PvJ.getContext();
        Object localObject2 = paramBundle.getString("open_ui_with_webview_ui_plugin_name");
        Object localObject3 = paramBundle.getString("open_ui_with_webview_ui_plugin_entry");
        Intent localIntent = new Intent();
        paramBundle = paramBundle.getBundle("open_ui_with_webview_ui_extras");
        if (paramBundle == null) {
          p.iCn();
        }
        com.tencent.mm.by.c.b((Context)localObject1, (String)localObject2, (String)localObject3, localIntent.putExtras(paramBundle));
        continue;
        localObject3 = new c.a();
        localIntent = new Intent();
        if (paramBundle == null) {
          p.iCn();
        }
        paramInt = paramBundle.getInt("scene");
        int i = paramBundle.getInt(f.b.VRU, 10000);
        localObject2 = paramBundle.getString("url");
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).isMpUrl((String)localObject2))
        {
          j = (int)(System.currentTimeMillis() / 1000L);
          localObject1 = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).e((String)localObject2, paramInt, i, j);
        }
        localObject2 = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
        Context localContext = this.PvJ.getContext();
        int j = paramBundle.getInt("item_show_type");
        paramBundle.getBoolean("isNativePage");
        localBundle.putBoolean("success", ((com.tencent.mm.plugin.brandservice.a.c)localObject2).a(localContext, (String)localObject1, j, paramInt, i, localIntent, paramBundle.getInt("openType"), (c.a)localObject3));
        if ((!((c.a)localObject3).success) && (((c.a)localObject3).message != null)) {
          localBundle.putString("desc", ((c.a)localObject3).message);
        }
      }
    }
    
    public final Bundle lY(String paramString1, String paramString2)
    {
      AppMethodBeat.i(212882);
      paramString1 = new Bundle();
      AppMethodBeat.o(212882);
      return paramString1;
    }
    
    public final void lZ(String paramString1, String paramString2) {}
    
    public final void ma(String paramString1, String paramString2) {}
    
    public final void v(int paramInt, Bundle paramBundle) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder$build$2", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
  public static final class b
    implements com.tencent.mm.plugin.webview.core.d
  {
    public b(com.tencent.mm.plugin.webview.d.h paramh, int paramInt) {}
    
    public final void a(com.tencent.mm.plugin.webview.core.c paramc)
    {
      AppMethodBeat.i(205728);
      p.k(paramc, "conn");
      this.PvK.a(paramc.gSm());
      paramc.gSm().a((f)new a.a(this.PvK), this.PvL);
      this.PvK.CQ(true);
      AppMethodBeat.o(205728);
    }
    
    public final boolean gPK()
    {
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
  static final class c
    implements b
  {
    c(a parama) {}
    
    public final void h(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(212969);
      HashMap localHashMap = new HashMap();
      Map localMap = (Map)localHashMap;
      p.j(paramString2, "ret");
      localMap.put("err_msg", paramString2);
      if (paramMap != null) {
        localHashMap.putAll(paramMap);
      }
      paramString1 = n.a.a(paramString1, (Map)localHashMap, false, "");
      paramString2 = new i(paramString1).MJ("__params").toString();
      p.j(paramString2, "JSONObject(resp).getJSON…ct(\"__params\").toString()");
      Log.d(this.PvM.TAG, "invoke callback: " + paramString2 + ", " + paramString1);
      AppMethodBeat.o(212969);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aw.a
 * JD-Core Version:    0.7.0.1
 */