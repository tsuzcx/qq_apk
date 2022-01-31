package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class FreeWifiActivateStateUI$6
  implements View.OnClickListener
{
  FreeWifiActivateStateUI$6(FreeWifiActivateStateUI paramFreeWifiActivateStateUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.kqR.getString(R.l.free_wifi_faq_doc);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    d.b(this.kqR.mController.uMN, "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.6
 * JD-Core Version:    0.7.0.1
 */