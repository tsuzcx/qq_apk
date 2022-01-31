package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class SeeRoomMemberUI$17
  implements DialogInterface.OnCancelListener
{
  SeeRoomMemberUI$17(SeeRoomMemberUI paramSeeRoomMemberUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(104324);
    this.efH.cancel();
    AppMethodBeat.o(104324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.17
 * JD-Core Version:    0.7.0.1
 */