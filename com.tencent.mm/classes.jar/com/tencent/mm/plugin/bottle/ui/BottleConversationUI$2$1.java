package com.tencent.mm.plugin.bottle.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BottleConversationUI$2$1
  implements DialogInterface.OnCancelListener
{
  BottleConversationUI$2$1(BottleConversationUI.2 param2) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(18554);
    BottleConversationUI.a(this.jSp.jSo, true);
    AppMethodBeat.o(18554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.2.1
 * JD-Core Version:    0.7.0.1
 */