package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.freewifi.model.d;

final class FreeWifiActivateStateUI$5
  implements View.OnClickListener
{
  FreeWifiActivateStateUI$5(FreeWifiActivateStateUI paramFreeWifiActivateStateUI) {}
  
  public final void onClick(View paramView)
  {
    if (this.kqR.aUO() == 2)
    {
      this.kqR.finish();
      return;
    }
    d.a(this.kqR.ssid, 1, this.kqR.getIntent());
    this.kqR.kqM = false;
    this.kqR.aUU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.5
 * JD-Core Version:    0.7.0.1
 */