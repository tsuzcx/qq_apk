package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WxaWidgetDebugUI$4
  implements View.OnClickListener
{
  WxaWidgetDebugUI$4(WxaWidgetDebugUI paramWxaWidgetDebugUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.fXw.mController.uMN, WxaWidgetSettingsUI.class);
    paramView.putExtra("app_id", this.fXw.appId);
    paramView.putExtra("pkg_type", this.fXw.bOa);
    paramView.putExtra("pkg_version", this.fXw.fEN);
    this.fXw.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.4
 * JD-Core Version:    0.7.0.1
 */