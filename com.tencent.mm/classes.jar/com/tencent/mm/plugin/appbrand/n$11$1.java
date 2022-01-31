package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.report.quality.b;

final class n$11$1
  implements Runnable
{
  n$11$1(n.11 param11) {}
  
  public final void run()
  {
    if ((!this.fzS.fzR) && (!this.fzS.fzM.mFinished))
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.aov();
      b.a(false, this.fzS.fzM.mAppId, this.fzS.eow, g.aoc());
    }
    n.c(this.fzS.fzM).n(2, System.currentTimeMillis() - this.fzS.eow);
    com.tencent.mm.plugin.appbrand.performance.a.a(this.fzS.fzM.mAppId, "X5Prepare", this.fzS.eow, System.currentTimeMillis());
    this.fzS.fzN.pP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.11.1
 * JD-Core Version:    0.7.0.1
 */