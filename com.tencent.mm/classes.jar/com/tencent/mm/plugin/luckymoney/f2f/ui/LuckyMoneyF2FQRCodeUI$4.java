package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.f2f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Queue;

final class LuckyMoneyF2FQRCodeUI$4
  implements ShuffleView.a
{
  LuckyMoneyF2FQRCodeUI$4(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void a(ValueAnimator paramValueAnimator, View paramView)
  {
    AppMethodBeat.i(42173);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f == 0.0F)
    {
      LuckyMoneyF2FQRCodeUI.a(this.olY, paramView.getTranslationX());
      LuckyMoneyF2FQRCodeUI.b(this.olY, paramView.getTranslationY());
      paramView.findViewById(2131825665).setVisibility(0);
    }
    paramView.setTranslationX((1.0F - f) * LuckyMoneyF2FQRCodeUI.A(this.olY));
    paramView.setTranslationY((1.0F - f) * LuckyMoneyF2FQRCodeUI.B(this.olY) - (LuckyMoneyF2FQRCodeUI.c(this.olY).getHeight() + LuckyMoneyF2FQRCodeUI.B(this.olY) * 8.0F) * f);
    paramView.setScaleX(0.5F * f + 1.0F);
    paramView.setScaleY(0.5F * f + 1.0F);
    paramValueAnimator = (Pair)LuckyMoneyF2FQRCodeUI.f(this.olY).peek();
    if ((paramValueAnimator != null) && (!bo.isNullOrNil(LuckyMoneyF2FQRCodeUI.C(this.olY))) && (LuckyMoneyF2FQRCodeUI.C(this.olY).equals(paramValueAnimator.first))) {
      LuckyMoneyF2FQRCodeUI.D(this.olY).setAlpha(f);
    }
    ab.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", new Object[] { Float.valueOf(f) });
    if (f >= 0.9F)
    {
      paramView.setAlpha((1.0F - f) * 10.0F);
      LuckyMoneyF2FQRCodeUI.E(this.olY).setAlpha(1.0F - (1.0F - f) * 10.0F);
      LuckyMoneyF2FQRCodeUI.E(this.olY).setScaleX(f);
      LuckyMoneyF2FQRCodeUI.E(this.olY).setScaleY(f);
      LuckyMoneyF2FQRCodeUI.E(this.olY).setVisibility(0);
    }
    if (f == 1.0F)
    {
      LuckyMoneyF2FQRCodeUI.F(this.olY).kJ("packet_received.m4a");
      LuckyMoneyF2FQRCodeUI.c(this.olY).removeView(LuckyMoneyF2FQRCodeUI.c(this.olY).getExitView());
      LuckyMoneyF2FQRCodeUI.G(this.olY);
      LuckyMoneyF2FQRCodeUI.H(this.olY).start();
    }
    AppMethodBeat.o(42173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.4
 * JD-Core Version:    0.7.0.1
 */