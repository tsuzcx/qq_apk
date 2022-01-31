package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class SettingsPanel
  extends FrameLayout
{
  private Button jxS;
  private Button jxT;
  private View.OnClickListener jxU;
  private Runnable jxV;
  
  public SettingsPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(11196);
    init();
    AppMethodBeat.o(11196);
  }
  
  public SettingsPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(11197);
    init();
    AppMethodBeat.o(11197);
  }
  
  private void init()
  {
    AppMethodBeat.i(11198);
    LayoutInflater.from(getContext()).inflate(2130970698, this, true);
    findViewById(2131827628).setOnClickListener(new SettingsPanel.1(this));
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)findViewById(2131827631);
    localMMSwitchBtn.setCheck(((e)g.E(e.class)).acl().acq());
    localMMSwitchBtn.setSwitchListener(new SettingsPanel.2(this));
    this.jxS = ((Button)findViewById(2131827635));
    qY(b.aAk());
    this.jxS.setOnClickListener(new SettingsPanel.3(this));
    this.jxT = ((Button)findViewById(2131827633));
    qZ(h.QB());
    this.jxT.setOnClickListener(new SettingsPanel.4(this));
    findViewById(2131827636).setOnClickListener(new SettingsPanel.5(this));
    if (((e)g.E(e.class)).acl().acr())
    {
      findViewById(2131827630).setVisibility(0);
      findViewById(2131827634).setVisibility(0);
      findViewById(2131827632).setVisibility(0);
    }
    AppMethodBeat.o(11198);
  }
  
  private void qY(int paramInt)
  {
    AppMethodBeat.i(11199);
    this.jxS.setTag(Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      this.jxS.setText("MHADrawableView");
      b.nL(0);
      AppMethodBeat.o(11199);
      return;
    case 1: 
      this.jxS.setText("MTextureView");
      b.nL(1);
      AppMethodBeat.o(11199);
      return;
    case 2: 
      this.jxS.setText("MSurfaceView");
      b.nL(2);
      AppMethodBeat.o(11199);
      return;
    case 3: 
      this.jxS.setText("MCanvasView");
      b.nL(3);
      AppMethodBeat.o(11199);
      return;
    }
    this.jxS.setText("MDrawableView");
    b.nL(4);
    AppMethodBeat.o(11199);
  }
  
  private void qZ(int paramInt)
  {
    AppMethodBeat.i(11200);
    this.jxT.setTag(Integer.valueOf(paramInt));
    String str;
    switch (paramInt)
    {
    default: 
      str = "Normal";
    }
    for (paramInt = 0;; paramInt = 1)
    {
      this.jxT.setText(str);
      h.jJ(paramInt);
      f.a("com.tencent.mm:support", new IPCInteger(paramInt), SettingsPanel.a.class, null);
      AppMethodBeat.o(11200);
      return;
      str = "Minimal-json";
    }
  }
  
  public void setOnCloseDebuggerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jxU = paramOnClickListener;
  }
  
  public void setOnResetDebuggerRunnable(Runnable paramRunnable)
  {
    this.jxV = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel
 * JD-Core Version:    0.7.0.1
 */