package com.davemorrissey.labs.subscaleview.view;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class SubsamplingScaleImageView$b
{
  boolean atE;
  int atF;
  int atG;
  private SubsamplingScaleImageView.d atH;
  private final float atI;
  private final PointF atJ;
  private final PointF atK;
  boolean atL;
  long duration;
  
  private SubsamplingScaleImageView$b(SubsamplingScaleImageView paramSubsamplingScaleImageView, float paramFloat, PointF paramPointF)
  {
    this.duration = 500L;
    this.atF = 2;
    this.atG = 1;
    this.atE = true;
    this.atL = true;
    this.atI = paramFloat;
    this.atJ = paramPointF;
    this.atK = null;
  }
  
  private SubsamplingScaleImageView$b(SubsamplingScaleImageView paramSubsamplingScaleImageView, float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    this.duration = 500L;
    this.atF = 2;
    this.atG = 1;
    this.atE = true;
    this.atL = true;
    this.atI = paramFloat;
    this.atJ = paramPointF1;
    this.atK = paramPointF2;
  }
  
  private SubsamplingScaleImageView$b(SubsamplingScaleImageView paramSubsamplingScaleImageView, PointF paramPointF)
  {
    AppMethodBeat.i(115651);
    this.duration = 500L;
    this.atF = 2;
    this.atG = 1;
    this.atE = true;
    this.atL = true;
    this.atI = SubsamplingScaleImageView.i(paramSubsamplingScaleImageView);
    this.atJ = paramPointF;
    this.atK = null;
    AppMethodBeat.o(115651);
  }
  
  public final void start()
  {
    AppMethodBeat.i(115652);
    if ((SubsamplingScaleImageView.w(this.ats) != null) && (SubsamplingScaleImageView.w(this.ats).atH != null)) {}
    try
    {
      SubsamplingScaleImageView.w(this.ats);
      int i = this.ats.getPaddingLeft();
      int j = (this.ats.getWidth() - this.ats.getPaddingRight() - this.ats.getPaddingLeft()) / 2;
      int k = this.ats.getPaddingTop();
      int m = (this.ats.getHeight() - this.ats.getPaddingBottom() - this.ats.getPaddingTop()) / 2;
      float f3 = SubsamplingScaleImageView.b(this.ats, this.atI);
      if (this.atL)
      {
        Object localObject = SubsamplingScaleImageView.a(this.ats, this.atJ.x, this.atJ.y, f3, new PointF());
        SubsamplingScaleImageView.a(this.ats, new SubsamplingScaleImageView.a((byte)0));
        SubsamplingScaleImageView.w(this.ats).arZ = SubsamplingScaleImageView.i(this.ats);
        SubsamplingScaleImageView.w(this.ats).aty = f3;
        SubsamplingScaleImageView.w(this.ats).time = System.currentTimeMillis();
        SubsamplingScaleImageView.w(this.ats).atB = ((PointF)localObject);
        SubsamplingScaleImageView.w(this.ats).atz = this.ats.getCenter();
        SubsamplingScaleImageView.w(this.ats).atA = ((PointF)localObject);
        SubsamplingScaleImageView.w(this.ats).atC = this.ats.c((PointF)localObject);
        SubsamplingScaleImageView.w(this.ats).atD = new PointF(j + i, m + k);
        SubsamplingScaleImageView.w(this.ats).duration = this.duration;
        SubsamplingScaleImageView.w(this.ats).atE = this.atE;
        SubsamplingScaleImageView.w(this.ats).atF = this.atF;
        SubsamplingScaleImageView.w(this.ats).atG = this.atG;
        SubsamplingScaleImageView.w(this.ats).time = System.currentTimeMillis();
        SubsamplingScaleImageView.w(this.ats).atH = this.atH;
        if (this.atK != null)
        {
          float f1 = this.atK.x - SubsamplingScaleImageView.w(this.ats).atz.x * f3;
          float f2 = this.atK.y - SubsamplingScaleImageView.w(this.ats).atz.y * f3;
          localObject = new SubsamplingScaleImageView.g(f3, new PointF(f1, f2), (byte)0);
          SubsamplingScaleImageView.a(this.ats, (SubsamplingScaleImageView.g)localObject);
          SubsamplingScaleImageView.a locala = SubsamplingScaleImageView.w(this.ats);
          f3 = this.atK.x;
          float f4 = ((SubsamplingScaleImageView.g)localObject).asa.x;
          float f5 = this.atK.y;
          locala.atD = new PointF(f4 - f1 + f3, ((SubsamplingScaleImageView.g)localObject).asa.y - f2 + f5);
        }
        this.ats.invalidate();
        AppMethodBeat.o(115652);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w(SubsamplingScaleImageView.l(this.ats), "Error thrown by animation listener", new Object[] { localException });
        continue;
        PointF localPointF = this.atJ;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.b
 * JD-Core Version:    0.7.0.1
 */