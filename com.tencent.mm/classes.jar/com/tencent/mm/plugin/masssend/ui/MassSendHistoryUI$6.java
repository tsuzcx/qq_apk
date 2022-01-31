package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class MassSendHistoryUI$6
  implements MMPullDownView.c
{
  MassSendHistoryUI$6(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final boolean bim()
  {
    AppMethodBeat.i(22799);
    if ((MassSendHistoryUI.d(this.oCd).getChildAt(MassSendHistoryUI.d(this.oCd).getChildCount() - 1).getBottom() <= MassSendHistoryUI.d(this.oCd).getHeight()) && (MassSendHistoryUI.d(this.oCd).getLastVisiblePosition() == MassSendHistoryUI.d(this.oCd).getAdapter().getCount() - 1))
    {
      AppMethodBeat.o(22799);
      return true;
    }
    AppMethodBeat.o(22799);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.6
 * JD-Core Version:    0.7.0.1
 */