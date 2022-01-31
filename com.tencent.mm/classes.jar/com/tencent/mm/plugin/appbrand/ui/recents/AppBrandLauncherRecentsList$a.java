package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"HandlerLeak"})
final class AppBrandLauncherRecentsList$a
  extends Handler
{
  public AppBrandLauncherRecentsList$a(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList)
  {
    super(Looper.getMainLooper());
    AppMethodBeat.i(133360);
    AppMethodBeat.o(133360);
  }
  
  private void aNk()
  {
    AppMethodBeat.i(133362);
    removeMessages(1);
    removeMessages(2);
    removeCallbacksAndMessages(null);
    AppMethodBeat.o(133362);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(133361);
    if (paramMessage.what == 1)
    {
      ((Runnable)paramMessage.obj).run();
      removeMessages(2);
      AppMethodBeat.o(133361);
      return;
    }
    if (paramMessage.what == 2)
    {
      ((Runnable)paramMessage.obj).run();
      AppMethodBeat.o(133361);
      return;
    }
    super.handleMessage(paramMessage);
    AppMethodBeat.o(133361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.a
 * JD-Core Version:    0.7.0.1
 */