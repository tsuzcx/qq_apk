package com.tencent.mm.plugin.game.chatroom.view;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMEditText;

final class GameChatCommentFooter$20
  implements ChatFooterPanel.a
{
  GameChatCommentFooter$20(GameChatCommentFooter paramGameChatCommentFooter) {}
  
  public final void aWL() {}
  
  public final void aWM()
  {
    AppMethodBeat.i(276226);
    if (GameChatCommentFooter.g(this.IqR) != null)
    {
      if (GameChatCommentFooter.g(this.IqR).getInputConnection() == null)
      {
        AppMethodBeat.o(276226);
        return;
      }
      GameChatCommentFooter.g(this.IqR).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
      GameChatCommentFooter.g(this.IqR).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    }
    AppMethodBeat.o(276226);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(276234);
    if (g.a(GameChatCommentFooter.g(this.IqR).getText().toString() + paramString, g.a.afII) <= 1000) {
      GameChatCommentFooter.g(this.IqR).bDt(paramString);
    }
    AppMethodBeat.o(276234);
  }
  
  public final void fp(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter.20
 * JD-Core Version:    0.7.0.1
 */