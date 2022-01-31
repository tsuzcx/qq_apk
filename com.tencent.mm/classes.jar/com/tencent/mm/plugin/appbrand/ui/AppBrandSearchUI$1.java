package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;

final class AppBrandSearchUI$1
  implements View.OnClickListener
{
  AppBrandSearchUI$1(AppBrandSearchUI paramAppBrandSearchUI) {}
  
  public final void onClick(View paramView)
  {
    if (TextUtils.isEmpty(AppBrandSearchUI.a(this.hdU))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("rawUrl", AppBrandSearchUI.a(this.hdU));
    localIntent.putExtra("geta8key_scene", 41);
    localIntent.putExtra("show_long_click_popup_menu", false);
    d.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI.1
 * JD-Core Version:    0.7.0.1
 */