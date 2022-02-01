package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.appbrand.wxawidget.b.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class ControlBoardPanel
  extends FrameLayout
{
  ConsolePanel oki;
  a rHG;
  View rHH;
  SettingsPanel rHI;
  View rHJ;
  View rHK;
  View rHL;
  View rHM;
  WindowManager rHN;
  WindowManager.LayoutParams rHO;
  boolean rHP;
  
  public ControlBoardPanel(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(121649);
    init();
    AppMethodBeat.o(121649);
  }
  
  public ControlBoardPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121650);
    init();
    AppMethodBeat.o(121650);
  }
  
  public ControlBoardPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121651);
    init();
    AppMethodBeat.o(121651);
  }
  
  private void init()
  {
    AppMethodBeat.i(121652);
    Context localContext = getContext();
    this.rHN = ((WindowManager)localContext.getSystemService("window"));
    LayoutInflater.from(localContext).inflate(b.b.control_board_panel, this, true);
    this.rHH = findViewById(b.a.content_vg);
    this.oki = ((ConsolePanel)findViewById(b.a.console_panel));
    this.rHI = ((SettingsPanel)findViewById(b.a.settings_panel));
    this.rHJ = findViewById(b.a.performance_panel);
    this.rHK = findViewById(b.a.console_btn);
    this.rHL = findViewById(b.a.settings_btn);
    this.rHM = findViewById(b.a.performance_btn);
    if (!((g)h.ae(g.class)).bgR().bgY()) {
      this.rHM.setVisibility(8);
    }
    this.rHK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121643);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ControlBoardPanel.this.oki.getVisibility() == 0)
        {
          ControlBoardPanel.this.rHH.setVisibility(8);
          ControlBoardPanel.this.oki.setVisibility(8);
          ControlBoardPanel.this.rHK.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121643);
          return;
          ControlBoardPanel.this.rHH.setVisibility(0);
          ControlBoardPanel.this.oki.setVisibility(0);
          ControlBoardPanel.this.rHI.setVisibility(8);
          ControlBoardPanel.this.rHJ.setVisibility(8);
          ControlBoardPanel.this.rHK.setSelected(true);
          ControlBoardPanel.this.rHL.setSelected(false);
          ControlBoardPanel.this.rHM.setSelected(false);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    this.rHL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121644);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ControlBoardPanel.this.rHI.getVisibility() == 0)
        {
          ControlBoardPanel.this.rHH.setVisibility(8);
          ControlBoardPanel.this.rHI.setVisibility(8);
          ControlBoardPanel.this.rHL.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121644);
          return;
          ControlBoardPanel.this.rHH.setVisibility(0);
          ControlBoardPanel.this.oki.setVisibility(8);
          ControlBoardPanel.this.rHI.setVisibility(0);
          ControlBoardPanel.this.rHJ.setVisibility(8);
          ControlBoardPanel.this.rHK.setSelected(false);
          ControlBoardPanel.this.rHL.setSelected(true);
          ControlBoardPanel.this.rHM.setSelected(false);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    this.rHM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121645);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ControlBoardPanel.this.rHJ.getVisibility() == 0)
        {
          ControlBoardPanel.this.rHH.setVisibility(8);
          ControlBoardPanel.this.rHJ.setVisibility(8);
          ControlBoardPanel.this.rHM.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121645);
          return;
          ControlBoardPanel.this.rHH.setVisibility(0);
          ControlBoardPanel.this.oki.setVisibility(8);
          ControlBoardPanel.this.rHI.setVisibility(8);
          ControlBoardPanel.this.rHJ.setVisibility(0);
          ControlBoardPanel.this.rHK.setSelected(false);
          ControlBoardPanel.this.rHL.setSelected(false);
          ControlBoardPanel.this.rHM.setSelected(true);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(121646);
        b localb = new b();
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.bn(paramAnonymousKeyEvent);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
        Log.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        if (paramAnonymousInt == 4)
        {
          ControlBoardPanel.this.rHH.setVisibility(8);
          ControlBoardPanel.this.rHJ.setVisibility(8);
          ControlBoardPanel.this.rHJ.setVisibility(8);
          ControlBoardPanel.this.rHM.setSelected(false);
          ControlBoardPanel.this.rHK.setSelected(false);
          ControlBoardPanel.this.rHL.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        a.a(false, this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(121646);
        return false;
      }
    });
    this.rHI.setOnCloseDebuggerClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121647);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = ControlBoardPanel.this;
        if (paramAnonymousView.rHP)
        {
          paramAnonymousView.rHP = false;
          paramAnonymousView.rHN.removeViewImmediate(paramAnonymousView);
          d.b(paramAnonymousView.oki);
          if (paramAnonymousView.rHG != null) {
            paramAnonymousView.rHG.a(paramAnonymousView, false);
          }
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121647);
      }
    });
    this.rHI.setOnResetDebuggerRunnable(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121648);
        ControlBoardPanel.this.reset();
        AppMethodBeat.o(121648);
      }
    });
    AppMethodBeat.o(121652);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(121653);
    Log.i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(121653);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(121654);
    d.b(this.oki);
    d.a(this.oki);
    AppMethodBeat.o(121654);
  }
  
  public static abstract interface a
  {
    public abstract void a(ControlBoardPanel paramControlBoardPanel, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel
 * JD-Core Version:    0.7.0.1
 */