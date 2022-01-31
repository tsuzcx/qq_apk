package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.a.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class a$b
  implements e.a
{
  private int gaQ = -1;
  
  public final void eb(int paramInt)
  {
    y.i("MBFontManagerRegistry", "mbfont idkey logid:" + this.gaQ + ",key:" + paramInt);
    h.nFQ.h(this.gaQ, paramInt, 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.a.b
 * JD-Core Version:    0.7.0.1
 */