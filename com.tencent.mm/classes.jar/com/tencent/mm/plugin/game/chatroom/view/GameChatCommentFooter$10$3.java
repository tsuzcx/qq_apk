package com.tencent.mm.plugin.game.chatroom.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameChatCommentFooter$10$3
  implements ValueAnimator.AnimatorUpdateListener
{
  GameChatCommentFooter$10$3(GameChatCommentFooter.10 param10) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(292830);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = GameChatCommentFooter.n(this.NXc.CyA).getLayoutParams();
    paramValueAnimator.width = i;
    GameChatCommentFooter.n(this.NXc.CyA).setLayoutParams(paramValueAnimator);
    GameChatCommentFooter.n(this.NXc.CyA).setAlpha(i / GameChatCommentFooter.m(this.NXc.CyA));
    AppMethodBeat.o(292830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter.10.3
 * JD-Core Version:    0.7.0.1
 */