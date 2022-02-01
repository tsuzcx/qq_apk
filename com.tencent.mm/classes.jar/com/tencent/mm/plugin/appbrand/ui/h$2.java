package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.i;

public final class h$2
  implements DialogInterface.OnShowListener
{
  public h$2(i parami) {}
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(48655);
    if (this.mHe.getWindow() != null) {
      this.mHe.getWindow().setDimAmount(0.0F);
    }
    AppMethodBeat.o(48655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h.2
 * JD-Core Version:    0.7.0.1
 */