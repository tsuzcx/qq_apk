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
  public TextView cBk;
  public LineChartView cBl;
  public TextView cBm;
  public TextView cBn;
  public TextView cBo;
  public TextView cBp;
  public TextView cBq;
  public TextView cBr;
  public TextView cBs;
  public TextView cBt;
  public TextView cBu;
  public TextView cBv;
  public TextView cBw;
  public TextView cBx;
  
  public FloatFrameView(Context paramContext)
  {
    super(paramContext);
    aM(paramContext);
  }
  
  public FloatFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    aM(paramContext);
  }
  
  private void aM(Context paramContext)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    LayoutInflater.from(paramContext).inflate(2131494143, this);
    this.cBk = ((TextView)findViewById(2131300235));
    this.cBu = ((TextView)findViewById(2131299636));
    this.cBv = ((TextView)findViewById(2131304347));
    this.cBu.setText("{other info}");
    this.cBw = ((TextView)findViewById(2131303552));
    this.cBm = ((TextView)findViewById(2131301398));
    this.cBn = ((TextView)findViewById(2131301399));
    this.cBo = ((TextView)findViewById(2131301400));
    this.cBp = ((TextView)findViewById(2131301401));
    this.cBx = ((TextView)findViewById(2131305545));
    this.cBq = ((TextView)findViewById(2131305541));
    this.cBr = ((TextView)findViewById(2131305542));
    this.cBs = ((TextView)findViewById(2131305543));
    this.cBt = ((TextView)findViewById(2131305544));
    this.cBl = ((LineChartView)findViewById(2131297955));
  }
  
  public static class LineChartView
    extends View
  {
    private final Paint cBA;
    final LinkedList<a> cBB;
    float cBC;
    float cBD;
    private Path cBE = new Path();
    private Path cBF = new Path();
    private float[] cBG = new float[2];
    private float[] cBH = new float[2];
    private int cBI = getContext().getResources().getColor(2131100532);
    private int cBJ = getContext().getResources().getColor(2131100536);
    private int cBK = getContext().getResources().getColor(2131100535);
    private int cBL = getContext().getResources().getColor(2131100534);
    private int cBM = getContext().getResources().getColor(2131100533);
    private int cBN = getContext().getResources().getColor(2131100202);
    float cBO = dip2px(getContext(), 8.0F);
    float cBP;
    private final TextPaint cBy = new TextPaint(1);
    private final Paint cBz;
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
      paramContext = this.cBy;
      float f = dip2px(getContext(), 8.0F);
      this.textSize = f;
      paramContext.setTextSize(f);
      this.cBy.setStrokeWidth(dip2px(getContext(), 1.0F));
      this.cBy.setColor(this.cBN);
      this.cBz = new TextPaint(1);
      this.cBz.setStrokeWidth(dip2px(getContext(), 1.0F));
      this.cBz.setStyle(Paint.Style.STROKE);
      this.cBz.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
      this.cBA = new Paint(this.cBy);
      this.cBA.setStrokeWidth(dip2px(getContext(), 1.0F));
      this.cBA.setColor(this.cBN);
      this.cBA.setStyle(Paint.Style.STROKE);
      this.cBA.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
      this.cBB = new LinkedList();
    }
    
    private static int dip2px(Context paramContext, float paramFloat)
    {
      return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    }
    
    @SuppressLint({"DefaultLocale"})
    public void draw(Canvas paramCanvas)
    {
      super.draw(paramCanvas);
      Iterator localIterator = this.cBB.iterator();
      int i = 0;
      int j = 1;
      if (localIterator.hasNext())
      {
        Object localObject = (a)localIterator.next();
        int k = i + ((a)localObject).fps;
        if (((a)localObject).cBR.paint.getColor() != ((a)localObject).color) {
          ((a)localObject).cBR.paint.setColor(((a)localObject).color);
        }
        ((a)localObject).cBQ[1] = ((j + 1) * ((a)localObject).cBR.cBC);
        ((a)localObject).cBQ[3] = localObject.cBQ[1];
        paramCanvas.drawLine(localObject.cBQ[0], localObject.cBQ[1], localObject.cBQ[2], localObject.cBQ[3], ((a)localObject).cBR.paint);
        float f;
        int m;
        if (j % 25 == 0)
        {
          Path localPath = new Path();
          f = localObject.cBQ[1];
          localPath.moveTo(0.0F, f);
          localPath.lineTo(getMeasuredHeight(), f);
          paramCanvas.drawPath(localPath, this.cBA);
          this.cBy.setColor(this.cBN);
          paramCanvas.drawText(j / 5 + "s", 0.0F, this.textSize + f, this.cBy);
          if (j > 0)
          {
            m = k / j;
            localObject = this.cBy;
            if (m <= 57) {
              break label346;
            }
            i = this.cBI;
          }
        }
        for (;;)
        {
          ((TextPaint)localObject).setColor(i);
          paramCanvas.drawText(m + "FPS", 0.0F, f - this.textSize / 2.0F, this.cBy);
          i = k;
          j += 1;
          break;
          label346:
          if (m > 51) {
            i = this.cBJ;
          } else if (m > 36) {
            i = this.cBK;
          } else if (m > 18) {
            i = this.cBL;
          } else {
            i = this.cBM;
          }
        }
      }
      this.cBy.setColor(this.cBN);
      this.cBz.setColor(this.cBJ);
      paramCanvas.drawPath(this.cBE, this.cBz);
      paramCanvas.drawText("50", this.cBG[0] - this.textSize / 2.0F, this.cBG[1] + this.textSize, this.cBy);
      this.cBz.setColor(this.cBK);
      paramCanvas.drawPath(this.cBF, this.cBz);
      paramCanvas.drawText("30", this.cBH[0] - this.textSize / 2.0F, this.cBH[1] + this.textSize, this.cBy);
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramBoolean)
      {
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        this.cBP = (this.width - 3.0F * this.cBO);
        this.cBD = dip2px(getContext(), 1.0F);
        this.paint.setStrokeWidth(this.cBD);
        this.cBC = (this.cBD * 2.0F);
        float f = this.cBP / 60.0F;
        this.cBG[0] = (10.0F * f + (this.width - this.cBP));
        this.cBG[1] = (this.cBC * 50.0F + this.cBO);
        this.cBE.moveTo(this.cBG[0], this.cBG[1]);
        this.cBE.lineTo(this.cBG[0], 0.0F);
        this.cBH[0] = (f * 30.0F + (this.width - this.cBP));
        this.cBH[1] = (this.cBC * 50.0F + this.cBO);
        this.cBF.moveTo(this.cBH[0], this.cBH[1]);
        this.cBF.lineTo(this.cBH[0], 0.0F);
      }
    }
    
    final class a
    {
      float[] cBQ = new float[4];
      int color;
      int fps;
      
      a(int paramInt1, int paramInt2)
      {
        this.fps = paramInt1;
        this.color = paramInt2;
        this.cBQ[0] = FloatFrameView.LineChartView.this.width;
        this.cBQ[2] = ((60 - paramInt1) * FloatFrameView.LineChartView.this.cBP / 60.0F + (FloatFrameView.LineChartView.this.getWidth() - FloatFrameView.LineChartView.this.cBP));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView
 * JD-Core Version:    0.7.0.1
 */