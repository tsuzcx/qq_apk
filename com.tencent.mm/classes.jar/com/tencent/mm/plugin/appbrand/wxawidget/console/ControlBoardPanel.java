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
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.appbrand.wxawidget.b.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class ControlBoardPanel
  extends FrameLayout
{
  ConsolePanel rnK;
  a uSV;
  View uSW;
  SettingsPanel uSX;
  View uSY;
  View uSZ;
  View uTa;
  View uTb;
  WindowManager uTc;
  WindowManager.LayoutParams uTd;
  boolean uTe;
  
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
    this.uTc = ((WindowManager)localContext.getSystemService("window"));
    LayoutInflater.from(localContext).inflate(b.b.control_board_panel, this, true);
    this.uSW = findViewById(b.a.content_vg);
    this.rnK = ((ConsolePanel)findViewById(b.a.console_panel));
    this.uSX = ((SettingsPanel)findViewById(b.a.settings_panel));
    this.uSY = findViewById(b.a.performance_panel);
    this.uSZ = findViewById(b.a.console_btn);
    this.uTa = findViewById(b.a.settings_btn);
    this.uTb = findViewById(b.a.performance_btn);
    if (!((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().bEP()) {
      this.uTb.setVisibility(8);
    }
    this.uSZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121643);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ControlBoardPanel.this.rnK.getVisibility() == 0)
        {
          ControlBoardPanel.this.uSW.setVisibility(8);
          ControlBoardPanel.this.rnK.setVisibility(8);
          ControlBoardPanel.this.uSZ.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121643);
          return;
          ControlBoardPanel.this.uSW.setVisibility(0);
          ControlBoardPanel.this.rnK.setVisibility(0);
          ControlBoardPanel.this.uSX.setVisibility(8);
          ControlBoardPanel.this.uSY.setVisibility(8);
          ControlBoardPanel.this.uSZ.setSelected(true);
          ControlBoardPanel.this.uTa.setSelected(false);
          ControlBoardPanel.this.uTb.setSelected(false);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    this.uTa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121644);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ControlBoardPanel.this.uSX.getVisibility() == 0)
        {
          ControlBoardPanel.this.uSW.setVisibility(8);
          ControlBoardPanel.this.uSX.setVisibility(8);
          ControlBoardPanel.this.uTa.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121644);
          return;
          ControlBoardPanel.this.uSW.setVisibility(0);
          ControlBoardPanel.this.rnK.setVisibility(8);
          ControlBoardPanel.this.uSX.setVisibility(0);
          ControlBoardPanel.this.uSY.setVisibility(8);
          ControlBoardPanel.this.uSZ.setSelected(false);
          ControlBoardPanel.this.uTa.setSelected(true);
          ControlBoardPanel.this.uTb.setSelected(false);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    this.uTb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121645);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ControlBoardPanel.this.uSY.getVisibility() == 0)
        {
          ControlBoardPanel.this.uSW.setVisibility(8);
          ControlBoardPanel.this.uSY.setVisibility(8);
          ControlBoardPanel.this.uTb.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121645);
          return;
          ControlBoardPanel.this.uSW.setVisibility(0);
          ControlBoardPanel.this.rnK.setVisibility(8);
          ControlBoardPanel.this.uSX.setVisibility(8);
          ControlBoardPanel.this.uSY.setVisibility(0);
          ControlBoardPanel.this.uSZ.setSelected(false);
          ControlBoardPanel.this.uTa.setSelected(false);
          ControlBoardPanel.this.uTb.setSelected(true);
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
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.cH(paramAnonymousKeyEvent);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
        Log.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        if (paramAnonymousInt == 4)
        {
          ControlBoardPanel.this.uSW.setVisibility(8);
          ControlBoardPanel.this.uSY.setVisibility(8);
          ControlBoardPanel.this.uSY.setVisibility(8);
          ControlBoardPanel.this.uTb.setSelected(false);
          ControlBoardPanel.this.uSZ.setSelected(false);
          ControlBoardPanel.this.uTa.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        a.a(false, this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(121646);
        return false;
      }
    });
    this.uSX.setOnCloseDebuggerClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121647);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = ControlBoardPanel.this;
        if (paramAnonymousView.uTe)
        {
          paramAnonymousView.uTe = false;
          paramAnonymousView.uTc.removeViewImmediate(paramAnonymousView);
          d.b(paramAnonymousView.rnK);
          if (paramAnonymousView.uSV != null) {
            paramAnonymousView.uSV.a(paramAnonymousView, false);
          }
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121647);
      }
    });
    this.uSX.setOnResetDebuggerRunnable(new Runnable()
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
    d.b(this.rnK);
    d.a(this.rnK);
    AppMethodBeat.o(121654);
  }
  
  public static abstract interface a
  {
    public abstract void a(ControlBoardPanel paramControlBoardPanel, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel
 * JD-Core Version:    0.7.0.1
 */