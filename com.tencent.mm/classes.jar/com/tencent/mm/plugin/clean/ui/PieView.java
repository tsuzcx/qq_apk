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
  private int dBK;
  private Paint fSg;
  private int kyd;
  private Paint paV;
  private Paint paW;
  private Paint paX;
  private Paint paY;
  private Paint paZ;
  private Paint pba;
  private int pbb;
  private int pbc;
  private int pbd;
  private int pbe;
  private int pbf;
  private int pbg;
  private int pbh;
  private int pbi;
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22844);
    this.kyd = 6;
    this.pbh = 0;
    this.dBK = 0;
    this.pbi = -90;
    initView();
    AppMethodBeat.o(22844);
  }
  
  public PieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(22843);
    this.kyd = 6;
    this.pbh = 0;
    this.dBK = 0;
    this.pbi = -90;
    initView();
    AppMethodBeat.o(22843);
  }
  
  private static Paint Bf(int paramInt)
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
    this.fSg = Bf(-1);
    this.paV = Bf(-657931);
    this.paW = Bf(-2565928);
    this.paX = Bf(-15223279);
    this.paY = Bf(-7876878);
    this.paZ = Bf(-7876878);
    this.pba = Bf(-1644567);
    AppMethodBeat.o(22845);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(22847);
    float f1 = getMeasuredWidth() / 2;
    float f2 = getMeasuredHeight() / 2 + getTop();
    float f3 = getMeasuredHeight() / 3 + 15;
    RectF localRectF1 = new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    if (this.dBK == 0)
    {
      paramCanvas.drawCircle(f1, f2, f3, this.paV);
      paramCanvas.drawArc(localRectF1, this.pbi, 45.0F, true, this.paW);
      paramCanvas.drawCircle(f1, f2, f3 - 15.0F, this.fSg);
      this.pbi += 4;
      this.pbi %= 360;
    }
    RectF localRectF2;
    int i;
    int j;
    if (this.dBK == 1)
    {
      f3 = 10.0F + f3;
      localRectF2 = new RectF(f1 - f3, f2 - f3, f1 + f3, f3 + f2);
      this.pbb = V(this.pbb, this.pbf, this.kyd);
      paramCanvas.drawArc(localRectF2, -90.0F, this.pbb, true, this.paX);
      if (this.pbh > 0) {
        break label363;
      }
      if (this.pbb == this.pbf)
      {
        this.pbd = V(this.pbd, this.pbg, this.kyd);
        paramCanvas.drawArc(localRectF1, this.pbf - 90, this.pbd, true, this.paY);
      }
      if (this.pbd == this.pbg)
      {
        i = this.pbf;
        j = this.pbg;
        this.pbc = V(this.pbc, 360 - i - j, this.kyd);
        paramCanvas.drawArc(localRectF1, this.pbf - 90 + this.pbg, this.pbc, true, this.paZ);
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(22847);
      return;
      label363:
      if (this.pbb == this.pbf)
      {
        this.pbe = V(this.pbe, this.pbh, this.kyd);
        paramCanvas.drawArc(localRectF2, this.pbf - 90, this.pbe, true, this.pba);
      }
      if (this.pbe == this.pbh)
      {
        this.pbd = V(this.pbd, this.pbg, this.kyd);
        paramCanvas.drawArc(localRectF1, this.pbh - 90 + this.pbf, this.pbd, true, this.paY);
      }
      if (this.pbd == this.pbg)
      {
        i = this.pbf;
        j = this.pbg;
        int k = this.pbh;
        this.pbc = V(this.pbc, 360 - i - j - k, this.kyd);
        paramCanvas.drawArc(localRectF1, this.pbf - 90 + this.pbg + this.pbh, this.pbc, true, this.paZ);
      }
    }
  }
  
  public void setDeepGrayTargetAngle(int paramInt)
  {
    this.pbg = paramInt;
  }
  
  public void setGreenTargetAngle(int paramInt)
  {
    this.pbf = paramInt;
  }
  
  public void setOtherAccTargetAngle(int paramInt)
  {
    this.pbh = paramInt;
  }
  
  public void setStage(int paramInt)
  {
    this.dBK = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.PieView
 * JD-Core Version:    0.7.0.1
 */