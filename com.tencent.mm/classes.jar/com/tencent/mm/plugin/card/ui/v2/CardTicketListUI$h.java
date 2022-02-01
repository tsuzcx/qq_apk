package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class CardTicketListUI$h
  implements MenuItem.OnMenuItemClickListener
{
  CardTicketListUI$h(CardTicketListUI paramCardTicketListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(215457);
    paramMenuItem = new e((Context)this.oMu.getContext(), 1, false);
    paramMenuItem.a((n.d)new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(215455);
        paramAnonymousl.add(0, 0, 1, (CharSequence)this.oMz.oMu.getString(2131764414));
        AppMethodBeat.o(215455);
      }
    });
    paramMenuItem.a((n.e)new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(215456);
        p.g(paramAnonymousMenuItem, "menuItem");
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          ad.i("MicroMsg.CardTicketListUI", "click history wording");
          Object localObject = new Intent((Context)this.oMz.oMu, CardInvalidTicketListUI.class);
          paramAnonymousMenuItem = this.oMz.oMu;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$updateTextMenu$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$updateTextMenu$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          g.yhR.f(16322, new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(215456);
      }
    });
    paramMenuItem.cMW();
    AppMethodBeat.o(215457);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.h
 * JD-Core Version:    0.7.0.1
 */