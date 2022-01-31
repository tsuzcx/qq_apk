package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

final class RoomExptDebugUI$5
  implements View.OnClickListener
{
  RoomExptDebugUI$5(RoomExptDebugUI paramRoomExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    a.aNc().jIH = 3;
    Toast.makeText(this.jIW, "set show finish", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.5
 * JD-Core Version:    0.7.0.1
 */