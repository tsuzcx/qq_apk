package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class ExdeviceProfileUI$7
  implements MMPullDownView.d
{
  ExdeviceProfileUI$7(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean cAk()
  {
    AppMethodBeat.i(179606);
    if (ExdeviceProfileUI.u(this.rJu).getFirstVisiblePosition() == 0)
    {
      View localView = ExdeviceProfileUI.u(this.rJu).getChildAt(ExdeviceProfileUI.u(this.rJu).getFirstVisiblePosition());
      if ((localView != null) && (localView.getTop() >= 0))
      {
        AppMethodBeat.o(179606);
        return true;
      }
    }
    AppMethodBeat.o(179606);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.7
 * JD-Core Version:    0.7.0.1
 */