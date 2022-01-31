package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeOneUI$3
  implements View.OnClickListener
{
  ProtocolThreeOneUI$3(ProtocolThreeOneUI paramProtocolThreeOneUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21123);
    l.B(d.bAB(), this.mOW.getIntent().getStringExtra("free_wifi_ap_key"), this.mOW.getIntent().getIntExtra("free_wifi_protocol_type", 0));
    int i = this.mOW.bBm();
    ab.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { m.U(this.mOW.getIntent()), Integer.valueOf(m.V(this.mOW.getIntent())), d.wl(i) });
    if (i == 2)
    {
      this.mOW.finish();
      AppMethodBeat.o(21123);
      return;
    }
    d.a(this.mOW.ssid, 1, this.mOW.getIntent());
    this.mOW.connect();
    AppMethodBeat.o(21123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.3
 * JD-Core Version:    0.7.0.1
 */