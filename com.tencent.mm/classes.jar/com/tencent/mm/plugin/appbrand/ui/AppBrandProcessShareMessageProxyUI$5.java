package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandProcessShareMessageProxyUI$5
  implements DialogInterface.OnKeyListener
{
  AppBrandProcessShareMessageProxyUI$5(AppBrandProcessShareMessageProxyUI paramAppBrandProcessShareMessageProxyUI, AppBrandProcessShareMessageProxyUI.c paramc) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(133013);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      this.iNj.f(false, null, 0);
      paramDialogInterface.dismiss();
    }
    AppMethodBeat.o(133013);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.5
 * JD-Core Version:    0.7.0.1
 */