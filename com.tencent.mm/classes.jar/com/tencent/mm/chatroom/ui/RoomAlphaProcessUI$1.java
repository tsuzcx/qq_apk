package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomAlphaProcessUI$1
  implements Runnable
{
  RoomAlphaProcessUI$1(RoomAlphaProcessUI paramRoomAlphaProcessUI, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(104128);
    Intent localIntent = new Intent(this.egO, RoomUpgradeUI.class);
    localIntent.setFlags(603979776);
    localIntent.putExtra("room_name", RoomAlphaProcessUI.a(this.egO));
    localIntent.putExtra("upgrade_success", this.egM);
    localIntent.putExtra("left_quota", this.egN);
    this.egO.startActivity(localIntent);
    AppMethodBeat.o(104128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAlphaProcessUI.1
 * JD-Core Version:    0.7.0.1
 */