package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class HoneyPayMainUI$1
  implements View.OnClickListener
{
  HoneyPayMainUI$1(HoneyPayMainUI paramHoneyPayMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41882);
    ab.d(this.nJe.TAG, "click add friend");
    HoneyPayMainUI.a(this.nJe);
    AppMethodBeat.o(41882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.1
 * JD-Core Version:    0.7.0.1
 */