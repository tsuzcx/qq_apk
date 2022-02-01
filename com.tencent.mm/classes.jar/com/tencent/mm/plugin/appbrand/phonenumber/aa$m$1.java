package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "_dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class aa$m$1
  implements DialogInterface.OnClickListener
{
  public static final 1 mqP;
  
  static
  {
    AppMethodBeat.i(148187);
    mqP = new 1();
    AppMethodBeat.o(148187);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(148186);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(148186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa.m.1
 * JD-Core Version:    0.7.0.1
 */