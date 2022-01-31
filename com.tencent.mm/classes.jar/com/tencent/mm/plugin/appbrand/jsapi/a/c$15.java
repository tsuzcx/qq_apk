package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

final class c$15
  implements DialogInterface.OnClickListener
{
  c$15(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.JsApiGetPhoneNumber", "confirm bind phone number");
    paramDialogInterface.dismiss();
    paramDialogInterface = this.gkx;
    y.i("MicroMsg.JsApiGetPhoneNumber", "doBindPhoneNumber()");
    Intent localIntent = new Intent(paramDialogInterface.gkh.mContext, AppBrandRedirectUI.class);
    localIntent.putExtra("key_from_scene", 0);
    MMActivity localMMActivity = (MMActivity)paramDialogInterface.gkh.mContext;
    localMMActivity.gJb = new c.8(paramDialogInterface, localMMActivity);
    localMMActivity.startActivityForResult(localIntent, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.15
 * JD-Core Version:    0.7.0.1
 */