package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$4
  implements DialogInterface.OnCancelListener
{
  b$4(b paramb, b.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
    this.fXX.e(3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.4
 * JD-Core Version:    0.7.0.1
 */