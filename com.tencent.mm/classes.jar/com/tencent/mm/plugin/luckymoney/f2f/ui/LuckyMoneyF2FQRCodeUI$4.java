package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.util.Pair;
import android.view.View;
import com.tencent.mm.plugin.luckymoney.f2f.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Queue;

final class LuckyMoneyF2FQRCodeUI$4
  implements ShuffleView.a
{
  LuckyMoneyF2FQRCodeUI$4(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void a(ValueAnimator paramValueAnimator, View paramView)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f == 0.0F)
    {
      LuckyMoneyF2FQRCodeUI.a(this.lOE, paramView.getTranslationX());
      LuckyMoneyF2FQRCodeUI.b(this.lOE, paramView.getTranslationY());
      paramView.findViewById(a.f.lucky_money_f2f_single_card).setVisibility(0);
    }
    paramView.setTranslationX((1.0F - f) * LuckyMoneyF2FQRCodeUI.A(this.lOE));
    paramView.setTranslationY((1.0F - f) * LuckyMoneyF2FQRCodeUI.B(this.lOE) - (LuckyMoneyF2FQRCodeUI.c(this.lOE).getHeight() + LuckyMoneyF2FQRCodeUI.B(this.lOE) * 8.0F) * f);
    paramView.setScaleX(0.5F * f + 1.0F);
    paramView.setScaleY(0.5F * f + 1.0F);
    paramValueAnimator = (Pair)LuckyMoneyF2FQRCodeUI.f(this.lOE).peek();
    if ((paramValueAnimator != null) && (!bk.bl(LuckyMoneyF2FQRCodeUI.C(this.lOE))) && (LuckyMoneyF2FQRCodeUI.C(this.lOE).equals(paramValueAnimator.first))) {
      LuckyMoneyF2FQRCodeUI.D(this.lOE).setAlpha(f);
    }
    y.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", new Object[] { Float.valueOf(f) });
    if (f >= 0.9F)
    {
      paramView.setAlpha((1.0F - f) * 10.0F);
      LuckyMoneyF2FQRCodeUI.E(this.lOE).setAlpha(1.0F - (1.0F - f) * 10.0F);
      LuckyMoneyF2FQRCodeUI.E(this.lOE).setScaleX(f);
      LuckyMoneyF2FQRCodeUI.E(this.lOE).setScaleY(f);
      LuckyMoneyF2FQRCodeUI.E(this.lOE).setVisibility(0);
    }
    if (f == 1.0F)
    {
      LuckyMoneyF2FQRCodeUI.F(this.lOE).eE("packet_received.m4a");
      LuckyMoneyF2FQRCodeUI.c(this.lOE).removeView(LuckyMoneyF2FQRCodeUI.c(this.lOE).getExitView());
      LuckyMoneyF2FQRCodeUI.G(this.lOE);
      LuckyMoneyF2FQRCodeUI.H(this.lOE).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.4
 * JD-Core Version:    0.7.0.1
 */