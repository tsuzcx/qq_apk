package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class CardHomePageUI$6
  implements View.OnClickListener
{
  CardHomePageUI$6(CardHomePageUI paramCardHomePageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113415);
    Object localObject = new Intent(this.oey, CardIndexUI.class);
    ((Intent)localObject).putExtra("key_card_type", 1);
    paramView = this.oey;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/card/ui/CardHomePageUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.wUl.f(11324, new Object[] { "GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(113415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.6
 * JD-Core Version:    0.7.0.1
 */