package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class RoomUpgradeUI$5
  implements DialogInterface.OnCancelListener
{
  RoomUpgradeUI$5(RoomUpgradeUI paramRoomUpgradeUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (RoomUpgradeUI.h(this.dqG) != null)
    {
      g.DO().dJT.c(RoomUpgradeUI.h(this.dqG));
      RoomUpgradeUI.i(this.dqG);
    }
    this.dqG.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeUI.5
 * JD-Core Version:    0.7.0.1
 */