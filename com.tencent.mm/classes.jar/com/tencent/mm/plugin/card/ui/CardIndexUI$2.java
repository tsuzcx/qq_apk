package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.protocal.protobuf.wk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class CardIndexUI$2
  implements View.OnClickListener
{
  CardIndexUI$2(CardIndexUI paramCardIndexUI, wk paramwk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113449);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.CardIndexUI", "click header view: %s", new Object[] { Integer.valueOf(this.wCN.Zds) });
    if (this.wCN.Zds == 1) {
      com.tencent.mm.plugin.card.c.b.a(this.wCM, this.wCN.Zdt, 0);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113449);
      return;
      if (this.wCN.Zds == 2)
      {
        paramView = new zp();
        paramView.icM.userName = this.wCN.Zdu.VcU;
        paramView.icM.icO = Util.nullAs(this.wCN.Zdu.VcV, "");
        paramView.icM.scene = 1028;
        paramView.publish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI.2
 * JD-Core Version:    0.7.0.1
 */