package com.tencent.mm.plugin.expt.roomexpt;

import android.widget.ArrayAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomExptDebugUI$8
  implements Runnable
{
  RoomExptDebugUI$8(RoomExptDebugUI paramRoomExptDebugUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(73598);
    RoomExptDebugUI.d(this.mcY).notifyDataSetChanged();
    RoomExptDebugUI.c(this.mcY);
    AppMethodBeat.o(73598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.8
 * JD-Core Version:    0.7.0.1
 */