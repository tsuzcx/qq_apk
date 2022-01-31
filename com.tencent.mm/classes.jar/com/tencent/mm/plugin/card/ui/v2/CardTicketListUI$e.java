package com.tencent.mm.plugin.card.ui.v2;

import a.l;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CardTicketListUI$e
  implements View.OnClickListener
{
  CardTicketListUI$e(CardTicketListUI paramCardTicketListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(89301);
    ab.i("MicroMsg.CardTicketListUI", "click history wording");
    paramView = new Intent((Context)this.kAE, CardInvalidTicketListUI.class);
    this.kAE.startActivity(paramView);
    h.qsU.e(16322, new Object[] { Integer.valueOf(8) });
    AppMethodBeat.o(89301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.e
 * JD-Core Version:    0.7.0.1
 */