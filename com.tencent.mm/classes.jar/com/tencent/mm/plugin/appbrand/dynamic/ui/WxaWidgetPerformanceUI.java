package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.collector.f;
import com.tencent.mm.plugin.appbrand.wxawidget.b.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetPerformanceUI
  extends MMActivity
{
  MMSwitchBtn okp;
  MMSwitchBtn okq;
  MMSwitchBtn okr;
  
  public void finish()
  {
    AppMethodBeat.i(121511);
    if ((isFinishing()) || (activityHasDestroyed()))
    {
      AppMethodBeat.o(121511);
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
      AppMethodBeat.o(121511);
      return;
      super.finish();
    }
  }
  
  public int getLayoutId()
  {
    return b.b.wxa_widget_performance_ui;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(121510);
    super.onCreate(paramBundle);
    setBackBtn(new WxaWidgetPerformanceUI.1(this));
    setMMTitle(b.c.wxa_widget_performance);
    Object localObject = (TextView)findViewById(b.a.msg_panel);
    paramBundle = findViewById(b.a.refresh_btn);
    paramBundle.setOnClickListener(new WxaWidgetPerformanceUI.2(this, (TextView)localObject));
    findViewById(b.a.clear_btn).setOnClickListener(new WxaWidgetPerformanceUI.3(this, (TextView)localObject));
    localObject = (MMSwitchBtn)findViewById(b.a.open_collect_btn);
    boolean bool = c.bKN();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121501);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.d.class, null);
        c.hE(paramAnonymousBoolean);
        paramBundle.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.okp.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.okq.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.okr.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(121501);
      }
    });
    paramBundle.setEnabled(bool);
    this.okp = ((MMSwitchBtn)findViewById(b.a.collect_draw_canvas_cost_time_btn));
    this.okp.setEnabled(bool);
    this.okp.setCheck(c.aeB("jsapi_draw_canvas"));
    this.okp.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121502);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.b.class, null);
        if (paramAnonymousBoolean)
        {
          c.aez("jsapi_draw_canvas");
          AppMethodBeat.o(121502);
          return;
        }
        c.aeA("jsapi_draw_canvas");
        AppMethodBeat.o(121502);
      }
    });
    this.okq = ((MMSwitchBtn)findViewById(b.a.collect_widget_launch_cost_time_btn));
    this.okq.setEnabled(bool);
    this.okq.setCheck(c.aeB("widget_launch"));
    this.okq.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121503);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.c.class, null);
        if (paramAnonymousBoolean)
        {
          c.aez("widget_launch");
          AppMethodBeat.o(121503);
          return;
        }
        c.aeA("widget_launch");
        AppMethodBeat.o(121503);
      }
    });
    this.okr = ((MMSwitchBtn)findViewById(b.a.collect_widget_fps_btn));
    this.okr.setEnabled(bool);
    this.okr.setCheck(f.bKO());
    this.okr.setSwitchListener(new WxaWidgetPerformanceUI.7(this));
    AppMethodBeat.o(121510);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static class b
    implements d<IPCBoolean, IPCVoid>
  {}
  
  static class c
    implements d<IPCBoolean, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI
 * JD-Core Version:    0.7.0.1
 */