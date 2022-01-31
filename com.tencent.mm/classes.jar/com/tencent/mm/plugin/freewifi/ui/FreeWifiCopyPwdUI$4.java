package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class FreeWifiCopyPwdUI$4
  extends ah
{
  FreeWifiCopyPwdUI$4(FreeWifiCopyPwdUI paramFreeWifiCopyPwdUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    paramMessage = (FreeWifiCopyPwdUI.b)paramMessage.obj;
    if (paramMessage.krv == FreeWifiCopyPwdUI.b(this.krr))
    {
      FreeWifiCopyPwdUI.a(this.krr, paramMessage.data);
      return;
    }
    FreeWifiCopyPwdUI.b(this.krr, paramMessage.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.4
 * JD-Core Version:    0.7.0.1
 */