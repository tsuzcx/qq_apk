package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.h;

final class TransferRoomOwnerUI$1
  implements DialogInterface.OnClickListener
{
  TransferRoomOwnerUI$1(TransferRoomOwnerUI paramTransferRoomOwnerUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new com.tencent.mm.chatroom.c.p(this.dtB.dpj, this.dol);
    g.DO().dJT.a(paramDialogInterface, 0);
    paramDialogInterface = this.dtB;
    TransferRoomOwnerUI localTransferRoomOwnerUI = this.dtB;
    this.dtB.getString(a.i.app_tip);
    TransferRoomOwnerUI.a(paramDialogInterface, h.b(localTransferRoomOwnerUI, this.dtB.getString(a.i.room_transferring_owner), false, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.TransferRoomOwnerUI.1
 * JD-Core Version:    0.7.0.1
 */