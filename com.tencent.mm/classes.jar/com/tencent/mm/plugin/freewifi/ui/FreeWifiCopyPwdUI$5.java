package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiCopyPwdUI$5
  implements View.OnClickListener
{
  FreeWifiCopyPwdUI$5(FreeWifiCopyPwdUI paramFreeWifiCopyPwdUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20940);
    paramView = new Intent();
    paramView.putExtra("free_wifi_show_detail_error", 1);
    paramView.putExtra("free_wifi_error_ui_error_msg", this.mNe.getString(2131300140));
    paramView.putExtra("free_wifi_error_ui_error_msg_detail1", this.mNf);
    paramView.setClass(this.mNe, FreeWifiErrorUI.class);
    this.mNe.startActivity(paramView);
    AppMethodBeat.o(20940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.5
 * JD-Core Version:    0.7.0.1
 */