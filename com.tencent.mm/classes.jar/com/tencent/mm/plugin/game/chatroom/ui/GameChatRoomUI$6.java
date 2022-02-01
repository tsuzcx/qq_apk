package com.tencent.mm.plugin.game.chatroom.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class GameChatRoomUI$6
  extends BroadcastReceiver
{
  GameChatRoomUI$6(GameChatRoomUI paramGameChatRoomUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(212019);
    if ((paramIntent != null) && ("com.tencent.mm.game.ACTION_QUIT_CHAT_ROOM".equals(paramIntent.getAction())) && (this.Cwp != null) && (!this.Cwp.isFinishing()))
    {
      paramContext = paramIntent.getStringExtra("chatroom_name");
      if (Util.nullAsNil(GameChatRoomUI.a(this.Cwp)).equals(paramContext))
      {
        Log.i("GameChatRoom.GameChatRoomUI", "GameChatRoomUI exit!");
        GameChatRoomUI.i(this.Cwp);
      }
    }
    AppMethodBeat.o(212019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomUI.6
 * JD-Core Version:    0.7.0.1
 */