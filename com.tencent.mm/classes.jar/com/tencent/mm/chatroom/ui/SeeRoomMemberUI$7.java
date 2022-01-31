package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.s;
import com.tencent.mm.roomsdk.a.b.c;
import java.util.ArrayList;
import java.util.List;

final class SeeRoomMemberUI$7
  implements DialogInterface.OnClickListener
{
  SeeRoomMemberUI$7(SeeRoomMemberUI paramSeeRoomMemberUI, c paramc, List paramList1, List paramList2, List paramList3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (s.ha(SeeRoomMemberUI.m(this.drs))) {
      SeeRoomMemberUI.a(this.drs, this.dop.chatroomName, this.doq);
    }
    paramDialogInterface = new ArrayList();
    paramDialogInterface.addAll(this.dor);
    paramDialogInterface.addAll(this.dos);
    SeeRoomMemberUI.a(this.drs, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.7
 * JD-Core Version:    0.7.0.1
 */