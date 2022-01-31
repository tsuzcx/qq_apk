package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.ui.collection.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.Locale;

final class AppBrandProfileUI$4
  implements n.d
{
  AppBrandProfileUI$4(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 1: 
      do
      {
        return;
        if (AppBrandProfileUI.c(this.hdE) == null)
        {
          y.e("MicroMsg.AppBrandProfileUI", "wxaExposedParams is null");
          return;
        }
        paramMenuItem = new Intent();
        String str = r.a(AppBrandProfileUI.c(this.hdE));
        y.i("MicroMsg.AppBrandProfileUI", "wxaExposedParams:%s", new Object[] { AppBrandProfileUI.c(this.hdE).toString() });
        y.v("MicroMsg.AppBrandProfileUI", "KRawUrl " + str);
        paramMenuItem.putExtra("rawUrl", str);
        paramMenuItem.putExtra("forceHideShare", true);
        d.b(this.hdE, "webview", ".ui.tools.WebViewUI", paramMenuItem);
        AppBrandProfileUI.a(this.hdE, 7, 1);
      } while (AppBrandProfileUI.c(this.hdE).from != 3);
      AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.uy(AppBrandProfileUI.e(this.hdE).appId);
      return;
    case 2: 
      paramMenuItem = new Intent(this.hdE, AppBrandAuthorizeUI.class).putExtra("key_username", AppBrandProfileUI.b(this.hdE));
      d.b(this.hdE, "appbrand", ".ui.AppBrandAuthorizeUI", paramMenuItem);
      AppBrandProfileUI.a(this.hdE, 10, 1);
      return;
    case 3: 
      paramMenuItem = String.format(Locale.US, "https://mp.weixin.qq.com/mp/wapreportwxadevlog?action=get_page&appid=%s#wechat_redirect", new Object[] { AppBrandProfileUI.c(this.hdE).appId });
      paramMenuItem = new Intent().putExtra("rawUrl", paramMenuItem).putExtra("forceHideShare", true);
      d.b(this.hdE, "webview", ".ui.tools.WebViewUI", paramMenuItem);
      return;
    }
    boolean bool1 = ((af)g.r(af.class)).ap(AppBrandProfileUI.b(this.hdE), 0);
    boolean bool2 = f.a(bool1, this.hdE, AppBrandProfileUI.b(this.hdE), 0);
    if (bool1)
    {
      paramInt = 12;
      if (!bool2) {
        break label369;
      }
    }
    label369:
    for (int i = 1;; i = 2)
    {
      AppBrandProfileUI.a(this.hdE, paramInt, i);
      return;
      paramInt = 11;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.4
 * JD-Core Version:    0.7.0.1
 */