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
  private int cAX;
  private int hAu;
  private int kHA;
  private int kHB;
  private int kHC;
  private int kHD;
  private int kHE;
  private Paint kHq;
  private Paint kHr;
  private Paint kHs;
  private Paint kHt;
  private Paint kHu;
  private Paint kHv;
  private Paint kHw;
  private int kHx;
  private int kHy;
  private int kHz;
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(18735);
    this.hAu = 6;
    this.kHD = 0;
    this.cAX = 0;
    this.kHE = -90;
    initView();
    AppMethodBeat.o(18735);
  }
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(18734);
    this.hAu = 6;
    this.kHD = 0;
    this.cAX = 0;
    this.kHE = -90;
    initView();
    AppMethodBeat.o(18734);
  }
  
  private static int P(int paramInt1, int paramInt2, int paramInt3)
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
    AppMethodBeat.i(18736);
    this.kHq = tz(-1);
    this.kHr = tz(-657931);
    this.kHs = tz(-2565928);
    this.kHt = tz(-15223279);
    this.kHu = tz(-7876878);
    this.kHv = tz(-7876878);
    this.kHw = tz(-1644567);
    AppMethodBeat.o(18736);
  }
  
  private static Paint tz(int paramInt)
  {
    AppMethodBeat.i(18737);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setColor(paramInt);
    AppMethodBeat.o(18737);
    return localPaint;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(18738);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2 + getTop();
    float f3 = getMeasuredHeight() / 3 + 15;
    RectF localRectF1 = new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    if (this.cAX == 0)
    {
      paramCanvas.drawCircle(f1, f2, f3, this.kHr);
      paramCanvas.drawArc(localRectF1, this.kHE, 45.0F, true, this.kHs);
      paramCanvas.drawCircle(f1, f2, f3 - 15.0F, this.kHq);
      this.kHE += 4;
      this.kHE %= 360;
    }
    RectF localRectF2;
    int i;
    int j;
    if (this.cAX == 1)
    {
      f3 = 10.0F + f3;
      localRectF2 = new RectF(f1 - f3, f2 - f3, f1 + f3, f3 + f2);
      this.kHx = P(this.kHx, this.kHB, this.hAu);
      paramCanvas.drawArc(localRectF2, -90.0F, this.kHx, true, this.kHt);
      if (this.kHD > 0) {
        break label363;
      }
      if (this.kHx == this.kHB)
      {
        this.kHz = P(this.kHz, this.kHC, this.hAu);
        paramCanvas.drawArc(localRectF1, this.kHB - 90, this.kHz, true, this.kHu);
      }
      if (this.kHz == this.kHC)
      {
        i = this.kHB;
        j = this.kHC;
        this.kHy = P(this.kHy, 360 - i - j, this.hAu);
        paramCanvas.drawArc(localRectF1, this.kHB - 90 + this.kHC, this.kHy, true, this.kHv);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(18738);
      return;
      label363:
      if (this.kHx == this.kHB)
      {
        this.kHA = P(this.kHA, this.kHD, this.hAu);
        paramCanvas.drawArc(localRectF2, this.kHB - 90, this.kHA, true, this.kHw);
      }
      if (this.kHA == this.kHD)
      {
        this.kHz = P(this.kHz, this.kHC, this.hAu);
        paramCanvas.drawArc(localRectF1, this.kHD - 90 + this.kHB, this.kHz, true, this.kHu);
      }
      if (this.kHz == this.kHC)
      {
        i = this.kHB;
        j = this.kHC;
        int k = this.kHD;
        this.kHy = P(this.kHy, 360 - i - j - k, this.hAu);
        paramCanvas.drawArc(localRectF1, this.kHB - 90 + this.kHC + this.kHD, this.kHy, true, this.kHv);
      }
    }
  }
  
  public void setDeepGrayTargetAngle(int paramInt)
  {
    this.kHC = paramInt;
  }
  
  public void setGreenTargetAngle(int paramInt)
  {
    this.kHB = paramInt;
  }
  
  public void setOtherAccTargetAngle(int paramInt)
  {
    this.kHD = paramInt;
  }
  
  public void setStage(int paramInt)
  {
    this.cAX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.PieView
 * JD-Core Version:    0.7.0.1
 */