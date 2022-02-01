package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class CardTicketListUI$l
  implements MenuItem.OnMenuItemClickListener
{
  CardTicketListUI$l(CardTicketListUI paramCardTicketListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(201410);
    paramMenuItem = new e((Context)this.qgN.getContext(), 1, false);
    paramMenuItem.a((o.f)new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(201408);
        paramAnonymousm.add(0, 0, 1, (CharSequence)this.qgP.qgN.getString(2131766757));
        AppMethodBeat.o(201408);
      }
    });
    paramMenuItem.a((o.g)new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(201409);
        p.g(paramAnonymousMenuItem, "menuItem");
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          Log.i("MicroMsg.CardTicketListUI", "click history wording");
          Object localObject = new Intent((Context)this.qgP.qgN, CardInvalidTicketListUI.class);
          paramAnonymousMenuItem = this.qgP.qgN;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$updateTextMenu$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$updateTextMenu$1$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          h.CyF.a(16322, new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(201409);
      }
    });
    paramMenuItem.dGm();
    AppMethodBeat.o(201410);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.l
 * JD-Core Version:    0.7.0.1
 */