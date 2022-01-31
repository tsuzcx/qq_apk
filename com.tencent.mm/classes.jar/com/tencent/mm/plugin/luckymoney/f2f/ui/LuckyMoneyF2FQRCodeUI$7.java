package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class LuckyMoneyF2FQRCodeUI$7
  implements SensorEventListener
{
  float hZz;
  final int lOI = 3;
  float lOJ = a.aa(ae.getContext(), a.d.MiddlePadding);
  int lOK;
  ValueAnimator lOL;
  
  LuckyMoneyF2FQRCodeUI$7(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    y.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = -3.0F;
    if ((paramSensorEvent.sensor.getType() != 1) || (LuckyMoneyF2FQRCodeUI.g(this.lOE) <= 0)) {}
    float f2;
    do
    {
      return;
      if (this.lOK == 0) {
        this.lOK = (e.cD(this.lOE) + (int)this.lOJ);
      }
      f2 = paramSensorEvent.values[1];
    } while (Math.abs(f2 - this.hZz) < 0.05D);
    this.hZz = f2;
    y.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[] { Float.valueOf(f2) });
    if (f2 < -3.0F) {}
    for (;;)
    {
      f1 = f1 / 3.0F * this.lOK + this.lOK;
      y.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(LuckyMoneyF2FQRCodeUI.N(this.lOE).getPaddingTop()) });
      if (this.lOL != null) {
        this.lOL.cancel();
      }
      this.lOL = ValueAnimator.ofFloat(new float[] { LuckyMoneyF2FQRCodeUI.N(this.lOE).getPaddingTop(), f1 }).setDuration(200L);
      this.lOL.addUpdateListener(new LuckyMoneyF2FQRCodeUI.7.1(this));
      this.lOL.start();
      return;
      if (f2 > 0.0F) {
        f1 = 0.0F;
      } else {
        f1 = f2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.7
 * JD-Core Version:    0.7.0.1
 */