package com.tencent.mm.plugin.luckymoney.ui.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class a$1
  implements Animation.AnimationListener
{
  a$1(ChatFooterPanel paramChatFooterPanel) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(43087);
    if (this.oxD != null)
    {
      this.oxD.onPause();
      this.oxD.setVisibility(8);
    }
    AppMethodBeat.o(43087);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(43086);
    if (this.oxD != null) {
      this.oxD.setVisibility(0);
    }
    AppMethodBeat.o(43086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a.a.1
 * JD-Core Version:    0.7.0.1
 */