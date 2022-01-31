package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiUploadEncryptedFileToCDN$3
  implements DialogInterface.OnClickListener
{
  JsApiUploadEncryptedFileToCDN$3(JsApiUploadEncryptedFileToCDN paramJsApiUploadEncryptedFileToCDN, c paramc, int paramInt, JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask paramJsApiUploadEncryptedMediaFileTask) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
    this.ggH.C(this.dIS, this.gwt.h("cancel", null));
    this.gws.ahD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.3
 * JD-Core Version:    0.7.0.1
 */