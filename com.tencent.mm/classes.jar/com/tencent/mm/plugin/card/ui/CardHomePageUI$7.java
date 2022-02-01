package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;

final class CardHomePageUI$7
  implements View.OnClickListener
{
  CardHomePageUI$7(CardHomePageUI paramCardHomePageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113416);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardHomePageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    localObject = new Intent(this.oOu, CardIndexUI.class);
    ((Intent)localObject).putExtra("key_card_type", 3);
    paramView = this.oOu;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/card/ui/CardHomePageUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/card/ui/CardHomePageUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    g.yxI.f(11324, new Object[] { "ClickTicketCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardHomePageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(113416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.7
 * JD-Core Version:    0.7.0.1
 */