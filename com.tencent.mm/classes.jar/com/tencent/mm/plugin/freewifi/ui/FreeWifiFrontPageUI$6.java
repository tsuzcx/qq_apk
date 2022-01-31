package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiFrontPageUI$6
  implements DialogInterface.OnCancelListener
{
  FreeWifiFrontPageUI$6(FreeWifiFrontPageUI paramFreeWifiFrontPageUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    d.a(this.krP.ssid, 4, this.krP.getIntent());
    y.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { m.B(this.krP.getIntent()), Integer.valueOf(m.C(this.krP.getIntent())), Integer.valueOf(4) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.6
 * JD-Core Version:    0.7.0.1
 */