package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class CardTicketListUI$h
  implements MenuItem.OnMenuItemClickListener
{
  CardTicketListUI$h(CardTicketListUI paramCardTicketListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(206261);
    paramMenuItem = new e((Context)this.oiY.getContext(), 1, false);
    paramMenuItem.a((n.c)new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(206259);
        paramAnonymousl.add(0, 0, 1, (CharSequence)this.ojd.oiY.getString(2131764414));
        AppMethodBeat.o(206259);
      }
    });
    paramMenuItem.a((n.d)new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(206260);
        k.g(paramAnonymousMenuItem, "menuItem");
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          ac.i("MicroMsg.CardTicketListUI", "click history wording");
          Object localObject = new Intent((Context)this.ojd.oiY, CardInvalidTicketListUI.class);
          paramAnonymousMenuItem = this.ojd.oiY;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$updateTextMenu$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$updateTextMenu$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          h.wUl.f(16322, new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(206260);
      }
    });
    paramMenuItem.cED();
    AppMethodBeat.o(206261);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.h
 * JD-Core Version:    0.7.0.1
 */