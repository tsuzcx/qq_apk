package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;

final class e$2
  implements DialogInterface.OnCancelListener
{
  e$2(e parame) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(17028);
    if ((this.ihi.iha != null) && (e.i(this.ihi) != null)) {
      try
      {
        e.i(this.ihi).ahW(this.ihi.iha.uYi);
        this.ihi.iha.dcJ();
        AppMethodBeat.o(17028);
        return;
      }
      catch (Exception paramDialogInterface)
      {
        ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cancel capture failed");
      }
    }
    AppMethodBeat.o(17028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e.2
 * JD-Core Version:    0.7.0.1
 */