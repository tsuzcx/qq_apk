package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.mm.plugin.appbrand.ui.recents.f;

final class c$b$1
  implements Runnable
{
  c$b$1(c.b paramb, boolean paramBoolean) {}
  
  public final void run()
  {
    if ((this.hkF.hkA.hkr != null) && (!this.hkF.hkA.hkr.isEmpty())) {
      this.hkF.hkA.hkr.bL(this.hkF.hkA.hkr.getItemCount() - 1);
    }
    f localf;
    if (this.hkF.hkA.hhs != null)
    {
      localf = this.hkF.hkA.hhs;
      if ((this.hhV) || (this.hkF.hkA.hkr.isEmpty())) {
        break label112;
      }
    }
    label112:
    for (boolean bool = true;; bool = false)
    {
      localf.dH(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c.b.1
 * JD-Core Version:    0.7.0.1
 */