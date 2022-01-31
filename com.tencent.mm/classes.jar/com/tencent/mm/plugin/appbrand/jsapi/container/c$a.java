package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
  implements Interpolator
{
  protected PointF a;
  protected PointF b;
  private int hKY;
  private final PointF hKZ;
  private final PointF hLa;
  protected PointF hLb;
  protected PointF hLc;
  protected PointF hLd;
  
  public c$a(c paramc)
  {
    this(paramc, new PointF(0.0F, 0.0F), new PointF(0.58F, 1.0F));
    AppMethodBeat.i(126284);
    AppMethodBeat.o(126284);
  }
  
  private c$a(c paramc, PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(126283);
    this.hKY = 0;
    this.hKZ = new PointF();
    this.hLa = new PointF();
    this.a = new PointF();
    this.b = new PointF();
    this.hLd = new PointF();
    if ((paramPointF1.x < 0.0F) || (paramPointF1.x > 1.0F))
    {
      paramc = new IllegalArgumentException("startX value must be in the range [0, 1]");
      AppMethodBeat.o(126283);
      throw paramc;
    }
    if ((paramPointF2.x < 0.0F) || (paramPointF2.x > 1.0F))
    {
      paramc = new IllegalArgumentException("endX value must be in the range [0, 1]");
      AppMethodBeat.o(126283);
      throw paramc;
    }
    this.hLb = paramPointF1;
    this.hLc = paramPointF2;
    AppMethodBeat.o(126283);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(126285);
    int i = 1;
    float f1 = paramFloat;
    while (i < 14)
    {
      this.hLd.x = (this.hLb.x * 3.0F);
      this.b.x = ((this.hLc.x - this.hLb.x) * 3.0F - this.hLd.x);
      this.a.x = (1.0F - this.hLd.x - this.b.x);
      f2 = (this.hLd.x + (this.b.x + this.a.x * f1) * f1) * f1 - paramFloat;
      if (Math.abs(f2) < 0.001D) {
        break;
      }
      f1 -= f2 / (this.hLd.x + (2.0F * this.b.x + this.a.x * 3.0F * f1) * f1);
      i += 1;
    }
    this.hLd.y = (this.hLb.y * 3.0F);
    this.b.y = ((this.hLc.y - this.hLb.y) * 3.0F - this.hLd.y);
    this.a.y = (1.0F - this.hLd.y - this.b.y);
    paramFloat = this.hLd.y;
    float f2 = this.b.y;
    float f3 = this.a.y;
    AppMethodBeat.o(126285);
    return (paramFloat + (f2 + f3 * f1) * f1) * f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c.a
 * JD-Core Version:    0.7.0.1
 */