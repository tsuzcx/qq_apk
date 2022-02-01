package com.tencent.mm.plugin.finder.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class w$a
  implements DialogInterface.OnClickListener
{
  public static final a AEa;
  
  static
  {
    AppMethodBeat.i(283676);
    AEa = new a();
    AppMethodBeat.o(283676);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(283675);
    ((com.tencent.mm.plugin.findersdk.a.l)h.ae(com.tencent.mm.plugin.findersdk.a.l.class)).o(Boolean.FALSE);
    AppMethodBeat.o(283675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.w.a
 * JD-Core Version:    0.7.0.1
 */