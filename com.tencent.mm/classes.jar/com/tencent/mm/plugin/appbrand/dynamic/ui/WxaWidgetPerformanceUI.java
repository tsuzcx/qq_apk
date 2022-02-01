package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetPerformanceUI
  extends MMActivity
{
  MMSwitchBtn rnR;
  MMSwitchBtn rnS;
  MMSwitchBtn rnT;
  
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(121498);
        WxaWidgetPerformanceUI.this.finish();
        AppMethodBeat.o(121498);
        return false;
      }
    });
    setMMTitle(b.c.wxa_widget_performance);
    Object localObject = (TextView)findViewById(b.a.msg_panel);
    paramBundle = findViewById(b.a.refresh_btn);
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121499);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = c.Xb("jsapi_draw_canvas").toString();
        paramAnonymousView = new StringBuilder();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          int i = c.dr("jsapi_draw_canvas", "__invoke_jsapi_data_size");
          paramAnonymousView.append("data size :").append(i).append("\n").append((String)localObject);
        }
        localObject = (IPCString)j.a(SupportProcessIPCService.PROCESS_NAME, new IPCString("widget_launch"), WxaWidgetPerformanceUI.e.class);
        if (localObject != null) {
          paramAnonymousView.append("\n\n").append(localObject);
        }
        if (f.cko()) {
          paramAnonymousView.append("\n\n").append(f.ckp());
        }
        this.rnV.setText(paramAnonymousView.toString());
        a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121499);
      }
    });
    findViewById(b.a.clear_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121500);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        j.a(SupportProcessIPCService.PROCESS_NAME, null, WxaWidgetPerformanceUI.a.class, null);
        c.clear();
        f.reset();
        this.rnV.setText(c.Xb("jsapi_draw_canvas").toString());
        a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121500);
      }
    });
    localObject = (MMSwitchBtn)findViewById(b.a.open_collect_btn);
    boolean bool = c.ckn();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121501);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.d.class, null);
        c.iu(paramAnonymousBoolean);
        paramBundle.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.rnR.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.rnS.setEnabled(paramAnonymousBoolean);
        WxaWidgetPerformanceUI.this.rnT.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(121501);
      }
    });
    paramBundle.setEnabled(bool);
    this.rnR = ((MMSwitchBtn)findViewById(b.a.collect_draw_canvas_cost_time_btn));
    this.rnR.setEnabled(bool);
    this.rnR.setCheck(c.Xe("jsapi_draw_canvas"));
    this.rnR.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121502);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.b.class, null);
        if (paramAnonymousBoolean)
        {
          c.Xc("jsapi_draw_canvas");
          AppMethodBeat.o(121502);
          return;
        }
        c.Xd("jsapi_draw_canvas");
        AppMethodBeat.o(121502);
      }
    });
    this.rnS = ((MMSwitchBtn)findViewById(b.a.collect_widget_launch_cost_time_btn));
    this.rnS.setEnabled(bool);
    this.rnS.setCheck(c.Xe("widget_launch"));
    this.rnS.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121503);
        j.a(SupportProcessIPCService.PROCESS_NAME, new IPCBoolean(paramAnonymousBoolean), WxaWidgetPerformanceUI.c.class, null);
        if (paramAnonymousBoolean)
        {
          c.Xc("widget_launch");
          AppMethodBeat.o(121503);
          return;
        }
        c.Xd("widget_launch");
        AppMethodBeat.o(121503);
      }
    });
    this.rnT = ((MMSwitchBtn)findViewById(b.a.collect_widget_fps_btn));
    this.rnT.setEnabled(bool);
    this.rnT.setCheck(f.cko());
    this.rnT.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121504);
        f.iv(paramAnonymousBoolean);
        AppMethodBeat.o(121504);
      }
    });
    AppMethodBeat.o(121510);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI
 * JD-Core Version:    0.7.0.1
 */