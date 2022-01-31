package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class ExdeviceProfileUI$5
  implements MMPullDownView.c
{
  ExdeviceProfileUI$5(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean bim()
  {
    AppMethodBeat.i(20027);
    View localView = ExdeviceProfileUI.z(this.lOl).getChildAt(ExdeviceProfileUI.z(this.lOl).getChildCount() - 1);
    int i = ExdeviceProfileUI.z(this.lOl).getAdapter().getCount();
    if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceProfileUI.z(this.lOl).getHeight()) && (ExdeviceProfileUI.z(this.lOl).getLastVisiblePosition() >= i - 1))
    {
      AppMethodBeat.o(20027);
      return true;
    }
    AppMethodBeat.o(20027);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.5
 * JD-Core Version:    0.7.0.1
 */