package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class s$e
  implements DialogInterface.OnClickListener
{
  public static final e mpa;
  
  static
  {
    AppMethodBeat.i(148092);
    mpa = new e();
    AppMethodBeat.o(148092);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(148091);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(148091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.s.e
 * JD-Core Version:    0.7.0.1
 */