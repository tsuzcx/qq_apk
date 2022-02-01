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
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.sdk.platformtools.ac;

public class ControlBoardPanel
  extends FrameLayout
{
  ConsolePanel jOm;
  a mPX;
  View mPY;
  SettingsPanel mPZ;
  View mQa;
  View mQb;
  View mQc;
  View mQd;
  WindowManager mQe;
  WindowManager.LayoutParams mQf;
  boolean mQg;
  
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
    this.mQe = ((WindowManager)localContext.getSystemService("window"));
    LayoutInflater.from(localContext).inflate(2131493661, this, true);
    this.mPY = findViewById(2131298780);
    this.jOm = ((ConsolePanel)findViewById(2131298581));
    this.mPZ = ((SettingsPanel)findViewById(2131304667));
    this.mQa = findViewById(2131303205);
    this.mQb = findViewById(2131298579);
    this.mQc = findViewById(2131304640);
    this.mQd = findViewById(2131303204);
    if (!((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAC().aAJ()) {
      this.mQd.setVisibility(8);
    }
    this.mQb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121643);
        if (ControlBoardPanel.this.jOm.getVisibility() == 0)
        {
          ControlBoardPanel.this.mPY.setVisibility(8);
          ControlBoardPanel.this.jOm.setVisibility(8);
          ControlBoardPanel.this.mQb.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
          AppMethodBeat.o(121643);
          return;
        }
        ControlBoardPanel.this.mPY.setVisibility(0);
        ControlBoardPanel.this.jOm.setVisibility(0);
        ControlBoardPanel.this.mPZ.setVisibility(8);
        ControlBoardPanel.this.mQa.setVisibility(8);
        ControlBoardPanel.this.mQb.setSelected(true);
        ControlBoardPanel.this.mQc.setSelected(false);
        ControlBoardPanel.this.mQd.setSelected(false);
        ControlBoardPanel.b(ControlBoardPanel.this);
        AppMethodBeat.o(121643);
      }
    });
    this.mQc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121644);
        if (ControlBoardPanel.this.mPZ.getVisibility() == 0)
        {
          ControlBoardPanel.this.mPY.setVisibility(8);
          ControlBoardPanel.this.mPZ.setVisibility(8);
          ControlBoardPanel.this.mQc.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
          AppMethodBeat.o(121644);
          return;
        }
        ControlBoardPanel.this.mPY.setVisibility(0);
        ControlBoardPanel.this.jOm.setVisibility(8);
        ControlBoardPanel.this.mPZ.setVisibility(0);
        ControlBoardPanel.this.mQa.setVisibility(8);
        ControlBoardPanel.this.mQb.setSelected(false);
        ControlBoardPanel.this.mQc.setSelected(true);
        ControlBoardPanel.this.mQd.setSelected(false);
        ControlBoardPanel.b(ControlBoardPanel.this);
        AppMethodBeat.o(121644);
      }
    });
    this.mQd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121645);
        if (ControlBoardPanel.this.mQa.getVisibility() == 0)
        {
          ControlBoardPanel.this.mPY.setVisibility(8);
          ControlBoardPanel.this.mQa.setVisibility(8);
          ControlBoardPanel.this.mQd.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
          AppMethodBeat.o(121645);
          return;
        }
        ControlBoardPanel.this.mPY.setVisibility(0);
        ControlBoardPanel.this.jOm.setVisibility(8);
        ControlBoardPanel.this.mPZ.setVisibility(8);
        ControlBoardPanel.this.mQa.setVisibility(0);
        ControlBoardPanel.this.mQb.setSelected(false);
        ControlBoardPanel.this.mQc.setSelected(false);
        ControlBoardPanel.this.mQd.setSelected(true);
        ControlBoardPanel.b(ControlBoardPanel.this);
        AppMethodBeat.o(121645);
      }
    });
    setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(121646);
        ac.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        if (paramAnonymousInt == 4)
        {
          ControlBoardPanel.this.mPY.setVisibility(8);
          ControlBoardPanel.this.mQa.setVisibility(8);
          ControlBoardPanel.this.mQa.setVisibility(8);
          ControlBoardPanel.this.mQd.setSelected(false);
          ControlBoardPanel.this.mQb.setSelected(false);
          ControlBoardPanel.this.mQc.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        AppMethodBeat.o(121646);
        return false;
      }
    });
    this.mPZ.setOnCloseDebuggerClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121647);
        paramAnonymousView = ControlBoardPanel.this;
        if (paramAnonymousView.mQg)
        {
          paramAnonymousView.mQg = false;
          paramAnonymousView.mQe.removeViewImmediate(paramAnonymousView);
          d.b(paramAnonymousView.jOm);
          if (paramAnonymousView.mPX != null) {
            paramAnonymousView.mPX.a(paramAnonymousView, false);
          }
        }
        AppMethodBeat.o(121647);
      }
    });
    this.mPZ.setOnResetDebuggerRunnable(new Runnable()
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
    ac.i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(121653);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(121654);
    d.b(this.jOm);
    d.a(this.jOm);
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