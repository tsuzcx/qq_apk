package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.d;

final class LuckyMoneyDetailUI$13
  implements View.OnClickListener
{
  LuckyMoneyDetailUI$13(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42662);
    LuckyMoneyDetailUI.a(this.otz, new aa());
    if (bo.hl(paramView.getId(), 2131825640))
    {
      LuckyMoneyDetailUI.w(this.otz).cRI = 1L;
      LuckyMoneyDetailUI.w(this.otz).ake();
    }
    if ((bo.hl(this.otz.ota.onU, 0)) && (bo.z(paramView.getTag(), "nodelete")))
    {
      LuckyMoneyDetailUI.C(this.otz);
      AppMethodBeat.o(42662);
      return;
    }
    d locald = new d(this.otz.getContext(), 1, false);
    locald.sao = new LuckyMoneyDetailUI.13.1(this, paramView);
    locald.sap = new LuckyMoneyDetailUI.13.2(this);
    LuckyMoneyDetailUI.w(this.otz).cRI = 2L;
    LuckyMoneyDetailUI.w(this.otz).ake();
    locald.crd();
    AppMethodBeat.o(42662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.13
 * JD-Core Version:    0.7.0.1
 */