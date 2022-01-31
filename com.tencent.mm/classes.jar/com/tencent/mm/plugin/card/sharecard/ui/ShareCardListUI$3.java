package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.report.service.h;

final class ShareCardListUI$3
  implements View.OnClickListener
{
  ShareCardListUI$3(ShareCardListUI paramShareCardListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88167);
    ShareCardListUI.c(this.krQ);
    if (b.bcD())
    {
      ShareCardListUI.c(this.krQ);
      if (b.bcC()) {
        ShareCardListUI.a(this.krQ, 2);
      }
    }
    for (;;)
    {
      h.qsU.e(11582, new Object[] { "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "" });
      am.bci().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(this.krQ)));
      ShareCardListUI.e(this.krQ);
      ShareCardListUI.f(this.krQ).bJ();
      ShareCardListUI.c(this.krQ);
      b.kpI = true;
      AppMethodBeat.o(88167);
      return;
      ShareCardListUI.c(this.krQ);
      if (b.bcC()) {
        ShareCardListUI.a(this.krQ, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI.3
 * JD-Core Version:    0.7.0.1
 */