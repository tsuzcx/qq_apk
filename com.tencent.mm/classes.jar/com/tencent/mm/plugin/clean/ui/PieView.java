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
  private int drg;
  private Paint ftg;
  private int jzV;
  private Paint nNU;
  private Paint nNV;
  private Paint nNW;
  private Paint nNX;
  private Paint nNY;
  private Paint nNZ;
  private int nOa;
  private int nOb;
  private int nOc;
  private int nOd;
  private int nOe;
  private int nOf;
  private int nOg;
  private int nOh;
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22844);
    this.jzV = 6;
    this.nOg = 0;
    this.drg = 0;
    this.nOh = -90;
    initView();
    AppMethodBeat.o(22844);
  }
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(22843);
    this.jzV = 6;
    this.nOg = 0;
    this.drg = 0;
    this.nOh = -90;
    initView();
    AppMethodBeat.o(22843);
  }
  
  private static int S(int paramInt1, int paramInt2, int paramInt3)
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
    this.ftg = zt(-1);
    this.nNU = zt(-657931);
    this.nNV = zt(-2565928);
    this.nNW = zt(-15223279);
    this.nNX = zt(-7876878);
    this.nNY = zt(-7876878);
    this.nNZ = zt(-1644567);
    AppMethodBeat.o(22845);
  }
  
  private static Paint zt(int paramInt)
  {
    AppMethodBeat.i(22846);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setColor(paramInt);
    AppMethodBeat.o(22846);
    return localPaint;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(22847);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2 + getTop();
    float f3 = getMeasuredHeight() / 3 + 15;
    RectF localRectF1 = new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    if (this.drg == 0)
    {
      paramCanvas.drawCircle(f1, f2, f3, this.nNU);
      paramCanvas.drawArc(localRectF1, this.nOh, 45.0F, true, this.nNV);
      paramCanvas.drawCircle(f1, f2, f3 - 15.0F, this.ftg);
      this.nOh += 4;
      this.nOh %= 360;
    }
    RectF localRectF2;
    int i;
    int j;
    if (this.drg == 1)
    {
      f3 = 10.0F + f3;
      localRectF2 = new RectF(f1 - f3, f2 - f3, f1 + f3, f3 + f2);
      this.nOa = S(this.nOa, this.nOe, this.jzV);
      paramCanvas.drawArc(localRectF2, -90.0F, this.nOa, true, this.nNW);
      if (this.nOg > 0) {
        break label363;
      }
      if (this.nOa == this.nOe)
      {
        this.nOc = S(this.nOc, this.nOf, this.jzV);
        paramCanvas.drawArc(localRectF1, this.nOe - 90, this.nOc, true, this.nNX);
      }
      if (this.nOc == this.nOf)
      {
        i = this.nOe;
        j = this.nOf;
        this.nOb = S(this.nOb, 360 - i - j, this.jzV);
        paramCanvas.drawArc(localRectF1, this.nOe - 90 + this.nOf, this.nOb, true, this.nNY);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(22847);
      return;
      label363:
      if (this.nOa == this.nOe)
      {
        this.nOd = S(this.nOd, this.nOg, this.jzV);
        paramCanvas.drawArc(localRectF2, this.nOe - 90, this.nOd, true, this.nNZ);
      }
      if (this.nOd == this.nOg)
      {
        this.nOc = S(this.nOc, this.nOf, this.jzV);
        paramCanvas.drawArc(localRectF1, this.nOg - 90 + this.nOe, this.nOc, true, this.nNX);
      }
      if (this.nOc == this.nOf)
      {
        i = this.nOe;
        j = this.nOf;
        int k = this.nOg;
        this.nOb = S(this.nOb, 360 - i - j - k, this.jzV);
        paramCanvas.drawArc(localRectF1, this.nOe - 90 + this.nOf + this.nOg, this.nOb, true, this.nNY);
      }
    }
  }
  
  public void setDeepGrayTargetAngle(int paramInt)
  {
    this.nOf = paramInt;
  }
  
  public void setGreenTargetAngle(int paramInt)
  {
    this.nOe = paramInt;
  }
  
  public void setOtherAccTargetAngle(int paramInt)
  {
    this.nOg = paramInt;
  }
  
  public void setStage(int paramInt)
  {
    this.drg = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.PieView
 * JD-Core Version:    0.7.0.1
 */