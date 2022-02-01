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
  
  public final boolean cAl()
  {
    AppMethodBeat.i(179605);
    View localView = ExdeviceProfileUI.u(this.rJu).getChildAt(ExdeviceProfileUI.u(this.rJu).getChildCount() - 1);
    int i = ExdeviceProfileUI.u(this.rJu).getAdapter().getCount();
    if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceProfileUI.u(this.rJu).getHeight()) && (ExdeviceProfileUI.u(this.rJu).getLastVisiblePosition() >= i - 1))
    {
      AppMethodBeat.o(179605);
      return true;
    }
    AppMethodBeat.o(179605);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.6
 * JD-Core Version:    0.7.0.1
 */