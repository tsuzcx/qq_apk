package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.c.a;
import com.tencent.mm.plugin.appbrand.c.a.a;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.c.c;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$2
  implements d.b
{
  JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$2(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask paramJsApiUploadEncryptedMediaFileTask, AppBrandLocalMediaObject paramAppBrandLocalMediaObject) {}
  
  public final void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131305);
    ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramBoolean), paramString2, paramString1, paramString3 });
    if ((!bo.isNullOrNil(paramString1)) && (paramString1.equals(this.hSx.ctV)))
    {
      g.auP().a(this.hSw.hSu);
      g.auP().a(this.hSw.hSv);
      g.auP();
      b.zE(this.hSx.ctV);
      if (paramBoolean) {
        break label267;
      }
      ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
      paramString1 = g.auO();
      paramString2 = this.hSw.fileId;
      if (!bo.isNullOrNil(paramString2)) {
        break label285;
      }
      ab.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
      label134:
      break label299;
      label135:
      paramString1 = null;
      label137:
      if ((paramString1 == null) || (paramString1.hgl == null)) {
        break label337;
      }
      ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
      this.hSw.ewj = paramString1.hgl.field_aesKey;
      this.hSw.fileId = paramString1.hgl.field_fileId;
      this.hSw.fileUrl = paramString1.hgl.field_fileUrl;
      this.hSw.gVW = paramString1.hgl.field_fileLength;
      ab.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[] { this.hSw.ewj, Integer.valueOf(this.hSw.gVW) });
    }
    for (;;)
    {
      this.hSw.hSs = 1;
      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.b(this.hSw);
      AppMethodBeat.o(131305);
      return;
      label267:
      this.hSw.fileId = paramString2;
      ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
      break;
      label285:
      paramString3 = paramString1.hgu.values().iterator();
      label299:
      if (!paramString3.hasNext()) {
        break label135;
      }
      paramString1 = (a)paramString3.next();
      if (!bo.nullAsNil(paramString1.hgk).equals(paramString2)) {
        break label134;
      }
      break label137;
      label337:
      ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.2
 * JD-Core Version:    0.7.0.1
 */