package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeThreeUI$3
  implements View.OnClickListener
{
  ProtocolThreeThreeUI$3(ProtocolThreeThreeUI paramProtocolThreeThreeUI) {}
  
  public final void onClick(View paramView)
  {
    l.u(d.aTZ(), this.ktl.getIntent().getStringExtra("free_wifi_ap_key"), this.ktl.getIntent().getIntExtra("free_wifi_protocol_type", 0));
    int i = this.ktl.aUO();
    y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { m.B(this.ktl.getIntent()), Integer.valueOf(m.C(this.ktl.getIntent())), d.rr(i) });
    if (i == 2)
    {
      this.ktl.finish();
      return;
    }
    d.a(this.ktl.ssid, 1, this.ktl.getIntent());
    this.ktl.connect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.3
 * JD-Core Version:    0.7.0.1
 */