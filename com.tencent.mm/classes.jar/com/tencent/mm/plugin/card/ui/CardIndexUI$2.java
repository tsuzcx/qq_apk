package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class CardIndexUI$2
  implements View.OnClickListener
{
  CardIndexUI$2(CardIndexUI paramCardIndexUI, ut paramut) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113449);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.CardIndexUI", "click header view: %s", new Object[] { Integer.valueOf(this.tyq.Sfx) });
    if (this.tyq.Sfx == 1) {
      com.tencent.mm.plugin.card.d.b.a(this.typ, this.tyq.Sfy, 0);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113449);
      return;
      if (this.tyq.Sfx == 2)
      {
        paramView = new xw();
        paramView.fWN.userName = this.tyq.Sfz.Ooe;
        paramView.fWN.fWP = Util.nullAs(this.tyq.Sfz.Oof, "");
        paramView.fWN.scene = 1028;
        EventCenter.instance.publish(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI.2
 * JD-Core Version:    0.7.0.1
 */