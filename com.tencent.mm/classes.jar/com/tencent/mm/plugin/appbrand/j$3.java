package com.tencent.mm.plugin.appbrand;

import android.widget.FrameLayout;
import java.util.HashMap;
import java.util.LinkedList;

final class j$3
  implements Runnable
{
  j$3(j paramj, i parami1, i parami2) {}
  
  public final void run()
  {
    this.fzd.cleanup();
    this.fzc.fyq.removeView(this.fzd.fyq);
    this.fzc.fyX.remove(this.fzd.mAppId);
    this.fzc.fyW.remove(this.fzd);
    if (this.fze != null) {
      this.fze.ZN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.3
 * JD-Core Version:    0.7.0.1
 */