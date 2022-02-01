package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

final class a$2
  implements DownloadListener
{
  a$2(a parama) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(46966);
    if (((b)g.ab(b.class)).a(b.a.qxq, 1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrandHTMLWebView", "onDownloadStart page[%s], downloadUrl[%s], userAgent[%s], contentDisposition[%s], mime[%s], contentLength[%d], allowDownloadByExpt[%b]", new Object[] { a.b(this.lvn).kuf, paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), Boolean.valueOf(bool) });
      a.c(this.lvn).tH(0);
      if (bool) {
        break;
      }
      AppMethodBeat.o(46966);
      return;
    }
    paramString3 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    paramString3.addFlags(268435456);
    try
    {
      paramString2 = a.b(this.lvn).getActivity();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = aj.getContext();
      }
      paramString2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString3);
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.ahp(), "com/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString1.startActivity((Intent)paramString2.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(46966);
      return;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.AppBrandHTMLWebView", "startActivity fail, e = " + paramString1.getMessage());
      AppMethodBeat.o(46966);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a.2
 * JD-Core Version:    0.7.0.1
 */