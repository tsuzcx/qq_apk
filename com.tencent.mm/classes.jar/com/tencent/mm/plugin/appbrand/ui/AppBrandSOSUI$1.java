package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;

final class AppBrandSOSUI$1
  implements View.OnClickListener
{
  AppBrandSOSUI$1(AppBrandSOSUI paramAppBrandSOSUI) {}
  
  public final void onClick(View paramView)
  {
    if (TextUtils.isEmpty(AppBrandSOSUI.a(this.hdT))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("rawUrl", AppBrandSOSUI.a(this.hdT));
    localIntent.putExtra("geta8key_scene", 41);
    localIntent.putExtra("show_long_click_popup_menu", false);
    d.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSOSUI.1
 * JD-Core Version:    0.7.0.1
 */