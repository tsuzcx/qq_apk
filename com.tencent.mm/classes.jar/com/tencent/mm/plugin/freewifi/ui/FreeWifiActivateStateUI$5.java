package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;

final class FreeWifiActivateStateUI$5
  implements View.OnClickListener
{
  FreeWifiActivateStateUI$5(FreeWifiActivateStateUI paramFreeWifiActivateStateUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20903);
    if (this.mMD.bBm() == 2)
    {
      this.mMD.finish();
      AppMethodBeat.o(20903);
      return;
    }
    d.a(this.mMD.ssid, 1, this.mMD.getIntent());
    this.mMD.mMy = false;
    this.mMD.bBs();
    AppMethodBeat.o(20903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.5
 * JD-Core Version:    0.7.0.1
 */