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
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class LuckyMoneyBusiReceiveUI$7
  implements View.OnClickListener
{
  LuckyMoneyBusiReceiveUI$7(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI, ak paramak) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65491);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    LuckyMoneyBusiReceiveUI.k(this.zcJ).setVisibility(4);
    LuckyMoneyBusiReceiveUI.l(this.zcJ).setVisibility(8);
    LuckyMoneyBusiReceiveUI.m(this.zcJ).setVisibility(8);
    if ((this.zcL.yVq != null) && (!Util.isNullOrNil(this.zcL.yVq.yUH))) {}
    for (paramView = this.zcL.yVq.yUH;; paramView = this.zcJ.getString(2131762740))
    {
      LuckyMoneyBusiReceiveUI.n(this.zcJ).setText(paramView);
      LuckyMoneyBusiReceiveUI.o(this.zcJ).setText(this.zcL.yWM);
      LuckyMoneyBusiReceiveUI.p(this.zcJ).setVisibility(0);
      LuckyMoneyBusiReceiveUI.n(this.zcJ).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65489);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          h.CyF.a(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
          af.a(LuckyMoneyBusiReceiveUI.7.this.zcJ, 1, false);
          a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65489);
        }
      });
      af.a(LuckyMoneyBusiReceiveUI.k(this.zcJ), new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(65490);
          LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.7.this.zcJ).setVisibility(0);
          AppMethodBeat.o(65490);
        }
      });
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(65491);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.7
 * JD-Core Version:    0.7.0.1
 */