package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class a$2
  implements DownloadListener
{
  a$2(a parama) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(155909);
    boolean bool;
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVu, 1) > 0) {
      bool = true;
    }
    for (;;)
    {
      ab.i("MicroMsg.AppBrandHTMLWebView", "onDownloadStart page[%s], downloadUrl[%s], userAgent[%s], contentDisposition[%s], mime[%s], contentLength[%d], allowDownloadByExpt[%b]", new Object[] { a.b(this.igQ).hzM, paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), Boolean.valueOf(bool) });
      h.qsU.cT(1097, 0);
      try
      {
        paramString2 = a.b(this.igQ).getRuntime();
        e.b(this.igQ.getAppId(), paramString2.atS().bDc, paramString2.gPz.gXd, 1097, 0);
        label136:
        if (!bool)
        {
          AppMethodBeat.o(155909);
          return;
          bool = false;
          continue;
        }
        paramString3 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
        paramString3.addFlags(268435456);
        try
        {
          paramString2 = com.tencent.mm.sdk.f.a.hr(a.b(this.igQ).mContext);
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = ah.getContext();
          }
          paramString1.startActivity(paramString3);
          AppMethodBeat.o(155909);
          return;
        }
        catch (Exception paramString1)
        {
          ab.e("MicroMsg.AppBrandHTMLWebView", "startActivity fail, e = " + paramString1.getMessage());
          AppMethodBeat.o(155909);
          return;
        }
      }
      catch (NullPointerException paramString2)
      {
        break label136;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.2
 * JD-Core Version:    0.7.0.1
 */