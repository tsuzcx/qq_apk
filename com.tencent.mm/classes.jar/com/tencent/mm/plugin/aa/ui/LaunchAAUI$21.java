package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LaunchAAUI$21
  implements View.OnClickListener
{
  LaunchAAUI$21(LaunchAAUI paramLaunchAAUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.val$url);
    d.b(this.eZt.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.21
 * JD-Core Version:    0.7.0.1
 */