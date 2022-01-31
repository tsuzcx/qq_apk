package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.report.service.h;

final class ShareCardListUI$3
  implements View.OnClickListener
{
  ShareCardListUI$3(ShareCardListUI paramShareCardListUI) {}
  
  public final void onClick(View paramView)
  {
    ShareCardListUI.c(this.iqI);
    if (b.aAS())
    {
      ShareCardListUI.c(this.iqI);
      if (b.aAR()) {
        ShareCardListUI.a(this.iqI, 2);
      }
    }
    for (;;)
    {
      h.nFQ.f(11582, new Object[] { "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "" });
      am.aAx().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(this.iqI)));
      ShareCardListUI.e(this.iqI);
      ShareCardListUI.f(this.iqI).aZ();
      ShareCardListUI.c(this.iqI);
      b.ioB = true;
      return;
      ShareCardListUI.c(this.iqI);
      if (b.aAR()) {
        ShareCardListUI.a(this.iqI, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI.3
 * JD-Core Version:    0.7.0.1
 */