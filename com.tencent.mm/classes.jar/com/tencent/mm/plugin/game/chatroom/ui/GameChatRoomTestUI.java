package com.tencent.mm.plugin.game.chatroom.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.ui.MMActivity;

public class GameChatRoomTestUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return f.f.CtQ;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomTestUI
 * JD-Core Version:    0.7.0.1
 */