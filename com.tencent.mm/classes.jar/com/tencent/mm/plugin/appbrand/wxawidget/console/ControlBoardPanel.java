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
import com.tencent.mm.sdk.platformtools.ad;

public class ControlBoardPanel
  extends FrameLayout
{
  ConsolePanel kix;
  View nqA;
  View nqB;
  View nqC;
  WindowManager nqD;
  WindowManager.LayoutParams nqE;
  boolean nqF;
  a nqw;
  View nqx;
  SettingsPanel nqy;
  View nqz;
  
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
    this.nqD = ((WindowManager)localContext.getSystemService("window"));
    LayoutInflater.from(localContext).inflate(2131493661, this, true);
    this.nqx = findViewById(2131298780);
    this.kix = ((ConsolePanel)findViewById(2131298581));
    this.nqy = ((SettingsPanel)findViewById(2131304667));
    this.nqz = findViewById(2131303205);
    this.nqA = findViewById(2131298579);
    this.nqB = findViewById(2131304640);
    this.nqC = findViewById(2131303204);
    if (!((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDF().aDM()) {
      this.nqC.setVisibility(8);
    }
    this.nqA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121643);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ControlBoardPanel.this.kix.getVisibility() == 0)
        {
          ControlBoardPanel.this.nqx.setVisibility(8);
          ControlBoardPanel.this.kix.setVisibility(8);
          ControlBoardPanel.this.nqA.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121643);
          return;
          ControlBoardPanel.this.nqx.setVisibility(0);
          ControlBoardPanel.this.kix.setVisibility(0);
          ControlBoardPanel.this.nqy.setVisibility(8);
          ControlBoardPanel.this.nqz.setVisibility(8);
          ControlBoardPanel.this.nqA.setSelected(true);
          ControlBoardPanel.this.nqB.setSelected(false);
          ControlBoardPanel.this.nqC.setSelected(false);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    this.nqB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121644);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ControlBoardPanel.this.nqy.getVisibility() == 0)
        {
          ControlBoardPanel.this.nqx.setVisibility(8);
          ControlBoardPanel.this.nqy.setVisibility(8);
          ControlBoardPanel.this.nqB.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121644);
          return;
          ControlBoardPanel.this.nqx.setVisibility(0);
          ControlBoardPanel.this.kix.setVisibility(8);
          ControlBoardPanel.this.nqy.setVisibility(0);
          ControlBoardPanel.this.nqz.setVisibility(8);
          ControlBoardPanel.this.nqA.setSelected(false);
          ControlBoardPanel.this.nqB.setSelected(true);
          ControlBoardPanel.this.nqC.setSelected(false);
          ControlBoardPanel.b(ControlBoardPanel.this);
        }
      }
    });
    this.nqC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121645);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ControlBoardPanel.this.nqz.getVisibility() == 0)
        {
          ControlBoardPanel.this.nqx.setVisibility(8);
          ControlBoardPanel.this.nqz.setVisibility(8);
          ControlBoardPanel.this.nqC.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121645);
          return;
          ControlBoardPanel.this.nqx.setVisibility(0);
          ControlBoardPanel.this.kix.setVisibility(8);
          ControlBoardPanel.this.nqy.setVisibility(8);
          ControlBoardPanel.this.nqz.setVisibility(0);
          ControlBoardPanel.this.nqA.setSelected(false);
          ControlBoardPanel.this.nqB.setSelected(false);
          ControlBoardPanel.this.nqC.setSelected(true);
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
        localb.mr(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
        ad.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        if (paramAnonymousInt == 4)
        {
          ControlBoardPanel.this.nqx.setVisibility(8);
          ControlBoardPanel.this.nqz.setVisibility(8);
          ControlBoardPanel.this.nqz.setVisibility(8);
          ControlBoardPanel.this.nqC.setSelected(false);
          ControlBoardPanel.this.nqA.setSelected(false);
          ControlBoardPanel.this.nqB.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        a.a(false, this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(121646);
        return false;
      }
    });
    this.nqy.setOnCloseDebuggerClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121647);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = ControlBoardPanel.this;
        if (paramAnonymousView.nqF)
        {
          paramAnonymousView.nqF = false;
          paramAnonymousView.nqD.removeViewImmediate(paramAnonymousView);
          d.b(paramAnonymousView.kix);
          if (paramAnonymousView.nqw != null) {
            paramAnonymousView.nqw.a(paramAnonymousView, false);
          }
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121647);
      }
    });
    this.nqy.setOnResetDebuggerRunnable(new Runnable()
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
    ad.i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(121653);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(121654);
    d.b(this.kix);
    d.a(this.kix);
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