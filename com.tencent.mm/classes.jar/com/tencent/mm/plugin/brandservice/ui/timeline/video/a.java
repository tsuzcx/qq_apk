package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.protocal.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager;", "", "()V", "TAG", "", "initAdWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "webView", "publishId", "configMpAdAttrs", "Lkotlin/Function2;", "", "", "onPageFinsh", "Lcom/tencent/xweb/WebView;", "Lkotlin/ParameterName;", "name", "view", "url", "getA8KeyScene", "plugin-brandservice_release"})
public final class a
{
  public static final a otI;
  
  static
  {
    AppMethodBeat.i(7036);
    otI = new a();
    AppMethodBeat.o(7036);
  }
  
  public static MMWebViewWithJsApi a(final MMWebViewWithJsApi paramMMWebViewWithJsApi, final String paramString, final d.g.a.m<? super String, ? super Integer, z> paramm, final d.g.a.m<? super WebView, ? super String, z> paramm1, final int paramInt)
  {
    AppMethodBeat.i(175497);
    p.h(paramMMWebViewWithJsApi, "webView");
    p.h(paramm, "configMpAdAttrs");
    p.h(paramm1, "onPageFinsh");
    y.f localf = new y.f();
    Object localObject = paramMMWebViewWithJsApi.getContext();
    if (localObject == null)
    {
      paramMMWebViewWithJsApi = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(175497);
      throw paramMMWebViewWithJsApi;
    }
    localf.NiY = new WeakReference((TmplShareWebViewToolUI)localObject);
    localObject = new y.f();
    ((y.f)localObject).NiY = new WeakReference((View)paramMMWebViewWithJsApi);
    paramMMWebViewWithJsApi.setBackgroundColor(0);
    paramMMWebViewWithJsApi.setWebViewClient((ac)new a(new b(localf, paramString, (y.f)localObject, paramm), paramInt, paramm1, paramMMWebViewWithJsApi, (MMWebView)paramMMWebViewWithJsApi));
    ae.i("MicroMsg.AdWebViewManager", "init:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(175497);
    return paramMMWebViewWithJsApi;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewClient;", "getA8KeyScene", "", "getWebViewStubCallback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "mmOnPageFinished", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "mmOnPageStarted", "favicon", "Landroid/graphics/Bitmap;", "plugin-brandservice_release"})
  public static final class a
    extends k
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
    
    public final com.tencent.mm.plugin.webview.ui.tools.widget.m bpV()
    {
      return (com.tencent.mm.plugin.webview.ui.tools.widget.m)this.otJ;
    }
    
    public final int bpW()
    {
      return paramInt;
    }
    
    public final void f(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(7030);
      super.f(paramWebView, paramString);
      paramm1.p(paramWebView, paramString);
      AppMethodBeat.o(7030);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$callback$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "handleMsg", "func", "", "param", "invokeAsResult", "plugin-brandservice_release"})
  public static final class b
    extends com.tencent.mm.plugin.webview.ui.tools.widget.m
  {
    b(y.f paramf1, String paramString, y.f paramf2, d.g.a.m paramm) {}
    
    public final Bundle eU(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7034);
      if (paramString1 == null) {}
      do
      {
        for (;;)
        {
          paramString1 = super.eU(paramString1, paramString2);
          p.g(paramString1, "super.handleMsg(func, param)");
          AppMethodBeat.o(7034);
          return paramString1;
          switch (paramString1.hashCode())
          {
          }
        }
      } while (!paramString1.equals("configMpAdAttrs"));
      ae.i("MicroMsg.AdWebViewManager", "configMpAdAttrs:".concat(String.valueOf(paramString2)));
      paramString2 = new i(paramString2);
      paramString1 = paramString2.getString("posInfo");
      int i = paramString2.getInt("webviewId");
      paramString2 = paramm;
      p.g(paramString1, "posInfo");
      paramString2.p(paramString1, Integer.valueOf(i));
      paramString1 = c.aPx("configMpAdAttrs:ok");
      p.g(paramString1, "ConstantsJSAPIFunc.creat…ue, \"configMpAdAttrs:ok\")");
      AppMethodBeat.o(7034);
      return paramString1;
    }
    
    public final boolean g(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(7032);
      p.h(paramBundle, "data");
      ae.i("MicroMsg.AdWebViewManager", "callback:".concat(String.valueOf(paramInt)));
      boolean bool = super.g(paramInt, paramBundle);
      AppMethodBeat.o(7032);
      return bool;
    }
    
    public final Bundle k(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(7033);
      ae.i("MicroMsg.AdWebViewManager", "invokeAsResult:".concat(String.valueOf(paramInt)));
      Bundle localBundle = new Bundle();
      Object localObject1;
      if (((WeakReference)this.otN.NiY).get() != null)
      {
        localObject1 = ((WeakReference)this.otN.NiY).get();
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
          p.gkB();
        }
        paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
        localObject1 = (Context)((WeakReference)this.otN.NiY).get();
        Object localObject2 = paramBundle.getString("open_ui_with_webview_ui_plugin_name");
        String str = paramBundle.getString("open_ui_with_webview_ui_plugin_entry");
        Intent localIntent = new Intent();
        paramBundle = paramBundle.getBundle("open_ui_with_webview_ui_extras");
        if (paramBundle == null) {
          p.gkB();
        }
        d.b((Context)localObject1, (String)localObject2, str, localIntent.putExtras(paramBundle).putExtra("KPublisherId", bu.nullAsNil(paramString)));
        continue;
        localObject1 = ((WeakReference)this.otN.NiY).get();
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
          if (!p.i("sendMPPageData", localObject1)) {
            break label314;
          }
          ((TmplShareWebViewToolUI)localObject2).U(paramBundle);
          break;
        }
        label314:
        if (p.i("closeAdWebview", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).bRV();
        }
        else if (p.i("adWebviewReady", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).bRW();
        }
        else if (p.i("dotWebViewReady", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).X(paramBundle);
        }
        else if (p.i("closeDotWebview", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).V(paramBundle);
        }
        else if (p.i("hideDotWebview", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).W(paramBundle);
        }
        else if (p.i("getMPVideoState", localObject1))
        {
          localBundle.putAll(((TmplShareWebViewToolUI)localObject2).bRX());
        }
        else if (p.i("setWebviewBackground", localObject1))
        {
          paramBundle = paramBundle.getString("backgroundColor");
          ae.i("MicroMsg.AdWebViewManager", "setWebviewBackground ".concat(String.valueOf(paramBundle)));
          paramInt = e.ee(paramBundle, 0);
          if (((WeakReference)this.otP.NiY).get() != null)
          {
            paramBundle = ((WeakReference)this.otP.NiY).get();
            if (paramBundle == null) {
              p.gkB();
            }
            ((View)paramBundle).setBackgroundColor(paramInt);
          }
        }
        else if (p.i("opPlayer", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).Z(paramBundle);
        }
        else if (p.i("setDotScriptData", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).Y(paramBundle);
        }
        else if (p.i("switchVideo", localObject1))
        {
          ((TmplShareWebViewToolUI)localObject2).S(paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a
 * JD-Core Version:    0.7.0.1
 */