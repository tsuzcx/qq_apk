package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.base.o;

final class j$1
  implements View.OnClickListener
{
  j$1(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113548);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/card/ui/CardPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((paramView.getId() == 2131303350) || (paramView.getId() == 2131303346))
    {
      if ((this.oJA.jtC != null) && (this.oJA.jtC.isShowing())) {
        this.oJA.jtC.dismiss();
      }
      if (!this.oJA.owK.bTw()) {
        this.oJA.bXe();
      }
    }
    a.a(this, "com/tencent/mm/plugin/card/ui/CardPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(113548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j.1
 * JD-Core Version:    0.7.0.1
 */