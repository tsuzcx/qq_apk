package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ExdeviceProfileUI$26$1
  implements n.c
{
  ExdeviceProfileUI$26$1(ExdeviceProfileUI.26 param26) {}
  
  public final void a(l paraml)
  {
    if (!bk.bl(ExdeviceProfileUI.o(this.jEU.jEM))) {
      paraml.e(5, this.jEU.jEM.getString(R.l.exdevice_profile_complain));
    }
    paraml.e(3, this.jEU.jEM.getString(R.l.exdevice_profile_add_black_list));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.26.1
 * JD-Core Version:    0.7.0.1
 */