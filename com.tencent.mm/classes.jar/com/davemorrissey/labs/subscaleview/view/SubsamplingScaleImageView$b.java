package com.davemorrissey.labs.subscaleview.view;

import android.graphics.PointF;
import com.tencent.mm.sdk.platformtools.y;

public final class SubsamplingScaleImageView$b
{
  boolean arm = true;
  int arn = 2;
  private int aro = 1;
  private SubsamplingScaleImageView.d arp;
  private final float arq;
  private final PointF arr;
  private final PointF ars;
  boolean art = true;
  long duration = 500L;
  
  private SubsamplingScaleImageView$b(SubsamplingScaleImageView paramSubsamplingScaleImageView, float paramFloat, PointF paramPointF)
  {
    this.arq = paramFloat;
    this.arr = paramPointF;
    this.ars = null;
  }
  
  private SubsamplingScaleImageView$b(SubsamplingScaleImageView paramSubsamplingScaleImageView, float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    this.arq = paramFloat;
    this.arr = paramPointF1;
    this.ars = paramPointF2;
  }
  
  private SubsamplingScaleImageView$b(SubsamplingScaleImageView paramSubsamplingScaleImageView, PointF paramPointF)
  {
    this.arq = SubsamplingScaleImageView.i(paramSubsamplingScaleImageView);
    this.arr = paramPointF;
    this.ars = null;
  }
  
  public final void start()
  {
    if ((SubsamplingScaleImageView.w(this.aqZ) != null) && (SubsamplingScaleImageView.w(this.aqZ).arp != null)) {}
    try
    {
      SubsamplingScaleImageView.w(this.aqZ);
      int i = this.aqZ.getPaddingLeft();
      int j = (this.aqZ.getWidth() - this.aqZ.getPaddingRight() - this.aqZ.getPaddingLeft()) / 2;
      int k = this.aqZ.getPaddingTop();
      int m = (this.aqZ.getHeight() - this.aqZ.getPaddingBottom() - this.aqZ.getPaddingTop()) / 2;
      float f3 = SubsamplingScaleImageView.b(this.aqZ, this.arq);
      if (this.art)
      {
        Object localObject = SubsamplingScaleImageView.a(this.aqZ, this.arr.x, this.arr.y, f3, new PointF());
        SubsamplingScaleImageView.a(this.aqZ, new SubsamplingScaleImageView.a((byte)0));
        SubsamplingScaleImageView.w(this.aqZ).apG = SubsamplingScaleImageView.i(this.aqZ);
        SubsamplingScaleImageView.w(this.aqZ).arg = f3;
        SubsamplingScaleImageView.w(this.aqZ).time = System.currentTimeMillis();
        SubsamplingScaleImageView.w(this.aqZ).arj = ((PointF)localObject);
        SubsamplingScaleImageView.w(this.aqZ).arh = this.aqZ.getCenter();
        SubsamplingScaleImageView.w(this.aqZ).ari = ((PointF)localObject);
        SubsamplingScaleImageView.w(this.aqZ).ark = this.aqZ.c((PointF)localObject);
        SubsamplingScaleImageView.w(this.aqZ).arl = new PointF(j + i, m + k);
        SubsamplingScaleImageView.w(this.aqZ).duration = this.duration;
        SubsamplingScaleImageView.w(this.aqZ).arm = this.arm;
        SubsamplingScaleImageView.w(this.aqZ).arn = this.arn;
        SubsamplingScaleImageView.w(this.aqZ).aro = this.aro;
        SubsamplingScaleImageView.w(this.aqZ).time = System.currentTimeMillis();
        SubsamplingScaleImageView.w(this.aqZ).arp = this.arp;
        if (this.ars != null)
        {
          float f1 = this.ars.x - SubsamplingScaleImageView.w(this.aqZ).arh.x * f3;
          float f2 = this.ars.y - SubsamplingScaleImageView.w(this.aqZ).arh.y * f3;
          localObject = new SubsamplingScaleImageView.g(f3, new PointF(f1, f2), (byte)0);
          SubsamplingScaleImageView.a(this.aqZ, (SubsamplingScaleImageView.g)localObject);
          SubsamplingScaleImageView.a locala = SubsamplingScaleImageView.w(this.aqZ);
          f3 = this.ars.x;
          float f4 = ((SubsamplingScaleImageView.g)localObject).apH.x;
          float f5 = this.ars.y;
          locala.arl = new PointF(f4 - f1 + f3, ((SubsamplingScaleImageView.g)localObject).apH.y - f2 + f5);
        }
        this.aqZ.invalidate();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w(SubsamplingScaleImageView.l(this.aqZ), "Error thrown by animation listener", new Object[] { localException });
        continue;
        PointF localPointF = this.arr;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.b
 * JD-Core Version:    0.7.0.1
 */