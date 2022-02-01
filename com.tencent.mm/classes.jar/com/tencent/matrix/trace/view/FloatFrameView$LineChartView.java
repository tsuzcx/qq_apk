package com.tencent.matrix.trace.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

public class FloatFrameView$LineChartView
  extends View
{
  private final TextPaint ddE = new TextPaint(1);
  private final Paint ddF;
  private final Paint ddG;
  final LinkedList<FloatFrameView.LineChartView.a> ddH;
  float ddI;
  float ddJ;
  private Path ddK = new Path();
  private Path ddL = new Path();
  private float[] ddM = new float[2];
  private float[] ddN = new float[2];
  private int ddO = getContext().getResources().getColor(2131100670);
  private int ddP = getContext().getResources().getColor(2131100674);
  private int ddQ = getContext().getResources().getColor(2131100673);
  private int ddR = getContext().getResources().getColor(2131100672);
  private int ddS = getContext().getResources().getColor(2131100671);
  private int ddT = getContext().getResources().getColor(2131100235);
  float ddU = dip2px(getContext(), 8.0F);
  float ddV;
  float height;
  private final Paint paint = new Paint();
  float textSize;
  float width;
  
  public FloatFrameView$LineChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatFrameView$LineChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = this.ddE;
    float f = dip2px(getContext(), 8.0F);
    this.textSize = f;
    paramContext.setTextSize(f);
    this.ddE.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.ddE.setColor(this.ddT);
    this.ddF = new TextPaint(1);
    this.ddF.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.ddF.setStyle(Paint.Style.STROKE);
    this.ddF.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
    this.ddG = new Paint(this.ddE);
    this.ddG.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.ddG.setColor(this.ddT);
    this.ddG.setStyle(Paint.Style.STROKE);
    this.ddG.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
    this.ddH = new LinkedList();
  }
  
  private static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  @SuppressLint({"DefaultLocale"})
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Iterator localIterator = this.ddH.iterator();
    int i = 0;
    int j = 1;
    if (localIterator.hasNext())
    {
      Object localObject = (FloatFrameView.LineChartView.a)localIterator.next();
      int k = i + ((FloatFrameView.LineChartView.a)localObject).fps;
      if (((FloatFrameView.LineChartView.a)localObject).ddX.paint.getColor() != ((FloatFrameView.LineChartView.a)localObject).color) {
        ((FloatFrameView.LineChartView.a)localObject).ddX.paint.setColor(((FloatFrameView.LineChartView.a)localObject).color);
      }
      ((FloatFrameView.LineChartView.a)localObject).ddW[1] = ((j + 1) * ((FloatFrameView.LineChartView.a)localObject).ddX.ddI);
      ((FloatFrameView.LineChartView.a)localObject).ddW[3] = localObject.ddW[1];
      paramCanvas.drawLine(localObject.ddW[0], localObject.ddW[1], localObject.ddW[2], localObject.ddW[3], ((FloatFrameView.LineChartView.a)localObject).ddX.paint);
      float f;
      int m;
      if (j % 25 == 0)
      {
        Path localPath = new Path();
        f = localObject.ddW[1];
        localPath.moveTo(0.0F, f);
        localPath.lineTo(getMeasuredHeight(), f);
        paramCanvas.drawPath(localPath, this.ddG);
        this.ddE.setColor(this.ddT);
        paramCanvas.drawText(j / 5 + "s", 0.0F, this.textSize + f, this.ddE);
        if (j > 0)
        {
          m = k / j;
          localObject = this.ddE;
          if (m <= 57) {
            break label346;
          }
          i = this.ddO;
        }
      }
      for (;;)
      {
        ((TextPaint)localObject).setColor(i);
        paramCanvas.drawText(m + "FPS", 0.0F, f - this.textSize / 2.0F, this.ddE);
        i = k;
        j += 1;
        break;
        label346:
        if (m > 51) {
          i = this.ddP;
        } else if (m > 36) {
          i = this.ddQ;
        } else if (m > 18) {
          i = this.ddR;
        } else {
          i = this.ddS;
        }
      }
    }
    this.ddE.setColor(this.ddT);
    this.ddF.setColor(this.ddP);
    paramCanvas.drawPath(this.ddK, this.ddF);
    paramCanvas.drawText("50", this.ddM[0] - this.textSize / 2.0F, this.ddM[1] + this.textSize, this.ddE);
    this.ddF.setColor(this.ddQ);
    paramCanvas.drawPath(this.ddL, this.ddF);
    paramCanvas.drawText("30", this.ddN[0] - this.textSize / 2.0F, this.ddN[1] + this.textSize, this.ddE);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.width = getMeasuredWidth();
      this.height = getMeasuredHeight();
      this.ddV = (this.width - 3.0F * this.ddU);
      this.ddJ = dip2px(getContext(), 1.0F);
      this.paint.setStrokeWidth(this.ddJ);
      this.ddI = (this.ddJ * 2.0F);
      float f = this.ddV / 60.0F;
      this.ddM[0] = (10.0F * f + (this.width - this.ddV));
      this.ddM[1] = (this.ddI * 50.0F + this.ddU);
      this.ddK.moveTo(this.ddM[0], this.ddM[1]);
      this.ddK.lineTo(this.ddM[0], 0.0F);
      this.ddN[0] = (f * 30.0F + (this.width - this.ddV));
      this.ddN[1] = (this.ddI * 50.0F + this.ddU);
      this.ddL.moveTo(this.ddN[0], this.ddN[1]);
      this.ddL.lineTo(this.ddN[0], 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView.LineChartView
 * JD-Core Version:    0.7.0.1
 */