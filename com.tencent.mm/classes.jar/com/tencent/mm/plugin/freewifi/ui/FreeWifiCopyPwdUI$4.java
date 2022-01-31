package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class FreeWifiCopyPwdUI$4
  extends ak
{
  FreeWifiCopyPwdUI$4(FreeWifiCopyPwdUI paramFreeWifiCopyPwdUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(20939);
    paramMessage = (FreeWifiCopyPwdUI.b)paramMessage.obj;
    if (paramMessage.mNj == FreeWifiCopyPwdUI.b(this.mNe))
    {
      FreeWifiCopyPwdUI.a(this.mNe, paramMessage.data);
      AppMethodBeat.o(20939);
      return;
    }
    FreeWifiCopyPwdUI.b(this.mNe, paramMessage.data);
    AppMethodBeat.o(20939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.4
 * JD-Core Version:    0.7.0.1
 */