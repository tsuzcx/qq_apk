package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class AppBrandLaunchErrorAction$1
  implements Runnable
{
  AppBrandLaunchErrorAction$1(AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, Activity paramActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(320805);
    if ((this.val$activity == null) || (this.val$activity.isFinishing()) || (this.val$activity.isDestroyed())) {}
    for (Object localObject = MMApplicationContext.getContext();; localObject = this.val$activity)
    {
      this.sVJ.ad((Context)localObject, "handleAsync");
      AppMethodBeat.o(320805);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction.1
 * JD-Core Version:    0.7.0.1
 */