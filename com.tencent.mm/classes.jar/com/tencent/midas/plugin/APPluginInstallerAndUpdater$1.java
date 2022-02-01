package com.tencent.midas.plugin;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class APPluginInstallerAndUpdater$1
  implements Runnable
{
  APPluginInstallerAndUpdater$1(Activity paramActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(217459);
    Toast.makeText(this.val$activity, "内核版本不一致！请检查Assets目录下MidasPay.zip是否更新。", 1).show();
    AppMethodBeat.o(217459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginInstallerAndUpdater.1
 * JD-Core Version:    0.7.0.1
 */