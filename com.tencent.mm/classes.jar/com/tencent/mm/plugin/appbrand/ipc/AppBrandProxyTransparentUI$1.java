package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandProxyTransparentUI$1
  implements AppBrandProxyTransparentUIProcessTask.a
{
  AppBrandProxyTransparentUI$1(AppBrandProxyTransparentUI paramAppBrandProxyTransparentUI, AppBrandProxyTransparentUIProcessTask paramAppBrandProxyTransparentUIProcessTask, String paramString) {}
  
  public final void aBh()
  {
    AppMethodBeat.i(73146);
    ab.i("MicroMsg.AppBrandProxyTransparentUI", "onResult");
    Intent localIntent = new Intent();
    localIntent.putExtra("task_object", this.hwj);
    localIntent.putExtra("task_id", this.hwk);
    this.hwl.setResult(-1, localIntent);
    this.hwl.finish();
    AppMethodBeat.o(73146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUI.1
 * JD-Core Version:    0.7.0.1
 */