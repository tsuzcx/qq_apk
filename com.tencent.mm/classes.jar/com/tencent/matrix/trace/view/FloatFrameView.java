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
  public TextView cMj;
  public FloatFrameView.LineChartView cMk;
  public TextView cMl;
  public TextView cMm;
  public TextView cMn;
  public TextView cMo;
  public TextView cMp;
  public TextView cMq;
  public TextView cMr;
  public TextView cMs;
  public TextView cMt;
  public TextView cMu;
  public TextView cMv;
  public TextView cMw;
  
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
    this.cMj = ((TextView)findViewById(2131300235));
    this.cMt = ((TextView)findViewById(2131299636));
    this.cMu = ((TextView)findViewById(2131304347));
    this.cMt.setText("{other info}");
    this.cMv = ((TextView)findViewById(2131303552));
    this.cMl = ((TextView)findViewById(2131301398));
    this.cMm = ((TextView)findViewById(2131301399));
    this.cMn = ((TextView)findViewById(2131301400));
    this.cMo = ((TextView)findViewById(2131301401));
    this.cMw = ((TextView)findViewById(2131305545));
    this.cMp = ((TextView)findViewById(2131305541));
    this.cMq = ((TextView)findViewById(2131305542));
    this.cMr = ((TextView)findViewById(2131305543));
    this.cMs = ((TextView)findViewById(2131305544));
    this.cMk = ((FloatFrameView.LineChartView)findViewById(2131297955));
  }
  
  final class LineChartView$a
  {
    float[] cMP = new float[4];
    int color;
    int fps;
    
    LineChartView$a(int paramInt1, int paramInt2)
    {
      this.fps = paramInt1;
      this.color = paramInt2;
      this.cMP[0] = FloatFrameView.this.width;
      this.cMP[2] = ((60 - paramInt1) * FloatFrameView.this.cMO / 60.0F + (FloatFrameView.this.getWidth() - FloatFrameView.this.cMO));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView
 * JD-Core Version:    0.7.0.1
 */