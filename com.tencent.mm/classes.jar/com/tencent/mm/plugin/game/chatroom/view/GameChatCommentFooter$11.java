package com.tencent.mm.plugin.game.chatroom.view;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.chatroom.f.b;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g;

final class GameChatCommentFooter$11
  implements c.a
{
  GameChatCommentFooter$11(GameChatCommentFooter paramGameChatCommentFooter) {}
  
  public final void abc(String paramString)
  {
    AppMethodBeat.i(292795);
    int i = g.dq(1000, paramString);
    if (i > 5)
    {
      GameChatCommentFooter.p(this.CyA).setVisibility(8);
      AppMethodBeat.o(292795);
      return;
    }
    GameChatCommentFooter.p(this.CyA).setText(String.valueOf(i));
    GameChatCommentFooter.p(this.CyA).setTextColor(this.CyA.getResources().getColor(f.b.BW_100_Alpha_0_5));
    GameChatCommentFooter.p(this.CyA).setVisibility(0);
    AppMethodBeat.o(292795);
  }
  
  public final void abd(String paramString)
  {
    AppMethodBeat.i(292796);
    GameChatCommentFooter.p(this.CyA).setVisibility(8);
    AppMethodBeat.o(292796);
  }
  
  public final void dN(String paramString)
  {
    AppMethodBeat.i(292797);
    GameChatCommentFooter.p(this.CyA).setText(g.dq(1000, paramString));
    GameChatCommentFooter.p(this.CyA).setTextColor(this.CyA.getResources().getColor(f.b.Red));
    GameChatCommentFooter.p(this.CyA).setVisibility(0);
    AppMethodBeat.o(292797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter.11
 * JD-Core Version:    0.7.0.1
 */