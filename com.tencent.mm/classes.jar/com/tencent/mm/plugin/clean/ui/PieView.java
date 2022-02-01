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
  private int dTz;
  private Paint gxp;
  private int lCq;
  private Paint qpU;
  private Paint qpV;
  private Paint qpW;
  private Paint qpX;
  private Paint qpY;
  private Paint qpZ;
  private int qqa;
  private int qqb;
  private int qqc;
  private int qqd;
  private int qqe;
  private int qqf;
  private int qqg;
  private int qqh;
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22844);
    this.lCq = 6;
    this.qqg = 0;
    this.dTz = 0;
    this.qqh = -90;
    initView();
    AppMethodBeat.o(22844);
  }
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(22843);
    this.lCq = 6;
    this.qqg = 0;
    this.dTz = 0;
    this.qqh = -90;
    initView();
    AppMethodBeat.o(22843);
  }
  
  private static Paint EN(int paramInt)
  {
    AppMethodBeat.i(22846);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setColor(paramInt);
    AppMethodBeat.o(22846);
    return localPaint;
  }
  
  private static int W(int paramInt1, int paramInt2, int paramInt3)
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
    this.gxp = EN(-1);
    this.qpU = EN(-657931);
    this.qpV = EN(-2565928);
    this.qpW = EN(-15223279);
    this.qpX = EN(-7876878);
    this.qpY = EN(-7876878);
    this.qpZ = EN(-1644567);
    AppMethodBeat.o(22845);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(22847);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2 + getTop();
    float f3 = getMeasuredHeight() / 3 + 15;
    RectF localRectF1 = new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    if (this.dTz == 0)
    {
      paramCanvas.drawCircle(f1, f2, f3, this.qpU);
      paramCanvas.drawArc(localRectF1, this.qqh, 45.0F, true, this.qpV);
      paramCanvas.drawCircle(f1, f2, f3 - 15.0F, this.gxp);
      this.qqh += 4;
      this.qqh %= 360;
    }
    RectF localRectF2;
    int i;
    int j;
    if (this.dTz == 1)
    {
      f3 = 10.0F + f3;
      localRectF2 = new RectF(f1 - f3, f2 - f3, f1 + f3, f3 + f2);
      this.qqa = W(this.qqa, this.qqe, this.lCq);
      paramCanvas.drawArc(localRectF2, -90.0F, this.qqa, true, this.qpW);
      if (this.qqg > 0) {
        break label363;
      }
      if (this.qqa == this.qqe)
      {
        this.qqc = W(this.qqc, this.qqf, this.lCq);
        paramCanvas.drawArc(localRectF1, this.qqe - 90, this.qqc, true, this.qpX);
      }
      if (this.qqc == this.qqf)
      {
        i = this.qqe;
        j = this.qqf;
        this.qqb = W(this.qqb, 360 - i - j, this.lCq);
        paramCanvas.drawArc(localRectF1, this.qqe - 90 + this.qqf, this.qqb, true, this.qpY);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(22847);
      return;
      label363:
      if (this.qqa == this.qqe)
      {
        this.qqd = W(this.qqd, this.qqg, this.lCq);
        paramCanvas.drawArc(localRectF2, this.qqe - 90, this.qqd, true, this.qpZ);
      }
      if (this.qqd == this.qqg)
      {
        this.qqc = W(this.qqc, this.qqf, this.lCq);
        paramCanvas.drawArc(localRectF1, this.qqg - 90 + this.qqe, this.qqc, true, this.qpX);
      }
      if (this.qqc == this.qqf)
      {
        i = this.qqe;
        j = this.qqf;
        int k = this.qqg;
        this.qqb = W(this.qqb, 360 - i - j - k, this.lCq);
        paramCanvas.drawArc(localRectF1, this.qqe - 90 + this.qqf + this.qqg, this.qqb, true, this.qpY);
      }
    }
  }
  
  public void setDeepGrayTargetAngle(int paramInt)
  {
    this.qqf = paramInt;
  }
  
  public void setGreenTargetAngle(int paramInt)
  {
    this.qqe = paramInt;
  }
  
  public void setOtherAccTargetAngle(int paramInt)
  {
    this.qqg = paramInt;
  }
  
  public void setStage(int paramInt)
  {
    this.dTz = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.PieView
 * JD-Core Version:    0.7.0.1
 */