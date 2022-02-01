package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class RegByMobileRegAIOUI$20
  implements View.OnFocusChangeListener
{
  RegByMobileRegAIOUI$20(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, boolean[] paramArrayOfBoolean) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(128534);
    if (paramBoolean)
    {
      this.jpo[0] = true;
      AppMethodBeat.o(128534);
      return;
    }
    b.wtJ.atr("ie_reg");
    AppMethodBeat.o(128534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.20
 * JD-Core Version:    0.7.0.1
 */