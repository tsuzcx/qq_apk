package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class c$9
  implements a.a
{
  c$9(c paramc) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return false;
    }
    if ((c.g(this.lJp) == -85.0D) || (c.h(this.lJp) == -1000.0D))
    {
      y.d("MicroMsg.MMPoiMapUI", "first get location");
      String str = (int)(1000000.0F * paramFloat2) + "," + (int)(1000000.0F * paramFloat1);
      g.DP().Dz().c(ac.a.urm, str);
      c.c(this.lJp, paramFloat2);
      c.d(this.lJp, paramFloat1);
      c.a(this.lJp, paramFloat2);
      c.b(this.lJp, paramFloat1);
      c.a(this.lJp, c.g(this.lJp));
      c.b(this.lJp, c.h(this.lJp));
      c.k(this.lJp).j(c.i(this.lJp), c.j(this.lJp));
      this.lJp.lFy.getIController().animateTo(c.g(this.lJp), c.h(this.lJp), com.tencent.mm.plugin.location.ui.d.bem());
      if (!c.q(this.lJp)) {
        c.m(this.lJp);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.9
 * JD-Core Version:    0.7.0.1
 */