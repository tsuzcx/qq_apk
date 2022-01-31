package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class SeeRoomMemberUI$3
  implements DialogInterface.OnCancelListener
{
  SeeRoomMemberUI$3(SeeRoomMemberUI paramSeeRoomMemberUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(104310);
    this.efK.cancel();
    AppMethodBeat.o(104310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.3
 * JD-Core Version:    0.7.0.1
 */