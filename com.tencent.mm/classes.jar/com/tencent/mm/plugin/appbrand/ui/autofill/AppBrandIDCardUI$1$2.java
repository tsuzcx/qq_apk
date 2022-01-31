package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandIDCardUI$1$2
  implements DialogInterface.OnClickListener
{
  AppBrandIDCardUI$1$2(AppBrandIDCardUI.1 param1, int paramInt, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(133216);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("intent_err_code", bo.f(Integer.valueOf(this.val$errCode), 0));
    paramDialogInterface.putExtra("intent_err_msg", bo.nullAsNil(this.ftO));
    this.iQA.iQz.setResult(1, paramDialogInterface);
    this.iQA.iQz.finish();
    AppMethodBeat.o(133216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.2
 * JD-Core Version:    0.7.0.1
 */