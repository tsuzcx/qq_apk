package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;

final class FreeWifiIntroductionUI$5
  implements View.OnClickListener
{
  FreeWifiIntroductionUI$5(FreeWifiIntroductionUI paramFreeWifiIntroductionUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.ksh.getString(R.l.free_wifi_faq_doc);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    d.b(this.ksh, "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.5
 * JD-Core Version:    0.7.0.1
 */