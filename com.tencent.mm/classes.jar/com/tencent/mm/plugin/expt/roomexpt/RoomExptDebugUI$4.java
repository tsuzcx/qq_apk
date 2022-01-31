package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomExptDebugUI$4
  implements View.OnClickListener
{
  RoomExptDebugUI$4(RoomExptDebugUI paramRoomExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73594);
    a.bsU().bsX();
    RoomExptDebugUI.d(this.mcY).clear();
    Toast.makeText(this.mcY, "del db finish", 0).show();
    AppMethodBeat.o(73594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.4
 * JD-Core Version:    0.7.0.1
 */