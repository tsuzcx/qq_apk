package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;

final class FreeWifiNetCheckUI$1
  extends ah
{
  int i = 0;
  
  FreeWifiNetCheckUI$1(FreeWifiNetCheckUI paramFreeWifiNetCheckUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (this.i >= FreeWifiNetCheckUI.a(this.ksx).length) {
        this.i = 0;
      }
      this.ksx.ksi.setImageResource(FreeWifiNetCheckUI.a(this.ksx)[this.i]);
      this.i += 1;
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (paramMessage.what == 2) {
        this.ksx.ksi.setImageResource(FreeWifiNetCheckUI.a(this.ksx)[(FreeWifiNetCheckUI.a(this.ksx).length - 1)]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.1
 * JD-Core Version:    0.7.0.1
 */