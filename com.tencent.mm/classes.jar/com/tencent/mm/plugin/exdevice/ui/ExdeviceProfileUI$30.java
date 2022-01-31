package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class ExdeviceProfileUI$30
  implements n.c
{
  ExdeviceProfileUI$30(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void a(l paraml)
  {
    if (ExdeviceProfileUI.x(this.jEM))
    {
      paraml.e(1, this.jEM.getString(R.l.exdevice_profile_already_like_cover));
      return;
    }
    paraml.e(4, this.jEM.getString(R.l.exdevice_profile_like_cover));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.30
 * JD-Core Version:    0.7.0.1
 */