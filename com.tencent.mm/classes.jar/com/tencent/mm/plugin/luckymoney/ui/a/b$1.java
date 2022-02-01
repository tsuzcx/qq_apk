package com.tencent.mm.plugin.luckymoney.ui.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class b$1
  implements Animation.AnimationListener
{
  b$1(ChatFooterPanel paramChatFooterPanel) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(65983);
    if (this.KIW != null)
    {
      this.KIW.onPause();
      this.KIW.setVisibility(8);
    }
    AppMethodBeat.o(65983);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(65982);
    if (this.KIW != null) {
      this.KIW.setVisibility(0);
    }
    AppMethodBeat.o(65982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a.b.1
 * JD-Core Version:    0.7.0.1
 */