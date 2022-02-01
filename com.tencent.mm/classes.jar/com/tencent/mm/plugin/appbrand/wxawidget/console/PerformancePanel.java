package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.collector.f;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class PerformancePanel
  extends FrameLayout
{
  MMSwitchBtn kiE;
  MMSwitchBtn kiF;
  MMSwitchBtn kiG;
  
  public PerformancePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121670);
    init();
    AppMethodBeat.o(121670);
  }
  
  public PerformancePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121671);
    init();
    AppMethodBeat.o(121671);
  }
  
  private void init()
  {
    AppMethodBeat.i(121672);
    LayoutInflater.from(getContext()).inflate(2131495080, this, true);
    Object localObject = (TextView)findViewById(2131302536);
    final View localView = findViewById(2131303925);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121659);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = c.MW("jsapi_draw_canvas").toString();
        paramAnonymousView = new StringBuilder();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          int i = c.cB("jsapi_draw_canvas", "__invoke_jsapi_data_size");
          paramAnonymousView.append("data size :").append(i).append("\n").append((String)localObject);
        }
        localObject = (IPCString)h.a("com.tencent.mm:support", new IPCString("widget_launch"), PerformancePanel.e.class);
        if (localObject != null) {
          paramAnonymousView.append("\n\n").append(localObject);
        }
        if (f.bdD()) {
          paramAnonymousView.append("\n\n").append(f.bdE());
        }
        this.kiI.setText(paramAnonymousView.toString());
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121659);
      }
    });
    findViewById(2131298348).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(121660);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        h.a("com.tencent.mm:support", null, PerformancePanel.a.class, null);
        c.clear();
        f.reset();
        this.kiI.setText(c.MW("jsapi_draw_canvas").toString());
        a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(121660);
      }
    });
    localObject = (MMSwitchBtn)findViewById(2131303021);
    boolean bool = c.bdC();
    ((MMSwitchBtn)localObject).setCheck(bool);
    ((MMSwitchBtn)localObject).setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121661);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), PerformancePanel.d.class, null);
        c.fX(paramAnonymousBoolean);
        localView.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.kiE.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.kiF.setEnabled(paramAnonymousBoolean);
        PerformancePanel.this.kiG.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(121661);
      }
    });
    localView.setEnabled(bool);
    this.kiE = ((MMSwitchBtn)findViewById(2131298446));
    this.kiE.setEnabled(bool);
    this.kiE.setCheck(c.MZ("jsapi_draw_canvas"));
    this.kiE.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121662);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), PerformancePanel.b.class, null);
        if (paramAnonymousBoolean)
        {
          c.MX("jsapi_draw_canvas");
          AppMethodBeat.o(121662);
          return;
        }
        c.MY("jsapi_draw_canvas");
        AppMethodBeat.o(121662);
      }
    });
    this.kiF = ((MMSwitchBtn)findViewById(2131298492));
    this.kiF.setEnabled(bool);
    this.kiF.setCheck(c.MZ("widget_launch"));
    this.kiF.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121663);
        h.a("com.tencent.mm:support", new IPCBoolean(paramAnonymousBoolean), PerformancePanel.c.class, null);
        if (paramAnonymousBoolean)
        {
          c.MX("widget_launch");
          AppMethodBeat.o(121663);
          return;
        }
        c.MY("widget_launch");
        AppMethodBeat.o(121663);
      }
    });
    this.kiG = ((MMSwitchBtn)findViewById(2131298491));
    this.kiG.setEnabled(bool);
    this.kiG.setCheck(f.bdD());
    this.kiG.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121664);
        f.fY(paramAnonymousBoolean);
        AppMethodBeat.o(121664);
      }
    });
    AppMethodBeat.o(121672);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {}
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid>
  {}
  
  static class c
    implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid>
  {}
  
  static class d
    implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid>
  {}
  
  static class e
    implements k<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel
 * JD-Core Version:    0.7.0.1
 */