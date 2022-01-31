package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.network.ac;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class JsApiUploadEncryptedFileToCDN
  extends a
{
  public static final int CTRL_INDEX = 194;
  public static final String NAME = "uploadEncryptedFileToCDN";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131319);
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(131319);
      return;
    }
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
      paramc.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(131319);
      return;
    }
    String str1 = paramc.getAppId();
    String str2 = paramJSONObject.optString("tempFilePath");
    boolean bool = paramJSONObject.optBoolean("isShowProgressTips", false);
    ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", new Object[] { str1, paramJSONObject.toString() });
    if (bo.isNullOrNil(str2))
    {
      ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
      paramc.h(paramInt, j("fail:tempFilePath is null", null));
      AppMethodBeat.o(131319);
      return;
    }
    AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.bw(str1, str2);
    if (localAppBrandLocalMediaObject == null)
    {
      ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
      paramc.h(paramInt, j("fail:file doesn't exist", null));
      AppMethodBeat.o(131319);
      return;
    }
    if (TextUtils.isEmpty(localAppBrandLocalMediaObject.fod))
    {
      ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
      paramc.h(paramInt, j("fail:fileFullPath is null", null));
      AppMethodBeat.o(131319);
      return;
    }
    JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask localJsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask();
    localJsApiUploadEncryptedMediaFileTask.appId = str1;
    localJsApiUploadEncryptedMediaFileTask.ctV = str2;
    localJsApiUploadEncryptedMediaFileTask.hSp = bool;
    localJsApiUploadEncryptedMediaFileTask.hSt = ((Activity)localContext);
    localJsApiUploadEncryptedMediaFileTask.hyO = paramc;
    localJsApiUploadEncryptedMediaFileTask.mimeType = localAppBrandLocalMediaObject.mimeType;
    localJsApiUploadEncryptedMediaFileTask.hxp = new JsApiUploadEncryptedFileToCDN.1(this, localJsApiUploadEncryptedMediaFileTask, paramc, paramInt);
    if (!ac.cm(localContext))
    {
      ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
      if ((!TextUtils.isEmpty(localAppBrandLocalMediaObject.mimeType)) && (localAppBrandLocalMediaObject.mimeType.contains("video"))) {}
      for (paramJSONObject = localContext.getString(2131297157);; paramJSONObject = localContext.getString(2131297151))
      {
        h.a(localContext, localContext.getString(2131297153, new Object[] { paramJSONObject, bo.nV(e.cM(localAppBrandLocalMediaObject.fod)) }), localContext.getString(2131297087), new JsApiUploadEncryptedFileToCDN.2(this, localJsApiUploadEncryptedMediaFileTask), new JsApiUploadEncryptedFileToCDN.3(this, paramc, paramInt, localJsApiUploadEncryptedMediaFileTask));
        AppMethodBeat.o(131319);
        return;
      }
    }
    ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
    localJsApiUploadEncryptedMediaFileTask.aBj();
    AppBrandMainProcessService.a(localJsApiUploadEncryptedMediaFileTask);
    AppMethodBeat.o(131319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN
 * JD-Core Version:    0.7.0.1
 */