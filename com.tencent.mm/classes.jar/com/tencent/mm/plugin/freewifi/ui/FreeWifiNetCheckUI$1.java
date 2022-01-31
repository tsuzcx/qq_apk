package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class FreeWifiNetCheckUI$1
  extends ak
{
  int i = 0;
  
  FreeWifiNetCheckUI$1(FreeWifiNetCheckUI paramFreeWifiNetCheckUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(21034);
    if (paramMessage.what == 1)
    {
      if (this.i >= FreeWifiNetCheckUI.a(this.mOl).length) {
        this.i = 0;
      }
      this.mOl.mNW.setImageResource(FreeWifiNetCheckUI.a(this.mOl)[this.i]);
      this.i += 1;
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      AppMethodBeat.o(21034);
      return;
      if (paramMessage.what == 2) {
        this.mOl.mNW.setImageResource(FreeWifiNetCheckUI.a(this.mOl)[(FreeWifiNetCheckUI.a(this.mOl).length - 1)]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.1
 * JD-Core Version:    0.7.0.1
 */