package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class ExdeviceProfileUI$5
  implements MMPullDownView.c
{
  ExdeviceProfileUI$5(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean aEW()
  {
    View localView = ExdeviceProfileUI.z(this.jEM).getChildAt(ExdeviceProfileUI.z(this.jEM).getChildCount() - 1);
    int i = ExdeviceProfileUI.z(this.jEM).getAdapter().getCount();
    return (i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceProfileUI.z(this.jEM).getHeight()) && (ExdeviceProfileUI.z(this.jEM).getLastVisiblePosition() >= i - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.5
 * JD-Core Version:    0.7.0.1
 */