package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.protocal.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import d.g.b.v.e;
import d.l;
import d.v;
import d.y;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager;", "", "()V", "TAG", "", "initAdWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "webView", "publishId", "configMpAdAttrs", "Lkotlin/Function2;", "", "", "onPageFinsh", "Lcom/tencent/xweb/WebView;", "Lkotlin/ParameterName;", "name", "view", "url", "getA8KeyScene", "plugin-brandservice_release"})
public final class a
{
  public static final a nis;
  
  static
  {
    AppMethodBeat.i(7036);
    nis = new a();
    AppMethodBeat.o(7036);
  }
  
  public static MMWebViewWithJsApi a(final MMWebViewWithJsApi paramMMWebViewWithJsApi, final String paramString, final d.g.a.m<? super String, ? super Integer, y> paramm, final d.g.a.m<? super WebView, ? super String, y> paramm1, final int paramInt)
  {
    AppMethodBeat.i(175497);
    d.g.b.k.h(paramMMWebViewWithJsApi, "webView");
    d.g.b.k.h(paramm, "configMpAdAttrs");
    d.g.b.k.h(paramm1, "onPageFinsh");
    v.e locale = new v.e();
    Object localObject = paramMMWebViewWithJsApi.getContext();
    if (localObject == null)
    {
      paramMMWebViewWithJsApi = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(175497);
      throw paramMMWebViewWithJsApi;
    }
    locale.Jhw = new WeakReference((TmplShareWebViewToolUI)localObject);
    localObject = new v.e();
    ((v.e)localObject).Jhw = new WeakReference((View)paramMMWebViewWithJsApi);
    paramMMWebViewWithJsApi.setBackgroundColor(0);
    paramMMWebViewWithJsApi.setWebViewClient((ab)new a(new b(locale, paramString, (v.e)localObject, paramm), paramInt, paramm1, paramMMWebViewWithJsApi, (MMWebView)paramMMWebViewWithJsApi));
    ad.i("MicroMsg.AdWebViewManager", "init:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(175497);
    return paramMMWebViewWithJsApi;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewClient;", "getA8KeyScene", "", "getWebViewStubCallback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "mmOnPageFinished", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "mmOnPageStarted", "favicon", "Landroid/graphics/Bitmap;", "plugin-brandservice_release"})
  public static final class a
    extends com.tencent.mm.plugin.webview.ui.tools.widget.k
  {
    a(a.b paramb, int paramInt, d.g.a.m paramm, MMWebViewWithJsApi paramMMWebViewWithJsApi, MMWebView paramMMWebView)
    {
      super();
    }
    
    public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(7029);
      super.a(paramWebView, paramString, paramBitmap);
      if (paramWebView == null)
      {
        paramWebView = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMWebView");
        AppMethodBeat.o(7029);
        throw paramWebView;
      }
      com.tencent.mm.plugin.webview.model.a.e((MMWebView)paramWebView);
      AppMethodBeat.o(7029);
    }
    
    public final com.tencent.mm.plugin.webview.ui.tools.widget.m beG()
    {
      return (com.tencent.mm.plugin.webview.ui.tools.widget.m)this.nit;
    }
    
    public final int beH()
    {
      return paramInt;
    }
    
