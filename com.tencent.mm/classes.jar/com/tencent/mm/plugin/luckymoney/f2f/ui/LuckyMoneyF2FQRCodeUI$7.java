package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class LuckyMoneyF2FQRCodeUI$7
  implements SensorEventListener
{
  float nvm;
  final int omc;
  float omd;
  int ome;
  ValueAnimator omf;
  
  LuckyMoneyF2FQRCodeUI$7(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI)
  {
    AppMethodBeat.i(42179);
    this.omc = 3;
    this.omd = a.ao(ah.getContext(), 2131427792);
    AppMethodBeat.o(42179);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    AppMethodBeat.i(42181);
    ab.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
    AppMethodBeat.o(42181);
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = -3.0F;
    AppMethodBeat.i(42180);
    float f2;
    if (paramSensorEvent.sensor.getType() == 1)
    {
      if (LuckyMoneyF2FQRCodeUI.g(this.olY) <= 0)
      {
        AppMethodBeat.o(42180);
        return;
      }
      if (this.ome == 0) {
        this.ome = (f.di(this.olY) + (int)this.omd);
      }
      f2 = paramSensorEvent.values[1];
      if (Math.abs(f2 - this.nvm) < 0.05D)
      {
        AppMethodBeat.o(42180);
        return;
      }
      this.nvm = f2;
      ab.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[] { Float.valueOf(f2) });
      if (f2 >= -3.0F) {
        break label246;
      }
    }
    for (;;)
    {
      f1 = f1 / 3.0F * this.ome + this.ome;
      ab.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(LuckyMoneyF2FQRCodeUI.N(this.olY).getPaddingTop()) });
      if (this.omf != null) {
        this.omf.cancel();
      }
      this.omf = ValueAnimator.ofFloat(new float[] { LuckyMoneyF2FQRCodeUI.N(this.olY).getPaddingTop(), f1 }).setDuration(200L);
      this.omf.addUpdateListener(new LuckyMoneyF2FQRCodeUI.7.1(this));
      this.omf.start();
      AppMethodBeat.o(42180);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.7
 * JD-Core Version:    0.7.0.1
 */