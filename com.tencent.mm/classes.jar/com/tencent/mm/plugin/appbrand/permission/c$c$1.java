package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class c$c$1
  implements Runnable
{
  c$c$1(c.c paramc) {}
  
  public final void run()
  {
    Runnable localRunnable = (Runnable)c.anK().pollFirst();
    if (localRunnable != null)
    {
      localRunnable.run();
      return;
    }
    y.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
    c.dz(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c.c.1
 * JD-Core Version:    0.7.0.1
 */