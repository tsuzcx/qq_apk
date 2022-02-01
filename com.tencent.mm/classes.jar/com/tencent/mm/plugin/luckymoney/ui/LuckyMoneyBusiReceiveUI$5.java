package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyBusiReceiveUI$5
  implements View.OnClickListener
{
  LuckyMoneyBusiReceiveUI$5(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65487);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    h.CyF.a(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    localObject = new Intent();
    ((Intent)localObject).setClass(this.zcJ.getContext(), LuckyMoneyBusiDetailUI.class);
    ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(this.zcJ));
    ((Intent)localObject).putExtra("key_sendid", LuckyMoneyBusiReceiveUI.h(this.zcJ).yQE);
    ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(this.zcJ));
    paramView = this.zcJ;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.zcJ.finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(65487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.5
 * JD-Core Version:    0.7.0.1
 */