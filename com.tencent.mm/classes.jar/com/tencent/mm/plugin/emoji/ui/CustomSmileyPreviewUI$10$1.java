package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CustomSmileyPreviewUI$10$1
  implements DialogInterface.OnClickListener
{
  CustomSmileyPreviewUI$10$1(CustomSmileyPreviewUI.10 param10) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(53232);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.lkR.lkP.finish();
    AppMethodBeat.o(53232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.10.1
 * JD-Core Version:    0.7.0.1
 */