    public final void f(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(7030);
      super.f(paramWebView, paramString);
      paramm1.n(paramWebView, paramString);
      AppMethodBeat.o(7030);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$callback$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "handleMsg", "func", "", "param", "invokeAsResult", "plugin-brandservice_release"})
  public static final class b
    extends com.tencent.mm.plugin.webview.ui.tools.widget.m
  {
    b(v.e parame1, String paramString, v.e parame2, d.g.a.m paramm) {}
    
    public final Bundle ev(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7034);
      if (paramString1 == null) {}
      do
      {
        for (;;)
        {
          paramString1 = super.ev(paramString1, paramString2);
          d.g.b.k.g(paramString1, "super.handleMsg(func, param)");
          AppMethodBeat.o(7034);
          return paramString1;
          switch (paramString1.hashCode())
          {
          }
        }
      } while (!paramString1.equals("configMpAdAttrs"));
      ad.i("MicroMsg.AdWebViewManager", "configMpAdAttrs:".concat(String.valueOf(paramString2)));
      paramString2 = new i(paramString2);
      paramString1 = paramString2.getString("posInfo");
      int i = paramString2.getInt("webviewId");
      paramString2 = paramm;
      d.g.b.k.g(paramString1, "posInfo");
      paramString2.n(paramString1, Integer.valueOf(i));
      paramString1 = c.aDg("configMpAdAttrs:ok");
      d.g.b.k.g(paramString1, "ConstantsJSAPIFunc.creat…ue, \"configMpAdAttrs:ok\")");
      AppMethodBeat.o(7034);
      return paramString1;
    }
    
    public final boolean f(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(7032);
      d.g.b.k.h(paramBundle, "data");
      ad.i("MicroMsg.AdWebViewManager", "callback:".concat(String.valueOf(paramInt)));
      boolean bool = super.f(paramInt, paramBundle);
      AppMethodBeat.o(7032);
      return bool;
    }
    
    public final Bundle j(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(7033);
      ad.i("MicroMsg.AdWebViewManager", "invokeAsResult:".concat(String.valueOf(paramInt)));
      Bundle localBundle = new Bundle();
      Object localObject1;
      if (((WeakReference)this.nix.Jhw).get() != null)
      {
        localObject1 = ((WeakReference)this.nix.Jhw).get();
        if (localObject1 == null)
        {
          paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
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
          d.g.b.k.fvU();
        }
        paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
        localObject1 = (Context)((WeakReference)this.nix.Jhw).get();
        Object localObject2 = paramBundle.getString("open_ui_with_webview_ui_plugin_name");
        String str = paramBundle.getString("open_ui_with_webview_ui_plugin_entry");
        Intent localIntent = new Intent();
        paramBundle = paramBundle.getBundle("open_ui_with_webview_ui_extras");
        if (paramBundle == null) {
          d.g.b.k.fvU();
        }
        d.b((Context)localObject1, (String)localObject2, str, localIntent.putExtras(paramBundle).putExtra("KPublisherId", bt.nullAsNil(paramString)));
        continue;
        localObject1 = ((WeakReference)this.nix.Jhw).get();
        if (localObject1 == null)
        {
          paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
          AppMethodBeat.o(7033);
          throw paramBundle;
        }
        localObject2 = (TmplShareWebViewToolUI)localObject1;
        if (paramBundle != null) {}
        for (localObject1 = paramBundle.getString("action");; localObject1 = null)
        {
          if (!d.g.b.k.g("sendMPPageData", localObject1)) {
            break label314;
          }
          ((TmplShareWebViewToolUI)localObject2).Q(paramBundle);
          break;
        }
        label314:
        if (d.g.b.k.g("closeAdWebview", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).bFh();
        }
        else if (d.g.b.k.g("adWebviewReady", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).bFi();
        }
        else if (d.g.b.k.g("dotWebViewReady", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).T(paramBundle);
        }
        else if (d.g.b.k.g("closeDotWebview", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).R(paramBundle);
        }
        else if (d.g.b.k.g("hideDotWebview", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).S(paramBundle);
        }
        else if (d.g.b.k.g("getMPVideoState", localObject1))
        {
          localBundle.putAll(((TmplShareWebViewToolUI)localObject2).bFj());
        }
        else if (d.g.b.k.g("setWebviewBackground", localObject1))
        {
          paramBundle = paramBundle.getString("backgroundColor");
          ad.i("MicroMsg.AdWebViewManager", "setWebviewBackground ".concat(String.valueOf(paramBundle)));
          paramInt = e.fj(paramBundle, 0);
          if (((WeakReference)this.niz.Jhw).get() != null)
          {
            paramBundle = ((WeakReference)this.niz.Jhw).get();
            if (paramBundle == null) {
              d.g.b.k.fvU();
            }
            ((View)paramBundle).setBackgroundColor(paramInt);
          }
        }
        else if (d.g.b.k.g("opPlayer", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).V(paramBundle);
        }
        else if (d.g.b.k.g("setDotScriptData", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).U(paramBundle);
        }
        else if (d.g.b.k.g("switchVideo", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).O(paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a
 * JD-Core Version:    0.7.0.1
 */