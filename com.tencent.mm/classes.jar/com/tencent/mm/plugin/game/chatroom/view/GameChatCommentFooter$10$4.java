package com.tencent.mm.plugin.game.chatroom.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameChatCommentFooter$10$4
  implements Animator.AnimatorListener
{
  GameChatCommentFooter$10$4(GameChatCommentFooter.10 param10) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(292828);
    GameChatCommentFooter.n(this.NXc.CyA).setVisibility(8);
    AppMethodBeat.o(292828);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(292827);
    GameChatCommentFooter.n(this.NXc.CyA).setVisibility(8);
    AppMethodBeat.o(292827);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(292826);
    GameChatCommentFooter.n(this.NXc.CyA).setVisibility(0);
    AppMethodBeat.o(292826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter.10.4
 * JD-Core Version:    0.7.0.1
 */