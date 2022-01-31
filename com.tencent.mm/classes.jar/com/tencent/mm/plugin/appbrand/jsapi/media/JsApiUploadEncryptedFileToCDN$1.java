package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class JsApiUploadEncryptedFileToCDN$1
  implements Runnable
{
  JsApiUploadEncryptedFileToCDN$1(JsApiUploadEncryptedFileToCDN paramJsApiUploadEncryptedFileToCDN, JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask paramJsApiUploadEncryptedMediaFileTask, c paramc, int paramInt) {}
  
  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fileId", this.gws.fileId);
    localHashMap.put("aesKey", this.gws.dQR);
    localHashMap.put("fileUrl", this.gws.fileUrl);
    localHashMap.put("fileLength", this.gws.fDG);
    y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[] { this.gws.fileId });
    if (bk.bl(this.gws.fileId))
    {
      y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
      this.ggH.C(this.dIS, this.gwt.h("fail", null));
    }
    for (;;)
    {
      this.gws.ahD();
      return;
      y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
      this.ggH.C(this.dIS, this.gwt.h("ok", localHashMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.1
 * JD-Core Version:    0.7.0.1
 */