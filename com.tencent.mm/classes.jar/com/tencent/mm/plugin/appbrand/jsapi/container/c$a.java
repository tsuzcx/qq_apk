package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
  implements Interpolator
{
  protected PointF b;
  protected PointF c;
  private int rTe;
  private final PointF rTf;
  private final PointF rTg;
  protected PointF rTh;
  protected PointF rTi;
  protected PointF rTj;
  
  public c$a(c paramc)
  {
    this(paramc, new PointF(0.0F, 0.0F), new PointF(0.58F, 1.0F));
    AppMethodBeat.i(137512);
    AppMethodBeat.o(137512);
  }
  
  private c$a(c paramc, PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(137511);
    this.rTe = 0;
    this.rTf = new PointF();
    this.rTg = new PointF();
    this.rTj = new PointF();
    this.b = new PointF();
    this.c = new PointF();
    if ((paramPointF1.x < 0.0F) || (paramPointF1.x > 1.0F))
    {
      paramc = new IllegalArgumentException("startX value must be in the range [0, 1]");
      AppMethodBeat.o(137511);
      throw paramc;
    }
    if ((paramPointF2.x < 0.0F) || (paramPointF2.x > 1.0F))
    {
      paramc = new IllegalArgumentException("endX value must be in the range [0, 1]");
      AppMethodBeat.o(137511);
      throw paramc;
    }
    this.rTh = paramPointF1;
    this.rTi = paramPointF2;
    AppMethodBeat.o(137511);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(137513);
    int i = 1;
    float f1 = paramFloat;
    while (i < 14)
    {
      this.c.x = (this.rTh.x * 3.0F);
      this.b.x = ((this.rTi.x - this.rTh.x) * 3.0F - this.c.x);
      this.rTj.x = (1.0F - this.c.x - this.b.x);
      f2 = (this.c.x + (this.b.x + this.rTj.x * f1) * f1) * f1 - paramFloat;
      if (Math.abs(f2) < 0.001D) {
        break;
      }
      f1 -= f2 / (this.c.x + (2.0F * this.b.x + this.rTj.x * 3.0F * f1) * f1);
      i += 1;
    }
    this.c.y = (this.rTh.y * 3.0F);
    this.b.y = ((this.rTi.y - this.rTh.y) * 3.0F - this.c.y);
    this.rTj.y = (1.0F - this.c.y - this.b.y);
    paramFloat = this.c.y;
    float f2 = this.b.y;
    float f3 = this.rTj.y;
    AppMethodBeat.o(137513);
    return (paramFloat + (f2 + f3 * f1) * f1) * f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c.a
 * JD-Core Version:    0.7.0.1
 */