package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class CardIndexUI$2
  implements View.OnClickListener
{
  CardIndexUI$2(CardIndexUI paramCardIndexUI, ur paramur) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113449);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.CardIndexUI", "click header view: %s", new Object[] { Integer.valueOf(this.qct.Lek) });
    if (this.qct.Lek == 1) {
      com.tencent.mm.plugin.card.d.b.a(this.qcs, this.qct.Lel, 0);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113449);
      return;
      if (this.qct.Lek == 2)
      {
        paramView = new wq();
        paramView.ecI.userName = this.qct.Lem.Hwr;
        paramView.ecI.ecK = Util.nullAs(this.qct.Lem.Hws, "");
        paramView.ecI.scene = 1028;
        EventCenter.instance.publish(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI.2
 * JD-Core Version:    0.7.0.1
 */