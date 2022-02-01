package com.tencent.mm.msgsubscription.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class c$a
  implements DialogInterface.OnClickListener
{
  public static final a mtz;
  
  static
  {
    AppMethodBeat.i(197581);
    mtz = new a();
    AppMethodBeat.o(197581);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(197580);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(197580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.c.a
 * JD-Core Version:    0.7.0.1
 */