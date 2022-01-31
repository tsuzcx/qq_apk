package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;

final class AppBrandIDCardUI$1$2
  implements DialogInterface.OnClickListener
{
  AppBrandIDCardUI$1$2(AppBrandIDCardUI.1 param1, int paramInt, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("intent_err_code", bk.e(Integer.valueOf(this.bEg), 0));
    paramDialogInterface.putExtra("intent_err_msg", bk.pm(this.edL));
    this.hfl.hfk.setResult(1, paramDialogInterface);
    this.hfl.hfk.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.2
 * JD-Core Version:    0.7.0.1
 */