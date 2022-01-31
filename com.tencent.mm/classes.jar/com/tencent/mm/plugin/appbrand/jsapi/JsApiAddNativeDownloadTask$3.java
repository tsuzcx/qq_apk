package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.y.j;

final class JsApiAddNativeDownloadTask$3
  implements Runnable
{
  JsApiAddNativeDownloadTask$3(JsApiAddNativeDownloadTask paramJsApiAddNativeDownloadTask, Context paramContext) {}
  
  public final void run()
  {
    Toast.makeText(this.val$context, this.val$context.getString(y.j.game_download_not_enough_space), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.3
 * JD-Core Version:    0.7.0.1
 */