package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class CardTicketListUI$h
  implements MenuItem.OnMenuItemClickListener
{
  CardTicketListUI$h(CardTicketListUI paramCardTicketListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(192687);
    paramMenuItem = new e((Context)this.nFX.getContext(), 1, false);
    paramMenuItem.a((n.c)new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(192685);
        paramAnonymousl.add(0, 0, 1, (CharSequence)this.nGc.nFX.getString(2131764414));
        AppMethodBeat.o(192685);
      }
    });
    paramMenuItem.a((n.d)new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(192686);
        k.g(paramAnonymousMenuItem, "menuItem");
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          ad.i("MicroMsg.CardTicketListUI", "click history wording");
          Object localObject = new Intent((Context)this.nGc.nFX, CardInvalidTicketListUI.class);
          paramAnonymousMenuItem = this.nGc.nFX;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$updateTextMenu$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$updateTextMenu$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          h.vKh.f(16322, new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(192686);
      }
    });
    paramMenuItem.csG();
    AppMethodBeat.o(192687);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.h
 * JD-Core Version:    0.7.0.1
 */