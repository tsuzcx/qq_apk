package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
  implements Interpolator
{
  private int kNQ;
  private final PointF kNR;
  private final PointF kNS;
  protected PointF kNT;
  protected PointF kNU;
  protected PointF kNV;
  protected PointF kNW;
  protected PointF kNX;
  
  public c$a(c paramc)
  {
    this(paramc, new PointF(0.0F, 0.0F), new PointF(0.58F, 1.0F));
    AppMethodBeat.i(137512);
    AppMethodBeat.o(137512);
  }
  
  private c$a(c paramc, PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(137511);
    this.kNQ = 0;
    this.kNR = new PointF();
    this.kNS = new PointF();
    this.kNV = new PointF();
    this.kNW = new PointF();
    this.kNX = new PointF();
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
    this.kNT = paramPointF1;
    this.kNU = paramPointF2;
    AppMethodBeat.o(137511);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(137513);
    int i = 1;
    float f1 = paramFloat;
    while (i < 14)
    {
      this.kNX.x = (this.kNT.x * 3.0F);
      this.kNW.x = ((this.kNU.x - this.kNT.x) * 3.0F - this.kNX.x);
      this.kNV.x = (1.0F - this.kNX.x - this.kNW.x);
      f2 = (this.kNX.x + (this.kNW.x + this.kNV.x * f1) * f1) * f1 - paramFloat;
      if (Math.abs(f2) < 0.001D) {
        break;
      }
      f1 -= f2 / (this.kNX.x + (2.0F * this.kNW.x + this.kNV.x * 3.0F * f1) * f1);
      i += 1;
    }
    this.kNX.y = (this.kNT.y * 3.0F);
    this.kNW.y = ((this.kNU.y - this.kNT.y) * 3.0F - this.kNX.y);
    this.kNV.y = (1.0F - this.kNX.y - this.kNW.y);
    paramFloat = this.kNX.y;
    float f2 = this.kNW.y;
    float f3 = this.kNV.y;
    AppMethodBeat.o(137513);
    return (paramFloat + (f2 + f3 * f1) * f1) * f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c.a
 * JD-Core Version:    0.7.0.1
 */