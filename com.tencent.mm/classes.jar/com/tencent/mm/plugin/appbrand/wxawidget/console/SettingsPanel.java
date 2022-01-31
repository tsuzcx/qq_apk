package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.ab.h;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.appbrand.dynamic.widget.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class SettingsPanel
  extends FrameLayout
{
  private Button hEF;
  private Button hEG;
  private View.OnClickListener hEH;
  private Runnable hEI;
  
  public SettingsPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SettingsPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(b.c.settings_panel, this, true);
    findViewById(b.b.restart_support_process_btn).setOnClickListener(new SettingsPanel.1(this));
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)findViewById(b.b.enable_release_debug_btn);
    localMMSwitchBtn.setCheck(((e)g.r(e.class)).Jn().Js());
    localMMSwitchBtn.setSwitchListener(new SettingsPanel.2(this));
    this.hEF = ((Button)findViewById(b.b.drawable_view_mode_btn));
    nq(c.afG());
    this.hEF.setOnClickListener(new SettingsPanel.3(this));
    this.hEG = ((Button)findViewById(b.b.json_parser_btn));
    nr(h.CJ());
    this.hEG.setOnClickListener(new SettingsPanel.4(this));
    findViewById(b.b.close_debugger_btn).setOnClickListener(new SettingsPanel.5(this));
    if (((e)g.r(e.class)).Jn().Jt())
    {
      findViewById(b.b.enable_release_debug_item).setVisibility(0);
      findViewById(b.b.drawable_view_mode_item).setVisibility(0);
      findViewById(b.b.json_parser_item).setVisibility(0);
    }
  }
  
  private void nq(int paramInt)
  {
    this.hEF.setTag(Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      this.hEF.setText("MHADrawableView");
      c.kO(0);
      return;
    case 1: 
      this.hEF.setText("MTextureView");
      c.kO(1);
      return;
    case 2: 
      this.hEF.setText("MSurfaceView");
      c.kO(2);
      return;
    case 3: 
      this.hEF.setText("MCanvasView");
      c.kO(3);
      return;
    }
    this.hEF.setText("MDrawableView");
    c.kO(4);
  }
  
  private void nr(int paramInt)
  {
    this.hEG.setTag(Integer.valueOf(paramInt));
    String str;
    switch (paramInt)
    {
    default: 
      str = "Normal";
    }
    for (paramInt = 0;; paramInt = 1)
    {
      this.hEG.setText(str);
      h.ht(paramInt);
      f.a("com.tencent.mm:support", new IPCInteger(paramInt), SettingsPanel.a.class, null);
      return;
      str = "Minimal-json";
    }
  }
  
  public void setOnCloseDebuggerClickListener(View.OnClickListener paramOnClickListener)
  {
    this.hEH = paramOnClickListener;
  }
  
  public void setOnResetDebuggerRunnable(Runnable paramRunnable)
  {
    this.hEI = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel
 * JD-Core Version:    0.7.0.1
 */