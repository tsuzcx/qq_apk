package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class HoneyPayReceiveCardUI$2
  implements View.OnClickListener
{
  HoneyPayReceiveCardUI$2(HoneyPayReceiveCardUI paramHoneyPayReceiveCardUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64825);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayReceiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    HoneyPayReceiveCardUI.a(this.uHJ);
    a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayReceiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.2
 * JD-Core Version:    0.7.0.1
 */