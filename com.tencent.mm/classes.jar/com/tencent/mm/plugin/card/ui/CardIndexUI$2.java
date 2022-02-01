package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class CardIndexUI$2
  implements View.OnClickListener
{
  CardIndexUI$2(CardIndexUI paramCardIndexUI, tm paramtm) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113449);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.CardIndexUI", "click header view: %s", new Object[] { Integer.valueOf(this.oOF.GjF) });
    if (this.oOF.GjF == 1) {
      com.tencent.mm.plugin.card.d.b.a(this.oOE, this.oOF.GjG, 0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113449);
      return;
      if (this.oOF.GjF == 2)
      {
        paramView = new vq();
        paramView.dKT.userName = this.oOF.GjH.CRv;
        paramView.dKT.dKV = bu.bI(this.oOF.GjH.CRw, "");
        paramView.dKT.scene = 1028;
        com.tencent.mm.sdk.b.a.IvT.l(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI.2
 * JD-Core Version:    0.7.0.1
 */