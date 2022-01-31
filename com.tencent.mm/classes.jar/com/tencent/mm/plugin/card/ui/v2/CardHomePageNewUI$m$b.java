package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.ui.base.n.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2"})
final class CardHomePageNewUI$m$b
  implements n.d
{
  CardHomePageNewUI$m$b(CardHomePageNewUI.a parama, CardHomePageNewUI.m paramm, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(89225);
    j.p(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89225);
      return;
      com.tencent.mm.ui.base.h.a((Context)this.kzY.kzs.getContext(), this.kzY.kzs.getString(2131297956), "", false, (DialogInterface.OnClickListener)new CardHomePageNewUI.m.b.1(this));
      paramMenuItem = com.tencent.mm.plugin.report.service.h.qsU;
      on localon = this.kzZ.kzm;
      if (localon == null) {
        j.ebi();
      }
      paramMenuItem.e(16324, new Object[] { Integer.valueOf(2), localon.wEJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(8), Integer.valueOf(this.iWi), Integer.valueOf(CardHomePageNewUI.l(this.kzY.kzs)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.m.b
 * JD-Core Version:    0.7.0.1
 */