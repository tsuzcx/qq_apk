package com.tencent.mm.plugin.game.chatroom.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameChatCommentFooter$10$2
  implements Animator.AnimatorListener
{
  GameChatCommentFooter$10$2(GameChatCommentFooter.10 param10) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(292813);
    paramAnimator = GameChatCommentFooter.n(this.NXc.CyA).getLayoutParams();
    paramAnimator.width = GameChatCommentFooter.m(this.NXc.CyA);
    GameChatCommentFooter.n(this.NXc.CyA).setLayoutParams(paramAnimator);
    GameChatCommentFooter.n(this.NXc.CyA).setAlpha(1.0F);
    AppMethodBeat.o(292813);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(292812);
    GameChatCommentFooter.n(this.NXc.CyA).setVisibility(0);
    paramAnimator = GameChatCommentFooter.n(this.NXc.CyA).getLayoutParams();
    paramAnimator.width = GameChatCommentFooter.m(this.NXc.CyA);
    GameChatCommentFooter.n(this.NXc.CyA).setLayoutParams(paramAnimator);
    GameChatCommentFooter.n(this.NXc.CyA).setAlpha(1.0F);
    AppMethodBeat.o(292812);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(292811);
    GameChatCommentFooter.n(this.NXc.CyA).setVisibility(0);
    AppMethodBeat.o(292811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter.10.2
 * JD-Core Version:    0.7.0.1
 */