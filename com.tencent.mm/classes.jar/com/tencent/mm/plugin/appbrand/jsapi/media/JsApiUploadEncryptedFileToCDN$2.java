package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiUploadEncryptedFileToCDN$2
  implements DialogInterface.OnClickListener
{
  JsApiUploadEncryptedFileToCDN$2(JsApiUploadEncryptedFileToCDN paramJsApiUploadEncryptedFileToCDN, JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask paramJsApiUploadEncryptedMediaFileTask) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(131302);
    ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
    this.hSn.aBj();
    AppBrandMainProcessService.a(this.hSn);
    AppMethodBeat.o(131302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.2
 * JD-Core Version:    0.7.0.1
 */