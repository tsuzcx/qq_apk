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
  public TextView cMS;
  public LineChartView cMT;
  public TextView cMU;
  public TextView cMV;
  public TextView cMW;
  public TextView cMX;
  public TextView cMY;
  public TextView cMZ;
  public TextView cNa;
  public TextView cNb;
  public TextView cNc;
  public TextView cNd;
  public TextView cNe;
  public TextView cNf;
  
  public FloatFrameView(Context paramContext)
  {
    super(paramContext);
    aN(paramContext);
  }
  
  public FloatFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    aN(paramContext);
  }
  
  private void aN(Context paramContext)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    LayoutInflater.from(paramContext).inflate(2131494143, this);
    this.cMS = ((TextView)findViewById(2131300235));
    this.cNc = ((TextView)findViewById(2131299636));
    this.cNd = ((TextView)findViewById(2131304347));
    this.cNc.setText("{other info}");
    this.cNe = ((TextView)findViewById(2131303552));
    this.cMU = ((TextView)findViewById(2131301398));
    this.cMV = ((TextView)findViewById(2131301399));
    this.cMW = ((TextView)findViewById(2131301400));
    this.cMX = ((TextView)findViewById(2131301401));
    this.cNf = ((TextView)findViewById(2131305545));
    this.cMY = ((TextView)findViewById(2131305541));
    this.cMZ = ((TextView)findViewById(2131305542));
    this.cNa = ((TextView)findViewById(2131305543));
    this.cNb = ((TextView)findViewById(2131305544));
    this.cMT = ((LineChartView)findViewById(2131297955));
  }
  
  public static class LineChartView
    extends View
  {
    private final TextPaint cNg = new TextPaint(1);
    private final Paint cNh;
    private final Paint cNi;
    final LinkedList<a> cNj;
    float cNk;
    float cNl;
    private Path cNm = new Path();
    private Path cNn = new Path();
    private float[] cNo = new float[2];
    private float[] cNp = new float[2];
    private int cNq = getContext().getResources().getColor(2131100532);
    private int cNr = getContext().getResources().getColor(2131100536);
    private int cNs = getContext().getResources().getColor(2131100535);
    private int cNt = getContext().getResources().getColor(2131100534);
    private int cNu = getContext().getResources().getColor(2131100533);
    private int cNv = getContext().getResources().getColor(2131100202);
    float cNw = dip2px(getContext(), 8.0F);
    float cNx;
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
      paramContext = this.cNg;
      float f = dip2px(getContext(), 8.0F);
      this.textSize = f;
      paramContext.setTextSize(f);
      this.cNg.setStrokeWidth(dip2px(getContext(), 1.0F));
      this.cNg.setColor(this.cNv);
      this.cNh = new TextPaint(1);
      this.cNh.setStrokeWidth(dip2px(getContext(), 1.0F));
      this.cNh.setStyle(Paint.Style.STROKE);
      this.cNh.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
      this.cNi = new Paint(this.cNg);
      this.cNi.setStrokeWidth(dip2px(getContext(), 1.0F));
      this.cNi.setColor(this.cNv);
      this.cNi.setStyle(Paint.Style.STROKE);
      this.cNi.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
      this.cNj = new LinkedList();
    }
    
    private static int dip2px(Context paramContext, float paramFloat)
    {
      return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    }
    
    @SuppressLint({"DefaultLocale"})
    public void draw(Canvas paramCanvas)
    {
      super.draw(paramCanvas);
      Iterator localIterator = this.cNj.iterator();
      int i = 0;
      int j = 1;
      if (localIterator.hasNext())
      {
        Object localObject = (a)localIterator.next();
        int k = i + ((a)localObject).fps;
        if (((a)localObject).cNz.paint.getColor() != ((a)localObject).color) {
          ((a)localObject).cNz.paint.setColor(((a)localObject).color);
        }
        ((a)localObject).cNy[1] = ((j + 1) * ((a)localObject).cNz.cNk);
        ((a)localObject).cNy[3] = localObject.cNy[1];
        paramCanvas.drawLine(localObject.cNy[0], localObject.cNy[1], localObject.cNy[2], localObject.cNy[3], ((a)localObject).cNz.paint);
        float f;
        int m;
        if (j % 25 == 0)
        {
          Path localPath = new Path();
          f = localObject.cNy[1];
          localPath.moveTo(0.0F, f);
          localPath.lineTo(getMeasuredHeight(), f);
          paramCanvas.drawPath(localPath, this.cNi);
          this.cNg.setColor(this.cNv);
          paramCanvas.drawText(j / 5 + "s", 0.0F, this.textSize + f, this.cNg);
          if (j > 0)
          {
            m = k / j;
            localObject = this.cNg;
            if (m <= 57) {
              break label346;
            }
            i = this.cNq;
          }
        }
        for (;;)
        {
          ((TextPaint)localObject).setColor(i);
          paramCanvas.drawText(m + "FPS", 0.0F, f - this.textSize / 2.0F, this.cNg);
          i = k;
          j += 1;
          break;
          label346:
          if (m > 51) {
            i = this.cNr;
          } else if (m > 36) {
            i = this.cNs;
          } else if (m > 18) {
            i = this.cNt;
          } else {
            i = this.cNu;
          }
        }
      }
      this.cNg.setColor(this.cNv);
      this.cNh.setColor(this.cNr);
      paramCanvas.drawPath(this.cNm, this.cNh);
      paramCanvas.drawText("50", this.cNo[0] - this.textSize / 2.0F, this.cNo[1] + this.textSize, this.cNg);
      this.cNh.setColor(this.cNs);
      paramCanvas.drawPath(this.cNn, this.cNh);
      paramCanvas.drawText("30", this.cNp[0] - this.textSize / 2.0F, this.cNp[1] + this.textSize, this.cNg);
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramBoolean)
      {
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        this.cNx = (this.width - 3.0F * this.cNw);
        this.cNl = dip2px(getContext(), 1.0F);
        this.paint.setStrokeWidth(this.cNl);
        this.cNk = (this.cNl * 2.0F);
        float f = this.cNx / 60.0F;
        this.cNo[0] = (10.0F * f + (this.width - this.cNx));
        this.cNo[1] = (this.cNk * 50.0F + this.cNw);
        this.cNm.moveTo(this.cNo[0], this.cNo[1]);
        this.cNm.lineTo(this.cNo[0], 0.0F);
        this.cNp[0] = (f * 30.0F + (this.width - this.cNx));
        this.cNp[1] = (this.cNk * 50.0F + this.cNw);
        this.cNn.moveTo(this.cNp[0], this.cNp[1]);
        this.cNn.lineTo(this.cNp[0], 0.0F);
      }
    }
    
    final class a
    {
      float[] cNy = new float[4];
      int color;
      int fps;
      
      a(int paramInt1, int paramInt2)
      {
        this.fps = paramInt1;
        this.color = paramInt2;
        this.cNy[0] = FloatFrameView.LineChartView.this.width;
        this.cNy[2] = ((60 - paramInt1) * FloatFrameView.LineChartView.this.cNx / 60.0F + (FloatFrameView.LineChartView.this.getWidth() - FloatFrameView.LineChartView.this.cNx));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView
 * JD-Core Version:    0.7.0.1
 */