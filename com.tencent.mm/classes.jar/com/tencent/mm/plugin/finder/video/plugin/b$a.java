package com.tencent.mm.plugin.finder.video.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class b$a
  implements DialogInterface.OnClickListener
{
  public static final a sQI;
  
  static
  {
    AppMethodBeat.i(204924);
    sQI = new a();
    AppMethodBeat.o(204924);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(204923);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(204923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */