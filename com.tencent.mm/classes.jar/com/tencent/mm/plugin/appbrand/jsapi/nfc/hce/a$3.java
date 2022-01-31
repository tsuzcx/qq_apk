package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class a$3
  implements DialogInterface.OnClickListener
{
  a$3(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.HCEActivityMgr", "alvinluo user click cancel button of NFC tips dialog.");
    a.a(this.gyo, "system NFC switch not opened");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.3
 * JD-Core Version:    0.7.0.1
 */