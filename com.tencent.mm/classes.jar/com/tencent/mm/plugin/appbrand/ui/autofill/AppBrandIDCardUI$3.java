package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandIDCardUI$3
  implements DialogInterface.OnCancelListener
{
  AppBrandIDCardUI$3(AppBrandIDCardUI paramAppBrandIDCardUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(133237);
    this.iQz.setResult(0);
    this.iQz.finish();
    AppMethodBeat.o(133237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.3
 * JD-Core Version:    0.7.0.1
 */