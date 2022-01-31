package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.r.a;

final class MassSendHistoryUI$8
  implements r.a
{
  MassSendHistoryUI$8(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final void Wp()
  {
    MassSendHistoryUI.c(this.mbC).setIsTopShowAll(MassSendHistoryUI.b(this.mbC).aCc());
    if (MassSendHistoryUI.b(this.mbC).getCount() == 0)
    {
      MassSendHistoryUI.c(this.mbC).setVisibility(8);
      MassSendHistoryUI.e(this.mbC).setVisibility(0);
      MassSendHistoryUI.f(this.mbC).setVisibility(8);
      return;
    }
    MassSendHistoryUI.c(this.mbC).setVisibility(0);
    MassSendHistoryUI.e(this.mbC).setVisibility(8);
    MassSendHistoryUI.f(this.mbC).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.8
 * JD-Core Version:    0.7.0.1
 */