package com.tencent.mm.plugin.luckymoney.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class LuckyMoneyDetailUI$13$1
  implements n.c
{
  LuckyMoneyDetailUI$13$1(LuckyMoneyDetailUI.13 param13, View paramView) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(42660);
    String str = this.otB.otz.getString(2131301307);
    if (!bo.hl(this.otB.otz.ota.onU, 0)) {
      paraml.hx(1, 2131301266);
    }
    for (;;)
    {
      paraml.e(2, str);
      if (!bo.z(this.bTJ.getTag(), "nodelete")) {
        paraml.a(3, this.otB.otz.getResources().getColor(2131690256), this.otB.otz.getContext().getString(2131301209));
      }
      AppMethodBeat.o(42660);
      return;
      str = this.otB.otz.getString(2131301216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.13.1
 * JD-Core Version:    0.7.0.1
 */