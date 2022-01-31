package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class CardIndexUI$2
  implements View.OnClickListener
{
  CardIndexUI$2(CardIndexUI paramCardIndexUI, oy paramoy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88522);
    ab.i("MicroMsg.CardIndexUI", "click header view: %s", new Object[] { Integer.valueOf(this.kwq.wFH) });
    if (this.kwq.wFH == 1)
    {
      b.a(this.kwp, this.kwq.wFI, 0);
      AppMethodBeat.o(88522);
      return;
    }
    if (this.kwq.wFH == 2)
    {
      paramView = new so();
      paramView.cIQ.userName = this.kwq.wFJ.ugl;
      paramView.cIQ.cIS = bo.bf(this.kwq.wFJ.uaL, "");
      paramView.cIQ.scene = 1028;
      a.ymk.l(paramView);
    }
    AppMethodBeat.o(88522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI.2
 * JD-Core Version:    0.7.0.1
 */