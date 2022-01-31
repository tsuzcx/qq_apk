package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandAuthorizeUI$2
  implements DialogInterface.OnClickListener
{
  AppBrandAuthorizeUI$2(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, ep paramep) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.hcv.state = 2;
    y.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state close");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.2
 * JD-Core Version:    0.7.0.1
 */