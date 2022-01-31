package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.ui.base.p;

final class ExdeviceProfileUI$1$1
  implements Runnable
{
  ExdeviceProfileUI$1$1(ExdeviceProfileUI.1 param1, i parami) {}
  
  public final void run()
  {
    if (ExdeviceProfileUI.d(this.jEO.jEM) != null) {
      ExdeviceProfileUI.d(this.jEO.jEM).dismiss();
    }
    ExdeviceProfileUI.a(this.jEO.jEM, this.jEN.jxW);
    ExdeviceProfileUI.f(this.jEO.jEM).setAffectedUserInfo(ExdeviceProfileUI.e(this.jEO.jEM));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.1.1
 * JD-Core Version:    0.7.0.1
 */