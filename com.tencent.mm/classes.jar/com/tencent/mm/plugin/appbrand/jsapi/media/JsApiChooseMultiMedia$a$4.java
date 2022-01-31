package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiChooseMultiMedia$a$4
  implements DialogInterface.OnCancelListener
{
  JsApiChooseMultiMedia$a$4(JsApiChooseMultiMedia.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(131233);
    ab.e("MicroMsg.JsApiChooseMultiMedia", "cancel show the progress dialog and finish progress");
    this.hRC.hRz.bpE = 0;
    JsApiChooseMultiMedia.a.h(this.hRC, this.hRC.hRz);
    AppMethodBeat.o(131233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.a.4
 * JD-Core Version:    0.7.0.1
 */