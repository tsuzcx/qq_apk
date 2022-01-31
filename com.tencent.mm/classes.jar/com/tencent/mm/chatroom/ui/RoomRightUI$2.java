package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.chatroom.c.l;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.h;

final class RoomRightUI$2
  implements DialogInterface.OnClickListener
{
  RoomRightUI$2(RoomRightUI paramRoomRightUI, String paramString) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new l(this.dqk);
    RoomRightUI localRoomRightUI1 = this.dqj;
    RoomRightUI localRoomRightUI2 = this.dqj;
    this.dqj.getString(a.i.app_tip);
    RoomRightUI.a(localRoomRightUI1, h.b(localRoomRightUI2, "", true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        g.DO().dJT.c(paramDialogInterface);
      }
    }));
    g.DO().dJT.a(paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomRightUI.2
 * JD-Core Version:    0.7.0.1
 */