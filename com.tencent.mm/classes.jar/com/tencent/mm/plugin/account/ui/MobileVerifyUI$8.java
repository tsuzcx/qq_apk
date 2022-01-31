package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.l;

final class MobileVerifyUI$8
  implements View.OnClickListener
{
  private final int gHr = 0;
  private final int gHs = 1;
  private final int gHt = 2;
  
  MobileVerifyUI$8(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125275);
    paramView = new l(this.gHp);
    paramView.sao = new MobileVerifyUI.8.1(this);
    paramView.sap = new MobileVerifyUI.8.2(this);
    paramView.cwt();
    AppMethodBeat.o(125275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.8
 * JD-Core Version:    0.7.0.1
 */