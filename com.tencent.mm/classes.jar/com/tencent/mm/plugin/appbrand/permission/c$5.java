package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class c$5
  implements Runnable
{
  c$5(Runnable paramRunnable, String paramString1, String paramString2) {}
  
  public final void run()
  {
    if (c.access$900())
    {
      c.anK().add(this.gWP);
      y.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[] { this.val$appId, this.gWN });
      return;
    }
    c.dz(true);
    this.gWP.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c.5
 * JD-Core Version:    0.7.0.1
 */