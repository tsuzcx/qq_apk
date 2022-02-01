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
import com.tencent.mm.sdk.platformtools.Log;

public class ControlBoardPanel
  extends FrameLayout
{
  ConsolePanel lpy;
  a oFR;
  View oFS;
  SettingsPanel oFT;
  View oFU;
  View oFV;
  View oFW;
  View oFX;
  WindowManager oFY;
  WindowManager.LayoutParams oFZ;
  boolean oGa;
  
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
    this.oFY = ((WindowManager)localContext.getSystemService("window"));
    LayoutInflater.from(localContext).inflate(2131493791, this, true);
    this.oFS = findViewById(2131299226);
    this.lpy = ((ConsolePanel)findViewById(2131299018));
    this.oFT = ((SettingsPanel)findViewById(2131307719));
    this.oFU = findViewById(2131305871);
    this.oFV = findViewById(2131299016);
    this.oFW = findViewById(2131307693);
    this.oFX = findViewById(2131305870);
    if (!((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().aXP()) {
      this.oFX.setVisibility(8);
    }
    this.oFV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121643);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ControlBoardPanel.this.lpy.getVisibility() == 0)
        {
          ControlBoardPanel.this.oFS.setVisibility(8);
          ControlBoardPanel.this.lpy.setVisibility(8);
          ControlBoardPanel.this.oFV.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121643);
          return;
          ControlBoardPanel.this.oFS.setVisibility(0);
          ControlBoardPanel.this.lpy.setVisibility(0);
          ControlBoardPanel.this.oFT.setVisibility(8);
          ControlBoardPanel.this.oFU.setVisibility(8);
          ControlBoardPanel.this.oFV.setSelected(true);
          ControlBoardPanel.this.oFW.setSelected(false);
          ControlBoardPanel.this.oFX.setSelected(false);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    this.oFW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121644);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ControlBoardPanel.this.oFT.getVisibility() == 0)
        {
          ControlBoardPanel.this.oFS.setVisibility(8);
          ControlBoardPanel.this.oFT.setVisibility(8);
          ControlBoardPanel.this.oFW.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121644);
          return;
          ControlBoardPanel.this.oFS.setVisibility(0);
          ControlBoardPanel.this.lpy.setVisibility(8);
          ControlBoardPanel.this.oFT.setVisibility(0);
          ControlBoardPanel.this.oFU.setVisibility(8);
          ControlBoardPanel.this.oFV.setSelected(false);
          ControlBoardPanel.this.oFW.setSelected(true);
          ControlBoardPanel.this.oFX.setSelected(false);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    this.oFX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121645);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ControlBoardPanel.this.oFU.getVisibility() == 0)
        {
          ControlBoardPanel.this.oFS.setVisibility(8);
          ControlBoardPanel.this.oFU.setVisibility(8);
          ControlBoardPanel.this.oFX.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121645);
          return;
          ControlBoardPanel.this.oFS.setVisibility(0);
          ControlBoardPanel.this.lpy.setVisibility(8);
          ControlBoardPanel.this.oFT.setVisibility(8);
          ControlBoardPanel.this.oFU.setVisibility(0);
          ControlBoardPanel.this.oFV.setSelected(false);
          ControlBoardPanel.this.oFW.setSelected(false);
          ControlBoardPanel.this.oFX.setSelected(true);
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
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.bm(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
        Log.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        if (paramAnonymousInt == 4)
        {
          ControlBoardPanel.this.oFS.setVisibility(8);
          ControlBoardPanel.this.oFU.setVisibility(8);
          ControlBoardPanel.this.oFU.setVisibility(8);
          ControlBoardPanel.this.oFX.setSelected(false);
          ControlBoardPanel.this.oFV.setSelected(false);
          ControlBoardPanel.this.oFW.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        a.a(false, this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(121646);
        return false;
      }
    });
    this.oFT.setOnCloseDebuggerClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121647);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = ControlBoardPanel.this;
        if (paramAnonymousView.oGa)
        {
          paramAnonymousView.oGa = false;
          paramAnonymousView.oFY.removeViewImmediate(paramAnonymousView);
          d.b(paramAnonymousView.lpy);
          if (paramAnonymousView.oFR != null) {
            paramAnonymousView.oFR.a(paramAnonymousView, false);
          }
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121647);
      }
    });
    this.oFT.setOnResetDebuggerRunnable(new Runnable()
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
    d.b(this.lpy);
    d.a(this.lpy);
    AppMethodBeat.o(121654);
  }
  
  public static abstract interface a
  {
    public abstract void a(ControlBoardPanel paramControlBoardPanel, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel
 * JD-Core Version:    0.7.0.1
 */