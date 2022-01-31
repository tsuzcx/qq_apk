package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

class ClientLaunchEntry$1
  extends ResultReceiver
{
  ClientLaunchEntry$1(c paramc, Handler paramHandler, Context paramContext)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    boolean bool3 = j.lQ(j.gMH);
    boolean bool1;
    if (paramInt == -1)
    {
      bool1 = true;
      if ((!(this.val$context instanceof AppBrandUI)) || (!((AppBrandUI)this.val$context).hem)) {
        break label120;
      }
    }
    label120:
    for (boolean bool2 = true;; bool2 = false)
    {
      y.i("MicroMsg.AppBrand.Precondition.ClientLaunchEntry", "[appswitch] onReceiveResult, %s, proxyLaunchBack %b, pendingNewIntents %b, handlingNewIntent %b", new Object[] { this.val$context.getClass().getSimpleName(), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
      if ((bool1) && (!bool3) && (!bool2)) {
        ((MMActivity)this.val$context).moveTaskToBack(true);
      }
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.ClientLaunchEntry.1
 * JD-Core Version:    0.7.0.1
 */