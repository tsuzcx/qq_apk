package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
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
  MMSwitchBtn rnR;
  MMSwitchBtn rnS;
  MMSwitchBtn rnT;
  
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
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121659);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = c.Xb("jsapi_draw_canvas").toString();
        paramAnonymousView = new StringBuilder();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          int i = c.dr("jsapi_draw_canvas", "__invoke_jsapi_data_size");
          paramAnonymousView.append("data size :").append(i).append("\n").append((String)localObject);
        }
        localObject = (IPCString)j.a(SupportProcessIPCService.PROCESS_NAME, new IPCString("widget_launch"), PerformancePanel.e.class);
        if (localObject != null) {
          paramAnonymousView.append("\n\n").append(localObject);
        }
        if (f.cko()) {
          paramAnonymousView.append("\n\n").append(f.ckp());
        }
        this.rnV.setText(paramAnonymousView.toString());
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121659);
      }
    });
    findViewById(b.a.clear_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121660);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        j.a(SupportProcessIPCService.PROCESS_NAME, null, PerformancePanel.a.class, null);
        c.clear();
        f.reset();
        this.rnV.setText(c.Xb("jsapi_draw_canvas").toString());
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121660);
      }
    });
    localObject = (MMSwitchBtn)findViewById(b.a.open_collect_btn);
    boolean bool = c.ckn();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121661);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), PerformancePanel.d.class, null);
        c.iu(paramAnonymousBoolean);
        localView.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.rnR.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.rnS.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.rnT.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(121661);
      }
    });
    localView.setEnabled(bool);
    this.rnR = ((MMSwitchBtn)findViewById(b.a.collect_draw_canvas_cost_time_btn));
    this.rnR.setEnabled(bool);
    this.rnR.setCheck(c.Xe("jsapi_draw_canvas"));
    this.rnR.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121662);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), PerformancePanel.b.class, null);
        if (paramAnonymousBoolean)
        {
          c.Xc("jsapi_draw_canvas");
          AppMethodBeat.o(121662);
          return;
        }
        c.Xd("jsapi_draw_canvas");
        AppMethodBeat.o(121662);
      }
    });
    this.rnS = ((MMSwitchBtn)findViewById(b.a.collect_widget_launch_cost_time_btn));
    this.rnS.setEnabled(bool);
    this.rnS.setCheck(c.Xe("widget_launch"));
    this.rnS.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121663);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), PerformancePanel.c.class, null);
        if (paramAnonymousBoolean)
        {
          c.Xc("widget_launch");
          AppMethodBeat.o(121663);
          return;
        }
        c.Xd("widget_launch");
        AppMethodBeat.o(121663);
      }
    });
    this.rnT = ((MMSwitchBtn)findViewById(b.a.collect_widget_fps_btn));
    this.rnT.setEnabled(bool);
    this.rnT.setCheck(f.cko());
    this.rnT.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121664);
        f.iv(paramAnonymousBoolean);
        AppMethodBeat.o(121664);
      }
    });
    AppMethodBeat.o(121672);
  }
  
  static class a
    implements d<IPCVoid, IPCVoid>
  {}
  
  static class b
    implements d<IPCBoolean, IPCVoid>
  {}
  
  static class c
    implements d<IPCBoolean, IPCVoid>
  {}
  
  static class d
    implements d<IPCBoolean, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel
 * JD-Core Version:    0.7.0.1
 */