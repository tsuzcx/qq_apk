package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class LuckyMoneyNotHookReceiveUI$13
  implements Runnable
{
  LuckyMoneyNotHookReceiveUI$13(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(284526);
    Object localObject = (RelativeLayout.LayoutParams)LuckyMoneyNotHookReceiveUI.t(this.KFB).getLayoutParams();
    float f = LuckyMoneyNotHookReceiveUI.u(this.KFB).getWidth() * 1.0993F;
    ((RelativeLayout.LayoutParams)localObject).width = Math.round(f);
    ((RelativeLayout.LayoutParams)localObject).height = Math.round(f * 1.72F);
    LuckyMoneyNotHookReceiveUI.t(this.KFB).setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = LuckyMoneyNotHookReceiveUI.u(this.KFB).getLayoutParams();
    if (localObject != null)
    {
      ((ViewGroup.LayoutParams)localObject).width += (int)(a.getScaleSize(MMApplicationContext.getContext()) * 1.0F);
      ((ViewGroup.LayoutParams)localObject).height -= (int)(a.getScaleSize(MMApplicationContext.getContext()) * 1.0F);
      LuckyMoneyNotHookReceiveUI.u(this.KFB).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(284526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.13
 * JD-Core Version:    0.7.0.1
 */