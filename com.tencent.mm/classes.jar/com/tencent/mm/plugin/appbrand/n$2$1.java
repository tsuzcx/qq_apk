package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

final class n$2$1
  implements Runnable
{
  n$2$1(n.2 param2, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction) {}
  
  public final void run()
  {
    this.fzP.fzM.finish();
    if (this.fzO != null)
    {
      AppBrandLaunchErrorAction localAppBrandLaunchErrorAction = this.fzO;
      MMActivity localMMActivity = this.fzP.fzM.aai();
      Object localObject;
      if (localMMActivity != null)
      {
        localObject = localMMActivity;
        if (!localMMActivity.isFinishing()) {}
      }
      else
      {
        localObject = ae.getContext();
      }
      localAppBrandLaunchErrorAction.cr((Context)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.2.1
 * JD-Core Version:    0.7.0.1
 */