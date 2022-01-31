package com.tencent.mm.plugin.appbrand.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandProcessProxyUI$4
  implements DialogInterface.OnKeyListener
{
  AppBrandProcessProxyUI$4(AppBrandProcessProxyUI paramAppBrandProcessProxyUI, String paramString) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(73127);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      if (!bo.isNullOrNil(this.hwf))
      {
        AppBrandProcessProxyUI.b(this.hwg).onClick(AppBrandProcessProxyUI.a(this.hwg), -3);
        paramDialogInterface.dismiss();
      }
      this.hwg.a(null);
    }
    AppMethodBeat.o(73127);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.4
 * JD-Core Version:    0.7.0.1
 */