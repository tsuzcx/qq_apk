package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class JsApiChooseImage$a$1
  implements DialogInterface.OnCancelListener
{
  JsApiChooseImage$a$1(JsApiChooseImage.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(131135);
    this.hQM.hQJ.bpE = 0;
    JsApiChooseImage.a.a(this.hQM, this.hQM.hQJ);
    AppMethodBeat.o(131135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.1
 * JD-Core Version:    0.7.0.1
 */