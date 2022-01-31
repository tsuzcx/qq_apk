package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiSuccUI$1
  implements View.OnClickListener
{
  FreeWifiSuccUI$1(FreeWifiSuccUI paramFreeWifiSuccUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21085);
    this.mOM.finish();
    FreeWifiSuccUI.a(this.mOM);
    AppMethodBeat.o(21085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.1
 * JD-Core Version:    0.7.0.1
 */