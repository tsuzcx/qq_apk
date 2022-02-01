package com.tencent.mm.plugin.finder.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class FinderPostRouterUI$c
  implements DialogInterface.OnClickListener
{
  FinderPostRouterUI$c(FinderPostRouterUI paramFinderPostRouterUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(252593);
    paramDialogInterface.dismiss();
    this.vNd.finish();
    AppMethodBeat.o(252593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostRouterUI.c
 * JD-Core Version:    0.7.0.1
 */