package com.tencent.matrix.trace.view;

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
import com.tencent.matrix.trace.a.a;
import java.util.Iterator;
import java.util.LinkedList;

public class FloatFrameView$LineChartView
  extends View
{
  float fhA;
  float fhB;
  private Path fhC = new Path();
  private Path fhD = new Path();
  private float[] fhE = new float[2];
  private float[] fhF = new float[2];
  private int fhG = getContext().getResources().getColor(a.a.level_best_color);
  private int fhH = getContext().getResources().getColor(a.a.level_normal_color);
  private int fhI = getContext().getResources().getColor(a.a.level_middle_color);
  private int fhJ = getContext().getResources().getColor(a.a.level_high_color);
  private int fhK = getContext().getResources().getColor(a.a.level_frozen_color);
  private int fhL = getContext().getResources().getColor(a.a.dark_text);
  float fhM = dip2px(getContext(), 8.0F);
  float fhN;
  private final TextPaint fhw = new TextPaint(1);
  private final Paint fhx;
  private final Paint fhy;
  final LinkedList<a> fhz;
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
    paramContext = this.fhw;
    float f = dip2px(getContext(), 8.0F);
    this.textSize = f;
    paramContext.setTextSize(f);
    this.fhw.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.fhw.setColor(this.fhL);
    this.fhx = new TextPaint(1);
    this.fhx.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.fhx.setStyle(Paint.Style.STROKE);
    this.fhx.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
    this.fhy = new Paint(this.fhw);
    this.fhy.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.fhy.setColor(this.fhL);
    this.fhy.setStyle(Paint.Style.STROKE);
    this.fhy.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
    this.fhz = new LinkedList();
  }
  
  private static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Iterator localIterator = this.fhz.iterator();
    int i = 0;
    int j = 1;
    if (localIterator.hasNext())
    {
      Object localObject = (a)localIterator.next();
      int k = i + ((a)localObject).fps;
      if (((a)localObject).fhP.paint.getColor() != ((a)localObject).color) {
        ((a)localObject).fhP.paint.setColor(((a)localObject).color);
      }
      ((a)localObject).fhO[1] = ((j + 1) * ((a)localObject).fhP.fhA);
      ((a)localObject).fhO[3] = localObject.fhO[1];
      paramCanvas.drawLine(localObject.fhO[0], localObject.fhO[1], localObject.fhO[2], localObject.fhO[3], ((a)localObject).fhP.paint);
      float f;
      int m;
      if (j % 25 == 0)
      {
        Path localPath = new Path();
        f = localObject.fhO[1];
        localPath.moveTo(0.0F, f);
        localPath.lineTo(getMeasuredHeight(), f);
        paramCanvas.drawPath(localPath, this.fhy);
        this.fhw.setColor(this.fhL);
        paramCanvas.drawText(j / 5 + "s", 0.0F, this.textSize + f, this.fhw);
        if (j > 0)
        {
          m = k / j;
          localObject = this.fhw;
          if (m <= 57) {
            break label347;
          }
          i = this.fhG;
        }
      }
      for (;;)
      {
        ((TextPaint)localObject).setColor(i);
        paramCanvas.drawText(m + "FPS", 0.0F, f - this.textSize / 2.0F, this.fhw);
        i = k;
        j += 1;
        break;
        label347:
        if (m > 51) {
          i = this.fhH;
        } else if (m > 36) {
          i = this.fhI;
        } else if (m > 18) {
          i = this.fhJ;
        } else {
          i = this.fhK;
        }
      }
    }
    this.fhw.setColor(this.fhL);
    this.fhx.setColor(this.fhH);
    paramCanvas.drawPath(this.fhC, this.fhx);
    paramCanvas.drawText("50", this.fhE[0] - this.textSize / 2.0F, this.fhE[1] + this.textSize, this.fhw);
    this.fhx.setColor(this.fhI);
    paramCanvas.drawPath(this.fhD, this.fhx);
    paramCanvas.drawText("30", this.fhF[0] - this.textSize / 2.0F, this.fhF[1] + this.textSize, this.fhw);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.width = getMeasuredWidth();
      this.height = getMeasuredHeight();
      this.fhN = (this.width - 3.0F * this.fhM);
      this.fhB = dip2px(getContext(), 1.0F);
      this.paint.setStrokeWidth(this.fhB);
      this.fhA = (this.fhB * 2.0F);
      float f = this.fhN / 60.0F;
      this.fhE[0] = (10.0F * f + (this.width - this.fhN));
      this.fhE[1] = (this.fhA * 50.0F + this.fhM);
      this.fhC.moveTo(this.fhE[0], this.fhE[1]);
      this.fhC.lineTo(this.fhE[0], 0.0F);
      this.fhF[0] = (f * 30.0F + (this.width - this.fhN));
      this.fhF[1] = (this.fhA * 50.0F + this.fhM);
      this.fhD.moveTo(this.fhF[0], this.fhF[1]);
      this.fhD.lineTo(this.fhF[0], 0.0F);
    }
  }
  
  final class a
  {
    int color;
    float[] fhO = new float[4];
    int fps;
    
    a(int paramInt1, int paramInt2)
    {
      this.fps = paramInt1;
      this.color = paramInt2;
      this.fhO[0] = FloatFrameView.LineChartView.this.width;
      this.fhO[2] = ((60 - paramInt1) * FloatFrameView.LineChartView.this.fhN / 60.0F + (FloatFrameView.LineChartView.this.getWidth() - FloatFrameView.LineChartView.this.fhN));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView.LineChartView
 * JD-Core Version:    0.7.0.1
 */