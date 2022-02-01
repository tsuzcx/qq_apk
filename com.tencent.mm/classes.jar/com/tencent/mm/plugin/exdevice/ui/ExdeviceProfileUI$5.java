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
  
  public final boolean dsq()
  {
    AppMethodBeat.i(24099);
    View localView = ExdeviceProfileUI.u(this.yBy).getChildAt(ExdeviceProfileUI.u(this.yBy).getChildCount() - 1);
    int i = ExdeviceProfileUI.u(this.yBy).getAdapter().getCount();
    if ((i > 0) && (localView != null) && (localView.getBottom() <= ExdeviceProfileUI.u(this.yBy).getHeight()) && (ExdeviceProfileUI.u(this.yBy).getLastVisiblePosition() >= i - 1))
    {
      AppMethodBeat.o(24099);
      return true;
    }
    AppMethodBeat.o(24099);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.5
 * JD-Core Version:    0.7.0.1
 */