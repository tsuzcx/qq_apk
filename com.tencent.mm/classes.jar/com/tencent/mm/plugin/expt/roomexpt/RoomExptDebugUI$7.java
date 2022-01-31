package com.tencent.mm.plugin.expt.roomexpt;

import android.widget.ArrayAdapter;

final class RoomExptDebugUI$7
  implements Runnable
{
  RoomExptDebugUI$7(RoomExptDebugUI paramRoomExptDebugUI) {}
  
  public final void run()
  {
    RoomExptDebugUI.d(this.jIW).notifyDataSetChanged();
    RoomExptDebugUI.c(this.jIW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.7
 * JD-Core Version:    0.7.0.1
 */