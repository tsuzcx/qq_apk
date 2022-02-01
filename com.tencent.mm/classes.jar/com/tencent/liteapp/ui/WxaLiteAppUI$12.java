package com.tencent.liteapp.ui;

import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaLiteAppUI$12
  implements Runnable
{
  WxaLiteAppUI$12(WxaLiteAppUI paramWxaLiteAppUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(219133);
    Vibrator localVibrator = (Vibrator)this.eht.getSystemService("vibrator");
    if (localVibrator == null)
    {
      AppMethodBeat.o(219133);
      return;
    }
    localVibrator.vibrate(this.ehu);
    AppMethodBeat.o(219133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppUI.12
 * JD-Core Version:    0.7.0.1
 */