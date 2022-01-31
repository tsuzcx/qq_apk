package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.d;

final class FreeWifiStateUI$5
  implements View.OnClickListener
{
  FreeWifiStateUI$5(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final void onClick(View paramView)
  {
    l.u(d.aTZ(), this.ksM.getIntent().getStringExtra("free_wifi_ap_key"), this.ksM.getIntent().getIntExtra("free_wifi_protocol_type", 0));
    if (this.ksM.aUO() == 2)
    {
      this.ksM.finish();
      return;
    }
    d.a(this.ksM.ssid, 1, this.ksM.getIntent());
    this.ksM.kqM = false;
    this.ksM.aUU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.5
 * JD-Core Version:    0.7.0.1
 */