package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;

final class RoomExptDebugUI$2
  implements View.OnClickListener
{
  RoomExptDebugUI$2(RoomExptDebugUI paramRoomExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73592);
    g.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(73591);
        RoomExptDebugUI.b(RoomExptDebugUI.2.this.mcY);
        AppMethodBeat.o(73591);
      }
    });
    AppMethodBeat.o(73592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.2
 * JD-Core Version:    0.7.0.1
 */