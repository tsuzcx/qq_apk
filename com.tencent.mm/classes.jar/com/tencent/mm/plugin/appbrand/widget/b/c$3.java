package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$3
  implements DialogInterface.OnCancelListener
{
  c$3(c paramc, c.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
    this.hsr.e(3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.c.3
 * JD-Core Version:    0.7.0.1
 */