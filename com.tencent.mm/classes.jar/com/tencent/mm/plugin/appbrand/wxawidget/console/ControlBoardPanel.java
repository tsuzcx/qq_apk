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
import com.tencent.mm.sdk.platformtools.ad;

public class ControlBoardPanel
  extends FrameLayout
{
  ConsolePanel joa;
  a mnW;
  View mnX;
  SettingsPanel mnY;
  View mnZ;
  View moa;
  View mob;
  View moc;
  WindowManager mod;
  WindowManager.LayoutParams moe;
  boolean mof;
  
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
    this.mod = ((WindowManager)localContext.getSystemService("window"));
    LayoutInflater.from(localContext).inflate(2131493661, this, true);
    this.mnX = findViewById(2131298780);
    this.joa = ((ConsolePanel)findViewById(2131298581));
    this.mnY = ((SettingsPanel)findViewById(2131304667));
    this.mnZ = findViewById(2131303205);
    this.moa = findViewById(2131298579);
    this.mob = findViewById(2131304640);
    this.moc = findViewById(2131303204);
    if (!((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().atS()) {
      this.moc.setVisibility(8);
    }
    this.moa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121643);
        if (ControlBoardPanel.this.joa.getVisibility() == 0)
        {
          ControlBoardPanel.this.mnX.setVisibility(8);
          ControlBoardPanel.this.joa.setVisibility(8);
          ControlBoardPanel.this.moa.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
          AppMethodBeat.o(121643);
          return;
        }
        ControlBoardPanel.this.mnX.setVisibility(0);
        ControlBoardPanel.this.joa.setVisibility(0);
        ControlBoardPanel.this.mnY.setVisibility(8);
        ControlBoardPanel.this.mnZ.setVisibility(8);
        ControlBoardPanel.this.moa.setSelected(true);
        ControlBoardPanel.this.mob.setSelected(false);
        ControlBoardPanel.this.moc.setSelected(false);
        ControlBoardPanel.b(ControlBoardPanel.this);
        AppMethodBeat.o(121643);
      }
    });
    this.mob.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121644);
        if (ControlBoardPanel.this.mnY.getVisibility() == 0)
        {
          ControlBoardPanel.this.mnX.setVisibility(8);
          ControlBoardPanel.this.mnY.setVisibility(8);
          ControlBoardPanel.this.mob.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
          AppMethodBeat.o(121644);
          return;
        }
        ControlBoardPanel.this.mnX.setVisibility(0);
        ControlBoardPanel.this.joa.setVisibility(8);
        ControlBoardPanel.this.mnY.setVisibility(0);
        ControlBoardPanel.this.mnZ.setVisibility(8);
        ControlBoardPanel.this.moa.setSelected(false);
        ControlBoardPanel.this.mob.setSelected(true);
        ControlBoardPanel.this.moc.setSelected(false);
        ControlBoardPanel.b(ControlBoardPanel.this);
        AppMethodBeat.o(121644);
      }
    });
    this.moc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121645);
        if (ControlBoardPanel.this.mnZ.getVisibility() == 0)
        {
          ControlBoardPanel.this.mnX.setVisibility(8);
          ControlBoardPanel.this.mnZ.setVisibility(8);
          ControlBoardPanel.this.moc.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
          AppMethodBeat.o(121645);
          return;
        }
        ControlBoardPanel.this.mnX.setVisibility(0);
        ControlBoardPanel.this.joa.setVisibility(8);
        ControlBoardPanel.this.mnY.setVisibility(8);
        ControlBoardPanel.this.mnZ.setVisibility(0);
        ControlBoardPanel.this.moa.setSelected(false);
        ControlBoardPanel.this.mob.setSelected(false);
        ControlBoardPanel.this.moc.setSelected(true);
        ControlBoardPanel.b(ControlBoardPanel.this);
        AppMethodBeat.o(121645);
      }
    });
    setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(121646);
        ad.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        if (paramAnonymousInt == 4)
        {
          ControlBoardPanel.this.mnX.setVisibility(8);
          ControlBoardPanel.this.mnZ.setVisibility(8);
          ControlBoardPanel.this.mnZ.setVisibility(8);
          ControlBoardPanel.this.moc.setSelected(false);
          ControlBoardPanel.this.moa.setSelected(false);
          ControlBoardPanel.this.mob.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        AppMethodBeat.o(121646);
        return false;
      }
    });
    this.mnY.setOnCloseDebuggerClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121647);
        paramAnonymousView = ControlBoardPanel.this;
        if (paramAnonymousView.mof)
        {
          paramAnonymousView.mof = false;
          paramAnonymousView.mod.removeViewImmediate(paramAnonymousView);
          d.b(paramAnonymousView.joa);
          if (paramAnonymousView.mnW != null) {
            paramAnonymousView.mnW.a(paramAnonymousView, false);
          }
        }
        AppMethodBeat.o(121647);
      }
    });
    this.mnY.setOnResetDebuggerRunnable(new Runnable()
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
    d.b(this.joa);
    d.a(this.joa);
    AppMethodBeat.o(121654);
  }
  
  public static abstract interface a
  {
    public abstract void a(ControlBoardPanel paramControlBoardPanel, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel
 * JD-Core Version:    0.7.0.1
 */