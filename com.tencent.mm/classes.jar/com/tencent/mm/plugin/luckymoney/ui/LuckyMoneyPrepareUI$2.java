package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LuckyMoneyPrepareUI$2
  implements View.OnTouchListener
{
  LuckyMoneyPrepareUI$2(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65828);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (paramMotionEvent.getAction() == 0)
    {
      this.vAO.hideTenpayKB();
      this.vAO.hideVKB();
    }
    a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(65828);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.2
 * JD-Core Version:    0.7.0.1
 */