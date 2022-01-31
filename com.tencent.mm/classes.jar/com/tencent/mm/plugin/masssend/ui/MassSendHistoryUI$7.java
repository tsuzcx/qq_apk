package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class MassSendHistoryUI$7
  implements MMPullDownView.d
{
  MassSendHistoryUI$7(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final boolean bil()
  {
    AppMethodBeat.i(22800);
    View localView = MassSendHistoryUI.d(this.oCd).getChildAt(MassSendHistoryUI.d(this.oCd).getFirstVisiblePosition());
    if ((localView != null) && (localView.getTop() == 0))
    {
      AppMethodBeat.o(22800);
      return true;
    }
    AppMethodBeat.o(22800);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.7
 * JD-Core Version:    0.7.0.1
 */