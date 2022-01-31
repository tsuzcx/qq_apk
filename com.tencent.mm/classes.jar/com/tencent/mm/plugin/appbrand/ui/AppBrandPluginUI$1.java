package com.tencent.mm.plugin.appbrand.ui;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b;

final class AppBrandPluginUI$1
  implements MessageQueue.IdleHandler
{
  AppBrandPluginUI$1(AppBrandPluginUI paramAppBrandPluginUI) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(133002);
    Looper.myQueue().removeIdleHandler(this);
    b.a(this.iNe, null);
    AppMethodBeat.o(133002);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI.1
 * JD-Core Version:    0.7.0.1
 */