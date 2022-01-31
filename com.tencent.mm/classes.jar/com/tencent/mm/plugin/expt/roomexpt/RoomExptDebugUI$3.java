package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

final class RoomExptDebugUI$3
  implements View.OnClickListener
{
  RoomExptDebugUI$3(RoomExptDebugUI paramRoomExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    a.aNc().aNg();
    RoomExptDebugUI.c(this.jIW);
    Toast.makeText(this.jIW, "reset finish", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.3
 * JD-Core Version:    0.7.0.1
 */