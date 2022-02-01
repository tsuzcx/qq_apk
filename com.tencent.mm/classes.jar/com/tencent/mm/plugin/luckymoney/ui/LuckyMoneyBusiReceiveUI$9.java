package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;

final class LuckyMoneyBusiReceiveUI$9
  implements View.OnClickListener
{
  LuckyMoneyBusiReceiveUI$9(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI, al paramal) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65492);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    LuckyMoneyBusiReceiveUI.k(this.EHj).setVisibility(4);
    LuckyMoneyBusiReceiveUI.l(this.EHj).setVisibility(8);
    LuckyMoneyBusiReceiveUI.m(this.EHj).setVisibility(8);
    if ((this.EHl.Ezn != null) && (!Util.isNullOrNil(this.EHl.Ezn.EyE))) {}
    for (paramView = this.EHl.Ezn.EyE;; paramView = this.EHj.getString(a.i.lucky_money_share_friends_tips))
    {
      LuckyMoneyBusiReceiveUI.n(this.EHj).setText(paramView);
      LuckyMoneyBusiReceiveUI.o(this.EHj).setText(this.EHl.EAQ);
      LuckyMoneyBusiReceiveUI.p(this.EHj).setVisibility(0);
      LuckyMoneyBusiReceiveUI.n(this.EHj).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(275845);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          h.IzE.a(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
          ag.a(LuckyMoneyBusiReceiveUI.9.this.EHj, 1, false);
          a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(275845);
        }
      });
      ag.a(LuckyMoneyBusiReceiveUI.k(this.EHj), new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(258008);
          LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.9.this.EHj).setVisibility(0);
          AppMethodBeat.o(258008);
        }
      });
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(65492);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.9
 * JD-Core Version:    0.7.0.1
 */