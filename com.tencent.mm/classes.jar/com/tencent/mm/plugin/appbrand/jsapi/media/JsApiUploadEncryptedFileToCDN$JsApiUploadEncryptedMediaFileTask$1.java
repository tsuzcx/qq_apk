package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.c.d.a;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$1
  implements d.a
{
  JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$1(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask paramJsApiUploadEncryptedMediaFileTask) {}
  
  public final void z(int paramInt, String paramString)
  {
    y.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.gwB.gwv = paramInt;
    this.gwB.gwx = 3;
    JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.a(this.gwB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.1
 * JD-Core Version:    0.7.0.1
 */