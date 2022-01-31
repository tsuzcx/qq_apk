package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class RoomUpgradeUI$2
  implements View.OnClickListener
{
  RoomUpgradeUI$2(RoomUpgradeUI paramRoomUpgradeUI) {}
  
  public final void onClick(View paramView)
  {
    switch (RoomUpgradeUI.a(this.dqG))
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 1: 
      if (RoomUpgradeUI.b(this.dqG))
      {
        b.a(this.dqG, RoomUpgradeUI.c(this.dqG), true);
        return;
      }
      RoomUpgradeUI.a(this.dqG, true);
      return;
    }
    if (RoomUpgradeUI.b(this.dqG))
    {
      RoomUpgradeUI.d(this.dqG);
      return;
    }
    RoomUpgradeUI.a(this.dqG, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeUI.2
 * JD-Core Version:    0.7.0.1
 */