package com.tencent.mm.plugin.game.chatroom.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatMemberListView$b$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ChatMemberListView$b$1(ChatMemberListView.b paramb, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(276260);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (LinearLayout.LayoutParams)this.Iop.getLayoutParams();
    paramValueAnimator.width = i;
    this.Iop.setLayoutParams(paramValueAnimator);
    AppMethodBeat.o(276260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView.b.1
 * JD-Core Version:    0.7.0.1
 */