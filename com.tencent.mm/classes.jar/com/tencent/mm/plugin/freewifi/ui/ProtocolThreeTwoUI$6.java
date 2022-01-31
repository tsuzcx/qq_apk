package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ProtocolThreeTwoUI$6
  implements View.OnClickListener
{
  ProtocolThreeTwoUI$6(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.kto.krL);
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    d.b(this.kto.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.6
 * JD-Core Version:    0.7.0.1
 */