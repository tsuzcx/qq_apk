package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiFrontPageUI$10
  implements View.OnClickListener
{
  FreeWifiFrontPageUI$10(FreeWifiFrontPageUI paramFreeWifiFrontPageUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20968);
    paramView = new Intent();
    paramView.putExtra("free_wifi_show_detail_error", 1);
    paramView.putExtra("free_wifi_error_ui_error_msg", this.mND.getString(2131300140));
    paramView.putExtra("free_wifi_error_ui_error_msg_detail1", this.mNf);
    paramView.setClass(this.mND, FreeWifiErrorUI.class);
    this.mND.startActivity(paramView);
    AppMethodBeat.o(20968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.10
 * JD-Core Version:    0.7.0.1
 */