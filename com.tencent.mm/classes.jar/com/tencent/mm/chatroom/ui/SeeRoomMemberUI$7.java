package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.roomsdk.a.b.c;
import java.util.ArrayList;
import java.util.List;

final class SeeRoomMemberUI$7
  implements DialogInterface.OnClickListener
{
  SeeRoomMemberUI$7(SeeRoomMemberUI paramSeeRoomMemberUI, c paramc, List paramList1, List paramList2, List paramList3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(104314);
    if (t.nJ(SeeRoomMemberUI.m(this.eja))) {
      SeeRoomMemberUI.a(this.eja, this.efM.chatroomName, this.efN);
    }
    paramDialogInterface = new ArrayList();
    paramDialogInterface.addAll(this.efO);
    paramDialogInterface.addAll(this.efP);
    SeeRoomMemberUI.a(this.eja, paramDialogInterface);
    AppMethodBeat.o(104314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.7
 * JD-Core Version:    0.7.0.1
 */