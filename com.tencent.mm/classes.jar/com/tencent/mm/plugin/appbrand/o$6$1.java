package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;

final class o$6$1
  implements Runnable
{
  o$6$1(o.6 param6, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction) {}
  
  public final void run()
  {
    AppMethodBeat.i(128983);
    this.gRA.gRv.finish();
    if (this.gRz != null)
    {
      AppBrandLaunchErrorAction localAppBrandLaunchErrorAction = this.gRz;
      MMActivity localMMActivity = this.gRA.gRv.atV();
      Object localObject;
      if (localMMActivity != null)
      {
        localObject = localMMActivity;
        if (!localMMActivity.isFinishing()) {}
      }
      else
      {
        localObject = ah.getContext();
      }
      localAppBrandLaunchErrorAction.cS((Context)localObject);
      OpenBusinessViewUtil.z(this.gRA.gRv);
    }
    AppMethodBeat.o(128983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.6.1
 * JD-Core Version:    0.7.0.1
 */