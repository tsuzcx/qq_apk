package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class aa$n
  implements DialogInterface.OnClickListener
{
  aa$n(aa paramaa) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(148191);
    Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
    paramDialogInterface.dismiss();
    aa.d(this.nBs);
    aa.b(this.nBs, "user cancel");
    aa.e(this.nBs);
    AppMethodBeat.o(148191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa.n
 * JD-Core Version:    0.7.0.1
 */