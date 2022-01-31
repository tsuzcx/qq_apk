package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class RegByMobileRegAIOUI$23
  implements View.OnTouchListener
{
  RegByMobileRegAIOUI$23(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, boolean[] paramArrayOfBoolean) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152604);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152604);
      return false;
      this.gFg[0] = true;
      b.pgQ.fD("ce_reg", "<Reg>");
      continue;
      b.pgQ.a("ce_reg", paramMotionEvent);
      b.pgQ.Wa("ce_reg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.23
 * JD-Core Version:    0.7.0.1
 */