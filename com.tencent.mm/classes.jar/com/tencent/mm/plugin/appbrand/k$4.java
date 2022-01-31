package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.ui.q;
import java.util.Iterator;

final class k$4
  implements Runnable
{
  k$4(k paramk, Runnable paramRunnable, i parami) {}
  
  public final void run()
  {
    if (this.fzj != null) {
      this.fzj.run();
    }
    if (this.fzi.ZV() == null) {}
    for (int i = 1;; i = 0)
    {
      if ((!this.fzi.fzf) && (i != 0) && (this.fzk == null) && (!this.fzi.fyk.isFinishing()) && ((this.fzi.fyk instanceof q)) && (((q)this.fzi.fyk).aoO()))
      {
        if (!this.fzi.ZY().hasNext()) {
          break;
        }
        this.fzi.fyk.moveTaskToBack(true);
      }
      return;
    }
    this.fzi.fyk.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.4
 * JD-Core Version:    0.7.0.1
 */