package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaWidgetDebugUI$4
  implements View.OnClickListener
{
  WxaWidgetDebugUI$4(WxaWidgetDebugUI paramWxaWidgetDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11014);
    paramView = new Intent(this.hqW.getContext(), WxaWidgetSettingsUI.class);
    paramView.putExtra("app_id", this.hqW.appId);
    paramView.putExtra("pkg_type", this.hqW.cvs);
    paramView.putExtra("pkg_version", this.hqW.gXf);
    this.hqW.startActivity(paramView);
    AppMethodBeat.o(11014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI.4
 * JD-Core Version:    0.7.0.1
 */