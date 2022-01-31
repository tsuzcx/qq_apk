package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;

final class FreeWifiActivateAuthStateUI$1
  implements View.OnClickListener
{
  FreeWifiActivateAuthStateUI$1(FreeWifiActivateAuthStateUI paramFreeWifiActivateAuthStateUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.kqB.getString(R.l.free_wifi_faq_doc);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    d.b(this.kqB, "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI.1
 * JD-Core Version:    0.7.0.1
 */