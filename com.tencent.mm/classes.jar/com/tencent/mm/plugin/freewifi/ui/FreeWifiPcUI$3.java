package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class FreeWifiPcUI$3
  implements View.OnClickListener
{
  FreeWifiPcUI$3(FreeWifiPcUI paramFreeWifiPcUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("rawUrl", FreeWifiPcUI.f(this.ksF));
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    d.b(this.ksF.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.3
 * JD-Core Version:    0.7.0.1
 */