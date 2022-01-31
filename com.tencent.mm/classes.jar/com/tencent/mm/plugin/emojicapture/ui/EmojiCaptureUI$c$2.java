package com.tencent.mm.plugin.emojicapture.ui;

import a.f.b.j;
import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "<anonymous parameter 1>", "", "onClick"})
final class EmojiCaptureUI$c$2
  implements DialogInterface.OnClickListener
{
  EmojiCaptureUI$c$2(EmojiCaptureUI.c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(2865);
    j.q(paramDialogInterface, "dialog");
    paramDialogInterface.dismiss();
    this.lxh.lxg.finish();
    AppMethodBeat.o(2865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.c.2
 * JD-Core Version:    0.7.0.1
 */