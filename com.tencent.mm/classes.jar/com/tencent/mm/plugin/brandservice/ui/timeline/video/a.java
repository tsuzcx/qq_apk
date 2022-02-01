package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager;", "", "()V", "TAG", "", "initAdWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "webView", "publishId", "configMpAdAttrs", "Lkotlin/Function2;", "", "", "onPageFinsh", "Lcom/tencent/xweb/WebView;", "Lkotlin/ParameterName;", "name", "view", "url", "getA8KeyScene", "plugin-brandservice_release"})
public final class a
{
  public static final a pHf;
  
  static
  {
    AppMethodBeat.i(7036);
    pHf = new a();
    AppMethodBeat.o(7036);
  }
  
  public static MMWebViewWithJsApi a(final MMWebViewWithJsApi paramMMWebViewWithJsApi, final String paramString, final kotlin.g.a.m<? super String, ? super Integer, x> paramm, final kotlin.g.a.m<? super WebView, ? super String, x> paramm1, final int paramInt)
  {
    AppMethodBeat.i(175497);
    p.h(paramMMWebViewWithJsApi, "webView");
    p.h(paramm, "configMpAdAttrs");
    p.h(paramm1, "onPageFinsh");
    z.f localf = new z.f();
    Object localObject = paramMMWebViewWithJsApi.getContext();
    if (localObject == null)
    {
      paramMMWebViewWithJsApi = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(175497);
      throw paramMMWebViewWithJsApi;
    }
    localf.SYG = new WeakReference((TmplShareWebViewToolUI)localObject);
    localObject = new z.f();
    ((z.f)localObject).SYG = new WeakReference((View)paramMMWebViewWithJsApi);
    paramMMWebViewWithJsApi.setBackgroundColor(0);
    paramMMWebViewWithJsApi.setWebViewClient((ac)new a(new b(localf, paramString, (z.f)localObject, paramm), paramInt, paramm1, paramMMWebViewWithJsApi, (MMWebView)paramMMWebViewWithJsApi));
    Log.i("MicroMsg.AdWebViewManager", "init:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(175497);
    return paramMMWebViewWithJsApi;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewClient;", "getA8KeyScene", "", "getWebViewStubCallback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "mmOnPageFinished", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "mmOnPageStarted", "favicon", "Landroid/graphics/Bitmap;", "plugin-brandservice_release"})
  public static final class a
    extends k
  {
    a(a.b paramb, int paramInt, kotlin.g.a.m paramm, MMWebViewWithJsApi paramMMWebViewWithJsApi, MMWebView paramMMWebView)
    {
      super();
    }
    
    public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(7029);
      super.a(paramWebView, paramString, paramBitmap);
      if (paramWebView == null)
      {
        paramWebView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMWebView");
        AppMethodBeat.o(7029);
        throw paramWebView;
      }
      com.tencent.mm.plugin.webview.model.a.e((MMWebView)paramWebView);
      AppMethodBeat.o(7029);
    }
    
    public final com.tencent.mm.plugin.webview.ui.tools.widget.m bLB()
    {
      return (com.tencent.mm.plugin.webview.ui.tools.widget.m)this.pHg;
    }
    
    public final int bLC()
    {
      return paramInt;
    }
    
