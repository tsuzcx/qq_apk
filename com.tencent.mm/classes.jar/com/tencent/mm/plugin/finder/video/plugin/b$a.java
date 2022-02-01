package com.tencent.mm.plugin.finder.video.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class b$a
  implements DialogInterface.OnClickListener
{
  public static final a tbT;
  
  static
  {
    AppMethodBeat.i(205549);
    tbT = new a();
    AppMethodBeat.o(205549);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(205548);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(205548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */