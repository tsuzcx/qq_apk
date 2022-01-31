package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.tools.b.c;

final class RegByMobileRegAIOUI$2
  implements View.OnClickListener
{
  RegByMobileRegAIOUI$2(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, boolean[] paramArrayOfBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152583);
    if (this.gFg[0] != 0) {
      this.gFg[0] = false;
    }
    while (!RegByMobileRegAIOUI.c(this.gIh).isChecked())
    {
      paramView = AnimationUtils.loadAnimation(this.gIh, 2131034133);
      RegByMobileRegAIOUI.d(this.gIh).startAnimation(paramView);
      AppMethodBeat.o(152583);
      return;
      b.pgQ.fD("ce_reg", "<Reg>");
      paramView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
      b.pgQ.a("ce_reg", paramView);
      b.pgQ.Wa("ce_reg");
    }
    paramView = c.d(RegByMobileRegAIOUI.m(this.gIh).getContentEditText()).hR(1, 32);
    paramView.AyD = true;
    paramView.a(new RegByMobileRegAIOUI.2.1(this));
    AppMethodBeat.o(152583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.2
 * JD-Core Version:    0.7.0.1
 */