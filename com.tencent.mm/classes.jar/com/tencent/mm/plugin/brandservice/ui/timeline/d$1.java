package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.s;

final class d$1
  implements Runnable
{
  d$1(d paramd, Runnable paramRunnable) {}
  
  public final void run()
  {
    Runnable localRunnable = this.dGX;
    if (d.axV()) {
      if (localRunnable != null) {
        ai.d(localRunnable);
      }
    }
    do
    {
      return;
      s.mA(false);
    } while (localRunnable == null);
    ai.d(localRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.d.1
 * JD-Core Version:    0.7.0.1
 */