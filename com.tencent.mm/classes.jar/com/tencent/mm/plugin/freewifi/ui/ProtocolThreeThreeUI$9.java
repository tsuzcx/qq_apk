package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class ProtocolThreeThreeUI$9
  implements DialogInterface.OnCancelListener
{
  ProtocolThreeThreeUI$9(ProtocolThreeThreeUI paramProtocolThreeThreeUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    d.a(this.ktl.ssid, 4, this.ktl.getIntent());
    y.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { m.B(this.ktl.getIntent()), Integer.valueOf(m.C(this.ktl.getIntent())), Integer.valueOf(4) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.9
 * JD-Core Version:    0.7.0.1
 */