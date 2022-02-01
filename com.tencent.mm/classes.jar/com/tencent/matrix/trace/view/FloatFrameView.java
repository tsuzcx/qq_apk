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
  public TextView cEc;
  public FloatFrameView.LineChartView cEd;
  public TextView cEe;
  public TextView cEf;
  public TextView cEg;
  public TextView cEh;
  public TextView cEi;
  public TextView cEj;
  public TextView cEk;
  public TextView cEl;
  public TextView cEm;
  public TextView cEn;
  public TextView cEo;
  public TextView cEp;
  
  public FloatFrameView(Context paramContext)
  {
    super(paramContext);
    aL(paramContext);
  }
  
  public FloatFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    aL(paramContext);
  }
  
  private void aL(Context paramContext)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    LayoutInflater.from(paramContext).inflate(2131494143, this);
    this.cEc = ((TextView)findViewById(2131300235));
    this.cEm = ((TextView)findViewById(2131299636));
    this.cEn = ((TextView)findViewById(2131304347));
    this.cEm.setText("{other info}");
    this.cEo = ((TextView)findViewById(2131303552));
    this.cEe = ((TextView)findViewById(2131301398));
    this.cEf = ((TextView)findViewById(2131301399));
    this.cEg = ((TextView)findViewById(2131301400));
    this.cEh = ((TextView)findViewById(2131301401));
    this.cEp = ((TextView)findViewById(2131305545));
    this.cEi = ((TextView)findViewById(2131305541));
    this.cEj = ((TextView)findViewById(2131305542));
    this.cEk = ((TextView)findViewById(2131305543));
    this.cEl = ((TextView)findViewById(2131305544));
    this.cEd = ((FloatFrameView.LineChartView)findViewById(2131297955));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView
 * JD-Core Version:    0.7.0.1
 */