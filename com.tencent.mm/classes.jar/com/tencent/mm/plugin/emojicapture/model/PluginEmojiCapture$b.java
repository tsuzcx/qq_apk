package com.tencent.mm.plugin.emojicapture.model;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
final class PluginEmojiCapture$b
  implements DialogInterface.OnDismissListener
{
  PluginEmojiCapture$b(b.a parama) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(2617);
    this.ltD.gR(true);
    AppMethodBeat.o(2617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture.b
 * JD-Core Version:    0.7.0.1
 */