package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;

final class t$11$1
  implements Runnable
{
  t$11$1(t.11 param11, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction) {}
  
  public final void run()
  {
    AppMethodBeat.i(269249);
    if (this.nwU != null)
    {
      AppBrandLaunchErrorAction localAppBrandLaunchErrorAction = this.nwU;
      Activity localActivity = AndroidContextUtil.castActivityOrNull(this.nwV.nwQ.mContext);
      Object localObject;
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        localObject = localActivity;
        if (!localActivity.isDestroyed()) {}
      }
      else
      {
        localObject = MMApplicationContext.getContext();
      }
      localAppBrandLaunchErrorAction.ad((Context)localObject, "handleSync");
    }
    AppMethodBeat.o(269249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.11.1
 * JD-Core Version:    0.7.0.1
 */