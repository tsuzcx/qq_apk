package com.tencent.mm.plugin.game.chatroom.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatMemberListView$b$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ChatMemberListView$b$2(ChatMemberListView.b paramb, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(211821);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (LinearLayout.LayoutParams)this.CwO.getLayoutParams();
    paramValueAnimator.width = i;
    this.CwO.setLayoutParams(paramValueAnimator);
    AppMethodBeat.o(211821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView.b.2
 * JD-Core Version:    0.7.0.1
 */