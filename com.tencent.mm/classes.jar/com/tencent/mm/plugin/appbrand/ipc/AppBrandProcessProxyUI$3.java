package com.tencent.mm.plugin.appbrand.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.bk;

final class AppBrandProcessProxyUI$3
  implements DialogInterface.OnKeyListener
{
  AppBrandProcessProxyUI$3(AppBrandProcessProxyUI paramAppBrandProcessProxyUI, String paramString) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      if (!bk.bl(this.gef))
      {
        AppBrandProcessProxyUI.b(this.geg).onClick(AppBrandProcessProxyUI.a(this.geg), -3);
        paramDialogInterface.dismiss();
      }
      this.geg.a(null);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.3
 * JD-Core Version:    0.7.0.1
 */