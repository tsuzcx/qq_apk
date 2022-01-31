package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeThreeUI$3
  implements View.OnClickListener
{
  ProtocolThreeThreeUI$3(ProtocolThreeThreeUI paramProtocolThreeThreeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21150);
    l.B(d.bAB(), this.mOZ.getIntent().getStringExtra("free_wifi_ap_key"), this.mOZ.getIntent().getIntExtra("free_wifi_protocol_type", 0));
    int i = this.mOZ.bBm();
    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[] { m.U(this.mOZ.getIntent()), Integer.valueOf(m.V(this.mOZ.getIntent())), d.wl(i) });
    if (i == 2)
    {
      this.mOZ.finish();
      AppMethodBeat.o(21150);
      return;
    }
    d.a(this.mOZ.ssid, 1, this.mOZ.getIntent());
    this.mOZ.connect();
    AppMethodBeat.o(21150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.3
 * JD-Core Version:    0.7.0.1
 */