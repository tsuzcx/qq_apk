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
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.b;
import java.util.ArrayList;

public class SettingsPanel
  extends FrameLayout
{
  private Button oGd;
  private Button oGe;
  private View.OnClickListener oGf;
  private Runnable oGg;
  
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
  
  private void AJ(int paramInt)
  {
    AppMethodBeat.i(121686);
    this.oGd.setTag(Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      this.oGd.setText("MHADrawableView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.wt(0);
      AppMethodBeat.o(121686);
      return;
    case 1: 
      this.oGd.setText("MTextureView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.wt(1);
      AppMethodBeat.o(121686);
      return;
    case 2: 
      this.oGd.setText("MSurfaceView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.wt(2);
      AppMethodBeat.o(121686);
      return;
    case 3: 
      this.oGd.setText("MCanvasView");
      com.tencent.mm.plugin.appbrand.dynamic.widget.b.wt(3);
      AppMethodBeat.o(121686);
      return;
    }
    this.oGd.setText("MDrawableView");
    com.tencent.mm.plugin.appbrand.dynamic.widget.b.wt(4);
    AppMethodBeat.o(121686);
  }
  
  private void AK(int paramInt)
  {
    AppMethodBeat.i(121687);
    this.oGe.setTag(Integer.valueOf(paramInt));
    String str;
    switch (paramInt)
    {
    default: 
      str = "Normal";
    }
    for (paramInt = 0;; paramInt = 1)
    {
      this.oGe.setText(str);
      com.tencent.mm.ab.h.qa(paramInt);
      com.tencent.mm.ipcinvoker.h.a(SupportProcessIPCService.dkO, new IPCInteger(paramInt), a.class, null);
      AppMethodBeat.o(121687);
      return;
      str = "Minimal-json";
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(121685);
    LayoutInflater.from(getContext()).inflate(2131496263, this, true);
    findViewById(2131307033).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121675);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXH().restart();
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(121674);
            Toast.makeText(SettingsPanel.this.getContext(), 2131768840, 1).show();
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
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)findViewById(2131300117);
    localMMSwitchBtn.setCheck(((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().aXO());
    localMMSwitchBtn.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121676);
        ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().fu(paramAnonymousBoolean);
        AppMethodBeat.o(121676);
      }
    });
    this.oGd = ((Button)findViewById(2131299801));
    AJ(com.tencent.mm.plugin.appbrand.dynamic.widget.b.bCu());
    this.oGd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(121678);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add("MHADrawableView");
        paramAnonymousView.add("MTextureView");
        paramAnonymousView.add("MSurfaceView");
        paramAnonymousView.add("MCanvasView");
        paramAnonymousView.add("MDrawableView");
        paramAnonymousView = new c(SettingsPanel.this.getContext(), paramAnonymousView);
        paramAnonymousView.app(((Integer)SettingsPanel.b(SettingsPanel.this).getTag()).intValue());
        paramAnonymousView.QTc = new c.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(121677);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              SettingsPanel.b(SettingsPanel.this).setText((CharSequence)paramAnonymous2Object1);
            }
            SettingsPanel.a(SettingsPanel.this, paramAnonymousView.hci());
            AppMethodBeat.o(121677);
          }
        };
        paramAnonymousView.show();
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121678);
      }
    });
    this.oGe = ((Button)findViewById(2131302920));
    AK(com.tencent.mm.ab.h.ayU());
    this.oGe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(121680);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add("Normal");
        paramAnonymousView.add("Minimal-json");
        paramAnonymousView = new c(SettingsPanel.this.getContext(), paramAnonymousView);
        paramAnonymousView.app(((Integer)SettingsPanel.c(SettingsPanel.this).getTag()).intValue());
        paramAnonymousView.QTc = new c.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(121679);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              SettingsPanel.c(SettingsPanel.this).setText((CharSequence)paramAnonymous2Object1);
            }
            SettingsPanel.b(SettingsPanel.this, paramAnonymousView.hci());
            AppMethodBeat.o(121679);
          }
        };
        paramAnonymousView.show();
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121680);
      }
    });
    findViewById(2131298773).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121681);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (SettingsPanel.d(SettingsPanel.this) != null) {
          SettingsPanel.d(SettingsPanel.this).onClick(paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121681);
      }
    });
    if (((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().aXP())
    {
      findViewById(2131300118).setVisibility(0);
      findViewById(2131299802).setVisibility(0);
      findViewById(2131302921).setVisibility(0);
    }
    AppMethodBeat.o(121685);
  }
  
  public void setOnCloseDebuggerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.oGf = paramOnClickListener;
  }
  
  public void setOnResetDebuggerRunnable(Runnable paramRunnable)
  {
    this.oGg = paramRunnable;
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCInteger, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel
 * JD-Core Version:    0.7.0.1
 */