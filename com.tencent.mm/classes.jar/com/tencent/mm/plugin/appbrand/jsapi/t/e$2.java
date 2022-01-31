package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements DialogInterface.OnCancelListener
{
  e$2(e parame) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((this.gGA.gGt != null) && (e.h(this.gGA) != null)) {}
    try
    {
      e.h(this.gGA).SU(this.gGA.gGt.riI);
      this.gGA.gGt.ccQ();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cancel capture failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.2
 * JD-Core Version:    0.7.0.1
 */