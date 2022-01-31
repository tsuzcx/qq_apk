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
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.sdk.platformtools.y;

public class ControlBoardPanel
  extends FrameLayout
{
  ConsolePanel fXr;
  WindowManager hEA;
  WindowManager.LayoutParams hEB;
  boolean hEC;
  ControlBoardPanel.a hEt;
  View hEu;
  SettingsPanel hEv;
  View hEw;
  View hEx;
  View hEy;
  View hEz;
  
  public ControlBoardPanel(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ControlBoardPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ControlBoardPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    Context localContext = getContext();
    this.hEA = ((WindowManager)localContext.getSystemService("window"));
    LayoutInflater.from(localContext).inflate(b.c.control_board_panel, this, true);
    this.hEu = findViewById(b.b.content_vg);
    this.fXr = ((ConsolePanel)findViewById(b.b.console_panel));
    this.hEv = ((SettingsPanel)findViewById(b.b.settings_panel));
    this.hEw = findViewById(b.b.performance_panel);
    this.hEx = findViewById(b.b.console_btn);
    this.hEy = findViewById(b.b.settings_btn);
    this.hEz = findViewById(b.b.performance_btn);
    if (!((e)g.r(e.class)).Jn().Jt()) {
      this.hEz.setVisibility(8);
    }
    this.hEx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (ControlBoardPanel.this.fXr.getVisibility() == 0)
        {
          ControlBoardPanel.this.hEu.setVisibility(8);
          ControlBoardPanel.this.fXr.setVisibility(8);
          ControlBoardPanel.this.hEx.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
          return;
        }
        ControlBoardPanel.this.hEu.setVisibility(0);
        ControlBoardPanel.this.fXr.setVisibility(0);
        ControlBoardPanel.this.hEv.setVisibility(8);
        ControlBoardPanel.this.hEw.setVisibility(8);
        ControlBoardPanel.this.hEx.setSelected(true);
        ControlBoardPanel.this.hEy.setSelected(false);
        ControlBoardPanel.this.hEz.setSelected(false);
        ControlBoardPanel.b(ControlBoardPanel.this);
      }
    });
    this.hEy.setOnClickListener(new ControlBoardPanel.2(this));
    this.hEz.setOnClickListener(new ControlBoardPanel.3(this));
    setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        y.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        if (paramAnonymousInt == 4)
        {
          ControlBoardPanel.this.hEu.setVisibility(8);
          ControlBoardPanel.this.hEw.setVisibility(8);
          ControlBoardPanel.this.hEw.setVisibility(8);
          ControlBoardPanel.this.hEz.setSelected(false);
          ControlBoardPanel.this.hEx.setSelected(false);
          ControlBoardPanel.this.hEy.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        return false;
      }
    });
    this.hEv.setOnCloseDebuggerClickListener(new ControlBoardPanel.5(this));
    this.hEv.setOnResetDebuggerRunnable(new ControlBoardPanel.6(this));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    y.i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void reset()
  {
    d.b(this.fXr);
    d.a(this.fXr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel
 * JD-Core Version:    0.7.0.1
 */