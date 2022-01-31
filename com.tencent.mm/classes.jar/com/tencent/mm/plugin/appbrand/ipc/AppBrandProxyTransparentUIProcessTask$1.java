package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

final class AppBrandProxyTransparentUIProcessTask$1
  implements MMActivity.a
{
  AppBrandProxyTransparentUIProcessTask$1(AppBrandProxyTransparentUIProcessTask paramAppBrandProxyTransparentUIProcessTask) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(73150);
    if (paramInt1 == (this.hwq.hashCode() & 0xFFFF))
    {
      if (paramIntent == null)
      {
        AppMethodBeat.o(73150);
        return;
      }
      AppBrandProxyTransparentUIProcessTask localAppBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask)paramIntent.getParcelableExtra("task_object");
      paramIntent = AppBrandProxyTransparentUIProcessTask.BG(paramIntent.getStringExtra("task_id"));
      if (paramIntent == null)
      {
        ab.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
        AppMethodBeat.o(73150);
        return;
      }
      AppBrandProxyTransparentUIProcessTask.a(localAppBrandProxyTransparentUIProcessTask, paramIntent);
      paramIntent.aBk();
      paramIntent.atb();
      this.hwq.mContext = null;
    }
    AppMethodBeat.o(73150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.1
 * JD-Core Version:    0.7.0.1
 */