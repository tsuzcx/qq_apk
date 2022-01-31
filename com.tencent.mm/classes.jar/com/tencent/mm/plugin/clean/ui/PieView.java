package com.tencent.mm.plugin.clean.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieView
  extends View
{
  private int bTs = 0;
  private int ghE = 6;
  private Paint iCj;
  private Paint iCk;
  private Paint iCl;
  private Paint iCm;
  private Paint iCn;
  private Paint iCo;
  private Paint iCp;
  private int iCq;
  private int iCr;
  private int iCs;
  private int iCt;
  private int iCu;
  private int iCv;
  private int iCw = 0;
  private int iCx = -90;
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private static int D(int paramInt1, int paramInt2, int paramInt3)
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
    this.iCj = pj(-1);
    this.iCk = pj(-657931);
    this.iCl = pj(-2565928);
    this.iCm = pj(-15223279);
    this.iCn = pj(-7876878);
    this.iCo = pj(-7876878);
    this.iCp = pj(-1644567);
  }
  
  private static Paint pj(int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setColor(paramInt);
    return localPaint;
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2 + getTop();
    float f3 = getMeasuredHeight() / 3 + 15;
    RectF localRectF1 = new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    if (this.bTs == 0)
    {
      paramCanvas.drawCircle(f1, f2, f3, this.iCk);
      paramCanvas.drawArc(localRectF1, this.iCx, 45.0F, true, this.iCl);
      paramCanvas.drawCircle(f1, f2, f3 - 15.0F, this.iCj);
      this.iCx += 4;
      this.iCx %= 360;
    }
    RectF localRectF2;
    int i;
    int j;
    if (this.bTs == 1)
    {
      f3 = 10.0F + f3;
      localRectF2 = new RectF(f1 - f3, f2 - f3, f1 + f3, f3 + f2);
      this.iCq = D(this.iCq, this.iCu, this.ghE);
      paramCanvas.drawArc(localRectF2, -90.0F, this.iCq, true, this.iCm);
      if (this.iCw > 0) {
        break label351;
      }
      if (this.iCq == this.iCu)
      {
        this.iCs = D(this.iCs, this.iCv, this.ghE);
        paramCanvas.drawArc(localRectF1, this.iCu - 90, this.iCs, true, this.iCn);
      }
      if (this.iCs == this.iCv)
      {
        i = this.iCu;
        j = this.iCv;
        this.iCr = D(this.iCr, 360 - i - j, this.ghE);
        paramCanvas.drawArc(localRectF1, this.iCu - 90 + this.iCv, this.iCr, true, this.iCo);
      }
    }
    for (;;)
    {
      invalidate();
      return;
      label351:
      if (this.iCq == this.iCu)
      {
        this.iCt = D(this.iCt, this.iCw, this.ghE);
        paramCanvas.drawArc(localRectF2, this.iCu - 90, this.iCt, true, this.iCp);
      }
      if (this.iCt == this.iCw)
      {
        this.iCs = D(this.iCs, this.iCv, this.ghE);
        paramCanvas.drawArc(localRectF1, this.iCw - 90 + this.iCu, this.iCs, true, this.iCn);
      }
      if (this.iCs == this.iCv)
      {
        i = this.iCu;
        j = this.iCv;
        int k = this.iCw;
        this.iCr = D(this.iCr, 360 - i - j - k, this.ghE);
        paramCanvas.drawArc(localRectF1, this.iCu - 90 + this.iCv + this.iCw, this.iCr, true, this.iCo);
      }
    }
  }
  
  public void setDeepGrayTargetAngle(int paramInt)
  {
    this.iCv = paramInt;
  }
  
  public void setGreenTargetAngle(int paramInt)
  {
    this.iCu = paramInt;
  }
  
  public void setOtherAccTargetAngle(int paramInt)
  {
    this.iCw = paramInt;
  }
  
  public void setStage(int paramInt)
  {
    this.bTs = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.PieView
 * JD-Core Version:    0.7.0.1
 */