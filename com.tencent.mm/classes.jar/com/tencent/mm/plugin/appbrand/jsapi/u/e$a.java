package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p.a;

final class e$a
  extends i
{
  e$a(e parame, MMWebViewWithJsApi paramMMWebViewWithJsApi)
  {
    super(paramMMWebViewWithJsApi);
  }
  
  private void a(ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(17041);
    if (!(e.d(this.ihi).getContext() instanceof MMActivity))
    {
      AppMethodBeat.o(17041);
      return;
    }
    MMActivity localMMActivity = (MMActivity)e.d(this.ihi).getContext();
    localMMActivity.mmSetOnActivityResultCallback(new e.a.1(this, localMMActivity));
    e.e(this.ihi).a(localMMActivity, e.f(this.ihi), paramValueCallback, paramValueCallback1, paramString1, paramString2);
    AppMethodBeat.o(17041);
  }
  
  public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, p.a parama)
  {
    AppMethodBeat.i(17040);
    if (parama.getMode() == 0)
    {
      if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
      {
        ab.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
        AppMethodBeat.o(17040);
        return true;
      }
      String str2 = parama.getAcceptTypes()[0];
      String str1 = "*";
      paramWebView = str1;
      if (parama.isCaptureEnabled())
      {
        if (!"image/*".equalsIgnoreCase(str2)) {
          break label95;
        }
        paramWebView = "camera";
      }
      for (;;)
      {
        a(null, paramValueCallback, str2, paramWebView);
        AppMethodBeat.o(17040);
        return true;
        label95:
        paramWebView = str1;
        if ("video/*".equalsIgnoreCase(str2)) {
          paramWebView = "camcorder";
        }
      }
    }
    AppMethodBeat.o(17040);
    return false;
  }
  
  public final void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(17037);
    super.d(paramWebView, paramString);
    e.b(this.ihi).Da(paramString);
    AppMethodBeat.o(17037);
  }
  
  public final void onClose()
  {
    AppMethodBeat.i(17038);
    e.b(this.ihi).aGi();
    AppMethodBeat.o(17038);
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(17039);
    a(paramValueCallback, null, paramString1, paramString2);
    AppMethodBeat.o(17039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e.a
 * JD-Core Version:    0.7.0.1
 */