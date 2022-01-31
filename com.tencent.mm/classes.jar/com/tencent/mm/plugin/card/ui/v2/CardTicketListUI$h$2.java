package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.ui.base.n.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
final class CardTicketListUI$h$2
  implements n.d
{
  CardTicketListUI$h$2(CardTicketListUI.h paramh, bkj parambkj) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(89307);
    j.p(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89307);
      return;
      if (this.kAG != null)
      {
        com.tencent.mm.ui.base.h.a((Context)this.kAF.kAE.getContext(), this.kAF.kAE.getString(2131297956), "", this.kAF.kAE.getString(2131297018), this.kAF.kAE.getString(2131296888), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89305);
            Object localObject1 = this.kAH.kAF.kAE;
            Object localObject2 = this.kAH.kAG;
            if (localObject2 == null) {
              j.ebi();
            }
            localObject2 = ((bkj)localObject2).wmm;
            j.p(localObject2, "ticketElement!!.user_card_id");
            CardTicketListUI.b((CardTicketListUI)localObject1, (String)localObject2);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = com.tencent.mm.plugin.report.service.h.qsU;
            localObject1 = this.kAH.kAG;
            if (localObject1 == null) {
              j.ebi();
            }
            paramAnonymousInt = ((bkj)localObject1).xyT;
            localObject1 = this.kAH.kAG;
            if (localObject1 == null) {
              j.ebi();
            }
            localObject1 = ((bkj)localObject1).wmm;
            localObject2 = CardTicketListUI.b(this.kAH.kAF.kAE);
            Object localObject3 = this.kAH.kAG;
            if (localObject3 == null) {
              j.ebi();
            }
            localObject3 = ((bkj)localObject3).wmm;
            j.p(localObject3, "ticketElement!!.user_card_id");
            bkj localbkj = this.kAH.kAG;
            if (localbkj == null) {
              j.ebi();
            }
            paramAnonymousDialogInterface.e(16326, new Object[] { Integer.valueOf(paramAnonymousInt), localObject1, Integer.valueOf(((c)localObject2).bP((String)localObject3, localbkj.xyT)), Integer.valueOf(4) });
            AppMethodBeat.o(89305);
          }
        }, (DialogInterface.OnClickListener)2.kAI);
        paramMenuItem = com.tencent.mm.plugin.report.service.h.qsU;
        Object localObject1 = this.kAG;
        if (localObject1 == null) {
          j.ebi();
        }
        paramInt = ((bkj)localObject1).xyT;
        localObject1 = this.kAG;
        if (localObject1 == null) {
          j.ebi();
        }
        localObject1 = ((bkj)localObject1).wmm;
        c localc = CardTicketListUI.b(this.kAF.kAE);
        Object localObject2 = this.kAG;
        if (localObject2 == null) {
          j.ebi();
        }
        localObject2 = ((bkj)localObject2).wmm;
        j.p(localObject2, "ticketElement!!.user_card_id");
        bkj localbkj = this.kAG;
        if (localbkj == null) {
          j.ebi();
        }
        paramMenuItem.e(16326, new Object[] { Integer.valueOf(paramInt), localObject1, Integer.valueOf(localc.bP((String)localObject2, localbkj.xyT)), Integer.valueOf(3) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.h.2
 * JD-Core Version:    0.7.0.1
 */