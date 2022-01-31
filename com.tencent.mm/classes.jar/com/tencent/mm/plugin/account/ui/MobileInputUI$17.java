package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;

final class MobileInputUI$17
  implements View.OnClickListener
{
  MobileInputUI$17(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125177);
    paramView = this.gGb.getString(2131306168, new Object[] { aa.dsG() });
    MobileInputUI.S(this.gGb, paramView);
    AppMethodBeat.o(125177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.17
 * JD-Core Version:    0.7.0.1
 */