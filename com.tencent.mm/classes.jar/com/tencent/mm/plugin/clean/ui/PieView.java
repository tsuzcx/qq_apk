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
  private int dAF;
  private Paint fQa;
  private int kuN;
  private int oUA;
  private int oUB;
  private int oUC;
  private int oUD;
  private int oUE;
  private int oUF;
  private Paint oUs;
  private Paint oUt;
  private Paint oUu;
  private Paint oUv;
  private Paint oUw;
  private Paint oUx;
  private int oUy;
  private int oUz;
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22844);
    this.kuN = 6;
    this.oUE = 0;
    this.dAF = 0;
    this.oUF = -90;
    initView();
    AppMethodBeat.o(22844);
  }
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(22843);
    this.kuN = 6;
    this.oUE = 0;
    this.dAF = 0;
    this.oUF = -90;
    initView();
    AppMethodBeat.o(22843);
  }
  
  private static Paint AT(int paramInt)
  {
    AppMethodBeat.i(22846);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setColor(paramInt);
    AppMethodBeat.o(22846);
    return localPaint;
  }
  
  private static int V(int paramInt1, int paramInt2, int paramInt3)
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
    this.fQa = AT(-1);
    this.oUs = AT(-657931);
    this.oUt = AT(-2565928);
    this.oUu = AT(-15223279);
    this.oUv = AT(-7876878);
    this.oUw = AT(-7876878);
    this.oUx = AT(-1644567);
    AppMethodBeat.o(22845);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(22847);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2 + getTop();
    float f3 = getMeasuredHeight() / 3 + 15;
    RectF localRectF1 = new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    if (this.dAF == 0)
    {
      paramCanvas.drawCircle(f1, f2, f3, this.oUs);
      paramCanvas.drawArc(localRectF1, this.oUF, 45.0F, true, this.oUt);
      paramCanvas.drawCircle(f1, f2, f3 - 15.0F, this.fQa);
      this.oUF += 4;
      this.oUF %= 360;
    }
    RectF localRectF2;
    int i;
    int j;
    if (this.dAF == 1)
    {
      f3 = 10.0F + f3;
      localRectF2 = new RectF(f1 - f3, f2 - f3, f1 + f3, f3 + f2);
      this.oUy = V(this.oUy, this.oUC, this.kuN);
      paramCanvas.drawArc(localRectF2, -90.0F, this.oUy, true, this.oUu);
      if (this.oUE > 0) {
        break label363;
      }
      if (this.oUy == this.oUC)
      {
        this.oUA = V(this.oUA, this.oUD, this.kuN);
        paramCanvas.drawArc(localRectF1, this.oUC - 90, this.oUA, true, this.oUv);
      }
      if (this.oUA == this.oUD)
      {
        i = this.oUC;
        j = this.oUD;
        this.oUz = V(this.oUz, 360 - i - j, this.kuN);
        paramCanvas.drawArc(localRectF1, this.oUC - 90 + this.oUD, this.oUz, true, this.oUw);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(22847);
      return;
      label363:
      if (this.oUy == this.oUC)
      {
        this.oUB = V(this.oUB, this.oUE, this.kuN);
        paramCanvas.drawArc(localRectF2, this.oUC - 90, this.oUB, true, this.oUx);
      }
      if (this.oUB == this.oUE)
      {
        this.oUA = V(this.oUA, this.oUD, this.kuN);
        paramCanvas.drawArc(localRectF1, this.oUE - 90 + this.oUC, this.oUA, true, this.oUv);
      }
      if (this.oUA == this.oUD)
      {
        i = this.oUC;
        j = this.oUD;
        int k = this.oUE;
        this.oUz = V(this.oUz, 360 - i - j - k, this.kuN);
        paramCanvas.drawArc(localRectF1, this.oUC - 90 + this.oUD + this.oUE, this.oUz, true, this.oUw);
      }
    }
  }
  
  public void setDeepGrayTargetAngle(int paramInt)
  {
    this.oUD = paramInt;
  }
  
  public void setGreenTargetAngle(int paramInt)
  {
    this.oUC = paramInt;
  }
  
  public void setOtherAccTargetAngle(int paramInt)
  {
    this.oUE = paramInt;
  }
  
  public void setStage(int paramInt)
  {
    this.dAF = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.PieView
 * JD-Core Version:    0.7.0.1
 */