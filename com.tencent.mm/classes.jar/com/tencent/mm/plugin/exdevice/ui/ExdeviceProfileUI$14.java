package com.tencent.mm.plugin.exdevice.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

final class ExdeviceProfileUI$14
  implements Runnable
{
  ExdeviceProfileUI$14(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void run()
  {
    BackwardSupportUtil.c.a(ExdeviceProfileUI.z(this.jEM));
    if (ExdeviceProfileUI.z(this.jEM).getCount() > 0) {
      BackwardSupportUtil.c.b(ExdeviceProfileUI.z(this.jEM), ExdeviceProfileUI.z(this.jEM).getCount() - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.14
 * JD-Core Version:    0.7.0.1
 */