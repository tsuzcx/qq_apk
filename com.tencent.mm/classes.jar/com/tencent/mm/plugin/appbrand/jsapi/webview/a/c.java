package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.a.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x.a;

final class c
  extends i
{
  private final com.tencent.mm.plugin.webview.modeltools.c pGM;
  private final g.c pGN;
  private k.c pGZ;
  private final kotlin.g.a.a<g> pHk;
  private a pHl;
  
  c(MMWebView paramMMWebView, g.c paramc, kotlin.g.a.a<g> parama)
  {
    super(paramMMWebView);
    AppMethodBeat.i(265074);
    this.pGM = new com.tencent.mm.plugin.webview.modeltools.c();
    this.pGN = paramc;
    this.pHk = parama;
    AppMethodBeat.o(265074);
  }
  
  private void a(ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(265082);
    final Activity localActivity = AndroidContextUtil.castActivityOrNull(this.pGN.getAndroidContext());
    if (localActivity == null)
    {
      Log.e("MicroMsg.AppBrand.HTMLWebChromeClient", "startFileChooser, invalid context(%s) hash(%d) url(%s)", new Object[] { this.pGN.getAndroidContext(), Integer.valueOf(this.pGN.hashCode()), this.pGN.getWebView().getUrl() });
      AppMethodBeat.o(265082);
      return;
    }
    f.aI(localActivity).b(new f.c()
    {
      public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(266074);
        boolean bool = c.b(c.this).c(localActivity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(266074);
        return bool;
      }
    });
    this.pGM.a(localActivity, (g)this.pHk.invoke(), paramValueCallback, paramValueCallback1, paramString1, paramString2);
    AppMethodBeat.o(265082);
  }
  
  public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(265075);
    if (this.pGN.bXs())
    {
      if (this.pHl == null) {
        this.pHl = new a((byte)0);
      }
      paramView = this.pHl;
      paramCustomViewCallback = AndroidContextUtil.castActivityOrNull(this.pGN.getPageView().getContext());
      if ((paramCustomViewCallback instanceof com.tencent.mm.plugin.appbrand.platform.window.a.a))
      {
        paramView.pHb = ((com.tencent.mm.plugin.appbrand.platform.window.a.a)paramCustomViewCallback);
        paramView.pHb.a(paramView);
      }
    }
    paramView = this.pGN.getAppId();
    paramCustomViewCallback = new k.c()
    {
      private void leaveFullscreen()
      {
        AppMethodBeat.i(278994);
        c.a(c.this).getWebView().leaveFullscreen();
        AppMethodBeat.o(278994);
      }
      
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(278992);
        if (paramAnonymousd == k.d.nti) {
          leaveFullscreen();
        }
        AppMethodBeat.o(278992);
      }
      
      public final void bBQ()
      {
        AppMethodBeat.i(278993);
        leaveFullscreen();
        AppMethodBeat.o(278993);
      }
    };
    this.pGZ = paramCustomViewCallback;
    k.a(paramView, paramCustomViewCallback);
    AppMethodBeat.o(265075);
    return false;
  }
  
  public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
  {
    AppMethodBeat.i(265081);
    if (parama.getMode() == 0)
    {
      if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
      {
        Log.i("MicroMsg.AppBrand.HTMLWebChromeClient", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
        AppMethodBeat.o(265081);
        return true;
      }
      String str2 = parama.getAcceptTypes()[0];
      String str1 = "*";
      paramWebView = str1;
      if (parama.isCaptureEnabled())
      {
        if (!"image/*".equalsIgnoreCase(str2)) {
          break label92;
        }
        paramWebView = "camera";
      }
      for (;;)
      {
        a(null, paramValueCallback, str2, paramWebView);
        AppMethodBeat.o(265081);
        return true;
        label92:
        paramWebView = str1;
        if ("video/*".equalsIgnoreCase(str2)) {
          paramWebView = "camcorder";
        }
      }
    }
    AppMethodBeat.o(265081);
    return false;
  }
  
  public final boolean bXA()
  {
    AppMethodBeat.i(265076);
    if (this.pHl != null) {
      this.pHl.uninstall();
    }
    k.b(this.pGN.getAppId(), this.pGZ);
    this.pGN.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(265696);
        if (c.a(c.this).getPageView().getFullscreenImpl() != null)
        {
          c.a(c.this).getPageView().getFullscreenImpl().bEz();
          com.tencent.mm.plugin.appbrand.page.a.d locald = (com.tencent.mm.plugin.appbrand.page.a.d)c.a(c.this).getPageView().R(com.tencent.mm.plugin.appbrand.page.a.d.class);
          if (locald != null) {
            locald.a(null);
          }
        }
        AppMethodBeat.o(265696);
      }
    });
    AppMethodBeat.o(265076);
    return false;
  }
  
  public final void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(265077);
    super.d(paramWebView, paramString);
    this.pGN.ajv(paramString);
    AppMethodBeat.o(265077);
  }
  
  public final void onClose()
  {
    AppMethodBeat.i(265078);
    this.pGN.bXu();
    AppMethodBeat.o(265078);
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(265080);
    a(paramValueCallback, null, paramString1, paramString2);
    AppMethodBeat.o(265080);
  }
  
  final class a
    implements a.a
  {
    com.tencent.mm.plugin.appbrand.platform.window.a.a pHb;
    
    private a() {}
    
    public final boolean Bk(int paramInt)
    {
      AppMethodBeat.i(269874);
      if (c.a(c.this).getPageView().getFullscreenImpl() == null)
      {
        AppMethodBeat.o(269874);
        return false;
      }
      uninstall();
      c.a(c.this).getPageView().getFullscreenImpl().yS(d.a.CC(paramInt));
      AppMethodBeat.o(269874);
      return true;
    }
    
    final void uninstall()
    {
      AppMethodBeat.i(269875);
      if (this.pHb != null) {
        this.pHb.b(this);
      }
      AppMethodBeat.o(269875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.c
 * JD-Core Version:    0.7.0.1
 */