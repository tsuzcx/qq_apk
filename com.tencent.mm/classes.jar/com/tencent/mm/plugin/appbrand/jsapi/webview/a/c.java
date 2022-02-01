package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.a.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z.a;

final class c
  extends l
{
  private final com.tencent.mm.plugin.webview.modeltools.d sLM;
  private final g.c sLN;
  private k.c sLZ;
  private final kotlin.g.a.a<g> sMk;
  private a sMl;
  
  c(MMWebView paramMMWebView, g.c paramc, kotlin.g.a.a<g> parama)
  {
    super(paramMMWebView);
    AppMethodBeat.i(327541);
    this.sLM = new com.tencent.mm.plugin.webview.modeltools.d();
    this.sLN = paramc;
    this.sMk = parama;
    AppMethodBeat.o(327541);
  }
  
  private void a(ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(327548);
    final Activity localActivity = AndroidContextUtil.castActivityOrNull(this.sLN.getAndroidContext());
    if (localActivity == null)
    {
      Log.e("MicroMsg.AppBrand.HTMLWebChromeClient", "startFileChooser, invalid context(%s) hash(%d) url(%s)", new Object[] { this.sLN.getAndroidContext(), Integer.valueOf(this.sLN.hashCode()), this.sLN.getWebView().getUrl() });
      AppMethodBeat.o(327548);
      return;
    }
    e.bt(localActivity).b(new e.c()
    {
      public final boolean onResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(327604);
        boolean bool = c.b(c.this).d(localActivity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(327604);
        return bool;
      }
    });
    this.sLM.a(localActivity, (g)this.sMk.invoke(), paramValueCallback, paramValueCallback1, paramString1, paramString2);
    AppMethodBeat.o(327548);
  }
  
  public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(327566);
    if (this.sLN.cxE())
    {
      if (this.sMl == null) {
        this.sMl = new a((byte)0);
      }
      paramView = this.sMl;
      paramCustomViewCallback = AndroidContextUtil.castActivityOrNull(this.sLN.getPageView().getContext());
      if ((paramCustomViewCallback instanceof com.tencent.mm.plugin.appbrand.platform.window.a.a))
      {
        paramView.sMb = ((com.tencent.mm.plugin.appbrand.platform.window.a.a)paramCustomViewCallback);
        paramView.sMb.a(paramView);
      }
    }
    paramView = this.sLN.getAppId();
    paramCustomViewCallback = new k.c()
    {
      private void leaveFullscreen()
      {
        AppMethodBeat.i(327605);
        c.a(c.this).getWebView().leaveFullscreen();
        AppMethodBeat.o(327605);
      }
      
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(327612);
        if (paramAnonymousd == k.d.qrN) {
          leaveFullscreen();
        }
        AppMethodBeat.o(327612);
      }
      
      public final void cbm()
      {
        AppMethodBeat.i(327617);
        leaveFullscreen();
        AppMethodBeat.o(327617);
      }
    };
    this.sLZ = paramCustomViewCallback;
    k.a(paramView, paramCustomViewCallback);
    AppMethodBeat.o(327566);
    return false;
  }
  
  public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, z.a parama)
  {
    AppMethodBeat.i(327599);
    if (parama.getMode() == 0)
    {
      if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
      {
        Log.i("MicroMsg.AppBrand.HTMLWebChromeClient", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
        AppMethodBeat.o(327599);
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
        AppMethodBeat.o(327599);
        return true;
        label92:
        paramWebView = str1;
        if ("video/*".equalsIgnoreCase(str2)) {
          paramWebView = "camcorder";
        }
      }
    }
    AppMethodBeat.o(327599);
    return false;
  }
  
  public final void bfj()
  {
    AppMethodBeat.i(327585);
    this.sLN.cxG();
    AppMethodBeat.o(327585);
  }
  
  public final boolean cxL()
  {
    AppMethodBeat.i(327569);
    if (this.sMl != null) {
      this.sMl.uninstall();
    }
    k.b(this.sLN.getAppId(), this.sLZ);
    this.sLN.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(327607);
        if (c.a(c.this).getPageView().getFullscreenImpl() != null)
        {
          c.a(c.this).getPageView().getFullscreenImpl().cdL();
          com.tencent.mm.plugin.appbrand.page.a.d locald = (com.tencent.mm.plugin.appbrand.page.a.d)c.a(c.this).getPageView().aa(com.tencent.mm.plugin.appbrand.page.a.d.class);
          if (locald != null) {
            locald.a(null);
          }
        }
        AppMethodBeat.o(327607);
      }
    });
    AppMethodBeat.o(327569);
    return false;
  }
  
  public final void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(327577);
    super.d(paramWebView, paramString);
    this.sLN.acw(paramString);
    AppMethodBeat.o(327577);
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(327593);
    a(paramValueCallback, null, paramString1, paramString2);
    AppMethodBeat.o(327593);
  }
  
  final class a
    implements a.a
  {
    com.tencent.mm.plugin.appbrand.platform.window.a.a sMb;
    
    private a() {}
    
    public final boolean Bx(int paramInt)
    {
      AppMethodBeat.i(327636);
      if (c.a(c.this).getPageView().getFullscreenImpl() == null)
      {
        AppMethodBeat.o(327636);
        return false;
      }
      uninstall();
      c.a(c.this).getPageView().getFullscreenImpl().zb(d.a.CT(paramInt));
      AppMethodBeat.o(327636);
      return true;
    }
    
    final void uninstall()
    {
      AppMethodBeat.i(327640);
      if (this.sMb != null) {
        this.sMb.b(this);
      }
      AppMethodBeat.o(327640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.c
 * JD-Core Version:    0.7.0.1
 */