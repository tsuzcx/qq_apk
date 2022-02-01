package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
  implements Interpolator
{
  private int kKB;
  private final PointF kKC;
  private final PointF kKD;
  protected PointF kKE;
  protected PointF kKF;
  protected PointF kKG;
  protected PointF kKH;
  protected PointF kKI;
  
  public c$a(c paramc)
  {
    this(paramc, new PointF(0.0F, 0.0F), new PointF(0.58F, 1.0F));
    AppMethodBeat.i(137512);
    AppMethodBeat.o(137512);
  }
  
  private c$a(c paramc, PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(137511);
    this.kKB = 0;
    this.kKC = new PointF();
    this.kKD = new PointF();
    this.kKG = new PointF();
    this.kKH = new PointF();
    this.kKI = new PointF();
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
    this.kKE = paramPointF1;
    this.kKF = paramPointF2;
    AppMethodBeat.o(137511);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(137513);
    int i = 1;
    float f1 = paramFloat;
    while (i < 14)
    {
      this.kKI.x = (this.kKE.x * 3.0F);
      this.kKH.x = ((this.kKF.x - this.kKE.x) * 3.0F - this.kKI.x);
      this.kKG.x = (1.0F - this.kKI.x - this.kKH.x);
      f2 = (this.kKI.x + (this.kKH.x + this.kKG.x * f1) * f1) * f1 - paramFloat;
      if (Math.abs(f2) < 0.001D) {
        break;
      }
      f1 -= f2 / (this.kKI.x + (2.0F * this.kKH.x + this.kKG.x * 3.0F * f1) * f1);
      i += 1;
    }
    this.kKI.y = (this.kKE.y * 3.0F);
    this.kKH.y = ((this.kKF.y - this.kKE.y) * 3.0F - this.kKI.y);
    this.kKG.y = (1.0F - this.kKI.y - this.kKH.y);
    paramFloat = this.kKI.y;
    float f2 = this.kKH.y;
    float f3 = this.kKG.y;
    AppMethodBeat.o(137513);
    return (paramFloat + (f2 + f3 * f1) * f1) * f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c.a
 * JD-Core Version:    0.7.0.1
 */