package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class JsApiUploadEncryptedFileToCDN
  extends a
{
  public static final int CTRL_INDEX = 194;
  public static final String NAME = "uploadEncryptedFileToCDN";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
      paramc.C(paramInt, h("fail", null));
      return;
    }
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    String str1 = paramc.getAppId();
    String str2 = paramJSONObject.optString("tempFilePath");
    boolean bool = paramJSONObject.optBoolean("isShowProgressTips", false);
    y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", new Object[] { str1, paramJSONObject.toString() });
    if (bk.bl(str2))
    {
      y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
      paramc.C(paramInt, h("fail:tempFilePath is null", null));
      return;
    }
    Object localObject = AppBrandLocalMediaObjectManager.getItemByLocalId(str1, str2);
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
      paramc.C(paramInt, h("fail:file doesn't exist", null));
      return;
    }
    if (TextUtils.isEmpty(((AppBrandLocalMediaObject)localObject).dXY))
    {
      y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
      paramc.C(paramInt, h("fail:fileFullPath is null", null));
      return;
    }
    JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask localJsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask();
    localJsApiUploadEncryptedMediaFileTask.appId = str1;
    localJsApiUploadEncryptedMediaFileTask.bMB = str2;
    localJsApiUploadEncryptedMediaFileTask.gwu = bool;
    localJsApiUploadEncryptedMediaFileTask.gwy = ((Activity)localContext);
    localJsApiUploadEncryptedMediaFileTask.ggu = paramc;
    localJsApiUploadEncryptedMediaFileTask.mimeType = ((AppBrandLocalMediaObject)localObject).mimeType;
    localJsApiUploadEncryptedMediaFileTask.gfD = new JsApiUploadEncryptedFileToCDN.1(this, localJsApiUploadEncryptedMediaFileTask, paramc, paramInt);
    if (!ab.bG(localContext))
    {
      y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
      if ((!TextUtils.isEmpty(((AppBrandLocalMediaObject)localObject).mimeType)) && (((AppBrandLocalMediaObject)localObject).mimeType.contains("video"))) {}
      for (paramJSONObject = localContext.getString(y.j.appbrand_jssdk_video);; paramJSONObject = localContext.getString(y.j.appbrand_jssdk_image))
      {
        localObject = bk.ht(e.bJ(((AppBrandLocalMediaObject)localObject).dXY));
        h.a(localContext, localContext.getString(y.j.appbrand_jssdk_upload_media_file_gprs_confirm, new Object[] { paramJSONObject, localObject }), localContext.getString(y.j.app_tip), new JsApiUploadEncryptedFileToCDN.2(this, localJsApiUploadEncryptedMediaFileTask), new JsApiUploadEncryptedFileToCDN.3(this, paramc, paramInt, localJsApiUploadEncryptedMediaFileTask));
        return;
      }
    }
    y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
    localJsApiUploadEncryptedMediaFileTask.ahC();
    AppBrandMainProcessService.a(localJsApiUploadEncryptedMediaFileTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN
 * JD-Core Version:    0.7.0.1
 */