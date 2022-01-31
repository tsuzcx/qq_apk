package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class MobileInputUI$9
  implements View.OnTouchListener
{
  MobileInputUI$9(MobileInputUI paramMobileInputUI, boolean[] paramArrayOfBoolean) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(125169);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125169);
      return false;
      this.gFg[0] = true;
      if (MobileInputUI.e(this.gGb)) {
        b.pgQ.fD("ce_reg_eu", "<Reg>");
      }
      if (MobileInputUI.f(this.gGb))
      {
        b.pgQ.fD("ce_login", "<Login>");
        continue;
        if (MobileInputUI.e(this.gGb))
        {
          b.pgQ.a("ce_reg_eu", paramMotionEvent);
          b.pgQ.Wa("ce_reg_eu");
        }
        if (MobileInputUI.f(this.gGb))
        {
          b.pgQ.a("ce_login", paramMotionEvent);
          b.pgQ.Wa("ce_login");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.9
 * JD-Core Version:    0.7.0.1
 */