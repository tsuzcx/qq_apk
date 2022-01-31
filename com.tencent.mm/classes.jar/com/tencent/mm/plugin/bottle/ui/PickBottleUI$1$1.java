package com.tencent.mm.plugin.bottle.ui;

import android.widget.ImageView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.a.h.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class PickBottleUI$1$1
  implements h.a
{
  PickBottleUI$1$1(PickBottleUI.1 param1) {}
  
  public final void cs(int paramInt1, int paramInt2)
  {
    if ((PickBottleUI.a(this.iaB.iaA) == null) || (PickBottleUI.b(this.iaB.iaA) == null)) {}
    do
    {
      return;
      PickBottleUI.a(this.iaB.iaA).stop();
      if (paramInt2 == -2002)
      {
        PickBottleUI.a(this.iaB.iaA, null);
        PickBottleUI.c(this.iaB.iaA).ol(0);
        PickBottleUI.c(this.iaB.iaA).ok(R.l.bottle_banby_expose);
      }
    } while (PickBottleUI.d(this.iaB.iaA) == null);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (PickBottleUI.d(this.iaB.iaA).hYg == -10001))
    {
      PickBottleUI.b(this.iaB.iaA).setBottleTalker(null);
      PickBottleUI.b(this.iaB.iaA).show(-10001);
      PickBottleUI.f(this.iaB.iaA).postDelayed(PickBottleUI.e(this.iaB.iaA), 2000L);
      return;
    }
    if (19990 == PickBottleUI.d(this.iaB.iaA).hYg) {
      m.f(PickBottleUI.d(this.iaB.iaA).hYr, PickBottleUI.d(this.iaB.iaA).iconUrl, R.g.nosdcard_headimg);
    }
    y.i("PickBottle", "bottleInfo:" + PickBottleUI.d(this.iaB.iaA).hYl + " real:" + PickBottleUI.d(this.iaB.iaA).hYr);
    PickBottleUI.b(this.iaB.iaA).setBottleTalker(PickBottleUI.d(this.iaB.iaA).hYl);
    PickBottleUI.b(this.iaB.iaA).setRealUserName(PickBottleUI.d(this.iaB.iaA).hYr);
    PickBottleUI.b(this.iaB.iaA).setIconUrl(PickBottleUI.d(this.iaB.iaA).iconUrl);
    PickBottleUI.b(this.iaB.iaA).setDensity(PickBottleUI.g(this.iaB.iaA));
    PickBottleUI.b(this.iaB.iaA).show(PickBottleUI.d(this.iaB.iaA).hYg);
    PickBottleUI.h(this.iaB.iaA).setVisibility(0);
    PickBottleUI.a(this.iaB.iaA, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.PickBottleUI.1.1
 * JD-Core Version:    0.7.0.1
 */