package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiChooseMedia$a$3
  implements DialogInterface.OnCancelListener
{
  JsApiChooseMedia$a$3(JsApiChooseMedia.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(131170);
    ab.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
    JsApiChooseMedia.a.e(this.hRe).bpE = 0;
    JsApiChooseMedia.a.a(this.hRe, JsApiChooseMedia.a.e(this.hRe));
    AppMethodBeat.o(131170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.3
 * JD-Core Version:    0.7.0.1
 */