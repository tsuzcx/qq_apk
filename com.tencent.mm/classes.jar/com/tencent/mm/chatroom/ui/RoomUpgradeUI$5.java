package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class RoomUpgradeUI$5
  implements DialogInterface.OnCancelListener
{
  RoomUpgradeUI$5(RoomUpgradeUI paramRoomUpgradeUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(104240);
    if (RoomUpgradeUI.h(this.eie) != null)
    {
      g.RK().eHt.a(RoomUpgradeUI.h(this.eie));
      RoomUpgradeUI.i(this.eie);
    }
    this.eie.finish();
    AppMethodBeat.o(104240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeUI.5
 * JD-Core Version:    0.7.0.1
 */