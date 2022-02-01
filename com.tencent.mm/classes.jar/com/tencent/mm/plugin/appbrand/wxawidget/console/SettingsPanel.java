package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.appbrand.wxawidget.b.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.ArrayList;

public class SettingsPanel
  extends FrameLayout
{
  private Button uTh;
  private Button uTi;
  private View.OnClickListener uTj;
  private Runnable uTk;
  
  public SettingsPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121683);
    init();
    AppMethodBeat.o(121683);
  }
  
  public SettingsPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121684);
    init();
    AppMethodBeat.o(121684);
  }
  
  private void EP(int paramInt)
  {
    AppMethodBeat.i(121686);
    this.uTh.setTag(Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      this.uTh.setText("MHADrawableView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.zW(0);
      AppMethodBeat.o(121686);
      return;
    case 1: 
      this.uTh.setText("MTextureView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.zW(1);
      AppMethodBeat.o(121686);
      return;
    case 2: 
      this.uTh.setText("MSurfaceView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.zW(2);
      AppMethodBeat.o(121686);
      return;
    case 3: 
      this.uTh.setText("MCanvasView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.zW(3);
      AppMethodBeat.o(121686);
      return;
    }
    this.uTh.setText("MDrawableView");
    com.tencent.mm.plugin.appbrand.dynamic.widget.b.zW(4);
    AppMethodBeat.o(121686);
  }
  
  private void EQ(int paramInt)
  {
    AppMethodBeat.i(121687);
    this.uTi.setTag(Integer.valueOf(paramInt));
    String str;
    switch (paramInt)
    {
    default: 
      str = "Normal";
    }
    for (paramInt = 0;; paramInt = 1)
    {
      this.uTi.setText(str);
      com.tencent.mm.ad.h.sv(paramInt);
      j.a(SupportProcessIPCService.PROCESS_NAME, new IPCInteger(paramInt), a.class, null);
      AppMethodBeat.o(121687);
      return;
      str = "Minimal-json";
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(121685);
    LayoutInflater.from(getContext()).inflate(com.tencent.mm.plugin.appbrand.wxawidget.b.b.settings_panel, this, true);
    findViewById(b.a.restart_support_process_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121675);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEI().bEH();
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(121674);
            Toast.makeText(SettingsPanel.this.getContext(), b.c.wxa_widget_restart_support_process_succ, 1).show();
            if (SettingsPanel.a(SettingsPanel.this) != null) {
              SettingsPanel.a(SettingsPanel.this).run();
            }
            AppMethodBeat.o(121674);
          }
        }, 2000L);
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121675);
      }
    });
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)findViewById(b.a.enable_release_debug_btn);
    localMMSwitchBtn.setCheck(((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().bEO());
    localMMSwitchBtn.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121676);
        ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().gV(paramAnonymousBoolean);
        AppMethodBeat.o(121676);
      }
    });
    this.uTh = ((Button)findViewById(b.a.drawable_view_mode_btn));
    EP(com.tencent.mm.plugin.appbrand.dynamic.widget.b.coe());
    this.uTh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(121678);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add("MHADrawableView");
        paramAnonymousView.add("MTextureView");
        paramAnonymousView.add("MSurfaceView");
        paramAnonymousView.add("MCanvasView");
        paramAnonymousView.add("MDrawableView");
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(SettingsPanel.this.getContext(), paramAnonymousView);
        paramAnonymousView.aFq(((Integer)SettingsPanel.b(SettingsPanel.this).getTag()).intValue());
        paramAnonymousView.agkc = new com.tencent.mm.ui.widget.picker.b.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(121677);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              SettingsPanel.b(SettingsPanel.this).setText((CharSequence)paramAnonymous2Object1);
            }
            SettingsPanel.a(SettingsPanel.this, paramAnonymousView.jIz());
            AppMethodBeat.o(121677);
          }
        };
        paramAnonymousView.show();
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121678);
      }
    });
    this.uTi = ((Button)findViewById(b.a.json_parser_btn));
    EQ(com.tencent.mm.ad.h.aZp());
    this.uTi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(121680);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add("Normal");
        paramAnonymousView.add("Minimal-json");
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(SettingsPanel.this.getContext(), paramAnonymousView);
        paramAnonymousView.aFq(((Integer)SettingsPanel.c(SettingsPanel.this).getTag()).intValue());
        paramAnonymousView.agkc = new com.tencent.mm.ui.widget.picker.b.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(121679);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              SettingsPanel.c(SettingsPanel.this).setText((CharSequence)paramAnonymous2Object1);
            }
            SettingsPanel.b(SettingsPanel.this, paramAnonymousView.jIz());
            AppMethodBeat.o(121679);
          }
        };
        paramAnonymousView.show();
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121680);
      }
    });
    findViewById(b.a.close_debugger_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121681);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (SettingsPanel.d(SettingsPanel.this) != null) {
          SettingsPanel.d(SettingsPanel.this).onClick(paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121681);
      }
    });
    if (((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().bEP())
    {
      findViewById(b.a.enable_release_debug_item).setVisibility(0);
      findViewById(b.a.drawable_view_mode_item).setVisibility(0);
      findViewById(b.a.json_parser_item).setVisibility(0);
    }
    AppMethodBeat.o(121685);
  }
  
  public void setOnCloseDebuggerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.uTj = paramOnClickListener;
  }
  
  public void setOnResetDebuggerRunnable(Runnable paramRunnable)
  {
    this.uTk = paramRunnable;
  }
  
  static class a
    implements d<IPCInteger, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel
 * JD-Core Version:    0.7.0.1
 */