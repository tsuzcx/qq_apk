package com.tencent.mm.plugin.masssend.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.g;

final class MassSendHistoryUI$5
  implements MMPullDownView.g
{
  MassSendHistoryUI$5(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final boolean bin()
  {
    int i = 0;
    AppMethodBeat.i(22798);
    if (MassSendHistoryUI.b(this.oCd).bem())
    {
      MassSendHistoryUI.d(this.oCd).setSelectionFromTop(0, MassSendHistoryUI.c(this.oCd).getTopHeight());
      AppMethodBeat.o(22798);
      return true;
    }
    c localc = MassSendHistoryUI.b(this.oCd);
    if (localc.bem()) {}
    for (;;)
    {
      ab.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:".concat(String.valueOf(i)));
      MassSendHistoryUI.b(this.oCd).a(null, null);
      MassSendHistoryUI.d(this.oCd).setSelectionFromTop(i, MassSendHistoryUI.c(this.oCd).getTopHeight());
      AppMethodBeat.o(22798);
      return true;
      localc.kxm += 10;
      if (localc.kxm <= localc.eke)
      {
        i = 10;
      }
      else
      {
        localc.kxm = localc.eke;
        i = localc.eke % 10;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.5
 * JD-Core Version:    0.7.0.1
 */