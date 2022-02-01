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
  private int fMU;
  private Paint jbC;
  private int oxQ;
  private Paint tOC;
  private Paint tOD;
  private Paint tOE;
  private Paint tOF;
  private Paint tOG;
  private Paint tOH;
  private int tOI;
  private int tOJ;
  private int tOK;
  private int tOL;
  private int tOM;
  private int tON;
  private int tOO;
  private int tOP;
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22844);
    this.oxQ = 6;
    this.tOO = 0;
    this.fMU = 0;
    this.tOP = -90;
    initView();
    AppMethodBeat.o(22844);
  }
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(22843);
    this.oxQ = 6;
    this.tOO = 0;
    this.fMU = 0;
    this.tOP = -90;
    initView();
    AppMethodBeat.o(22843);
  }
  
  private static Paint Iu(int paramInt)
  {
    AppMethodBeat.i(22846);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setColor(paramInt);
    AppMethodBeat.o(22846);
    return localPaint;
  }
  
  private static int X(int paramInt1, int paramInt2, int paramInt3)
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
    this.jbC = Iu(-1);
    this.tOC = Iu(-657931);
    this.tOD = Iu(-2565928);
    this.tOE = Iu(-15223279);
    this.tOF = Iu(-7876878);
    this.tOG = Iu(-7876878);
    this.tOH = Iu(-1644567);
    AppMethodBeat.o(22845);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(22847);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2 + getTop();
    float f3 = getMeasuredHeight() / 3 + 15;
    RectF localRectF1 = new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    if (this.fMU == 0)
    {
      paramCanvas.drawCircle(f1, f2, f3, this.tOC);
      paramCanvas.drawArc(localRectF1, this.tOP, 45.0F, true, this.tOD);
      paramCanvas.drawCircle(f1, f2, f3 - 15.0F, this.jbC);
      this.tOP += 4;
      this.tOP %= 360;
    }
    RectF localRectF2;
    int i;
    int j;
    if (this.fMU == 1)
    {
      f3 = 10.0F + f3;
      localRectF2 = new RectF(f1 - f3, f2 - f3, f1 + f3, f3 + f2);
      this.tOI = X(this.tOI, this.tOM, this.oxQ);
      paramCanvas.drawArc(localRectF2, -90.0F, this.tOI, true, this.tOE);
      if (this.tOO > 0) {
        break label363;
      }
      if (this.tOI == this.tOM)
      {
        this.tOK = X(this.tOK, this.tON, this.oxQ);
        paramCanvas.drawArc(localRectF1, this.tOM - 90, this.tOK, true, this.tOF);
      }
      if (this.tOK == this.tON)
      {
        i = this.tOM;
        j = this.tON;
        this.tOJ = X(this.tOJ, 360 - i - j, this.oxQ);
        paramCanvas.drawArc(localRectF1, this.tOM - 90 + this.tON, this.tOJ, true, this.tOG);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(22847);
      return;
      label363:
      if (this.tOI == this.tOM)
      {
        this.tOL = X(this.tOL, this.tOO, this.oxQ);
        paramCanvas.drawArc(localRectF2, this.tOM - 90, this.tOL, true, this.tOH);
      }
      if (this.tOL == this.tOO)
      {
        this.tOK = X(this.tOK, this.tON, this.oxQ);
        paramCanvas.drawArc(localRectF1, this.tOO - 90 + this.tOM, this.tOK, true, this.tOF);
      }
      if (this.tOK == this.tON)
      {
        i = this.tOM;
        j = this.tON;
        int k = this.tOO;
        this.tOJ = X(this.tOJ, 360 - i - j - k, this.oxQ);
        paramCanvas.drawArc(localRectF1, this.tOM - 90 + this.tON + this.tOO, this.tOJ, true, this.tOG);
      }
    }
  }
  
  public void setDeepGrayTargetAngle(int paramInt)
  {
    this.tON = paramInt;
  }
  
  public void setGreenTargetAngle(int paramInt)
  {
    this.tOM = paramInt;
  }
  
  public void setOtherAccTargetAngle(int paramInt)
  {
    this.tOO = paramInt;
  }
  
  public void setStage(int paramInt)
  {
    this.fMU = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.PieView
 * JD-Core Version:    0.7.0.1
 */