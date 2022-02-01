package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.i;

final class FingerPrintAuthUI$6
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthUI$6(FingerPrintAuthUI paramFingerPrintAuthUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(64528);
    a.b(this.HgZ, new Bundle(), this.val$errCode);
    i.bC(this.HgZ, "https://kf.qq.com/touch/sappfaq/210406zmIFbI210406FFnEnI.html");
    AppMethodBeat.o(64528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.6
 * JD-Core Version:    0.7.0.1
 */