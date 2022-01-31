package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;

final class FreeWifiIntroductionUI$4
  implements View.OnClickListener
{
  FreeWifiIntroductionUI$4(FreeWifiIntroductionUI paramFreeWifiIntroductionUI) {}
  
  public final void onClick(View paramView)
  {
    if (FreeWifiIntroductionUI.b(this.ksh) == 3) {}
    for (paramView = this.ksh.getString(R.l.mig_free_wifi_service_term_doc);; paramView = this.ksh.getString(R.l.free_wifi_service_term_doc))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      d.b(this.ksh, "webview", ".ui.tools.WebViewUI", localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.4
 * JD-Core Version:    0.7.0.1
 */