    public final void f(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(7030);
      super.f(paramWebView, paramString);
      paramm1.invoke(paramWebView, paramString);
      AppMethodBeat.o(7030);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$callback$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "handleMsg", "func", "", "param", "invokeAsResult", "plugin-brandservice_release"})
  public static final class b
    extends com.tencent.mm.plugin.webview.ui.tools.widget.m
  {
    b(z.f paramf1, String paramString, z.f paramf2, kotlin.g.a.m paramm) {}
    
    public final boolean f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(7032);
      p.h(paramBundle, "data");
      Log.i("MicroMsg.AdWebViewManager", "callback:".concat(String.valueOf(paramInt)));
      boolean bool = super.f(paramInt, paramBundle);
      AppMethodBeat.o(7032);
      return bool;
    }
    
    public final Bundle fl(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7034);
      if (paramString1 == null) {}
      do
      {
        for (;;)
        {
          paramString1 = super.fl(paramString1, paramString2);
          p.g(paramString1, "super.handleMsg(func, param)");
          AppMethodBeat.o(7034);
          return paramString1;
          switch (paramString1.hashCode())
          {
          }
        }
      } while (!paramString1.equals("configMpAdAttrs"));
      Log.i("MicroMsg.AdWebViewManager", "configMpAdAttrs:".concat(String.valueOf(paramString2)));
      paramString2 = new i(paramString2);
      paramString1 = paramString2.getString("posInfo");
      int i = paramString2.getInt("webviewId");
      paramString2 = paramm;
      p.g(paramString1, "posInfo");
      paramString2.invoke(paramString1, Integer.valueOf(i));
      paramString1 = com.tencent.mm.protocal.c.bga("configMpAdAttrs:ok");
      p.g(paramString1, "ConstantsJSAPIFunc.creat…ue, \"configMpAdAttrs:ok\")");
      AppMethodBeat.o(7034);
      return paramString1;
    }
    
    public final Bundle j(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(7033);
      Log.i("MicroMsg.AdWebViewManager", "invokeAsResult:".concat(String.valueOf(paramInt)));
      Bundle localBundle = new Bundle();
      Object localObject1;
      if (((WeakReference)this.pHk.SYG).get() != null)
      {
        localObject1 = ((WeakReference)this.pHk.SYG).get();
        if (localObject1 == null)
        {
          paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
          AppMethodBeat.o(7033);
          throw paramBundle;
        }
        if (!((TmplShareWebViewToolUI)localObject1).isFinishing()) {}
      }
      else
      {
        AppMethodBeat.o(7033);
        return localBundle;
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(7033);
        return localBundle;
        if (paramBundle == null) {
          p.hyc();
        }
        paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
        localObject1 = (Context)((WeakReference)this.pHk.SYG).get();
        Object localObject2 = paramBundle.getString("open_ui_with_webview_ui_plugin_name");
        String str = paramBundle.getString("open_ui_with_webview_ui_plugin_entry");
        Intent localIntent = new Intent();
        paramBundle = paramBundle.getBundle("open_ui_with_webview_ui_extras");
        if (paramBundle == null) {
          p.hyc();
        }
        com.tencent.mm.br.c.b((Context)localObject1, (String)localObject2, str, localIntent.putExtras(paramBundle).putExtra("KPublisherId", Util.nullAsNil(paramString)));
        continue;
        localObject1 = ((WeakReference)this.pHk.SYG).get();
        if (localObject1 == null)
        {
          paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
          AppMethodBeat.o(7033);
          throw paramBundle;
        }
        localObject2 = (TmplShareWebViewToolUI)localObject1;
        if (paramBundle != null) {}
        for (localObject1 = paramBundle.getString("action");; localObject1 = null)
        {
          if (!p.j("sendMPPageData", localObject1)) {
            break label314;
          }
          ((TmplShareWebViewToolUI)localObject2).aa(paramBundle);
          break;
        }
        label314:
        if (p.j("closeAdWebview", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).cpF();
        }
        else if (p.j("adWebviewReady", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).cpG();
        }
        else if (p.j("dotWebViewReady", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).ad(paramBundle);
        }
        else if (p.j("closeDotWebview", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).ab(paramBundle);
        }
        else if (p.j("hideDotWebview", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).ac(paramBundle);
        }
        else if (p.j("getMPVideoState", localObject1))
        {
          localBundle.putAll(((TmplShareWebViewToolUI)localObject2).cpH());
        }
        else if (p.j("setWebviewBackground", localObject1))
        {
          paramBundle = paramBundle.getString("backgroundColor");
          Log.i("MicroMsg.AdWebViewManager", "setWebviewBackground ".concat(String.valueOf(paramBundle)));
          paramInt = e.gw(paramBundle, 0);
          if (((WeakReference)this.pHm.SYG).get() != null)
          {
            paramBundle = ((WeakReference)this.pHm.SYG).get();
            if (paramBundle == null) {
              p.hyc();
            }
            ((View)paramBundle).setBackgroundColor(paramInt);
          }
        }
        else if (p.j("opPlayer", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).af(paramBundle);
        }
        else if (p.j("setDotScriptData", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).ae(paramBundle);
        }
        else if (p.j("switchVideo", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).Y(paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a
 * JD-Core Version:    0.7.0.1
 */