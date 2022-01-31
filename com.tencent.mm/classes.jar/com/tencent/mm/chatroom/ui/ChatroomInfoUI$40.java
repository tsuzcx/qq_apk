package com.tencent.mm.chatroom.ui;

import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ChatroomInfoUI$40
  implements Animation.AnimationListener
{
  ChatroomInfoUI$40(ChatroomInfoUI paramChatroomInfoUI, LinearLayout paramLinearLayout) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool = true;
    AppMethodBeat.i(104009);
    paramAnimation = (ViewGroup)this.efA.getWindow().findViewById(16908290);
    if (paramAnimation == null) {}
    for (;;)
    {
      ab.i("MicroMsg.ChatroomInfoUI", "remove cover view now. contentView is null [%b]", new Object[] { Boolean.valueOf(bool) });
      if (paramAnimation != null) {
        paramAnimation.removeView(this.efW);
      }
      this.efA.getListView().setTranscriptMode(ChatroomInfoUI.C(this.efA));
      AppMethodBeat.o(104009);
      return;
      bool = false;
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.40
 * JD-Core Version:    0.7.0.1
 */