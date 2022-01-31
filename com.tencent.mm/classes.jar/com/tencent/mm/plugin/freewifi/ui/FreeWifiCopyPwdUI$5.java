package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;

final class FreeWifiCopyPwdUI$5
  implements View.OnClickListener
{
  FreeWifiCopyPwdUI$5(FreeWifiCopyPwdUI paramFreeWifiCopyPwdUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("free_wifi_show_detail_error", 1);
    paramView.putExtra("free_wifi_error_ui_error_msg", this.krr.getString(R.l.free_wifi_connect_fail_msg));
    paramView.putExtra("free_wifi_error_ui_error_msg_detail1", this.krs);
    paramView.setClass(this.krr, FreeWifiErrorUI.class);
    this.krr.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.5
 * JD-Core Version:    0.7.0.1
 */