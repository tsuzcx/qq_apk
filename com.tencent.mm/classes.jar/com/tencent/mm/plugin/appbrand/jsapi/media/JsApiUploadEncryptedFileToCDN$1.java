package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class JsApiUploadEncryptedFileToCDN$1
  implements Runnable
{
  JsApiUploadEncryptedFileToCDN$1(JsApiUploadEncryptedFileToCDN paramJsApiUploadEncryptedFileToCDN, JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask paramJsApiUploadEncryptedMediaFileTask, c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(131301);
    HashMap localHashMap = new HashMap();
    localHashMap.put("fileId", this.hSn.fileId);
    localHashMap.put("aesKey", this.hSn.ewj);
    localHashMap.put("fileUrl", this.hSn.fileUrl);
    localHashMap.put("fileLength", this.hSn.gVW);
    ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[] { this.hSn.fileId });
    if (bo.isNullOrNil(this.hSn.fileId))
    {
      ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
      this.hxW.h(this.bAX, this.hSo.j("fail", null));
    }
    for (;;)
    {
      this.hSn.aBk();
      AppMethodBeat.o(131301);
      return;
      ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
      this.hxW.h(this.bAX, this.hSo.j("ok", localHashMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.1
 * JD-Core Version:    0.7.0.1
 */