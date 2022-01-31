package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class FreeWifiFrontPageUI$9
  implements DialogInterface.OnCancelListener
{
  FreeWifiFrontPageUI$9(FreeWifiFrontPageUI paramFreeWifiFrontPageUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(20967);
    d.a(this.mND.ssid, 4, this.mND.getIntent());
    ab.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { m.U(this.mND.getIntent()), Integer.valueOf(m.V(this.mND.getIntent())), Integer.valueOf(4) });
    AppMethodBeat.o(20967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.9
 * JD-Core Version:    0.7.0.1
 */