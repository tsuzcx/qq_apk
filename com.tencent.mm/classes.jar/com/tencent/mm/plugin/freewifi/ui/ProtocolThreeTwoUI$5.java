package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeTwoUI$5
  implements View.OnClickListener
{
  ProtocolThreeTwoUI$5(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final void onClick(View paramView)
  {
    l.u(d.aTZ(), this.kto.getIntent().getStringExtra("free_wifi_ap_key"), this.kto.getIntent().getIntExtra("free_wifi_protocol_type", 0));
    int i = this.kto.aUO();
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { m.B(this.kto.getIntent()), Integer.valueOf(m.C(this.kto.getIntent())), d.rr(i) });
    if (i == 2)
    {
      this.kto.finish();
      return;
    }
    d.a(this.kto.ssid, 1, this.kto.getIntent());
    this.kto.connect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.5
 * JD-Core Version:    0.7.0.1
 */