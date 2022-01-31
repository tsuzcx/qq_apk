package com.tencent.mm.plugin.masssend.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.g;

final class MassSendHistoryUI$5
  implements MMPullDownView.g
{
  MassSendHistoryUI$5(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final boolean aEX()
  {
    int i = 0;
    if (MassSendHistoryUI.b(this.mbC).aCc())
    {
      MassSendHistoryUI.d(this.mbC).setSelectionFromTop(0, MassSendHistoryUI.c(this.mbC).getTopHeight());
      return true;
    }
    c localc = MassSendHistoryUI.b(this.mbC);
    if (localc.aCc()) {}
    for (;;)
    {
      y.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:" + i);
      MassSendHistoryUI.b(this.mbC).a(null, null);
      MassSendHistoryUI.d(this.mbC).setSelectionFromTop(i, MassSendHistoryUI.c(this.mbC).getTopHeight());
      return true;
      localc.iwi += 10;
      if (localc.iwi <= localc.dsw)
      {
        i = 10;
      }
      else
      {
        localc.iwi = localc.dsw;
        i = localc.dsw % 10;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.5
 * JD-Core Version:    0.7.0.1
 */