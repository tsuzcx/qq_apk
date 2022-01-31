package com.tencent.mm.plugin.account.security.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.f;

final class MySafeDeviceListUI$3
  extends ah
{
  MySafeDeviceListUI$3(MySafeDeviceListUI paramMySafeDeviceListUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    MySafeDeviceListUI.b(this.fkm).notifyDataSetChanged();
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.MySafeDeviceListUI.3
 * JD-Core Version:    0.7.0.1
 */