package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class n$n
  implements DialogInterface.OnClickListener
{
  n$n(n paramn) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(134916);
    ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
    paramDialogInterface.dismiss();
    n.d(this.iEE);
    n.b(this.iEE, "user cancel");
    n.e(this.iEE);
    AppMethodBeat.o(134916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.n.n
 * JD-Core Version:    0.7.0.1
 */