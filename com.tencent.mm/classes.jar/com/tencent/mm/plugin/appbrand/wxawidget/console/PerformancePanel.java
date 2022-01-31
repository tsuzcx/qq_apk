package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class PerformancePanel
  extends FrameLayout
{
  MMSwitchBtn hqY;
  MMSwitchBtn hqZ;
  MMSwitchBtn hra;
  
  public PerformancePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(11184);
    init();
    AppMethodBeat.o(11184);
  }
  
  public PerformancePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(11185);
    init();
    AppMethodBeat.o(11185);
  }
  
  private void init()
  {
    AppMethodBeat.i(11186);
    LayoutInflater.from(getContext()).inflate(2130970416, this, true);
    Object localObject = (TextView)findViewById(2131826716);
    View localView = findViewById(2131826715);
    localView.setOnClickListener(new PerformancePanel.1(this, (TextView)localObject));
    findViewById(2131820991).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(11174);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:support", null, PerformancePanel.a.class, null);
        c.clear();
        com.tencent.mm.plugin.appbrand.collector.f.reset();
        this.hrc.setText(c.zL("jsapi_draw_canvas").toString());
        AppMethodBeat.o(11174);
      }
    });
    localObject = (MMSwitchBtn)findViewById(2131826711);
    boolean bool = c.ayk();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new PerformancePanel.3(this, localView));
    localView.setEnabled(bool);
    this.hqY = ((MMSwitchBtn)findViewById(2131826712));
    this.hqY.setEnabled(bool);
    this.hqY.setCheck(c.zO("jsapi_draw_canvas"));
    this.hqY.setSwitchListener(new PerformancePanel.4(this));
    this.hqZ = ((MMSwitchBtn)findViewById(2131826713));
    this.hqZ.setEnabled(bool);
    this.hqZ.setCheck(c.zO("widget_launch"));
    this.hqZ.setSwitchListener(new PerformancePanel.5(this));
    this.hra = ((MMSwitchBtn)findViewById(2131826714));
    this.hra.setEnabled(bool);
    this.hra.setCheck(com.tencent.mm.plugin.appbrand.collector.f.ayl());
    this.hra.setSwitchListener(new PerformancePanel.6(this));
    AppMethodBeat.o(11186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel
 * JD-Core Version:    0.7.0.1
 */