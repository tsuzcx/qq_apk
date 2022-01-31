package com.tencent.mm.plugin.expt.roomexpt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

final class RoomExptDebugUI$4
  implements View.OnClickListener
{
  RoomExptDebugUI$4(RoomExptDebugUI paramRoomExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    a.aNc().aNf();
    RoomExptDebugUI.d(this.jIW).clear();
    Toast.makeText(this.jIW, "del db finish", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.4
 * JD-Core Version:    0.7.0.1
 */