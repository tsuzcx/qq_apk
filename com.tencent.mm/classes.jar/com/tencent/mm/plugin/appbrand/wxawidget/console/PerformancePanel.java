package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class PerformancePanel
  extends FrameLayout
{
  MMSwitchBtn fXA;
  MMSwitchBtn fXy;
  MMSwitchBtn fXz;
  
  public PerformancePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PerformancePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(b.c.performance_panel, this, true);
    Object localObject = (TextView)findViewById(b.b.msg_panel);
    View localView = findViewById(b.b.refresh_btn);
    localView.setOnClickListener(new PerformancePanel.1(this, (TextView)localObject));
    findViewById(b.b.clear_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:support", null, PerformancePanel.a.class, null);
        c.clear();
        com.tencent.mm.plugin.appbrand.collector.f.reset();
        this.fXC.setText(c.rV("jsapi_draw_canvas").toString());
      }
    });
    localObject = (MMSwitchBtn)findViewById(b.b.open_collect_btn);
    boolean bool = c.adS();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new PerformancePanel.3(this, localView));
    localView.setEnabled(bool);
    this.fXy = ((MMSwitchBtn)findViewById(b.b.collect_draw_canvas_cost_time_btn));
    this.fXy.setEnabled(bool);
    this.fXy.setCheck(c.rY("jsapi_draw_canvas"));
    this.fXy.setSwitchListener(new PerformancePanel.4(this));
    this.fXz = ((MMSwitchBtn)findViewById(b.b.collect_widget_launch_cost_time_btn));
    this.fXz.setEnabled(bool);
    this.fXz.setCheck(c.rY("widget_launch"));
    this.fXz.setSwitchListener(new PerformancePanel.5(this));
    this.fXA = ((MMSwitchBtn)findViewById(b.b.collect_widget_fps_btn));
    this.fXA.setEnabled(bool);
    this.fXA.setCheck(com.tencent.mm.plugin.appbrand.collector.f.adT());
    this.fXA.setSwitchListener(new PerformancePanel.6(this));
  }
  
  private static class d
    implements a<IPCBoolean, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel
 * JD-Core Version:    0.7.0.1
 */