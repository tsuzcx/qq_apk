package com.tencent.matrix.trace.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.a.b;
import com.tencent.matrix.trace.a.c;

public class FloatFrameView
  extends LinearLayout
{
  public TextView fhi;
  public FloatFrameView.LineChartView fhj;
  public TextView fhk;
  public TextView fhl;
  public TextView fhm;
  public TextView fhn;
  public TextView fho;
  public TextView fhp;
  public TextView fhq;
  public TextView fhr;
  public TextView fhs;
  public TextView fht;
  public TextView fhu;
  public TextView fhv;
  
  public FloatFrameView(Context paramContext)
  {
    super(paramContext);
    ci(paramContext);
  }
  
  public FloatFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ci(paramContext);
  }
  
  private void ci(Context paramContext)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    LayoutInflater.from(paramContext).inflate(a.c.float_frame_view, this);
    this.fhi = ((TextView)findViewById(a.b.fps_view));
    this.fhs = ((TextView)findViewById(a.b.extra_info));
    this.fht = ((TextView)findViewById(a.b.scene_view));
    this.fhs.setText("{other info}");
    this.fhu = ((TextView)findViewById(a.b.qi_wang_tv));
    this.fhk = ((TextView)findViewById(a.b.level_frozen));
    this.fhl = ((TextView)findViewById(a.b.level_high));
    this.fhm = ((TextView)findViewById(a.b.level_middle));
    this.fhn = ((TextView)findViewById(a.b.level_normal));
    this.fhv = ((TextView)findViewById(a.b.sum_qi_wang_tv));
    this.fho = ((TextView)findViewById(a.b.sum_level_frozen));
    this.fhp = ((TextView)findViewById(a.b.sum_level_high));
    this.fhq = ((TextView)findViewById(a.b.sum_level_middle));
    this.fhr = ((TextView)findViewById(a.b.sum_level_normal));
    this.fhj = ((FloatFrameView.LineChartView)findViewById(a.b.chart));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.trace.view.FloatFrameView
 * JD-Core Version:    0.7.0.1
 */