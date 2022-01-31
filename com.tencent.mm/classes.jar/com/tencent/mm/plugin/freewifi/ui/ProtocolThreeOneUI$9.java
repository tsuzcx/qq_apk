package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeOneUI$9
  implements DialogInterface.OnCancelListener
{
  ProtocolThreeOneUI$9(ProtocolThreeOneUI paramProtocolThreeOneUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    d.a(this.kti.ssid, 4, this.kti.getIntent());
    y.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { m.B(this.kti.getIntent()), Integer.valueOf(m.C(this.kti.getIntent())), Integer.valueOf(4) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.9
 * JD-Core Version:    0.7.0.1
 */