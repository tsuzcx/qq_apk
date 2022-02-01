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
  final LinkedList<FloatFrameView.LineChartView.a> cMA;
  float cMB;
  float cMC;
  private Path cMD = new Path();
  private Path cME = new Path();
  private float[] cMF = new float[2];
  private float[] cMG = new float[2];
  private int cMH = getContext().getResources().getColor(2131100532);
  private int cMI = getContext().getResources().getColor(2131100536);
  private int cMJ = getContext().getResources().getColor(2131100535);
  private int cMK = getContext().getResources().getColor(2131100534);
  private int cML = getContext().getResources().getColor(2131100533);
  private int cMM = getContext().getResources().getColor(2131100202);
  float cMN = dip2px(getContext(), 8.0F);
  float cMO;
  private final TextPaint cMx = new TextPaint(1);
  private final Paint cMy;
  private final Paint cMz;
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
    paramContext = this.cMx;
    float f = dip2px(getContext(), 8.0F);
    this.textSize = f;
    paramContext.setTextSize(f);
    this.cMx.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.cMx.setColor(this.cMM);
    this.cMy = new TextPaint(1);
    this.cMy.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.cMy.setStyle(Paint.Style.STROKE);
    this.cMy.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
    this.cMz = new Paint(this.cMx);
    this.cMz.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.cMz.setColor(this.cMM);
    this.cMz.setStyle(Paint.Style.STROKE);
    this.cMz.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
    this.cMA = new LinkedList();
  }
  
  private static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  @SuppressLint({"DefaultLocale"})
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Iterator localIterator = this.cMA.iterator();
    int i = 0;
    int j = 1;
    if (localIterator.hasNext())
    {
      Object localObject = (FloatFrameView.LineChartView.a)localIterator.next();
      int k = i + ((FloatFrameView.LineChartView.a)localObject).fps;
      if (((FloatFrameView.LineChartView.a)localObject).cMQ.paint.getColor() != ((FloatFrameView.LineChartView.a)localObject).color) {
        ((FloatFrameView.LineChartView.a)localObject).cMQ.paint.setColor(((FloatFrameView.LineChartView.a)localObject).color);
      }
      ((FloatFrameView.LineChartView.a)localObject).cMP[1] = ((j + 1) * ((FloatFrameView.LineChartView.a)localObject).cMQ.cMB);
      ((FloatFrameView.LineChartView.a)localObject).cMP[3] = localObject.cMP[1];
      paramCanvas.drawLine(localObject.cMP[0], localObject.cMP[1], localObject.cMP[2], localObject.cMP[3], ((FloatFrameView.LineChartView.a)localObject).cMQ.paint);
      float f;
      int m;
      if (j % 25 == 0)
      {
        Path localPath = new Path();
        f = localObject.cMP[1];
        localPath.moveTo(0.0F, f);
        localPath.lineTo(getMeasuredHeight(), f);
        paramCanvas.drawPath(localPath, this.cMz);
        this.cMx.setColor(this.cMM);
        paramCanvas.drawText(j / 5 + "s", 0.0F, this.textSize + f, this.cMx);
        if (j > 0)
        {
          m = k / j;
          localObject = this.cMx;
          if (m <= 57) {
            break label346;
          }
          i = this.cMH;
        }
      }
      for (;;)
      {
        ((TextPaint)localObject).setColor(i);
        paramCanvas.drawText(m + "FPS", 0.0F, f - this.textSize / 2.0F, this.cMx);
        i = k;
        j += 1;
        break;
        label346:
        if (m > 51) {
          i = this.cMI;
        } else if (m > 36) {
          i = this.cMJ;
        } else if (m > 18) {
          i = this.cMK;
        } else {
          i = this.cML;
        }
      }
    }
    this.cMx.setColor(this.cMM);
    this.cMy.setColor(this.cMI);
    paramCanvas.drawPath(this.cMD, this.cMy);
    paramCanvas.drawText("50", this.cMF[0] - this.textSize / 2.0F, this.cMF[1] + this.textSize, this.cMx);
    this.cMy.setColor(this.cMJ);
    paramCanvas.drawPath(this.cME, this.cMy);
    paramCanvas.drawText("30", this.cMG[0] - this.textSize / 2.0F, this.cMG[1] + this.textSize, this.cMx);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.width = getMeasuredWidth();
      this.height = getMeasuredHeight();
      this.cMO = (this.width - 3.0F * this.cMN);
      this.cMC = dip2px(getContext(), 1.0F);
      this.paint.setStrokeWidth(this.cMC);
      this.cMB = (this.cMC * 2.0F);
      float f = this.cMO / 60.0F;
      this.cMF[0] = (10.0F * f + (this.width - this.cMO));
      this.cMF[1] = (this.cMB * 50.0F + this.cMN);
      this.cMD.moveTo(this.cMF[0], this.cMF[1]);
      this.cMD.lineTo(this.cMF[0], 0.0F);
      this.cMG[0] = (f * 30.0F + (this.width - this.cMO));
      this.cMG[1] = (this.cMB * 50.0F + this.cMN);
      this.cME.moveTo(this.cMG[0], this.cMG[1]);
      this.cME.lineTo(this.cMG[0], 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView.LineChartView
 * JD-Core Version:    0.7.0.1
 */