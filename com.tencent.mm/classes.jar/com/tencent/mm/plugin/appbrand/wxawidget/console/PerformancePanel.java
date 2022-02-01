package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
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
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class PerformancePanel
  extends FrameLayout
{
  MMSwitchBtn okp;
  MMSwitchBtn okq;
  MMSwitchBtn okr;
  
  public PerformancePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121670);
    init();
    AppMethodBeat.o(121670);
  }
  
  public PerformancePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121671);
    init();
    AppMethodBeat.o(121671);
  }
  
  private void init()
  {
    AppMethodBeat.i(121672);
    LayoutInflater.from(getContext()).inflate(b.b.performance_panel, this, true);
    Object localObject = (TextView)findViewById(b.a.msg_panel);
    final View localView = findViewById(b.a.refresh_btn);
    localView.setOnClickListener(new PerformancePanel.1(this, (TextView)localObject));
    findViewById(b.a.clear_btn).setOnClickListener(new PerformancePanel.2(this, (TextView)localObject));
    localObject = (MMSwitchBtn)findViewById(b.a.open_collect_btn);
    boolean bool = c.bKN();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121661);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), PerformancePanel.d.class, null);
        c.hE(paramAnonymousBoolean);
        localView.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.okp.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.okq.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.okr.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(121661);
      }
    });
    localView.setEnabled(bool);
    this.okp = ((MMSwitchBtn)findViewById(b.a.collect_draw_canvas_cost_time_btn));
    this.okp.setEnabled(bool);
    this.okp.setCheck(c.aeB("jsapi_draw_canvas"));
    this.okp.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121662);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), PerformancePanel.b.class, null);
        if (paramAnonymousBoolean)
        {
          c.aez("jsapi_draw_canvas");
          AppMethodBeat.o(121662);
          return;
        }
        c.aeA("jsapi_draw_canvas");
        AppMethodBeat.o(121662);
      }
    });
    this.okq = ((MMSwitchBtn)findViewById(b.a.collect_widget_launch_cost_time_btn));
    this.okq.setEnabled(bool);
    this.okq.setCheck(c.aeB("widget_launch"));
    this.okq.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121663);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), PerformancePanel.c.class, null);
        if (paramAnonymousBoolean)
        {
          c.aez("widget_launch");
          AppMethodBeat.o(121663);
          return;
        }
        c.aeA("widget_launch");
        AppMethodBeat.o(121663);
      }
    });
    this.okr = ((MMSwitchBtn)findViewById(b.a.collect_widget_fps_btn));
    this.okr.setEnabled(bool);
    this.okr.setCheck(f.bKO());
    this.okr.setSwitchListener(new PerformancePanel.6(this));
    AppMethodBeat.o(121672);
  }
  
  static class b
    implements d<IPCBoolean, IPCVoid>
  {}
  
  static class c
    implements d<IPCBoolean, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel
 * JD-Core Version:    0.7.0.1
 */