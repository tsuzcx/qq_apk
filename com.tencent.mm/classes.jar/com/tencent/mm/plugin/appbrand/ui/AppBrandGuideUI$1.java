package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandGuideUI$1
  implements DialogInterface.OnDismissListener
{
  AppBrandGuideUI$1(AppBrandGuideUI paramAppBrandGuideUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(132955);
    this.iMz.finish();
    AppMethodBeat.o(132955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.1
 * JD-Core Version:    0.7.0.1
 */