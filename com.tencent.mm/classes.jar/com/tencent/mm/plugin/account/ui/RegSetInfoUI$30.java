package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

final class RegSetInfoUI$30
  implements View.OnFocusChangeListener
{
  RegSetInfoUI$30(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(128696);
    if (paramBoolean)
    {
      RegSetInfoUI.q(this.njA);
      RegSetInfoUI.m(this.njA).startTimer(200L);
    }
    AppMethodBeat.o(128696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.30
 * JD-Core Version:    0.7.0.1
 */