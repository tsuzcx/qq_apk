package com.tencent.mm.plugin.clean.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PieView
  extends View
{
  private int doR;
  private Paint fwN;
  private int kar;
  private Paint oqW;
  private Paint oqX;
  private Paint oqY;
  private Paint oqZ;
  private Paint ora;
  private Paint orb;
  private int orc;
  private int ord;
  private int ore;
  private int orf;
  private int org;
  private int orh;
  private int ori;
  private int orj;
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22844);
    this.kar = 6;
    this.ori = 0;
    this.doR = 0;
    this.orj = -90;
    initView();
    AppMethodBeat.o(22844);
  }
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(22843);
    this.kar = 6;
    this.ori = 0;
    this.doR = 0;
    this.orj = -90;
    initView();
    AppMethodBeat.o(22843);
  }
  
  private static Paint Ak(int paramInt)
  {
    AppMethodBeat.i(22846);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setColor(paramInt);
    AppMethodBeat.o(22846);
    return localPaint;
  }
  
  private static int T(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt2 - paramInt1 >= paramInt3) {
      i = paramInt1 + paramInt3;
    }
    do
    {
      return i;
      i = paramInt2;
    } while (paramInt1 - paramInt2 <= paramInt3);
    return paramInt1 - paramInt3;
  }
  
  private void initView()
  {
    AppMethodBeat.i(22845);
    this.fwN = Ak(-1);
    this.oqW = Ak(-657931);
    this.oqX = Ak(-2565928);
    this.oqY = Ak(-15223279);
    this.oqZ = Ak(-7876878);
    this.ora = Ak(-7876878);
    this.orb = Ak(-1644567);
    AppMethodBeat.o(22845);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(22847);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2 + getTop();
    float f3 = getMeasuredHeight() / 3 + 15;
    RectF localRectF1 = new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    if (this.doR == 0)
    {
      paramCanvas.drawCircle(f1, f2, f3, this.oqW);
      paramCanvas.drawArc(localRectF1, this.orj, 45.0F, true, this.oqX);
      paramCanvas.drawCircle(f1, f2, f3 - 15.0F, this.fwN);
      this.orj += 4;
      this.orj %= 360;
    }
    RectF localRectF2;
    int i;
    int j;
    if (this.doR == 1)
    {
      f3 = 10.0F + f3;
      localRectF2 = new RectF(f1 - f3, f2 - f3, f1 + f3, f3 + f2);
      this.orc = T(this.orc, this.org, this.kar);
      paramCanvas.drawArc(localRectF2, -90.0F, this.orc, true, this.oqY);
      if (this.ori > 0) {
        break label363;
      }
      if (this.orc == this.org)
      {
        this.ore = T(this.ore, this.orh, this.kar);
        paramCanvas.drawArc(localRectF1, this.org - 90, this.ore, true, this.oqZ);
      }
      if (this.ore == this.orh)
      {
        i = this.org;
        j = this.orh;
        this.ord = T(this.ord, 360 - i - j, this.kar);
        paramCanvas.drawArc(localRectF1, this.org - 90 + this.orh, this.ord, true, this.ora);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(22847);
      return;
      label363:
      if (this.orc == this.org)
      {
        this.orf = T(this.orf, this.ori, this.kar);
        paramCanvas.drawArc(localRectF2, this.org - 90, this.orf, true, this.orb);
      }
      if (this.orf == this.ori)
      {
        this.ore = T(this.ore, this.orh, this.kar);
        paramCanvas.drawArc(localRectF1, this.ori - 90 + this.org, this.ore, true, this.oqZ);
      }
      if (this.ore == this.orh)
      {
        i = this.org;
        j = this.orh;
        int k = this.ori;
        this.ord = T(this.ord, 360 - i - j - k, this.kar);
        paramCanvas.drawArc(localRectF1, this.org - 90 + this.orh + this.ori, this.ord, true, this.ora);
      }
    }
  }
  
  public void setDeepGrayTargetAngle(int paramInt)
  {
    this.orh = paramInt;
  }
  
  public void setGreenTargetAngle(int paramInt)
  {
    this.org = paramInt;
  }
  
  public void setOtherAccTargetAngle(int paramInt)
  {
    this.ori = paramInt;
  }
  
  public void setStage(int paramInt)
  {
    this.doR = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.PieView
 * JD-Core Version:    0.7.0.1
 */