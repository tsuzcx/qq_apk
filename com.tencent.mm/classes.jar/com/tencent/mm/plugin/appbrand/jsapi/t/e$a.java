package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.webview.modeltools.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j.a;

final class e$a
  extends i
{
  e$a(e parame, MMWebViewWithJsApi paramMMWebViewWithJsApi)
  {
    super(paramMMWebViewWithJsApi);
  }
  
  private void a(ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    if (!(e.c(this.gGA).getContext() instanceof MMActivity)) {
      return;
    }
    MMActivity localMMActivity = (MMActivity)e.c(this.gGA).getContext();
    localMMActivity.gJb = new e.a.1(this, localMMActivity);
    e.d(this.gGA).a(localMMActivity, e.e(this.gGA), paramValueCallback, paramValueCallback1, paramString1, paramString2);
  }
  
  public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, j.a parama)
  {
    boolean bool = false;
    if (parama.getMode() == 0)
    {
      if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
      {
        y.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
        bool = true;
      }
    }
    else {
      return bool;
    }
    String str2 = parama.getAcceptTypes()[0];
    String str1 = "*";
    paramWebView = str1;
    if (parama.isCaptureEnabled())
    {
      if (!"image/*".equalsIgnoreCase(str2)) {
        break label84;
      }
      paramWebView = "camera";
    }
    for (;;)
    {
      a(null, paramValueCallback, str2, paramWebView);
      return true;
      label84:
      paramWebView = str1;
      if ("video/*".equalsIgnoreCase(str2)) {
        paramWebView = "camcorder";
      }
    }
  }
  
  public final void d(WebView paramWebView, String paramString)
  {
    super.d(paramWebView, paramString);
    e.b(this.gGA).uI(paramString);
  }
  
  protected final void onClose()
  {
    e.b(this.gGA).alh();
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    a(paramValueCallback, null, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.a
 * JD-Core Version:    0.7.0.1
 */