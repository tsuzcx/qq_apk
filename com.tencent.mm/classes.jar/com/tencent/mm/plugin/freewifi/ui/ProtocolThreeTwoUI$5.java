package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeTwoUI$5
  implements View.OnClickListener
{
  ProtocolThreeTwoUI$5(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21177);
    l.B(d.bAB(), this.mPc.getIntent().getStringExtra("free_wifi_ap_key"), this.mPc.getIntent().getIntExtra("free_wifi_protocol_type", 0));
    int i = this.mPc.bBm();
    ab.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { m.U(this.mPc.getIntent()), Integer.valueOf(m.V(this.mPc.getIntent())), d.wl(i) });
    if (i == 2)
    {
      this.mPc.finish();
      AppMethodBeat.o(21177);
      return;
    }
    d.a(this.mPc.ssid, 1, this.mPc.getIntent());
    this.mPc.connect();
    AppMethodBeat.o(21177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.5
 * JD-Core Version:    0.7.0.1
 */