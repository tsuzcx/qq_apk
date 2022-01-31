package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomCardUI$5
  implements DialogInterface.OnDismissListener
{
  RoomCardUI$5(RoomCardUI paramRoomCardUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(155170);
    this.ehp.finish();
    AppMethodBeat.o(155170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.5
 * JD-Core Version:    0.7.0.1
 */