package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class AppBrandIDCardUI$1$7
  implements DialogInterface.OnClickListener
{
  AppBrandIDCardUI$1$7(AppBrandIDCardUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48928);
    ad.i("MicroMsg.AppBrandIDCardUI", "[showVerifySmsAlert] btn click");
    AppMethodBeat.o(48928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.7
 * JD-Core Version:    0.7.0.1
 */