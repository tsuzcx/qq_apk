package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4$1
  implements DialogInterface.OnClickListener
{
  JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4$1(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(131307);
    ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
    JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.c(this.hSy.hSw).cancel();
    this.hSy.hSw.hSr = 1;
    this.hSy.hSw.hSs = 1;
    AppBrandMainProcessService.a(this.hSy.hSw);
    AppMethodBeat.o(131307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.1
 * JD-Core Version:    0.7.0.1
 */