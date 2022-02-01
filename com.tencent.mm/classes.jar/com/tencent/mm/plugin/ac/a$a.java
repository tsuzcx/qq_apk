package com.tencent.mm.plugin.ac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.stub.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.e.p;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder$JsApiWebViewStub_Callback_AIDL;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL$Stub;", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "TAG", "", "asBinder", "Landroid/os/IBinder;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "closeWindow", "", "bundle", "dealNext", "getA8keyScene", "getCommitUrl", "getCurrentUrl", "getInitUrl", "getPublisher", "handleMsg", "func", "param", "hideMenuEntry", "ishide", "invokeAsResult", "loadUrl", "url", "jsCode", "onHandleEnd", "callbackId", "ret", "retData", "onSceneEnd", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "requestClearMsgList", "setCustomMenu", "setFontSizeCb", "font", "setFooterBarVisible", "visible", "setMenuItemsVisible", "setPageOwner", "userName", "nickName", "setRecogResultForQBarImg", "filePath", "result", "codeType", "codeVersion", "setShareBtnVisible", "setTitlePbVisibility", "visibility", "webview-sdk_release"})
public final class a$a
  extends f.a
{
  private final h IBw;
  private final String TAG;
  
  public a$a(h paramh)
  {
    AppMethodBeat.i(224852);
    this.IBw = paramh;
    this.TAG = "MicroMsg.JsApiWebViewStub_Callback_AIDL";
    AppMethodBeat.o(224852);
  }
  
  public final boolean a(d paramd)
  {
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(224848);
    this.IBw.a(paramString1, paramString2, n.aN(paramBundle), paramBoolean);
    AppMethodBeat.o(224848);
    return true;
  }
  
  public final void aL(Bundle paramBundle) {}
  
  public final void aM(Bundle paramBundle) {}
  
  public final void aWP(String paramString) {}
  
  public final boolean afl(int paramInt)
  {
    return true;
  }
  
  public final IBinder asBinder()
  {
    AppMethodBeat.i(224851);
    IBinder localIBinder = super.asBinder();
    AppMethodBeat.o(224851);
    return localIBinder;
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final String ePp()
  {
    return this.TAG;
  }
  
  public final boolean f(int paramInt, Bundle paramBundle)
  {
    return true;
  }
  
  public final void fWV() {}
  
  public final String fWW()
  {
    return this.TAG;
  }
  
  public final String fWX()
  {
    return this.TAG;
  }
  
  public final int fWY()
  {
    return 0;
  }
  
  public final void fWZ() {}
  
  public final Bundle fl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224850);
    paramString1 = new Bundle();
    AppMethodBeat.o(224850);
    return paramString1;
  }
  
  public final String getCurrentUrl()
  {
    return this.TAG;
  }
  
  public final Bundle j(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(224849);
    Log.i(this.TAG, "invokeAsResult:".concat(String.valueOf(paramInt)));
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(224849);
      return localBundle;
      if (paramBundle == null) {
        p.hyc();
      }
      paramBundle.setClassLoader(e.p.class.getClassLoader());
      Object localObject1 = this.IBw.getContext();
      Object localObject2 = paramBundle.getString("open_ui_with_webview_ui_plugin_name");
      Object localObject3 = paramBundle.getString("open_ui_with_webview_ui_plugin_entry");
      Intent localIntent = new Intent();
      paramBundle = paramBundle.getBundle("open_ui_with_webview_ui_extras");
      if (paramBundle == null) {
        p.hyc();
      }
      c.b((Context)localObject1, (String)localObject2, (String)localObject3, localIntent.putExtras(paramBundle));
      continue;
      localObject3 = new b.a();
      localIntent = new Intent();
      if (paramBundle == null) {
        p.hyc();
      }
      paramInt = paramBundle.getInt("scene");
      int i = paramBundle.getInt(e.b.OyR, 10000);
      localObject2 = paramBundle.getString("url");
      localObject1 = localObject2;
      if (((b)g.af(b.class)).isMpUrl((String)localObject2))
      {
        j = (int)(System.currentTimeMillis() / 1000L);
        localObject1 = ((b)g.af(b.class)).d((String)localObject2, paramInt, i, j);
      }
      localObject2 = (b)g.af(b.class);
      Context localContext = this.IBw.getContext();
      int j = paramBundle.getInt("item_show_type");
      paramBundle.getBoolean("isNativePage");
      localBundle.putBoolean("success", ((b)localObject2).a(localContext, (String)localObject1, j, paramInt, i, localIntent, paramBundle.getInt("openType"), (b.a)localObject3));
      if ((!((b.a)localObject3).success) && (((b.a)localObject3).message != null)) {
        localBundle.putString("desc", ((b.a)localObject3).message);
      }
    }
  }
  
  public final void lA(String paramString1, String paramString2) {}
  
  public final void lz(String paramString1, String paramString2) {}
  
  public final void t(int paramInt, Bundle paramBundle) {}
  
  public final void yL(boolean paramBoolean) {}
  
  public final void yM(boolean paramBoolean) {}
  
  public final void yN(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.a.a
 * JD-Core Version:    0.7.0.1
 */