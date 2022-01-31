package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$4
  implements DialogInterface.OnCancelListener
{
  a$4(a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(137888);
    ab.i("MicroMsg.HCEActivityMgr", "alvinluo cancel by pressing back");
    a.a(this.hUN, "system NFC switch not opened");
    AppMethodBeat.o(137888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.4
 * JD-Core Version:    0.7.0.1
 */