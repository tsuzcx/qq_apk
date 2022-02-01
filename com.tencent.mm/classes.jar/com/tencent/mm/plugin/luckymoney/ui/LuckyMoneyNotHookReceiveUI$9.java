package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.wallet_core.ui.g;

final class LuckyMoneyNotHookReceiveUI$9
  implements View.OnClickListener
{
  LuckyMoneyNotHookReceiveUI$9(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI, cdu paramcdu) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(271296);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    g.bA(this.ELl.getContext(), this.ELq.url);
    h.IzE.a(22105, new Object[] { Integer.valueOf(3), Integer.valueOf(0), this.ELq.TlD });
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNotHookReceiveUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(271296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.9
 * JD-Core Version:    0.7.0.1
 */