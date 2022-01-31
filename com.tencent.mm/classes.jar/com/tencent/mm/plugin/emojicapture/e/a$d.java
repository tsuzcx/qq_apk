package com.tencent.mm.plugin.emojicapture.e;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class a$d
  implements DialogInterface.OnCancelListener
{
  a$d(a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(2742);
    a.c(this.lwa).boQ();
    AppMethodBeat.o(2742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a.d
 * JD-Core Version:    0.7.0.1
 */