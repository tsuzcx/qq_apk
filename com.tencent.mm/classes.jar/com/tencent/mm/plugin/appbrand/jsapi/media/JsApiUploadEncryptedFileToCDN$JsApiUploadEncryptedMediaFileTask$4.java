package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4
  implements DialogInterface.OnKeyListener
{
  JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask paramJsApiUploadEncryptedMediaFileTask) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131309);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      if ((!TextUtils.isEmpty(this.hSw.mimeType)) && (this.hSw.mimeType.contains("video"))) {}
      for (paramDialogInterface = this.hSw.hSt.getString(2131297157);; paramDialogInterface = this.hSw.hSt.getString(2131297151))
      {
        h.a(this.hSw.hSt, true, this.hSw.hSt.getString(2131297152, new Object[] { paramDialogInterface }), "", this.hSw.hSt.getString(2131297154), this.hSw.hSt.getString(2131297155), new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.1(this), new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.2(this));
        AppMethodBeat.o(131309);
        return true;
      }
    }
    AppMethodBeat.o(131309);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4
 * JD-Core Version:    0.7.0.1
 */