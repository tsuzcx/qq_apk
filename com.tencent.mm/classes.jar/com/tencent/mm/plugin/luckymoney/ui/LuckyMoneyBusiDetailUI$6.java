package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.report.service.g;

final class LuckyMoneyBusiDetailUI$6
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$6(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65455);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    g.yxI.f(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.JO(this.vHv.vAB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    localObject = new Intent();
    ((Intent)localObject).setClass(this.vHt.getContext(), LuckyMoneyMyRecordUI.class);
    ((Intent)localObject).putExtra("key_type", 2);
    paramView = this.vHt;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.6
 * JD-Core Version:    0.7.0.1
 */