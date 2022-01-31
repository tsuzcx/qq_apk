package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomExptDebugUI$5
  implements View.OnClickListener
{
  RoomExptDebugUI$5(RoomExptDebugUI paramRoomExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73595);
    a.bsU().mcG = 3;
    Toast.makeText(this.mcY, "set show finish", 0).show();
    AppMethodBeat.o(73595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.5
 * JD-Core Version:    0.7.0.1
 */