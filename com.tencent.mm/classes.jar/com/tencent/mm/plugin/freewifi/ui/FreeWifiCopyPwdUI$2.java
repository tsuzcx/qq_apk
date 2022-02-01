package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiCopyPwdUI$2
  implements View.OnClickListener
{
  FreeWifiCopyPwdUI$2(FreeWifiCopyPwdUI paramFreeWifiCopyPwdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24996);
    paramView = new Intent("android.settings.WIFI_SETTINGS");
    this.ssP.startActivityForResult(paramView, FreeWifiCopyPwdUI.ssJ);
    AppMethodBeat.o(24996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.2
 * JD-Core Version:    0.7.0.1
 */