package com.tencent.mm.plugin.appbrand.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandProcessProxyUI$a
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener
{
  private boolean hwi = false;
  
  private AppBrandProcessProxyUI$a(AppBrandProcessProxyUI paramAppBrandProcessProxyUI) {}
  
  private void nO(int paramInt)
  {
    AppMethodBeat.i(73131);
    if (this.hwi)
    {
      AppMethodBeat.o(73131);
      return;
    }
    this.hwi = true;
    ResultReceiver localResultReceiver = (ResultReceiver)this.hwg.getIntent().getParcelableExtra("key_result_receiver");
    if (localResultReceiver != null) {
      localResultReceiver.send(paramInt, null);
    }
    AppMethodBeat.o(73131);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(73129);
    nO(paramInt);
    AppMethodBeat.o(73129);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(73130);
    nO(-2);
    this.hwg.a(null);
    AppMethodBeat.o(73130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.a
 * JD-Core Version:    0.7.0.1
 */