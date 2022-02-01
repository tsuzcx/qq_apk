package com.tencent.matrix.trace.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FloatFrameView
  extends LinearLayout
{
  public TextView ddA;
  public TextView ddB;
  public TextView ddC;
  public TextView ddD;
  public TextView ddq;
  public FloatFrameView.LineChartView ddr;
  public TextView dds;
  public TextView ddt;
  public TextView ddu;
  public TextView ddv;
  public TextView ddw;
  public TextView ddx;
  public TextView ddy;
  public TextView ddz;
  
  public FloatFrameView(Context paramContext)
  {
    super(paramContext);
    bh(paramContext);
  }
  
  public FloatFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bh(paramContext);
  }
  
  private void bh(Context paramContext)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    LayoutInflater.from(paramContext).inflate(2131494698, this);
    this.ddq = ((TextView)findViewById(2131301710));
    this.ddA = ((TextView)findViewById(2131300270));
    this.ddB = ((TextView)findViewById(2131307281));
    this.ddA.setText("{other info}");
    this.ddC = ((TextView)findViewById(2131306327));
    this.dds = ((TextView)findViewById(2131303153));
    this.ddt = ((TextView)findViewById(2131303154));
    this.ddu = ((TextView)findViewById(2131303155));
    this.ddv = ((TextView)findViewById(2131303156));
    this.ddD = ((TextView)findViewById(2131308766));
    this.ddw = ((TextView)findViewById(2131308762));
    this.ddx = ((TextView)findViewById(2131308763));
    this.ddy = ((TextView)findViewById(2131308764));
    this.ddz = ((TextView)findViewById(2131308765));
    this.ddr = ((FloatFrameView.LineChartView)findViewById(2131298290));
  }
  
  final class LineChartView$a
  {
    int color;
    float[] ddW = new float[4];
    int fps;
    
    LineChartView$a(int paramInt1, int paramInt2)
    {
      this.fps = paramInt1;
      this.color = paramInt2;
      this.ddW[0] = FloatFrameView.this.width;
      this.ddW[2] = ((60 - paramInt1) * FloatFrameView.this.ddV / 60.0F + (FloatFrameView.this.getWidth() - FloatFrameView.this.ddV));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView
 * JD-Core Version:    0.7.0.1
 */