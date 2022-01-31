package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

final class RegSetInfoUI$30
  implements View.OnFocusChangeListener
{
  RegSetInfoUI$30(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(125535);
    if (paramBoolean)
    {
      RegSetInfoUI.q(this.gJQ);
      RegSetInfoUI.m(this.gJQ).ag(200L, 200L);
    }
    AppMethodBeat.o(125535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.30
 * JD-Core Version:    0.7.0.1
 */