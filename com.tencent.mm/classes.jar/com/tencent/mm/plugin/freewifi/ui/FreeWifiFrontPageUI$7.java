package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;

final class FreeWifiFrontPageUI$7
  implements View.OnClickListener
{
  FreeWifiFrontPageUI$7(FreeWifiFrontPageUI paramFreeWifiFrontPageUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("free_wifi_show_detail_error", 1);
    paramView.putExtra("free_wifi_error_ui_error_msg", this.krP.getString(R.l.free_wifi_connect_fail_msg));
    paramView.putExtra("free_wifi_error_ui_error_msg_detail1", this.krs);
    paramView.setClass(this.krP, FreeWifiErrorUI.class);
    this.krP.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.7
 * JD-Core Version:    0.7.0.1
 */