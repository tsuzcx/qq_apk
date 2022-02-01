package com.tencent.liteapp.ui;

import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaLiteAppUI$2
  implements Runnable
{
  WxaLiteAppUI$2(WxaLiteAppUI paramWxaLiteAppUI, long paramLong, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(219140);
    Vibrator localVibrator = (Vibrator)this.eht.getSystemService("vibrator");
    if (localVibrator == null)
    {
      AppMethodBeat.o(219140);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (localVibrator.hasAmplitudeControl()))
    {
      localVibrator.vibrate(VibrationEffect.createOneShot(this.ehu, this.ehv));
      AppMethodBeat.o(219140);
      return;
    }
    localVibrator.vibrate(this.ehu);
    AppMethodBeat.o(219140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppUI.2
 * JD-Core Version:    0.7.0.1
 */