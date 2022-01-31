package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomInfoDetailUI$2$3
  implements DialogInterface.OnClickListener
{
  RoomInfoDetailUI$2$3(RoomInfoDetailUI.2 param2, ProgressDialog paramProgressDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(104188);
    this.efE.show();
    RoomInfoDetailUI.a(this.ehE.ehD, false);
    RoomInfoDetailUI.a(this.ehE.ehD, this.efE);
    AppMethodBeat.o(104188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI.2.3
 * JD-Core Version:    0.7.0.1
 */