package com.tencent.mm.chatroom.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.b.a;

final class RoomUpgradeResultUI$3
  implements ao.b.a
{
  RoomUpgradeResultUI$3(RoomUpgradeResultUI paramRoomUpgradeResultUI, String paramString) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104223);
    if (paramBoolean) {
      RoomUpgradeResultUI.b(this.ehU).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104222);
          RoomUpgradeResultUI.a(RoomUpgradeResultUI.3.this.ehU, RoomUpgradeResultUI.3.this.ehV);
          AppMethodBeat.o(104222);
        }
      });
    }
    AppMethodBeat.o(104223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeResultUI.3
 * JD-Core Version:    0.7.0.1
 */