package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.i;

public final class d$2
  implements DialogInterface.OnShowListener
{
  public d$2(i parami) {}
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(143591);
    if (this.iMU.getWindow() != null) {
      this.iMU.getWindow().setDimAmount(0.0F);
    }
    AppMethodBeat.o(143591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d.2
 * JD-Core Version:    0.7.0.1
 */