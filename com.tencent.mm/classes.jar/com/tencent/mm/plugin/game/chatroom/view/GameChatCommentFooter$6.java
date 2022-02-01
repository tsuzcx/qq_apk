package com.tencent.mm.plugin.game.chatroom.view;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;

final class GameChatCommentFooter$6
  extends g
{
  GameChatCommentFooter$6(GameChatCommentFooter paramGameChatCommentFooter, g.a parama)
  {
    super(1000, parama);
  }
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(276420);
    if (paramSpanned.length() > paramInt3)
    {
      paramInt2 = a(paramSpanned.subSequence(0, paramInt3).toString(), g.a.afII);
      if (paramSpanned.length() <= paramInt4) {
        break label223;
      }
    }
    label220:
    label223:
    for (paramInt3 = a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), g.a.afII);; paramInt3 = 0)
    {
      paramInt4 = a(paramCharSequence.toString(), g.a.afII);
      int j = bCA(paramCharSequence.toString());
      if (paramInt2 + paramInt4 + paramInt3 > 1000)
      {
        paramInt2 = 1000 - paramInt2 - paramInt3 - j;
        if (paramInt2 >= 0) {
          break label220;
        }
        paramInt2 = i;
      }
      for (;;)
      {
        if ((paramCharSequence == null) || (paramInt1 < 0) || (paramCharSequence.length() < paramInt1 + paramInt2))
        {
          AppMethodBeat.o(276420);
          return "";
          paramInt2 = a(paramSpanned.toString(), g.a.afII);
          break;
        }
        paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt1 + paramInt2);
        AppMethodBeat.o(276420);
        return paramCharSequence;
        paramSpanned = paramCharSequence;
        if (paramCharSequence == null) {
          paramSpanned = "";
        }
        AppMethodBeat.o(276420);
        return paramSpanned;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter.6
 * JD-Core Version:    0.7.0.1
 */