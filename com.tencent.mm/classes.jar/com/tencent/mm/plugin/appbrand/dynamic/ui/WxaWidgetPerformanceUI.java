package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.collector.f;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetPerformanceUI
  extends MMActivity
{
  MMSwitchBtn fXA;
  MMSwitchBtn fXy;
  MMSwitchBtn fXz;
  
  public void finish()
  {
    if ((isFinishing()) || (this.uMr)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      finishAndRemoveTask();
    }
    for (;;)
    {
      TypedArray localTypedArray = obtainStyledAttributes(16973825, new int[] { 16842938, 16842939 });
      int i = localTypedArray.getResourceId(0, 0);
      int j = localTypedArray.getResourceId(1, 0);
      localTypedArray.recycle();
      overridePendingTransition(i, j);
      return;
      super.finish();
    }
  }
  
  protected final int getLayoutId()
  {
    return b.c.wxa_widget_performance_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new WxaWidgetPerformanceUI.1(this));
    setMMTitle(b.e.wxa_widget_performance);
    Object localObject = (TextView)findViewById(b.b.msg_panel);
    paramBundle = findViewById(b.b.refresh_btn);
    paramBundle.setOnClickListener(new WxaWidgetPerformanceUI.2(this, (TextView)localObject));
    findViewById(b.b.clear_btn).setOnClickListener(new WxaWidgetPerformanceUI.3(this, (TextView)localObject));
    localObject = (MMSwitchBtn)findViewById(b.b.open_collect_btn);
    boolean bool = c.adS();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new WxaWidgetPerformanceUI.4(this, paramBundle));
    paramBundle.setEnabled(bool);
    this.fXy = ((MMSwitchBtn)findViewById(b.b.collect_draw_canvas_cost_time_btn));
    this.fXy.setEnabled(bool);
    this.fXy.setCheck(c.rY("jsapi_draw_canvas"));
    this.fXy.setSwitchListener(new WxaWidgetPerformanceUI.5(this));
    this.fXz = ((MMSwitchBtn)findViewById(b.b.collect_widget_launch_cost_time_btn));
    this.fXz.setEnabled(bool);
    this.fXz.setCheck(c.rY("widget_launch"));
    this.fXz.setSwitchListener(new WxaWidgetPerformanceUI.6(this));
    this.fXA = ((MMSwitchBtn)findViewById(b.b.collect_widget_fps_btn));
    this.fXA.setEnabled(bool);
    this.fXA.setCheck(f.adT());
    this.fXA.setSwitchListener(new WxaWidgetPerformanceUI.7(this));
  }
  
  private static class b
    implements a<IPCBoolean, IPCVoid>
  {}
  
  private static class c
    implements a<IPCBoolean, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI
 * JD-Core Version:    0.7.0.1
 */