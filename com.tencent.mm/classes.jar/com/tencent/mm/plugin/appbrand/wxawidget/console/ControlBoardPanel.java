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
import com.tencent.mm.sdk.platformtools.ae;

public class ControlBoardPanel
  extends FrameLayout
{
  ConsolePanel klN;
  a nvP;
  View nvQ;
  SettingsPanel nvR;
  View nvS;
  View nvT;
  View nvU;
  View nvV;
  WindowManager nvW;
  WindowManager.LayoutParams nvX;
  boolean nvY;
  
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
    this.nvW = ((WindowManager)localContext.getSystemService("window"));
    LayoutInflater.from(localContext).inflate(2131493661, this, true);
    this.nvQ = findViewById(2131298780);
    this.klN = ((ConsolePanel)findViewById(2131298581));
    this.nvR = ((SettingsPanel)findViewById(2131304667));
    this.nvS = findViewById(2131303205);
    this.nvT = findViewById(2131298579);
    this.nvU = findViewById(2131304640);
    this.nvV = findViewById(2131303204);
    if (!((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().aEc()) {
      this.nvV.setVisibility(8);
    }
    this.nvT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121643);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ControlBoardPanel.this.klN.getVisibility() == 0)
        {
          ControlBoardPanel.this.nvQ.setVisibility(8);
          ControlBoardPanel.this.klN.setVisibility(8);
          ControlBoardPanel.this.nvT.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121643);
          return;
          ControlBoardPanel.this.nvQ.setVisibility(0);
          ControlBoardPanel.this.klN.setVisibility(0);
          ControlBoardPanel.this.nvR.setVisibility(8);
          ControlBoardPanel.this.nvS.setVisibility(8);
          ControlBoardPanel.this.nvT.setSelected(true);
          ControlBoardPanel.this.nvU.setSelected(false);
          ControlBoardPanel.this.nvV.setSelected(false);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    this.nvU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121644);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ControlBoardPanel.this.nvR.getVisibility() == 0)
        {
          ControlBoardPanel.this.nvQ.setVisibility(8);
          ControlBoardPanel.this.nvR.setVisibility(8);
          ControlBoardPanel.this.nvU.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121644);
          return;
          ControlBoardPanel.this.nvQ.setVisibility(0);
          ControlBoardPanel.this.klN.setVisibility(8);
          ControlBoardPanel.this.nvR.setVisibility(0);
          ControlBoardPanel.this.nvS.setVisibility(8);
          ControlBoardPanel.this.nvT.setSelected(false);
          ControlBoardPanel.this.nvU.setSelected(true);
          ControlBoardPanel.this.nvV.setSelected(false);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    this.nvV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121645);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ControlBoardPanel.this.nvS.getVisibility() == 0)
        {
          ControlBoardPanel.this.nvQ.setVisibility(8);
          ControlBoardPanel.this.nvS.setVisibility(8);
          ControlBoardPanel.this.nvV.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121645);
          return;
          ControlBoardPanel.this.nvQ.setVisibility(0);
          ControlBoardPanel.this.klN.setVisibility(8);
          ControlBoardPanel.this.nvR.setVisibility(8);
          ControlBoardPanel.this.nvS.setVisibility(0);
          ControlBoardPanel.this.nvT.setSelected(false);
          ControlBoardPanel.this.nvU.setSelected(false);
          ControlBoardPanel.this.nvV.setSelected(true);
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
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
        ae.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        if (paramAnonymousInt == 4)
        {
          ControlBoardPanel.this.nvQ.setVisibility(8);
          ControlBoardPanel.this.nvS.setVisibility(8);
          ControlBoardPanel.this.nvS.setVisibility(8);
          ControlBoardPanel.this.nvV.setSelected(false);
          ControlBoardPanel.this.nvT.setSelected(false);
          ControlBoardPanel.this.nvU.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        a.a(false, this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(121646);
        return false;
      }
    });
    this.nvR.setOnCloseDebuggerClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121647);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = ControlBoardPanel.this;
        if (paramAnonymousView.nvY)
        {
          paramAnonymousView.nvY = false;
          paramAnonymousView.nvW.removeViewImmediate(paramAnonymousView);
          d.b(paramAnonymousView.klN);
          if (paramAnonymousView.nvP != null) {
            paramAnonymousView.nvP.a(paramAnonymousView, false);
          }
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121647);
      }
    });
    this.nvR.setOnResetDebuggerRunnable(new Runnable()
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
    ae.i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(121653);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(121654);
    d.b(this.klN);
    d.a(this.klN);
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