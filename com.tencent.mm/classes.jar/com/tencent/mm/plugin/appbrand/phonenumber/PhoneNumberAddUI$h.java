package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class PhoneNumberAddUI$h
  implements DialogInterface.OnClickListener
{
  public static final h iDH;
  
  static
  {
    AppMethodBeat.i(134829);
    iDH = new h();
    AppMethodBeat.o(134829);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(134828);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(134828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.h
 * JD-Core Version:    0.7.0.1
 */