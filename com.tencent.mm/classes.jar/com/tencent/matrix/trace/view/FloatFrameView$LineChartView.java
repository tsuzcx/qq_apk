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
  private int cEA = getContext().getResources().getColor(2131100532);
  private int cEB = getContext().getResources().getColor(2131100536);
  private int cEC = getContext().getResources().getColor(2131100535);
  private int cED = getContext().getResources().getColor(2131100534);
  private int cEE = getContext().getResources().getColor(2131100533);
  private int cEF = getContext().getResources().getColor(2131100202);
  float cEG = dip2px(getContext(), 8.0F);
  float cEH;
  private final TextPaint cEq = new TextPaint(1);
  private final Paint cEr;
  private final Paint cEs;
  final LinkedList<a> cEt;
  float cEu;
  float cEv;
  private Path cEw = new Path();
  private Path cEx = new Path();
  private float[] cEy = new float[2];
  private float[] cEz = new float[2];
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
    paramContext = this.cEq;
    float f = dip2px(getContext(), 8.0F);
    this.textSize = f;
    paramContext.setTextSize(f);
    this.cEq.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.cEq.setColor(this.cEF);
    this.cEr = new TextPaint(1);
    this.cEr.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.cEr.setStyle(Paint.Style.STROKE);
    this.cEr.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
    this.cEs = new Paint(this.cEq);
    this.cEs.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.cEs.setColor(this.cEF);
    this.cEs.setStyle(Paint.Style.STROKE);
    this.cEs.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
    this.cEt = new LinkedList();
  }
  
  private static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  @SuppressLint({"DefaultLocale"})
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Iterator localIterator = this.cEt.iterator();
    int i = 0;
    int j = 1;
    if (localIterator.hasNext())
    {
      Object localObject = (a)localIterator.next();
      int k = i + ((a)localObject).fps;
      if (((a)localObject).cEJ.paint.getColor() != ((a)localObject).color) {
        ((a)localObject).cEJ.paint.setColor(((a)localObject).color);
      }
      ((a)localObject).cEI[1] = ((j + 1) * ((a)localObject).cEJ.cEu);
      ((a)localObject).cEI[3] = localObject.cEI[1];
      paramCanvas.drawLine(localObject.cEI[0], localObject.cEI[1], localObject.cEI[2], localObject.cEI[3], ((a)localObject).cEJ.paint);
      float f;
      int m;
      if (j % 25 == 0)
      {
        Path localPath = new Path();
        f = localObject.cEI[1];
        localPath.moveTo(0.0F, f);
        localPath.lineTo(getMeasuredHeight(), f);
        paramCanvas.drawPath(localPath, this.cEs);
        this.cEq.setColor(this.cEF);
        paramCanvas.drawText(j / 5 + "s", 0.0F, this.textSize + f, this.cEq);
        if (j > 0)
        {
          m = k / j;
          localObject = this.cEq;
          if (m <= 57) {
            break label346;
          }
          i = this.cEA;
        }
      }
      for (;;)
      {
        ((TextPaint)localObject).setColor(i);
        paramCanvas.drawText(m + "FPS", 0.0F, f - this.textSize / 2.0F, this.cEq);
        i = k;
        j += 1;
        break;
        label346:
        if (m > 51) {
          i = this.cEB;
        } else if (m > 36) {
          i = this.cEC;
        } else if (m > 18) {
          i = this.cED;
        } else {
          i = this.cEE;
        }
      }
    }
    this.cEq.setColor(this.cEF);
    this.cEr.setColor(this.cEB);
    paramCanvas.drawPath(this.cEw, this.cEr);
    paramCanvas.drawText("50", this.cEy[0] - this.textSize / 2.0F, this.cEy[1] + this.textSize, this.cEq);
    this.cEr.setColor(this.cEC);
    paramCanvas.drawPath(this.cEx, this.cEr);
    paramCanvas.drawText("30", this.cEz[0] - this.textSize / 2.0F, this.cEz[1] + this.textSize, this.cEq);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.width = getMeasuredWidth();
      this.height = getMeasuredHeight();
      this.cEH = (this.width - 3.0F * this.cEG);
      this.cEv = dip2px(getContext(), 1.0F);
      this.paint.setStrokeWidth(this.cEv);
      this.cEu = (this.cEv * 2.0F);
      float f = this.cEH / 60.0F;
      this.cEy[0] = (10.0F * f + (this.width - this.cEH));
      this.cEy[1] = (this.cEu * 50.0F + this.cEG);
      this.cEw.moveTo(this.cEy[0], this.cEy[1]);
      this.cEw.lineTo(this.cEy[0], 0.0F);
      this.cEz[0] = (f * 30.0F + (this.width - this.cEH));
      this.cEz[1] = (this.cEu * 50.0F + this.cEG);
      this.cEx.moveTo(this.cEz[0], this.cEz[1]);
      this.cEx.lineTo(this.cEz[0], 0.0F);
    }
  }
  
  final class a
  {
    float[] cEI = new float[4];
    int color;
    int fps;
    
    a(int paramInt1, int paramInt2)
    {
      this.fps = paramInt1;
      this.color = paramInt2;
      this.cEI[0] = FloatFrameView.LineChartView.this.width;
      this.cEI[2] = ((60 - paramInt1) * FloatFrameView.LineChartView.this.cEH / 60.0F + (FloatFrameView.LineChartView.this.getWidth() - FloatFrameView.LineChartView.this.cEH));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView.LineChartView
 * JD-Core Version:    0.7.0.1
 */