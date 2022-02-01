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
import com.tencent.matrix.trace.a.a;
import com.tencent.matrix.trace.a.b;
import com.tencent.matrix.trace.a.c;
import java.util.Iterator;
import java.util.LinkedList;

public class FloatFrameView
  extends LinearLayout
{
  public TextView dhA;
  public TextView dhB;
  public TextView dhC;
  public TextView dhD;
  public TextView dhE;
  public TextView dhF;
  public TextView dhG;
  public TextView dht;
  public LineChartView dhu;
  public TextView dhv;
  public TextView dhw;
  public TextView dhx;
  public TextView dhy;
  public TextView dhz;
  
  public FloatFrameView(Context paramContext)
  {
    super(paramContext);
    bv(paramContext);
  }
  
  public FloatFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bv(paramContext);
  }
  
  private void bv(Context paramContext)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    LayoutInflater.from(paramContext).inflate(a.c.float_frame_view, this);
    this.dht = ((TextView)findViewById(a.b.fps_view));
    this.dhD = ((TextView)findViewById(a.b.extra_info));
    this.dhE = ((TextView)findViewById(a.b.scene_view));
    this.dhD.setText("{other info}");
    this.dhF = ((TextView)findViewById(a.b.qi_wang_tv));
    this.dhv = ((TextView)findViewById(a.b.level_frozen));
    this.dhw = ((TextView)findViewById(a.b.level_high));
    this.dhx = ((TextView)findViewById(a.b.level_middle));
    this.dhy = ((TextView)findViewById(a.b.level_normal));
    this.dhG = ((TextView)findViewById(a.b.sum_qi_wang_tv));
    this.dhz = ((TextView)findViewById(a.b.sum_level_frozen));
    this.dhA = ((TextView)findViewById(a.b.sum_level_high));
    this.dhB = ((TextView)findViewById(a.b.sum_level_middle));
    this.dhC = ((TextView)findViewById(a.b.sum_level_normal));
    this.dhu = ((LineChartView)findViewById(a.b.chart));
  }
  
  public static class LineChartView
    extends View
  {
    private final TextPaint dhH = new TextPaint(1);
    private final Paint dhI;
    private final Paint dhJ;
    final LinkedList<a> dhK;
    float dhL;
    float dhM;
    private Path dhN = new Path();
    private Path dhO = new Path();
    private float[] dhP = new float[2];
    private float[] dhQ = new float[2];
    private int dhR = getContext().getResources().getColor(a.a.level_best_color);
    private int dhS = getContext().getResources().getColor(a.a.level_normal_color);
    private int dhT = getContext().getResources().getColor(a.a.level_middle_color);
    private int dhU = getContext().getResources().getColor(a.a.level_high_color);
    private int dhV = getContext().getResources().getColor(a.a.level_frozen_color);
    private int dhW = getContext().getResources().getColor(a.a.dark_text);
    float dhX = dip2px(getContext(), 8.0F);
    float dhY;
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
      paramContext = this.dhH;
      float f = dip2px(getContext(), 8.0F);
      this.textSize = f;
      paramContext.setTextSize(f);
      this.dhH.setStrokeWidth(dip2px(getContext(), 1.0F));
      this.dhH.setColor(this.dhW);
      this.dhI = new TextPaint(1);
      this.dhI.setStrokeWidth(dip2px(getContext(), 1.0F));
      this.dhI.setStyle(Paint.Style.STROKE);
      this.dhI.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
      this.dhJ = new Paint(this.dhH);
      this.dhJ.setStrokeWidth(dip2px(getContext(), 1.0F));
      this.dhJ.setColor(this.dhW);
      this.dhJ.setStyle(Paint.Style.STROKE);
      this.dhJ.setPathEffect(new DashPathEffect(new float[] { 6.0F, 6.0F }, 0.0F));
      this.dhK = new LinkedList();
    }
    
    private static int dip2px(Context paramContext, float paramFloat)
    {
      return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    }
    
    @SuppressLint({"DefaultLocale"})
    public void draw(Canvas paramCanvas)
    {
      super.draw(paramCanvas);
      Iterator localIterator = this.dhK.iterator();
      int i = 0;
      int j = 1;
      if (localIterator.hasNext())
      {
        Object localObject = (a)localIterator.next();
        int k = i + ((a)localObject).fps;
        if (((a)localObject).dia.paint.getColor() != ((a)localObject).color) {
          ((a)localObject).dia.paint.setColor(((a)localObject).color);
        }
        ((a)localObject).dhZ[1] = ((j + 1) * ((a)localObject).dia.dhL);
        ((a)localObject).dhZ[3] = localObject.dhZ[1];
        paramCanvas.drawLine(localObject.dhZ[0], localObject.dhZ[1], localObject.dhZ[2], localObject.dhZ[3], ((a)localObject).dia.paint);
        float f;
        int m;
        if (j % 25 == 0)
        {
          Path localPath = new Path();
          f = localObject.dhZ[1];
          localPath.moveTo(0.0F, f);
          localPath.lineTo(getMeasuredHeight(), f);
          paramCanvas.drawPath(localPath, this.dhJ);
          this.dhH.setColor(this.dhW);
          paramCanvas.drawText(j / 5 + "s", 0.0F, this.textSize + f, this.dhH);
          if (j > 0)
          {
            m = k / j;
            localObject = this.dhH;
            if (m <= 57) {
              break label347;
            }
            i = this.dhR;
          }
        }
        for (;;)
        {
          ((TextPaint)localObject).setColor(i);
          paramCanvas.drawText(m + "FPS", 0.0F, f - this.textSize / 2.0F, this.dhH);
          i = k;
          j += 1;
          break;
          label347:
          if (m > 51) {
            i = this.dhS;
          } else if (m > 36) {
            i = this.dhT;
          } else if (m > 18) {
            i = this.dhU;
          } else {
            i = this.dhV;
          }
        }
      }
      this.dhH.setColor(this.dhW);
      this.dhI.setColor(this.dhS);
      paramCanvas.drawPath(this.dhN, this.dhI);
      paramCanvas.drawText("50", this.dhP[0] - this.textSize / 2.0F, this.dhP[1] + this.textSize, this.dhH);
      this.dhI.setColor(this.dhT);
      paramCanvas.drawPath(this.dhO, this.dhI);
      paramCanvas.drawText("30", this.dhQ[0] - this.textSize / 2.0F, this.dhQ[1] + this.textSize, this.dhH);
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramBoolean)
      {
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        this.dhY = (this.width - 3.0F * this.dhX);
        this.dhM = dip2px(getContext(), 1.0F);
        this.paint.setStrokeWidth(this.dhM);
        this.dhL = (this.dhM * 2.0F);
        float f = this.dhY / 60.0F;
        this.dhP[0] = (10.0F * f + (this.width - this.dhY));
        this.dhP[1] = (this.dhL * 50.0F + this.dhX);
        this.dhN.moveTo(this.dhP[0], this.dhP[1]);
        this.dhN.lineTo(this.dhP[0], 0.0F);
        this.dhQ[0] = (f * 30.0F + (this.width - this.dhY));
        this.dhQ[1] = (this.dhL * 50.0F + this.dhX);
        this.dhO.moveTo(this.dhQ[0], this.dhQ[1]);
        this.dhO.lineTo(this.dhQ[0], 0.0F);
      }
    }
    
    final class a
    {
      int color;
      float[] dhZ = new float[4];
      int fps;
      
      a(int paramInt1, int paramInt2)
      {
        this.fps = paramInt1;
        this.color = paramInt2;
        this.dhZ[0] = FloatFrameView.LineChartView.this.width;
        this.dhZ[2] = ((60 - paramInt1) * FloatFrameView.LineChartView.this.dhY / 60.0F + (FloatFrameView.LineChartView.this.getWidth() - FloatFrameView.LineChartView.this.dhY));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView
 * JD-Core Version:    0.7.0.1
 */