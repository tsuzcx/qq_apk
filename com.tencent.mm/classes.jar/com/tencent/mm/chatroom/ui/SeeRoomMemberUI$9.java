package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SeeRoomMemberUI$9
  implements DialogInterface.OnClickListener
{
  SeeRoomMemberUI$9(SeeRoomMemberUI paramSeeRoomMemberUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(104315);
    paramDialogInterface = this.eja;
    SeeRoomMemberUI localSeeRoomMemberUI = this.eja;
    SeeRoomMemberUI.m(this.eja);
    SeeRoomMemberUI.a(paramDialogInterface, localSeeRoomMemberUI);
    AppMethodBeat.o(104315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.9
 * JD-Core Version:    0.7.0.1
 */