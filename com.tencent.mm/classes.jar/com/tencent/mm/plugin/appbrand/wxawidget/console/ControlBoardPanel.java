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
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.sdk.platformtools.ab;

public class ControlBoardPanel
  extends FrameLayout
{
  ConsolePanel hqR;
  ControlBoardPanel.a jxG;
  View jxH;
  SettingsPanel jxI;
  View jxJ;
  View jxK;
  View jxL;
  View jxM;
  WindowManager jxN;
  WindowManager.LayoutParams jxO;
  boolean jxP;
  
  public ControlBoardPanel(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(11164);
    init();
    AppMethodBeat.o(11164);
  }
  
  public ControlBoardPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(11165);
    init();
    AppMethodBeat.o(11165);
  }
  
  public ControlBoardPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(11166);
    init();
    AppMethodBeat.o(11166);
  }
  
  private void init()
  {
    AppMethodBeat.i(11167);
    Context localContext = getContext();
    this.jxN = ((WindowManager)localContext.getSystemService("window"));
    LayoutInflater.from(localContext).inflate(2130969273, this, true);
    this.jxH = findViewById(2131823248);
    this.hqR = ((ConsolePanel)findViewById(2131823249));
    this.jxI = ((SettingsPanel)findViewById(2131823250));
    this.jxJ = findViewById(2131823251);
    this.jxK = findViewById(2131823245);
    this.jxL = findViewById(2131823246);
    this.jxM = findViewById(2131823247);
    if (!((e)g.E(e.class)).acl().acr()) {
      this.jxM.setVisibility(8);
    }
    this.jxK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(11158);
        if (ControlBoardPanel.this.hqR.getVisibility() == 0)
        {
          ControlBoardPanel.this.jxH.setVisibility(8);
          ControlBoardPanel.this.hqR.setVisibility(8);
          ControlBoardPanel.this.jxK.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
          AppMethodBeat.o(11158);
          return;
        }
        ControlBoardPanel.this.jxH.setVisibility(0);
        ControlBoardPanel.this.hqR.setVisibility(0);
        ControlBoardPanel.this.jxI.setVisibility(8);
        ControlBoardPanel.this.jxJ.setVisibility(8);
        ControlBoardPanel.this.jxK.setSelected(true);
        ControlBoardPanel.this.jxL.setSelected(false);
        ControlBoardPanel.this.jxM.setSelected(false);
        ControlBoardPanel.b(ControlBoardPanel.this);
        AppMethodBeat.o(11158);
      }
    });
    this.jxL.setOnClickListener(new ControlBoardPanel.2(this));
    this.jxM.setOnClickListener(new ControlBoardPanel.3(this));
    setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(11161);
        ab.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        if (paramAnonymousInt == 4)
        {
          ControlBoardPanel.this.jxH.setVisibility(8);
          ControlBoardPanel.this.jxJ.setVisibility(8);
          ControlBoardPanel.this.jxJ.setVisibility(8);
          ControlBoardPanel.this.jxM.setSelected(false);
          ControlBoardPanel.this.jxK.setSelected(false);
          ControlBoardPanel.this.jxL.setSelected(false);
          ControlBoardPanel.a(ControlBoardPanel.this);
        }
        AppMethodBeat.o(11161);
        return false;
      }
    });
    this.jxI.setOnCloseDebuggerClickListener(new ControlBoardPanel.5(this));
    this.jxI.setOnResetDebuggerRunnable(new ControlBoardPanel.6(this));
    AppMethodBeat.o(11167);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(11168);
    ab.i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(11168);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(11169);
    d.b(this.hqR);
    d.a(this.hqR);
    AppMethodBeat.o(11169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel
 * JD-Core Version:    0.7.0.1
 */