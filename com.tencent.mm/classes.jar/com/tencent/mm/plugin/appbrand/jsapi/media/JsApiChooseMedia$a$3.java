package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiChooseMedia$a$3
  implements DialogInterface.OnCancelListener
{
  JsApiChooseMedia$a$3(JsApiChooseMedia.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
    JsApiChooseMedia.a.e(this.gvN).aYY = 0;
    JsApiChooseMedia.a.a(this.gvN, JsApiChooseMedia.a.e(this.gvN));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.3
 * JD-Core Version:    0.7.0.1
 */