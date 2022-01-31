package com.tencent.mm.plugin.appbrand.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$3$3
  implements DialogInterface.OnCancelListener
{
  c$3$3(c.3 param3) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    c.anJ().B(c.a(this.gWM.gWJ), c.b(this.gWM.gWJ));
    y.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user cancel, appId %s, api %s", new Object[] { c.a(this.gWM.gWJ), c.b(this.gWM.gWJ) });
    c.c(this.gWM.gWJ).onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c.3.3
 * JD-Core Version:    0.7.0.1
 */