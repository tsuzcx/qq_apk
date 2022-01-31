package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandProxyTransparentUI$1
  implements AppBrandProxyTransparentUIProcessTask.a
{
  AppBrandProxyTransparentUI$1(AppBrandProxyTransparentUI paramAppBrandProxyTransparentUI, AppBrandProxyTransparentUIProcessTask paramAppBrandProxyTransparentUIProcessTask, String paramString) {}
  
  public final void ahB()
  {
    y.i("MicroMsg.AppBrandProxyTransparentUI", "onResult");
    Intent localIntent = new Intent();
    localIntent.putExtra("task_object", this.gej);
    localIntent.putExtra("task_id", this.gek);
    this.gel.setResult(-1, localIntent);
    this.gel.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUI.1
 * JD-Core Version:    0.7.0.1
 */