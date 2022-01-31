package com.tencent.mm.plugin.appbrand.launching;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandPreInitTask$2
  implements Runnable
{
  AppBrandPreInitTask$2(AppBrandPreInitTask paramAppBrandPreInitTask, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(131719);
    this.ijN.run();
    Looper.myLooper().quit();
    AppMethodBeat.o(131719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.2
 * JD-Core Version:    0.7.0.1
 */