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
  private int hSE;
  private Paint lDC;
  private int rBp;
  private Paint wRS;
  private Paint wRT;
  private Paint wRU;
  private Paint wRV;
  private Paint wRW;
  private Paint wRX;
  private int wRY;
  private int wRZ;
  private int wSa;
  private int wSb;
  private int wSc;
  private int wSd;
  private int wSe;
  private int wSf;
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22844);
    this.rBp = 6;
    this.wSe = 0;
    this.hSE = 0;
    this.wSf = -90;
    initView();
    AppMethodBeat.o(22844);
  }
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(22843);
    this.rBp = 6;
    this.wSe = 0;
    this.hSE = 0;
    this.wSf = -90;
    initView();
    AppMethodBeat.o(22843);
  }
  
  private static Paint IX(int paramInt)
  {
    AppMethodBeat.i(22846);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setColor(paramInt);
    AppMethodBeat.o(22846);
    return localPaint;
  }
  
  private static int ao(int paramInt1, int paramInt2, int paramInt3)
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
    this.lDC = IX(-1);
    this.wRS = IX(-657931);
    this.wRT = IX(-2565928);
    this.wRU = IX(-15223279);
    this.wRV = IX(-7876878);
    this.wRW = IX(-7876878);
    this.wRX = IX(-1644567);
    AppMethodBeat.o(22845);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(22847);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2 + getTop();
    float f3 = getMeasuredHeight() / 3 + 15;
    RectF localRectF1 = new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    if (this.hSE == 0)
    {
      paramCanvas.drawCircle(f1, f2, f3, this.wRS);
      paramCanvas.drawArc(localRectF1, this.wSf, 45.0F, true, this.wRT);
      paramCanvas.drawCircle(f1, f2, f3 - 15.0F, this.lDC);
      this.wSf += 4;
      this.wSf %= 360;
    }
    RectF localRectF2;
    int i;
    int j;
    if (this.hSE == 1)
    {
      f3 = 10.0F + f3;
      localRectF2 = new RectF(f1 - f3, f2 - f3, f1 + f3, f3 + f2);
      this.wRY = ao(this.wRY, this.wSc, this.rBp);
      paramCanvas.drawArc(localRectF2, -90.0F, this.wRY, true, this.wRU);
      if (this.wSe > 0) {
        break label363;
      }
      if (this.wRY == this.wSc)
      {
        this.wSa = ao(this.wSa, this.wSd, this.rBp);
        paramCanvas.drawArc(localRectF1, this.wSc - 90, this.wSa, true, this.wRV);
      }
      if (this.wSa == this.wSd)
      {
        i = this.wSc;
        j = this.wSd;
        this.wRZ = ao(this.wRZ, 360 - i - j, this.rBp);
        paramCanvas.drawArc(localRectF1, this.wSc - 90 + this.wSd, this.wRZ, true, this.wRW);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(22847);
      return;
      label363:
      if (this.wRY == this.wSc)
      {
        this.wSb = ao(this.wSb, this.wSe, this.rBp);
        paramCanvas.drawArc(localRectF2, this.wSc - 90, this.wSb, true, this.wRX);
      }
      if (this.wSb == this.wSe)
      {
        this.wSa = ao(this.wSa, this.wSd, this.rBp);
        paramCanvas.drawArc(localRectF1, this.wSe - 90 + this.wSc, this.wSa, true, this.wRV);
      }
      if (this.wSa == this.wSd)
      {
        i = this.wSc;
        j = this.wSd;
        int k = this.wSe;
        this.wRZ = ao(this.wRZ, 360 - i - j - k, this.rBp);
        paramCanvas.drawArc(localRectF1, this.wSc - 90 + this.wSd + this.wSe, this.wRZ, true, this.wRW);
      }
    }
  }
  
  public void setDeepGrayTargetAngle(int paramInt)
  {
    this.wSd = paramInt;
  }
  
  public void setGreenTargetAngle(int paramInt)
  {
    this.wSc = paramInt;
  }
  
  public void setOtherAccTargetAngle(int paramInt)
  {
    this.wSe = paramInt;
  }
  
  public void setStage(int paramInt)
  {
    this.hSE = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.PieView
 * JD-Core Version:    0.7.0.1
 */