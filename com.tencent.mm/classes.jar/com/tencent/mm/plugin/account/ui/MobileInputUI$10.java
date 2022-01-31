package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class MobileInputUI$10
  implements View.OnClickListener
{
  MobileInputUI$10(MobileInputUI paramMobileInputUI, boolean[] paramArrayOfBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125170);
    if (this.gFg[0] != 0) {
      this.gFg[0] = false;
    }
    for (;;)
    {
      MobileInputUI.g(this.gGb);
      AppMethodBeat.o(125170);
      return;
      if (MobileInputUI.e(this.gGb))
      {
        b.pgQ.fD("ce_reg_eu", "<Reg>");
        paramView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
        b.pgQ.a("ce_reg_eu", paramView);
        b.pgQ.Wa("ce_reg_eu");
      }
      if (MobileInputUI.f(this.gGb))
      {
        b.pgQ.fD("ce_login", "<Login>");
        paramView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
        b.pgQ.a("ce_login", paramView);
        b.pgQ.Wa("ce_login");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.10
 * JD-Core Version:    0.7.0.1
 */