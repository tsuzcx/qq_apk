package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
final class aa$l
  implements DialogInterface.OnDismissListener
{
  aa$l(aa paramaa) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(148185);
    ad.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
    aa.d(this.lmf);
    aa.e(this.lmf);
    AppMethodBeat.o(148185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa.l
 * JD-Core Version:    0.7.0.1
 */