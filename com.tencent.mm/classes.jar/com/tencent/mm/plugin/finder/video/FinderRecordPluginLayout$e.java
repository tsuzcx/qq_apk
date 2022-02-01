package com.tencent.mm.plugin.finder.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class FinderRecordPluginLayout$e
  implements DialogInterface.OnClickListener
{
  FinderRecordPluginLayout$e(FinderRecordPluginLayout paramFinderRecordPluginLayout) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(254076);
    paramDialogInterface.dismiss();
    FinderRecordPluginLayout.l(this.wdu);
    AppMethodBeat.o(254076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout.e
 * JD-Core Version:    0.7.0.1
 */