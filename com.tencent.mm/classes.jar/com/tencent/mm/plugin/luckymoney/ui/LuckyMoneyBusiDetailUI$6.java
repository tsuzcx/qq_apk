package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.ui.k;

final class LuckyMoneyBusiDetailUI$6
  extends k
{
  LuckyMoneyBusiDetailUI$6(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, q paramq) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(284079);
    h.OAn.b(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.ZY(this.KAd.Ksf)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.KAb.getContext(), LuckyMoneyMyRecordUI.class);
    ((Intent)localObject).putExtra("key_type", 2);
    paramView = this.KAb;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "onRealClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(284079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.6
 * JD-Core Version:    0.7.0.1
 */