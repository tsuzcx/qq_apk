package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class aa$h
  implements DialogInterface.OnClickListener
{
  aa$h(aa paramaa) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(148181);
    paramDialogInterface.dismiss();
    ad.e("MicroMsg.PhoneNumberVerifyCodeDialog", "verify code is error, do send the right code");
    aa.g(this.mlJ);
    AppMethodBeat.o(148181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa.h
 * JD-Core Version:    0.7.0.1
 */