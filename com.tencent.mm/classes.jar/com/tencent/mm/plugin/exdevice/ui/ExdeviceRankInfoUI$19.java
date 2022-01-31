package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ExdeviceRankInfoUI$19
  implements n.c
{
  ExdeviceRankInfoUI$19(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void a(l paraml)
  {
    if (y.getLogLevel() == 0) {}
    for (int i = 2;; i = g.AA().getInt("WeRunLaunchGroupRankWeAppSwitch", 0))
    {
      if (i == 2) {
        paraml.a(3, this.jFV.getString(R.l.exdevice_opt_menu_share_sport_appbrand), R.k.bottomsheet_icon_transmit);
      }
      paraml.a(0, this.jFV.getString(R.l.exdevice_opt_menu_send_to_friend), R.k.bottomsheet_icon_transmit);
      paraml.a(1, this.jFV.getString(R.l.exdevice_opt_menu_share_to_timeline), R.k.bottomsheet_icon_moment);
      paraml.a(2, this.jFV.getString(R.l.exdevice_opt_menu_donate), R.k.bottomsheet_icon_donate);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.19
 * JD-Core Version:    0.7.0.1
 */