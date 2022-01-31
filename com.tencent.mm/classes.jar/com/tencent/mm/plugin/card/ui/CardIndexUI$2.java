package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.protocal.c.lx;
import com.tencent.mm.protocal.c.ma;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class CardIndexUI$2
  implements View.OnClickListener
{
  CardIndexUI$2(CardIndexUI paramCardIndexUI, ma paramma) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.CardIndexUI", "click header view: %s", new Object[] { Integer.valueOf(this.ivm.sIa) });
    if (this.ivm.sIa == 1)
    {
      b.a(this.ivl, this.ivm.sIb, 0);
      return;
    }
    if (this.ivm.sIa == 2)
    {
      paramView = new rc();
      paramView.caq.userName = this.ivm.sIc.qhq;
      paramView.caq.cas = bk.aM(this.ivm.sIc.qhr, "");
      paramView.caq.scene = 1028;
      a.udP.m(paramView);
      return;
    }
    int i = this.ivm.sIa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI.2
 * JD-Core Version:    0.7.0.1
 */