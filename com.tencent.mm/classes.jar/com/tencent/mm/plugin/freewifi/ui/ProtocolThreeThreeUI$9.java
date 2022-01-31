package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class ProtocolThreeThreeUI$9
  implements DialogInterface.OnCancelListener
{
  ProtocolThreeThreeUI$9(ProtocolThreeThreeUI paramProtocolThreeThreeUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(21159);
    d.a(this.mOZ.ssid, 4, this.mOZ.getIntent());
    ab.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[] { m.U(this.mOZ.getIntent()), Integer.valueOf(m.V(this.mOZ.getIntent())), Integer.valueOf(4) });
    AppMethodBeat.o(21159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.9
 * JD-Core Version:    0.7.0.1
 */