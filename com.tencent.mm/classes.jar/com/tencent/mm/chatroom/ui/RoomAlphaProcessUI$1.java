package com.tencent.mm.chatroom.ui;

import android.content.Intent;

final class RoomAlphaProcessUI$1
  implements Runnable
{
  RoomAlphaProcessUI$1(RoomAlphaProcessUI paramRoomAlphaProcessUI, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    Intent localIntent = new Intent(this.dps, RoomUpgradeUI.class);
    localIntent.setFlags(603979776);
    localIntent.putExtra("room_name", RoomAlphaProcessUI.a(this.dps));
    localIntent.putExtra("upgrade_success", this.dpq);
    localIntent.putExtra("left_quota", this.dpr);
    this.dps.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAlphaProcessUI.1
 * JD-Core Version:    0.7.0.1
 */