package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$2"})
final class CardHomePageNewUI$q
  implements n.d
{
  CardHomePageNewUI$q(CardHomePageNewUI paramCardHomePageNewUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(152211);
    j.p(paramMenuItem, "menuItem");
    paramInt = paramMenuItem.getItemId();
    ab.i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.l(this.kzs)) });
    paramMenuItem = CardHomePageNewUI.x(this.kzs).get(paramInt);
    j.p(paramMenuItem, "cardSortInfoList[itemId]");
    paramMenuItem = (pc)paramMenuItem;
    CardHomePageNewUI.d(this.kzs, paramMenuItem.wvk);
    if ((paramMenuItem.wFN == 1) && (CardHomePageNewUI.l(this.kzs) != 1))
    {
      if (!this.kzs.kAo)
      {
        com.tencent.mm.ui.base.h.a((Context)this.kzs.getContext(), this.kzs.getString(2131297951), this.kzs.getString(2131302083), this.kzs.getString(2131300996), this.kzs.getString(2131298499), false, (DialogInterface.OnClickListener)new CardHomePageNewUI.q.1(this), null);
        AppMethodBeat.o(152211);
        return;
      }
      CardHomePageNewUI.b(this.kzs, true);
      CardHomePageNewUI.c(this.kzs, 0);
      CardHomePageNewUI.b(this.kzs, 1);
      CardHomePageNewUI.q(this.kzs);
      com.tencent.mm.plugin.report.service.h.qsU.e(16322, new Object[] { Integer.valueOf(15) });
      AppMethodBeat.o(152211);
      return;
    }
    if ((paramMenuItem.wFN == 2) && (CardHomePageNewUI.l(this.kzs) != 2))
    {
      CardHomePageNewUI.b(this.kzs, true);
      CardHomePageNewUI.c(this.kzs, 0);
      CardHomePageNewUI.b(this.kzs, 2);
      CardHomePageNewUI.q(this.kzs);
      com.tencent.mm.plugin.report.service.h.qsU.e(16322, new Object[] { Integer.valueOf(16) });
      AppMethodBeat.o(152211);
      return;
    }
    if ((paramMenuItem.wFN == 3) && (CardHomePageNewUI.l(this.kzs) != 3))
    {
      CardHomePageNewUI.b(this.kzs, true);
      CardHomePageNewUI.c(this.kzs, 0);
      CardHomePageNewUI.b(this.kzs, 3);
      CardHomePageNewUI.q(this.kzs);
      com.tencent.mm.plugin.report.service.h.qsU.e(16322, new Object[] { Integer.valueOf(17) });
    }
    AppMethodBeat.o(152211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.q
 * JD-Core Version:    0.7.0.1
 */