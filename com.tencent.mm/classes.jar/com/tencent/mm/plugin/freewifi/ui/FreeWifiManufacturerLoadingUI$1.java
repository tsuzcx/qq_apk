package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;

final class FreeWifiManufacturerLoadingUI$1
  extends ah
{
  int i = 0;
  
  FreeWifiManufacturerLoadingUI$1(FreeWifiManufacturerLoadingUI paramFreeWifiManufacturerLoadingUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (this.i >= FreeWifiManufacturerLoadingUI.a(this.ksr).length) {
        this.i = 0;
      }
      FreeWifiManufacturerLoadingUI.b(this.ksr).setImageResource(FreeWifiManufacturerLoadingUI.a(this.ksr)[this.i]);
      this.i += 1;
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (paramMessage.what == 2) {
        FreeWifiManufacturerLoadingUI.b(this.ksr).setImageResource(FreeWifiManufacturerLoadingUI.a(this.ksr)[(FreeWifiManufacturerLoadingUI.a(this.ksr).length - 1)]);
      } else if ((paramMessage.what == 3) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {
        FreeWifiManufacturerLoadingUI.c(this.ksr).setText(paramMessage.obj.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.1
 * JD-Core Version:    0.7.0.1
 */