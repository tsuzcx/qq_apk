package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class GroupToolsManagereUI$5
  implements DialogInterface.OnClickListener
{
  GroupToolsManagereUI$5(GroupToolsManagereUI paramGroupToolsManagereUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(182172);
    ac.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot cancel");
    AppMethodBeat.o(182172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.5
 * JD-Core Version:    0.7.0.1
 */