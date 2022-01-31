package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class FreeWifiManufacturerLoadingUI$1
  extends ak
{
  int i = 0;
  
  FreeWifiManufacturerLoadingUI$1(FreeWifiManufacturerLoadingUI paramFreeWifiManufacturerLoadingUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(21008);
    if (paramMessage.what == 1)
    {
      if (this.i >= FreeWifiManufacturerLoadingUI.a(this.mOf).length) {
        this.i = 0;
      }
      FreeWifiManufacturerLoadingUI.b(this.mOf).setImageResource(FreeWifiManufacturerLoadingUI.a(this.mOf)[this.i]);
      this.i += 1;
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      AppMethodBeat.o(21008);
      return;
      if (paramMessage.what == 2) {
        FreeWifiManufacturerLoadingUI.b(this.mOf).setImageResource(FreeWifiManufacturerLoadingUI.a(this.mOf)[(FreeWifiManufacturerLoadingUI.a(this.mOf).length - 1)]);
      } else if ((paramMessage.what == 3) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {
        FreeWifiManufacturerLoadingUI.c(this.mOf).setText(paramMessage.obj.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.1
 * JD-Core Version:    0.7.0.1
 */