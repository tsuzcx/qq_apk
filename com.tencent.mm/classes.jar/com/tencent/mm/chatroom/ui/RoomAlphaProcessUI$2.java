package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomAlphaProcessUI$2
  implements Runnable
{
  RoomAlphaProcessUI$2(RoomAlphaProcessUI paramRoomAlphaProcessUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(104129);
    Intent localIntent = new Intent(this.egO, RoomUpgradeUI.class);
    localIntent.setFlags(603979776);
    localIntent.putExtra("room_name", RoomAlphaProcessUI.a(this.egO));
    localIntent.putExtra("upgrade_success", this.egM);
    this.egO.startActivity(localIntent);
    AppMethodBeat.o(104129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAlphaProcessUI.2
 * JD-Core Version:    0.7.0.1
 */