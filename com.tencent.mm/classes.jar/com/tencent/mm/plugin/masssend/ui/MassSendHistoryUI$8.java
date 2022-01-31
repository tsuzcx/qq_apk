package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.p.a;

final class MassSendHistoryUI$8
  implements p.a
{
  MassSendHistoryUI$8(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final void apT()
  {
    AppMethodBeat.i(22801);
    MassSendHistoryUI.c(this.oCd).setIsTopShowAll(MassSendHistoryUI.b(this.oCd).bem());
    if (MassSendHistoryUI.b(this.oCd).getCount() == 0)
    {
      MassSendHistoryUI.c(this.oCd).setVisibility(8);
      MassSendHistoryUI.e(this.oCd).setVisibility(0);
      MassSendHistoryUI.f(this.oCd).setVisibility(8);
      AppMethodBeat.o(22801);
      return;
    }
    MassSendHistoryUI.c(this.oCd).setVisibility(0);
    MassSendHistoryUI.e(this.oCd).setVisibility(8);
    MassSendHistoryUI.f(this.oCd).setVisibility(0);
    AppMethodBeat.o(22801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.8
 * JD-Core Version:    0.7.0.1
 */