package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

final class RegByMobileRegAIOUI$23
  implements View.OnTouchListener
{
  RegByMobileRegAIOUI$23(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, boolean[] paramArrayOfBoolean) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(128537);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(128537);
      return false;
      this.jlX[0] = true;
      com.tencent.mm.plugin.normsg.a.b.wtJ.io("ce_reg", "<Reg>");
      continue;
      com.tencent.mm.plugin.normsg.a.b.wtJ.a("ce_reg", paramMotionEvent);
      com.tencent.mm.plugin.normsg.a.b.wtJ.atu("ce_reg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.23
 * JD-Core Version:    0.7.0.1
 */