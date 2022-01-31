package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.d;

final class FreeWifiStateUI$5
  implements View.OnClickListener
{
  FreeWifiStateUI$5(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21075);
    l.B(d.bAB(), this.mOB.getIntent().getStringExtra("free_wifi_ap_key"), this.mOB.getIntent().getIntExtra("free_wifi_protocol_type", 0));
    if (this.mOB.bBm() == 2)
    {
      this.mOB.finish();
      AppMethodBeat.o(21075);
      return;
    }
    d.a(this.mOB.ssid, 1, this.mOB.getIntent());
    this.mOB.mMy = false;
    this.mOB.bBs();
    AppMethodBeat.o(21075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.5
 * JD-Core Version:    0.7.0.1
 */