package com.tencent.mm.plugin.account.ui;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MobileVerifyUI$1$1
  implements Runnable
{
  MobileVerifyUI$1$1(MobileVerifyUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(125268);
    MobileVerifyUI.b(this.gHq.gHp);
    if (MobileVerifyUI.c(this.gHq.gHp) >= 0L)
    {
      this.gHq.gHp.gGZ.setText(this.gHq.gHp.getResources().getQuantityString(2131361811, (int)MobileVerifyUI.c(this.gHq.gHp), new Object[] { Integer.valueOf((int)MobileVerifyUI.c(this.gHq.gHp)) }));
      AppMethodBeat.o(125268);
      return;
    }
    this.gHq.gHp.gGZ.setVisibility(8);
    this.gHq.gHp.gGY.setVisibility(0);
    MobileVerifyUI.d(this.gHq.gHp);
    this.gHq.gHp.gGY.setEnabled(true);
    this.gHq.gHp.gGY.setText(this.gHq.gHp.getString(2131301600));
    AppMethodBeat.o(125268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.1.1
 * JD-Core Version:    0.7.0.1
 */