package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c.d.a;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$1
  implements d.a
{
  JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$1(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask paramJsApiUploadEncryptedMediaFileTask) {}
  
  public final void M(int paramInt, String paramString)
  {
    AppMethodBeat.i(131304);
    ab.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.hSw.hSq = paramInt;
    this.hSw.hSs = 3;
    JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.a(this.hSw);
    AppMethodBeat.o(131304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.1
 * JD-Core Version:    0.7.0.1
 */