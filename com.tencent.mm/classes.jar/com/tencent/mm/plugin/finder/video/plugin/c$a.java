package com.tencent.mm.plugin.finder.video.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class c$a
  implements DialogInterface.OnClickListener
{
  public static final a wgV;
  
  static
  {
    AppMethodBeat.i(254468);
    wgV = new a();
    AppMethodBeat.o(254468);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(254467);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(254467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.c.a
 * JD-Core Version:    0.7.0.1
 */