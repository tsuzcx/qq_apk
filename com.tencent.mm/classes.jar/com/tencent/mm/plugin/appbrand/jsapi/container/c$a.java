package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public final class c$a
  implements Interpolator
{
  protected PointF a = new PointF();
  protected PointF b = new PointF();
  private int gqg = 0;
  private final PointF gqh = new PointF();
  private final PointF gqi = new PointF();
  protected PointF gqj;
  protected PointF gqk;
  protected PointF gql = new PointF();
  
  public c$a(c paramc)
  {
    this(paramc, new PointF(0.0F, 0.0F), new PointF(0.58F, 1.0F));
  }
  
  private c$a(c paramc, PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1.x < 0.0F) || (paramPointF1.x > 1.0F)) {
      throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }
    if ((paramPointF2.x < 0.0F) || (paramPointF2.x > 1.0F)) {
      throw new IllegalArgumentException("endX value must be in the range [0, 1]");
    }
    this.gqj = paramPointF1;
    this.gqk = paramPointF2;
  }
  
  public final float getInterpolation(float paramFloat)
  {
    int i = 1;
    float f1 = paramFloat;
    while (i < 14)
    {
      this.gql.x = (this.gqj.x * 3.0F);
      this.b.x = ((this.gqk.x - this.gqj.x) * 3.0F - this.gql.x);
      this.a.x = (1.0F - this.gql.x - this.b.x);
      float f2 = (this.gql.x + (this.b.x + this.a.x * f1) * f1) * f1 - paramFloat;
      if (Math.abs(f2) < 0.001D) {
        break;
      }
      f1 -= f2 / (this.gql.x + (2.0F * this.b.x + this.a.x * 3.0F * f1) * f1);
      i += 1;
    }
    this.gql.y = (this.gqj.y * 3.0F);
    this.b.y = ((this.gqk.y - this.gqj.y) * 3.0F - this.gql.y);
    this.a.y = (1.0F - this.gql.y - this.b.y);
    return (this.gql.y + (this.b.y + this.a.y * f1) * f1) * f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c.a
 * JD-Core Version:    0.7.0.1
 */