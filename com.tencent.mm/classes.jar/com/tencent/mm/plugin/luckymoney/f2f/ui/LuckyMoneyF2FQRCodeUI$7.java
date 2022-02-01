package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class LuckyMoneyF2FQRCodeUI$7
  implements SensorEventListener
{
  final int Exf;
  float Exg;
  int Exh;
  ValueAnimator Exi;
  float aCb;
  
  LuckyMoneyF2FQRCodeUI$7(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI)
  {
    AppMethodBeat.i(65070);
    this.Exf = 3;
    this.Exg = a.aY(MMApplicationContext.getContext(), a.d.MiddlePadding);
    AppMethodBeat.o(65070);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    AppMethodBeat.i(65072);
    Log.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
    AppMethodBeat.o(65072);
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = -3.0F;
    AppMethodBeat.i(65071);
    float f2;
    if (paramSensorEvent.sensor.getType() == 1)
    {
      if (LuckyMoneyF2FQRCodeUI.h(this.Exb) <= 0)
      {
        AppMethodBeat.o(65071);
        return;
      }
      if (this.Exh == 0) {
        this.Exh = (h.ew(this.Exb) + (int)this.Exg);
      }
      f2 = paramSensorEvent.values[1];
      if (Math.abs(f2 - this.aCb) < 0.05D)
      {
        AppMethodBeat.o(65071);
        return;
      }
      this.aCb = f2;
      Log.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[] { Float.valueOf(f2) });
      if (f2 >= -3.0F) {
        break label246;
      }
    }
    for (;;)
    {
      f1 = f1 / 3.0F * this.Exh + this.Exh;
      Log.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(LuckyMoneyF2FQRCodeUI.O(this.Exb).getPaddingTop()) });
      if (this.Exi != null) {
        this.Exi.cancel();
      }
      this.Exi = ValueAnimator.ofFloat(new float[] { LuckyMoneyF2FQRCodeUI.O(this.Exb).getPaddingTop(), f1 }).setDuration(200L);
      this.Exi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(65069);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.7.this.Exb).setPadding(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.7.this.Exb).getPaddingLeft(), (int)f, LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.7.this.Exb).getPaddingRight(), LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.7.this.Exb).getPaddingBottom());
          f /= LuckyMoneyF2FQRCodeUI.7.this.Exh;
          if (f <= 1.0F)
          {
            LuckyMoneyF2FQRCodeUI.Q(LuckyMoneyF2FQRCodeUI.7.this.Exb).setAlpha(1.0F - f + LuckyMoneyF2FQRCodeUI.P(LuckyMoneyF2FQRCodeUI.7.this.Exb));
            LuckyMoneyF2FQRCodeUI.R(LuckyMoneyF2FQRCodeUI.7.this.Exb).setAlpha(f * LuckyMoneyF2FQRCodeUI.P(LuckyMoneyF2FQRCodeUI.7.this.Exb));
            AppMethodBeat.o(65069);
            return;
          }
          LuckyMoneyF2FQRCodeUI.Q(LuckyMoneyF2FQRCodeUI.7.this.Exb).setAlpha(LuckyMoneyF2FQRCodeUI.P(LuckyMoneyF2FQRCodeUI.7.this.Exb));
          LuckyMoneyF2FQRCodeUI.R(LuckyMoneyF2FQRCodeUI.7.this.Exb).setAlpha(LuckyMoneyF2FQRCodeUI.P(LuckyMoneyF2FQRCodeUI.7.this.Exb));
          AppMethodBeat.o(65069);
        }
      });
      this.Exi.start();
      AppMethodBeat.o(65071);
      return;
      label246:
      if (f2 > 0.0F) {
        f1 = 0.0F;
      } else {
        f1 = f2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.7
 * JD-Core Version:    0.7.0.1
 */