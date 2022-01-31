package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeOneUI$3
  implements View.OnClickListener
{
  ProtocolThreeOneUI$3(ProtocolThreeOneUI paramProtocolThreeOneUI) {}
  
  public final void onClick(View paramView)
  {
    l.u(d.aTZ(), this.kti.getIntent().getStringExtra("free_wifi_ap_key"), this.kti.getIntent().getIntExtra("free_wifi_protocol_type", 0));
    int i = this.kti.aUO();
    y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { m.B(this.kti.getIntent()), Integer.valueOf(m.C(this.kti.getIntent())), d.rr(i) });
    if (i == 2)
    {
      this.kti.finish();
      return;
    }
    d.a(this.kti.ssid, 1, this.kti.getIntent());
    this.kti.connect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.3
 * JD-Core Version:    0.7.0.1
 */