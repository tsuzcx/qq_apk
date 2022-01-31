package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4
  implements DialogInterface.OnKeyListener
{
  JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask paramJsApiUploadEncryptedMediaFileTask) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      if ((!TextUtils.isEmpty(this.gwB.mimeType)) && (this.gwB.mimeType.contains("video"))) {}
      for (paramDialogInterface = this.gwB.gwy.getString(y.j.appbrand_jssdk_video);; paramDialogInterface = this.gwB.gwy.getString(y.j.appbrand_jssdk_image))
      {
        h.a(this.gwB.gwy, true, this.gwB.gwy.getString(y.j.appbrand_jssdk_media_file_uploading_tips, new Object[] { paramDialogInterface }), "", this.gwB.gwy.getString(y.j.appbrand_jssdk_upload_video_cancel), this.gwB.gwy.getString(y.j.appbrand_jssdk_upload_video_continue), new DialogInterface.OnClickListener()new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.2
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.c(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.this.gwB).cancel();
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.this.gwB.gww = 1;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.this.gwB.gwx = 1;
            AppBrandMainProcessService.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.this.gwB);
          }
        }, new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.2(this));
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4
 * JD-Core Version:    0.7.0.1
 */