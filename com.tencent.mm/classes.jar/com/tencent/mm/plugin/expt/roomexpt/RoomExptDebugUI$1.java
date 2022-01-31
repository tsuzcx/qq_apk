package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;

final class RoomExptDebugUI$1
  implements View.OnClickListener
{
  RoomExptDebugUI$1(RoomExptDebugUI paramRoomExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73590);
    g.RO().ac(new RoomExptDebugUI.1.1(this));
    AppMethodBeat.o(73590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.1
 * JD-Core Version:    0.7.0.1
 */