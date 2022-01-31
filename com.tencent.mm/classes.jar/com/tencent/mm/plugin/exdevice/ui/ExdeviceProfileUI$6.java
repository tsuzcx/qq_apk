package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class ExdeviceProfileUI$6
  implements MMPullDownView.d
{
  ExdeviceProfileUI$6(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final boolean bil()
  {
    AppMethodBeat.i(20028);
    if (ExdeviceProfileUI.z(this.lOl).getFirstVisiblePosition() == 0)
    {
      View localView = ExdeviceProfileUI.z(this.lOl).getChildAt(ExdeviceProfileUI.z(this.lOl).getFirstVisiblePosition());
      if ((localView != null) && (localView.getTop() >= 0))
      {
        AppMethodBeat.o(20028);
        return true;
      }
    }
    AppMethodBeat.o(20028);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.6
 * JD-Core Version:    0.7.0.1
 */