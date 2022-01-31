package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomExptDebugUI$3
  implements View.OnClickListener
{
  RoomExptDebugUI$3(RoomExptDebugUI paramRoomExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73593);
    a.bsU().bsY();
    RoomExptDebugUI.c(this.mcY);
    Toast.makeText(this.mcY, "reset finish", 0).show();
    AppMethodBeat.o(73593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.3
 * JD-Core Version:    0.7.0.1
 */