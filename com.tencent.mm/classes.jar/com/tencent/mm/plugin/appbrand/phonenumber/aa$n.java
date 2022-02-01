package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class aa$n
  implements DialogInterface.OnClickListener
{
  aa$n(aa paramaa) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(148191);
    ad.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
    paramDialogInterface.dismiss();
    aa.d(this.lmf);
    aa.b(this.lmf, "user cancel");
    aa.e(this.lmf);
    AppMethodBeat.o(148191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa.n
 * JD-Core Version:    0.7.0.1
 */