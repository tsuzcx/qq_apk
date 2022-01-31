package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomInfoDetailUI$2$1
  implements DialogInterface.OnCancelListener
{
  RoomInfoDetailUI$2$1(RoomInfoDetailUI.2 param2) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(104186);
    RoomInfoDetailUI.a(this.ehE.ehD, true);
    AppMethodBeat.o(104186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI.2.1
 * JD-Core Version:    0.7.0.1
 */