package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;

final class RegByMobileRegAIOUI$22
  implements View.OnFocusChangeListener
{
  RegByMobileRegAIOUI$22(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, boolean[] paramArrayOfBoolean) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(128534);
    if (paramBoolean)
    {
      this.nij[0] = true;
      AppMethodBeat.o(128534);
      return;
    }
    d.GxJ.aTj("ie_reg");
    AppMethodBeat.o(128534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.22
 * JD-Core Version:    0.7.0.1
 */