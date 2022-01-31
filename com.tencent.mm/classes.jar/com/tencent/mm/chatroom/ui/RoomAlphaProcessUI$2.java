package com.tencent.mm.chatroom.ui;

import android.content.Intent;

final class RoomAlphaProcessUI$2
  implements Runnable
{
  RoomAlphaProcessUI$2(RoomAlphaProcessUI paramRoomAlphaProcessUI, boolean paramBoolean) {}
  
  public final void run()
  {
    Intent localIntent = new Intent(this.dps, RoomUpgradeUI.class);
    localIntent.setFlags(603979776);
    localIntent.putExtra("room_name", RoomAlphaProcessUI.a(this.dps));
    localIntent.putExtra("upgrade_success", this.dpq);
    this.dps.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAlphaProcessUI.2
 * JD-Core Version:    0.7.0.1
 */