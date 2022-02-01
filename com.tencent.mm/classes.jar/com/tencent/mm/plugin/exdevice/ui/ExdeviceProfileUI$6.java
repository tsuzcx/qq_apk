package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class ExdeviceProfileUI$6
  implements MMPullDownView.c
{
  ExdeviceProfileUI$6(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean bPj()
  {
    AppMethodBeat.i(179605);
    View localView = ExdeviceProfileUI.z(this.peX).getChildAt(ExdeviceProfileUI.z(this.peX).getChildCount() - 1);
    int i = ExdeviceProfileUI.z(this.peX).getAdapter().getCount();
    if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceProfileUI.z(this.peX).getHeight()) && (ExdeviceProfileUI.z(this.peX).getLastVisiblePosition() >= i - 1))
    {
      AppMethodBeat.o(179605);
      return true;
    }
    AppMethodBeat.o(179605);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.6
 * JD-Core Version:    0.7.0.1
 */