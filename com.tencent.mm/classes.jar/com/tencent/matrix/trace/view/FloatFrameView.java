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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.LinkedList;

public class FloatFrameView
  extends LinearLayout
{
  public TextView bSW;
  public LineChartView bSX;
  
  public FloatFrameView(Context paramContext)
  {
    super(paramContext);
    aA(paramContext);
  }
  
  public FloatFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    aA(paramContext);
  }
  
  private void aA(Context paramContext)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    LayoutInflater.from(paramContext).inflate(2130969603, this);
    this.bSW = ((TextView)findViewById(2131824190));
    this.bSX = ((LineChartView)findViewById(2131824191));
  }
  
  public static class LineChartView
    extends View
  {
    private final TextPaint bSY = new TextPaint();
    private final Paint bSZ;
    private final Paint bTa;
    final LinkedList<a> bTb;
    float bTc;
    float bTd;
    private Path bTe = new Path();
    private float[] bTf = new float[2];
    private Path bTg = new Path();
    private float[] bTh = new float[2];
    private int bTi = getContext().getResources().getColor(17170453);
    private int bTj = getContext().getResources().getColor(17170457);
    private int bTk = getContext().getResources().getColor(17170455);
    private int bTl = getContext().getResources().getColor(17170432);
    float bTm = 10.0F * getContext().getResources().getDisplayMetrics().density;
    float bTn;
    float height;
    private final Paint paint = new Paint();
    float textSize;
    float width;
    
    public LineChartView(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, 0);
    }
    
    public LineChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      paramContext = this.bSY;
      float f = 8.0F * getContext().getResources().getDisplayMetrics().density;
      this.textSize = f;
      paramContext.setTextSize(f);
      this.bSY.setStrokeWidth(3.0F);
      this.bSY.setColor(this.bTl);
      this.bSZ = new TextPaint();
      this.bSZ.setStrokeWidth(2.0F);
      this.bSZ.setStyle(Paint.Style.STROKE);
      this.bTa = new Paint(this.bSY);
      this.bTa.setStrokeWidth(2.0F);
      this.bTa.setColor(this.bTl);
      this.bTa.setStyle(Paint.Style.STROKE);
      this.bTa.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
      this.bTb = new LinkedList();
    }
    
    private int getColor(int paramInt)
    {
      if (paramInt >= 50) {
        return this.bTi;
      }
      if (paramInt >= 30) {
        return this.bTj;
      }
      return this.bTk;
    }
    
    public void draw(Canvas paramCanvas)
    {
      super.draw(paramCanvas);
      Iterator localIterator = this.bTb.iterator();
      int j = 0;
      int i = 1;
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        j += locala.fps;
        if (locala.bTp.paint.getColor() != locala.color) {
          locala.bTp.paint.setColor(locala.color);
        }
        locala.bTo[1] = ((i + 1) * locala.bTp.bTc);
        locala.bTo[3] = locala.bTo[1];
        paramCanvas.drawLine(locala.bTo[0], locala.bTo[1], locala.bTo[2], locala.bTo[3], locala.bTp.paint);
        if ((i % 25 == 0) || (i == 0))
        {
          Path localPath = new Path();
          float f = locala.bTo[1];
          localPath.moveTo(0.0F, f);
          localPath.lineTo(getMeasuredHeight(), f);
          paramCanvas.drawPath(localPath, this.bTa);
          this.bSY.setColor(this.bTl);
          paramCanvas.drawText(i / 5 + "s", 0.0F, this.textSize + f, this.bSY);
          if (i > 0)
          {
            int k = j / i;
            this.bSY.setColor(getColor(k));
            paramCanvas.drawText(k + " FPS", 0.0F, f - this.textSize / 2.0F, this.bSY);
          }
        }
        i += 1;
      }
      this.bSY.setColor(this.bTl);
      this.bSZ.setColor(this.bTi);
      paramCanvas.drawPath(this.bTe, this.bSZ);
      paramCanvas.drawText("50", this.bTf[0] - this.textSize / 2.0F, this.bTf[1], this.bSY);
      this.bSZ.setColor(this.bTj);
      paramCanvas.drawPath(this.bTg, this.bSZ);
      paramCanvas.drawText("30  FPS", this.bTh[0] - this.textSize / 2.0F, this.bTh[1], this.bSY);
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramBoolean)
      {
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        this.bTn = (this.width - this.bTm);
        this.bTd = ((this.height - this.bTm * 2.0F) / 150.0F);
        this.paint.setStrokeWidth(this.bTd);
        this.bTc = (this.bTd * 2.0F);
        float f = this.bTn / 60.0F;
        this.bTf[0] = (10.0F * f + this.bTm);
        this.bTf[1] = this.height;
        this.bTe.moveTo(this.bTf[0], this.height - this.textSize);
        this.bTe.lineTo(this.bTf[0], 0.0F);
        this.bTh[0] = (f * 30.0F + this.bTm);
        this.bTh[1] = this.height;
        this.bTg.moveTo(this.bTh[0], this.height - this.textSize);
        this.bTg.lineTo(this.bTh[0], 0.0F);
      }
    }
    
    final class a
    {
      float[] bTo = new float[4];
      int color;
      int fps;
      
      public a(int paramInt)
      {
        this.fps = paramInt;
        this.color = FloatFrameView.LineChartView.a(FloatFrameView.LineChartView.this, paramInt);
        this.bTo[0] = FloatFrameView.LineChartView.this.width;
        this.bTo[2] = ((60 - paramInt) * FloatFrameView.LineChartView.this.bTn / 60.0F + FloatFrameView.LineChartView.this.bTm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView
 * JD-Core Version:    0.7.0.1
 */