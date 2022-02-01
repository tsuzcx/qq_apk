package com.tencent.mm.plugin.luckymoney.ui.a;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ad;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

public final class b
{
  public static void a(ViewGroup paramViewGroup, ChatFooterPanel paramChatFooterPanel, int paramInt, ac.a parama)
  {
    AppMethodBeat.i(65985);
    paramChatFooterPanel.setEntranceScene(paramInt);
    paramChatFooterPanel.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, ad.bD(paramViewGroup.getContext()));
    localLayoutParams.gravity = 80;
    paramViewGroup.removeAllViews();
    paramViewGroup.addView(paramChatFooterPanel, localLayoutParams);
    paramViewGroup = ad.VK();
    paramViewGroup.djc = parama;
    paramChatFooterPanel.setCallback(paramViewGroup);
    AppMethodBeat.o(65985);
  }
  
  public static boolean a(Context paramContext, ChatFooterPanel paramChatFooterPanel)
  {
    AppMethodBeat.i(65984);
    if (paramChatFooterPanel == null)
    {
      AppMethodBeat.o(65984);
      return false;
    }
    paramChatFooterPanel.onPause();
    if (paramChatFooterPanel.getVisibility() == 0)
    {
      paramChatFooterPanel.setVisibility(8);
      paramContext = AnimationUtils.loadAnimation(paramContext, 2130772130);
      paramContext.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(65983);
          if (this.zjh != null)
          {
            this.zjh.onPause();
            this.zjh.setVisibility(8);
          }
          AppMethodBeat.o(65983);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(65982);
          if (this.zjh != null) {
            this.zjh.setVisibility(0);
          }
          AppMethodBeat.o(65982);
        }
      });
      paramChatFooterPanel.startAnimation(paramContext);
      AppMethodBeat.o(65984);
      return true;
    }
    AppMethodBeat.o(65984);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a.b
 * JD-Core Version:    0.7.0.1
 */