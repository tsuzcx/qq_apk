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
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.modelappbrand.f;
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
  private Button rHS;
  private Button rHT;
  private View.OnClickListener rHU;
  private Runnable rHV;
  
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
  
  private void Ep(int paramInt)
  {
    AppMethodBeat.i(121686);
    this.rHS.setTag(Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      this.rHS.setText("MHADrawableView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.zG(0);
      AppMethodBeat.o(121686);
      return;
    case 1: 
      this.rHS.setText("MTextureView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.zG(1);
      AppMethodBeat.o(121686);
      return;
    case 2: 
      this.rHS.setText("MSurfaceView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.zG(2);
      AppMethodBeat.o(121686);
      return;
    case 3: 
      this.rHS.setText("MCanvasView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.zG(3);
      AppMethodBeat.o(121686);
      return;
    }
    this.rHS.setText("MDrawableView");
    com.tencent.mm.plugin.appbrand.dynamic.widget.b.zG(4);
    AppMethodBeat.o(121686);
  }
  
  private void Eq(int paramInt)
  {
    AppMethodBeat.i(121687);
    this.rHT.setTag(Integer.valueOf(paramInt));
    String str;
    switch (paramInt)
    {
    default: 
      str = "Normal";
    }
    for (paramInt = 0;; paramInt = 1)
    {
      this.rHT.setText(str);
      com.tencent.mm.ad.h.sz(paramInt);
      j.a(SupportProcessIPCService.PROCESS_NAME, new IPCInteger(paramInt), SettingsPanel.a.class, null);
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
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((g)com.tencent.mm.kernel.h.ae(g.class)).bgQ().bgP();
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
    localMMSwitchBtn.setCheck(((g)com.tencent.mm.kernel.h.ae(g.class)).bgR().bgX());
    localMMSwitchBtn.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121676);
        ((g)com.tencent.mm.kernel.h.ae(g.class)).bgR().ge(paramAnonymousBoolean);
        AppMethodBeat.o(121676);
      }
    });
    this.rHS = ((Button)findViewById(b.a.drawable_view_mode_btn));
    Ep(com.tencent.mm.plugin.appbrand.dynamic.widget.b.bNP());
    this.rHS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(121678);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add("MHADrawableView");
        paramAnonymousView.add("MTextureView");
        paramAnonymousView.add("MSurfaceView");
        paramAnonymousView.add("MCanvasView");
        paramAnonymousView.add("MDrawableView");
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(SettingsPanel.this.getContext(), paramAnonymousView);
        paramAnonymousView.ayK(((Integer)SettingsPanel.b(SettingsPanel.this).getTag()).intValue());
        paramAnonymousView.YrN = new com.tencent.mm.ui.widget.picker.b.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(121677);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              SettingsPanel.b(SettingsPanel.this).setText((CharSequence)paramAnonymous2Object1);
            }
            SettingsPanel.a(SettingsPanel.this, paramAnonymousView.idp());
            AppMethodBeat.o(121677);
          }
        };
        paramAnonymousView.show();
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121678);
      }
    });
    this.rHT = ((Button)findViewById(b.a.json_parser_btn));
    Eq(com.tencent.mm.ad.h.aGo());
    this.rHT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(121680);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add("Normal");
        paramAnonymousView.add("Minimal-json");
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(SettingsPanel.this.getContext(), paramAnonymousView);
        paramAnonymousView.ayK(((Integer)SettingsPanel.c(SettingsPanel.this).getTag()).intValue());
        paramAnonymousView.YrN = new com.tencent.mm.ui.widget.picker.b.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(121679);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              SettingsPanel.c(SettingsPanel.this).setText((CharSequence)paramAnonymous2Object1);
            }
            SettingsPanel.b(SettingsPanel.this, paramAnonymousView.idp());
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
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (SettingsPanel.d(SettingsPanel.this) != null) {
          SettingsPanel.d(SettingsPanel.this).onClick(paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121681);
      }
    });
    if (((g)com.tencent.mm.kernel.h.ae(g.class)).bgR().bgY())
    {
      findViewById(b.a.enable_release_debug_item).setVisibility(0);
      findViewById(b.a.drawable_view_mode_item).setVisibility(0);
      findViewById(b.a.json_parser_item).setVisibility(0);
    }
    AppMethodBeat.o(121685);
  }
  
  public void setOnCloseDebuggerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.rHU = paramOnClickListener;
  }
  
  public void setOnResetDebuggerRunnable(Runnable paramRunnable)
  {
    this.rHV = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel
 * JD-Core Version:    0.7.0.1
 */