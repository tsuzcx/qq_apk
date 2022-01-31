package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeTwoUI$3
  implements DialogInterface.OnCancelListener
{
  ProtocolThreeTwoUI$3(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    d.a(this.kto.ssid, 4, this.kto.getIntent());
    y.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { m.B(this.kto.getIntent()), Integer.valueOf(m.C(this.kto.getIntent())), Integer.valueOf(4) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.3
 * JD-Core Version:    0.7.0.1
 */