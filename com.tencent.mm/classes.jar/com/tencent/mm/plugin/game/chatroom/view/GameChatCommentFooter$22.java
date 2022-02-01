package com.tencent.mm.plugin.game.chatroom.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.m.a;
import com.tencent.mm.ui.widget.MMEditText;

final class GameChatCommentFooter$22
  implements m.a
{
  GameChatCommentFooter$22(GameChatCommentFooter paramGameChatCommentFooter) {}
  
  public final void clear()
  {
    AppMethodBeat.i(276211);
    GameChatCommentFooter localGameChatCommentFooter = this.IqR;
    if (localGameChatCommentFooter.nir != null)
    {
      localGameChatCommentFooter.nir.setText("");
      if (localGameChatCommentFooter.moD != null) {
        localGameChatCommentFooter.moD.setToSendText("");
      }
    }
    AppMethodBeat.o(276211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter.22
 * JD-Core Version:    0.7.0.1
 */