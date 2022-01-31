package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class ExdeviceProfileUI$6
  implements MMPullDownView.d
{
  ExdeviceProfileUI$6(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean aEV()
  {
    if (ExdeviceProfileUI.z(this.jEM).getFirstVisiblePosition() == 0)
    {
      View localView = ExdeviceProfileUI.z(this.jEM).getChildAt(ExdeviceProfileUI.z(this.jEM).getFirstVisiblePosition());
      if ((localView != null) && (localView.getTop() >= 0)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.6
 * JD-Core Version:    0.7.0.1
 */