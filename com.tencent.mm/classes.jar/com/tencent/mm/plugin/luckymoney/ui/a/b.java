package com.tencent.mm.plugin.luckymoney.ui.a;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.api.ae;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

public final class b
{
  public static void a(ViewGroup paramViewGroup, ChatFooterPanel paramChatFooterPanel, int paramInt, ad.a parama)
  {
    AppMethodBeat.i(65985);
    paramChatFooterPanel.setEntranceScene(paramInt);
    paramChatFooterPanel.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, ae.cp(paramViewGroup.getContext()));
    localLayoutParams.gravity = 80;
    paramViewGroup.removeAllViews();
    paramViewGroup.addView(paramChatFooterPanel, localLayoutParams);
    paramViewGroup = ae.aBJ();
    paramViewGroup.hej = parama;
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
      paramContext = AnimationUtils.loadAnimation(paramContext, a.a.push_down_out);
      paramContext.setAnimationListener(new b.1(paramChatFooterPanel));
      paramChatFooterPanel.startAnimation(paramContext);
      AppMethodBeat.o(65984);
      return true;
    }
    AppMethodBeat.o(65984);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a.b
 * JD-Core Version:    0.7.0.1
 */