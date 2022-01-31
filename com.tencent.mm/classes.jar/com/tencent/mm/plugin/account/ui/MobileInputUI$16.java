package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;

final class MobileInputUI$16
  implements View.OnClickListener
{
  MobileInputUI$16(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125176);
    paramView = this.gGb.getString(2131306187) + aa.dsG();
    MobileInputUI.S(this.gGb, paramView);
    AppMethodBeat.o(125176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.16
 * JD-Core Version:    0.7.0.1
 */