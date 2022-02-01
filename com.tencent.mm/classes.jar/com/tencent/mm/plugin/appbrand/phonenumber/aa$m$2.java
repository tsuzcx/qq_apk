package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "_dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class aa$m$2
  implements DialogInterface.OnClickListener
{
  public static final 2 mqQ;
  
  static
  {
    AppMethodBeat.i(148189);
    mqQ = new 2();
    AppMethodBeat.o(148189);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(148188);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(148188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa.m.2
 * JD-Core Version:    0.7.0.1
 */